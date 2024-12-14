package hazy.gestionProfile.UsersProfiles;


import hazy.gestionProfile.enumm.DietaryHabit;
import hazy.gestionProfile.enumm.Lifestyle;
import hazy.gestionProfile.enumm.Passion;
import hazy.gestionProfile.enumm.Personality;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/api/enums")
    public class EnumController {

        private final EnumService enumService;

        public EnumController(EnumService enumService) {
            this.enumService = enumService;
        }

        @GetMapping("/personalities")
        public List<Personality> getPersonalityOptions() {
            return enumService.getPersonalityOptions();
        }

        @GetMapping("/lifestyles")
        public List<Lifestyle> getLifestyleOptions() {
            return enumService.getLifestyleOptions();
        }

        @GetMapping("/dietary-habits")
        public List<DietaryHabit> getDietaryOptions() {
            return enumService.getDietaryOptions();
        }

        @GetMapping("/passions")
        public List<Passion> getPassionOptions() {
            return enumService.getPassionOptions();
        }
    }


