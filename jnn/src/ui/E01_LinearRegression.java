package ui;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * http://ufldl.stanford.edu/tutorial/supervised/LinearRegression/
 *
 * @author michal
 */
public class E01_LinearRegression {

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

    public void run() {
        housingData = loadHousingData(HOUSING_DATA);
        int numRecords = housingData.size();
        int numColumns = -1;
        for (HousingRecord rec : housingData) {
            if (numColumns < 0) {
                numColumns = rec.row.length;
            } else {
                if (numColumns != rec.row.length) {
                    System.out.println("Error: number of columns is not the same in the whole data file!!! " + numColumns + " != " + rec.row.length);
                }
            }
        }

        int rowNumber = 0;
        for (HousingRecord rec : housingData) {
            System.out.format("Line %5d: %s\n", rowNumber++, rec.toString());
        }
        System.out.println("Hohusing data: number of records: " + numRecords + " parameters per record: " + numColumns);
    }

    public static List<HousingRecord> loadHousingData(String fileName) {
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
