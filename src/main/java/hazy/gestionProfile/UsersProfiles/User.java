package hazy.gestionProfile.UsersProfiles;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
//  we have a inheritance hierarchy in our class and we want to map all the 3 classes to a relational database
@Inheritance(strategy = InheritanceType.JOINED)
//and the joined it means every entity has it's table , we retrieving data it combines rows from all table to compele data for a specific entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String nom;
        private String prenom;
        private String email;
        private String motDePasse;
        private String numeroTelephone;
        private Boolean profilComplet;

        @Enumerated(EnumType.STRING)
        private Sexe sexe;

        @Enumerated(EnumType.STRING)
        private Role role;



    // Enum types for Sexe and Role
        public enum Sexe {
            HOMME, FEMME
        }

        public enum Role {
            ETUDIANT, LOUEUR
        }



}
