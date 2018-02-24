
package test;

import main.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



import java.io.PushbackReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Defines some tests to check the behaviour of crucial methods in the programm.
 */

public class BibtexParserUnitTests {

    private Reader reader;
    private BibtexParser parser;
    private Reader reader2;
    private BibtexParser parser2;
    private BibtexDatabase db;



       @Before
    public void createData() throws FileNotFoundException {

            reader = new FileReader("src/test/BibtexParserUnitTestFile.txt");
            reader2 = new FileReader("src/test/BibtexParserUnitTestFile2.txt");
            db = new BibtexDatabase();
            parser = new BibtexParser(reader, db);
            parser2 = new BibtexParser(reader2,db);


        }


    @Test

    public void SkipWhiteSpaceTest() throws IOException {

           parser.parseTextWord();
           parser.skipWhitespace();

        int c = parser.getPushBackReader().read();
        System.out.println(c);

        Assert.assertEquals('i', c  );

    }


    @Test

    public void moveForwardUntilTest() throws IOException {



          Assert.assertTrue(parser.moveForwardUntil('*'));

          int c = parser.getPushBackReader().read();
          Assert.assertEquals(' ',c);

    }


    @Test

    public void parseTextWordTest() throws IOException{

        Assert.assertEquals("this", parser.parseTextWord());
        Assert.assertEquals("is", parser.parseTextWord());
        Assert.assertEquals("sample", parser.parseTextWord());
        Assert.assertEquals("file", parser.parseTextWord());
        Assert.assertEquals("with", parser.parseTextWord());
        Assert.assertEquals("random", parser.parseTextWord());
        Assert.assertEquals("words", parser.parseTextWord());


    }


    @Test

    public void parseFieldTest()throws IOException{


           reader2.read();
           Assert.assertEquals("jabadaba dooo", parser2.parseField());

    }


    @Test

    public void parseVariableTest() throws IOException{

           parser2.moveForwardUntil('{');
           parser2.getPushBackReader().unread('{');
           parser2.parseVariable();

           Assert.assertEquals("test passed:)", db.getVariables().get("variable"));


    }


    @Test

    public void parseEntryKeyAndField() throws IOException{

    parser2.moveForwardUntil('{');
    parser2.moveForwardUntil('{');

        Assert.assertEquals("crossref", parser2.parseEntryKey());
        Assert.assertEquals(" whole-set", parser2.parseEntryField());

    }


}



