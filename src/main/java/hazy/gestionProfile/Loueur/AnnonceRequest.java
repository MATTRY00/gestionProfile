package hazy.gestionProfile.Loueur;

import hazy.gestionProfile.enumm.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record AnnonceRequest(

        Integer id,
        @NotNull(message = "ID du loueur est requis")
        Integer loueurId,

        @NotNull(message = "Type de logement est requis")
        TypeLogement typeLogement,

        @NotNull(message = "Type de bien est requis")
        TypeBien typeBien,

        @NotNull(message = "Adresse est requise")
        Adresse adresse,

        @NotNull(message = "Titre est requis")
        String titre,

        @NotNull(message = "Description est requise")
        String description,

        @NotNull(message = "Capacité d'accueil est requise")
        int capaciteAccueil,

        @NotNull(message = "Nombre de pièces est requis")
        int nombrePieces,

        @NotNull(message = "Surface totale du bien est requise")
        long surface,

        int nombreTotaleChambres, // Champ désactivé si le bien est un studio

        int nbrSalleBain, // Champ désactivé si le bien est un studio

        @NotNull(message = "Salon est requis")
        Salon salon,

        @NotNull(message = "Cuisine est requise")
        Cuisine cuisine,

        boolean meuble, // Indique si le logement est meublé

        boolean eauEtElectriciteInclus, // Indique si l'eau et l'électricité sont incluses

        List<Equipement> equipements, // Liste des équipements

        List<CuisineEquipement> cuisineEquipements, // Liste des équipements de cuisine

        List<Service> services, // Liste des services offerts au locataire

        @NotNull(message = "Prix est requis")
        BigDecimal prix,

        @NotNull(message = "Date de disponibilité est requise")
        LocalDateTime dateDisponibilite,

        LocalDateTime dureeLocation, // Date de fin de disponibilité ou durée de location

        List<Photo> photos,
        List<String> commentairesContenus) {
}
