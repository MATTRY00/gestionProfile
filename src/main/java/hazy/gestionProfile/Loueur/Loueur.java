package hazy.gestionProfile.Loueur;
import hazy.gestionProfile.UsersProfiles.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Loueur extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    @OneToMany(mappedBy = "loueur", cascade = CascadeType.ALL)
    private List<Annonce> annonces; // Un Loueur peut avoir plusieurs Annonces


}
