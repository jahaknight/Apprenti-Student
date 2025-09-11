package org.example;

import org.example.model.Printer;
import org.example.service.PrinterManager;
import org.example.service.PrinterMonitor;
import org.example.view.ConsoleIO;
import org.example.view.MenuController;

/**
 * App class for the 3D Printer Manager Application
 *
 */
public class App {
    public static void main( String[] args )
    {
        ConsoleIO io = ConsoleIO.getInstance();
        PrinterManager manager = new PrinterManager();
        MenuController menu = new MenuController(io, manager);
        menu.run();



        io.displayMessage("Printer monitor online");


        io.displayMessage("Halting printer monitors");
        manager.haltMonitors();
        io.displayMessage("Goodbye!");
        System.exit(0);
    }
}
