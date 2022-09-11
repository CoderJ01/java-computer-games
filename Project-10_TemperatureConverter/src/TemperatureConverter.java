package programmer.coderj.temperatureconverter;

import programmer.coderj.mywindow.MyWindow;

public class TemperatureConverter extends MyWindow {

	public TemperatureConverter() {
		double f = promptForDouble("Enter degrees Fahreintheit.");
		print((f - 32) * 5 / 9 + " degrees Celsius");
		double c = promptForDouble("Enter degrees Celsius");
		print("Fahreintheit = " + (1.8 * c + 32));
	}

	public static void main(String[] args) {
		new TemperatureConverter();
	}

}
