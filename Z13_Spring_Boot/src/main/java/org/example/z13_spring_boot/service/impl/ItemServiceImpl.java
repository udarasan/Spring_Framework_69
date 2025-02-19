package org.example.z13_spring_boot.service.impl;

import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.entity.Item;
import org.example.z13_spring_boot.repo.ItemRepo;
import org.example.z13_spring_boot.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())){
           throw new RuntimeException("Item already exists");
        }
        itemRepo.save(modelMapper.map(itemDTO, Item.class));

    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (itemRepo.existsById(itemDTO.getCode())){
            itemRepo.save(modelMapper.map(itemDTO, Item.class));
        }
        throw new RuntimeException("Item does not exist");
    }

    @Override
    public void deleteItem(int id) {
        itemRepo.deleteById(id);
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return modelMapper.map(itemRepo.findAll(),
                new TypeToken<ItemDTO>(){}.getType());
    }
}
