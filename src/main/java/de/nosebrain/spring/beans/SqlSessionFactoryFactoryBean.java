package de.nosebrain.spring.beans;

import java.io.InputStreamReader;
import java.io.Reader;

import javax.sql.DataSource;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

/**
 * 
 * @author nosebrain
 */
public class SqlSessionFactoryFactoryBean implements FactoryBean<SqlSessionFactory> {

	private Resource configLocation;
	private DataSource dataSource;

	private String environment = "production";
	private Class<? extends TransactionFactory> transactionFactoryClass = JdbcTransactionFactory.class;

	@Override
	public SqlSessionFactory getObject() throws Exception {
		final Reader reader = new InputStreamReader(this.configLocation.getInputStream());
		// Null environment causes the configuration to use the default.
		// This will be overwritten below regardless.
		final XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(reader, null, null);
		final Configuration configuration = xmlConfigBuilder.parse();

		final TransactionFactory transactionFactory = this.transactionFactoryClass.newInstance();

		final Environment env = new Environment(this.environment, transactionFactory, this.dataSource);
		configuration.setEnvironment(env);

		final SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(configuration);
	}

	@Override
	public Class<?> getObjectType() {
		return SqlSessionFactory.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(final String environment) {
		this.environment = environment;
	}

	/**
	 * @param configLocation the configLocation to set
	 */
	public void setConfigLocation(final Resource configLocation) {
		this.configLocation = configLocation;
	}

	/**
	 * @param transactionFactoryClass the transactionFactoryClass to set
	 */
	public void setTransactionFactoryClass(final Class<? extends TransactionFactory> transactionFactoryClass) {
		this.transactionFactoryClass = transactionFactoryClass;
	}

	/**
	 * @param dataSource the dataSource to set
	 */
	public void setDataSource(final DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
