import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;

class BackgroundFrame extends JFrame {
	public BackgroundFrame() {
		this.setTitle("Arena");
		this.setSize(400,400);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackgroundImage(getBackgroundFromLevel("default"));
		this.addCharacter();
	}
	
	public BackgroundFrame(String level) {
		this.setTitle(level + "Arena");
		this.setSize(400,400);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBackgroundImage(getBackgroundFromLevel(level));
		this.addCharacter();
	}
	
	private String getBackgroundFromLevel(String level) {
		String background;
		switch (level) {
			default: 
				background = "gfx/backgrounds/default.png";
				break;
			case "L1":
				background = "gfx/backgrounds/map_01.png";
				break;
			case "L2":
				background = "gfx/backgrounds/map_02.png";
				break;
			case "L3":
				background = "gfx/backgrounds/map_03.png";
				break;
		}
		
		return background;
	}
	
	private void setBackgroundImage(String img) {
		try {
			this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(img)))));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void addCharacter() {
		try {
			JPanel panel = new JPanel();
			JLabel label = new JLabel(new ImageIcon(ImageIO.read(new File("gfx/characters/default.png"))));
			panel.add(label);
			this.add(panel);
			this.getContentPane().add(label);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}