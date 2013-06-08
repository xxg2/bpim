package com.bpim.enums;

public enum ExcelType {
	MENWORK("人工"),
	MACHINE("机械"),
	MATERIAL("材料");
	
	private String type;
	
	ExcelType(String type) {
		this.type = type;
	}
}
