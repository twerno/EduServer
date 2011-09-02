package net.twerno.eduserver.zadanie.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import net.twerno.eduserver.user.UserHelper;
import net.twerno.eduserver.zadanie.entity.ZadaneZadanie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class InternalZadanieService {

//	@Autowired
//	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
//	@Autowired
//	private SessionFactory session;
	
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	public List<ZadaneZadanie> dajZadaneMi() {
		String SQL = " SELECT z.id" 
                +" FROM      account_grupa        a" 
				+" LEFT JOIN zadane_zadanie_grupy zzg ON zzg.grupy = a.grupa_id"
				+" LEFT JOIN zadane_zadanie       z   ON z.id      = zzg.zadane_zadanie"
				+" WHERE a.account_id = ?";

		List<ZadaneZadanie> result = new ArrayList<ZadaneZadanie>();
		List<Map<String,Object>> queryResult = jdbcTemplate.queryForList(SQL, 
					new Object[] { UserHelper.getCurrentUserId() });
		for (Map<String, Object> row: queryResult)
			result.add(ZadaneZadanie.findZadaneZadanie(row.get("id").toString()));
		return result;
	}
	
}
