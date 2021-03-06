package de.nosebrain.mybatis.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

/**
 * {@link TypeHandler} for {@link Locale}
 * @author nosebrain
 */
public class LocaleTypeHandler implements TypeHandler<Locale> {

	private static final Locale convertLocale(final String string) {
		return new Locale(string);
	}

	@Override
	public void setParameter(final PreparedStatement ps, final int i, final Locale parameter, final JdbcType jdbcType) throws SQLException {
		if (parameter instanceof Locale) {
			final Locale locale = (Locale) parameter;
			ps.setString(i, locale.toString());
		}
	}

	@Override
	public Locale getResult(final ResultSet rs, final String columnName) throws SQLException {
		return convertLocale(rs.getString(columnName));
	}

	@Override
	public Locale getResult(final CallableStatement cs, final int columnIndex) throws SQLException {
		return convertLocale(cs.getString(columnIndex));
	}
	
	@Override
	public Locale getResult(final ResultSet rs, final int columnIndex) throws SQLException {
		return convertLocale(rs.getString(columnIndex));
	}

}
