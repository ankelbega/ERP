package com.enercom.enercom.controllers;

import com.enercom.enercom.domain.Item;
import com.enercom.enercom.services.item.ItemService;
import com.enercom.enercom.services.item.SaveItemRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/item")
public class ItemController {
    private ItemService itemService;

    public ItemController(final ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable int id) {
        var item = this.itemService.findById(id);

        return item.isPresent()
                ? ResponseEntity.ok(item.get())
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public List<Item> getAll() {
        return itemService.findAll();
    }

    @PostMapping
    public int save(@RequestBody @Valid SaveItemRequest request) {
        return itemService.save(request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        itemService.delete(id);
    }
}
