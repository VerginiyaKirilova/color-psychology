package com.colors.controller.controllerPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactPageController {

    @GetMapping
    public String showColorsPage() {
        return "contact"; // -> resources/templates/contact.html
    }
}
