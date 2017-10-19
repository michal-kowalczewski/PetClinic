package com.petclinic.type;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DisplayTypes {
	TypeDAO typeDAO = new TypeDAO();
	Type type = new Type();
	ArrayList<Type> types;
	int typeId;

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public void setType(int typeId, String typeName) {
		type.setTypeId(typeId);
		type.setTypeName(typeName);
	}

	public void setTypes(ArrayList<Type> types) {
		this.types = types;
	}

	public List<Type> getTypes() {

		List<Type> types = new ArrayList<Type>();
		types = typeDAO.getAll();
		return types;
	}
	
	public Type getType() {
		return type;
	}
	public int getTypeId() {
		return type.getTypeId();
	}
}
