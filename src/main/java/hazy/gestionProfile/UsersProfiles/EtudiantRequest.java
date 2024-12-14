package hazy.gestionProfile.UsersProfiles;





import hazy.gestionProfile.enumm.DietaryHabit;
import hazy.gestionProfile.enumm.Lifestyle;
import hazy.gestionProfile.enumm.Passion;
import hazy.gestionProfile.enumm.Personality;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record EtudiantRequest(
        Integer id,
        @NotNull(message = "School name is required")
        String ecole,
        @NotNull(message = "Phone number is required")
        String numeroTele,
        @NotNull(message = "Country code is required")
        String paysCode,
        @NotNull(message = "Date of birth is required")
        Date dateNaissance,
        @NotNull(message = "Languages spoken is required")
        String langues,
        @NotNull(message = "Description is required")
        String description,
        String photoUrl, // Optional, as not every user may want to upload a photo.
        @NotNull(message = "Contact preference is required")
        ContactPreference contactPreference ,  // Using the enum you defined
        List<Personality> personalityTraits,  // List of personality traits (from the enum)
        List<Lifestyle> lifestylePreferences,  // List of lifestyle preferences (from the enum)
        List<DietaryHabit> dietaryHabits,  // List of dietary habits (from the enum)
        List<Passion> passions  // List of passions (from the enum)
) {



    // Here you could define any custom methods or logic specific to this request if needed
}

