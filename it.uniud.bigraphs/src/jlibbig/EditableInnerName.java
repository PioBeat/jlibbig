package jlibbig;

class EditableInnerName extends EditableLinkFacet implements InnerName, EditableNamed, EditablePoint{

	private EditableHandle handle;
	
	EditableInnerName(){}
	
	EditableInnerName(String name){
		super(name);
	}
	
	EditableInnerName(EditableHandle handle){
		setHandle(handle);
	}
	
	EditableInnerName(String name, EditableHandle handle){
		super(name);
		setHandle(handle);
	}
	
	@Override
	public EditableHandle getHandle() {
		return this.handle;
	}

	@Override
	public void setHandle(EditableHandle handle) {
		if(this.handle != null){
			if(!this.handle.equals(handle)){
				this.handle.unlinkPoint(this);
			}
		}
		this.handle = handle;
		if(handle != null){
			handle.linkPoint(this);
		}
	}

	@Override
	public EditableInnerName replicate() {
		return new EditableInnerName(this.getName());
	}
}
