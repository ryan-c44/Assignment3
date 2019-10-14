import java.util.Comparator;

public class SortByFirstName implements Comparator<Employee> {

	@Override
	public int compare(Employee a, Employee b) {
		return a.getFirstName().compareTo(b.getFirstName());
	}
	
}
