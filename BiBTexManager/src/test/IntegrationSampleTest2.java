package test;

import main.BibtexDatabase;
import main.BibtexManager;
import main.BibtexParser;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Defines a test which checks proper behaviour of cooperating classes.
 */

public class IntegrationSampleTest2 {

    String fileName = "src/test/IntegrationSampleTestFile2.txt";
    ArrayList<String> authors = new ArrayList<>();
    ArrayList<String> categories = new ArrayList<>();
    Character sign = '*';

    BibtexManager manager;

    @Before

    public void CreateData() throws IOException{



        authors.add("Donald E. Knuth");
        authors.add("Paul Pot");
        authors.add("Mihalis Yannakakis");

        categories.add("article");

        manager = new BibtexManager(fileName,categories,authors, sign);


    }


    @Test

    public void checkingRequiredFields() throws Exception {

        manager.getParser().parse();

        manager.getPresenter().present();



    }
}
