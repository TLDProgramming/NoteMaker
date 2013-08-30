package com.github.thelonedevil.NoteMaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainWindow extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7939012021918971526L;
	JPanel pnl = new JPanel();
	JButton close = new JButton("Close");
	JButton newnote = new JButton("New Note");
	JButton refresh = new JButton("Refresh");
	JTextArea notes = new JTextArea(20, 37);
	JScrollPane spnl = new JScrollPane(notes);

	public MainWindow() {
		super("Note Maker");
		setSize(500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(pnl);
		pnl.add(spnl);
		pnl.add(close);
		pnl.add(newnote);
		pnl.add(refresh);
		setVisible(true);
		close.addActionListener(this);
		newnote.addActionListener(this);
		refresh.addActionListener(this);
		notes.setEditable(false);
		notes.setLineWrap(true);
		notes.setWrapStyleWord(true);
		notes.setText(App.getNotes());
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if ( source == close) {
			System.exit(0);
		} else if (source == newnote){
			AddNoteWindow note = new AddNoteWindow();
			
		}else if(source == refresh){
			notes.setText(App.getNotes());
		}
	}

}
