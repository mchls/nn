package data;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Test data - parameters of houses and their prices
 * 
 * @author michal
 */
public class HousingData {
    public static final String HOUSING_DATA = "/home/michal/pgms/michals/nn/jnn/stanford_dl_ex/ex1/housing.data";
    public List<HousingRecord> housingData;

    public static class HousingRecord {

        public double[] row;

        public HousingRecord(double[] row) {
            this.row = row;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < row.length; i++) {
                sb.append(String.format("%4.2f ", row[i]));
            }
            return sb.toString();
        }
    }

    public HousingData() {
        this.housingData = loadHousingData(HOUSING_DATA);
    }
    
        
    /**
     * Parse all housing data.
     * 
     * @param fileName
     * @return 
     */
    private static List<HousingRecord> loadHousingData(String fileName) {
        System.out.println("Loading file " + fileName);
        List<HousingRecord> list = new LinkedList();
        BufferedReader in = null;
        try {
            try {
                in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    line = line.trim().replaceAll(" +", " ");
                    String split[] = line.split(" ", -1);
                    double[] row = new double[split.length];
                    for (int i = 0; i < split.length; i++) {
                        row[i] = Double.parseDouble(split[i]);
                    }
                    list.add(new HousingRecord(row));
                }
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
        return list;
    }
}
