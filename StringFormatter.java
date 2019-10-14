import java.awt.List;
import java.util.ArrayList;

public class StringFormatter {
	
	public enum Alignment{L, C, R}
	
	interface Part{
		String format(String... args);
	}
	
	private String nullValue= "null";
	private ArrayList<Part> partList = new ArrayList<Part>();
	
	public StringFormatter nullValue(String value) {
		nullValue = value;
		return this;
	}
	
	public StringFormatter add(String literal) {

	    partList.add(new Part() {
	      @Override
	      public String format(String... args) {
	        return literal;
	      }
	    });

	    return this;
	}
	
	public StringFormatter add(int index) {

	    partList.add(new Part() {
	      @Override
	      public String format(String... args) {
	        if(args[index] == null) {
	          return nullValue;
	        }

	        return args[index];
	      }
	    });

	    return this;
	}
	
	public StringFormatter add(int index, Alignment alignment, int width) {

	    partList.add(new Part() {
	      @Override
	      public String format(String... args) {
	        String arg = args[index];

	        if(arg == null) {
	          arg = nullValue;
	        }

	        if(arg.length() == width) {
	          return arg;
	        }else if(arg.length() > width) {
	          return arg.substring(0, width);
	        }

	        int frontWidth = 0;
	        int backWidth = 0;

	        if(alignment == Alignment.C) {
	          frontWidth = (width - arg.length())/2;
	          backWidth = width - arg.length() - frontWidth;
	        }else if(alignment == Alignment.L) {
	          frontWidth = 0;
	          backWidth = width - arg.length();
	        }else if(alignment == Alignment.R) {
	          backWidth = 0;
	          frontWidth = width - arg.length();
	        }

	        StringBuffer sb = new StringBuffer(width);

	        for(int i=0;i<frontWidth;i++) {
	          sb.append(" ");
	        }

	        sb.append(arg);

	        for(int i=0;i<backWidth;i++) {
	          sb.append(" ");
	        }

	        return sb.toString();
	      }
	    });

	    return this;
	}
	
	public String format(String... args) {

	    StringBuffer sb = new StringBuffer();

	    for(Part part: partList) {
	      sb.append(part.format(args));
	    }

	    return sb.toString();
	}
}
