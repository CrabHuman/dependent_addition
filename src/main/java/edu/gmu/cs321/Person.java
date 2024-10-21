package edu.gmu.cs321;

public class Person 
{
	private String firstName;
	private String lastName;
	private int personID;

	public Person(){
		firstName = null;
		lastName = null;
		personID = -1;
	}

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