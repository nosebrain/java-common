package de.nosebrain.spring.beans;

import org.springframework.beans.factory.FactoryBean;

import org.mongodb.morphia.Morphia;

/**
 * 
 * @author nosebrain
 *
 */
public class MorphiaFactoryBean implements FactoryBean<Morphia> {

	private String packageName;

	@Override
	public Morphia getObject() throws Exception {
		final Morphia morphia = new Morphia();
		if (!"".equals(this.packageName)) {
			morphia.mapPackage(this.packageName);
		}
		return morphia;
	}

	@Override
	public Class<?> getObjectType() {
		return Morphia.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(final String packageName) {
		this.packageName = packageName;
	}
}
