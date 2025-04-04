package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvLoader {
    private static final Dotenv dotenv = Dotenv.configure()
            .filename(".env")
            .ignoreIfMissing()
            .load();

    public static String get(String key) {
        return dotenv.get(key);
    }
}
