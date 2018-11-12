package _04_HangMan;

import java.awt.event.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

public class HangMan {
	// FIXME Fix bug that makes you lose life if letter is in word, but only if the previous letter was wrong
	// FIXME Fix share button
	public static String hangmanURL = "mailto:hangman@example.com?subject=Look%20at%20my%20Hangman%20score!&body=Look%20at%20my%20Hangman%20score!%20It's%20";
	public static int origLives = 15;
	
	public int score;
	public int lives;
	public int words;
	public Stack<String> dict;
	public String word;
	public ArrayList<Character> charsTried;
	
	public HangMan() {
		lives = origLives;
		try {
			words = Integer.parseInt(JOptionPane.showInputDialog("Hey cool surfie dude man, like,\n how many words do you wanna\n guess, ya know?"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ya crashed me! You villian! Wah!\n I'm gonna get you for that!\n Well anyway I'll just say ya\n said 5.");
			words = 5;
		}
		
		dict = new Stack<String>();
		for (int i = 0; i < Math.min(words, Utilities.getTotalWordsInFile("dictionary.txt")); i++) {
			String randomWord = Utilities.readRandomLineFromFile("dictionary.txt");
			while (dict.contains(randomWord)) {
				randomWord = Utilities.readRandomLineFromFile("dictionary.txt");
				System.out.println(randomWord);
			}
			
			dict.push(randomWord);
		}
		
		word = "n";
		charsTried = new ArrayList<Character>();
	}
	
	public static void main(String[] args) {
		HangMan game = new HangMan();
		
		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JLabel label = new JLabel();
		panel.add(label);
		
		JLabel timeElapsed = new JLabel();
		panel.add(timeElapsed);
		frame.setVisible(true);
		
		JButton shareScore = new JButton("Share your score");
		shareScore.setVisible(false);
		shareScore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 try {
					java.awt.Desktop.getDesktop().browse(new URI(hangmanURL + game.score + "!"));
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		
		panel.add(shareScore);
		
		frame.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				
			}
			
			
			@SuppressWarnings("deprecation")
			public void keyPressed(KeyEvent e) {
				for (int i = 0; i < game.word.length(); i++) {
					char c = game.word.charAt(i);
					if (game.charsTried.contains(e.getKeyChar())) {
						// If the character was already tried
						break;
					} else {
						// If the character was not already tried
						if (c == e.getKeyChar()) {
							// If the character is the letter in the word
							label.setText(label.getText().substring(0, i) + c + label.getText().substring(i+1));
						} else if (i == game.word.length()-1) {
							// If the character is not the letter in the word, and the letter is the last letter
							game.lives--;
							game.charsTried.add(e.getKeyChar());
						}
						
						if (i == game.word.length()-1) {
							// If the  letter is the last letter
							game.charsTried.add(e.getKeyChar());
						}
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		
		int dictionaryPages = game.dict.size();
		for (int i = 0; i < dictionaryPages; i++) {
			game.lives = origLives;
			game.word = game.dict.pop();
			long time = System.currentTimeMillis();
			
			label.setText("");
			for (int j = 0; j < game.word.length(); j++) {
				label.setText(label.getText()+"_");
			}
			
			while (label.getText().contains("_")) {
				if (game.lives < 0) {
					JOptionPane.showMessageDialog(null, "Sorry! You're outta lives.\n The word was: srwrxnierpoznép! Just kidding.\n It was actually "+game.word+".");
					break;
				}
				
				if (System.currentTimeMillis()-time >= 100) {
					timeElapsed.setText("Time: "+(System.currentTimeMillis()-time)/100+" Lives: "+game.lives);
				}
			}
			
			if (game.lives >= 0) {
				JOptionPane.showMessageDialog(null, "Got it right, dude cool surfer!\n The word WAS INDEED "+game.word+"!!!");
			}
			game.charsTried.clear();
		}
		
		shareScore.setVisible(true);
	}
}
