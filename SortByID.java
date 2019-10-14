import java.util.Comparator;

public class SortByID implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getEmployeeID().compareTo(b.getEmployeeID());
	}
	

}
