package com.colors.controller.controllerApi;

import com.colors.colorApp.LogClientService;
import com.colors.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ColorSearchController {
    private final ColorService colorService;
    private final LogClientService logClientService;

    @Autowired
    public ColorSearchController(ColorService colorService, LogClientService logClientService) {
        this.colorService = colorService;
        this.logClientService = logClientService;
    }

    /*@GetMapping("/color-search")
    public String showSearchPage(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isBlank()) {
            colorService.findByName(name).ifPresentOrElse(
                    color -> model.addAttribute("color", color),
                    () -> model.addAttribute("error", "Цветът не е намерен.")
            );
        }
        return "color-search";
    }*/

    @GetMapping("/color-search")
    public String search(@RequestParam(required = false) String name, Model model) {
        if (name != null && !name.isBlank()) {
            // Изпращаме лог към микросървиса
            logClientService.log("anonymous", "Търсене на цвят: " + name, "SEARCH_COLOR");

            colorService.findByName(name).ifPresentOrElse(
                    color -> model.addAttribute("color", color),
                    () -> model.addAttribute("error", "Цветът не е намерен.")
            );
        }
        return "color-search";
    }

/*    @GetMapping("/color-search")
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
    }*/
}