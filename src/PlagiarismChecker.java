import java.util.Arrays;

/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author YOUR NAME HERE
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // Array to hold the length of paths taken to reach a particular index
        int[][] paths = new int[doc1.length() + 1][doc2.length() + 1];

        // Adds a place holder space to the front of each string for out of bounds cases
        doc1 = " " + doc1;
        doc2 = " " + doc2;

        // Row major iteration through the 2D array
        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[i].length; j++) {

                // At each index, if the current char in both strings match, take the diagonal and add one
                // Otherwise, take the max of the upward or leftward paths
                int max = 0;
                if (doc1.charAt(i) == doc2.charAt(j)) max = paths[i - 1][j-1] + 1;
                else max = Math.max(paths[i - 1][j], paths[i][j-1]);
                paths[i][j] = max;
            }
        }
        return paths[doc1.length() - 1][doc2.length() - 1];
    }
}
