package hazy.gestionProfile.Demande;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/Demande")
public class DemandeController {
    private final DemandeService demandeService;
//todo all the services are working
    @PostMapping("/creation-demande")
    public ResponseEntity<Integer> createDemande(@RequestBody DemandeRequest request) {
        Integer demandeId = demandeService.createDemande(request);
        return ResponseEntity.ok(demandeId);
    }
//    public ResponseEntity<Integer> createDemande(@RequestBody @Valid DemandeRequest request){
//        return ResponseEntity.ok(this.demandeService.save(request));
//    }
    @GetMapping("/find/{id}")
    public ResponseEntity<DemandeResponse> findById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.demandeService.findById(id));

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<DemandeResponse>> findAll(){
        return ResponseEntity.ok(this.demandeService.findAll());
    }
}
