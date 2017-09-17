package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
public class Ontologia {

    String inputFileName = "";
    String URI = "";
    String arvore;
    List<String> Listarvore = new ArrayList<>();

    public Ontologia(String inputFileName, String URI) {
        this.inputFileName = inputFileName;
        this.URI = URI;

    }

    public List<String> listarClasses() {

        try {
            OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
            OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
            
            InputStream in = FileManager.get().open(inputFileName);

            if (in == null) {
                throw new IllegalArgumentException("File: " + inputFileName + " not found");
            }
            inf.read(in, "");

            ExtendedIterator classes = inf.listClasses();
            while (classes.hasNext()) {
                OntClass essaClasse = (OntClass) classes.next();
                if (inf.getNsPrefixURI("") != null) {
                    URI = inf.getNsPrefixURI("");
                } else {
                    int flagURI = essaClasse.getURI().lastIndexOf("#");
                    URI = essaClasse.getURI().substring(0, flagURI + 1);
                }
               // model.createOntology(URI);
                //System.out.println(URI);
                String vClasse = essaClasse.getLocalName();
              //  if (vClasse != null){
              //  model.createClass(URI+vClasse);
              //  }
                
                if (vClasse != null && !essaClasse.hasSuperClass()) {
                    // System.out.println("TEste extração de uri na classe"+essaClasse.getURI());
                    
                    if (essaClasse.hasSubClass()) {
                        arvore = "<details><summary>" + vClasse + "</summary>";
                        Listarvore.add(arvore);
                        for (Iterator i = essaClasse.listSubClasses(); i.hasNext();) {
                            OntClass c = (OntClass) i.next();
                            String subClasse = c.getLocalName();
                            listarSubClasses(subClasse);
                        }
                        arvore = "</details>";
                        Listarvore.add(arvore);
                    } else {
                        arvore = "<summary>" + vClasse + "</summary>";
                        Listarvore.add(arvore);
                    }
                }
            }
            StringWriter sw = new StringWriter();
				inf.write(sw, "RDF/XML-ABBREV");
				String owlCode = sw.toString();
				File file = new File("k:/Outros/t6.rdf");
				try{
				FileWriter fw = new FileWriter(file);
				fw.write(owlCode);
				fw.close();
				} catch(FileNotFoundException fnfe){
				fnfe.printStackTrace();
				} catch(IOException ioe){
				ioe.printStackTrace();
				}
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Listarvore;
    }

    public void listarSubClasses(String classe) {
        OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException("File: " + inputFileName + " not found");
        }
        inf.read(in, "");
        OntClass cla = inf.getOntClass(URI + classe);
        ArrayList<String> sc = new ArrayList<String>();
        if (cla.hasSubClass()) {
            arvore = "<details><summary>" + classe + "</summary>";
            Listarvore.add(arvore);
            for (Iterator i = cla.listSubClasses(); i.hasNext();) {
                OntClass c = (OntClass) i.next();

                String VSubClasses = c.getLocalName();

                arvore = VSubClasses + "<p>";//mudei aqui
                Listarvore.add(arvore);
                if (c.hasSubClass()) {
                    listarSubClasses(VSubClasses);
                }
            }
            arvore = "</details>";
            Listarvore.add(arvore);
        } else {
            arvore = "<summary>" + classe + "</summary>";
            Listarvore.add(arvore);
        }
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public void setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    public String getURI() {
        return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }

}
