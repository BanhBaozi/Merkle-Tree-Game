import java.util.ArrayList;

public class MerkleThread implements Runnable{

    public static volatile ArrayList<String> grabbedWords;
    private int iMerkleTreeInputs = 4; //how many words to wait for before tree gets created

    @Override
    public void run() {
        Utils utils = new Utils();
        MerkleManager merkleManager = new MerkleManager();
        grabbedWords = new ArrayList<>();
        while(true){

            utils.sleepRandomTime("Merkle Thread"); // let user know sleep status of thread
            String sNewWord = merkleManager.grabWord();

            // validate user input
            if(sNewWord != null){
                utils.print("[Merkle] grabbed word");
                grabbedWords.add(sNewWord); // add grabbed word to list
                if(grabbedWords.size() == iMerkleTreeInputs){
                    // set the sMerkleRoot to the generated merkle root value by getMerkleNode
                    MerkleManager.sMerkleRoot = utils.getMerkleNode(grabbedWords);
                }
            }
        }
    }
}
