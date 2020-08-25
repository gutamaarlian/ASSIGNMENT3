package com.bca.tama.testing.controller;

import com.bca.tama.testing.Entity.Item;
import com.bca.tama.testing.util.ItemDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ControllerItem {
    private ItemDao itemDao;
    int run = 0;

    public ControllerItem(){
        this.itemDao = new ItemDao();
    }

    @GetMapping("/item")
    public String index(Model model) {
        List<Item> listItem = itemDao.doSelectAllItems();
        model.addAttribute("listItem", listItem);
        return "index";
    }


}
