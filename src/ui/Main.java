package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.*;

public class Main {

	private Machine turin;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("data/in_turing.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/Output.txt"));
		while (br.readLine() != null) {
			String a = br.readLine();
			int instructions = a.length();
			for (int i = 0; i < instructions; i++) {

			}

		}

	}
}
