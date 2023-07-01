package hr.algebra.dogsfx.helper;

import hr.algebra.dogsfx.model.DogBreed;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WhitelistedObjectInputStream extends ObjectInputStream {
    private static Set<Class<?>> whitelist=new HashSet<>();

    static {
        whitelist.add(DogBreed.class);
        whitelist.add(List.class);
        whitelist.add(ArrayList.class);
    }

    public WhitelistedObjectInputStream(InputStream inputStream) throws IOException {
        super(inputStream);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass desc) throws IOException, ClassNotFoundException {
        Class<?> clazz = super.resolveClass(desc);
        if (!isWhitelisted(clazz)) {
            throw new ClassNotFoundException("Class not whitelisted: " + clazz.getName());
        }
        return clazz;
    }

    private static boolean isWhitelisted(Class<?> clazz) {
        return whitelist.contains(clazz);
    }
}
