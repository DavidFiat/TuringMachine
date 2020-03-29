package ui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.*;

public class Main {

	private static Machine turin;

	public Main() {

	}

	public static void main(String[] args) throws IOException {
		long t1 = System.currentTimeMillis();

		Main m = new Main();
		m.readAll();
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

	}

	public void readAll() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/in_turing.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data/Output.txt"));
		turin = new Machine();

		while (br.readLine() != null) {
			String a = br.readLine();
			int instructions = a.length();
			for (int i = 0; i < instructions; i++) {

				char option = a.charAt(i);

				switch (option) {

				case (48):
					i++;
					if (a.charAt(i) == 48) {
						bw.write(turin.c0Read() + "\n");

					} else if (a.charAt(i) == 49) {
						i++;
						turin.c0Add("" + a.charAt(i));

					} else if (a.charAt(i) == 50) {
						turin.c0Remove();

					}
					break;

				case (49):
					i++;
					if (a.charAt(i) == 48) {
						bw.write(turin.c1Read() + "\n");

					} else if (a.charAt(i) == 49) {
						i++;
						turin.c1Add("" + a.charAt(i));

					} else if (a.charAt(i) == 50) {
						turin.c1Remove();

					}
					break;
				case (50):
					i++;
					if (a.charAt(i) == 48) {
						bw.write(turin.c2Read() + "\n");

					} else if (a.charAt(i) == 49) {
						i++;
						turin.c2Add("" + a.charAt(i));
					} else if (a.charAt(i) == 50) {
						turin.c2Remove();

					}
					break;
				}

			}

		}
		br.close();
		bw.close();
	}
}
