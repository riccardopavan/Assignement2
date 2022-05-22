////////////////////////////////////////////////////////////////////
// Alberto Lazari 1216747
// Riccardo Pavan 1189938
////////////////////////////////////////////////////////////////////

package it.unipd.mtss.model;

public class User {
    private final String name;
    private final int age;

    public User(String name, int age) {
        if (name == null) {
            throw new IllegalArgumentException("Il nome non può essere nullo");
        }
        if (age < 0) {
            throw new IllegalArgumentException("L'età non può essere negativa");
        }
        if (name.equals("")) {
            throw new IllegalArgumentException("Il nome non può essere vuoto");
        }

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
