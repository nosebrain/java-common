package de.nosebrain.spring.beans.factory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.Resource;

/**
 * 
 * @author nosebrain
 */
public class SqlSessionFactoryBean implements FactoryBean<SqlSessionFactory> {

	private SqlSessionFactory factory;
	private String environment;
	private Properties props;
	private Resource configLocation;
	
	/**
	 * @param configLocation the configLocation to set
	 */
	public void setConfigLocation(Resource configLocation) {
		this.configLocation = configLocation;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(Properties props) {
		this.props = props;
	}

	/**
	 * @param environment the environment to set
	 */
	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	@Override
	public SqlSessionFactory getObject() throws Exception {
		if (this.factory == null) {
			this.factory = this.buildFactoryBean();
		}
		
		return this.factory;
	}

	private SqlSessionFactory buildFactoryBean() throws IOException {
		final Reader reader = new InputStreamReader(this.configLocation.getInputStream());
		final SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		return builder.build(reader, this.environment, this.props);
	}

	@Override
	public Class<?> getObjectType() {
		return SqlSessionFactory.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

}
