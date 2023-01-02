package sidhu.graph;

/**
 *
 * @author Prabh
 */
public class Appointment {
    
    //appointment details variables
    private int appointmentID;
    private int customerID;
    private String appointmentType;
    private String compDate;
    private double revenue;
    
    //set all the values to the paramaters sent in the constructor
    public Appointment(int aID, int cID, String type, String aDate, double rev) {
        appointmentID = aID;
        customerID = cID;
        appointmentType = type;
        compDate = aDate;
        revenue = rev;
    }
    
    //set the ID of the appointment (SHOULD NOT BE USED)
    public void setID(int ID) {
        appointmentID = ID;
    }
    
    //get the ID of the appointment
    public int getID() {
        return appointmentID;
    }
    
    //set the appointment type
    public void setType(String type) {
        appointmentType = type;
    }
    
    //get the appointment type
    public String getType() {
        return appointmentType;
    }
    
    //set the appointment date
    public void setDate(String date) {
        compDate = date;
    }
    
    //get the appointment date
    public String getDate() {
        return compDate;
    }
    
    //set the appointment revenue
    public void setRevenue(double rev) {
        revenue = rev;
    } 
    
    //get the appointment revenue
    public double getRevenue() {
        return revenue;
    } 
    
    //get the customer ID
    public int getCustomerID() {
        return customerID;
    }
    
    //formatted output for the appointment record
    @Override
    public String toString(){
        String formattedOutput = "";
        formattedOutput += "Appointment ID #: " + appointmentID + "\n";
        formattedOutput += "Customer ID #: " + customerID + "\n";
        formattedOutput += "Appointment Type: " + appointmentType + "\n";
        formattedOutput += "Date: " + compDate + "\n";
        formattedOutput += "Revenue: " + revenue + "\n";
        
        return formattedOutput;
    }
    
}
