package main;


import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.lang.reflect.*;

/**
 *
 * Defines how to present parsed data from BibTex file.
 */

public class BibtexPresenter {




    protected BibtexDatabase db;
    private Character sign;
    private BibtexRecordDatabase recordDb;



    BibtexPresenter(BibtexDatabase db, Character sign) {

        this.db = db;
        this.sign = sign;
        this.recordDb = new BibtexRecordDatabase();

    }




    public void present() throws Exception {

        for (Map.Entry<String, BibtexEntry> pair : db.getEntries().entrySet()) {

            System.out.println("\n\n\n\n");
            try {
                presentEntry(pair);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }



    public void presentEntry(Map.Entry<String, BibtexEntry> pair) throws Exception {

        String [] strRecord = pair.getKey().split(" ");
        String record = strRecord[0].toLowerCase();

        String [] requiredRecords = new String[0];

        Class cls = Class.forName("main.BibtexRecordDatabase");
        Object obj = cls.newInstance();
        HashMap<String, BibtexRecord> map;

        Method getRecords = cls.getMethod("get_"+record);
        Object target =getRecords.invoke(obj);

        map = (HashMap<String, BibtexRecord>) target;


            for (Map.Entry<String, BibtexRecord> example : map.entrySet()) {

                    if(example.getValue().getRequired()==true){

                    if(pair.getValue().getFields().get(example.getKey()) == null) {
                        throw new NullPointerException("Entry " + pair.getKey() + " does not have required field \"" + example.getKey() + "\"");

                    }
                }
            }










        int N = 150;  // WIDTH OF TABLE :) CAN BE CHANGED
        int M = 30;   // WIDTH OF KEY - COLUMN :) CAN BE CHANGED

        for (int i = 0; i < N; i++) System.out.print(sign);

        System.out.print("\n"+ sign);
        for(int i =0 ; i < N -2 ; i ++)System.out.print(" ");
        System.out.println(sign);

        System.out.print( sign + " " + pair.getKey());
        for(int i=0;i< N - pair.getKey().toString().length() - 3; i++) System.out.print(" ");
        System.out.print(sign +"\n");

        System.out.print(sign);
        for(int i =0 ; i < N -2 ; i ++)System.out.print(" ");
        System.out.println(sign);

        for (int i = 0; i < N; i++) System.out.print(sign);





        for (Map.Entry<String, String> fields : pair.getValue().getFields().entrySet()) {


            if (map.containsKey(fields.getKey())) {

                System.out.print("\n" + sign);
                for (int i = 0; i < M - 2; i++) System.out.print(" ");
                System.out.print(sign);
                for (int i = 0; i < N - M - 1; i++) System.out.print(" ");

                System.out.print(sign + "\n" + sign + " " + fields.getKey());


                if (fields.getKey().toLowerCase().equals("author") || fields.getKey().toLowerCase().equals("editor")) {

                    String[] str = fields.getValue().split("and ");

                    for (int i = 0; i < M - fields.getKey().toString().length() - 3; i++) System.out.print(" ");
                    System.out.print(sign);
                    System.out.print(" " + str[0]);
                    for (int i = 0; i < N - str[0].length() - M - 2; i++) System.out.print(" ");
                    System.out.println(sign);

                    for (int i = 1; i < str.length; i++) {

                        System.out.print(sign);
                        for (int j = 0; j < M - 2; j++) System.out.print(" ");
                        System.out.print(sign + " " + str[i]);
                        for (int j = 0; j < N - M - str[i].length() - 2; j++) System.out.print(" ");
                        System.out.print(sign + "\n");

                    }

                    System.out.print(sign);
                    for (int i = 0; i < M - 2; i++) System.out.print(" ");
                    System.out.print(sign);
                    for (int i = 0; i < N - M - 1; i++) System.out.print(" ");
                    System.out.print(sign + "\n");

                    for (int i = 0; i < N; i++) System.out.print(sign);

                } else {

                    for (int i = 0; i < M - fields.getKey().length() - 3; i++) System.out.print(" ");
                    System.out.print(sign + " ");

                    String[] str = fields.getValue().split(" ");

                    int lengthOfVariale = 0;
                    int lengthOfShortcut = 0;
                    for (String word : str) {


                        if (db.getVariables().containsKey(word)) {
                            System.out.print(db.getVariables().get(word) + " ");
                            lengthOfVariale = lengthOfVariale + db.getVariables().get(word).length();
                            lengthOfShortcut += word.length();
                        } else System.out.print(word + " ");


                    }


                    for (int i = 0; i < N - fields.getValue().length() - lengthOfVariale - M + lengthOfShortcut - 3; i++)
                        System.out.print(" ");
                    System.out.println(sign);


                    System.out.print(sign);
                    for (int i = 0; i < M - 2; i++) System.out.print(" ");
                    System.out.print(sign);
                    for (int i = 0; i < N - M - 1; i++) System.out.print(" ");
                    System.out.print(sign + "\n");

                    for (int i = 0; i < N; i++) System.out.print(sign);

                }
            }

       }
    }

}
