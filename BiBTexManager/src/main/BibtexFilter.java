package main;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Provides methods of filtering data by preferred key.
 */

public class BibtexFilter extends BibtexPresenter {


    public BibtexFilter(BibtexDatabase db, Character sign) {
        super(db, sign);
    }



    public void filterByCategory() throws Exception {

        for(String category : db.getCategories()) {

            for (Map.Entry<String, BibtexEntry> pair : db.getEntries().entrySet()) {

                String[] str = pair.getKey().split(" ");

                if (str[0].equals(category.toUpperCase())) {
                    System.out.println("\n\n\n\n");
                    try {
                        presentEntry(pair);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }

            System.out.println("\n\n\n");
        }
    }


    public void filterByAuthors() throws Exception {


        for (String author : db.getAuthors()) {

            for (Map.Entry<String, BibtexEntry> pair : db.getEntries().entrySet()) {

                String[] str = new String[0];
                String[] str2 = new String[0];

                if (pair.getValue().getFields().containsKey("author"))
                    str = pair.getValue().getFields().get("author").split("and ");

                if (pair.getValue().getFields().containsKey("editor"))
                    str2 = pair.getValue().getFields().get("editor").split("and ");

                if (str.length > 0) {
                    for (String x : str) {

                        if (x.equals(author)) {
                            System.out.println("\n\n\n\n");
                            presentEntry(pair);
                        }

                    }
                }


                else {
                    for (String x : str2) {

                        if (x.equals(author)) {
                            System.out.println("\n\n\n\n");
                            presentEntry(pair);
                        }

                    }

                }

            }

        }

        System.out.println("\n\n\n");
    }
}