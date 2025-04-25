import java.io.*;


public class VerifyBinaryFile {
    public static void main(String[] args) {
        String filePath = "src/people-copy.dat";
        
        try {
            DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(filePath)));
            
            try {
                while (true) {
                    int age = input.readInt();
                    String name = input.readUTF();
                    String address = input.readUTF();
                    int zipCode = input.readInt();
                    double salary = input.readDouble();
                    
                    System.out.println("Age: " + age);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Zip Code: " + zipCode);
                    System.out.println("Salary: " + salary);
                    System.out.println();
                }
            } catch (EOFException e) {
                System.out.println("End of file reached.");
            }
            
            input.close();
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}