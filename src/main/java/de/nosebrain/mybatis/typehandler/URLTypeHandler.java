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
 * {@link TypeHandler} for {@link URL}
 * @author nosebrain
 */
public class URLTypeHandler implements TypeHandler<URL> {

	private static URL convertToURL(final String string) {
		try {
			return new URL(string);
		} catch (final MalformedURLException e) {
			// TODO: log
			return null;
		}
	}

	@Override
	public void setParameter(final PreparedStatement ps, final int i, final URL parameter, final JdbcType jdbcType) throws SQLException {
		final URL url = (URL) parameter;
		ps.setString(i, url.toString());
	}

	@Override
	public URL getResult(final ResultSet rs, final String columnName) throws SQLException {
		return convertToURL(rs.getString(columnName));
	}

	@Override
	public URL getResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		return convertToURL(cs.getString(columnIndex));
	}
	
	@Override
	public URL getResult(ResultSet rs, int columnIndex) throws SQLException {
		return convertToURL(rs.getString(columnIndex));
	}
}
