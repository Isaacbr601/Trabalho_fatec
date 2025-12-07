package com.apada.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date; // Import necessário
import com.apada.database.Conexao;

public class AlunoDAO {

    // INSERIR ALUNO
    public static void inserirAluno(String nome, String dataNascimento, String email,
                                    String telefone, String endereco, String statusMatricula,
                                    int turmaId, String cpf) {
        String sql = "INSERT INTO aluno (nome, data_nascimento, email, telefone, endereco, status_matricula, turma_id, cpf) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Converter a string (AAAA-MM-DD) para java.sql.Date
            Date dataSql = Date.valueOf(dataNascimento);

            stmt.setString(1, nome);
            stmt.setDate(2, dataSql); // aqui muda de setString → setDate
            stmt.setString(3, email);
            stmt.setString(4, telefone);
            stmt.setString(5, endereco);
            stmt.setString(6, statusMatricula);
            stmt.setInt(7, turmaId);
            stmt.setString(8, cpf);

            stmt.executeUpdate();
            System.out.println("Aluno inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir aluno: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Data inválida! Use o formato AAAA-MM-DD.");
        }
    }

    // LISTAR ALUNOS
    public static void listarAlunos() {
        String sql = "SELECT * FROM aluno";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_aluno") +
                        ", Nome: " + rs.getString("nome") +
                        ", CPF: " + rs.getString("cpf") +
                        ", Email: " + rs.getString("email") +
                        ", Data de Nascimento: " + rs.getDate("data_nascimento"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar alunos: " + e.getMessage());
        }
    }

    // ATUALIZAR ALUNO
    public static void atualizarAluno(int idAluno, String nome, String email) {
        String sql = "UPDATE aluno SET nome = ?, email = ? WHERE id_aluno = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setInt(3, idAluno);

            stmt.executeUpdate();
            System.out.println("Aluno atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar aluno: " + e.getMessage());
        }
    }

    // DELETAR ALUNO
    public static void deletarAluno(int idAluno) {
        String sql = "DELETE FROM aluno WHERE id_aluno = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            stmt.executeUpdate();
            System.out.println("Aluno deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar aluno: " + e.getMessage());
        }
    }
}
