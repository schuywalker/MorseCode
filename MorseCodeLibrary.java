import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class MorseCodeLibrary {

        private static final String WORDSPACE = "       ";
        private static final String LETSPACE = "   ";
        private static final String SIGNALSPACE = " ";
        
        private static final Map<Character, String> ENCODE_MAPPINGS = Map.ofEntries(
            Map.entry('A',". ---"),
            Map.entry('B',"--- . . ."),
            Map.entry('C',"--- . --- ."),
            Map.entry('D',"--- . ."),
            Map.entry('E',"."),
            Map.entry('F',". . --- ."),
            Map.entry('G',"--- --- ."),
            Map.entry('H',". . . ."),
            Map.entry('I',". ."),
            Map.entry('J',". --- --- ---"),
            Map.entry('K',"--- . ---"),
            Map.entry('L',". --- . ."),
            Map.entry('M',"--- ---"),
            Map.entry('N',"--- ."),
            Map.entry('O',"--- --- ---"),
            Map.entry('P',". --- --- ."),
            Map.entry('Q',"--- --- . ---"),
            Map.entry('R',". --- ."),
            Map.entry('S',". . ."),
            Map.entry('T',"---"),
            Map.entry('U',". . ---"),
            Map.entry('V',". . . ---"),
            Map.entry('W',". --- ---"),
            Map.entry('X',"--- . . ---"),
            Map.entry('Y',"--- . ------"),
            Map.entry('Z',"--- --- . ."),

            Map.entry('1',". --- --- --- ---"),
            Map.entry('2',". . --- --- ---"),
            Map.entry('3',". . . --- ---"),
            Map.entry('4',". . . . ---"),
            Map.entry('5',". . . . ."),
            Map.entry('6',"--- . . . ."),
            Map.entry('7',"--- --- . . ."),
            Map.entry('8',"--- --- --- . ."),
            Map.entry('9',"--- --- --- --- ."),
            Map.entry('0',"--- --- --- --- ---")
        );
    
        private static final Map<String, Character> DECODE_MAPPINGS = Map.ofEntries(
            Map.entry(". ---", 'A'),
            Map.entry("--- . . .", 'B'),
            Map.entry("--- . --- .", 'C'),
            Map.entry("--- . .", 'D'),
            Map.entry(".", 'E'),
            Map.entry(". . --- .", 'F'),
            Map.entry("--- --- .", 'G'),
            Map.entry(". . . .", 'H'),
            Map.entry(". .", 'I'),
            Map.entry(". --- --- ---", 'J'),
            Map.entry("--- . ---", 'K'),
            Map.entry(". --- . .", 'L'),
            Map.entry("--- ---", 'M'),
            Map.entry("--- .", 'N'),
            Map.entry("--- --- ---", 'O'),
            Map.entry(". --- --- .", 'P'),
            Map.entry("--- --- . ---", 'Q'),
            Map.entry(". --- .", 'R'),
            Map.entry(". . .", 'S'),
            Map.entry("---", 'T'),
            Map.entry(". . ---", 'U'),
            Map.entry(". . . ---", 'V'),
            Map.entry(". --- ---", 'W'),
            Map.entry("--- . . ---", 'X'),
            Map.entry("--- . ------", 'Y'),
            Map.entry("--- --- . .", 'Z'),

            Map.entry(". --- --- --- ---", '1'),
            Map.entry(". . --- --- ---", '2'),
            Map.entry(". . . --- ---", '3'),
            Map.entry(". . . . ---", '4'),
            Map.entry(". . . . .", '5'),
            Map.entry("--- . . . .", '6'),
            Map.entry("--- --- . . .", '7'),
            Map.entry("--- --- --- . .", '8'),
            Map.entry("--- --- --- --- .", '9'),
            Map.entry("--- --- --- --- ---", '0')
        );

        public static String encode(String rawInput) {
                rawInput = rawInput.toUpperCase();
                char[] tokens = rawInput.toCharArray();
                StringBuilder output = new StringBuilder();
                for (int i = 0; i < tokens.length; i++) {
                    if (tokens[i] == ' ') {
                        output.append(WORDSPACE);
                    } else {
                        String mapping = ENCODE_MAPPINGS.get(tokens[i]);
                        output.append((mapping != null) ? mapping : "%");
                        if (i != tokens.length-1) output.append(LETSPACE);
                    }
                }

            return output.toString();
        }

        public static String decode(String morseCode) {
            String[] words = Arrays.stream(morseCode.split(WORDSPACE, -1))
                    .filter(s -> !s.isEmpty())
                    .toArray(String[]::new);
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < words.length; i++) {
                String[] tokens = Arrays.stream(words[i].split(LETSPACE, -1))
                        .filter(letter -> !letter.isEmpty())
                        .toArray(String[]::new);
                for (String token : tokens) {
                    // handle bad inputs
                    if (!token.equals(LETSPACE)) output.append((!token.equals("%")) ? DECODE_MAPPINGS.get(token) : "%");
                }
                if (i != words.length - 1) output.append(SIGNALSPACE);
            }

            return output.toString().trim();
        }
}
