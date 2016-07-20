package epam.tc.ships.bean;

import java.util.ArrayList;

public class Ship {
	
	private String name;
	private String shipNationality;
	
	private int yearOfBirth;
	private int length;
	private int width;
	private int height;
	private int id;
	private ArrayList<Pirate> crew;
	private ArrayList<Sea> route;
	
	public Ship(){
		name = "no name";
		shipNationality = " no nationality";
		yearOfBirth = 0;
		length = 0;
		width = 0;
		height = 0;
		id = 0;
		crew = new ArrayList<Pirate>();
		route = new ArrayList<Sea>();
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getNationality(){
		return shipNationality;
	}
	
	public void setNationality(String nationality){
		this.shipNationality = nationality;
	}
	
	public int getYearOfBirth(){
		return yearOfBirth;
	}
	
	public void setYearOfBirth(int yearOfBirth){
		this.yearOfBirth = yearOfBirth;
	}
	
	public int getLength(){
		return length;
	}
	
	public void setLength(int length){
		this.length = length;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getHeight(){
		return height;
	}
	
	public void setHeight(int height){
		this.height = height;
	}
	
	public ArrayList<Pirate> getCrew(){
		return crew;
	}
	
	public void setCrew(ArrayList<Pirate> crew){
		this.crew = crew;
	}
	
	public ArrayList<Sea> getRoute(){
		return route;
	}
	
	public void setRoute(ArrayList<Sea> route){
		this.route = route;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public String toString(){
		String s = name + " " + id + " " + shipNationality + " " + yearOfBirth + " " + length + " "
				+ width + " " + height + "\n";
		for (int i = 0; i < crew.size(); i++){
			s += crew.get(i).toString() + "\n";
		}
		for (int i = 0; i < route.size(); i++){
			s += route.get(i) + " ";
		}
		return s;
	}
	
	
}
