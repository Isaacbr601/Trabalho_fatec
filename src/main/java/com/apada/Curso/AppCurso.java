package com.apada.curso;

import java.util.Scanner;

public class AppCurso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU CURSO ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Duração: ");
                    String duracao = sc.nextLine();
                    com.apada.curso.CursoDAO.inserirCurso(nome, valor, duracao);
                    break;

                case 2:
                    System.out.print("ID do curso: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo valor: ");
                    double novoValor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Nova duração: ");
                    String novaDuracao = sc.nextLine();
                    com.apada.curso.CursoDAO.atualizarCurso(idAtualizar, novoNome, novoValor, novaDuracao);
                    break;

                case 3:
                    System.out.print("ID do curso: ");
                    int idDeletar = sc.nextInt();
                    com.apada.curso.CursoDAO.deletarCurso(idDeletar);
                    break;

                case 4:
                    com.apada.curso.CursoDAO.listarCursos();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
