import org.mindrot.jbcrypt.BCrypt;

public class JavaHashGen {

    // Function to generate bcrypt hash
    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    // Function to verify password against stored hash
    public static boolean check(String password, String hashed) {
        return BCrypt.checkpw(password, hashed);
    }

    public static void main(String[] args) {

        // 🔥 Replace "YOUR_PASSWORD_HERE" with your actual password
        String passwordToHash = "HajiSA@67";

        // Generate hash
        String generatedHash = hash(passwordToHash);

        // Print generated hash for Firestore storage
        System.out.println("Generated Hash: " + generatedHash);

        // Optional: verify it works
        boolean isMatch = check(passwordToHash, generatedHash);
        System.out.println("Password matches hash: " + isMatch);
    }
}
