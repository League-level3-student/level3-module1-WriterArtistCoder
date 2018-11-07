package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.*;

public class _02_TextUndoRedo {
	
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	public static void main(String[] args) {
		Stack<Character> deleted = new Stack<Character>();
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(50, 50, 250, 100);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		
		JLabel label = new JLabel("abcdefghijklmnopqrstuvwxyz");
		panel.add(label);

		frame.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {
				
			}

			public void keyPressed(KeyEvent e) {
				switch (e.getKeyChar()) {
				case '\b':
					try {
						deleted.push(label.getText().charAt(label.getText().length()-1));
						label.setText(label.getText().substring(0, label.getText().length()-1));
					} catch (Exception ex) {
						
					}
					break;
				case '\\':
					if (deleted.size() > 0) {
						label.setText(label.getText()+deleted.pop());
					}
					break;
				default:
					label.setText(label.getText()+e.getKeyChar());
					break;
				}
			}

			public void keyReleased(KeyEvent e) {
				
			}
			
		});
		frame.setVisible(true);
	}
	
}
