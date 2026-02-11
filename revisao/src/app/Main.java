package app;

import model.Aluno;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class Main {

    public static void cadastrarAluno(Scanner entrada, ArrayList<Aluno> alunos) {
        System.out.println("Nome do aluno: ");
        String nome = entrada.nextLine();

        System.out.println("Matricula: ");
        Integer matricula = entrada.nextInt();

        System.out.println("Nota: ");
        Double nota = entrada.nextDouble();

        entrada.nextLine();

        alunos.add(new Aluno(nome, matricula, nota));
        System.out.println("Aluno cadastrado!");
    }

    public static void listarAlunos(ArrayList<Aluno> alunos){
        if (alunos.isEmpty()){
            System.out.println("Lista Vazia");
            return;
        }
        for (Aluno a : alunos){
            System.out.println(a);
        }
    }

    static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ArrayList<Aluno> alunos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("Sistema SENAI");
            System.out.println("1 - Cadastrar aluno ");
            System.out.println("2 - listar aluno ");


            opcao = entrada.nextInt();

            switch (opcao) {
                case 1: cadastrarAluno(entrada, alunos);
                    break;
            }
        } while (opcao != 0);
    }
}