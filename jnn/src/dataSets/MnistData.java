package dataSets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Reading of the MNIST database of training and testing handwritten images
 *
 * @author michal
 */
public class MnistData {

    public static final String MNIST_BASE = "/home/michal/pgms/michals/nn/jnn/stanford_dl_ex/common/";
    public static final String MNIST_TRAIN_LABELS = "train-labels-idx1-ubyte";
    public static final String MNIST_TRAIN_IMAGES = "train-images-idx3-ubyte";
    public static final String MNIST_TEST_LABELS = "t10k-labels-idx1-ubyte";
    public static final String MNIST_TEST_IMAGES = "t10k-images-idx3-ubyte";
    final public boolean isTestSet;
    public ArrayList<Item> data = new ArrayList();

    /**
     * Single image and its label.
     */
    public static class Item {

        final public int label;
        final public byte[][] image;

        public Item(int label, byte[][] image) {
            this.label = label;
            this.image = image;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Label: ").append(label).append("\n");
            for (int y = 0; y < image.length; y++) {
                for (int x = 0; x < image[0].length; x++) {
                    sb.append(String.format("%4d ", image[x][y] & 0xff));
                }
                sb.append('\n');
            }
            return sb.toString();
        }
    }

    /**
     * The whole database of testing or training data.
     *
     * @param isTestSet
     */
    public MnistData(boolean isTestSet) {
        this.isTestSet = isTestSet;
        loadData(MNIST_BASE + (isTestSet ? MNIST_TEST_LABELS : MNIST_TRAIN_LABELS),
                MNIST_BASE + (isTestSet ? MNIST_TEST_IMAGES : MNIST_TRAIN_IMAGES));
    }

    /**
     * Load the whole data set
     *
     * @param inFileLabels
     * @param inFileImages
     */
    private void loadData(String inFileLabels, String inFileImages) {
        int[] labels = loadDataLabels(inFileLabels);
        if (labels == null) {
            return;
        }
        DataInputStream in = null;
        try {
            try {
                File file = new File(inFileImages);
                long size = file.length();
                in = new DataInputStream(new BufferedInputStream(new FileInputStream(inFileImages)));
                long bytesRead = 0;
                int expectedMagicNumber = 2051;
                int magicNumber = in.readInt();
                bytesRead += 4;
                if (magicNumber != expectedMagicNumber) {
                    System.out.println("Error reading magic number " + magicNumber + "!=" + expectedMagicNumber + " of the file " + inFileImages);
                    return;
                }
                int numberOfItems = in.readInt();
                bytesRead += 4;
                int numberOfRows = in.readInt();
                bytesRead += 4;
                int numberOfColumns = in.readInt();
                bytesRead += 4;
                System.out.println("Magic: " + magicNumber + " Number of items: " + numberOfItems
                        + " Columns x rows: " + numberOfColumns + " x " + numberOfRows
                        + " Bytes to be read: " + (size - bytesRead));
                if ((numberOfItems * numberOfColumns * numberOfRows) != (size - bytesRead)) {
                    System.out.println("Wrong file length! Expected: " + (numberOfItems * numberOfColumns * numberOfRows + bytesRead) + " Found: " + size + " File: " + inFileImages);
                    return;
                }
                for (int item = 0; item < numberOfItems; item++) {
                    byte[][] image = new byte[numberOfColumns][numberOfRows];
                    for (int y = 0; y < numberOfRows; y++) {
                        for (int x = 0; x < numberOfColumns; x++) {
                            image[x][y] = in.readByte();
                        }
                    }
                    Item it = new Item(labels[item], image);
                    data.add(it);
                }
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }

    /**
     * Load labels belonging to the image data
     *
     * @param inFile
     * @return
     */
    private int[] loadDataLabels(String inFile) {
        DataInputStream in = null;
        try {
            try {
                File file = new File(inFile);
                long size = file.length();
                in = new DataInputStream(new BufferedInputStream(new FileInputStream(inFile)));
                long bytesRead = 0;
                int expectedMagicNumber = 2049;
                int magicNumber = in.readInt();
                bytesRead += 4;
                if (magicNumber != expectedMagicNumber) {
                    System.out.println("Error reading magic number " + magicNumber + "!=" + expectedMagicNumber + " of the file " + inFile);
                    return null;
                }
                int numberOfItems = in.readInt();
                bytesRead += 4;
                System.out.println("Magic: " + magicNumber + " Number of items: " + numberOfItems + " Bytes to be read: " + (size - bytesRead));
                if (numberOfItems != (size - bytesRead)) {
                    System.out.println("Wrong file length! Expected: " + (numberOfItems + bytesRead) + " Found: " + size + " File: " + inFile);
                    return null;
                }
                int labels[] = new int[numberOfItems];
                for (int i = 0; i < numberOfItems; i++) {
                    labels[i] = in.readByte();
                }
                return labels;
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
        return null;
    }
}
