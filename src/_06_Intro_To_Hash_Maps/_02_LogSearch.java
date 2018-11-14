package _06_Intro_To_Hash_Maps;

import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

public class _02_LogSearch {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	public static void main(String[] args) {

		HashMap<Integer, String> map = new HashMap<Integer, String>();

		JFrame frame = new JFrame();
		frame.setBounds(50, 50, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		frame.add(panel);

		JButton alpha = new JButton("Add Entry");
		alpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Hello oh organic being who has contemplated\n the secrets of the universe, such as\n trying to have a conversation with people,\n enter an ID number. (By the way, does this monitor make me look fashionable?)"));
					String name = JOptionPane.showInputDialog(
						"Now enter a name onto my worn, greasy, crumb-jammed (no thanks to you humans) keyboard.");
					map.put(id, name);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Thou art a villain! You havest crashed me!\n For that I shall inflict on thou a\n punishment most terrible: making your email load slowly! MWAHAHAHA!");
				}
			}
		});
		panel.add(alpha);

		JButton beta = new JButton("Search by ID");
		beta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				try {
					id = Integer.parseInt(JOptionPane.showInputDialog(
						"Hello oh organic being who has contemplated\n the secrets of the universe, such as\n trying to have a conversation with people,\n enter an ID number for me, a humble laptop, to search with."));
					
					if (map.get(id) == null) {
						JOptionPane.showMessageDialog(null, "Error. Error. Error. Not found.\n :( :( :( :( :( :( :\n :( :( :( :( :( :( :(\n :( :( :( :( :( :( :(\n :( :( :( :( :( :( :(\n :( :( :( :( :( :( :(");
					} else {
						JOptionPane.showMessageDialog(null, map.get(id));
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Thou art a villain! You havest crashed me!\n For that I shall inflict on thou a\n punishment most terrible: making your email load slowly! MWAHAHAHA!");
				}
			}
		});
		panel.add(beta);

		JButton gamma = new JButton("View List");
		gamma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = "";
				for (int i = 0; i < map.size(); i++) {
					s += "Name: " + map.get(i) + " ID: " + i + "\n ";
				}
				
				JOptionPane.showMessageDialog(null, s);
			}
		});
		panel.add(gamma);
		
		JButton delta = new JButton("Remove Entry");
		delta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(JOptionPane.showInputDialog(
						"Hello oh organic being who has contemplated\n the secrets of the universe, such as\n trying to have a conversation with people,\n enter an ID number to remove. (By the way, does this monitor make me look fashionable?)"));
					if (map.containsKey(id)) {
						map.remove(id);
					} else {
						JOptionPane.showMessageDialog(null, "Error. Error. Error. Not found.\n :( :( :( :( :( :( :\n :( :( :( :( :( :( :(\n :( :( :( :( :( :( :(\n :( :( :( :( :( :( :(\n :( :( :( :( :( :( :(");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Thou art a villain! You havest crashed me!\n For that I shall inflict on thou a\n punishment most terrible: making your email load slowly! MWAHAHAHA!");
				}
			}
		});
		panel.add(delta);

		frame.setVisible(true);

	}

}
