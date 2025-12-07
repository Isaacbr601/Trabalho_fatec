package com.apada.curso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.apada.database.Conexao;
import java.util.Scanner;

public class CursoDAO {

    public static void inserirCurso(String nome, double valor, String duracao) {
        String sql = "INSERT INTO curso (nome, valor, duracao) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setString(3, duracao);
            stmt.executeUpdate();
            System.out.println("Curso inserido com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao inserir curso: " + e.getMessage());
        }
    }

    public static void listarCursos() {
        String sql = "SELECT * FROM curso";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_curso") +
                        ", Nome: " + rs.getString("nome") +
                        ", Valor: " + rs.getDouble("valor") +
                        ", Duração: " + rs.getString("duracao"));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar cursos: " + e.getMessage());
        }
    }

    public static void atualizarCurso(int id, String nome, double valor, String duracao) {
        String sql = "UPDATE curso SET nome = ?, valor = ?, duracao = ? WHERE id_curso = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setDouble(2, valor);
            stmt.setString(3, duracao);
            stmt.setInt(4, id);
            stmt.executeUpdate();
            System.out.println("Curso atualizado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao atualizar curso: " + e.getMessage());
        }
    }

    public static void deletarCurso(int id) {
        String sql = "DELETE FROM curso WHERE id_curso = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Curso deletado com sucesso!");

        } catch (SQLException e) {
            System.err.println("Erro ao deletar curso: " + e.getMessage());
        }
    }
}
