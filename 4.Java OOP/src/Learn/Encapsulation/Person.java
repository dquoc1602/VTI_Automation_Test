package Learn.Encapsulation;

//Đóng gói
public class Person {
    // ENCAPSULATION: Fields are private to restrict direct access from outside
    private String name;
    private String age;

    // Getter method: Allows reading the private 'name' field
    public String getName() {
        return name;
    }

    // Setter method: Allows modifying the private 'name' field
    // This allows control over how the data is set (e.g., validation could be added here)
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public String getAge() {
        return age;
    }

    // Setter for age
    public void setAge(String age) {
        this.age = age;
    }
}
