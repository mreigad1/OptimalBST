Matthew Reigada
12/08/2015

Optimal BST’s are BST’s which are typically statically sized and prioritize
the minimization of total expected search cost.  This program constructs
Optimal Binary Search Tree from input text file data.

Files Included:
	driver.java
	Node.java
	NodeSort.java
	InputManager.java
	OptimalTree.java
	ExampleInput1
	ExampleInput2
	makefile
	run
	README.txt

NOTE:  Everything compiles and executes using javac

Execute program either by:

	I.)   "./run <input_Filename> <output_Filename>"

	      NOTE:  This script will compile, execute, and clean the program within
	             the directory, generated output files will remain within directory.

	II.)  "make"
	      "make test"

	      NOTE:  "make" will compile the program, "make test" will execute program
	             upon "ExampleInput1" & "ExampleInput2" and will generate
	             "ExampleOutput1" & "ExampleOutput2" from these provided inputs.
