import java.io.IOException;

public class driver {

	public static void main(String[] args) {
		
		if(args.length != 2){
			System.out.println("Invalid number of command line arguments.");
			System.exit(0);
		}
		
		InputManager im = new InputManager();
		im.loadFile(args[0]);
		
		OptimalTree op = new OptimalTree();
		NodeSort root = op.createTree(im.st);
		try {
			im.output(args[1], root.PreOrderString());
		} catch (IOException e) {
			System.err.println("Error with file output.");
			e.printStackTrace();
		}
	}

}
