import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountriesApp {

	private static Path filePath = Paths.get("countries.txt");

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		while (true) {
			System.out.println("Enter a command (list, add, quit): ");
			String command = scnr.nextLine();
			if (command.equals("quit")) {
				break;
			} else if (command.equals("list")) {
				List<Country> things = readFile();
				int i = 1;
				for (Country thing : things) {
					System.out.println(i++ + ". " + thing);
				}
			} else if (command.equals("add")) {
				Country name = getCountryFromUser(scnr);
				System.out.println("Adding " + name);
				appendLineToFile(name);
			} else {
				System.out.println("Invalid command.");
			}

		}
		System.out.println("Goodbye.");
		scnr.close();

	}

	private static Country getCountryFromUser(Scanner scnr) {
		
		String name = Validator.getString(scnr, "Enter a country: ");
		int population = Validator.getInt(scnr, "Enter it's population: ");
		boolean speakEnglish = Validator.getYesNo(scnr, "Is English the first language of this country (yes/no)? ");
		String city = Validator.getString(scnr, "Enter the country's largest city: ");
		return new Country(name, population, speakEnglish, city);
	}

	public static List<Country> readFile() {
		try {
			List<String> lines = Files.readAllLines(filePath);

			List<Country> countries = new ArrayList<>();
			for (String line : lines) {
				// #1 split the line based on the delimiter
				String[] parts = line.split("/");
				// #2 select each part based on index position and convert
				// to the correct type
				String name = parts[0];
				int population = Integer.parseInt(parts[1]);
				boolean speakEnglish = Boolean.parseBoolean(parts[2]);
				String city = parts[3];
				// #3 use the data to create an object and add it to the list
				countries.add(new Country(name, population, speakEnglish, city));
			}

			return countries;
		} catch (IOException e) {
			System.out.println("Unable to read file.");
			return new ArrayList<>();
		}
	}

	public static void appendLineToFile(Country thing) {
		String line = thing.getName() + "/" + thing.getPopulation() + "/" + thing.isSpeakEnglish() + "/" + thing.getCity();

	
		List<String> lines = Collections.singletonList(line);
		try {
			Files.write(filePath, lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.out.println("Unable to write to file.");
		}
	}

}
