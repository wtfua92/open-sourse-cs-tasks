
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int stopCodonIndex = dna.indexOf(stopCodon, startIndex + 3);
        boolean multipleOf3 = startIndex + stopCodonIndex % 3 == 0;
        return multipleOf3 ? stopCodonIndex + 3 : dna.length();
    }
    
    public String findGene(String dna) {
        int startIndex = dna.indexOf("ATG");
        
        if (startIndex < 0) {
            return "";
        }
        
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        
        int firstStopCodonIndex = 
            Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        
        return firstStopCodonIndex != dna.length() ? dna.substring(startIndex, firstStopCodonIndex) : "";
    }    
    
    public void printAllGenes(String dna) {
        String newDna = dna;
        while(true) {
            String currentGene = findGene(newDna);
            if (currentGene.length() == 0) {
                break;
            }
            System.out.println("Gene: " + currentGene);
            newDna = newDna.substring(newDna.indexOf(currentGene) + currentGene.length() + 1);
        }
    }    
    
    public void testFindStopCodon() {
        //            0123456789ABCDEF01234567
        String dna = "ATGCCCGGGTTTTAACCCGGGTAG";
        System.out.println("Should be 12: " + findStopCodon(dna, 0, "TAA"));
        System.out.println("Should be 24: " + findStopCodon(dna, 12, "TAA"));
    }
    
    public void testFindGene() {
        String dna = "ATGCCCGGGTTTTAACCCGGGTAG";
        System.out.println("Should be ATGCCCGGGTTTTAA:" + findGene(dna));
        dna = "ATGCCCGGGTTTAACCCCGGGTAGGGC";
        System.out.println("Should be ATGCCCGGGTTTAACCCCGGGTAG:" + findGene(dna));
        dna = "ATGCCCGGGTTTAACCCCGGGTGAGGC";
        System.out.println("Should be ATGCCCGGGTTTAACCCCGGGTGA:" + findGene(dna));
        dna = "ATGCCCGGGTTTAACCCCGGTGAGGC";
        System.out.println("Should be empty string:" + findGene(dna));
    }
    
    public void testPrintAllGenes() {
        String dna = 
            "ATGCCCGGGTTTAACCCCGGGTGAGGCATGCCCGGGTTAACCCGGGTAGATGCCCGGGTTTAACCCCGGGTAGGGCATGCCCGGGTTTAACCCCGGGTGAGGC";
        printAllGenes(dna);
    }
}
