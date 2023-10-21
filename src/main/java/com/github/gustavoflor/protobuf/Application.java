package com.github.gustavoflor.protobuf;

import com.github.gustavoflor.protobuf.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    private static final Path PATH = Paths.get("person.ser");

    public static void main(String[] args) throws IOException {
        writeSerializedFile();
//        readSerializedFile();
    }

    private static void writeSerializedFile() throws IOException {
        final var austin = Person.newBuilder()
            .setName("Austin Richard Post")
            .setAge(28)
            .build();

        Files.write(PATH, austin.toByteArray());
    }

    private static void readSerializedFile() throws IOException {
        final var bytes = Files.readAllBytes(PATH);

        final var austin = Person.parseFrom(bytes);

        System.out.println(austin);
    }

}
