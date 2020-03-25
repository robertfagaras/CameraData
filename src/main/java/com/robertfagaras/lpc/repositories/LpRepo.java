package com.robertfagaras.lpc.repositories;

import com.robertfagaras.lpc.model.LP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LpRepo {

    @Autowired
    @Qualifier("jdbcTemplate2")
    private JdbcTemplate jdbcTemplate2;

    public void addLP(LP lp){
        String sql = "INSERT INTO lp VALUES(NULL,?,?)";
        jdbcTemplate2.update(sql,lp.getDate(),lp.getNumber());
    }

    public List<LP> getLPs(){
        String sql = "SELECT * FROM lp";
        return jdbcTemplate2.query(sql, new RowMapper<LP>() {
            @Override
            public LP mapRow(ResultSet resultSet, int i) throws SQLException {
                LP lp = new LP();
                lp.setId(resultSet.getInt("id"));
                lp.setDate(resultSet.getString("date"));
                lp.setNumber(resultSet.getString("number"));
                return lp;
            }
        });
    }

}
