package in.blogspot.randomcompiler.palindrome.partitioning;

public class PalindromePartitioning {
    public static int palindromePartitioning(String input) {
        boolean[][] isPalindrome = new boolean[input.length()][input.length()];
        int[][] minCuts = new int[input.length()][input.length()];
        
        for(int i=0; i<input.length(); i++) {
            isPalindrome[i][i] = true;
            minCuts[i][i] = 0;
        }
        
        for(int len=2; len<=input.length(); len++) {
            for(int i=0; i<=input.length()-len; i++) {
                int j = i + len -1;
                if(j-i == 1) {
                    if(input.charAt(i) == input.charAt(j)) {
                        isPalindrome[i][j] = true;
                        minCuts[i][j] = 0;
                    } else {
                        isPalindrome[i][j] = false;
                        minCuts[i][j] = 1;
                    }
                } else {
                    if(isPalindrome[i+1][j-1]) {
                        if(input.charAt(i) == input.charAt(j)) {
                            isPalindrome[i][j] = true;
                            minCuts[i][j] = 0;
                        } else {
                            isPalindrome[i][j] = false;
                            minCuts[i][j] = Integer.MAX_VALUE;
                            for(int k=i; k<=j-1; k++) {
                                minCuts[i][j] = Math.min(minCuts[i][j], minCuts[i][k]+minCuts[k+1][j]+1);
                            }
                        }
                    } else {
                        isPalindrome[i][j] = false;
                        minCuts[i][j] = Integer.MAX_VALUE;
                        for(int k=i; k<=j-1; k++) {
                            minCuts[i][j] = Math.min(minCuts[i][j], minCuts[i][k]+minCuts[k+1][j]+1);
                        }
                    }
                }
            }
        }
        System.out.println("isPalindrome array for: " + input);
        for(int i=0; i<input.length(); i++) {
            for(int j=0; j<input.length(); j++) {
                System.out.print(isPalindrome[i][j]+" ");
            }
            System.out.println();
        }
        
        System.out.println("minCuts array for: " + input);
        for(int i=0; i<input.length(); i++) {
            for(int j=0; j<input.length(); j++) {
                System.out.print(minCuts[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return minCuts[0][input.length()-1];
    }
}
