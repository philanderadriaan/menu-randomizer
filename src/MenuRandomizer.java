import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

public class MenuRandomizer {

	public static void main(String[] args) throws Exception {
		try {
			List<Entry<String, Float>> menuList = new ArrayList<Entry<String, Float>>();
			for (String line : Files.readAllLines(Paths.get("menu.txt"))) {
				if (line.isBlank()) {
					shuffle(menuList);
					continue;
				}
				String[] split = line.trim().split("\t");
				menuList.add(new SimpleEntry<String, Float>(split[0], Float.valueOf(split[1])));
			}
			shuffle(menuList);
		} catch (Exception exception) {
			JOptionPane.showMessageDialog(null, exception.getMessage(), exception.getClass().toString(),
					JOptionPane.ERROR_MESSAGE);
			RandomizerUtility.dialogError(exception.getClass().toString(), exception.getMessage());
			throw exception;
		}
	}

	private static void shuffle(List<Entry<String, Float>> menuList) {
		Collections.shuffle(menuList);
		System.out.println(menuList.get(0).getKey());
		// System.out.println(menuList.get(0).getKey() + " " + String.format("%.2f",
		// menuList.get(0).getValue()));
		menuList.clear();
	}
}
