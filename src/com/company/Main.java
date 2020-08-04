package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
	Person person = new Person(1, "Mike");
    person.show();
	WriteObject.writeObject(person);

	System.out.println("--------read--------");

	Person person1 = (Person) ReadObject.readObject();
	person1.show();

    }
}

class Person implements Serializable {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void show(){
        System.out.println(id + " " + name);
    }
}

class WriteObject{

    public static void writeObject(Object obj) {

        File file = new File("person.bin");

        try
        {
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            fos.close();
            oos.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

class ReadObject{


    public static Object readObject() {
        Object obj = null;
        try {
            File file = new File("person.bin");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
