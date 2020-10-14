package com.solid.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
	private List<String> entries = new ArrayList<>();
	private static int count = 0;

	public void addEntry(String text) {
		entries.add("" + (++count) + ":" + text);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	// Here we break the SRP as we are making god object which is anti pattern
	// Journal Class - Giving multiple responsibilities
	public void save(String filename) throws FileNotFoundException {

		try (PrintStream out = new PrintStream(filename)) {
			out.println(toString());
		}

	}

	public void load(String file) {
	}

	public void load(URL url) {
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}
}

class Persistence {

	public void save(Journal journal, String filename, boolean isOverride) throws FileNotFoundException {

		if (isOverride || new File(filename).exists()) {
			try (PrintStream out = new PrintStream(filename)) {
				out.println(journal.toString());
			}
		}
	}

	public void load(String file) {
	}

	public void load(URL url) {
	}

}

public class SRPDemo {

	public static void main(String[] args) throws IOException {
		Journal journal = new Journal();
		journal.addEntry("I cried today");
		journal.addEntry("I ate today");

		System.out.println(journal.toString());
		String filename = "E:\\Workspaces\\design-patterns\\journal.txt";
		Persistence persistence = new Persistence();
		persistence.save(journal, filename, true);

		// windows!
		Runtime.getRuntime().exec("notepad.exe " + filename);

	}

}
