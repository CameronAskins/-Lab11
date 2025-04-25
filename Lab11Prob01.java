import java.io.*;


public class Lab11Prob01 {
    public static void main(String[] args) {
        // File paths
        String inputFilePath = "src/people.dat";
        String outputFilePath = "src/people-copy.dat";
        
        try {
            // Create DataInputStream to read binary data
            DataInputStream input = new DataInputStream(
                new BufferedInputStream(new FileInputStream(inputFilePath)));
            
            // Create DataOutputStream to write binary data
            DataOutputStream output = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(outputFilePath)));
            
            // Read and write data
            try {
                while (true) {
                    // Read data
                    int age = input.readInt();
                    String name = input.readUTF();
                    String address = input.readUTF();
                    int zipCode = input.readInt();
                    double salary = input.readDouble();
                    
                    // Display data to console
                    System.out.println("Age: " + age);
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Zip Code: " + zipCode);
                    System.out.println("Salary: " + salary);
                    System.out.println();
                    
                    // Write data to output file
                    output.writeInt(age);
                    output.writeUTF(name);
                    output.writeUTF(address);
                    output.writeInt(zipCode);
                    output.writeDouble(salary);
                }
            } catch (EOFException e) {
                // End of file reached, which is expected
                System.out.println("End of file reached.");
            }
            
            // Close streams
            input.close();
            output.close();
            
            System.out.println("Data successfully copied to " + outputFilePath);
            
        } catch (IOException e) {
            System.out.println("Error processing files: " + e.getMessage());
        }
    }
}