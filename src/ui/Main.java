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

				int option = a.charAt(i);

				switch (option) {

				case (0):
					i++;
					if (a.charAt(i) == 0) {
						bw.write(turin.c0Read());
						break;

					} else if (a.charAt(i) == 1) {
						i++;
						turin.c0Add("" + a.charAt(i));
						break;
					} else if (a.charAt(i) == 2) {
						turin.c0Remove();
						break;

					}

				case (1):
					i++;
					if (a.charAt(i) == 0) {
						bw.write(turin.c1Read());
						break;

					} else if (a.charAt(i) == 1) {
						i++;
						turin.c1Add("" + a.charAt(i));
						break;
					} else if (a.charAt(i) == 2) {
						turin.c1Remove();
						break;

					}
				case (2):
					i++;
					if (a.charAt(i) == 0) {
						bw.write(turin.c2Read());
						break;

					} else if (a.charAt(i) == 1) {
						i++;
						turin.c2Add("" + a.charAt(i));
						break;
					} else if (a.charAt(i) == 2) {
						turin.c2Remove();
						break;

					}
				}

			}

		}
		br.close();
		bw.close();
	}
}
