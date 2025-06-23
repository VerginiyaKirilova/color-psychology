package com.colors.data;

import com.colors.entity.ColorEntity;
import com.colors.service.ColorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ColorService colorService;

    public DataSeeder(ColorService colorService) {
        this.colorService = colorService;
    }

    @Override
    public void run(String... args) {
        if (colorService.getAllColors().isEmpty()) {
            colorService.save(new ColorEntity("Червено", "Символизира страст, енергия и опасност."));
            colorService.save(new ColorEntity("Синьо", "Представлява спокойствие, доверие и стабилност."));
            colorService.save(new ColorEntity("Зелено", "Символизира природа, растеж и хармония."));
        }
    }
}
