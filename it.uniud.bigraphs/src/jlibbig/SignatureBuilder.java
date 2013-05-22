package jlibbig;

import java.util.*;

/**
 * Helper for signature construction. Every instance maintains a set of controls
 * which are used to instantiate signatures on demand.
 * 
 * @see Signature
 */
public class SignatureBuilder {

	private Map<String, BigraphControl> ctrls = new HashMap<>();

	/**
	 * Creates an empty builder.
	 */
	public SignatureBuilder() {
	}

	/** 
	 * Creates a signature with the control present in the builder
	 * @return a signature
	 */
	public Signature makeSignature() {
		return new Signature(ctrls.values());
	}
	
	public void put(String name, boolean active, int arity) {
		ctrls.put(name, new BGControl(name,active,arity));
	}

	public boolean contains(String name) {
		return ctrls.containsKey(name);
	}

	public BigraphControl  get(String name) {
		return ctrls.get(name);
	}

	public Collection<BigraphControl > getAll() {
		return Collections.unmodifiableCollection(ctrls.values());
	}

	public void remove(String name) {
		ctrls.remove(name);
	}

	public void clear() {
		ctrls.clear();
	}
	
	private static class BGControl extends AbstractNamed implements BigraphControl{
		private final boolean active;
		private final int arity;
				
		BGControl(String name,boolean active, int arity){
			super(name);
			this.arity = arity;
			this.active = active;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + arity;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			BGControl other = (BGControl) obj;
			if (arity != other.arity || super.getName() != other.getName())
				return false;
			return true;
		}
	
		@Override
		public String toString() {
			return getName() + ":" + arity;
		}

		@Override
		public int getArity() {
			return arity;
		}

		@Override
		public boolean isActive() {
			return active;
		}
		
	}

}
