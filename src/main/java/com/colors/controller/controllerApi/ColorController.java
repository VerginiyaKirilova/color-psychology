package com.colors.controller.controllerApi;

import com.colors.entity.ColorEntity;
import com.colors.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/colors")
public class ColorController {

    private final ColorService colorService;

    @Autowired
    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public String showAllColors(Model model) {
        model.addAttribute("colors", colorService.getAllColors());
        return "colors"; // името на HTML темплейта (colors.html)
    }

    @GetMapping("/search")
    public String searchColor(@RequestParam String name, Model model) {
        Optional<ColorEntity> color = colorService.findByName(name);
        if (color.isPresent()) {
            model.addAttribute("color", color.get());
            return "color-details"; // покажи детайли
        } else {
            model.addAttribute("error", "Цветът не е намерен.");
            return "color-not-found";
        }
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("color", new ColorEntity());
        return "add-color"; // форма за добавяне
    }

    @PostMapping("/add")
    public String addColor(@ModelAttribute ColorEntity color, Model model) {
        colorService.save(color);
        return "redirect:/colors"; // препрати към всички
    }
/*@RestController
@RequestMapping("/api/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }
    @GetMapping
    public List<ColorEntity> getColors(){
        return colorService.getAllColors();
    }

    @GetMapping("/search")
    public ResponseEntity<ColorEntity> searchColor(@RequestParam String name){
        return colorService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ColorEntity addColor(@RequestParam ColorEntity color){
        return colorService.save(color);
    }*/
}
