package edu.gmu.cs321;

public class Person 
{
	private String firstName;
	private String lastName;
	private int personID;

	

	public Person(String firstName, String lastName, int personID){
		this.firstName=firstName;
		this.lastName=lastName;
		this.personID=personID;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getID(){
		return personID;
	}
	
}