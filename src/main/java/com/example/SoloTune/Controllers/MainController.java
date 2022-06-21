package com.example.SoloTune.Controllers;


import com.example.SoloTune.models.Item;
import com.example.SoloTune.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/homePage")
    public String homePage() {
        return "homePage";
    }

    @GetMapping("/about-us")
    public String aboutUs() {
        return "about-us";
    }

    @GetMapping("/price")
    public String price(Model model) {
        Iterable<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "price";
    }
}
