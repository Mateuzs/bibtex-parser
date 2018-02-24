package main;

/**
 * Defines a record type and defines if it is required in representation of BibTex entry of specific type.
 * */

public class BibtexRecord {

    private Boolean required;


    public BibtexRecord(Boolean required){

        this.required = required;

    }

    public Boolean getRequired() {
        return required;
    }


}
