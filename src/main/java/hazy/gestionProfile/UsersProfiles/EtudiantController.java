package hazy.gestionProfile.UsersProfiles;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
private final EtudiantService etudiantService;


@PostMapping("/creation-profile/save")
@CrossOrigin(origins = "http://localhost:3000/create-etudiant")  // Allow only this origin
    public ResponseEntity<Integer> createProfile(@RequestBody @Valid EtudiantRequest request){
    return ResponseEntity.ok(this.etudiantService.save(request));
}
//todo the find byID is working ghir howa l id dyal request makatb9ach hiya nfss dyal response o -- o kanakhdo dyal response ila bghina n9lbo 3lih
@GetMapping("/find/{id}")
    public ResponseEntity<EtudiantResponse> findById(@PathVariable("id") int id){
    return ResponseEntity.ok(this.etudiantService.findById(id));

}
//todo it's working
@GetMapping
    public ResponseEntity<List<EtudiantResponse>> findAll(){
    return ResponseEntity.ok(this.etudiantService.findAll());
}

//communication entre les microservices
    @GetMapping("/{id}/exists")
    public ResponseEntity<Void> verifierEtudiant(@PathVariable int id) {
        if (!etudiantService.existeEtudiant(id)) {
            throw new EntityNotFoundException("Étudiant introuvable");
        }
        return ResponseEntity.ok().build();
    }

}
