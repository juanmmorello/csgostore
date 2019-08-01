package com.morello.gostore.service.impl;

import com.morello.gostore.domain.Item;
import com.morello.gostore.repository.ItemRepository;
import com.morello.gostore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getFullItemsAsList() {
        return itemRepository.findAll();
    }

    @Override
    public List<Item> getFullListByType(String type) {
        return itemRepository.getAllByType(type);
    }

    @Override
    public Item getItemById(Long id) {
        if (id == null){
            throw new IllegalArgumentException();
        }
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public void saveNewItem(Item item) {
        if (item == null){
            throw new IllegalArgumentException();
        }
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void updateExistingItem(Item item) {
        if (item == null){
            throw new IllegalArgumentException();
        }
        itemRepository.saveAndFlush(item);
    }

    @Override
    public void deleteExistingItem(Long id) {
        if (id == null){
            throw new IllegalArgumentException();
        }
        itemRepository.deleteById(id);
    }
}
