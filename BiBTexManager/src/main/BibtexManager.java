package main;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

/**
 * Defines a BibTex Manager which contains proper structure and objects
 * required to handle  a BibTex file.
 */

public class BibtexManager implements IBibtexManager {

    private BibtexDatabase db = new BibtexDatabase();

    private String fileName;
    private ArrayList<String> categories;
    private ArrayList<String> authors;
    private Reader reader;
    private Character sign;

    private BibtexParser parser;
    private BibtexPresenter presenter;
    private BibtexFilter filter;



   public BibtexManager(String fileName, ArrayList<String> categories, ArrayList<String> authors, Character sign ){

        this.fileName = fileName;
        this.categories = categories;
        this.authors = authors;
        this.sign = sign;

        try { this.reader = new FileReader(fileName);
        }
        catch (FileNotFoundException e){System.out.println("File not found");}
        catch (IOException e) { e.printStackTrace(); }


        this.db.setCategories(categories);
        this.db.setAuthors(authors);

        this.parser = new BibtexParser(reader,db);
        this.presenter = new BibtexPresenter(db, sign);
        this.filter = new BibtexFilter(db,sign);

    }



    public BibtexDatabase getBibtexDatabase(){

        return db;
    }


    public BibtexParser getParser(){
        return parser;
    }


    public BibtexPresenter getPresenter(){
        return presenter;
    }


    public BibtexFilter getFilter() {
        return filter;
    }



    @Override
    public void accept(IManagerVisitor visitor, String option) throws Exception {
        visitor.visit(this, option);
    };



}
