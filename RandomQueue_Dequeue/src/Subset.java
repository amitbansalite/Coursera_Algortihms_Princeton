
public class Subset {	
	public static void main(String[] args) {
		if(args.length <1){
	    	throw new IllegalArgumentException("There should be 1 integer argument");
	    }
	    
	    int k = 0;
	    try {
	        k = Integer.parseInt(args[0]);
	    } catch (NumberFormatException e) {
	    	throw new IllegalArgumentException("k must be an integer");
	    }      
	    
	    int[] count = new int[20];
	    
	    for(int x=0; x< 1000000; x++){
	   
	    	RandomizedQueue<Integer> inputList = new RandomizedQueue<Integer>();	 	   
	 	    for(int i=0; i< 20; i++){
	 	    	if(i <k){
		    		inputList.enqueue(i);	    		
		    	}
		    	else{
		    		int rand = StdRandom.uniform(i);
		    		if(rand < k){
		    			inputList.dequeue();
		    			inputList.enqueue(i);
		    		}	    		
		    	}
	 	    }
	 	    
	 	   for(Integer j : inputList){
		    	count[j]++;
		    }
	    }	    
	    
	    for(int i=0; i<20; i++){
	    	StdOut.print("\n " + i + " : " + count[i]);
	    }    
	}
}
