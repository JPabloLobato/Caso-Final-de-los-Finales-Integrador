package Ejercicio_5;

/* Los errores que hay en este código son los métodos que suponemos que hay en Utils.java, leerCadena, leerEntero, leerFloat y
leerDouble, que no están definidos en el código. */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static ArrayList<UserAccount> users = new ArrayList<>();
    private static UserAccount currentUser;

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Usuario.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String alias = parts[0].trim();
                String email = parts[1].trim();
                users.add(new UserAccount(alias, email));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cargar usuario");
            System.out.println("2. Publicar tweet");
            System.out.println("3. Salir");
            int option = Utils.leerEntero();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el alias del usuario:");
                    String alias = Utils.leerCadena();
                    currentUser = findUserByAlias(alias);
                    if (currentUser == null) {
                        System.out.println("Usuario no encontrado");
                    } else {
                        System.out.println("Usuario cargado");
                    }
                    break;
                case 2:
                    if (currentUser == null) {
                        System.out.println("No hay usuario cargado");
                    } else {
                        System.out.println("Ingrese el mensaje del tweet:");
                        String message = Utils.leerCadena();
                        try {
                            Tweet tweet = new Tweet(LocalDate.now(), message, currentUser);
                            currentUser.tweet(tweet);
                            System.out.println("Tweet publicado");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private static UserAccount findUserByAlias(String alias) {
        for (UserAccount user : users) {
            if (user.getAlias().equals(alias)) {
                return user;
            }
        }
        return null;
    }
}