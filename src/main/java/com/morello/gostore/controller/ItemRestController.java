package com.morello.gostore.controller;

import com.morello.gostore.domain.Item;
import com.morello.gostore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemRestController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<List<Item>> getFullItemList(){
        return ResponseEntity.ok(itemService.getFullItemsAsList());
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Item>> getFullListByType(@PathVariable String type){
        return ResponseEntity.ok(itemService.getFullListByType(type));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @PostMapping("/")
    public ResponseEntity insertNewItem(@RequestBody Item item){
        itemService.saveNewItem(item);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/")
    public ResponseEntity updateExistingItem(@RequestBody Item item){
        itemService.updateExistingItem(item);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteExistingItem(@PathVariable Long id){
        itemService.deleteExistingItem(id);
        return ResponseEntity.ok().build();
    }
}
