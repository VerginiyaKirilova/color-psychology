package com.colors.controller.controllerApi;

import com.colors.entity.ColorEntity;
import com.colors.model.Color;
import com.colors.service.ColorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    }
}
