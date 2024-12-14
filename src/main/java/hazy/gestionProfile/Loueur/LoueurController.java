package hazy.gestionProfile.Loueur;
import hazy.gestionProfile.Comments.Comment.Comment;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
@RestController
@RequestMapping("/loueur/Annonce")
public class LoueurController {

    private final LoueurService loueurService;



    @PostMapping("/Creation-Annonce")
    public ResponseEntity<Integer> createAnnonce(@RequestBody @Valid AnnonceRequest request){
        return ResponseEntity.ok(this.loueurService.save(request));
    }
    //todo the find byID is working ghir howa l id dyal request makatb9ach hiya nfss dyal response o -- o kanakhdo dyal response ila bghina n9lbo 3lih
    @GetMapping("/find/{id}")
    public ResponseEntity<AnnonceResponse> findById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.loueurService.findById(id));

    }
    //todo it's working
    @GetMapping
    public ResponseEntity<List<AnnonceResponse>> findAll(){
        return ResponseEntity.ok(this.loueurService.findAll());
    }


    //todo communication entre microservices
    @GetMapping("/{id}/exists")
    public ResponseEntity<Void> verifierAnnonce(@PathVariable int id) {
        if (!loueurService.existeAnnonce(id)) {
            throw new EntityNotFoundException("Annonce introuvable");
        }
        return ResponseEntity.ok().build();
    }
    @GetMapping("/{id}/comments")
    public List<String> getCommentsForAnnonce(@PathVariable Integer id) {
        // Trouver l'annonce par ID
        AnnonceResponse annonce = loueurService.findById(id);

        // Retourner une liste de contenus de commentaires
        return annonce.commentairesContenus();

    }
}
