package com.example.demo.Controllers;

import com.example.demo.Models.Item;
import com.example.demo.Models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class InventoryController {

    @Autowired
    private ItemDao itemDao;


    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String displayInventory(Model model) {
        model.addAttribute("title", "INVEN ORGANIZATION MADE EASY");
        model.addAttribute("titlee", "Inventory");
        model.addAttribute("inventory", itemDao.findAll());


        return "Inventory/view";
    }

    @RequestMapping(value = "/view", method = RequestMethod.POST)
    public String handleDelete(@RequestParam int DeleteId) {


        itemDao.deleteById(DeleteId);


        return "redirect:/view";

    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String displayEdit(Model model) {
        model.addAttribute("title", "INVEN ORGANIZATION MADE EASY");
        model.addAttribute("titlee", "Edit Inventory");
        model.addAttribute("inventory", itemDao.findAll());

        return "Inventory/edit";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String handleEdit(Item item, @RequestParam(value="ItemId") int itemId, Model model){

        Item thing = itemDao.findById(itemId).get();
        thing.setQuantity(item.getQuantity());
        thing.setName(item.getName());
        thing.setQuantity(item.getQuantity());
        itemDao.save(thing);

        return "redirect:/view";

    }
}
