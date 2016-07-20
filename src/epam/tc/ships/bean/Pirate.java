package epam.tc.ships.bean;

public class Pirate {
	
	private String nickname;
	private String nationality;
	
	public Pirate(String nickname, String nationality){
		this.nickname = nickname;
		this.nationality = nationality;
	}
	
	public Pirate(){
		this.nickname = "";
		this.nationality = "";
	}
	
	public String getNickname(){
		return nickname;
	}
	
	public void setNickname(String nickname){
		this.nickname = nickname;
	}
	
	public String getNationality(){
		return nationality;
	}
	
	public void setNationality(String nationality){
		this.nationality = nationality;
	}
	
	public String toString(){
		return "(" + nickname + " " + nationality + ")";
	}
}
