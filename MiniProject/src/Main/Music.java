package Main;


import javazoom.jl.player.MP3Player;

public class Music {

<<<<<<< HEAD
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
=======
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
>>>>>>> 1480cc793c25309f5038ed96a2ede8603320304c
