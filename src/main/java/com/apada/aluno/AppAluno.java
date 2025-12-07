package com.apada.aluno;

import java.util.Scanner;

public class AppAluno {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU ALUNO ===");
            System.out.println("1 - Inserir");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Remover");
            System.out.println("4 - Listar");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    entrada.nextLine(); // limpar buffer
                    System.out.print("Nome: ");
                    String nome = entrada.nextLine();

                    System.out.print("Data de Nascimento (AAAA-MM-DD): ");
                    String dataNascimento = entrada.next();

                    System.out.print("Email: ");
                    String email = entrada.next();

                    System.out.print("Telefone: ");
                    String telefone = entrada.next();

                    entrada.nextLine(); // limpar buffer
                    System.out.print("Endereço: ");
                    String endereco = entrada.nextLine();

                    System.out.print("Status da Matrícula: ");
                    String statusMatricula = entrada.next();

                    System.out.print("ID da Turma: ");
                    int turmaId = entrada.nextInt();

                    System.out.print("CPF: ");
                    String cpf = entrada.next();

                    AlunoDAO.inserirAluno(nome, dataNascimento, email, telefone, endereco, statusMatricula, turmaId, cpf);
                    break;

                case 2:
                    System.out.print("ID do aluno: ");
                    int idAluno = entrada.nextInt();

                    entrada.nextLine(); // limpar buffer
                    System.out.print("Novo Nome: ");
                    String novoNome = entrada.nextLine();

                    System.out.print("Novo Email: ");
                    String novoEmail = entrada.next();

                    AlunoDAO.atualizarAluno(idAluno, novoNome, novoEmail);
                    break;

                case 3:
                    System.out.print("ID do aluno: ");
                    int idRemover = entrada.nextInt();
                    AlunoDAO.deletarAluno(idRemover);
                    break;

                case 4:
                    AlunoDAO.listarAlunos();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);

        entrada.close();
    }
}
