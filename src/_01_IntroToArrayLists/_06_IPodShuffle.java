package _01_IntroToArrayLists;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;
import javax.swing.SortingFocusTraversalPolicy;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle{
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
		//new Song("demo.mp3").play();				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
		ArrayList<Song> songs = new ArrayList<Song>(Arrays.asList(new Song[]{new Song("demo.mp3"), new Song("dem-bones.mp3")}));
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton surprise = new JButton("Click repeatedly fast to launch fireworks");
		surprise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				songs.get(new Random().nextInt(songs.size())).play();
			}
		});
		frame.add(surprise);
		frame.pack();
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}
}