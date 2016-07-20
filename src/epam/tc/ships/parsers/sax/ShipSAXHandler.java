package epam.tc.ships.parsers.sax;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import epam.tc.ships.bean.Pirate;
import epam.tc.ships.bean.Sea;
import epam.tc.ships.bean.Ship;
import epam.tc.ships.bean.TagName;

public class ShipSAXHandler extends DefaultHandler{
	
	private ArrayList<Ship> ships = new ArrayList<Ship>();
	private Ship ship;
	private Pirate pirate;
	private StringBuilder text;
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException{
		
		text = new StringBuilder();
		
		TagName tag = TagName.valueOf(qName.toUpperCase().replaceAll(" ", "_"));
		
		switch(tag){
		
		case SHIP:
			ship = new Ship();
			ship.setName(attributes.getValue("name"));
			int id = Integer.parseInt(attributes.getValue("id"));
			ship.setId(id);
			break;
		case PIRATE:
			pirate = new Pirate();
			break;
		default:
			break;
		}		
	}
	
	public void characters(char[] buffer, int start, int length){
		text.append(buffer, start, length);
		text.trimToSize();
	}
	
	public void endElement(String uri, String localName, String qName) 
			throws SAXException {
		TagName tag = TagName.valueOf(qName.toUpperCase().replaceAll(" ", "_"));
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
		case PIRATE:
			ship.getCrew().add(pirate);
			break;
		case NICKNAME:
			pirate.setNickname(text.toString());
			break;
		case NATIONALITY:
			pirate.setNationality(text.toString());
			break;
		case SHIP:
			ships.add(ship);
		default:
			break;
		}
	}
	
	public ArrayList<Ship> getShips(){
		return ships;
	}

}
