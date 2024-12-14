package hazy.gestionProfile.Loueur;

import hazy.gestionProfile.enumm.TypePiece;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Photo {
    @Id
    @GeneratedValue
    private int id;
    private String image;

    @Enumerated(EnumType.STRING)
    private TypePiece typePiece;
    private String Legende;

    @ManyToOne
    @JoinColumn(name = "annonce_id")
    private Annonce annonce;

}
