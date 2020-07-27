
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    private boolean twoOccurrences(String stringA, String stringB) {
        int firstOccurrence = stringB.indexOf(stringA);
        
        if (firstOccurrence < 0) {
            return false;
        }
        
        int secondOccurrence = 
            stringB.indexOf(stringA, firstOccurrence + stringA.length());
        
        if (secondOccurrence < 0) {
            return false;
        }
            
        return true;
    }
    
    private String lastPart(String stringA, String stringB) {
        int firstOccurrence = stringB.indexOf(stringA);
    
        if (firstOccurrence < 0) {
            return stringB;
        }
        
        return stringB.substring(firstOccurrence + stringA.length());
    }
    
    public void testing() {
        String stringA = "a";
        String stringB = "abca";
        
        boolean result = twoOccurrences(stringA, stringB);
        System.out.println("Should be true: " + result);
        
        stringB = "aabc";
        result = twoOccurrences(stringA, stringB);
        System.out.println("Should be true: " + result);
        
        stringB = "abc";
        result = twoOccurrences(stringA, stringB);
        System.out.println("Should be false: " + result);
        
        stringA = "by";
        stringB = "A story by Abby Long";
        result = twoOccurrences(stringA, stringB);
        System.out.println("Should be true: " + result);
        
        stringB = "Story author - Abby Long";
        result = twoOccurrences(stringA, stringB);
        System.out.println("Should be false: " + result);
        
        stringB = "Story author - AbbyLong";
        String newResult = lastPart(stringA, stringB);
        System.out.println("Should be 'Long': " + newResult);
        
        stringA = "zoo";
        stringB = "Story author - AbbyLong";
        newResult = lastPart(stringA, stringB);
        System.out.println("Should be 'Story author - AbbyLong': " + newResult);
    }
}
