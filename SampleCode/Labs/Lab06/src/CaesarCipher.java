import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class CaesarCipher implements CipherIO{
	//Instance Variables
	SecretAgent sender;
	SecretAgent receiver;
	String msg;
	int offset;
	int nextOffset;
	File msgFile;
	Random ran = new Random();
	//Constructor for writing message
	public CaesarCipher(SecretAgent sender, SecretAgent receiver, File msgFile, int offset,
			String msg) {
		this.sender = sender;
		this.receiver = receiver;
		this.msgFile = msgFile;
		this.offset = offset;
		this.msg = msg;
	}
	
	//Constructor for reading an encrypted message
	public CaesarCipher(File msgFile, int offset) {
		this.msgFile = msgFile;
		this.offset = offset;
	}
	
	//Encryption methods
	private int[] convertToAscii(String s) {
		int[] letterArr = new int[s.length()];
		
		for(int i = 0; i < s.length(); i++) {
			char[] charArray = s.toCharArray();
			letterArr[i] = charArray[i];
		}
		return letterArr;
	}
	
	private String convertToString(int[] asciiArr) {
		String str = "";
		
		for(int i = 0; i < asciiArr.length; i++) {
			char letter = (char)asciiArr[i];
			str += letter;
		}
		return str;
	}
	
	public String encrypt(String stringToEncrypt, int offset) {
		int[] asciiStringArr = convertToAscii(stringToEncrypt);
		for(int i = 0; i < asciiStringArr.length; i++) {
			asciiStringArr[i] += offset;
		}
		String encryptedStr = convertToString(asciiStringArr);
		return encryptedStr;
	}
	
	public String decrypt(String encryptedString, int offset) {
		int[] decryptChar = convertToAscii(encryptedString);
		
		for(int i = 0; i < decryptChar.length; i++) {
			decryptChar[i] -= offset;
		}
		String decryptedStr = convertToString(decryptChar);
		return decryptedStr;
	}
	
	
	
	@Override
	public String toString() {
		return "Sender: " + "\n" + 
					"\t" + sender.toString() + "\n" + 
			   "Receiver: " + "\n" +
			   		"\t" + receiver.toString() + "\n" + 
			   "Message: " + this.msg + "\n" + 
			   "Offset: " + this.offset + "\n" + 
			   "Next Offset: " + this.nextOffset;
	}
	
	@Override
	public void writeToBinaryFile() throws FileNotFoundException, IOException {
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(msgFile));
		
		output.writeObject(sender);
		output.writeObject(receiver);
		
		output.writeUTF(encrypt(msg, offset));
		
		nextOffset = ran.nextInt(100) + 1;
		output.writeInt(nextOffset);
		
		output.close();
	}
	
	@Override
	public int readFromBinaryFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream input = new ObjectInputStream(new FileInputStream(msgFile));
		
		sender = (SecretAgent)input.readObject();
		receiver = (SecretAgent) input.readObject();
		
		//comment out line 108 and uncomment line 110 to see encrypted message in output
		msg = decrypt(input.readUTF(), offset);
		
		//msg = input.readUTF();
		
		nextOffset = input.readInt();

		input.close();
		
		return nextOffset;
	}

	public int getNextOffset() {
		return nextOffset;
	}
	
	
	
	
}
