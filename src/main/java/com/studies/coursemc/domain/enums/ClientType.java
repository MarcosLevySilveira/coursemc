package com.studies.coursemc.domain.enums;

public enum ClientType {

	PERSON(1, "Person Client"),
	COMPANY(2, "Company Client");
	
	
	private int cod;
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String description() {
		return description;
	}
	
	public static ClientType toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		for (ClientType x : ClientType.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid ID: " + cod );
		
	}
	
}
