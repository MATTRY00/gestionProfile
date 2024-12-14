package hazy.gestionProfile.Demande;


import hazy.gestionProfile.UsersProfiles.Etudiant;
import hazy.gestionProfile.UsersProfiles.EtudiantRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class DemandeService {

    private final DemandeRepo demandeRepo;
    private final DemandeMapper demandeMapper;

    private final EtudiantRepository etudiantRepository;

    //saving part 1
    //todo save is working in postman
//    public Integer save(DemandeRequest request) {
//        var demande = demandeMapper.toDemande(request);
//        return demandeRepo.save(demande).getId();}

    public Integer createDemande(DemandeRequest request) {
        // Récupérer l'étudiant concerné
        Etudiant etudiant = etudiantRepository.findById(request.etudiantId())
                .orElseThrow(() -> new IllegalArgumentException("Étudiant non trouvé avec l'ID : " + request.etudiantId()));

        // Créer et associer une nouvelle demande
        Demande demande = new Demande();
        demande.setPossedeDejaLocal(request.possedeDejaLocal());
        demande.setVille(request.ville());
        demande.setTypeChambre(request.typeChambre());
        demande.setBudgetMensuel(request.budgetMensuel());
        demande.setDureeLocation(request.dureeLocation());
        demande.setDisponibleImmediatement(request.disponibleImmediatement());
        demande.setDateDisponibilite(request.dateDisponibilite());
        demande.setPasDeFetes(request.pasDeFetes());
        demande.setNonFumeur(request.nonFumeur());
        demande.setPasDeVisiteurs(request.pasDeVisiteurs());
        demande.setPasDAnimaux(request.pasDAnimaux());
        demande.setEtudiant(etudiant);
        demande.setEcole(request.ecole());
        demande.setSexe(request.sexe());
        demande.setName(request.name());// Liaison bidirectionnelle
        demande.setMatchingScore(request.matchingScore());

        // Sauvegarder la demande
        demandeRepo.save(demande);

        // Mettre à jour l'étudiant avec l'ID de la demande
        etudiant.setDemande(demande);
        etudiantRepository.save(etudiant); // Mise à jour de l'étudiant

        return demande.getId();
    }

    // get user profile by id
    public DemandeResponse findById(Integer id) {
        return demandeRepo.findById(id)
                .map(demandeMapper::toDemandeResponse)
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found with ID:: " + id));
    }

    public List<DemandeResponse> findAll(){
        return demandeRepo.findAll()
                .stream().map(demandeMapper::toDemandeResponse)//thrown if the entity coudl not  found in the data base
                .collect(Collectors.toList());
    }
}
