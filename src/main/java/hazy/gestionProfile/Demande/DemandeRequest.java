package hazy.gestionProfile.Demande;

import hazy.gestionProfile.enumm.DureeLocation;
import hazy.gestionProfile.enumm.TypeChambre;

import java.time.LocalDate;

public record DemandeRequest(

        Integer id,
        Boolean possedeDejaLocal,
        String ville,

        TypeChambre typeChambre,

        Integer budgetMensuel,


        DureeLocation dureeLocation,

        Boolean disponibleImmediatement,

        LocalDate dateDisponibilite,

        Boolean pasDeFetes,

        Boolean nonFumeur,

        Boolean pasDeVisiteurs,

        Boolean pasDAnimaux,

        Integer etudiantId,
        String ecole,
        hazy.gestionProfile.UsersProfiles.User.Sexe sexe,
        String name,
        Integer matchingScore



) {
}
