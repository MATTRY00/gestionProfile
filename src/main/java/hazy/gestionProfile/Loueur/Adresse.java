package hazy.gestionProfile.Loueur;

import jakarta.persistence.Embeddable;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
@Embeddable
public class Adresse {

        private String rue;
        private String quartier;
        private String ville; // You could use the Ville enum here or String
        private String codePostal;

    }

