public class MerkleManager {

    // Variable initial and declarations
    public static volatile String sUserEnteredValue; //volatile: prevents different threads from keeping cache of this
    public static String sEnteredExpectedRoot;
    public static String sMerkleRoot = null;
    public static int iStrike = 0;

    public void manageFunction() {
        // Create an instance of the Util class
        Utils utils = new Utils();

        // Created 3 instances of the three kinds of threads
        Thread oMerkleThread = new Thread(new MerkleThread());
        Thread oRogueThread = new Thread(new RogueThread());
        Thread oMonitorThread = new Thread(new MonitorThread());


        sEnteredExpectedRoot = utils.promptUser("Enter the expected merkle root: ");

        // start my three threads
        oMerkleThread.start();
        oRogueThread.start();
        oMonitorThread.start();



        while(true){
            sUserEnteredValue = utils.promptUser("Enter value: ");
        }

    }

    public String grabWord(){
        String temp = sUserEnteredValue;
        sUserEnteredValue = null;
        return temp;
    }

}

/*
   --------------------------- HASH VALUE GUIDE ---------------------------------

   -- LEAVES --

   H(a) : ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb
   H(b) : 3e23e8160039594a33894f6564e1b1348bbd7a0088d42c4acb73eeaed59c009d
   H(c) : 2e7d2c03a9507ae265ecf5b5356885a53393a2029d241394997265a1a25aefc6
   H(d) : 18ac3e7343f016890c510e93f935261169d9e3f565436429830faf0934f4f8e4

   -- UPPER TREE --

   H4(H0 + H1) : 62af5c3cb8da3e4f25061e829ebeea5c7513c54949115b1acc225930a90154da
   H5(H2 + H3) : d3a0f1c792ccf7f1708d5422696263e35755a86917ea76ef9242bd4a8cf4891a

   -- MERKLE NODE --
   H6(H4 + H5) : 58c89d709329eb37285837b042ab6ff72c7c8f74de0446b091b6a0131c102cfd
  */