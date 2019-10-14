import java.util.Comparator;

public class SortByLastName implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getLastName().compareTo(b.getLastName());
	}
	
}
