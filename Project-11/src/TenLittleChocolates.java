package programmer.coderj.tenlittlechocolates;

import programmer.coderj.mywindow.MyWindow;

public class TenLittleChocolates extends MyWindow {

	public TenLittleChocolates() {
		for(int i = 10; i >= 1; i--) {
			print(i + " little chocolates.");
		}
		print("1 little chocolate bar.");
	}

	public static void main(String[] args) {
		new TenLittleChocolates();
	}

}
