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

        public int lineNumber;
        public double[] houseParameters;
        public double housePrice;

        public HousingRecord(int lineNumber, double[] houseParameters, double housePrice) {
            this.lineNumber = lineNumber;
            this.houseParameters = houseParameters;
            this.housePrice = housePrice;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("parameters x1-x").append(houseParameters.length).append(": ");
            for (int i = 0; i < houseParameters.length; i++) {
                sb.append(String.format("%5.2f ", houseParameters[i]));
            }
            sb.append("price y: ");
            sb.append(String.format("%5.2f ", housePrice));
            return sb.toString();
        }
    }

    public HousingData() {
        this.housingData = loadHousingData(HOUSING_DATA);
        checkDataValidity();
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
                int lineNumber = 0;
                while ((line = in.readLine()) != null) {
                    lineNumber++;
                    line = line.trim().replaceAll(" +", " ");
                    String split[] = line.split(" ", -1);
                    double[] houseParameters = new double[split.length - 1];
                    for (int i = 0; i < split.length - 1; i++) {
                        houseParameters[i] = Double.parseDouble(split[i]);
                    }
                    double housePrice = Double.parseDouble(split[split.length - 1]);
                    list.add(new HousingRecord(lineNumber, houseParameters, housePrice));
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

    /**
     * Basic check of the consistency of the data set.
     */
    private void checkDataValidity() {
        int numColumns = -1;
        for (HousingRecord rec : housingData) {
            if (numColumns < 0) {
                numColumns = rec.houseParameters.length;
            } else {
                if (numColumns != rec.houseParameters.length) {
                    System.out.println("Error: number of columns is not the same in the whole data file!!! " + numColumns + " != " + rec.houseParameters.length);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int numColumns = -1;
        for (HousingRecord rec : housingData) {
            sb.append(String.format("Line %5d: %s\n", rec.lineNumber, rec.toString()));
            if (numColumns < 0) {
                numColumns = rec.houseParameters.length;
            }
        }
        sb.append("Number of records: ").append(housingData.size()).append(numColumns >= 0 ? (", parameters per record: " + numColumns) : "");
        return sb.toString();
    }
}
