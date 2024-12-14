package hazy.gestionProfile.UsersProfiles;

import org.springframework.stereotype.Service;
@Service
public class EtudiantMapper {

    // Map Step 1 data to Etudiant (basic info)
//    public Etudiant toEtudiantStep1(EtudiantStep1Request request) {
//        return Etudiant.builder()
//                .id(request.id() )
//                .ecole(request.ecole() )
//                .numeroTele(request.numeroTele() )
//                .paysCode(request.paysCode() )
//                .dateNaissance(request.dateNaissance()) // Keep existing data
//                .langues(request.langues()) // Keep existing data
//                .photoUrl(request.photoUrl() ) // Keep existing data
//                .contactPreference(request.contactPreference() ) // Keep existing data
//
//                .build();
//    }

    // Map Step 2 data to Etudiant (additional info)
//    public Etudiant toEtudiantStep2(EtudiantStep2Request request) {
//        return Etudiant.builder()
//                .personalityTraits(request.personalityTraits() ) // Keep existing data
//                .lifestylePreferences(request.lifestylePreferences()) // Keep existing data
//                .dietaryHabits(request.dietaryHabits() ) // Keep existing data
//                .passions(request.passions()) // Keep existing data
//                .build();
//    }

//    public EtudiantResponse1 toProductResponse1(Etudiant etudiant) {
//        return new EtudiantResponse1(
//                etudiant.getId(),
//                etudiant.getNom(),
//                etudiant.getPrenom(),
//                etudiant.getEcole(),
//                etudiant.getNumeroTele(),
//                etudiant.getDateNaissance(),
//                etudiant.getLangues(),
//                etudiant.getDescription(),
//                etudiant.getPhotoUrl()
//        );
//    }

//    public EtudiantResponse2 toProductResponse2(Etudiant etudiant) {
//        return new EtudiantResponse2(
//                etudiant.getPersonalityTraits(),
//                etudiant.getLifestylePreferences(),
//                etudiant.getDietaryHabits(),
//                etudiant.getPassions()
//        );
//    }


    public Etudiant toEtudiant(EtudiantRequest request) {
       return Etudiant.builder()
               .id(request.id())
               .ecole(request.ecole())
               .numeroTele(request.numeroTele())
               .paysCode(request.paysCode())
               .dateNaissance(request.dateNaissance()) // Keep existing data
               .langues(request.langues())
               .description(request.description())// Keep existing data
               .photoUrl(request.photoUrl()) // Keep existing data
               .contactPreference(request.contactPreference())
               .personalityTraits(request.personalityTraits())
               .lifestylePreferences(request.lifestylePreferences())
               .dietaryHabits(request.dietaryHabits())
               .passions(request.passions())
               .build();


    }
    public EtudiantResponse toProductResponse(Etudiant etudiant) {
        return new EtudiantResponse(
                etudiant.getId(),
                etudiant.getNom(),
                etudiant.getPrenom(),
                etudiant.getEcole(),
                etudiant.getNumeroTele(),
                etudiant.getDateNaissance(),
                etudiant.getLangues(),
                etudiant.getDescription(),
                etudiant.getPhotoUrl(),
                etudiant.getPersonalityTraits(),
                etudiant.getLifestylePreferences(),
                etudiant.getDietaryHabits(),
                etudiant.getPassions()
        );
    }


}
