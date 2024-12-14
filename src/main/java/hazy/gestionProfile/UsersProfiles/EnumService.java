package hazy.gestionProfile.UsersProfiles;

import hazy.gestionProfile.enumm.DietaryHabit;
import hazy.gestionProfile.enumm.Lifestyle;
import hazy.gestionProfile.enumm.Passion;
import hazy.gestionProfile.enumm.Personality;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class EnumService {

    public List<ContactPreference> getContactPreferences() {
        return Arrays.asList(ContactPreference.values());
    }

    public List<Personality> getPersonalityOptions() {
        return Arrays.asList(Personality.values());
    }

    public List<Lifestyle> getLifestyleOptions() {
        return Arrays.asList(Lifestyle.values());
    }

    public List<DietaryHabit> getDietaryOptions() {
        return Arrays.asList(DietaryHabit.values());
    }

    public List<Passion> getPassionOptions() {
        return Arrays.asList(Passion.values());
    }
}
