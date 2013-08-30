package com.github.thelonedevil.NoteMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AddNoteWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8904406469651901527L;
	JPanel pnl = new JPanel();
	JTextArea note = new JTextArea(20, 37);
	JScrollPane spnl = new JScrollPane(note);
	JButton accept = new JButton("Accept");
	JButton cancel = new JButton("Cancel");

	public AddNoteWindow() {
		super("Add Note");
		setSize(500, 500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		add(pnl);
		note.setLineWrap(true);
		note.setWrapStyleWord(true);
		spnl.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnl.add(spnl);
		pnl.add(cancel);
		pnl.add(accept);
		accept.addActionListener(this);
		cancel.addActionListener(this);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == accept){
			App.notes.add(note.getText());
			App.saveNotes();
			this.dispose();
		}else if(source == cancel){
			this.dispose();
			
		}
		
	}

}
