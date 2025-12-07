package com.apada;

import java.util.Scanner;

// Importando os menus de cada CRUD
import com.apada.aluno.AppAluno;
import com.apada.curso.AppCurso;
import com.apada.Matricula.AppMatricula;
import com.apada.Pagamento.AppPagamento;

public class App {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1 - Gerenciar Alunos");
            System.out.println("2 - Gerenciar Cursos");
            System.out.println("3 - Gerenciar Matrículas");
            System.out.println("4 - Gerenciar Pagamentos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1 -> AppAluno.main(null); // chama menu do aluno
                case 2 -> AppCurso.main(null); // chama menu do curso
                case 3 -> AppMatricula.main(null); // chama menu da matrícula
                case 4 -> AppPagamento.main(null); // chama o menu de pagamento
                case 0 -> System.out.println("Encerrando o sistema...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        entrada.close();
    }
}
