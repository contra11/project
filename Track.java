package rhythm_game;

public class Track {

	private String titleImage; // Á¦¸ñ ÀÌ¹ÌÁö
	private String startImage; // À½¾Ç ¼±ÅÃ Ã¢ ÀÌ¹ÌÁö
	private String gameImage; // À½¾Ç ½ÇÇà½Ã °ÔÀÓ ÀÌ¹ÌÁö
	private String startMusic; // À½¾Ç ¼±ÅÃ Ã¢ bgm
	private String gameMusic; // °ÔÀÓ ÇØ´ç °î À½¾Ç
	private String titleName; // °î Á¦¸ñ
	
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	public String getTitleName() {
		return titleName;
	}
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}
	
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic, String titleName) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
		this.titleName = titleName;
	}
	
}
