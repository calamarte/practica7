import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 * Created by Dgarcia on 14/06/2017.
 */
public class Getxml {
    public static DataBase cogexml() {
        String servidor = "";
        String usuario = "";
        String passwd = "";
        String database = "";
        DataBase db = null;
        try {
            File fXmlFile = new File("src/main/resources/application.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("staff");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    usuario = eElement.getElementsByTagName("username").item(0).getTextContent();
                    passwd = eElement.getElementsByTagName("password").item(0).getTextContent();
                    servidor = eElement.getElementsByTagName("server").item(0).getTextContent();
                    database = eElement.getElementsByTagName("nickname").item(0).getTextContent();
                }
            }
            db = new DataBase(servidor, database, usuario, passwd);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return db;
    }
}
