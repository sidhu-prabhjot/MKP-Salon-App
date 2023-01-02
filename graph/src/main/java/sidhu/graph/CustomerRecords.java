package sidhu.graph;
import java.util.ArrayList;

/**
 *
 * @author Prabh
 */
public class CustomerRecords {
    
    //structure of BST node
    private static class Node {
        Customer customer;
        Node left;
        Node right;

        public Node(Customer customer) {
            this.customer = customer;
        }
    }
      
    private Node root;
    private int maxID;
    
    //when instantiated, turn the customer records into a BST according to ID
    public CustomerRecords(ArrayList<Customer> customers) {
        for (Customer customer : customers) {
            root = insert(root, customer);
        }
        
        maxID = getGreatestID() + 1;
    }
    
    //insert a customer into the binary tree according to ID
    private Node insert(Node node, Customer customer) {
        if (node == null) {
            return new Node(customer);
        }
        if (customer.getID() < node.customer.getID()) {
            node.left = insert(node.left, customer);
        } else {
            node.right = insert(node.right, customer);
        }
        return node;
    }
    
    //public function to insert a new node into the BST
    public void addCustomer(Customer customer) {
        customer.setID(maxID);
        maxID += 1;
        root = insert(root, customer);
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
        return Math.max(node.customer.getID(), rightID);
    }
    
    //search the BST to find an ID. if it does not exist, then return null
    public Customer searchID(int id) {
        return searchID(root, id);
    }

    private Customer searchID(Node node, int id) {
        if (node == null) {
            return null;
        }
        if (id == node.customer.getID()) {
            return node.customer;
        }
        if (id < node.customer.getID()) {
            return searchID(node.left, id);
        } else {
            return searchID(node.right, id);
        }
    }
    
    /*search the BST to find a firstName. if it does not exist, then return null. Return the 
    found matches in an array list*/
    public ArrayList<Customer> searchFirstName(String firstName) {
        ArrayList<Customer> matches = new ArrayList<>();
        searchFirstName(root, firstName, matches);
        return matches;
    }

    private void searchFirstName(Node node, String firstName, ArrayList<Customer> matches) {
        if (node == null) {
            return;
        }
        if (firstName.equals(node.customer.getFirstName())) {
            matches.add(node.customer);
        }
        searchFirstName(node.left, firstName, matches);
        searchFirstName(node.right, firstName, matches);
    }
    
    /*search the BST to find a lastName. if it does not exist, then return null. Return the 
    found matches in an array list*/
    public ArrayList<Customer> searchLastName(String lastName) {
        ArrayList<Customer> matches = new ArrayList<>();
        searchLastName(root, lastName, matches);
        return matches;
    }

    private void searchLastName(Node node, String lastName, ArrayList<Customer> matches) {
        if (node == null) {
            return;
        }
        if (lastName.equals(node.customer.getLastName())) {
            matches.add(node.customer);
        }
        searchLastName(node.left, lastName, matches);
        searchLastName(node.right, lastName, matches);
    }
    
    /*search the BST to find a phoneNumber. if it does not exist, then return null. Return the 
    found matches in an array list*/
    public ArrayList<Customer> searchPhoneNumber(String phoneNumber) {
        ArrayList<Customer> matches = new ArrayList<>();
        searchPhoneNumber(root, phoneNumber, matches);
        return matches;
    }

    private void searchPhoneNumber(Node node, String phoneNumber, ArrayList<Customer> matches) {
        if (node == null) {
            return;
        }
        if (phoneNumber.equals(node.customer.getPhoneNumber())) {
            matches.add(node.customer);
        }
        searchPhoneNumber(node.left, phoneNumber, matches);
        searchPhoneNumber(node.right, phoneNumber, matches);
    }
    
    /*search the BST to find a email. if it does not exist, then return null. Return the 
    found matches in an array list*/
    public ArrayList<Customer> searchEmail(String email) {
        ArrayList<Customer> matches = new ArrayList<>();
        searchEmail(root, email, matches);
        return matches;
    }

    private void searchEmail(Node node, String email, ArrayList<Customer> matches) {
        if (node == null) {
            return;
        }
        if (email.equals(node.customer.getEmail())) {
            matches.add(node.customer);
        }
        searchEmail(node.left, email, matches);
        searchEmail(node.right, email, matches);
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
        System.out.print(node.customer.getID() + "\n");
        System.out.print(node.customer.getFirstName() + "\n");
        System.out.print(node.customer.getLastName() + "\n");
        System.out.print(node.customer.getPhoneNumber() + "\n");
        System.out.print(node.customer.getEmail() + "\n");
        System.out.println();
        printRecords(node.right);
    }
    
    //return the recrods in the form of an array list
    public ArrayList<Customer> toArrayList() {
        ArrayList<Customer> list = new ArrayList<>();
        toArrayList(root, list);
        return list;
    }

    private void toArrayList(Node node, ArrayList<Customer> list) {
        if (node == null) {
            return;
        }
        toArrayList(node.left, list);
        list.add(node.customer);
        toArrayList(node.right, list);
    }

    //return the maxID member variable
    public int getMaxID() {
        return maxID;
    }
}
