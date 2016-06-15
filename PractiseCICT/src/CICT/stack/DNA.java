package CICT.stack;

public class DNA {
    private  int maxCharVal;    //ASCII 0-128   
    private int[][] sm;        // the state machine

	private void buildPatternDFA(String genome) {
		// build state machine from genome
        int M = genome.length();
        sm = new int[maxCharVal][M]; 
        sm[genome.charAt(0)][0] = 1; 
        for (int st = 0, j = 1; j < M; j++) {
            for (int g = 0; g < maxCharVal; g++) 
                sm[g][j] = sm[g][st];       // mismatch copy
            sm[genome.charAt(j)][j] = j+1;   // Set match 
            st = sm[genome.charAt(j)][st];     // Update restart state 
        }
	}
    
    public boolean search(String genome, String gene) {
    	this.maxCharVal = 128; // ASCII 0-127
    	buildPatternDFA(genome); 
        int M = genome.length(), N = gene.length();
        int i, j;
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = sm[gene.charAt(i)][j];
        }
        if (j == M) return true;    // found
        return false;               
    }
    
 //@Test   
/*    public static void main(String[] args) {
		DNA d = new DNA();
		System.out.println(d.search("ACGGT","AAAACCCCCCCCCGGGGGGGGGGACGGTAAGG"));
	}
*/
}
