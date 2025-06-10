package com.colors.controller.controllerPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/best-practices")
public class BestPracticesPageController {

    @GetMapping
    public String showColorsPage() {
        return "best-practices"; // -> resources/templates/best-practices.html
    }
}
