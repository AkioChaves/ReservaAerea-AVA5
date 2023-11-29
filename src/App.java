import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Reserva Aérea!");

        Menu.exibirMenuPrincipal(scanner);

        scanner.close();
    }
}