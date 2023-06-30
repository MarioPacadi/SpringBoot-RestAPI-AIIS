package hr.algebra.dogsfx.helper;

import hr.algebra.dogsfx.model.DogBreed;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class SerializationWhitelist {
    private static final Set<Class<?>> allowedClasses = new HashSet<>();

    static {
        allowedClasses.add(DogBreed.class);
    }

    public static boolean isClassAllowed(Class<?> clazz) {
        return allowedClasses.contains(clazz);
    }
}
