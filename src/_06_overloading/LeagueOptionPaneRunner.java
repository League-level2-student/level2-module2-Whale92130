package _06_overloading;

public class LeagueOptionPaneRunner {
	public static void main(String[] args) {
		LeagueOptionPane a = new LeagueOptionPane();
		a.showMessageDialog("hi");
		a.showMessageDialog("bye", "Kentucky");
		a.showMessageDialog("Yolo", "Texas", "java.png");
	}
}
