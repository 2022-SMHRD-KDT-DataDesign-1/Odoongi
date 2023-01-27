package Main;


import javazoom.jl.player.MP3Player;

public class Music {

	private String musicPath;

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	MP3Player player = new MP3Player();

	public Music(String musicPath) {
        super();
        this.musicPath = musicPath;
	}

	// 재생기능
	public void play(String s) {
		player.play(s);
		
	}

	// 정지 기능
	public void stop() {
		player.stop();
	}

}

