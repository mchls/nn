package dataSets.abstracts;

/**
 *
 * @author michal
 */
public class DataSetRecord {

    final public double[] parameters;
    final public double correctResult;

    public DataSetRecord(double[] parameters, double correctResult) {
        this.parameters = parameters;
        this.correctResult = correctResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("parameters x1-x").append(parameters.length).append(": ");
        for (int i = 0; i < parameters.length; i++) {
            sb.append(String.format("%5.2f ", parameters[i]));
        }
        sb.append("correct results y: ");
        sb.append(String.format("%5.2f ", correctResult));
        return sb.toString();
    }
}
