package de.nosebrain.mybatis;

import static de.nosebrain.util.ValidationUtils.present;

import java.util.LinkedList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

/**
 * 
 * @author nosebrain
 *
 */
public final class MyBatisUtils {
	private MyBatisUtils() {}

	/**
	 * 
	 * @param session
	 * @param statement
	 * @param parameter
	 * @return {@link SqlSession#selectList(String, Object)}
	 */
	public static <T> List<T> selectList(final SqlSession session, final String statement, final Object parameter) {
		final List<T> selectList = session.selectList(statement, parameter);
		return !present(selectList) ? new LinkedList<T>() : selectList;
	}

	/**
	 * 
	 * @param session
	 * @param statement
	 * @return {@link SqlSession#selectList(String)}
	 */
	public static <T> List<T> selectList(final SqlSession session, final String statement) {
		return selectList(session, statement, null);
	}

	/**
	 * 
	 * @param session
	 * @param statement
	 * @param param
	 * @return {@link SqlSession#selectOne(String, Object)}
	 */
	public static <T> T selectOne(final SqlSession session, final String statement, final Object param) {
		return session.<T>selectOne(statement, param);
	}

	/**
	 * 
	 * @param session
	 * @param statement
	 * @return {@link SqlSession#selectOne(String)}
	 */
	public static <T> T selectOne(final SqlSession session, final String statement) {
		return selectOne(session, statement, null);
	}
}
