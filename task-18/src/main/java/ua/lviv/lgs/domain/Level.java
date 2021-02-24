package ua.lviv.lgs.domain;

public enum Level {
	L1("L1"),
	L2("L2"),
	L3("L3"),
	L4("L4"),
	L5("L5");
	
	private final String name;
	
	Level(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
