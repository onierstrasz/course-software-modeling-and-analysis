package executionTrace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;

public class ExecutionTraceCreation {
	
	ClassPool pool;
	ArrayList<String> classNames = new ArrayList<String>();
	String pathToBinFiles = Paths.get(".").toAbsolutePath().getParent().getParent().normalize().toString().concat("/JHotDraw_6_b1/bin"); //path to bin folder of JHotDraw6b1
	
	protected void initializeEverything(){
		collectAllClassNamesFromFolder(new File(pathToBinFiles), "");
		pool = ClassPool.getDefault();
		try {
			pool.insertClassPath(pathToBinFiles);
			pool.appendClassPath(Paths.get(".").toAbsolutePath().getParent().getParent().normalize().toString().concat("/JHotDraw_6_b1/lib/jdo2-api-2.3-eb.jar"));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void collectAllClassNamesFromFolder(File folder, String prefix){
		if(folder != null){
			File[] files = folder.listFiles();
			for(File file : files){
				if(file.isDirectory())
					collectAllClassNamesFromFolder(file, prefix.isEmpty() ? prefix.concat(file.getName()) : prefix.concat(".".concat(file.getName())));
				else if(file.getName().substring(file.getName().lastIndexOf('.') + 1).equals("class")){
						classNames.add(prefix.concat(".").concat(file.getName().substring(0, file.getName().lastIndexOf('.'))));
						}
					}
				}

		}
	
	public void instrumentClasses(){
		
		try {
			for(String name : classNames){
				CtClass clazz = pool.getCtClass(name);
				System.out.println("Instrumenting class " + clazz.getName());
				for(CtMethod m : clazz.getDeclaredMethods()){
					if(m.isEmpty() == false){
						m.insertBefore("System.out.println(\"Entering method " + m.getLongName() + "\");");
						m.insertAfter("System.out.println(\"Exiting method " + m.getLongName() + "\");");
					}
				}
				clazz.writeFile(pathToBinFiles);
			}
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotCompileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	}
