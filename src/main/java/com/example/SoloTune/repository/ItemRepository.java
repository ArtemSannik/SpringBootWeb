package com.example.SoloTune.repository;

import com.example.SoloTune.models.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Long> {
}
