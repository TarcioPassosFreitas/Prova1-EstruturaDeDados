package Prova1;

public class Pokemon {
	private int ID;
	private int AT;
	
	public Pokemon (int id, int at) {
	this.ID = id;
	this.AT = at;
	}
	
	public int getID() {
	return ID;
	}
	
	public void setID(int iD) {
	ID = iD;
	}
	
	public int getAT() {
	return AT;
	}
	
	public void setAT(int aT) {
	AT = aT;
	}
	
	public void displayPokemons() {
		System.out.println(" { " + this.ID + ", " + this.AT + " } ");
	}
}
