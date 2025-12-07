package com.apada.Matricula;  // respeitando a letra maiúscula do seu pacote

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.apada.database.Conexao;

public class MatriculaDAO {

    // Inserir matrícula
    public static void inserirMatricula(int idAluno, int idCurso, String data, String status) {
        String sql = "INSERT INTO matricula (id_aluno, id_curso, data, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idAluno);
            stmt.setInt(2, idCurso);
            stmt.setString(3, data);
            stmt.setString(4, status);

            stmt.executeUpdate();
            System.out.println("Matrícula inserida com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir matrícula: " + e.getMessage());
        }
    }

    // Listar matrículas
    public static void listarMatriculas() {
        String sql = "SELECT m.id_matricula, a.nome AS aluno, c.nome AS curso, m.data, m.status " +
                "FROM matricula m " +
                "JOIN aluno a ON m.id_aluno = a.id_aluno " +
                "JOIN curso c ON m.id_curso = c.id_curso";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_matricula") +
                        ", Aluno: " + rs.getString("aluno") +
                        ", Curso: " + rs.getString("curso") +
                        ", Data: " + rs.getDate("data") +
                        ", Status: " + rs.getString("status"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar matrículas: " + e.getMessage());
        }
    }

    // Atualizar matrícula
    public static void atualizarMatricula(int idMatricula, String status) {
        String sql = "UPDATE matricula SET status = ? WHERE id_matricula = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setInt(2, idMatricula);

            stmt.executeUpdate();
            System.out.println("Matrícula atualizada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar matrícula: " + e.getMessage());
        }
    }

    // Deletar matrícula
    public static void deletarMatricula(int idMatricula) {
        String sql = "DELETE FROM matricula WHERE id_matricula = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMatricula);
            stmt.executeUpdate();
            System.out.println("Matrícula deletada com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar matrícula: " + e.getMessage());
        }
    }
}
