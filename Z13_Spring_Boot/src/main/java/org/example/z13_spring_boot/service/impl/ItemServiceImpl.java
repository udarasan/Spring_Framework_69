package org.example.z13_spring_boot.service.impl;

import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.entity.Item;
import org.example.z13_spring_boot.repo.ItemRepo;
import org.example.z13_spring_boot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Override
    public boolean addItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())){
            return false;
        }
        Item item = new Item();
        item.setCode(itemDTO.getCode());
        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setQuantity(itemDTO.getQuantity());
        itemRepo.save(item);
        return true;

    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())){
            itemRepo.save(
                    new Item(
                            itemDTO.getCode(),
                            itemDTO.getName(),
                            itemDTO.getQuantity(),
                            itemDTO.getPrice()));
            return true;
        }
        return false;
    }

    @Override
    public void deleteItem(int id) {
        itemRepo.deleteById(id);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> all=itemRepo.findAll();
        List<ItemDTO> itemsDTOList=new ArrayList<ItemDTO>();
        for (Item item:all){
            itemsDTOList.add(new ItemDTO(item.getCode(),item.getName(),item.getQuantity(),item.getPrice()));
        }
        return itemsDTOList;
    }
}
