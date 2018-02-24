package main;

/**
 *
 * Defines ManagerVisitor interface.
 */
public interface IManagerVisitor {


    void visit (BibtexManager manager,String option) throws Exception;


}
