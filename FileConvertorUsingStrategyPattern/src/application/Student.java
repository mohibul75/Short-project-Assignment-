package application;

public class Student {
	private String name;
	private String roll;
	private String phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student(String name, String roll, String phone) {
		super();
		this.name = name;
		this.roll = roll;
		this.phone = phone;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String toString(){
	    StringBuilder sb = new StringBuilder();
	    sb.append("************************************");
	    sb.append("\nempId: ").append(name);
	    sb.append("\nname: ").append(roll);
	    sb.append("\ndesignation: ").append(phone);
	    sb.append("\n************************************");
	    return sb.toString();
	}

}
