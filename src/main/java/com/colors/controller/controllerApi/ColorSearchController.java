package com.colors.controller.controllerApi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ColorSearchController {

    @GetMapping("/color-search")
    public String showSearchPage(Model model) {
        model.addAttribute("color", "");
        model.addAttribute("meaning", "");
        return "color-search";
    }

    @PostMapping("/color-search")
    public String handleSearch(@RequestParam("color") String color, Model model) {
        String meaning = switch (color.toLowerCase()) {
            case "червен" -> "Енергия, страст";
            case "син" -> "Спокойствие, доверие";
            case "жълт" -> "Щастие, позитивност";
            case "зелен" -> "Природа, баланс";
            default -> "Няма информация за този цвят.";
        };
        model.addAttribute("color", color);
        model.addAttribute("meaning", meaning);
        return "color-search";
    }
}