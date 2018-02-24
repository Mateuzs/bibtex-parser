package main;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Creates required structure to hold parsed data.
 * Contains all important data from BibTex file
 *
 */

public class BibtexDatabase {




    private HashMap<String, BibtexEntry> entries = new HashMap<String,BibtexEntry>();

    private HashMap<String, String> variables = new HashMap<>();

    private String preamble;

    private ArrayList<String> categories;

    private ArrayList<String> authors;






    public void setPreamble(String preamble) {

        this.preamble=preamble;
    }



    public HashMap<String, String> getVariables(){

        return variables;
    }



    public void addVariable(String key, String content  ){

        variables.put(key, content);

    }


    public HashMap<String, BibtexEntry> getEntries() {

        return entries;
    }


    public void addEntry(String id, BibtexEntry entry){

        entries.put(id,entry);


    }


    public ArrayList<String> getCategories(){

        return categories;
    }


    public ArrayList<String> getAuthors(){

        return authors;
    }



    public void setCategories(ArrayList<String> categories){

        this.categories=categories;
    }


    public void setAuthors(ArrayList<String> authors){

        this.authors=authors;

    }


}
