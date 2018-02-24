package main;

/**
 * Defines BibTexManager interface.
 */
public interface IBibtexManager {


     void accept (IManagerVisitor visitor, String option) throws Exception;

}
