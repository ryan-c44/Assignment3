import java.util.Comparator;

public class SortByPosition implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getPosition().compareTo(o2.getPosition());
	}
	

}
