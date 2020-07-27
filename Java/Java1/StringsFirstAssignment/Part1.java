
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna) {
        String START_CODON = "ATG";
        String STOP_CODON = "TAA";
        String ERROR_MSG = "No valid gene";
        int startIndex = dna.indexOf(START_CODON);
        if (startIndex < 0) {
            return ERROR_MSG;
        }
        int endIndex = dna.indexOf(STOP_CODON, startIndex + 3);
        
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
        String gene = findSimpleGene(dna);
        System.out.println("Gene: " + gene);
        
        dna = "ATGGCAAGATTAGGTAA";
        gene = findSimpleGene(dna);
        System.out.println("Gene: " + gene);
        
        dna = "ATTGCAAGATTAGGTAA";
        gene = findSimpleGene(dna);
        System.out.println("Gene: " + gene);
        
        dna = "ATGCAAGATTAGGTTA";
        gene = findSimpleGene(dna);
        System.out.println("Gene: " + gene);
        
    }
}
