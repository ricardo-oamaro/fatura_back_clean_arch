package br.com.fatura.infrastructure.controller;

import br.com.fatura.core.exception.InternalServerErrorException;
import br.com.fatura.infrastructure.dto.request.CreateItemRequest;
import br.com.fatura.infrastructure.dto.respose.BaseResponse;
import br.com.fatura.infrastructure.mapper.ItemEntityMapper;
import br.com.fatura.infrastructure.repository.ItemRepository;
import br.com.fatura.usecase.CreateItemUseCase;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/api/items")
@Document(collection = "items")
public class ItemController {

    @Autowired
    private CreateItemUseCase createItemUseCase;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemEntityMapper itemEntityMapper;

    @PostMapping("/insert")
    public BaseResponse<String> createItem(@RequestBody @Valid CreateItemRequest request) throws InternalServerErrorException {
        log.info("Inicio da criação do item::ItemController");
        createItemUseCase.create(itemEntityMapper.toItem(request));
        log.info("Item criado com sucesso::ItemController");
        return BaseResponse.<String>builder().success(true).message("Item criado com sucesso").build();
    }
}
