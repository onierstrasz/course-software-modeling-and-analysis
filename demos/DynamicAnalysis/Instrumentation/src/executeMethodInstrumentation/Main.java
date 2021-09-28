package executeMethodInstrumentation;

public class Main {
	
	public static void main(String[] args){
		ExecuteMethodInstrumentation e = new ExecuteMethodInstrumentation();
		e.initializeEverything();
		e.instrumentExecuteMethod();
	}

}
