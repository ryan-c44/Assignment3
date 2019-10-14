import java.util.Comparator;

public class SortByGender implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getGender().compareTo(o2.getGender());
	}
}
