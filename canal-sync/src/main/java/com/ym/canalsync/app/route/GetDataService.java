package com.ym.canalsync.app.route;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.ym.canalsync.app.config.DSEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 描述:
 *
 * @author YuanMan
 * @date 2020-04-23 14:50
 */
@Service
@DS(DSEnum.BOSS_PMS)
public class GetDataService {

    private static final String SQL = "select * from %s where id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Map<String, Object> selectData(String pk, String table) {
        String sql = String.format(SQL, table);
        try {
            return jdbcTemplate.queryForMap(sql, pk);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
