package _06_overloading;

import java.awt.Color;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		LeagueOptionPane a = new LeagueOptionPane();
		a.showMessageDialog("hi");
		a.showMessageDialog("bye", "Kentucky");
		a.showMessageDialog("Yolo", "Texas", "java.png");
		a.showMessageDialog("joe", "hi", "example.png", Color.GREEN);
	}
}
