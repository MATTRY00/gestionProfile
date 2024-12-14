package hazy.gestionProfile.Demande;

import hazy.gestionProfile.UsersProfiles.Etudiant;
import hazy.gestionProfile.UsersProfiles.User;
import hazy.gestionProfile.enumm.DureeLocation;
import hazy.gestionProfile.enumm.TypeChambre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity

public class Demande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private Boolean possedeDejaLocal;

    private String ville;

    @Enumerated(EnumType.STRING)
    private TypeChambre typeChambre;


    private Integer budgetMensuel;


    @Enumerated(EnumType.STRING)
    private DureeLocation dureeLocation;

    private Boolean disponibleImmediatement;

    private LocalDate dateDisponibilite;


    private Boolean pasDeFetes;


    private Boolean nonFumeur;

    private Boolean pasDeVisiteurs;


    private Boolean pasDAnimaux;

    @OneToOne
    @JoinColumn(name = "etudiant_id") // clé étrangère vers Etudiant
    private Etudiant etudiant;

    private String ecole;
    @Enumerated(EnumType.STRING)
    private User.Sexe sexe;

    private String name;
    private int matchingScore;




  //todo when we create the demande the site redirect us to the profile page
    //todo update demande is the same as create the demande
    //todo il faut afficher ma demande sur mon profile
}

