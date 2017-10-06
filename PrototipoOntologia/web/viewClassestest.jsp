<%@page import="org.apache.jena.sparql.vocabulary.TestManifestUpdate_11.request"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.apache.jena.ontology.OntClass"%>
<%@page import="org.apache.jena.util.iterator.ExtendedIterator"%>
<%@page import="org.apache.jena.ontology.OntModel"%>
<%@page import="model.Ontologia"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Protótipo de ontologias</title>
    </head>
    <body>
        <%
           // String uri = request.getAttribute("uri") == null ? "" : request.getAttribute("uri").toString();
            String nomeArquivo = request.getAttribute("nomeArquivo").toString();
            Ontologia ont = (Ontologia)request.getAttribute("ont");
            OntModel ontModel = ont.getModeloOntologico();
            ExtendedIterator classes = ontModel.listClasses();
            while (classes.hasNext()) {
                OntClass essaClasse = (OntClass) classes.next();
                String vClasse = essaClasse.getLocalName();
                if (vClasse != null && !essaClasse.hasSuperClass()) {

                    if (essaClasse.hasSubClass()) {
                    
        %>
        <details><summary><%=vClasse%></summary>
                <%
                    for (Iterator i = essaClasse.listSubClasses(); i.hasNext();) {
                        OntClass c = (OntClass) i.next();
                        String subClasse = c.getLocalName();
                        listarSubClasses(subClasse);
            }
                %>
        </details>
        <%
        } else {
        %>
    
        <details><summary><%=vClasse%></summary></details>
        
    <%
                }
            }
        %>
    
    <%! 
    public void listarSubClasses(String classe) {
        Ontologia ont = (Ontologia)request.getAttribute("ont");

        OntClass cla = ont.getOntClass(ont.getNsPrefixURI() + classe);
        if (cla.hasSubClass() && !cla.hasSuperClass()) {
            arvore = "<details><summary>" + classe + "</summary>";
 ;
            for (Iterator i = cla.listSubClasses(); i.hasNext();) {
                OntClass c = (OntClass) i.next();
                String VSubClasses = c.getLocalName();
                arvore = VSubClasses + "<p>";//mudei aqui
              
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
    %>

</body>
</html>
