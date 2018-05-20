package model;

public class Student {
	public String surname;
	public String name;
	public String town;
	public String street;
	public String house;
	public int familyMembers;
	public int area;
	public double areaPerPerson;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public int getFamilyMembers() {
		return familyMembers;
	}

	public void setFamilyMembers(int familyMembers) {
		this.familyMembers = familyMembers;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public double getAreaPerPerson() {
		return areaPerPerson;
	}

	public void setAreaPerPerson(double tempAreaPerPersone) {
		this.areaPerPerson = tempAreaPerPersone;
	}
}
