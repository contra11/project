package rhythm_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	
	private Image noteLineImage = new ImageIcon(Main.class.getResource("../image/noteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../image/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../image/gameInfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	private Image flareImage;
	private Image judgeImage;
	
	private String titleName;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String musicTitle) {
		this.titleName = titleName;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 240, 0, null);
		g.drawImage(noteRouteDImage, 341, 0, null);
		g.drawImage(noteRouteFImage, 442, 0, null);
		g.drawImage(noteRouteSpace1Image, 543, 0, null);
		g.drawImage(noteRouteSpace2Image, 640, 0, null);
		g.drawImage(noteRouteJImage, 741, 0, null);
		g.drawImage(noteRouteKImage, 842, 0, null);
		g.drawImage(noteRouteLImage, 943, 0, null);
		g.drawImage(noteLineImage, 236, 0, null);
		g.drawImage(noteLineImage, 337, 0, null);
		g.drawImage(noteLineImage, 438, 0, null);
		g.drawImage(noteLineImage, 539, 0, null);
		g.drawImage(noteLineImage, 737, 0, null);
		g.drawImage(noteLineImage, 838, 0, null);
		g.drawImage(noteLineImage, 939, 0, null);
		g.drawImage(noteLineImage, 1040, 0, null);
		for(int i=0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../image/miss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
		}
		g.drawImage(judgementLineImage, 240, 580, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 30, 702);
		g.drawString("Good luck!!", 1090, 702);
		g.setColor(Color.BLACK);
		g.drawString("S", 279, 610);
		g.drawString("D", 380, 610);
		g.drawString("F", 481, 610);
		g.drawString("Space", 595, 610);
		g.drawString("J", 780, 610);
		g.drawString("K", 881, 610);
		g.drawString("L", 982, 610);
		g.drawImage(flareImage, 440, 370, null);
		g.drawImage(judgeImage, 465, 420, null);
	}
	
	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../image/notePressed.png")).getImage();
	}
	
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../image/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		
		if(titleName.equals("MoonMoon - Paint")) {
			int startTime = 3500 - Main.REACH_TIME * 1000;
			int gap = 120;
			beats = new Beat[] {
					new Beat(startTime + gap * 1, "S"),
					new Beat(startTime + gap * 4, "D"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 9, "F"),
					new Beat(startTime + gap * 11, "J"),
					new Beat(startTime + gap * 14, "K"),
					new Beat(startTime + gap * 23, "S"),
					new Beat(startTime + gap * 25, "D"),
					new Beat(startTime + gap * 27, "F"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 42, "F"),
					new Beat(startTime + gap * 45, "D"),
					new Beat(startTime + gap * 48, "F"),
					new Beat(startTime + gap * 51, "L"),
					new Beat(startTime + gap * 54, "J"),
					new Beat(startTime + gap * 56, "Space"),
					new Beat(startTime + gap * 63, "J"),
					new Beat(startTime + gap * 66, "K"),
					new Beat(startTime + gap * 74, "F"),
					new Beat(startTime + gap * 77, "D"),
					new Beat(startTime + gap * 79, "F"),
					new Beat(startTime + gap * 82, "D"),
					new Beat(startTime + gap * 85, "K"),
					new Beat(startTime + gap * 87, "L"),
					new Beat(startTime + gap * 90, "D"),
					new Beat(startTime + gap * 92, "S"),
					new Beat(startTime + gap * 96, "J"),
					new Beat(startTime + gap * 98, "F"),
					new Beat(startTime + gap * 106, "Space"),
					new Beat(startTime + gap * 109, "J"),
					new Beat(startTime + gap * 111, "K"),
					new Beat(startTime + gap * 113, "L"),
					new Beat(startTime + gap * 116, "Space"),
					new Beat(startTime + gap * 127, "Space"),
					new Beat(startTime + gap * 130, "F"),
					new Beat(startTime + gap * 132, "D"),
					new Beat(startTime + gap * 135, "S"),
					new Beat(startTime + gap * 137, "Space"),
					new Beat(startTime + gap * 140, "Space"),
					new Beat(startTime + gap * 148, "D"),
					new Beat(startTime + gap * 150, "S"),
					new Beat(startTime + gap * 158, "L"),
					new Beat(startTime + gap * 161, "K"),
					new Beat(startTime + gap * 163, "J"),
					new Beat(startTime + gap * 165, "F"),
					new Beat(startTime + gap * 168, "D"),
					new Beat(startTime + gap * 171, "S"),
					new Beat(startTime + gap * 173, "J"),
					new Beat(startTime + gap * 176, "L"),
					new Beat(startTime + gap * 179, "D"),
					new Beat(startTime + gap * 182, "Space"),
			};
		}
		else if(titleName.equals("TWICE - LIKEY")) {
			int startTime = 3300 - Main.REACH_TIME * 1000;
			int gap = 120;
			beats = new Beat[] {
					new Beat(startTime + gap * 1, "Space"),
					new Beat(startTime + gap * 5, "S"),
					new Beat(startTime + gap * 5, "J"),
					new Beat(startTime + gap * 15, "D"),
					new Beat(startTime + gap * 15, "K"),
					new Beat(startTime + gap * 17, "F"),
					new Beat(startTime + gap * 17, "L"),
					new Beat(startTime + gap * 25, "F"),
					new Beat(startTime + gap * 25, "L"),
					new Beat(startTime + gap * 31, "S"),
					new Beat(startTime + gap * 31, "F"),
					new Beat(startTime + gap * 31, "J"),
					new Beat(startTime + gap * 31, "L"),
					new Beat(startTime + gap * 36, "Space"),
					new Beat(startTime + gap * 47, "D"),
					new Beat(startTime + gap * 47, "L"),
					new Beat(startTime + gap * 48, "S"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 65, "Space"),
					new Beat(startTime + gap * 69, "Space"),
					new Beat(startTime + gap * 71, "Space"),
					new Beat(startTime + gap * 74, "D"),
					new Beat(startTime + gap * 74, "K"),
					new Beat(startTime + gap * 76, "D"),
					new Beat(startTime + gap * 76, "J"),
					new Beat(startTime + gap * 78, "D"),
					new Beat(startTime + gap * 78, "Space"),
					new Beat(startTime + gap * 80, "D"),
					new Beat(startTime + gap * 80, "L"),
					new Beat(startTime + gap * 88, "L"),
					new Beat(startTime + gap * 90, "D"),
					new Beat(startTime + gap * 92, "S"),
					new Beat(startTime + gap * 94, "K"),
					new Beat(startTime + gap * 96, "L"),
					new Beat(startTime + gap * 97, "K"),
					new Beat(startTime + gap * 98, "J"),
					new Beat(startTime + gap * 100, "S"),
					new Beat(startTime + gap * 101, "D"),
					new Beat(startTime + gap * 102, "F"),
					new Beat(startTime + gap * 104, "L"),
					new Beat(startTime + gap * 105, "K"),
					new Beat(startTime + gap * 106, "J"),
					new Beat(startTime + gap * 108, "S"),
					new Beat(startTime + gap * 109, "D"),
					new Beat(startTime + gap * 110, "F"),
					new Beat(startTime + gap * 111, "L"),
					new Beat(startTime + gap * 112, "K"),
					new Beat(startTime + gap * 113, "J"),
					new Beat(startTime + gap * 117, "Space"),
					new Beat(startTime + gap * 119, "S"),
					new Beat(startTime + gap * 120, "D"),
					new Beat(startTime + gap * 121, "F"),
					new Beat(startTime + gap * 123, "L"),
					new Beat(startTime + gap * 124, "K"),
					new Beat(startTime + gap * 125, "J"),
					new Beat(startTime + gap * 126, "S"),
					new Beat(startTime + gap * 127, "D"),
					new Beat(startTime + gap * 128, "F"),
					new Beat(startTime + gap * 135, "S"),
					new Beat(startTime + gap * 135, "F"),
					new Beat(startTime + gap * 135, "J"),
					new Beat(startTime + gap * 135, "L"),
					new Beat(startTime + gap * 137, "D"),
					new Beat(startTime + gap * 137, "K"),
					new Beat(startTime + gap * 137, "Space"),
					new Beat(startTime + gap * 139, "S"),
					new Beat(startTime + gap * 139, "F"),
					new Beat(startTime + gap * 139, "J"),
					new Beat(startTime + gap * 139, "L"),
					new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 153, "Space"),
			};
		}
		else if(titleName.equals("Pop Etc - Fingerprints")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i=0; i<noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			flareImage = new ImageIcon(Main.class.getResource("../image/flare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../image/miss.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../image/late.png")).getImage();
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../image/good.png")).getImage();
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../image/great.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../image/perfect.png")).getImage();
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../image/early.png")).getImage();
		}
	}
	
}