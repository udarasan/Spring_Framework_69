package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping( "save")
    public boolean saveItem(@RequestBody ItemDTO itemDTO) {
        System.out.println(itemDTO.getCode());
        boolean res=itemService.addItem(itemDTO);
        return res;
    }

    @PutMapping("update")
    public boolean updateItem(@RequestBody ItemDTO itemDTO) {
        boolean res=itemService.updateItem(itemDTO);
        return res;
    }
    @DeleteMapping(path = "delete/{id}")
    public boolean deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return true;
    }
    @GetMapping("getAll")
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }
}
