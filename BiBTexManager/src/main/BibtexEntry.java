package main;

import java.util.HashMap;

/**
 * Defines BibTex Entries - special objects containing
 * its type and  keys with values, required to present.
 */

public class BibtexEntry {


    private String id;
    private BibtexEntryType type;
    private HashMap<String,String> fields = new HashMap<>();



    BibtexEntry (String id,BibtexEntryType type){
        this.id = id;
        this.type = type;
    }



    public void insertValues(String key, String value){
        fields.put(key,value);
    }



    public String getId(){

        return id;

    }


    public HashMap<String, String> getFields() {
        return fields;
    }



    @Override
    public boolean equals(Object other){
        if (other == null) return false;
        if (other == this) return true;
        if (!(other instanceof BibtexEntry))return false;
        if(this.id == ((BibtexEntry) other).getId())
            return true;
        else return false;
    }


    @Override
    public int hashCode() {
        int prime = 31;
        return prime +  id.hashCode();
    }



}
