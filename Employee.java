

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {

	private String employeeID;
	private EmployeeType employeeType;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Gender gender;
	private String position;

	public Employee(String employeeID, EmployeeType employeeType, String firstName, String lastName, LocalDate dob, Gender gender,
			String position) {
		super();
		this.employeeID = employeeID;
		this.employeeType = employeeType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.position = position;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public void setEmployeeID(String employeeID) {
		if(employeeID == null) {
			throw new IllegalArgumentException("Employee Id is required");
		}
		
		if(employeeID.trim().isEmpty()) {
			throw new IllegalArgumentException("Employee Id is required");
		}
		
		this.employeeID = employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		
		if(firstName == null) {
			throw new IllegalArgumentException("First name is required");
		}
		
		if(firstName.trim().isEmpty()) {
			throw new IllegalArgumentException("First name is required");
		}
		
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	
	}

	public void setLastName(String lastName) {
		
		if(lastName == null) {
			throw new IllegalArgumentException("Last name is required");
		}
		
		if(lastName.trim().isEmpty()) {
			throw new IllegalArgumentException("Last name is required");
		}
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		if(dob == null) {
			throw new IllegalArgumentException("DOB is required.");
		}
		
		LocalDate minDate = LocalDate.of(1900, 1, 1);
		if(dob.isBefore(minDate)) {
			throw new IllegalArgumentException("DOB is outdated");
		}
		
		this.dob = dob;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		if(gender == null) {
			throw new IllegalArgumentException("gender is required");
		}
		
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}
		

	public void setPosition(String position) {
		if(position == null) {
			throw new IllegalArgumentException("Position is required");
		}
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee [employeeID=" + employeeID + " employeeType=" + employeeType + ", firstName=" + firstName + ", lastName=" + lastName + ", dob="
				+ dob + ", gender=" + gender + ", position=" + position + "]";
	}
	
	
	
	
}
