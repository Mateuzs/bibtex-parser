package main;


/**
 *
 * Defines how visitor can use a manager to handle BibTex file.
 */
public class ManagerVisitor implements IManagerVisitor {


/**
 * Allow you to visit a manager with an option - int number.
 * "1" - present the whole parsed file.
 * "2" - present filtered entries by given authors.
 * "3" - present filtered entries by given categories.
 */

    @Override

    public void visit(BibtexManager manager, String option) throws Exception{

        manager.getParser().parse();

        switch(option){

            case("1"):
                System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t***PRESRENTING PARSED FILE***");
                manager.getPresenter().present();
                break;
            case("2"):
                System.out.println("\n\n\n\n\n\t\t\t\t\t\t\t***PRESRENTING ENTRIES FILTERED BY GIVEN AUTHORS***");
                manager.getFilter().filterByAuthors();
                break;
            case("3"):
                System.out.println("\n\n\n\n\n\t\t\t\t\t\t***PRESRENTING ENTRIES FILTERED BY GIVEN CATEGORIES***");
                manager.getFilter().filterByCategory();




        }

    }
}
