import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class Utils {

    public String getMerkleNode(ArrayList<String> listName){

        // Create Merkle Node Projects
        MerkleNode oNode0 = new MerkleNode();
        MerkleNode oNode1 = new MerkleNode();
        MerkleNode oNode2 = new MerkleNode();
        MerkleNode oNode3 = new MerkleNode();
        MerkleNode oNode4 = new MerkleNode();
        MerkleNode oNode5 = new MerkleNode();
        MerkleNode oNode6 = new MerkleNode();

        // Create leaves of tree with hashes of inputs
        oNode0.sHash = generateHash(listName.get(0));
        oNode1.sHash = generateHash(listName.get(1));
        oNode2.sHash = generateHash(listName.get(2));
        oNode3.sHash = generateHash(listName.get(3));

        // Begin creating upper levels of tree
        populateMerkleNode(oNode4,oNode0,oNode1);
        populateMerkleNode(oNode5,oNode2,oNode3);
        populateMerkleNode(oNode6,oNode4,oNode5);

        return oNode6.sHash; //this is the merkel root

    }

    private void populateMerkleNode(MerkleNode oNode, MerkleNode oLeftNode, MerkleNode oRightNode){

        oNode.oLeft = oLeftNode;// set our left side of node
        oNode.oRight = oRightNode;// set our right side of node
        oNode.sHash = generateHash(oLeftNode.sHash + oRightNode.sHash); //create the next node
    }

    /* Algorithm to generate has using SHA-256*/
    public synchronized String generateHash(String sOriginal){

        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] btEncodedhash = digest.digest(
                    sOriginal.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < btEncodedhash.length; i++) {
                //0xff is telling it's going to be a hex number
                sb.append(Integer.toString((btEncodedhash[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception ex){

            System.out.println("Error generating hash: " + ex.getMessage());
            return null;
        }
    }

    /*This will pass in the string which will be the questions you want to display to user*/
    public String promptUser(String question){
        Scanner scan = new Scanner(System.in);
        System.out.println(question);
        return scan.nextLine().trim(); //returns the user answer
    }

    /*Simple print statement to make my coding simpler*/
    public void print(String displayText){
        System.out.println(displayText);
    }

    /*This function will allow for my threads to sleep at random times*/
    public void sleepRandomTime(String sThreadName){

        // Gets random number between 0 and 5 and then adds 3, meaning between 3 and 8 now.
        int iSleepTime = new SecureRandom().nextInt(5) + 3;

        System.out.println(sThreadName + " sleeping for " + iSleepTime + " seconds.");
        sleep(iSleepTime);
    }

    /*This function will print out the array lists*/
    public void printList(ArrayList<String> list){
        for(String str : list){
            print(str +" ");
        }
        System.out.println();
    }

    /*Function will put my threads to sleep*/
    public void sleep(int iSeconds){
        try {
            Thread.sleep(iSeconds * 1000);
        }
        catch (Exception ex) {
            //it failed... oops
        }
    }
}
