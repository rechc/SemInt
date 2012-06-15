package de.htw.SemInt;


import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Model;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Model m = ModelFactory.createDefaultModel();
    	
        System.out.println( "Hello World!" );
    }
}
