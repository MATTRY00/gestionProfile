package hazy.gestionProfile.Loueur;


import hazy.gestionProfile.Comments.Comment.Comment;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class LoueurService {

    private final AnnonceRepository annonceRepository;
    private final LoueurMapper loueurMapper;
    private final LoueurRepository loueurRepository;
    //saving part 1
    //todo save is working in postman
//    public Integer save(AnnonceRequest request) {
//        var annonce = loueurMapper.toLoueur(request);
//        return loueurRepository.save(annonce).getId();}

    public Integer save(AnnonceRequest request) {
        // Récupérer le loueur à partir de l'ID
        Loueur loueur = loueurRepository.findById(request.loueurId())
                .orElseThrow(() -> new IllegalArgumentException("Loueur non trouvé avec l'ID : " + request.loueurId()));

        // Convertir la requête en entité Annonce et associer le loueur
        Annonce annonce = loueurMapper.toLoueur(request, loueur);

        // Sauvegarder l'annonce
        annonceRepository.save(annonce);

        return annonce.getId();
    }

    // get user profile by id
    public AnnonceResponse findById(Integer id) {
        return annonceRepository.findById(id)
                .map(loueurMapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Etudiant not found with ID:: " + id));
    }

    public List<AnnonceResponse> findAll(){
        return annonceRepository.findAll()
                .stream().map(loueurMapper::toProductResponse)//thrown if the entity coudl not  found in the data base
                .collect(Collectors.toList());
    }


    //todo communication entre microservices
    public boolean existeAnnonce(int id) {
        return annonceRepository.existsById(id);  // Utilisation de la méthode JPA pour vérifier l'existence
    }



    //consuming the comment from kafka
    @Transactional
    @KafkaListener(topics = "comment-topic", groupId = "comment-group")
    public void consommerCommentaire(Comment commentaire) {
        try {
            // Récupérer l'annonce par l'ID de l'annonce
            Annonce annonce = annonceRepository.findById(commentaire.getAnnonceId())
                    .orElseThrow(() -> new RuntimeException("Annonce non trouvée pour l'ID: " + commentaire.getAnnonceId()));

            // Ajouter le contenu du commentaire à la liste des contenus de commentaires
            annonce.addCommentaire(commentaire.getContenu());

            // Sauvegarder l'annonce mise à jour avec le nouveau contenu de commentaire
            annonceRepository.save(annonce);

            System.out.println("Commentaire ajouté avec succès à l'Annonce ID: " + annonce.getId());
        } catch (Exception e) {
            System.err.println("Erreur lors de la consommation du commentaire: " + e.getMessage());
        }
    }



}





