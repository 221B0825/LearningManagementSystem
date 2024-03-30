package domain;

public enum Path {
	
	DATA_ROOT("data\\lecture\\root.txt"),
	DATA_LECTURE("data\\lecture\\"),
    USER_ICON("assets\\icons\\userIcon.png"),
    BANNER_IMAGE_1("assets\\banners\\banner1.png"),
	BANNER_IMAGE_2("assets\\banners\\banner2.png"),
	BANNER_IMAGE_3("assets\\banners\\banner3.png");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
    
}
