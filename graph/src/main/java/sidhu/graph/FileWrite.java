package sidhu.graph;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Prabh
 */
public class FileWrite {
    
    //write information from customer object to file
    public static void writeCustomersToFile(ArrayList<Customer> customers, String fileName) {
        
        fileName = "src/main/java/sidhu/graph/DataFiles/CustomerRecords.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
          for (Customer customer : customers) {
            writer.write(String.format("%d,%s,%s,%s,%s\n",
                customer.getID(), 
                customer.getFirstName(), 
                customer.getLastName(),
                customer.getPhoneNumber(), 
                customer.getEmail()));
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    //write information from customer object to file
    public static void writeAppointmentsToFile(ArrayList<Appointment> appointments, String fileName) {
        
        fileName = "src/main/java/sidhu/graph/DataFiles/AppointmentRecords.txt";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
          for (Appointment appointment : appointments) {
            writer.write(String.format("%d,%d,%s,%s,%.2f\n",
                appointment.getID(), 
                123, 
                appointment.getType(),
                appointment.getDate(), 
                appointment.getRevenue()));
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
}
