package com.colors.controller.pageController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchColorController {

    @GetMapping("/color-check")
    public String colorSearchPage(){
        return "color-search";
    }
    @GetMapping("/color-search")
    public String showSearchPage(Model model) {
        model.addAttribute("color", new ColorRequest());
        return "color-search";
    }

    @PostMapping("/color-search")
    public String handleColorSearch(@ModelAttribute("color") ColorRequest color, Model model) {
        String meaning = getMeaningByColor(color.getName());
        model.addAttribute("meaning", meaning);
        return "color-search";
    }

    private String getMeaningByColor(String colorName) {
        return switch (colorName.toLowerCase()) {
            case "red" -> "Energy, Passion";
            case "blue" -> "Calmness, Trust";
            case "yellow" -> "Happiness, Positivity";
            case "green" -> "Nature, Balance";
            default -> "Unknown color";
        };
    }
}
