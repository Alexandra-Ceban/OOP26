public class FillMethod {
   
    public static String fill(String message, Object... args) {
        StringBuilder result = new StringBuilder();
        int nextArg = 0;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);

            if (c == '%' && nextArg < args.length) {
                result.append(args[nextArg]);
                nextArg++;
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}

