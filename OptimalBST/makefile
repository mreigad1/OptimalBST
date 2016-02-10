# Specify the target

all: clean driver.class InputManager.class Node.class NodeSort.class OptimalTree.class 

run: all execute clean

# Specify how the object files should be created from source files

driver.class: driver.java
	javac driver.java

InputManager.class: InputManager.java
	javac InputManager.java

Node.class: Node.java
	javac Node.java

NodeSort.class: NodeSort.java
	javac NodeSort.java

OptimalTree.class: OptimalTree.java
	javac OptimalTree.java


test:
	java driver ExampleInput1 ExampleOutput1
	java driver ExampleInput2 ExampleOutput2

# Specify the object files and executables that are generated
# and need to be removed to re-compile the whole thing
clean:
	rm -f *.o *~ *.class
