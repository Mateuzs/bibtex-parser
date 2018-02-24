package test;

import main.BibtexDatabase;
import main.BibtexParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

/**
 * Defines a test which tests behaviour of the whole program, from begin to end.
 */
public class IntegrationSampleTest {

    private Reader reader;
    private BibtexParser parser;
    private BibtexDatabase db;



    @Before

   public void  CreateData() throws FileNotFoundException{

        reader = new FileReader("src/test/IntegrationSampleTestFile.txt");
        db = new BibtexDatabase();
        parser = new BibtexParser(reader,db);

    }


    @Test

    public void parseTest() throws Exception {

        parser.parse();

        Assert.assertTrue(db.getEntries().containsKey("ARTICLE (whole-journal)") );
        Assert.assertTrue(db.getEntries().containsKey("INBOOK (inbook-minimal)") );
        Assert.assertTrue(db.getEntries().containsKey("INBOOK (inbook-full)") );

        Assert.assertEquals("[volume, number, note, journal, month, year, key]", db.getEntries().get("ARTICLE (whole-journal)").getFields().keySet().toString());
        Assert.assertEquals("[chapter, year, author, publisher, title]", db.getEntries().get("INBOOK (inbook-minimal)").getFields().keySet().toString());
        Assert.assertEquals("[chapter, note, address, year, author, edition, title, type, volume, pages, month, series, publisher]", db.getEntries().get("INBOOK (inbook-full)").getFields().keySet().toString());


        Assert.assertEquals("Donald E. Knuth", db.getEntries().get("INBOOK (inbook-minimal)").getFields().get("author"));
        Assert.assertEquals("Fundamental Algorithms", db.getEntries().get("INBOOK (inbook-minimal)").getFields().get("title"));
        Assert.assertEquals("Addison-Wesley", db.getEntries().get("INBOOK (inbook-minimal)").getFields().get("publisher"));
        Assert.assertEquals("1973", db.getEntries().get("INBOOK (inbook-minimal)").getFields().get("year"));
        Assert.assertEquals("1.2", db.getEntries().get("INBOOK (inbook-minimal)").getFields().get("chapter"));

        Assert.assertEquals("GAJ", db.getEntries().get("ARTICLE (whole-journal)").getFields().get("key") );
        Assert.assertEquals("mboxG-Animal`s Journal",  db.getEntries().get("ARTICLE (whole-journal)").getFields().get("journal"));
        Assert.assertEquals("1986",  db.getEntries().get("ARTICLE (whole-journal)").getFields().get("year"));
        Assert.assertEquals("41",  db.getEntries().get("ARTICLE (whole-journal)").getFields().get("volume"));
        Assert.assertEquals("7",  db.getEntries().get("ARTICLE (whole-journal)").getFields().get("number"));
        Assert.assertEquals("jul",  db.getEntries().get("ARTICLE (whole-journal)").getFields().get("month"));
        Assert.assertEquals("The entire issue is devoted to gnats and gnus(this entry is a cross-referenced ARTICLE (journal))",  db.getEntries().get("ARTICLE (whole-journal)").getFields().get("note"));


        Assert.assertEquals("Donald E. Knuth", db.getEntries().get("INBOOK (inbook-full)").getFields().get("author"));
        Assert.assertEquals("Fundamental Algorithms", db.getEntries().get("INBOOK (inbook-full)").getFields().get("title"));
        Assert.assertEquals("1", db.getEntries().get("INBOOK (inbook-full)").getFields().get("volume"));
        Assert.assertEquals("The Art of Computer Programming", db.getEntries().get("INBOOK (inbook-full)").getFields().get("series"));
        Assert.assertEquals("Addison-Wesley", db.getEntries().get("INBOOK (inbook-full)").getFields().get("publisher"));
        Assert.assertEquals("Reading, Massachusetts", db.getEntries().get("INBOOK (inbook-full)").getFields().get("address"));
        Assert.assertEquals("Second", db.getEntries().get("INBOOK (inbook-full)").getFields().get("edition"));
        Assert.assertEquals("10  jan", db.getEntries().get("INBOOK (inbook-full)").getFields().get("month"));
        Assert.assertEquals("1973", db.getEntries().get("INBOOK (inbook-full)").getFields().get("year"));
        Assert.assertEquals("Section", db.getEntries().get("INBOOK (inbook-full)").getFields().get("type"));
        Assert.assertEquals("1.2", db.getEntries().get("INBOOK (inbook-full)").getFields().get("chapter"));
        Assert.assertEquals("10--119", db.getEntries().get("INBOOK (inbook-full)").getFields().get("pages"));
        Assert.assertEquals("This is a full INBOOK entry", db.getEntries().get("INBOOK (inbook-full)").getFields().get("note"));




    }
}
