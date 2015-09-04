package dataSets.abstracts;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author michal
 */
public class DataSetSplit {

    final double trainingSetPerc;
    final int originalSetSize;
    final public ArrayList<DataSetRecord> trainingSet = new ArrayList();
    final public ArrayList<DataSetRecord> testingSet = new ArrayList();

    public DataSetSplit(double trainingSetPerc, List<DataSetRecord> dataSetRandomized) {
        this.trainingSetPerc = trainingSetPerc;

        this.originalSetSize = dataSetRandomized.size();
        int sizeTrainingSet = (int) (originalSetSize * trainingSetPerc / 100.0 + 0.5);
        if (sizeTrainingSet > dataSetRandomized.size()) {
            sizeTrainingSet = dataSetRandomized.size();
        }
        if (sizeTrainingSet < 0) {
            sizeTrainingSet = 0;
        }
        trainingSet.addAll(dataSetRandomized.subList(0, sizeTrainingSet));
        testingSet.addAll(dataSetRandomized.subList(sizeTrainingSet, originalSetSize));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Original set size: ").append(originalSetSize);
        sb.append(" Training split: ").append(trainingSet.size());
        sb.append(" Testing set: ").append(testingSet.size());
        sb.append("\nTraining:\n");
        for (DataSetRecord dsr : trainingSet) {
            sb.append("   ").append(dsr.toString()).append('\n');
        }
        sb.append("\nTesting:\n");
        for (DataSetRecord dsr : testingSet) {
            sb.append("   ").append(dsr.toString()).append('\n');
        }
        return sb.toString();
    }
}
