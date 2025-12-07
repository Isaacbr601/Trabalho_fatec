package com.apada.Matricula;

import java.util.Scanner;

public class AppMatricula {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU MATRÍCULA ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar status");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("ID do Aluno: ");
                    int idAluno = sc.nextInt();
                    System.out.print("ID do Curso: ");
                    int idCurso = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Data (AAAA-MM-DD): ");
                    String data = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();

                    MatriculaDAO.inserirMatricula(idAluno, idCurso, data, status);
                    break;

                case 2:
                    System.out.print("ID da Matrícula: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo status: ");
                    String novoStatus = sc.nextLine();

                    MatriculaDAO.atualizarMatricula(idAtualizar, novoStatus);
                    break;

                case 3:
                    System.out.print("ID da Matrícula: ");
                    int idDeletar = sc.nextInt();

                    MatriculaDAO.deletarMatricula(idDeletar);
                    break;

                case 4:
                    MatriculaDAO.listarMatriculas();
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
