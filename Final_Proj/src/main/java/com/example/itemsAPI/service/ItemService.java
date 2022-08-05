package com.example.itemsAPI.service;

import java.util.List;
import com.example.itemsAPI.repository.entity.Item;

public interface ItemService {
    public Item save(Item item );

    public boolean delete( int itemId );

    public List<Item> all();

    public Item findById( int itemId );



}
