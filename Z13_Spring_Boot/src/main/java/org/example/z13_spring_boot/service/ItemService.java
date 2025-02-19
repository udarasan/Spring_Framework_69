package org.example.z13_spring_boot.service;

import org.example.z13_spring_boot.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    void addItem(ItemDTO itemDTO);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(int id);
    List<ItemDTO> getAllItems();
}
