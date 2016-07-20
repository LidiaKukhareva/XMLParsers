package epam.tc.ships.parsers.sax;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import epam.tc.ships.bean.Ship;

public class SAXParser {
	
	public static ArrayList<Ship> parseShips(){
		
		ArrayList<Ship> ships = null;
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			ShipSAXHandler handler = new ShipSAXHandler();
			reader.setContentHandler(handler);
		
			reader.parse(new InputSource("ships.xml"));
			reader.setFeature("http://xml.org/sax/features/validation", true);
			reader.setFeature("http://xml.org/sax/features/namespaces", true);
			reader.setFeature("http://xml.org/sax/features/string-interning", true);
			reader.setFeature("http://apache.org/xml/features/validation/schema", false);
			
			ships = handler.getShips();
		} 
		catch (IOException e){
			e.printStackTrace();
		} 
		catch (SAXException e){
			e.printStackTrace();
		}
		return ships;
	}
}
