package hazy.gestionProfile.UsersProfiles;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EtudiantService {


    private final EtudiantRepository etudiantRepository;
    private final EtudiantMapper etudiantMapper;
//saving part 1
    //todo save is working in postman
    public Integer save(EtudiantRequest request) {
        var etudiant = etudiantMapper.toEtudiant(request);
        return etudiantRepository.save(etudiant).getId();}

// get user profile by id
public EtudiantResponse findById(Integer id) {
    return etudiantRepository.findById(id)
            .map(etudiantMapper::toProductResponse)
            .orElseThrow(() -> new EntityNotFoundException("Etudiant not found with ID:: " + id));
}

public List<EtudiantResponse> findAll(){
        return etudiantRepository.findAll()
                .stream().map(etudiantMapper::toProductResponse)//thrown if the entity coudl not  found in the data base
                .collect(Collectors.toList());
}

//ma3dnach update in our case update hiya create
//public List<Personality> getPersonalityOptions() {
//    return Arrays.asList(Personality.values());
//}
//
//    // Returns a list of all Lifestyle options
//    public List<Lifestyle> getLifestyleOptions() {
//        return Arrays.asList(Lifestyle.values());
//    }
//
//    // Returns a list of all DietaryHabit options
//    public List<DietaryHabit> getDietaryOptions() {
//        return Arrays.asList(DietaryHabit.values());
//    }

    // Returns a list of all Passion options
//    public List<Passion> getPassionOptions() {
//        return Arrays.asList(Passion.values());
//    }


    //todo communication entre les micorservices
    public boolean existeEtudiant(int id) {
        return etudiantRepository.existsById(id);  // Utilisation de la méthode JPA pour vérifier l'existence
    }


}
