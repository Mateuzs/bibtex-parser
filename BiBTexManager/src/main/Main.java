
package main;


import gnu.getopt.Getopt;

import java.util.ArrayList;


public class    Main {


    public static void main(String [] args  ) throws Exception {


       

        ArrayList<String>  categories = new ArrayList<>();
        ArrayList<String>  authors = new ArrayList<>();

        Character sign = '*';
        String fileName = "";
        String option = "";

        Getopt g = new Getopt("testprog", args, ":a:c:f:s:o:h");

        int c = g.getopt();

        do
        {
            switch(c)
            {
                case 'a':
                    authors.add(g.getOptarg());
                    break;
                case 'c':
                    categories.add(g.getOptarg());
                    break;
                case 'f':
                    fileName = g.getOptarg();
                    break;
                case 's':
                    sign = g.getOptarg().toCharArray()[0];
                    break;
                case 'o':
                    option = g.getOptarg();
                    break;
                case 'h':
                    System.out.println("\nHello in my Bibtex mini Parser program :) here You can find basic options: \n " +
                                        "-a : takes an author \n -c : takes a category \n -f : takes a file name" +
                                        "\n -s : takes a sign builder for the tables\n -h : shows  help \n" +
                                        "\n -o : defines an option of parsing the file:\n" +
                                        "   1 - present the whole parsed file.\n" +
                                        "   2 - present filtered entries by given authors.\n" +
                                        "   3 - present filtered entries by given categories. ");
                    return;

                default:

                    throw new IllegalArgumentException("bad syntax of options, please use -h to get to know how use this program :)");
            }
        }
        while ((c = g.getopt()) != -1);



        BibtexManager manager = new BibtexManager(fileName, categories, authors, sign);
        IManagerVisitor visitor = new ManagerVisitor();
        manager.accept(visitor, option);


    }
}
