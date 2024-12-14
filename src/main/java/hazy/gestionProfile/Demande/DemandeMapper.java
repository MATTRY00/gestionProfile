package hazy.gestionProfile.Demande;

import hazy.gestionProfile.UsersProfiles.Etudiant;
import hazy.gestionProfile.UsersProfiles.EtudiantRepository;
import hazy.gestionProfile.UsersProfiles.User;
import org.springframework.stereotype.Service;

@Service

public class DemandeMapper {

    private final EtudiantRepository etudiantRepository;

    public DemandeMapper(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }
    public Demande toDemande(DemandeRequest request) {
        Etudiant etudiant = etudiantRepository.findById(request.etudiantId())
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé avec l'ID : " + request.etudiantId()));
        return Demande.builder()
                .id(request.id())
                .possedeDejaLocal(request.possedeDejaLocal())
                .ville(request.ville())
                .typeChambre(request.typeChambre())
                .budgetMensuel(request.budgetMensuel())
                .dureeLocation(request.dureeLocation())
                .disponibleImmediatement(request.disponibleImmediatement())
                .dateDisponibilite(request.dateDisponibilite())
                .pasDeFetes(request.pasDeFetes())
                .nonFumeur(request.nonFumeur())
                .pasDeVisiteurs(request.pasDeVisiteurs())
                .pasDAnimaux(request.pasDAnimaux())
                .etudiant(etudiant)
                .ecole(request.ecole())
                .sexe(request.sexe())
                .name(request.name())
                .matchingScore(request.matchingScore())
                .build();
    }

    public DemandeResponse toDemandeResponse(Demande demande) {
        return new DemandeResponse(
                demande.getId(),
                demande.getPossedeDejaLocal(),
                demande.getVille(),
                demande.getTypeChambre(),
                demande.getBudgetMensuel(),
                demande.getDureeLocation(),
                demande.getDisponibleImmediatement(),
                demande.getDateDisponibilite(),
                demande.getPasDeFetes(),
                demande.getNonFumeur(),
                demande.getPasDeVisiteurs(),
                demande.getPasDAnimaux(),
                demande.getEtudiant().getId(),
                demande.getEcole(),
                demande.getSexe(),
                demande.getName(),
                demande.getMatchingScore()

        );
    }
}