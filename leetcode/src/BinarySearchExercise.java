public class BinarySearchExercise {
    public static final int BAD_VERSION = 1702766719;

    public static boolean isBadVersion(long n) {
        if (n >= BAD_VERSION) {
            return true;
        } else {
            return false;
        }
    }

    public static long firstBadVersion(int n) {
        long left = 0, right = n;
        long badVersion = 0;
        while (left <= right) {
            badVersion = (left + right) / 2;
            if (isBadVersion(badVersion) == true) {
                if (isBadVersion(badVersion - 1) == true) {
                    right = badVersion - 2;
                } else {
                    return badVersion;
                }
            } else {
                if (isBadVersion(badVersion + 1) == true) {
                    return badVersion + 1;
                } else {
                    left = badVersion + 2;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
