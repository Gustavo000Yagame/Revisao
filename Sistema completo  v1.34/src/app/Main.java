package app;

import model.*;
import service.Helpdesk;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static PrioridadeChamado escolherPrioridade(Scanner entrada){
        System.out.println("1 - Baixa | 2 - Média | 3 - Alta");
        int opcao = entrada.nextInt();
        entrada.nextLine();

        if (opcao == 1) return PrioridadeChamado.BAIXA;
        if (opcao == 2) return PrioridadeChamado.MEDIA;
        if (opcao == 3) return PrioridadeChamado.ALTA;

        return null;
    }

    public static StatusChamado escolherStatus(Scanner entrada){
        System.out.println("1 - ABERTO | 2 - EM_ANDAMENTO | 3 - RESOLVIDO | 4 - CANCELADO");
        int opcao = entrada.nextInt();
        entrada.nextLine();

        if (opcao == 1) return StatusChamado.ABERTO;
        if (opcao == 2) return StatusChamado.EM_ANDAMENTO;
        if (opcao == 3) return StatusChamado.RESOLVIDO;
        if (opcao == 4) return StatusChamado.CANCELADO;

        return null;
    }

    public static void iniciar(String[] args){

        Scanner entrada = new Scanner(System.in);
        Helpdesk hd = new Helpdesk();

        int opcao;

        do {
            System.out.println("--- Sistema HelpDesk ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Abrir Chamado");
            System.out.println("--- Listar ---");
            System.out.println("3 - Listar chamados por status");
            System.out.println("4 - Listar chamados por nome");
            System.out.println("--- Alterar ---");
            System.out.println("5 - Alterar status do chamado");
            System.out.println("6 - Alterar Descrição do ID");
            System.out.println("0 - Voltar");

            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao){
                /*case 0:{
                    sistema.Sistema.escolha(new String[0]);
                }break;
                */
                case 1: {
                    System.out.println("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.println("Email: ");
                    String email = entrada.nextLine();

                    hd.cadastrarCliente(nome, email);
                    System.out.println("Cliente cadastrado!");
                    break;
                }

                case 2: {
                    System.out.println("Número do chamado: ");
                    Integer numero = entrada.nextInt();
                    entrada.nextLine();

                    System.out.println("Título: ");
                    String titulo = entrada.nextLine();

                    System.out.println("Descrição: ");
                    String descricao = entrada.nextLine();

                    System.out.println("Email do cliente: ");
                    String email = entrada.nextLine();

                    Cliente cli = hd.buscarCliente(email);

                    if (cli == null){
                        System.out.println("Cliente não foi encontrado!");
                        break;
                    }

                    PrioridadeChamado prio = escolherPrioridade(entrada);

                    if (prio == null){
                        System.out.println("Prioridade inválida!");
                        break;
                    }

                    hd.abrirChamado(numero, titulo, descricao, prio, cli);
                    System.out.println("Chamado foi aberto!");
                    break;
                }

                case 3: {
                    StatusChamado status = escolherStatus(entrada);

                    if (status == null){
                        System.out.println("Status inválido!");
                        break;
                    }

                    ArrayList<Chamado> lista = hd.listarChamadosPorStatus(status);

                    if (lista.isEmpty()){
                        System.out.println("Nenhum chamado com esse status.");
                    } else {
                        for (Chamado c : lista){
                            System.out.println(c);
                        }
                    }
                    break;
                }

                case 5: {
                    System.out.println("Número do chamado: ");
                    Integer numero = entrada.nextInt();
                    entrada.nextLine();

                    StatusChamado novoStatus = escolherStatus(entrada);

                    if (novoStatus == null){
                        System.out.println("Status inválido!");
                        break;
                    }

                     boolean alterado = hd.alterarStatusChamado(numero, novoStatus);

                    if (alterado){
                        System.out.println("Status alterado com sucesso!");
                    } else {
                        System.out.println("Chamado não encontrado!");
                    }break;
                }

                case 4: {
                    System.out.println("Digite o nome do cliente:");
                    String nome = entrada.nextLine();

                    ArrayList<Chamado> lista = hd.buscarChamadosPorNome(nome);

                    if (lista.isEmpty()) {
                        System.out.println("Nenhum chamado encontrado para esse cliente.");
                    } else {
                        System.out.println("Chamados encontrados:");
                        for (Chamado c : lista) {
                            System.out.println(c);
                        }
                    }
                    break;
                }
                    case 6:
                        System.out.println("Digite o ID do Chamado");
                        Integer numero = entrada.nextInt();
                        entrada.nextLine();

                        System.out.println("Digite a nova descrição");
                        String descricao = entrada.nextLine();

                        boolean alterado = hd.alterarDescricaoChamado(numero, descricao);

                        if(alterado){
                            System.out.println("Descrição alterada com sucesso");
                        }else {
                            //throw new IllegalArgumentException
                            System.out.println("Chamado não encontrado, tente novamente mais tarde!");
                        }break;


                case 0:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        entrada.close();
    }
}