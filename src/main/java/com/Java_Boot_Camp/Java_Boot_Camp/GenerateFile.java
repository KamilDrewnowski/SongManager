package com.Java_Boot_Camp.Java_Boot_Camp;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import com.opencsv.CSVWriter;
import org.xml.sax.*;
import org.w3c.dom.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenerateFile {

    private String role1 = null;
    private String role2 = null;
    private String role3 = null;
    private String role4 = null;

//method for saving a file from a table to a file in xml format
    public static void saveToXML(String table[][], int howLong) {

        String xmlCsvFileName = createNewFile();

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            // root element
            Element root = document.createElement("songs");
            document.appendChild(root);

            // loop for every song with set length (top 3, top 10 e.t.c.)
            for (int i = 0; i < howLong; i++) {

                Element Song = document.createElement("song");

                root.appendChild(Song);

                Element title = document.createElement("title");
                title.appendChild(document.createTextNode(table[0][i]));
                Song.appendChild(title);

                Element author = document.createElement("author");
                author.appendChild(document.createTextNode(table[1][i]));
                Song.appendChild(author);

                Element album = document.createElement("album");
                album.appendChild(document.createTextNode(table[2][i]));
                Song.appendChild(album);

                Element category = document.createElement("category");
                category.appendChild(document.createTextNode(table[3][i]));
                Song.appendChild(category);

                Element votes = document.createElement("votes");
                votes.appendChild(document.createTextNode(table[4][i]));
                Song.appendChild(votes);

            }

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlCsvFileName));

            transformer.transform(domSource, streamResult);

            System.out.println("The XML file has been generated");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    //method to save a file from a table to a file in csv format
    public static void saveToCSV(String table[][], int howLong) {

        String xmlCsvFileName = createNewFile();

        File file = new File(xmlCsvFileName);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter(file);

            // create CSVWriter object fileWriter object as parameter
            CSVWriter writer = new CSVWriter(outputFile, ',',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            // adding header to csv
            String[] header = { "Title", "Author", "Album", "Category", "Votes" };
            writer.writeNext(header);

            // add data to csv
            for(int i=0;i<howLong;i++) {
                String[] data1 = {table[0][i], table[1][i], table[2][i], table[3][i], table[4][i]};
                writer.writeNext(data1);
            }

            System.out.println("The CSV file has been generated \n");

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    //method to create a new file with the given name
    public static String createNewFile() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Set name of file, e.g SavedFile.xml or SavedFile.csv");

        String xmlCsvFileName = scan.nextLine();

        try {
            File myObj = new File(xmlCsvFileName); //creating new file
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return xmlCsvFileName;
    }
}
