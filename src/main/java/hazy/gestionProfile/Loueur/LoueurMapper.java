package hazy.gestionProfile.Loueur;

import org.springframework.stereotype.Service;

@Service
public class LoueurMapper {

    public Annonce toLoueur(AnnonceRequest request, Loueur loueur) {
        return Annonce.builder()
                .id(request.id())
                .loueur(loueur)
                .typeLogement(request.typeLogement())
                .typeBien(request.typeBien())
                .adresse(request.adresse())
                .titre(request.titre())
                .description(request.description())
                .capacite_accueil(request.capaciteAccueil())
                .nombre_pieces(request.nombrePieces())
                .surface(request.surface())
                .nombre_totale_chambres(request.nombreTotaleChambres())
                .nbr_salle_bain(request.nbrSalleBain())
                .salon(request.salon())
                .cuisine(request.cuisine())
                .meuble(request.meuble())
                .eauEtElectriciteInclus(request.eauEtElectriciteInclus())
                .equipements(request.equipements())
                .cuisineEquipements(request.cuisineEquipements())
                .services(request.services())
                .prix(request.prix())
                .date_disponibilite(request.dateDisponibilite())
                .duree_location(request.dureeLocation())
                .photos(request.photos())
                .commentairesContenus(request.commentairesContenus())

                .build();

    }

    public AnnonceResponse toProductResponse(Annonce annonce) {
        return new AnnonceResponse(
                annonce.getId(),
                annonce.getLoueur().getId(),
                annonce.getTypeLogement(),
                annonce.getTypeBien(),
                annonce.getAdresse(),
                annonce.getTitre(),
                annonce.getDescription(),
                annonce.getCapacite_accueil(),
                annonce.getNombre_pieces(),
                annonce.getSurface(),
                annonce.getNombre_totale_chambres(),
                annonce.getNbr_salle_bain(),
                annonce.getSalon(),
                annonce.getCuisine(),
                annonce.isMeuble(),
                annonce.isEauEtElectriciteInclus(),
                annonce.getEquipements(),
                annonce.getCuisineEquipements(),
                annonce.getServices(),
                annonce.getPrix(),
                annonce.getDate_disponibilite(),
                annonce.getDuree_location(),
                annonce.getPhotos(),
                annonce.getCommentairesContenus()
        );
    }

}
