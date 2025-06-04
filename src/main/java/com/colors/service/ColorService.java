package com.colors.service;

import com.colors.model.Color;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ColorService {
    public List<Color> getAllColors() {
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
    }
}
