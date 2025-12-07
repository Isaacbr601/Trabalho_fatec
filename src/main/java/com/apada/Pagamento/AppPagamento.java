package com.apada.Pagamento;

import java.util.Scanner;

public class AppPagamento {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU PAGAMENTO ===");
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
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Forma: ");
                    String forma = sc.nextLine();
                    System.out.print("Status: ");
                    String status = sc.nextLine();
                    System.out.print("ID da Matrícula: ");
                    int idMatricula = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Data (AAAA-MM-DD): ");
                    String data = sc.nextLine();

                    PagamentoDAO.inserirPagamento(valor, forma, status, idMatricula, data);
                    break;

                case 2:
                    System.out.print("ID do Pagamento: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo Status: ");
                    String novoStatus = sc.nextLine();

                    PagamentoDAO.atualizarPagamento(idAtualizar, novoStatus);
                    break;

                case 3:
                    System.out.print("ID do Pagamento: ");
                    int idDeletar = sc.nextInt();

                    PagamentoDAO.deletarPagamento(idDeletar);
                    break;

                case 4:
                    PagamentoDAO.listarPagamentos();
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
