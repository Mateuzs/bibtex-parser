package main;

import java.util.HashMap;

/**
 * Defines required and optional record in Bibtex entries of all standard types.
 */

public class BibtexRecordDatabase {

    private HashMap<String, BibtexRecord> article = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> book = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> inbook = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> booklet = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> incollection = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> inproceedings = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> manual = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> mastersthesis = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> misc = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> phdthesis = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> proceedings = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> techreport = new HashMap<String, BibtexRecord>();
    private HashMap<String, BibtexRecord> unpublished = new HashMap<String, BibtexRecord>();



    public BibtexRecordDatabase(){

        article.put("author", new BibtexRecord(true));
        article.put("title", new BibtexRecord(true));
        article.put("journal", new BibtexRecord(true));
        article.put("year", new BibtexRecord(true));
        article.put("volume", new BibtexRecord(false));
        article.put("number", new BibtexRecord(false));
        article.put("pages", new BibtexRecord(false));
        article.put("month", new BibtexRecord(false));
        article.put("note", new BibtexRecord(false));
        article.put("key", new BibtexRecord(false));

        book.put("author", new BibtexRecord(true));
        book.put("editor", new BibtexRecord(true));
        book.put("title", new BibtexRecord(true));
        book.put("publisher", new BibtexRecord(true));
        book.put("year", new BibtexRecord(true));
        book.put("volume", new BibtexRecord(false));
        book.put("series", new BibtexRecord(false));
        book.put("address", new BibtexRecord(false));
        book.put("edition", new BibtexRecord(false));
        book.put("month", new BibtexRecord(false));
        book.put("note", new BibtexRecord(false));
        book.put("key", new BibtexRecord(false));

        inproceedings.put("author", new BibtexRecord( true));
        inproceedings.put("title", new BibtexRecord( true));
        inproceedings.put("booktitle", new BibtexRecord( true));
        inproceedings.put("year", new BibtexRecord( true));
        inproceedings.put("editor", new BibtexRecord( false));
        inproceedings.put("volume", new BibtexRecord( false));
        inproceedings.put("number", new BibtexRecord( false));
        inproceedings.put("series", new BibtexRecord( false));
        inproceedings.put("pages", new BibtexRecord( false));
        inproceedings.put("address", new BibtexRecord( false));
        inproceedings.put("month", new BibtexRecord( false));
        inproceedings.put("organization", new BibtexRecord( false));
        inproceedings.put("publisher", new BibtexRecord( false));
        inproceedings.put("note", new BibtexRecord( false));
        inproceedings.put("key", new BibtexRecord( false));

        booklet.put("title", new BibtexRecord(true));
        booklet.put("author", new BibtexRecord(false));
        booklet.put("howpublished", new BibtexRecord(false));
        booklet.put("address", new BibtexRecord(false));
        booklet.put("month", new BibtexRecord(false));
        booklet.put("year", new BibtexRecord(false));
        booklet.put("note", new BibtexRecord(false));
        booklet.put("key", new BibtexRecord(false));

        inbook.put("author", new BibtexRecord(true));
        inbook.put("title", new BibtexRecord(true));
        inbook.put("chapter", new BibtexRecord(true));
        inbook.put("publisher", new BibtexRecord(true));
        inbook.put("year", new BibtexRecord(true));
        inbook.put("number", new BibtexRecord(false));
        inbook.put("volume", new BibtexRecord(false));
        inbook.put("series", new BibtexRecord(false));
        inbook.put("type", new BibtexRecord(false));
        inbook.put("address", new BibtexRecord(false));
        inbook.put("edition", new BibtexRecord(false));
        inbook.put("month", new BibtexRecord(false));
        inbook.put("note", new BibtexRecord(false));
        inbook.put("key", new BibtexRecord(false));

        incollection.put("author", new BibtexRecord(true));
        incollection.put("title", new BibtexRecord(true));
        incollection.put("booktitle", new BibtexRecord(true));
        incollection.put("publisher", new BibtexRecord(true));
        incollection.put("year", new BibtexRecord(true));
        incollection.put("editor", new BibtexRecord(false));
        incollection.put("volume", new BibtexRecord(false));
        incollection.put("number", new BibtexRecord(false));
        incollection.put("series", new BibtexRecord(false));
        incollection.put("type", new BibtexRecord(false));
        incollection.put("chapter", new BibtexRecord(false));
        incollection.put("pages", new BibtexRecord(false));
        incollection.put("address", new BibtexRecord(false));
        incollection.put("edition", new BibtexRecord(false));
        incollection.put("month", new BibtexRecord(false));
        incollection.put("note", new BibtexRecord(false));
        incollection.put("key", new BibtexRecord(false));

        manual.put("title", new BibtexRecord(true));
        manual.put("organization", new BibtexRecord(false));
        manual.put("address", new BibtexRecord(false));
        manual.put("edition", new BibtexRecord(false));
        manual.put("month", new BibtexRecord(false));
        manual.put("year", new BibtexRecord(false));
        manual.put("note", new BibtexRecord(false));
        manual.put("key", new BibtexRecord(false));

        mastersthesis.put("author", new BibtexRecord(true));
        mastersthesis.put("title", new BibtexRecord(true));
        mastersthesis.put("school", new BibtexRecord(true));
        mastersthesis.put("year", new BibtexRecord(true));
        mastersthesis.put("type", new BibtexRecord(false));
        mastersthesis.put("address", new BibtexRecord(false));
        mastersthesis.put("month", new BibtexRecord(false));
        mastersthesis.put("note", new BibtexRecord(false));
        mastersthesis.put("key", new BibtexRecord(false));

        phdthesis.put("author", new BibtexRecord(true));
        phdthesis.put("title", new BibtexRecord(true));
        phdthesis.put("school", new BibtexRecord(true));
        phdthesis.put("year", new BibtexRecord(true));
        phdthesis.put("type", new BibtexRecord(false));
        phdthesis.put("adress", new BibtexRecord(false));
        phdthesis.put("month", new BibtexRecord(false));
        phdthesis.put("note", new BibtexRecord(false));
        phdthesis.put("key", new BibtexRecord(false));

        techreport.put("author", new BibtexRecord(true));
        techreport.put("title", new BibtexRecord(true));
        techreport.put("institution", new BibtexRecord(true));
        techreport.put("year", new BibtexRecord(true));
        techreport.put("editor", new BibtexRecord(false));
        techreport.put("volume", new BibtexRecord(false));
        techreport.put("number", new BibtexRecord(false));
        techreport.put("series", new BibtexRecord(false));
        techreport.put("address", new BibtexRecord(false));
        techreport.put("month", new BibtexRecord(false));
        techreport.put("organization", new BibtexRecord(false));
        techreport.put("publisher", new BibtexRecord(false));
        techreport.put("note", new BibtexRecord(false));
        techreport.put("key", new BibtexRecord(false));

        misc.put("author", new BibtexRecord(false));
        misc.put("title", new BibtexRecord(false));
        misc.put("howpublished", new BibtexRecord(false));
        misc.put("month", new BibtexRecord(false));
        misc.put("year", new BibtexRecord(false));
        misc.put("note", new BibtexRecord(false));
        misc.put("key", new BibtexRecord(false));

        unpublished.put("author", new BibtexRecord(true));
        unpublished.put("published", new BibtexRecord(true));
        unpublished.put("note", new BibtexRecord(true));
        unpublished.put("month", new BibtexRecord(false));
        unpublished.put("year", new BibtexRecord(false));
        unpublished.put("key", new BibtexRecord(false));

        proceedings.put("title", new BibtexRecord(true));
        proceedings.put("year", new BibtexRecord(true));
        proceedings.put("author", new BibtexRecord(false));
        proceedings.put("editor", new BibtexRecord(false));
        proceedings.put("title", new BibtexRecord(false));
        proceedings.put("year", new BibtexRecord(false));
        proceedings.put("key", new BibtexRecord(false));
        proceedings.put("month", new BibtexRecord(false));
        proceedings.put("organization", new BibtexRecord(false));
        proceedings.put("note", new BibtexRecord(false));
        proceedings.put("series", new BibtexRecord(false));
        proceedings.put("author", new BibtexRecord(false));



    }


    public HashMap<String , BibtexRecord>  get_article(){

        return article;
    }



    public HashMap<String , BibtexRecord>  get_book(){

        return book;
    }


    public HashMap<String , BibtexRecord>  get_inproceedings(){

        return inproceedings;
    }


    public HashMap<String , BibtexRecord>  get_booklet(){

        return booklet;
    }


    public HashMap<String , BibtexRecord>  get_inbook(){

        return inbook;
    }

    public HashMap<String , BibtexRecord>  get_incollection(){

        return incollection;
    }

    public HashMap<String , BibtexRecord>  get_manual(){

        return manual;
    }

    public HashMap<String , BibtexRecord>  get_mastersthesis(){

        return mastersthesis;
    }

    public HashMap<String , BibtexRecord>  get_phdthesis(){

        return phdthesis;
    }

    public HashMap<String , BibtexRecord>  get_techreport(){

        return techreport;
    }

    public HashMap<String , BibtexRecord>  get_misc(){

        return misc;
    }

    public HashMap<String , BibtexRecord>  get_unpublished(){

        return unpublished;
    }

    public HashMap<String , BibtexRecord>  get_proceedings(){

        return proceedings;
    }

}
