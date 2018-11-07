// HangMan
package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.*;

public class HangMan {
	//"mailto:hangman@example.com?subject=Look at my Hangman score!&body=Look at my Hangman score! It's " + score
	//Fix bug that makes you guess a limit of 2 words
	public static int origLives = 15;
	
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
		
		frame.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				
			}
			
			
			public void keyPressed(KeyEvent e) {
				for (int i = 0; i < game.word.length(); i++) {
					char c = game.word.charAt(i);
					if (c == e.getKeyChar()) {
						label.setText(label.getText().substring(0, i) + c + label.getText().substring(i+1));
					} else if (!game.charsTried.contains(e.getKeyChar())) {
						game.lives--;
						game.charsTried.add(e.getKeyChar());
					}
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		
		for (int i = 0; i < game.dict.size(); i++) {
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
		
	}
}
