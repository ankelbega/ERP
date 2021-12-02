package com.enercom.enercom.services.item;

import com.enercom.enercom.domain.Item;
import com.enercom.enercom.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Optional<Item> findById(int id) {
        return itemRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        var item = itemRepository
                .findById(id).orElseThrow(() -> new IllegalArgumentException("Id is invalid"));
        itemRepository.delete(item);
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public int save(SaveItemRequest request) {
        var dbItem = itemRepository.findById(request.getId());
        if (dbItem.isPresent()) {
            dbItem.get().setEntityName(request.getEntityName());
            dbItem.get().setStockUnit(request.getStockUnit());
            dbItem.get().setMaxRetailPrice(request.getMaxRetailPrice());
            dbItem.get().setEntryPrice(request.getEntryPrice());
            dbItem.get().setFinalPrice(request.getFinalPrice());
            dbItem.get().setTvsh(request.getTvsh());
            itemRepository.save(dbItem.get());
            return dbItem.get().getId();
        }

        var newItem = Item.builder()
                .entityName(request.getEntityName())
                .stockUnit(request.getStockUnit())
                .maxRetailPrice(request.getMaxRetailPrice())
                .entryPrice(request.getEntryPrice())
                .finalPrice(request.getFinalPrice())
                .tvsh(request.getTvsh())
                .build();
        itemRepository.save(newItem);
        return newItem.getId();
    }
}
