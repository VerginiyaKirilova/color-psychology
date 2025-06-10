package com.colors.controller.controllerPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/combinations")
public class CombinationsPageController {

    @GetMapping
    public String showColorsPage() {
        return "combinations"; // -> resources/templates/combinations.html
    }
}
