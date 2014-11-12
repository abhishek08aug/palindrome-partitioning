package in.blogspot.randomcompiler.palindrome.partitioning;

public class PalindromePartitioningDemo {

    public static void main(String[] args) {
        System.out.println("Minimum cuts for ABBAABBA is: " + PalindromePartitioning.palindromePartitioning("ABBAABBA"));
        System.out.println("Minimum cuts for ABCCBA is: " + PalindromePartitioning.palindromePartitioning("ABCCBA"));
        System.out.println("Minimum cuts for ABB is: " + PalindromePartitioning.palindromePartitioning("ABB"));
    }

}
