import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	public static void GenGrid(String grid) {
		String[] variables = grid.split(";");
		StringTokenizer st = new StringTokenizer(variables[0] + "," + variables[1] + "," + variables[2], ",");

		StringBuilder builder = new StringBuilder();

		// construct the grid predicate
		String n = st.nextToken();
		String m = st.nextToken();

		// ensure grid size is between is maximum 5 and is positive
		if (Integer.parseInt(n) > 5 || Integer.parseInt(m) > 5) {
			System.err.println("Grid size is maximum 5 by 5");
			return;
		}
		if (Integer.parseInt(n) <= 0 || Integer.parseInt(m) <= 0) {
			System.err.println("Grid size must be positive");
			return;
		}

		builder.append("grid(");
		builder.append(n);
		builder.append(", ");
		builder.append(m);
		builder.append(").\n");

		// construct the iron man predicate
		String ix = st.nextToken();
		String iy = st.nextToken();
		builder.append("ironMan(");
		builder.append(ix);
		builder.append(", ");
		builder.append(iy);
		builder.append(", s0).\n");

		// construct the Thanos predicate
		String tx = st.nextToken();
		String ty = st.nextToken();
		builder.append("thanos(");
		builder.append(tx);
		builder.append(", ");
		builder.append(ty);
		builder.append(").\n");

		// construct the stones predicates
		st = new StringTokenizer(variables[3], ",");

		while (st.hasMoreTokens()) {
			String x = st.nextToken(), y = st.nextToken();
			builder.append("stone(");
			builder.append(x);
			builder.append(", ");
			builder.append(y);
			builder.append(", s0).\n");
		}

		try {
			PrintWriter out = new PrintWriter("KB.pl");
			out.print(builder.toString());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// outputs what is in KB1
		//GenGrid("5,5;1,2;3,4;1,1,2,1,2,2,3,3");
		
		// outputs what is in KB2
		//GenGrid("5,5;2,2;2,3;0,0,4,4,0,4,4,0");

		GenGrid("3,3;0,0;2,2;0,1,0,2,1,1,1,2");
	}

}
