/**
 * Please read over the whole exercise before beginning.
 *  In this exercise you are going to implement a static method matchingTags that 
 * takes a Scanner and returns true iff the text from the scanner source is a 
 * sequence of properly nested HTML tags, possibly with other text. For the opening tag,
 *  such as <p>, there must be a closing tag </p>. A tag such as <p> may have other tags
 *  inside. For example the following html tags are properly matched and nested:
<p> some text <ul> <li> some more <a> wow!
</a> </li> </ul> <a> </a> </p> some more text
The inner tags must be closed before the outer ones. For simplicity, assume the
 tags are separated by whitespace, as is any other text in the file. You must 
 use a stack to help you match tags.
To make this problem easier, we wrote some helper methods for you: isOpening, 
isClosing, and getTagName.
 */

import java.util.*;

public class Exercise4{
    public static boolean matchingTags(Scanner in){
        Stack<String> tagHolder = new Stack<>();
        while (in.hasNext()){
            String tag = in.next();
            if (isOpening(tag)){
                tagHolder.push(tag);
            }
            else if (isClosing(tag)){
                if (tagHolder.empty()){ return false;}
                else{
                    String lastOpenTagName = getTagName(tagHolder.peek());
                    String newCloseTagName = getTagName(tag);
                    if(lastOpenTagName.equals(newCloseTagName)){
                        tagHolder.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if(tagHolder.empty()){
            return true;
        }
        else{
            return false;
        }

    }

    public static boolean isOpening(String s){
        return s.startsWith("<") && !s.startsWith("</") && s.endsWith(">");
    }
    // ✅ Helper method: returns true if token is a closing tag (like </p>)
    private static boolean isClosing(String s) {
        return s.startsWith("</") && s.endsWith(">");
    }

    // ✅ Helper method: extracts tag name (removes <, </, and >)
    private static String getTagName(String s) {
        return s.replaceAll("[</>]", "");
    }
        public static void main(String[] args) {
        String input = "<p> some text <ul> <li> some more <a> wow! </a> </li> </ul> <a> </a> </p> some more text";
        Scanner sc = new Scanner(input);
        System.out.println(matchingTags(sc)); // Expected: true

        String badInput = "<div> <b> text </div> </b>";
        Scanner sc2 = new Scanner(badInput);
        System.out.println(matchingTags(sc2)); // Expected: false
    }
}