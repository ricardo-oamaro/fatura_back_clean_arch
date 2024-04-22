package br.com.fatura.infrastructure.repository;

import br.com.fatura.infrastructure.entity.ItemEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<ItemEntity, String> {
}
