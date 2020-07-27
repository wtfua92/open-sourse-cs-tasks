
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public int howMany(String stringA, String stringB) {
        int occuranceCount = 0;
        int currentIndex = 0;
        while (true) {
            int occuranceIndex = stringB.indexOf(stringA, currentIndex);
            if (occuranceIndex == -1) {
                break;
            }
            
            occuranceCount += 1;
            currentIndex = occuranceIndex + stringA.length();
            
        }
        
        return occuranceCount;
    }
    
    public void testHowMany() {
        System.out.println("Should be 3: " + howMany("GAA", "ATGAACGAATTGAATC"));
        System.out.println("Should be 2: " + howMany("AA", "ATAAAA"));
        System.out.println("Should be 0: " + howMany("AA", "BBB"));
    }
}
