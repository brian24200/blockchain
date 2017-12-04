import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class Block {
	private int previousHash;
	private String[] transactions;
	
	private int blockHash;

	public Block(int previousBlock, String[] transactions) {
		this.previousHash = previousBlock;
		this.transactions = transactions;
		
		Object[] contens = {Arrays.hashCode(transactions), previousHash};
		this.blockHash = Arrays.hashCode(contens);
	}

	public int getPreviousHash() {
		return previousHash;
	}
	
	public int getBlockHash() {
		return blockHash;
	}

	public String[] getTransaction() {
		return transactions;
	}
	
	//=======================//Verification of Hash//=========================//
	public static boolean isChainValid(int size, ArrayList<Block> blockchain) {
		for (int blocksize = 1; blocksize < size; blocksize ++) {
			Block currentblock = blockchain.get(blocksize);
			Block previousblock = blockchain.get(blocksize - 1);
						
			if(previousblock.blockHash != currentblock.previousHash) 
				return false;

		}//end for
		return true;
	}
}
		
	
	
	
