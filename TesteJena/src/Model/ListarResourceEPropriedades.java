/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.InputStream;
import java.util.Iterator;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.iterator.ExtendedIterator;

/**
 *
 * @author Filipe
 */
public class ListarResourceEPropriedades {

    /**
     * @param args the command line arguments
     */
    static final String inputFileName = "urbanus.owl";

    public static void main(String[] args) {

        try {

            //create the reasoning model using the base
            OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
            // use the FileManager to find the input file
            InputStream in = FileManager.get().open(inputFileName);
            if (in == null) {
                throw new IllegalArgumentException("File: " + inputFileName + " not found");
            }

            inf.read(in, "");

            String URI = "http://www.owl-ontologies.com/unnamed.owl#";//read(java.io.InputStream in, java.lang.String base)

            ExtendedIterator classes = inf.listClasses();
            while (classes.hasNext()) {
                OntClass essaClasse = (OntClass) classes.next();

                String vClasse = essaClasse.getLocalName();
                
                if (essaClasse.hasSubClass()) {
                    System.out.println("Classe: " + vClasse+"{");
                    OntClass cla = inf.getOntClass(URI + vClasse);
                    for (Iterator i = cla.listSubClasses(); i.hasNext();) {
                        OntClass c = (OntClass) i.next();
                        System.out.print("   " + c.getLocalName() + " " + "\n");
                    }
                    System.out.println("}");
                }
                
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


    

