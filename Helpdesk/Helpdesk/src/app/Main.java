package app;
import model.*;
import service.Helpdesk;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static void main() {
        Scanner entrada = new Scanner(System.in);
        Helpdesk hd = new Helpdesk();

        int opcao;
        do {
            System.out.println("=== Sistem HelpDesk ====");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - abrer chamado");
            System.out.println("0 - Sair");

            opcao = entrada.nextInt();

            switch (opcao){
                case 1: {
                    System.out.println("Nome: ");
                    String nome = entrada.nextLine();
                    System.out.println("Email: ");
                    String email = entrada.nextLine();
                    hd.cadastrarCliente(nome,email);
                    System.out.println("Cliente cadastrado!"); break;
                }
                case 2: {
                    System.out.println("Numero");
                    Integer numero = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("titulo");
                    String titulo = entrada.nextLine();

                    System.out.println("Descrição");
                    String descricao = entrada.nextLine();

                    System.out.println("Email do cliente");
                    String email = entrada.nextLine();

                    System.out.println("Prioridade");

                    System.out.println("Cliente");
                }
            }
        }while(opcao != 0);

    }
}
