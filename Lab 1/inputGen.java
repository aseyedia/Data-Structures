import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomDataGenerator {
	
	private static String[] middleEarth = new String[] {
			"Frodo",
			"Gandalf",
			"Aragorn",
			"Legolas",
			"Samwise",
			"Gimli",
			"Bilbo",
			"Peregrin",
			"Boromir",
			"Galadirel",
			"Meriadoc",
			"Elrond",
			"Faramir",
			"Treebeard",
			"Gollum",
			"Eomer",
			"Thorin",
			"Eowyn",
			"Theoden",
			"Saruman",
			"Arwen",
			"Sauron",
			"Smaug",
			"Bard",
			"Haldir",
			"Radagast",
			"Kili",
			"Balin",
			"Shadowfax",
			"Tauriel",
			"Thranduil",
			"Fili",
			"Dwalin",
			"Tom",
			"Balrog",
			"Gloin",
			"Celeborn",
			"Bofur",
			"Beorn",
			"Bombur",
			"Oin",
			"Bill",
			"Gwaihir",
			"Ori",
			"Shelob",
			"Nori",
			"Gil",
			"Grima",
			"Morgoth",
			"Bifur",
			"Elendil"
	};
	private static String[] starWars = new String[] {
			"ObiWan",
			"Yoda",
			"Han",
			"Vader",
			"Luke",
			"Chewbacca",
			"R2D2",
			"Leia",
			"Boba",
			"Maul",
			"Palpatine",
			"C3PO",
			"QuiGon",
			"Lando",
			"Mace",
			"Padme",
			"Ackbar",
			"Jabba",
			"Rey",
			"Grievous",
			"Tarkin",
			"Jango",
			"Dooku",
			"Ahsoka",
			"Kylo",
			"BB8",
			"Poe",
			"Wedge",
			"Finn",
			"Warrick",
			"Anakin",
			"Revan",
			"Rex",
			"Kit",
			"Plo",
			"Chirrut",
			"Thrawn",
			"Bail",
			"Greedo",
			"Mara",
			"Aayla",
			"Asajj",
			"Bossk",
			"Jyn",
			"Cody",
			"Cad",
			"Shaak",
			"KiAdi",
			"Bane",
			"Jawa",
			"Ewok",
			"Jaina",
			"Bastila",
			"Galen",
			"Jacen",
			"JarJar",
			"Plagueis",
			"Shmi",
			"Ben",
			"Watto"
	};
	private static String[] got = new String[] {
			"Eddard",
			"Robert",
			"Jaime",
			"Catelyn",
			"Cersei",
			"Daenerys",
			"Jorah",
			"Petyr",
			"Viserys",
			"Jon",
			"Sansa",
			"Arya",
			"Robb",
			"Theon",
			"Bran",
			"Joffrey",
			"Sandor",
			"Tyrion",
			"Drogo",
			"Tywin",
			"Davos",
			"Samwell",
			"Margaery",
			"Stannis",
			"Melisandre",
			"Jeor",
			"Bronn",
			"Varys",
			"Shae",
			"Ygritte",
			"Talisa",
			"Gendry",
			"Tormund",
			"Gilly",
			"Brienne",
			"Ramsay",
			"Ellaria",
			"Daario",
			"Missandei",
			"Jaqen",
			"Tommen",
			"Roose",
			"Pycelle",
			"Meryn",
			"Hodor",
			"Grenn",
			"Osha",
			"Rickon",
			"Gregor",
			"Janos",
			"Lancel",
			"Myrcella",
			"Rodrik",
			"Luwin",
			"Irri",
			"Doreah",
			"Kevan",
			"Barristan",
			"Rast",
			"Aemon",
			"Alliser",
			"Loras",
			"Beric",
			"Podrick",
			"Yara",
			"Qyburn",
			"Olenna",
			"Shireen",
			"Jojen",
			"Thoros",
			"Olly",
			"Mace",
			"Bowen"
	};
	private static Random random = new Random();
	
	public static void main(String[] args) throws IOException {
		
		if (Integer.parseInt(args[0]) == 1)
			generate(middleEarth, args[1]);
		if (Integer.parseInt(args[0]) == 2)
			generate(starWars, args[1]);
		if (Integer.parseInt(args[0]) == 3)
			generate(got, args[1]);
		
	}
	
	public static void generate(String[] names, String outputPath) throws IOException {
		String[] shuffledNames = shuffle(names);
		
		BufferedWriter bw = Files.newBufferedWriter(Paths.get(outputPath));
		
		for (String shuffledName : shuffledNames) {
			int entered = random.nextInt(5)+1;
			int exited = reroll(entered);
			bw.write(shuffledName+"\t"+entered+"\t"+exited+"\n");
		}
		
		bw.close();
	}
	
	/**
	 * Keeps rolling until we get a unique number
	 * @param currentNumber
	 * @return
	 */
	private static int reroll(int currentNumber) {
		int roll = random.nextInt(5)+1;
		while (roll == currentNumber)
			roll = random.nextInt(5)+1;
		
		return roll;
	}
	
	/**
	 * Shuffles the names in a given list
	 * @return
	 */
	private static String[] shuffle(String[] names) {
		List<String> strList = Arrays.asList(names);
		Collections.shuffle(strList);
		
		return strList.toArray(new String[names.length]);
	}
	
}