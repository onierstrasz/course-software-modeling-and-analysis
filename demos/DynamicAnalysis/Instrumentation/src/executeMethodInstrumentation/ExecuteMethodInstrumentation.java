package executeMethodInstrumentation;

import java.io.IOException;
import java.nio.file.Paths;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class ExecuteMethodInstrumentation {
	
	ClassPool pool; //pool used to get the CtClass objects
	String pathToBinFiles = Paths.get(".").toAbsolutePath().getParent().getParent().normalize().toString().concat("/JHotDraw_6_b1/bin"); //path to bin folder of JHotDraw6b1
	CtClass clazz; //CtClass object representing the class we want to modify
	CtMethod method; //CtMethod object representing the method we want to instrument
	
	public void initializeEverything(){
		pool = ClassPool.getDefault(); // returns the singleton instance of class ClassPool
		try {
			pool.insertClassPath(pathToBinFiles);  // appends to the pool path to class files, so that pool knows where to search for the class
			clazz = pool.getCtClass("org.jhotdraw.util.UndoCommand"); // getting the class from the pool by its full name
			method = clazz.getDeclaredMethod("execute");
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void instrumentExecuteMethod(){
		try {
			method.instrument(new ExprEditor(){
				public void edit(MethodCall mc) throws CannotCompileException{
					if(mc.getMethodName().equals("undo")){
						//$0 is a metavariable which represents the receiver object at run time
						//$_ is the return object from a method call
						//$proceed represents the actual invoked method, and can be used only with $$ variable, where $$ is the array of the method arguments at run-time
						mc.replace("{System.out.println($0.getClass().toString()); $_ = $proceed($$);}"); 
						System.out.println("instrumented");
					}
				}
				
			});
			clazz.writeFile(pathToBinFiles);
			
		} catch (CannotCompileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
