package hazy.gestionProfile.UsersProfiles;

import hazy.gestionProfile.Demande.Demande;
import hazy.gestionProfile.enumm.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
@Entity
public class Etudiant extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ecole; //information   -- l ville automatiquement integer f l'ecole

    private String numeroTele;//Inforamtions
    private String paysCode;//Inforamtions
    private Date dateNaissance;//Inforamtions
    private String langues;//Inforamtions
    private String description;//Inforamtion  --- parle nous de toi
    private String photoUrl;  //Inforamtion(categorie)

    @Enumerated(EnumType.STRING)//tu veux etre contactee par qui
    private ContactPreference contactPreference; //Inforamtion

    //interets (categorie)
    @ElementCollection(targetClass = Personality.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_personalities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "personality")
    private List<Personality> personalityTraits;
    //interets
    @ElementCollection(targetClass = Lifestyle.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_lifestyles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "lifestyle")
    private List<Lifestyle> lifestylePreferences;
    //interets
    @ElementCollection(targetClass = DietaryHabit.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_dietary_habits", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "dietary_habit")
    private List<DietaryHabit> dietaryHabits;
    //interets
    @ElementCollection(targetClass = Passion.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_passions", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "passion")
    private List<Passion> passions;
    @OneToOne(mappedBy = "etudiant", cascade = CascadeType.ALL,orphanRemoval = true)
    private Demande demande;
    // Getters et Setters
    public void setDemande(Demande demande) {
        this.demande = demande;
        if (demande != null) {
            demande.setEtudiant(this); // Synchronisation inverse
        }}


}

