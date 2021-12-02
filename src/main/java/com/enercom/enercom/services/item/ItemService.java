package com.enercom.enercom.services.item;

import com.enercom.enercom.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();

    Optional<Item> findById(int id);

    int save(SaveItemRequest request);

    void delete(int id);
}
