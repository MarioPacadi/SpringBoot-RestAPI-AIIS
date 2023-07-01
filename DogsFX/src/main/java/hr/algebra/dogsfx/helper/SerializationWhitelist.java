package hr.algebra.dogsfx.helper;

import hr.algebra.dogsfx.model.DogBreed;

import java.util.HashSet;
import java.util.Set;

public class SerializationWhitelist {
    private static final Set<Class<?>> allowedClasses = new HashSet<>();

    static {
        allowedClasses.add(DogBreed.class);
    }

    public static boolean isClassAllowed(Class<?> clazz) {
        return allowedClasses.contains(clazz);
    }
}
