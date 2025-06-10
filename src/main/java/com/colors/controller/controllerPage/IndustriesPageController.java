package com.colors.controller.controllerPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/industries")
public class IndustriesPageController {

    @GetMapping
    public String showColorsPage() {
        return "industries"; // -> resources/templates/industries.html
    }
}
