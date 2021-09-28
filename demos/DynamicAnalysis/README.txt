# Dynamic analysis demo instructions

1. The JHotDRaw_6_b1 folder contains three subfolders: 

	src - contains source files
	lib - contains all the necessary libraries to be able to run JHotDraw
	bin - contains class files

2. The structure of the Demo folder cannot be changed, since the path to the bin folder is supplied to javassist; if you update the structure, make sure to update pathToBinFiles fields in demo

## How to run JHotDraw:

1. import it into Eclipse
	specify/fix the build path to the libraries in the lib folder if necessary
2. run it as a Java Application with the main method in the class JavaDrawApp
3. File>>New to create new sheet
4. click on the rectangle tool, for example and draw a rectangle on the sheet
5. click on the rectangle to select it
6. Attributes>>Fill Color>>Red (or any other color) to change the color of the rectangle 
7. Edit>>Undo Command

	This list of executions will invoke method org.jhotdraw.util.UndoCommand.execute() (if you want to be sure, put a breakpoint at the beginning of the execute() method and run it in debug mode).

8. close the JHotDraw window.

## Instrumentation Demos

There are two demos

1. executeMethodInstrumentation (to be run from Main class) 

	This demo instruments one method call to undo() method in the method org.jhotdraw.util.UndoCommand.execute(), so that it logs the actual run-time type of the receiver of the method call.

2. executionTrace (to be run from Main class)

	This demo instruments *all* the methods in all the classes in the bin folder, so that it logs the message whenever the method starts the execution and whenever the method finishes the execution.

Import the project in workspace/Instrumentation into Eclipse. Fix the build path to the javassist library (jar file) if necessary.

Run either one of the demos, and if everything is ok, no exceptions will be raised.

If you have run the first instrumentation demo, run JHotDraw and perform all the steps from above. When you undo color change, it should write in the console "class org.jhotdraw.standard.ChangeAttributeCommand$UndoActivity" as it is the run-time type of the receiver. If you now resize the rectangle, and undo this action it will write "class org.jhotdraw.standard.ResizeHandle$UndoActivity" as it is now run-time type of the receiver.

Make sure to recompile JHotDraw project every time after running either one of the instrumentation demos, as the class files are affected by the changes, and the instrumentation will stay in the bytecode if you don't recompile it (in Eclipse you can do it by Project>>Clean and then select the project you want to clean and click OK).

If you run the second demo, it will instrument all the classes in JHotDraw, and during the instrumentation it will output to the console the name of the class currently being instrumented. Again, no exception should be raised if everything is ok. Now run JHotDraw and it will output the execution trace to the console. Even only opening it will produce a large amount of output. Whatever you do now it JHotDraw will be logged in the console.

Do not forget to clean JHotDraw at the end.
