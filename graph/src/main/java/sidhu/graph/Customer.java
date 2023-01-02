package sidhu.graph;

/**
 *
 * @author Prabh
 */


public class Customer {
    //variables that represent different Customer paramaters
    private int customerID;   
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    
    //constructor to set values for the customer object
    public Customer (int ID, String fname, String lname, String phoneNum, String eml) {
        //TODO: when the customer class is created, use the graph class (main to generate and send it)
        customerID = ID;
        firstName = fname;
        lastName = lname;
        phoneNumber = phoneNum;
        email = eml;
    }
    
    //set the customer's first name
    public void setFirstName(String fname) {
        firstName = fname;
    }
    
    //get the customer's first name
    public String getFirstName() {
        return firstName;
    }
    
    //set the customer's last name
    public void setLastName(String lname) {
        lastName = lname;
    }
    
    //get the customer's last name
    public String getLastName() {
        return lastName;
    }
    
    //set the customer's phone number
    public void setPhoneNumber(String phoneNum) {
        phoneNumber = phoneNum;
    }
    
    //get the customer's phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    //set the customer's email address
    public void setEmail(String eml) {
        email = eml;
    }
    
    //get the customer's email address
    public String getEmail() {
        return email;
    }
    
    //set the customer's ID (SHOULD NOT BE USED)
    public void setID(int ID) {
        customerID = ID;
    }
    
    //get the customer's ID
    public int getID() {
        return customerID;
    }
    
    //toString method that formats the customer paramaters in a presentable string
    @Override
    public String toString() {
        String formattedOutput = "";
        formattedOutput += "Customer ID #: " + customerID + "\n";
        formattedOutput += "First Name: " + firstName + "\n";
        formattedOutput += "Last Name: " + lastName + "\n";
        formattedOutput += "Phone Number: " + phoneNumber + "\n";
        formattedOutput += "Email: " + email + "\n";
        
        return formattedOutput;
        
    }
    
    
}
