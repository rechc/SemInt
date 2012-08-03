/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jenapellet;

import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.ProfileRegistry;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.reasoner.Reasoner;
import com.hp.hpl.jena.reasoner.ValidityReport;
import com.hp.hpl.jena.util.PrintUtil;
import com.sun.org.apache.xml.internal.utils.URI;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
import org.mindswap.pellet.jena.PelletInfGraph;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.semanticweb.owl.apibinding.OWLManager;
import org.semanticweb.owl.model.OWLClass;
import org.semanticweb.owl.model.OWLOntology;
import org.semanticweb.owl.model.OWLOntologyManager;

/**
 *
 * @author christian
 */
public class JenaPellet {

    public JenaPellet() {
    }

    
    public static void usageWithOntModel() {    
        System.out.println("Results with OntModel");
        System.out.println("---------------------");
        System.out.println();

        // ontology that will be used
        String ont = "./onto.owl";
        String ns = "http://www.semanticweb.org/bline_asus/ontologies/2012/5/untitled-ontology-5#";    
        
        // create an empty ontology model using Pellet spec
        OntModel model = ModelFactory.createOntologyModel( PelletReasonerFactory.THE_SPEC );
        OntModel model2 = ModelFactory.createOntologyModel(ProfileRegistry.OWL_DL_LANG);
            
        // read the file
        model.read( ont );
        
        // print validation report
        ValidityReport report = model.validate();
        printIterator( report.getReports(), "Validation Results" );
        
        // print superclasses using the utility function
        OntClass c = model.getOntClass( ns + "Kunde" );         
        printIterator(c.listSuperClasses(), "All super classes of " + c.getLocalName());
        // OntClass provides function to print *only* the direct subclasses 
        printIterator(c.listSuperClasses(true), "Direct superclasses of " + c.getLocalName());
        
        System.out.println();
    }
    
    public static void printIterator(Iterator<?> i, String header) {
        System.out.println(header);
        for(int c = 0; c < header.length(); c++)
            System.out.print("=");
        System.out.println();
        
        if(i.hasNext()) {
	        while (i.hasNext()) 
	            System.out.println( i.next() );
        }       
        else
            System.out.println("<EMPTY>");
        
        System.out.println();
    }
    
    public void searchClass() {
        String ns = "http://www.semanticweb.org/bline_asus/ontologies/2012/5/untitled-ontology-5#";
        String ontopath = "./onto.owl";

        try {
            OntModel model = ModelFactory.createOntologyModel(ProfileRegistry.OWL_DL_LANG);
            //OntModel onto = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, null);

            model.read((new FileInputStream(ontopath)), "RDF/XML");
            //model.write(System.out);

            Reasoner reasoner = PelletReasonerFactory.theInstance().create(model.getResource(ns));
            reasoner = reasoner.bindSchema(model);
            
           OntClass Kunde = model.getOntClass(ns +  "Kunde");         
           Iterator instances = Kunde.listInstances();
           
            System.out.println("Ausgabe Instance");
           while (instances.hasNext()){
               Object o = instances.next();
               System.out.println("aaa: " + o.toString());
               
           }
      
        } catch (Exception e) {
            System.out.println("Fehler: " + e.toString());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        JenaPellet jp = new JenaPellet();
//        jp.searchClass();
        usageWithOntModel();
    }
}
