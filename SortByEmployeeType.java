import java.util.Comparator;

public class SortByEmployeeType implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o2.getEmployeeType().compareTo(o2.getEmployeeType());
	}
	

}
