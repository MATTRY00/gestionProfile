package hazy.gestionProfile.Loueur;

import hazy.gestionProfile.Comments.Comment.Comment;
import hazy.gestionProfile.enumm.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Builder
@Getter
@Setter
@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;

    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;
    @Embedded
    private Adresse adresse;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT")
    private String description;

    private int capacite_accueil;
    private  int nombre_pieces;
    private long surface; //surface totale du bien
    private int nombre_totale_chambres;//desactiver si le cas du studio
    private int nbr_salle_bain;//desactiver si le cas du studio
    @Enumerated(EnumType.STRING)
    private Salon salon;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
    private boolean meuble; // Meublé ou non
    private boolean eauEtElectriciteInclus; // Eau et électricité incluses dans le loyer
    @ElementCollection(targetClass = Equipement.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "annonce_equipements", joinColumns = @JoinColumn(name = "annonce_id"))
    @Column(name = "equipement")
    private List<Equipement> equipements;
    @ElementCollection(targetClass = CuisineEquipement.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "annonce_cuisine_equipements", joinColumns = @JoinColumn(name = "annonce_id"))
    @Column(name = "cuisine_equipement")
    private List<CuisineEquipement> cuisineEquipements;
    @ElementCollection(targetClass = Service.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "annonce_services", joinColumns = @JoinColumn(name = "annonce_id"))
    @Column(name = "service")
    private List<Service> services; // les services offrer au locataire comme menage ...

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(name = "date_creation", nullable = false)
    private LocalDateTime date_disponibilite;

    @Column(name = "date_expiration")
    private LocalDateTime duree_location;


    @OneToMany(mappedBy = "annonce")
    private List<Photo> photos;

    @ElementCollection(targetClass = StatusAnnonce.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "status_annonce", joinColumns = @JoinColumn(name = "annonce_id"))
    @Column(name = "status")
    private List<StatusAnnonce> statusAnnonces;


    @ManyToOne
    @JoinColumn(name = "loueur_id")
    private Loueur loueur;

//
//    @ElementCollection
//    private List<Integer> commentaireIds = new ArrayList<>();
@ElementCollection(fetch = FetchType.LAZY)
@CollectionTable(name = "annonce_commentaires", joinColumns = @JoinColumn(name = "annonce_id"))
@Column(name = "contenu")
private List<String> commentairesContenus = new ArrayList<>();

    public void addCommentaire(String contenu) {
        this.commentairesContenus.add(contenu);
    }


    // Getter for commentairesContenus
    public List<String> getCommentairesContenus() {
        return commentairesContenus;
    }

}
