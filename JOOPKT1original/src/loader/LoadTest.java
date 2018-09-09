package loader;

import java.util.ArrayList;
import loaders.Loader;
import loaders.FastLoader;

public class LoadTest {
	// Loon arraylisti laadijate hoidmiseks
	public static ArrayList<Loader> loaders = new ArrayList<Loader>();

	public static void main(String[] args) {
		// Loon 4 uut objekti kasutades static factory meetodit
		Loader l1 = Loader.getInstance(1);
		Loader l2 = Loader.getInstance(1);
		Loader fl1 = Loader.getInstance(2);
		Loader fl2 = Loader.getInstance(2);
		// Lisan 4 laadijat arraylisti
		loaders.add(l1);
		loaders.add(l2);
		loaders.add(fl1);
		loaders.add(fl2);
		// Teen läbi esimese laadimise ringi
		System.out.println("First round of loading:\n\n");
		for (Loader loader : loaders) {
			loader.startLoad();
			System.out.println(loader.readInfo());
			loader.stopLoad();
			System.out.println(loader.readInfo());
			System.out.println("\n\n----------x----------\n\n");
		}
		// Käivitan kõigil laadijatel avariireþiimi
		l1.startCrashLoad(1);
		l2.startCrashLoad(2);
		fl1.startCrashLoad(3);
		fl2.startCrashLoad(4);
		// Teen läbi teise laadimise ringi avariireþiimis
		System.out.println("Second round of loading:\n\n");
		for (Loader loader : loaders) {
			loader.startLoad();
			System.out.println(loader.readInfo());
			loader.stopLoad();
			System.out.println(loader.readInfo());
			System.out.println("\n\n----------x----------\n\n");
		}
		// Lõpetan kõigil laadijatel avariireþiimi
		l1.stopCrashLoad();
		l2.stopCrashLoad();
		fl1.stopCrashLoad();
		fl2.stopCrashLoad();
		// Teen läbi kolmanda laadimise ringi (tulemus sama nagu esimene)
		System.out.println("Third round of loading:\n\n");
		for (Loader loader : loaders) {
			loader.startLoad();
			System.out.println(loader.readInfo());
			loader.stopLoad();
			System.out.println(loader.readInfo());
			System.out.println("\n\n----------x----------\n\n");
		}
		// Teen läbi aeglase laadimise
		System.out.println("Slow loading for 1 fast loader:");
		((FastLoader) fl1).startLowLoad();
		fl1.startLoad();
		System.out.println(fl1.readInfo());
		fl1.stopLoad();
	}
}