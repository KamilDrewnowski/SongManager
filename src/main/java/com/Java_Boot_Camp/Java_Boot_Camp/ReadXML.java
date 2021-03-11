package com.Java_Boot_Camp.Java_Boot_Camp;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML extends JavaBootCampApplication{

    //method for reading information from the csv file
    static int readXML(String fileName, String table[][], int tableRecord){

        try {
            File fXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = null;
            try {
                 doc = dBuilder.parse(fXmlFile);
            }catch( Exception e){
                System.out.println("You can not parse XML file, maybe check do you have & and change to &amp;");
            }
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("song");
            System.out.println("----------------------------");

            for (int xmlPosition = 0; xmlPosition < nList.getLength(); xmlPosition++) {

                Node nNode = nList.item(xmlPosition);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                    //looking for song with the same title in table
                    boolean haveSongLikeThis = false;
                    for(int temp = 0; temp<tableRecord; temp++){
                        if(table[0][temp].equals(eElement.getElementsByTagName("title").item(0).getTextContent())){
                            int temporaryTableValue=Integer.parseInt(table[4][temp]);
                            int temporaryVote=Integer.parseInt(eElement.getElementsByTagName("votes").item(0).getTextContent());
                            int voteToSet=temporaryTableValue+temporaryVote;
                            table[4][temp]=String.valueOf(voteToSet);
                            haveSongLikeThis = true;
                        }
                    }
                    //if the songs don't repeat themselves
                    if(haveSongLikeThis == false) {
                        table[0][tableRecord] = eElement.getElementsByTagName("title").item(0).getTextContent();
                        table[1][tableRecord] = eElement.getElementsByTagName("author").item(0).getTextContent();
                        table[2][tableRecord] = eElement.getElementsByTagName("album").item(0).getTextContent();
                        table[3][tableRecord] = eElement.getElementsByTagName("category").item(0).getTextContent();
                        table[4][tableRecord] = eElement.getElementsByTagName("votes").item(0).getTextContent();
                        tableRecord++;
                    }
                    haveSongLikeThis = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tableRecord;
    }
}