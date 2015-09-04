package ui;

import dataSets.HousingData;
import dataSets.HousingData.HousingRecord;
import dataSets.abstracts.DataSetRecord;
import dataSets.abstracts.DataSetSplit;
import java.util.List;
import java.util.Random;

/**
 * http://ufldl.stanford.edu/tutorial/supervised/LinearRegression/
 *
 * @author michal
 */
public class LinReg {

    public static class Theta {

        /**
         * The size is numberOfInputs+1 (the intercept is the first value).
         */
        final double[] theta;

        private Theta(double[] theta) {
            this.theta = theta;
        }

        /**
         * Generated the vector as random values. The size of the vector will be numInputs+1 as the first value is the
         * intercept one.
         *
         * @param numInputs
         * @return
         */
        public static Theta factoryGenerateRandom(int numInputs) {
            double[] values = new double[numInputs + 1];
            Random rg = new Random();
            for (int i = 0; i < values.length; i++) {
                values[i] = rg.nextDouble();
            }
            return new Theta(values);
        }

        /**
         * Calculate the output value.
         * <pre>
         * y=theta_0+theta_1*x_1+theta_2*x_2+...+theta_N*x_N
         * </pre>
         *
         * @param x
         * @return
         */
        public double calculateOutputY(double[] x) {
            double result = theta[0]; // base
            for (int i = 1; i < theta.length; i++) {
                result += theta[i] * x[i - 1];
            }
            return result;
        }

        /**
         * Cost.
         * <pre>
         * 1/2*sum(h_theta(x^(i))-y^(i))^2
         * </pre>
         *
         * @param dataSet
         * @return
         */
        public double costFunction(List<DataSetRecord> dataSet) {
            double cost = 0.0;
            for (DataSetRecord hr : dataSet) {
                double predicted = calculateOutputY(hr.parameters);
                cost += 0.5 * (predicted - hr.correctResult) * (predicted - hr.correctResult);
            }
            return cost;
        }

        public Theta train(List<DataSetRecord> dataSet, double alpha) {
            double[] newTheta = new double[theta.length];
            double[] err = new double[dataSet.size()];
            double errSum = 0.0;
            int i = 0;
            for (DataSetRecord hr : dataSet) {
                err[i] = hr.correctResult - calculateOutputY(hr.parameters);
                errSum += err[i];
                i++;
            }
            newTheta[0] = theta[0] + alpha * errSum;
            for (int j = 1; j < theta.length; j++) {
                i = 0;
                for (DataSetRecord hr : dataSet) {
                    newTheta[j] = theta[j] + alpha * err[i] * hr.parameters[j - 1];
                    i++;
                }
            }
            return new Theta(newTheta);
        }
    }

    public void run() {
        HousingData hd = new HousingData();
        //System.out.println("Input housing data:\n" + hd.toString());
        Theta theta = Theta.factoryGenerateRandom(hd.getNumberOfParameters());
        DataSetSplit dsp = new DataSetSplit(30.0, hd.getDataSetRandomized());
        //System.out.println("DataSetSplit: "+dsp);
        for (int i = 0; i < 10; i++) {
            double errBefore = theta.costFunction(dsp.trainingSet);
            theta = theta.train(dsp.trainingSet, 0.001);
            double errAfter = theta.costFunction(dsp.trainingSet);
            System.out.format("ErrBefore: %1.2f ErrAfter: %1.2f ErrDiff: %1.2f\n", errBefore, errAfter, errAfter - errBefore);
        }
    }
}
