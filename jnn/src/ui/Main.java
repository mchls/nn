package ui;

import data.MnistData;

/**
 * http://ufldl.stanford.edu/tutorial/ Starter code: git clone https://github.com/amaas/stanford_dl_ex Data should go to
 * the common folder: http://ai.stanford.edu/~amaas/data/data.zip
 *
 * @author michal
 */
public class Main {

    public static void main(String[] args) {
        LinReg e01 = new LinReg();
        e01.run();
//        MnistData train = new MnistData(true);
//        for (int i = 0; i < 10; i++) {
//            System.out.println(train.data.get(i));
//        }
    }
}
