package edu.gmu.cs321;
//Person class
public class Person 
{
	//Private attributes
	private String firstName;
	private String lastName;
	private int personID;
	//Person no parameter constructor
	public Person(){
		firstName = null;
		lastName = null;
		personID = -1;
	}
	//Person constructor with parameters
	public Person(String firstName, String lastName, int personID){
		this.firstName=firstName;
		this.lastName=lastName;
		this.personID=personID;
	}
	//Getters
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public int getID(){
		return personID;
	}
	//Setters
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public void setPersonID(int personID){
		this.personID = personID;
	}


	public String getFullName(){
		if(firstName == null || lastName == null){
			return null;
		}
		return(firstName + " " + lastName);

	}
	
}