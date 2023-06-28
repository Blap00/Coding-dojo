package ManipulacionCadenas;

public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        return str1.trim() + str2.trim();
    }
    
    public int getIndexOrNull(String str, char letter) {
        return str.indexOf(letter);
    }
    
    public int getIndexOrNull(String str, String subString) {
        return str.indexOf(subString);
    }
    
    public String concatSubstring(String str, int startIndex, int endIndex, String concatStr) {
        return str.substring(startIndex, endIndex) + concatStr;
    }
}
