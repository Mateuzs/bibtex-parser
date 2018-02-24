package main;

import java.io.FileReader;
import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;


/**
 * Defines BibTex parser and methods of parsing file.
 */

public class BibtexParser  {

    private BibtexDatabase db;
    private int PORTION = 8;
    private PushbackReader in;
    private int line = 1;
    private boolean eof = false;



    public BibtexParser(Reader reader, BibtexDatabase db){

        this.db = db;
        this.in = new PushbackReader(reader,PORTION);
    }


    public PushbackReader getPushBackReader(){
        return in;

    }



    public void parse() throws Exception {

    try {
        while(!eof) {
            boolean found = moveForwardUntil('@');
            if(!found) break;

            skipWhitespace();

            String entryType = parseTextWord();

            BibtexEntryType tp;
            try {
                 tp = BibtexEntryType.valueOf(entryType);
            }
            catch (IllegalArgumentException e){
                 tp = null;
            }

            if(tp == null){

                if(entryType.toLowerCase().equals("preamble")){

                    db.setPreamble(parsePreamble());
                }
                if(entryType.toLowerCase().equals("string")){
                    parseVariable();
                }
                if(entryType.toLowerCase().equals("comment")){
                    continue;
                }
            }
            else if(tp != null){

                try{

                    parseEntry(entryType);
                }
                catch (IOException e){System.out.println("Error occured while parsing entry");}
            }

        }

        in.close();

    } catch (IOException e) {
            System.out.println("Error occured while parsing file");
    }

    }



    public void skipWhitespace() throws IOException {
        int c;

        while (true) {
            c = in.read();
            if ((c == -1) || (c == 65535)) {
                eof = true;
                return;
            }

            if (Character.isWhitespace((char) c)) {
                continue;
            } else

                in.unread(c);

            break;
        }
    }



    public int pickup() throws IOException{

        int c = in.read();
        in.unread(c);

        return c;

    }



    public void moveForward(char expected) throws IOException {

        int c = in.read();

        if (c != expected) {
            throw new RuntimeException("Error in line " + line + ": Expected " + expected
                    + " but received " + (char) c);
        }

    }



    public boolean moveForwardUntil(char expected) throws IOException {
        int c;
        while (((c = in.read()) != expected) && (c != -1) && (c != 65535)){
        }

        if ((c == -1) || (c == 65535))
            eof = true;

        return c == expected;
    }


        public String parseTextWord() throws IOException{

             StringBuilder word = new StringBuilder(20);

             skipWhitespace();

            while (true) {
                int c = in.read();

                if (c == -1) {
                    eof = true;

                    return word.toString();
                }


                if (Character.isLetterOrDigit((char) c) || (c == ':') || (c == '-') || (c == '_')
                        || (c == '*') || (c == '+') || (c == '.') || (c == '/') || (c == '\'')) {
                    word.append((char) c);
                } else {
                    in.unread(c);
                    return word.toString();
                }
            }
        }


        public String parseField() throws IOException{

        String field = "";
        int c;

        while(( c = in.read()) != '"'){

            field += (char) c;

            }

        return field;

        }


    public String parsePreamble() throws IOException{

        String preamble = new String("");


        while(true){

            int c = in.read();

            if(c == -1){
                eof = true;
                break;
            }

            if(c == '@') {
               in.unread(c);
                break;
            }

            preamble += (char) c;

        }


        return preamble;
    }





    public void parseVariable() throws IOException{

        String name;
        String content;

        skipWhitespace();
        moveForward('{');

        name = parseTextWord();

        moveForwardUntil('"');

        content = parseField();

        db.addVariable(name,content);


    }


    public void parseEntry(String entryType) throws Exception {


        moveForward('{');
        String id = entryType+" ("+parseTextWord()+")";
        BibtexEntry entry = new BibtexEntry(id, BibtexEntryType.valueOf(entryType));
        moveForward(',');



        while(pickup() != '}') {


            String key = parseEntryKey();
            skipWhitespace();
            moveForward('=');
            skipWhitespace();
            String value = parseEntryField();
            moveForward('\n');
            entry.getFields().containsKey(key);

             entry.insertValues(key, value);

        }

        if(db.getEntries().containsKey(id)) throw new Exception ("Another Entry with name : "+ id + " exists. Only the first one found will be added.");

        else  db.addEntry(id, entry);
    }

    public String parseEntryKey() throws IOException{

        String key = "";
        int c;
        while(pickup() != '='){

            c = in.read();

            if(c == -1){
                eof = true;
                break;
            }

            if(c == '\n' || c == ' ') continue;
            key += (char) c;
        }

        return key;
    }


    public String parseEntryField() throws IOException{

        String field = "";
        int c;

        while(pickup() != '\n'){

            c = in.read();

            if(c == -1){
                eof = true;
                break;
            }

            if(c != '{' && c != '}' && c != '\'' && c != '[' && c != ']'
                    && c != '$' && c != '~' && c!= '\\' && c != '"' && c != '=' && c!= '#')
                field += (char) c;
        }


            field = field.startsWith("\"") ? field = field.substring(1) : field;
            field = field.substring(0, field.length() - 1);
            field = field.endsWith("\"") ? field = field.substring(0, field.length() - 1) : field;


        return field;

    }





}
