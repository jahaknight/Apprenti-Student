package org.example.view;

import org.example.model.Printer;
import org.example.service.PrinterManager;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private ConsoleIO io;
    private PrinterManager manager;

    public MenuController(ConsoleIO io, PrinterManager manager) {
        this.io = ConsoleIO.getInstance();
        this.manager = new PrinterManager();
    }

    public void run() {
        boolean running = true;
        Printer p;
        while (running) {
            io.displayMessage("=== 3D Printer Farm ===");
            io.displayMessage("[D]isplay printer status");
            io.displayMessage("[A]dd a new printer");
            io.displayMessage("[P]rint an object");
            io.displayMessage("[C]lear the print bed");
            io.displayMessage("e[X]it");
            String choice = io.getStringRequired("");

            switch (choice) {
                case "D": // display all printers
                    List<String> printerID = manager.getAllPrinterIDs();
                    if (printerID.isEmpty()) {
                        io.displayMessage("No printers added yet");
                    } else {
                        io.displayMessage("Printers");
                        for (String id : printerID) {
                            p = manager.getPrinter(id);
                            io.displayMessage(p.toString());
                        }
                    }
                    break;

                case "A": { // add a new printer
                    String id = io.getStringRequired("Enter printer ID");
                    if (manager.getPrinter(id) != null) {
                        io.displayMessage("ID already exits:" + id);
                        break;
                    }
                    String name = io.getStringRequired("Enter printer name ");
                    p = new Printer(name);
                    manager.addPrinter(id, p);
                    io.displayMessage("Added: " + id + " : " + p.getName());
                    break;
                }

                case "P": // start print on chosen printer
                    p = getPrinterFromUser();
                    if (p == null) {
                        break;
                    }
                    if (p.getStatus() != Printer.PrinterStatus.READY) {
                        io.displayMessage("Printer not ready. Current: " + p.getStatus());
                        break;
                    }
                    String file = io.getStringRequired("Object to print");
                    p.print(file);
                    io.displayMessage("Sent to "  + " : " + file);
                    break;

                case "C":
                    p = getPrinterFromUser();
                    if (p == null) {
                        break;
                    }
                    if (p.getStatus() == Printer.PrinterStatus.COMPLETE) {
                        io.displayMessage("Retrieving" + p.getPrintModelName());
                        p.clearBed(); // Complete -> Ready
                        io.displayMessage(p.toString());
                    } else {
                        io.displayMessage("Print incomplete or not started.");
                    }

                    break;

                case "X":
                    running = false;
                    break;
                default:
                    io.displayMessage("Unknown choice. Use D= Display, A=Add, P=Print, C=Clear, X= Exit");
            }

        }

    }
    public Printer getPrinterFromUser() {
        List<String> ids = manager.getAllPrinterIDs();
        if (ids.isEmpty()) {
            io.displayMessage("No printers available. Add one first.");
        }
        io.displayMessage("Available printers: ");
        for (String id : ids) io.displayMessage(" - " + id);

        String id = io.getStringRequired("Enter printer ID");
        Printer p = manager.getPrinter(id);
        if (p == null) {
            io.displayMessage("No printer with ID: " + id);
        }
        return p;
    }
}
