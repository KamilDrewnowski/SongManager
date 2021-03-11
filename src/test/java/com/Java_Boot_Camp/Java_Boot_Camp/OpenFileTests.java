package com.Java_Boot_Camp.Java_Boot_Camp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenFileTests {

    String exampleName = "file.xml";
    String correctExtension = "xml";

    //testing getting an extension from a file
    @Test
    public void testGetExtensionByApacheCommonLib(){
        String getExtension;
        getExtension=OpenFile.getExtensionByApacheCommonLib(exampleName);
        assertEquals(correctExtension, getExtension);
    }

}
