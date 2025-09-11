package org.example.service;

import org.example.model.Printer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrinterManagerTest {

    private PrinterManager pm;

    @BeforeEach
    public void setup(){
        pm = new PrinterManager();

        Printer p1 = new Printer("Alpha");
        Printer p2 = new Printer("Beta");
        Printer p3 = new Printer("Charlie");

        pm.addPrinter("A", p1);
        pm.addPrinter("B", p2);
        pm.addPrinter("C", p3);
    }

    @Test
    public void addPrinterAddsAPrinterToTheMap(){
        Printer testPrinter = new Printer("testPrinter");
        pm.addPrinter("ab", testPrinter);
        assertEquals(testPrinter, pm.getPrinter("ab"));
    }

    @Test
    public void getAllPrinterIDsReturnsCorrectListOfAllPrinters(){

        // Act
        List<String> ids = pm.getAllPrinterIDs();

        // Assert
        assertEquals(Set.of("A", "B", "C"), Set.copyOf(ids), "IDs do not match");



    }

    @Test
    public void getPrinterIDSize(){

        // Act
        List<String> ids = pm.getAllPrinterIDs();

        // Assert
        assertEquals(3, ids.size(), "Should return all printer IDs");

    }
}