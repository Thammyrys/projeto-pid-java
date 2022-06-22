package com.projetoloja.services.implement;

import com.projetoloja.models.AparelhoModel;
import com.projetoloja.services.AparelhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AparelhoServiceImpl implements AparelhoService {

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

    private String INSERT_APARELHO = "INSERT INTO APARELHO (" +
                "id, " +
                "descricao_defeito, " +
                "marca_aparelho, " +
                "modelo_aparelho, " +
                "nome_aparelho, " +
                "numero_serie, " +
                "cliente_id, " +
                "funcionario_id, " +
                "ordem_id) " +
            "VALUES(" +
                ":id, :descricao, :marca, :modelo, " +
                ":nome, :numero, :cliente, :funcionario, :ordem" +
            ")";

    @Override
    public void cadastrarAparelho(AparelhoModel aparelho) {
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", aparelho.getId())
                .addValue("descricao", aparelho.getDescricaoDefeito())
                .addValue("marca", aparelho.getMarcaAparelho())
                .addValue("modelo", aparelho.getModeloAparelho())
                .addValue("nome", aparelho.getNomeAparelho())
                .addValue("numero", aparelho.getNumeroSerie())
                .addValue("funcionario", aparelho.getFuncionario())
                .addValue("ordem", aparelho.getOrdemServico());
        jdbcTemplate.update(INSERT_APARELHO, parameterSource);
    }

    @Override
    public List<AparelhoModel> listarAparelhos() {
        return null;
    }
}
