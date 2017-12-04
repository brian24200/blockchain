import java.util.Arrays;
import java.util.ArrayList;

	public class Main {

	    /**
	        Hash = digital signature
	        Each block will have:
	            List of transactions
	            Previous Hash
	            Hash Verification
	     */

		static ArrayList<Block> blockchain = new ArrayList<>();
		
	    public static void main(String[] args) {

	        String[] genesisTransactions = {"Satoshi sent ivan 99999 bitcoin","Hal Finney sent 10 bitcoins to Ivan"};
	        Block genesisBlock = new Block(0, genesisTransactions);
	        blockchain.add(genesisBlock);
	        
	        String[] block2Transactions = {"Ivan sent 10 bitcoin to Satoshi", "Satoshi sent 10 bitcoin to Starbuck"};
	        Block block2 = new Block(genesisBlock.getBlockHash(), block2Transactions);
	        blockchain.add(block2);
	        
	        String[] block3Transactions = {"Tony sent 500 bitcoins to Bruce"};
	        Block block3 = new Block(block2.getBlockHash(), block3Transactions);
	        blockchain.add(block3);
	        
	        String[] block4Transactions = {"Kim sent 10 bitcoin to Payless"};
	        Block block4 = new Block(block3.getBlockHash(), block4Transactions);
	        blockchain.add(block4);
	        
	        String[] block5Transactions = {"Bill sent 100000 bitcoin to Warren"};
	        Block block5 = new Block(block4.getBlockHash(), block5Transactions);
	        blockchain.add(block5);
	        
	        String[] block6Transactions = {"Steven sent 1000 bitcoin to Ricardo"};
	        Block block6 = new Block(block5.getBlockHash(), block6Transactions);
	        blockchain.add(block6);

	        System.out.println("Hash of genesis block: " + genesisBlock.getBlockHash());

	        System.out.println("Hash of block 2: " + block2.getBlockHash());

	        System.out.println("Hash of block 3: " + block3.getBlockHash());
 
	        System.out.println("Hash of block 4: " + block4.getBlockHash()); 

	        System.out.println("Hash of block 5: " + block5.getBlockHash());
	        
	        System.out.println("Hash of block 6: " + block6.getBlockHash());
	        
	        int size = blockchain.size();
	        System.out.print("\nBlockchain valid:" + Block.isChainValid(size, blockchain));
	        
	        //===================//Invalid Block//=====================//
	        
	        String[] block7Transactions = {"ivan sent 1000000 bitcoin to satoshi", "satoshi sent 10 bitcoin to starbuck"};
	        Block block7 = new Block(block2.getBlockHash(), block7Transactions);
	        blockchain.add(2, block7);
	        
	        System.out.println("\nHash of block 3: " + block3.getBlockHash());
	        System.out.print("\n\nBlockchain valid:" + Block.isChainValid(size, blockchain));
	    }
}
