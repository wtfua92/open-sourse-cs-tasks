
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        String ERROR_MSG = "No valid gene";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex < 0) {
            return ERROR_MSG;
        }
        int endIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        if (endIndex < 0) {
            return ERROR_MSG;
        }
        
        if ((endIndex - startIndex) % 3 > 0) {
            return ERROR_MSG;
        }
        
        return dna.substring(startIndex, endIndex);
    }
    
    public void testSimpleGene() {
        String dna = "AGTCAATGCAAGATTAGTAACCAG";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene: " + gene);

        gene = findSimpleGene(dna.toLowerCase(), startCodon.toLowerCase(), stopCodon.toLowerCase());
        System.out.println("Gene: " + gene);
        
        dna = "ATGGCAAGATTAGGTAA";
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene: " + gene);
        
        dna = "ATTGCAAGATTAGGTAA";
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene: " + gene);
        
        dna = "ATGCAAGATTAGGTTA";
        gene = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Gene: " + gene);
        
    }
}
