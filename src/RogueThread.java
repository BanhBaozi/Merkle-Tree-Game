
public class RogueThread implements Runnable {



    @Override
    public void run() {

        Utils utils = new Utils();
        MerkleManager merkleManager = new MerkleManager();

        while(true){

            utils.sleepRandomTime("Rogue Thread"); // let user know sleep status of thread
            String sNewWord = merkleManager.grabWord();

            // validate user input
            if(sNewWord != null){
                utils.print("[Rogue] grabbed word: STRIKE!");
                MerkleManager.iStrike++  ; // strike incrementer to end game
            }

        }
    }
}
