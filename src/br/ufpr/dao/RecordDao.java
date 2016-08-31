package br.ufpr.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import br.ufpr.util.Util;

public class RecordDao extends GenericDao {
	
	
	@SuppressWarnings("rawtypes")
	public Long getMaxId() throws SQLException {
		String sql = "select max(c004_record_id) MAX_VALUE from T004_Record";
		ArrayList<Map> res = executeQuery(sql);
		Iterator<Map> iter = res.iterator();
		Long qtd = (long) 0;

		while(iter.hasNext()) {
			Map row = (Map) iter.next();
			qtd = Long.parseLong(Util.getNullText(row.get("MAX_VALUE")));
		} 

		return qtd;
	}

}