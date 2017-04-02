
import java.io.InputStream;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

public class Tutorial05 extends Object {

    public static void main(String args[]) {
        String inputFileName = "urbanus.owl";
//  Criando um modelo vazio
        Model model = ModelFactory.createDefaultModel();
        
// usar o FileManager para encontrar o arquivo** obs: ele tem que esta na pasta do projeto
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }
//  ler o  Arquivo RDF/XML 
        model.read(in, "");
        
//  Escreva para o padrão
        model.write(System.out);
    }
}
