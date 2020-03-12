import java.io.File;

public class CorrespondenceDemo {
	
	private SecretAgent john;
	private SecretAgent vlad;
	private int initialOffset;
	
	private File fileFromJohn;
	private File fileFromVlad;
	private File file2FromJohn;
	
	public static void main(String[] args) {
		CorrespondenceDemo c = new CorrespondenceDemo(8);		
		c.runScenario();
	}
	
	public void runScenario(){
		System.out.println("***Starting Correspondence***");
		System.out.println();
		
		//Message 1
		System.out.println("*****MESSAGE 1********");
		String msg = "Hi Vladamir, don't put missles in Cuba!";
		writeMsg(john, vlad, msg, fileFromJohn, this.initialOffset);
		int nextOffset = readMsg(fileFromJohn, this.initialOffset);
		
		//Message 2
		System.out.println("*****MESSAGE 2********");
		msg = "Thanks comrade! I will send a set of nesting dolls to show my appreciation";
		writeMsg(vlad, john, msg, fileFromVlad, nextOffset);
		nextOffset = readMsg(fileFromVlad, nextOffset);
		
		//Message 3
		System.out.println("*****MESSAGE 3********");
		msg = "Thanks for the nesting dolls.";
		writeMsg(john, vlad, msg, file2FromJohn, nextOffset);
		nextOffset = readMsg(file2FromJohn, nextOffset);
		
		System.out.println("***Ending Correspondence***");
	}
	
	public CorrespondenceDemo(int initialOffset){
		this.initialOffset = initialOffset;
		
		john = new SecretAgent("Doe", "John", "12345");
		vlad = new SecretAgent("Mendelev", "Vladimir", "54321");
		
		fileFromJohn = new File("/Users/dylan/tmp/msgFromJohn.enc");
		fileFromVlad = new File("/Users/dylan/tmp/msgFromVlad.enc");
		file2FromJohn = new File("/Users/dylan/tmp/msg2FromJohn.enc");		
		
	}
	
	private void writeMsg(SecretAgent sender, SecretAgent receiver, String msg, File msgFile, int offset){
		System.out.printf("***Writing message from %s to %s***%n", sender.getFirstName(), receiver.getFirstName());
		
		
		
		System.out.println("Message:");
		System.out.println("\t" + msg);
		
		System.out.println("Offset:");
		System.out.println("\t" +  offset);		
		
		CaesarCipher cipher = new CaesarCipher(sender, receiver,msgFile, offset, msg);
		try{
			cipher.writeToBinaryFile();
		}
		catch(Exception e){
			System.out.println("Error writing msg to binary file");
			e.printStackTrace();
			System.exit(0);
		}		
		
		System.out.println("***Done writing message***\n\n");
	}
	
	//reads the message and returns the new offset.
	private int readMsg(File msgFile, int offset){
		System.out.println("***Reading message***");		
		CaesarCipher cipher = new CaesarCipher(msgFile, offset);
		int nextOffset = 0;
		
		try{
			nextOffset = cipher.readFromBinaryFile();
			System.out.println(cipher.toString());
		}
		catch(Exception e){
			System.out.println("Error writing msg to binary file");
			e.printStackTrace();
			System.exit(0);
		}		
		
		System.out.println("***Done reading message***\n\n");
		
		return nextOffset;
	}
}
