package travel;

import travelluxury.*;
import java.util.ArrayList;

public class DestinationTest {
	public static void main(String[] args) {
		Destination d1 = new Destination("Paide", 296.15);
		Destination d2 = new Destination("Rooma", 307.15);
		Destination d3 = new Destination("Stockholm", 278.15);
		d1.getCelsius();
		d2.getCelsius();
		d3.getCelsius();
		d1.getFahrenheit();
		d2.getFahrenheit();
		d3.getFahrenheit();
		System.out.println(d1.getAvgWeather(t -> t - 273.15));
		System.out.println(d1.getAvgWeather(t -> t * (9.0 / 5.0) - 459.67));
		System.out.println(d1.getAvgWeather(Destination::toCelsius));
		System.out.println(d1.getAvgWeather(Destination::toFahrenheit));
		System.out.println("\nSiit hakkab kodune ülesanne.\n");
		ArrayList<DestinationLuxury> dl = new ArrayList<DestinationLuxury>();
		Location l1 = new Location("Milaano", "Milano", "Itaalia", "Euroopa");
		Location l2 = new Location("Helsingi", "Helsinki", "Soome", "Euroopa");
		Location l3 = new Location("Moskva", "Moskva", "Venemaa", "Euraasia");
		// Kommentaarides on temperatuurid Celsiuse kraadides
		Temperature t1 = new Temperature(294.15, 277.15, 297.15); // 21, 4, 24
		Temperature t2 = new Temperature(289.15, 270.15, 292.15); // 16, -3, 19
		Temperature t3 = new Temperature(278.15, 251.15, 291.15); // 5, -22, 18
		DestinationLuxury dl1 = new DestinationLuxury(l1, t1);
		DestinationLuxury dl2 = new DestinationLuxury(l2, t2);
		DestinationLuxury dl3 = new DestinationLuxury(l3, t3);
		dl.add(dl1);
		dl.add(dl2);
		dl.add(dl3);
		for (DestinationLuxury dls : dl) {
			System.out.print("Päevane keskmine temperatuur K: ");
			System.out.println(dls.dailyAvg((x1, x2) -> (x1 + x2) / 2.0));
			System.out.print("Päevane keskmine temperatuur C: ");
			System.out.println(dls.toCelsius(dls.dailyAvg((x1, x2) -> (x1 + x2) / 2.0)));
			dls.getDetailedInfo(l -> System.out.printf("%s (%s), %s, %s\n",
					l.getName(), l.getLocalName(), l.getCountry(), l.getContinent()));
			dls.getDetailedInfo(l -> System.out.printf("%s, %s\n", l.getName(), l.getCountry()));
			dls.getDetailedInfo(l -> System.out.printf("%s\n", l.getName()));
			dls.getDetailedInfo(l -> System.out.printf("%s\n", l.getName().toUpperCase()));
			dls.getDetailedInfo(l -> System.out.printf("%s, %s\n", l.getName(),
					l.getCountry().toUpperCase()));
			System.out.println("----------x----------");
		}
	}
}