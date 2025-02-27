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

        int[][] paths = new int[doc1.length()][doc2.length()];
        int lowCol = 0;
        int highest = 0;

        for (int i = 0; i < doc1.length(); i++) {
            for (int j = lowCol; j < doc2.length(); j++) {
                int max = 0;
                if (i > 0) max = Math.max(max, paths[i-1][j]);
                if (j > 0) max = Math.max(max, paths[i][j-1]);
                if (doc1.charAt(i) == doc2.charAt(j)) {
                    if (j > 0 && i > 0) {

                    }
                }
                else paths[i][j] = max;
            }
        }
        return highest;
    }
}
