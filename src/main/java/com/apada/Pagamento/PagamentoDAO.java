package com.apada.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.apada.database.Conexao;

public class PagamentoDAO {

    // INSERIR PAGAMENTO
    public static void inserirPagamento(double valor, String forma, String status, int idMatricula, String data) {
        String sql = "INSERT INTO pagamento (valor, forma, status, id_matricula, data) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, valor);
            stmt.setString(2, forma);
            stmt.setString(3, status);
            stmt.setInt(4, idMatricula);
            stmt.setString(5, data);

            stmt.executeUpdate();
            System.out.println("Pagamento inserido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir pagamento: " + e.getMessage());
        }
    }

    // ATUALIZAR STATUS DO PAGAMENTO
    public static void atualizarPagamento(int idPagamento, String novoStatus) {
        String sql = "UPDATE pagamento SET status = ? WHERE id_pagamento = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, novoStatus);
            stmt.setInt(2, idPagamento);

            stmt.executeUpdate();
            System.out.println("Pagamento atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar pagamento: " + e.getMessage());
        }
    }

    // DELETAR PAGAMENTO
    public static void deletarPagamento(int idPagamento) {
        String sql = "DELETE FROM pagamento WHERE id_pagamento = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPagamento);
            stmt.executeUpdate();
            System.out.println("Pagamento deletado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao deletar pagamento: " + e.getMessage());
        }
    }

    // LISTAR PAGAMENTOS
    public static void listarPagamentos() {
        String sql = "SELECT * FROM pagamento";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_pagamento") +
                        ", Valor: " + rs.getDouble("valor") +
                        ", Forma: " + rs.getString("forma") +
                        ", Status: " + rs.getString("status") +
                        ", ID Matrícula: " + rs.getInt("id_matricula") +
                        ", Data: " + rs.getDate("data"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar pagamentos: " + e.getMessage());
        }
    }
}
