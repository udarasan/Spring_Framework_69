package org.example.z13_spring_boot.controller;

import org.example.z13_spring_boot.dto.CustomerDTO;
import org.example.z13_spring_boot.dto.ItemDTO;
import org.example.z13_spring_boot.service.ItemService;
import org.example.z13_spring_boot.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping( value = "save",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO) {
        itemService.addItem(itemDTO);
        return new ResponseUtil(201,"Item Saved",null);
    }

    @PutMapping(value = "update",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        itemService.updateItem(itemDTO);
        return new ResponseUtil(200,"Item Updated",null);
    }
    @DeleteMapping(path = "delete/{id}")
    public ResponseUtil deleteItem(@PathVariable("id") int id) {
        itemService.deleteItem(id);
        return new ResponseUtil(200,"Item Deleted",null);
    }
    @GetMapping("getAll")
    public ResponseUtil getAllItems() {
        return new ResponseUtil(200,"Get All Items",itemService.getAllItems());
    }
}
