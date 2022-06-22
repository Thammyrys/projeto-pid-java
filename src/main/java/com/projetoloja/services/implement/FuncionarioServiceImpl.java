package com.projetoloja.services.implement;

import com.projetoloja.models.ClienteModel;
import com.projetoloja.models.FuncionarioModel;
import com.projetoloja.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

    private String QUERY_INSERT_FUNC = "INSERT INTO FUNCIONARIO (" +
            "ID, " +
            "CEP_FUNC, " +
            "ENDERECO_FUNC, " +
            "NOME_FUNC, " +
            "TELEFONE_FUNC) " +
            "VALUES (" +
            ":id, " +
            ":cep, " +
            ":endereco, " +
            ":nome, " +
            ":telefone)";
    @Override
    public void cadastrarFuncionario(FuncionarioModel funcionario) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", funcionario.getId())
                .addValue("cep", funcionario.getCepFunc())
                .addValue("endereco", funcionario.getEnderecoFunc())
                .addValue("nome", funcionario.getNomeFunc())
                .addValue("telefone", funcionario.getTelefoneFunc());
        jdbcTemplate.update(QUERY_INSERT_FUNC, namedParameters);
    }

    @Override
    public void excluirFuncionario(Long idFuncionario) {

    }

    private String SQL_LISTAR_FUNC = "SELECT * FROM FUNCIONARIO";
    @Override
    public List<FuncionarioModel> listarFuncionarios() {
        List<FuncionarioModel> listaRetorno = jdbcTemplate.query(SQL_LISTAR_FUNC, new FuncionarioMapper());
        return listaRetorno;
    }

    private String QUERY_BUSCAR_FUNC = "SELECT * FROM FUNCIONARIO WHERE ID = :id ";

    @Override
    public FuncionarioModel buscarFuncionario(Long idFuncionario) {
        SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", idFuncionario);
        return jdbcTemplate.queryForObject(QUERY_BUSCAR_FUNC, namedParameters, new FuncionarioMapper());
    }

    private class FuncionarioMapper implements RowMapper<FuncionarioModel> {
        @Override
        public FuncionarioModel mapRow(ResultSet rs, int rowNum) throws SQLException {
            FuncionarioModel funcionario = new FuncionarioModel();
            funcionario.setId(rs.getLong("ID"));
            funcionario.setCepFunc(rs.getString("CEP_FUNC"));
            funcionario.setEnderecoFunc(rs.getString("ENDERECO_FUNC"));
            funcionario.setNomeFunc(rs.getString("NOME_FUNC"));
            funcionario.setTelefoneFunc(rs.getString("TELEFONE_FUNC"));
            return funcionario;
        }
    }
}
