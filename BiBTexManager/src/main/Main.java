
package main;


import gnu.getopt.Getopt;

import java.util.ArrayList;


public class    Main {


    public static void main(String [] args  ) throws Exception {

      // WORKING EXAMPLE
      // args = new String []{"-a","Paul Pot","-c","article","-a","Paul Pot","-f","src/main/bibFileExample.txt","-s","*","-o","2",""};

        ArrayList<String>  categories = new ArrayList<>();
        ArrayList<String>  authors = new ArrayList<>();

        Character sign = '*';
        String fileName = "";
        String option = "";

        Getopt g = new Getopt("testprog", args, ":a:c:f:s:o:h:");
        int c;

        while ((c = g.getopt()) != -1)
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
                                        "-a : take an author \n -c : take a category \n -f : take a file name" +
                                        "\n -s : take a sign builder for the tables\n -h : show  help \n");
                    return;

                default:
                    throw new IllegalArgumentException("bad syntax of options, please use -h to get to know how use this program :)");
            }
        }



        for(String author: authors) System.out.println(author);

        BibtexManager manager = new BibtexManager(fileName, categories, authors, sign);
        IManagerVisitor visitor = new ManagerVisitor();
        manager.accept(visitor, option);


    }
}
