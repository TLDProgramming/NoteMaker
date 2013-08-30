package com.github.thelonedevil.NoteMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 * 
 */
public class App {
	static List<String> notes = new ArrayList<String>();
	static File file = new File("notes.txt");

	public static void main(String[] args) {
		loadNotes();
		MainWindow gui = new MainWindow();
		saveNotes();
	}

	static String getNotes() {
		String note = "";
		int size = notes.size();
		int index = 0;
		while (index < size) {
			note = note + "\n" + notes.get(index);
			index++;
		}
		return note;

	}

	static void loadNotes() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));

			String line;

			while ((line = br.readLine()) != null) {
				notes.add(line);
			}

			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void saveNotes() {

		PrintStream out;
		try {
			out = new PrintStream(file);

			int size = notes.size();
			int index = 0;
			while (index < size) {
				out.println(notes.get(index));
				index++;
			}
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			try {
				file.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
