package com.example.itemsAPI.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.example.itemsAPI.repository.ItemRepository;
import com.example.itemsAPI.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceMySQL implements ItemService{

    private final ItemRepository itemRepository;
    //private Item item;

    public ItemServiceMySQL(@Autowired ItemRepository itemRepository )
    {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item )
    {
        //TODO implement this method
              return itemRepository.save(item);
             //  return null;
    }

    @Override
    public boolean delete(int itemId )
    {
        //TODO implement this method
        itemRepository.deleteById(itemId);
        return false;
    }

    @Override
    public List<Item> all()
    {
        List<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach( result::add );
        return result;
    }

    @Override
    public Item findById( int itemId )
    {
        //TODO implement this method
        Optional<Item> itemList = itemRepository.findById(itemId);
        if (itemList.isPresent())
        {
            return itemList.get();
        }
        return null;
    }
   /*@Override
     public List<Item> all()
    {
        //TODO implement this method
       return (List<Item>) itemRepository.findAll();
       // return null;
    }
    @Override
    public Item findById( int itemId )
    {
        //TODO implement this method
       Optional<Item>  optionalItem = itemRepository.findById(itemId);
        if(optionalItem.isPresent()) {
            return optionalItem.get();
        }

        return null;
    }

*/
}
