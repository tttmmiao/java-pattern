package serializable;

import java.io.*;

/**
 *  demo
 */
public class Demo {
    public static void main(String[] args){
        //writeToFile();
        readFromFile();
    }

    public static void writeToFile(){
        //write
        User user = new User();
        user.setName("ttt");
        user.setAge(1);
        FileOutputStream output = null;
        ObjectOutputStream oos = null;
        try {
            output = new FileOutputStream("output.txt");
            oos = new ObjectOutputStream(output);
            oos.writeObject(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readFromFile(){
        //read
        FileInputStream input = null;
        ObjectInputStream ois = null;
        try {
            input = new FileInputStream("output.txt");
            ois = new ObjectInputStream(input);
            User user =(User) ois.readObject();
            System.out.println(user);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
