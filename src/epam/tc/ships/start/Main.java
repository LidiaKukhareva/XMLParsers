package epam.tc.ships.start;

import java.util.ArrayList;

import epam.tc.ships.bean.Ship;
import epam.tc.ships.parsers.dom.DOMParser;
import epam.tc.ships.parsers.sax.SAXParser;
import epam.tc.ships.parsers.stax.StAXParser;

public class Main {
	
	public static void printShips(ArrayList<Ship> ships){
		for (int i = 0; i < ships.size(); i++){
			System.out.println(ships.get(i).toString());
		}
	}

	public static void main(String[] args) {
		
		ArrayList<Ship> ships = SAXParser.parseShips();
		System.out.println("By SAX:");
		printShips(ships);
		
		ships = StAXParser.parseShips();
		System.out.println("By StAX:");
		printShips(ships);
		
		ships = DOMParser.parseShips();
		System.out.println("By DOM:");
		printShips(ships);
	}

}
