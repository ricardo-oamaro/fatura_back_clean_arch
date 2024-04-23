package br.com.fatura.infrastructure.service;

import br.com.fatura.application.gateway.GetItemsGateway;
import br.com.fatura.core.domain.Item;
import br.com.fatura.infrastructure.mapper.ItemEntityMapper;
import br.com.fatura.infrastructure.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GetItemsGatewayImpl implements GetItemsGateway {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemEntityMapper itemEntityMapper;

    @Override
    public List<Item> findAll() {
        var itemsEntityList = itemRepository.findAll();
        return itemsEntityList
                .stream()
                .map(entity -> itemEntityMapper.toItem(entity))
                .collect(Collectors.toList());
    }
}
