package com.enercom.enercom.repositories;

import com.enercom.enercom.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
