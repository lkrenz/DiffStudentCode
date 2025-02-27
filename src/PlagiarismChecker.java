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

        int[][] paths = new int[doc1.length() + 1][doc2.length() + 1];
        int lowCol = 0;
        int highest = 0;
        doc1 = " " + doc1;
        doc2 = " " + doc2;

        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[i].length; j++) {
                int max = 0;
                if (doc1.charAt(i) == doc2.charAt(j)) max = paths[i - 1][j-1] + 1;
                else max = Math.max(paths[i - 1][j], paths[i][j-1]);
                paths[i][j] = max;
            }
        }
        return paths[doc1.length() - 1][doc2.length() - 1];
    }
}
