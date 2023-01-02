package sidhu.graph;
import java.util.ArrayList;

/**
 *
 * @author Prabh
 */
public class AppointmentRecords {
    
    //structure of BST node
    private static class Node {
        Appointment appointment;
        Node left;
        Node right;

        public Node(Appointment appointment) {
            this.appointment = appointment;
        }
    }
    
    private Node root;
    private int maxID;
    
    //when instantiated, turn the appoointment records into a BST according to ID
    public AppointmentRecords(ArrayList<Appointment> appointments) {
        for (Appointment appointment: appointments) {
            root = insert(root, appointment);
        }
        
        maxID = getGreatestID() + 1;
    }
    
    //insert a appointment record into the binary tree according to ID
    private Node insert(Node node, Appointment appointment) {
        if (node == null) {
            return new Node(appointment);
        }
        if (appointment.getID() < node.appointment.getID()) {
            node.left = insert(node.left, appointment);
        } else {
            node.right = insert(node.right, appointment);
        }
        return node;
    }
    
    //public function to insert a new node into the BST
    public void addAppointment(Appointment appointment) {
        appointment.setID(maxID);
        maxID += 1;
        root = insert(root, appointment);
    }
    
    //get the greatest ID in the BST
    private int getGreatestID() {
        return getGreatestID(root);
    }

    private int getGreatestID(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int rightID = getGreatestID(node.right);
        return Math.max(node.appointment.getID(), rightID);
    }
 
    //search the BST to find an ID. if it does not exist, then return null
    public Appointment searchID(int id) {
        return searchID(root, id);
    }

    private Appointment searchID(Node node, int id) {
        if (node == null) {
            return null;
        }
        if (id == node.appointment.getID()) {
            return node.appointment;
        }
        if (id < node.appointment.getID()) {
            return searchID(node.left, id);
        } else {
            return searchID(node.right, id);
        }
    }

    //search the BST to find a customer ID. if it does not exist, then return null. Otherwise, return all matches
    public ArrayList<Appointment> searchCustomerID(int id) {
        ArrayList<Appointment> matches = new ArrayList<>();
        searchCustomerID(root, id, matches);
        return matches;
    }

    private void searchCustomerID(Node node, int id, ArrayList<Appointment> matches) {
        if (node == null) {
            return;
        }
        if (id == node.appointment.getCustomerID()) {
            matches.add(node.appointment);
        }
        searchCustomerID(node.left, id, matches);
        searchCustomerID(node.right, id, matches);
    }
    
    /*search the BST to find a type of appointment. If it does not exist, then return null. Otherwise,
    return an array list of the matches*/
    public ArrayList<Appointment> searchType(String type) {
        ArrayList<Appointment> matches = new ArrayList<>();
        searchType(root, type, matches);
        return matches;
    }

    private void searchType(Node node, String type, ArrayList<Appointment> matches) {
        if (node == null) {
            return;
        }
        if (type.equalsIgnoreCase(node.appointment.getType())) {
            matches.add(node.appointment);
        }
        searchType(node.left, type, matches);
        searchType(node.right, type, matches);
    }
    
    /*search the BST to find a completion date of appointment. If it does not exist, 
    then return null. Otherwise, return an array list of the matches*/
    public ArrayList<Appointment> searchCompletionDate(String completionDate) {
        ArrayList<Appointment> matches = new ArrayList<>();
        searchCompletionDate(root, completionDate, matches);
        return matches;
    }

    private void searchCompletionDate(Node node, String completionDate, ArrayList<Appointment> matches) {
        if (node == null) {
            return;
        }
        if (completionDate.equalsIgnoreCase(node.appointment.getDate())) {
            matches.add(node.appointment);
        }
        searchCompletionDate(node.left, completionDate, matches);
        searchCompletionDate(node.right, completionDate, matches);
    }
    
    /*search the BST to find revenue of appointment. If it does not exist, then return null. 
    Otherwise, return an array list of the matches*/
    public ArrayList<Appointment> searchRevenue(double revenue) {
        ArrayList<Appointment> matches = new ArrayList<>();
        searchRevenue(root, revenue, matches);
        return matches;
    }

    private void searchRevenue(Node node, double revenue, ArrayList<Appointment> matches) {
        if (node == null) {
            return;
        }
        if (revenue == node.appointment.getRevenue()) {
            matches.add(node.appointment);
        }
        searchRevenue(node.left, revenue, matches);
        searchRevenue(node.right, revenue, matches);
    }

    //return the maxID member variable
    public int getMaxID() {
        return maxID;
    }
    
    //return the recrods in the form of an array list
    public ArrayList<Appointment> toArrayList() {
        ArrayList<Appointment> list = new ArrayList<>();
        toArrayList(root, list);
        return list;
    }
    
    private void toArrayList(Node node, ArrayList<Appointment> list) {
        if (node == null) {
            return;
        }
        toArrayList(node.left, list);
        list.add(node.appointment);
        toArrayList(node.right, list);
    }

    //print out the records in the console
    public void printRecords() {
        printRecords(root);
    }

    private void printRecords(Node node) {
        if (node == null) {
            return;
        }
        printRecords(node.left);
        System.out.print(node.appointment.getID() + "\n");
        System.out.print(node.appointment.getCustomerID() + "\n");
        System.out.print(node.appointment.getType() + "\n");
        System.out.print(node.appointment.getDate() + "\n");
        System.out.print(node.appointment.getRevenue() + "\n");
        System.out.println();
        printRecords(node.right);
    }
}
