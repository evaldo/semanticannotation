package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
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

    public OntModel gerarModelo() {
        OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException("File: " + inputFileName + " not found");
        }
        inf.read(in, "");
        return inf;
    }

    public String gravarModelo(OntModel inf) {
        StringWriter sw = new StringWriter();
        inf.write(sw, "RDF/XML-ABBREV");
        String owlCode = sw.toString();
        String localArquivo = "c:/Outros/gecon.rdf";
        try {
            OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(localArquivo), "UTF-8");
            bufferOut.write(owlCode);
            bufferOut.close();
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return localArquivo;
    }

    public List<String> listarClasses() {
        
        try {
            OntModel inf = gerarModelo();
            ExtendedIterator classes = inf.listClasses();

            while (classes.hasNext()) {
                OntClass essaClasse = (OntClass) classes.next();
                if (inf.getNsPrefixURI("") != null) {
                    URI = inf.getNsPrefixURI("");
                } else {
                    int flagURI = essaClasse.getURI().lastIndexOf("#");
                    URI = essaClasse.getURI().substring(0, flagURI + 1);
                }
                String vClasse = essaClasse.getLocalName();

                if (vClasse != null && !essaClasse.hasSuperClass()) {
                    String comentario = inf.getOntClass(URI + vClasse).getComment(null);
                    String test = comentario;
                    if (test == null) {
                        test = "Não Possui Comentários";
                    }
                    if (essaClasse.hasSubClass()) {

                        arvore = "<li><a href=\"#\" data-tooltip=\"" + test.replace("\"", "\'") + "\">" + vClasse + "</a>";
                        Listarvore.add(arvore);
                        Listarvore.add("<ul class=\"sub-menu\">");

                        for (Iterator i = essaClasse.listSubClasses(); i.hasNext();) {
                            OntClass c = (OntClass) i.next();
                            String subClasse = c.getLocalName();
                            listarSubClasses(subClasse);
                        }
                        Listarvore.add("</ul></li>");

                    } else {
                        arvore = "<li><a href=\"#\" data-tooltip=\"" + test.replace("\"", "\'") + "\">" + vClasse + "</a></li>";
                        Listarvore.add(arvore);
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
     

        return Listarvore;
    }

    public void listarSubClasses(String classe) {
        OntModel inf = gerarModelo();
        OntClass cla = inf.getOntClass(URI + classe);
        String comentario = inf.getOntClass(URI + classe).getComment(null);
        String test = comentario;
        if (test == null) {
            test = "Não Possui Comentários";
        }
        if (cla.hasSubClass()) {
            Listarvore.add("<li><a href=\"#\" data-tooltip=\"" + test.replace("\"", "\'") + "\">" + classe + "</a>");
            Listarvore.add("<ul class=\"sub-menu\">");
            for (Iterator i = cla.listSubClasses(); i.hasNext();) {
                OntClass c = (OntClass) i.next();
                String VSubClasses = c.getLocalName();
                String comentarioSubClasse = inf.getOntClass(URI + VSubClasses).getComment(null);
                String testSubClasse = comentarioSubClasse;
                if (testSubClasse == null) {
                    testSubClasse = "Não Possui Comentários";
                }
                if (c.hasSubClass()) {
                    listarSubClasses(VSubClasses);

                } else {
                    arvore = "<li><a href=\"#\" data-tooltip=\"" + testSubClasse.replace("\"", "\'") + "\">" + VSubClasses + "</a></li>";
                    Listarvore.add(arvore);
                }
            }
            Listarvore.add("</ul></li>");
        } else {
            arvore = "<li><a href=\"#\" data-tooltip=\"" + test.replace("\"", "\'") + "\">" + classe + "</a></li>";
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
