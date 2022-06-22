package com.projetoloja.services.implement;

import com.projetoloja.models.OrdemServicoModel;
import com.projetoloja.services.OrdemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

@Service
public class OrdemServiceImpl implements OrdemService {

    @Autowired
    private NamedParameterJdbcOperations jdbcTemplate;

    private String INSERIR_ORDEM = "INSERT INTO ordem_servico (" +
                "id, " +
                "data_entrada, " +
                "data_saida )" +
            "VALUES (" +
                ":id, :dataEntrada, :dataSaida" +
            ")";

    @Override
    public Integer inserirOrdem(OrdemServicoModel ordem) throws Exception {

        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource parameterSource = new MapSqlParameterSource()
                .addValue("id", ordem.getId())
                .addValue("dataEntrada", ordem.getDataEntrada())
                .addValue("dataSaida", ordem.getDataSaida());

        jdbcTemplate.update(INSERIR_ORDEM, parameterSource, keyHolder, new String[]{"id"});

        return fetchIdFromKeyHolder(keyHolder);
    }

    private Integer fetchIdFromKeyHolder(KeyHolder keyHolder) throws Exception {
        Integer id = null;
        Number generatedValue = keyHolder.getKey();
        if(generatedValue == null) {
            throw new Exception("Erro ao gerar chave!");
        } else {
            id = generatedValue.intValue();
        }
        return  id;
    }
}
