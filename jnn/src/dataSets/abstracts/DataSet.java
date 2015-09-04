package dataSets.abstracts;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author michal
 */
public class DataSet {

    public ArrayList<DataSetRecord> dataSet;

    public ArrayList<DataSetRecord> getDataSet() {
        return dataSet;
    }

    public ArrayList<DataSetRecord> getDataSetRandomized() {
        ArrayList<DataSetRecord> dataSetRandomized = new ArrayList(dataSet);
        Collections.shuffle(dataSetRandomized);
        return dataSetRandomized;
    }

    /**
     * Number of parameters (inputs) of the data set.
     *
     * @return
     */
    public int getNumberOfParameters() {
        return dataSet.isEmpty() ? 0 : dataSet.get(0).parameters.length;
    }

    /**
     * Basic check of the consistency of the data set.
     */
    protected void checkDataValidity() {
        int numColumns = -1;
        for (DataSetRecord rec : dataSet) {
            if (numColumns < 0) {
                numColumns = rec.parameters.length;
            } else {
                if (numColumns != rec.parameters.length) {
                    System.out.println("Error: number of columns is not the same in the whole data file!!! " + numColumns + " != " + rec.parameters.length);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (DataSetRecord rec : dataSet) {
            sb.append(rec.toString());
        }
        sb.append("Number of records: ").append(dataSet.size()).append(", parameters per record: ").append(getNumberOfParameters());
        return sb.toString();
    }
}
