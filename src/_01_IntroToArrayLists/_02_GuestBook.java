package _01_IntroToArrayLists;

import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook {
	

	public static void main(String[] args) {
		ArrayList<String> guestList = new ArrayList<String>();
		// Create a GUI with two buttons. One button reads "Add Name" and the other
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		// button reads "View Names".
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		// When the add name button is clicked, display an input dialog that asks the
		// user to enter a name. Add
		// that name to an ArrayList.
		JButton add = new JButton("Add name");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guestList.add(JOptionPane.showInputDialog(
							"Invite a guest to the party,\n O kinda-great organic form of life.\n (Type his/her/zer/their name in.)"));
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Villian! You havest crashest me! >:(");
				}
			}
		});
		
		panel.add(add);
		// When the "View Names" button is clicked, display a
		// message dialog that displays
		// all the names added to the list. Format the list as follows:
		// Guest #1: Bob Banders
		// Guest #2: Sandy Summers
		// Guest #3: Greg Ganders
		// Guest #4: Donny Doners
		JButton view = new JButton("View guest list");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"O kinda-great organic form of life,\n who needs me to present thy guest list\n 'cause Post-Its are sooo last petasecond,\n here's your guest list. (Click OK to see list.)");
				String guestString = "";

				for (int i = 0; i < guestList.size(); i++) {
					guestString += "Guest #" + (i+1) + ": " + guestList.get(i) + "\n ";
				}
				JOptionPane.showMessageDialog(null, guestString);
			}
		});
		
		panel.add(view);
		
		frame.pack();
		frame.setVisible(true);
	}
}
