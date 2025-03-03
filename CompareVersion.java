import java.util.Arrays;

public class CompareVersion {

    public static int compareVersion(String version1, String version2) {
        // Split the version strings into parts based on "."
        String[] v1Parts = version1.split("\\.");
        String[] v2Parts = version2.split("\\.");

        // Compare corresponding parts
        int length = Math.max(v1Parts.length, v2Parts.length);
        for(int i = 0; i < length; i++) {
            // Get the revision value for version1, treat missing revisions as 0
//            System.out.println(Arrays.toString(v1Parts));
            int val1 = (i < version1.length()) ? Integer.parseInt(v1Parts[i]) : 0;
            int val2 = (i < version2.length()) ? Integer.parseInt(v2Parts[i]) : 0;

            if(val1 < val2) return -1;
            else if (val1 > val2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Example usage
        String version1 = "1.2";
        String version2 = "1.10";

        System.out.println(compareVersion(version1, version2));
    }
}
