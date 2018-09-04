public class MerkleManager_Test {

    public static void main(String[] args){

        MerkleManager merkleManager = new MerkleManager();
        merkleManager.manageFunction();
    }
}

/*
   HASH VALUES

   LEAVES

   a : ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb
   b : 3e23e8160039594a33894f6564e1b1348bbd7a0088d42c4acb73eeaed59c009d
   c : 2e7d2c03a9507ae265ecf5b5356885a53393a2029d241394997265a1a25aefc6
   d : 18ac3e7343f016890c510e93f935261169d9e3f565436429830faf0934f4f8e4

   UPPER TREE

   H4(H0 + H1) : 62af5c3cb8da3e4f25061e829ebeea5c7513c54949115b1acc225930a90154da
   H5(H2 + H3) : d3a0f1c792ccf7f1708d5422696263e35755a86917ea76ef9242bd4a8cf4891a

   MERKLE NODE
   H6(H4 + H5) : 58c89d709329eb37285837b042ab6ff72c7c8f74de0446b091b6a0131c102cfd
  */