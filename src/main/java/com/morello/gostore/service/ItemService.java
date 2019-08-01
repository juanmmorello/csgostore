package com.morello.gostore.service;

import com.morello.gostore.domain.Item;

import java.util.List;

public interface ItemService {
    // GET
    List<Item> getFullItemsAsList();
    List<Item> getFullListByType(String type);
    Item getItemById(Long id);

    // POST
    void saveNewItem(Item item);

    // PUT
    void updateExistingItem(Item item);

    // DELETE
    void deleteExistingItem(Long id);
}
