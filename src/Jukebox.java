
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2018
 *    Level 1
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/* 1. Download the JavaZoom jar from here: http://bit.ly/javazoom
 * 2. Right click your project and add it as an External JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {

	/*
	 * 6. Create a user interface for your Jukebox so that the user can to choose
	 * which song to play. You can use can use a different button for each song, or
	 * a picture of the album cover. When the button or album cover is clicked, stop
	 * the currently playing song, and play the one that was selected.
	 */

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Jukebox());
		new Jukebox().createUI();
	}

	public void run() {

		// 3. Find an mp3 on your computer or on the Internet.
		// 4. Create a Song

		// 5. Play the Song
	}

	JButton leftButton = new JButton();
	JButton middleButton = new JButton();
	JButton rightButton = new JButton();

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	Song cool = new Song("Miley Cyrus - Party In The U.S.A. (Official Music Video).mp3");
	Song nice = new Song("OneRepublic - Secrets.mp3");
	Song wow = new Song("Journey - Don't Stop Believin' (Audio).mp3");

	private void createUI() {
		frame.add(panel);
		frame.setVisible(true);
		leftButton.setText("Party In The USA");
		middleButton.setText("Secrets");
		rightButton.setText("Don't Stop Beleiving");
		leftButton.addActionListener(this);
		middleButton.addActionListener(this);
		rightButton.addActionListener(this);
		panel.add(leftButton);
		panel.add(middleButton);
		panel.add(rightButton);
		frame.pack();
		frame.setTitle("Jukebox");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed == leftButton) {
			wow.stop();
			nice.stop();
			cool.play();
		} else if (buttonPressed == middleButton) {
			cool.stop();
			wow.stop();
			nice.play();
		}
		if (buttonPressed == rightButton) {
			cool.stop();
			nice.stop();
			wow.play();
		}

	}
}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}
