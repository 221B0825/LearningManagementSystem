package domain;

public enum Attributes {
	
	COMMON_WIDTH(675),
	BANNER_HEIGHT(128),
	LECTURE_HEIGHT(300),
	DELAY_TIME(3000),
	MOVE_DELAY_TIME(20),
	SLIDE_SPEED(12);
	
	private final int attribute;
	
	private Attributes(int attribute) {
		this.attribute = attribute;
	}
	
	public int getValue() {
		return attribute;
	}

}
