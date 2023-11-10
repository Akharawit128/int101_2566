package work02;

import work01.Utilitor;

public class Person {

    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname) {

        Utilitor util = new Utilitor();
        this.firstname = util.testString(firstname);
        this.lastname = util.testString(lastname);

        this.id = nextId;
        nextId++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person(").append(id).append(",").append(firstname).append(",").append(lastname).append(")");
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {

        Utilitor util = new Utilitor();
        this.firstname = util.testString(firstname);
    }

    public void setLastname(String lastname) {

        Utilitor util = new Utilitor();
        this.lastname = util.testString(lastname);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return false;
    }
}
