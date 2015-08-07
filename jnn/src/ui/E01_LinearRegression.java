package ui;

import data.HousingData;
import data.HousingData.HousingRecord;

/**
 * http://ufldl.stanford.edu/tutorial/supervised/LinearRegression/
 *
 * @author michal
 */
public class E01_LinearRegression {

    public void run() {
        HousingData hd = new HousingData();

        int numRecords = hd.housingData.size();
        int numColumns = -1;
        for (HousingRecord rec : hd.housingData) {
            if (numColumns < 0) {
                numColumns = rec.row.length;
            } else {
                if (numColumns != rec.row.length) {
                    System.out.println("Error: number of columns is not the same in the whole data file!!! " + numColumns + " != " + rec.row.length);
                }
            }
        }

        int rowNumber = 0;
        for (HousingRecord rec : hd.housingData) {
            System.out.format("Line %5d: %s\n", rowNumber++, rec.toString());
        }
        System.out.println("Hohusing data: number of records: " + numRecords + " parameters per record: " + numColumns);
    }
}
