package gb.org;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private User сhief;
    User nextUser;
    User predUser;

    public User(String firstName, String lastName, int age, User сhief) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.сhief = сhief;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {this.age = age; }

    public User getСhief() {
        return сhief;
    }

    public void setСhief(User сhief) {
        this.сhief = сhief;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.firstName, this.lastName, this.age);
    }

}
