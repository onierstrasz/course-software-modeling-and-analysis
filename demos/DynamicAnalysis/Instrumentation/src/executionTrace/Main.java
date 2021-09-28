package executionTrace;

import java.io.File;

public class Main {
	
	public static void main(String[] args){
		ExecutionTraceCreation e = new ExecutionTraceCreation();
		e.initializeEverything();
		e.instrumentClasses();
	}

}
