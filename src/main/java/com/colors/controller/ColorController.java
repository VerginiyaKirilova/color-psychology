package com.colors.controller;

import com.colors.model.Color;
import com.colors.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }
    @GetMapping
    public List<Color> getColors(){
        return colorService.getAllColors();
    }

    @GetMapping("/search")
    public ResponseEntity<Color> searchColor(@RequestParam String name){
        return colorService.findByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
