package com.colors.service;

import com.colors.entity.ColorEntity;
import com.colors.model.Color;
import com.colors.repository.ColorRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ColorService {

private final ColorRepository colorRepository;

    public ColorService(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    public List<ColorEntity> getAllColors(){
        return colorRepository.findAll();
    }

    public Optional<ColorEntity> findByName(String name){
        return colorRepository.findByNameIgnoreCase(name);
    }

    public ColorEntity save(ColorEntity color){
        return colorRepository.save(color);
    }
/*    public List<Color> getAllColors() {
        return Arrays.asList(
                new Color("Червен", "Енергия, страст"),
                new Color("Син", "Спокойствие, доверие"),
                new Color("Жълт", "Щастие, позитивност"),
                new Color("Зелен", "Природа, баланс")

        );
    }

    public Optional<Color> findByName(String name) {
        return getAllColors().stream()
                .filter(color -> color.getName().equalsIgnoreCase(name))
                .findFirst();
    }*/
}
