package epam.tc.ships.parsers.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import epam.tc.ships.bean.Pirate;
import epam.tc.ships.bean.Sea;
import epam.tc.ships.bean.Ship;
import epam.tc.ships.bean.TagName;

public class StAXParser {
	
	public static ArrayList<Ship> parseShips(){
		
		ArrayList<Ship> ships = null;
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try{
			InputStream input = new FileInputStream("ships.xml");
			XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
			
			ships = process(reader);
		}
		catch(XMLStreamException | FileNotFoundException e){
			e.printStackTrace();
		}
		return ships;
	}
	
	private static ArrayList<Ship> process(XMLStreamReader reader) throws XMLStreamException{
		ArrayList<Ship> ships = new ArrayList<Ship>();
		Ship ship = null;
		Pirate pirate = null;
		
		TagName tag = null;
		String localName = null;
		
		while(reader.hasNext()){
			int type = reader.next();
			switch(type){
			case XMLStreamConstants.START_ELEMENT:
				localName = reader.getLocalName();
				tag = TagName.valueOf(localName.toUpperCase().replaceAll(" ", "_"));
				
				switch(tag){
				case SHIP:
					ship = new Ship();
					ship.setName(reader.getAttributeValue(null, "name"));
					int id = Integer.parseInt(reader.getAttributeValue(null, "id"));
					ship.setId(id);
					break;
				case PIRATE:
					pirate = new Pirate();
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if(text.isEmpty()){
					break;
				}
				switch(tag){
				case SHIPNATIONALITY:
					ship.setNationality(text.toString());
					break;
				case YEAROFBIRTH:
					ship.setYearOfBirth(Integer.parseInt(text.toString()));
					break;
				case LENGTH:
					ship.setLength(Integer.parseInt(text.toString()));
					break;
				case WIDTH:
					ship.setWidth(Integer.parseInt(text.toString()));
					break;
				case HEIGHT:
					ship.setHeight(Integer.parseInt(text.toString()));;
					break;
				case SEA:
					ship.getRoute().add(Sea.valueOf(text.toString().toUpperCase()));
					break;
				case NICKNAME:
					pirate.setNickname(text.toString());
					break;
				case NATIONALITY:
					pirate.setNationality(text.toString());
					break;
				default:
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				localName = reader.getLocalName();
				tag = TagName.valueOf(localName.toUpperCase().replaceAll(" ", "_"));
				switch(tag){
				case PIRATE:
					ship.getCrew().add(pirate);
					break;
				case SHIP:
					ships.add(ship);
				}
			}
		}
		return ships;
	}
}
