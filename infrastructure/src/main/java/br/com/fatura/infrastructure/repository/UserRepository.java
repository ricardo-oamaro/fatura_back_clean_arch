package br.com.fatura.infrastructure.repository;

import br.com.fatura.core.domain.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends MongoRepository<User, ObjectId> {

        UserDetails findByEmail(String email);
}
