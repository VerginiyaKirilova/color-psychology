package com.colors.controller.controllerPage;

import com.colors.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ColorPageController {

    public final ColorService colorService;

    public ColorPageController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/colors")
    public String showColorsPage(Model model) {
        model.addAttribute("colors", colorService.getAllColors());
        return "colors"; // -> resources/templates/colors.html
    }
}
