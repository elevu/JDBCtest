package jdbctest;

public class Artist {

    private int id;
    private String name;
    private String lastName;
    private int birthYear;

    public Artist(int id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.birthYear = age;
    }

    @Override
    public String toString() {
        return String.format("%-4s%-20s%-20s%-8s", id, name, lastName, birthYear);
    }

}
