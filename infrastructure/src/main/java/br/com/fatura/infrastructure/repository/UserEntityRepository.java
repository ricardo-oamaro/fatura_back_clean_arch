package br.com.fatura.infrastructure.repository;

import br.com.fatura.core.domain.User;
import br.com.fatura.infrastructure.entity.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UserEntityRepository extends MongoRepository<UserEntity, String> {

    User findByEmail(String email);
}
