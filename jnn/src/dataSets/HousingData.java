package dataSets;

import dataSets.abstracts.DataSet;
import dataSets.abstracts.DataSetRecord;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Test data - parameters of houses and their prices
 *
 * @author michal
 */
public class HousingData extends DataSet {

    public static final String HOUSING_DATA = "/home/michal/pgms/michals/nn/jnn/stanford_dl_ex/ex1/housing.data";

    public static class HousingRecord extends DataSetRecord {

        public int lineNumber;

        public HousingRecord(int lineNumber, double[] houseParameters, double housePrice) {
            super(houseParameters, housePrice);
            this.lineNumber = lineNumber;
        }
    }

    public HousingData() {
        this.dataSet = loadHousingData(HOUSING_DATA);
        checkDataValidity();
    }

    /**
     * Parse all housing data.
     *
     * @param fileName
     * @return
     */
    private static ArrayList<DataSetRecord> loadHousingData(String fileName) {
        System.out.println("Loading file " + fileName);
        ArrayList<DataSetRecord> list = new ArrayList();
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
}
