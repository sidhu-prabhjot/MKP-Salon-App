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
    
    private static String customerRecordsPath = "src/main/java/sidhu/graph/DataFiles/CustomerRecords.txt";
    private static String appointmentRecordsPath = "src/main/java/sidhu/graph/DataFiles/AppointmentRecords.txt";
    
    //write information from customer object to file
    public static void writeCustomersToFile(ArrayList<Customer> customers, String fileName) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(customerRecordsPath))) {
          for (Customer customer : customers) {
            writer.write(String.format("%d,%s,%s,%s,%s\n",
                customer.getID(), 
                customer.getFirstName(), 
                customer.getLastName(),
                customer.getPhoneNumber(), 
                customer.getEmail()));
          }
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    //write information from customer object to file
    public static void writeAppointmentsToFile(ArrayList<Appointment> appointments, String fileName) {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(appointmentRecordsPath))) {
          for (Appointment appointment : appointments) {
            writer.write(String.format("%d,%d,%s,%s,%.2f\n",
                appointment.getID(), 
                123, 
                appointment.getType(),
                appointment.getDate(), 
                appointment.getRevenue()));
          }
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    public static void setCustomerRecordsPath(String filePath) {
        customerRecordsPath = filePath;
    }
    
    public static String getCustomerRecordsPath() {
        return customerRecordsPath;
    }
    
    public static void setAppointmentRecordsPath(String filePath) {
        appointmentRecordsPath = filePath;
    }
    
    public static String getAppointmentRecordsPath() {
        return appointmentRecordsPath;
    }
    
}
