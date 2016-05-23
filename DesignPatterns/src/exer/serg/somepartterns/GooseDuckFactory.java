package exer.serg.somepartterns;

public class GooseDuckFactory {
	
	private GooseDuckFactory() {}
	
	public static GooseAdapter createGooseDuck() {
		return new GooseAdapter(new Goose());
	}

}
