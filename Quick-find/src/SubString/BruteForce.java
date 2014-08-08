package SubString;

// worst case : length of txt * length of substring

public class BruteForce {
	
	public static int BruteForce(String pat, String txt){
		
		int M = pat.length();
		int N = txt.length();
		
		for( int i=0; i   <= N-M; i++)
		{		
			int j;
			for( j=0; j<M; j++)
			{				
				if( txt.charAt(i+j) != pat.charAt(j))
				{
					break;					
				}				
			}
			if ( j == M)
				return i;
		}				
		return N;
	}
	  
	
	// same complexity as above
	public static int BruteForce_OneLoop(String pat, String txt){
		
		int M = pat.length();
		int N = txt.length();
		
		int i,j;
		
		for( i=0, j=0; i<N && j<M ; i++)
		{
			if ( txt.charAt(i) == pat.charAt(j))
					j++;
			else
			{		// backing up places instead of second loop as above
				i = i-j;
				j = 0;				
			}			
		}
		if ( j == M)	return i-M;
		else 			return N;
		
	}
}


