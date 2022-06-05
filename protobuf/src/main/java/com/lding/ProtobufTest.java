package com.lding;

import com.lding.domain.PersonModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ProtobufTest {
    public static void main(String[] args) throws Exception {
        PersonModel.Person person = PersonModel.Person
                .newBuilder().setName("avril").setAge(18).setSex(true).build();
        byte[] bytes = person.toByteArray();
        System.out.println("序列化后的长度为：" + bytes.length);

        try (FileOutputStream fos = new FileOutputStream("person.dat")) {
            fos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        File file = new File("person.dat");
        try {
            byte[] buffer = new byte[(int) file.length()];
            FileInputStream fis = new FileInputStream(file);
            fis.read(buffer);
            PersonModel.Person personCopy = PersonModel.Person.parseFrom(buffer);
            System.out.println(personCopy); // name: "avril" age: 18 sex: true
            System.out.println(person == personCopy); // false
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
