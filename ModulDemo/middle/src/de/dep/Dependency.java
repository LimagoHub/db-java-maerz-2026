package de.dep;

import java.util.ServiceLoader;

public interface Dependency {

    String getName();
    void drucken();

    static Dependency create() {

        final ServiceLoader<Dependency> loader = ServiceLoader.load(Dependency.class);

        return loader.findFirst().get();
    }

    static Dependency create(String name) {
        ServiceLoader<Dependency> loader = ServiceLoader.load(Dependency.class);

        return loader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(dep -> dep.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Keine Implementierung für " + name + " gefunden!"));
    }

}