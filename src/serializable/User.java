package serializable;

import java.io.Serializable;

/**
 * user class
 */
public class User implements Serializable{
    private static final long serialVersionUID = -1;
    private String name;
    transient private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
