package epam.tc.ships.parsers.dom;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import epam.tc.ships.bean.Pirate;
import epam.tc.ships.bean.Sea;
import epam.tc.ships.bean.Ship;

public class DOMParser {
	
	private static ArrayList<Ship> ships = new ArrayList<Ship>();
	
	public static ArrayList<Ship> parseShips(){
		
		SAXBuilder builder = new SAXBuilder();
		Document document = null;
		try {
			document = builder.build("ships.xml");
		}catch (JDOMException | IOException e) {
			e.printStackTrace();
		}
		
		Element root = document.getRootElement();
		List<Element> shipsElements = root.getChildren();
		Iterator<Element> it = shipsElements.iterator();
		
		while(it.hasNext()){
			Element temp = it.next();
			String name = temp.getAttributeValue("name");
			int id = Integer.parseInt(temp.getAttributeValue("id"));
			List<Element> shipElements = temp.getChildren();
			parseShip(shipElements, name, id);
		}
		
		return ships;
	}
	
	public static void parseShip(List<Element> shipElements, String name, int id){
		
		Ship ship = new Ship();
		ship.setName(name);
		ship.setId(id);
		
		Iterator<Element> it = shipElements.iterator();
		
		ship.setNationality(it.next().getText());
		ship.setYearOfBirth(Integer.parseInt(it.next().getText()));
		ship.setLength(Integer.parseInt(it.next().getText()));
		ship.setWidth(Integer.parseInt(it.next().getText()));
		ship.setHeight(Integer.parseInt(it.next().getText()));
		
		List<Element> seas = it.next().getChildren();
		parseRoute(ship, seas);
			
		List<Element> pirates = it.next().getChildren();
		parseCrew(ship, pirates);
		
		ships.add(ship);
			
	}
	
	public static void parseCrew(Ship ship, List<Element> pirates){
		Iterator<Element> it = pirates.iterator();
		while(it.hasNext()){
			Element el = it.next();
			List<Element> pirateElements = el.getChildren();
			Iterator<Element> it1 = pirateElements.iterator();
			Pirate pirate = new Pirate();
			pirate.setNickname(it1.next().getText());
			pirate.setNationality(it1.next().getText());
		}
	}
	public static void parseRoute(Ship ship, List<Element> seas){
		Iterator<Element> it = seas.iterator();
		while(it.hasNext()){
			Element temp = it.next();
			ship.getRoute().add(Sea.valueOf(temp.getText().toUpperCase()));
		}
	}	
	
	
}
