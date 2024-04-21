package br.com.fatura.infrastructure.validation;

import br.com.fatura.infrastructure.mapper.UserEntityMapper;
import br.com.fatura.infrastructure.repository.UserRepository;
import br.com.fatura.infrastructure.service.util.Constrants;
import br.com.fatura.infrastructure.service.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserEntityMapper userEntityMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try{
            String path = request.getRequestURI();
            if("/auth/login".equals(path) || "/auth/register".equals(path)){
                filterChain.doFilter(request, response);
                return;
            }
            var token = this.recoverToken(request);
            if (token != null) {
                var email = jwtUtil.validateToken(token);
                if (email != null && !email.isEmpty()) {
                    UserDetails user = userRepository.findByEmail(email);
                    if (user != null) {
                        var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    } else {
                        log.error(Constrants.USER_NOT_FOUND);
                        sendErrorResponse(response, Constrants.USER_NOT_FOUND);
                    }
                } else {
                    log.error(Constrants.LOGIN_ERROR);
                    sendErrorResponse(response, Constrants.LOGIN_ERROR);
                }

            } else {
                log.error(Constrants.TOKEN_NOT_PROVIDED);
                sendErrorResponse(response, Constrants.TOKEN_NOT_PROVIDED);
            }
        } catch (Exception e) {
            log.error(Constrants.LOGIN_ERROR);
            sendErrorResponse(response, Constrants.LOGIN_ERROR);
        }
    }
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

    private void sendErrorResponse(HttpServletResponse response, String message) throws IOException, JSONException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        JSONObject jsonResponse = new JSONObject();
        jsonResponse.put("errors", message);
        response.getWriter().write(jsonResponse.toString());
    }
}
