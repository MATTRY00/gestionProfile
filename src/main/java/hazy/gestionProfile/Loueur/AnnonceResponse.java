package hazy.gestionProfile.Loueur;

import hazy.gestionProfile.enumm.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record AnnonceResponse(

        Integer id,
        Integer loueurId,

        TypeLogement typeLogement,

        TypeBien typeBien,

        Adresse adresse,

        String titre,

        String description,

        int capaciteAccueil,

        int nombrePieces,

        long surface,

        int nombreTotaleChambres, // Champ désactivé si le bien est un studio

        int nbrSalleBain, // Champ désactivé si le bien est un studio

        Salon salon,

        Cuisine cuisine,

        boolean meuble, // Indique si le logement est meublé

        boolean eauEtElectriciteInclus, // Indique si l'eau et l'électricité sont incluses

        List<Equipement> equipements, // Liste des équipements

        List<CuisineEquipement> cuisineEquipements, // Liste des équipements de cuisine

        List<Service> services, // Liste des services offerts au locataire

        BigDecimal prix,

        LocalDateTime dateDisponibilite,

        LocalDateTime dureeLocation, // Date de fin de disponibilité ou durée de location

        List<Photo> photos,
        List<String> commentairesContenus
) {

}
