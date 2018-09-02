public class MonitorThread implements Runnable {

    Utils utils = new Utils();
    @Override
    public void run() {


        while(true){
            if(MerkleManager.sMerkleRoot != null){
                //if there is a merkle root
                if(MerkleManager.sMerkleRoot.equals(MerkleManager.sEnteredExpectedRoot)){
                    utils.print("You Win: " +MerkleManager.sMerkleRoot);
                    System.exit(0);
                }
                else {
                    utils.print("The roots don't match: You lose!\n");

                    /*---------------------DEBUG TESTS------------------- */
                    utils.printList(MerkleThread.grabbedWords); // test print to see what's in my ArrayList
                    utils.print("Actual Root: " +MerkleManager.sMerkleRoot ); // test print to see what the actual merkle root value is
                    utils.print("Your guessed root: " +MerkleManager.sEnteredExpectedRoot); // test print for users guess of merkle root

                    System.exit(0); // exit program
                }
            }
            else if(MerkleManager.iStrike == 3){
                utils.print("3 Strikes: you lost!");
                utils.printList(MerkleThread.grabbedWords); // test print to see what's in my ArrayList
                System.exit(0); // exit program
            }

            utils.sleep(1); //sleep the utils object to allow for updates
        }
    }
}
