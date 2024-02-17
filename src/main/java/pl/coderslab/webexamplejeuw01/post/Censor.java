package pl.coderslab.webexamplejeuw01.post;

public class Censor {
    private static String[] DISALLOWED_PHRASES = {
            "kurde", "motyla noga", "cholera"
    };

    public static String doCensor(String toBeCensored) {
        String result = toBeCensored;
        for (String phrase : DISALLOWED_PHRASES) {
            result = result.replaceAll(phrase, "*".repeat(phrase.length()));
        }
        return result;
    }
}
