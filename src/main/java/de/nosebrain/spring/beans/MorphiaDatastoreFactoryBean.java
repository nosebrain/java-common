package de.nosebrain.spring.beans;

import org.springframework.beans.factory.FactoryBean;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

/**
 * 
 * @author nosebrain
 *
 */
public class MorphiaDatastoreFactoryBean implements FactoryBean<Datastore>{

	private Mongo mongo;
	private Morphia morphia;

	private String databaseName;

	@Override
	public Datastore getObject() throws Exception {
		return this.morphia.createDatastore(this.mongo, this.databaseName);
	}

	@Override
	public Class<?> getObjectType() {
		return Datastore.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * @param mongo the mongo to set
	 */
	public void setMongo(final Mongo mongo) {
		this.mongo = mongo;
	}

	/**
	 * @param morphia the morphia to set
	 */
	public void setMorphia(final Morphia morphia) {
		this.morphia = morphia;
	}

	/**
	 * @param databaseName the databaseName to set
	 */
	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}

}
