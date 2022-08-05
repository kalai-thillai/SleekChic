package com.example.itemsAPI.controller;


import com.example.itemsAPI.controller.dto.ItemDto;
import com.example.itemsAPI.repository.entity.Item;
import com.example.itemsAPI.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
    @RequestMapping("/item")
    public class ItemController{

         final ItemService itemService;

        public ItemController(@Autowired ItemService itemService )
        {
            this.itemService = itemService;
        }
    @CrossOrigin
    @PostMapping
    public Item save( @RequestBody ItemDto itemDto )

    {
        //Item itemObj = new Item(itemDto);
        //return itemService.save(itemObj);
        return itemService.save(new Item(itemDto) );
    }
    @CrossOrigin
    @GetMapping("/all")
        public Iterable<Item> getItems()
    {
        return itemService.all();
     }
    @CrossOrigin
    @GetMapping("/{id}")
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById(id);

    }
    @CrossOrigin
    @PutMapping( "/{id}" )
    public Item update( @RequestBody ItemDto itemDto, @PathVariable Integer id )
    {
        Item item = itemService.findById( id );
        item.setName( itemDto.getName() );
        item.setDescription( itemDto.getDescription() );
        item.setImageUrl( itemDto.getImageUrl() );
        return itemService.save( item );
    }
    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }



}

