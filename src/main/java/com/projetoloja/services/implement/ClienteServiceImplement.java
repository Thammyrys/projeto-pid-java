package com.projetoloja.services.implement;

import com.projetoloja.models.ClienteModel;
import com.projetoloja.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ClienteServiceImplement implements ClienteService {

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;
    private String QUERY_INSERT_CLIENTE = "INSERT INTO CLIENTE (" +
                "ID, " +
                "CEP_CLIENTE, " +
                "CPF_CLIENTE, " +
                "ENDERECO_CLIENTE, " +
                "NOME_CLIENTE, " +
                "TELEFONE_CLIENTE) " +
            "VALUES (" +
                ":id, " +
                ":cep, " +
                ":cpf, " +
                ":endereco, " +
                ":nome, " +
                ":telefone)";

    @Override
    public void cadastrarCliente(ClienteModel cliente) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", cliente.getId())
                .addValue("cep", cliente.getCepCliente())
                .addValue("cpf", cliente.getCpfCliente())
                .addValue("endereco", cliente.getEnderecoCliente())
                .addValue("nome", cliente.getNomeCliente())
                .addValue("telefone", cliente.getTelefoneCliente());
        jdbcTemplate.update(QUERY_INSERT_CLIENTE, namedParameters);
    }

    @Override
    public void excluirCliente(Long idCliente) {

    }

    private String QUERY_LISTAR_CLIENTES = "SELECT * FROM CLIENTE";
    @Override
    public List<ClienteModel> listarClientes() {
        List<ClienteModel> clienteList =
                jdbcTemplate.query(QUERY_LISTAR_CLIENTES, new ClienteMapper());

        return clienteList;
    }

    private String QUERY_BUSCAR_CLIENT = "SELECT * FROM CLIENTE WHERE ID = :id";
    @Override
    public ClienteModel buscarCliente(Long idCliente) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", idCliente);
        return jdbcTemplate.queryForObject(QUERY_BUSCAR_CLIENT, namedParameters, new ClienteMapper());
    }

    private class ClienteMapper implements RowMapper<ClienteModel> {
        @Override
        public ClienteModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            ClienteModel cliente = new ClienteModel();
            cliente.setId(rs.getLong("id"));
            cliente.setCepCliente(rs.getString("CEP_CLIENTE"));
            cliente.setCpfCliente(rs.getString("CPF_CLIENTE"));
            cliente.setEnderecoCliente(rs.getString("ENDERECO_CLIENTE"));
            cliente.setNomeCliente(rs.getString("NOME_CLIENTE"));
            cliente.setTelefoneCliente(rs.getString("TELEFONE_CLIENTE"));
            return cliente;
        }
    }
}
