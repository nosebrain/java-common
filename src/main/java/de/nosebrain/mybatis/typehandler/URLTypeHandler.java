package de.nosebrain.mybatis.typehandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * 
 * @author nosebrain
 */
public class URLTypeHandler implements TypeHandler {

	private static URL convertToURL(final String string) {
		try {
			return new URL(string);
		} catch (final MalformedURLException e) {
			// TODO: log
			return null;
		}
	}

	@Override
	public void setParameter(final PreparedStatement ps, final int i, final Object parameter, final JdbcType jdbcType) throws SQLException {
		final URL url = (URL) parameter;
		ps.setString(i, url.toString());
	}

	@Override
	public Object getResult(final ResultSet rs, final String columnName) throws SQLException {
		return convertToURL(rs.getString(columnName));
	}

	@Override
	public Object getResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		return convertToURL(cs.getString(columnIndex));
	}

}
