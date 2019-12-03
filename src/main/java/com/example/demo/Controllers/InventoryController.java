package com.example.demo.Controllers;

import com.example.demo.Models.data.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InventoryController {

    @Autowired
    private ItemDao itemDao;


    @RequestMapping(value = "view", method = RequestMethod.GET)
    public String displayInventory(Model model){
        model.addAttribute("inventory", itemDao.findAll());
        model.addAttribute("title", "Inventory");

        return "Inventory/view";
    }

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String displayEditItems(Model model) {
        model.addAttribute("inventory", itemDao.findAll());
        model.addAttribute("title","Edit Your Inventory");

        return "Inventory/edit";
    }

}
