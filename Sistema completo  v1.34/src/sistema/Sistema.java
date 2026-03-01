package sistema;
import service.Helpdesk;

import java.util.*;

public class Sistema {
    static void escolha() {
    Scanner entrada = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("  | --- Escolha o sistema ---");
            System.out.println("1 |  --- Helpdesk --- ");
            System.out.println("0 |  --- Sair --- ");
            opcao = entrada.nextInt();



            switch (opcao) {
                case 1:
                System.out.println("Entrando em HelpDesk...");
                app.Main.iniciar(new String[0]);
                break;

                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);

            }
        } while (opcao != 0);
    }
}