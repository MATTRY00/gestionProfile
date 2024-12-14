package hazy.gestionProfile.UsersProfiles;

import hazy.gestionProfile.enumm.DietaryHabit;
import hazy.gestionProfile.enumm.Lifestyle;
import hazy.gestionProfile.enumm.Passion;
import hazy.gestionProfile.enumm.Personality;

import java.util.Date;
import java.util.List;

public record EtudiantResponse(
        Integer id,
        String nom,
        String prenom,
        String ecole,
        String numeroTele,
        Date dateNaissance,//hna khass irj3 age en se basant 3la date de naissance
        String langues,
        String description,

        String photoUrl, // Optional, as not every user may want to upload a photo.
        List<Personality> personalityTraits,  // List of personality traits (from the enum)
        List<Lifestyle> lifestylePreferences,  // List of lifestyle preferences (from the enum)
        List<DietaryHabit> dietaryHabits,  // List of dietary habits (from the enum)
        List<Passion> passions
) {
}
