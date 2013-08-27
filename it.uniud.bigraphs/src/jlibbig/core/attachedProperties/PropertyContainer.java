package jlibbig.core.attachedProperties;

import java.util.*;

public class PropertyContainer implements PropertyTarget{
	private final Map<String,Property<?>> props = new HashMap<>();

	/* (non-Javadoc)
	 * @see jlibbig.core.AttachedPropertyTarget#attachProperty(jlibbig.core.AttachedProperty)
	 */
	@Override
	public Property<?> attachProperty(Property<?> prop) {
		prop.onAttach(this);
		return this.props.put(prop.getName(), prop);
	}

	/* (non-Javadoc)
	 * @see jlibbig.core.AttachedPropertyTarget#detachProperty(jlibbig.core.AttachedProperty)
	 */
	@Override
	public Property<?> detachProperty(Property<?> prop) {
		prop.onDetach(this);
		return props.remove(prop.getName());
	}

	/* (non-Javadoc)
	 * @see jlibbig.core.AttachedPropertyTarget#detachProperty(java.lang.String)
	 */
	@Override
	public Property<?> detachProperty(String name) {
		return detachProperty(props.get(name)); 
	}

	/* (non-Javadoc)
	 * @see jlibbig.core.AttachedPropertyTarget#getProperty(java.lang.String)
	 */
	@Override
	public Property<?> getProperty(String name) {
		return props.get(name);
	}

}
