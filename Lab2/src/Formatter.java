import java.util.HashMap;
import java.util.Map;


public class Formatter {
    static boolean performFormat = true;
    /**
     * Formats a string with given format options, text and background color.<br/>
     * Formatting options:
     * <li> B - Bold</li>
     * <li> I - Italic</li>
     * <li> U - Underline</li>
     * <li> W - Inverse background and text color</li>
     * <li> S - Strikethrough</li>
     * <br/>
     * Color options:
     * <li> B - Black</li>
     * <li> R - Red</li>
     * <li> G - Green</li>
     * <li> Y - Yellow</li>
     * <li> M - Magenta</li>
     * <li> C - Cyan</li>
     * <li> W - White</li>
     * <li> D - Default - resets color</li>
     *
     * @param str             String to format
     * @param formats         String of formatting options as letters
     * @param textColor       String with text color letter
     * @param backgroundColor String with background color letter
     * @return formatted string
     */
    public static String format(String str, String formats, String textColor, String backgroundColor) {
        if (!performFormat) return str;
        str = setColor(str, textColor, backgroundColor);
        for (int i = 0; i < formats.length(); i++) {
            switch (formats.charAt(i)) {
                case 'B':
                    str = bold(str);
                    break;
                case 'I':
                    str = italic(str);
                    break;
                case 'U':
                    str = underline(str);
                    break;
                case 'W':
                    str = inverse(str);
                    break;
                case 'S':
                    str = strikethrough(str);
                    break;
                default:
                    break;
            }

        }

        return endFormat(str);

    }

    /**
     * Formats a string with given format options, text and background color.<br/>
     * Formatting options:
     * <li> B - Bold</li>
     * <li> I - Italic</li>
     * <li> U - Underline</li>
     * <li> W - Inverse background and text color</li>
     * <li> S - Strikethrough</li>
     * <br/>
     * Color options:
     * <li> B - Black</li>
     * <li> R - Red</li>
     * <li> G - Green</li>
     * <li> Y - Yellow</li>
     * <li> M - Magenta</li>
     * <li> C - Cyan</li>
     * <li> W - White</li>
     * <li> D - Default - resets color</li>
     *
     * @param str             String to format
     * @param formats         String of formatting options as letters
     * @param textColor       String with text color letter
     * @return formatted string
     */
    public static String format(String str, String formats, String textColor) {
        return format(str, formats, textColor, "D");
    }

    /**
     * Formats a string with given format options, text and background color.<br/>
     * Formatting options:
     * <li> B - Bold</li>
     * <li> I - Italic</li>
     * <li> U - Underline</li>
     * <li> W - Inverse background and text color</li>
     * <li> S - Strikethrough</li>
     *
     * @param str             String to format
     * @param formats         String of formatting options as letters
     * @return formatted string
     */
    public static String format(String str, String formats) {
        return format(str, formats, "D");
    }

    public static String format(String str, FormatterOptions options) {
        return format(str, options.format, options.textColor, options.backgroundColor);
    }

    private static String bold(String str) {
        return "\033[1m" + str;
    }

    private static String italic(String str) {
        return "\033[3m" + str;
    }

    private static String underline(String str) {
        return "\033[4m" + str;
    }

    private static String inverse(String str) {
        return "\033[7m" + str;
    }

    private static String strikethrough(String str) {
        return "\033[9m" + str;
    }

    private static String setColor(String str, String textColor, String backColor) {
        str = String.format("\033[%dm", codeByColorLetter(backColor.charAt(0)) + 10) + str;
        return String.format("\033[%dm", codeByColorLetter(textColor.charAt(0))) + str;
    }

    private static int codeByColorLetter(char colorLetter) {
        switch (colorLetter) {
            case 'B':
                return 30;
            case 'R':
                return 31;
            case 'G':
                return 32;
            case 'Y':
                return 33;
            case 'M':
                return 35;
            case 'C':
                return 36;
            case 'W':
                return 37;
            case 'D':
                return 39;
            default:
                return 0;

        }
    }

    static String test(String str) {
        return "\033[1m" + str + "\033[0;0m";
    }

    private static String endFormat(String str) {
        return str + "\033[0;0m";
    }
}

class FormatterOptions {
    String format = "";
    String textColor = "";
    String backgroundColor = "";
    FormatterOptions(String _format, String _textColor, String _backgroundColor) {
        format = _format;
        textColor = _textColor;
        backgroundColor = _backgroundColor;
    }
    FormatterOptions(String _format, String _textColor) {
        format = _format;
        textColor = _textColor;
        backgroundColor = "_backgroundColor";
    }
    FormatterOptions(String _format) {
        format = _format;
        textColor = "";
        backgroundColor = "_backgroundColor";
    }
}
