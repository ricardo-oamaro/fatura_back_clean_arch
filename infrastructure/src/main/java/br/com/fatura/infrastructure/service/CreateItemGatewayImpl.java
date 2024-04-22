package br.com.fatura.infrastructure.service;

import br.com.fatura.application.gateway.CreateItemGateway;
import br.com.fatura.core.domain.item.Item;
import br.com.fatura.infrastructure.mapper.ItemEntityMapper;
import br.com.fatura.infrastructure.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateItemGatewayImpl implements CreateItemGateway {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemEntityMapper itemEntityMapper;


    @Override
    public Boolean create(Item item) {
        log.info("Inserindo informação no banco de dados");
        itemRepository.save(itemEntityMapper.toItemEntity(item));
        return true;
    }


}
