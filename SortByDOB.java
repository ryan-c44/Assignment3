import java.util.Comparator;

public class SortByDOB implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDob().compareTo(o2.getDob());
	}
	

}
