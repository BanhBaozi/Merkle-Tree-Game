public class MerkleManager {

    // Variable initial and declarations
    public static volatile String sUserEnteredValue;
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
   HASH VALUES

   LEAVES
   a : CA978112CA1BBDCAFAC231B39A23DC4DA786EFF8147C4E72B9807785AFEE48BB
   b : 3E23E8160039594A33894F6564E1B1348BBD7A0088D42C4ACB73EEAED59C009D
   c : 2E7D2C03A9507AE265ECF5B5356885A53393A2029D241394997265A1A25AEFC6
   d : 18AC3E7343F016890C510E93F935261169D9E3F565436429830FAF0934F4F8E4

   UPPER TREE
   node4: FB8E20FC2E4C3F248C60C39BD652F3C1347298BB977B8B4D5903B85055620603
   node5: 21E721C35A5823FDB452FA2F9F0A612C74FB952E06927489C6B27A43B817BED4

   MerkleNode:
  */