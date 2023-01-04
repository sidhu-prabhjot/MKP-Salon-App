package sidhu.graph;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Prabh
 */
public class FileRead {
    
    private static String customerRecordsPath = "src/main/java/sidhu/graph/DataFiles/CustomerRecords.txt";
    private static String appointmentRecordsPath = "src/main/java/sidhu/graph/DataFiles/AppointmentRecords.txt"; 
    
    public static ArrayList<Customer> readCustomers(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(customerRecordsPath))) {
          String line;
          while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int id = Integer.parseInt(values[0]);
            String firstName = values[1];
            String lastName = values[2];
            String phone = values[3];
            String email = values[4];
            Customer customer = new Customer(id, firstName, lastName, phone, email);
            customers.add(customer);
          }
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

        return customers;
  }
    
    //read appointment recrods from text file
    public static ArrayList<Appointment> readAppointments(String filePath) {
        ArrayList<Appointment> appointments = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(appointmentRecordsPath))) {
          String line;
          while ((line = br.readLine()) != null) {
            String[] values = line.split(",");
            int id = Integer.parseInt(values[0]);
            int customerID = Integer.parseInt(values[1]);
            String type = values[2];
            String date = values[3];
            double revenue = Double.parseDouble(values[4]);
            Appointment appointment = new Appointment(id, customerID, type, date, revenue);
            appointments.add(appointment);
          }
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }

        return appointments;
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
