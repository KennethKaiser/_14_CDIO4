package dtu.filereader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVFileReaderTest {
    @Test
    void checkNoFileE(){
        CSVFileReader csvFileReader = new CSVFileReader();
        assertEquals(null, csvFileReader.readCSV("", ";"));

    }

}