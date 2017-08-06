package de.nosebrain.spring.beans;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.FactoryBean;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * 
 * @author nosebrain
 */
public class MorphiaDatastoreFactoryBean implements FactoryBean<Datastore>{

	private MongoClient mongoClient;
	private Morphia morphia;

	private String databaseName;

	@Override
	public Datastore getObject() throws Exception {
		return this.morphia.createDatastore(this.mongoClient, this.databaseName);
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
	 * @param mongoClient the mongoClient to set
	 */
	public void setMongoClient(final MongoClient mongoClient) {
		this.mongoClient = mongoClient;
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
