
/**
 * Write a description of WhichCountry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountry {
    public String countryInfo(CSVParser parser, String country) {
        String countryName = "";
        String export = "";
        String value = "";
        for (CSVRecord r: parser) {
            countryName = r.get("Country");
            if (countryName.equals(country)) {
                export = r.get("Exports");
                value = r.get("Value (dollars)");
                break;
            }
        }
        
        if (export.length() > 0) {
            return countryName + ": " + export + ": " + value;
        }
        
        return "NOT FOUND";
    }    
    
    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord r: parser) {
            String export = r.get("Exports");
            
            if (export.contains(exportItem1) && export.contains(exportItem2)) {
                System.out.println(r.get("Country"));
            }
        }
    }
    
    public int numberOfExports(CSVParser parser, String exportItem) {
        int result = 0;
        
        for (CSVRecord r: parser) {
            String export = r.get("Exports");
            if (export.contains(exportItem)) {
                result += 1;
            }
        }
        
        return result;
    }
    
    public void bigExporters(CSVParser parser, String amount) {
        for (CSVRecord r: parser) {
            String value = r.get("Value (dollars)");
            
            if (value.length() > amount.length()) {
                System.out.println(r.get("Country") + " " + value);
            }
        }
    }
    
    public void tester() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Germany"));
        
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        parser = fr.getCSVParser();
        System.out.println(numberOfExports(parser, "gold"));
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }
}
