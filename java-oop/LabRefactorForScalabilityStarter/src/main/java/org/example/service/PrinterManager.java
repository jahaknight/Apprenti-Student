package org.example.service;

import org.example.model.Printer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PrinterManager {

    private Map<String, Printer> printers;
    private List<PrinterMonitor> monitors;

    public PrinterManager() {
        this.printers = new LinkedHashMap<String, Printer>();
        this.monitors = new ArrayList<PrinterMonitor>();
    }

    public void addPrinter(String key, Printer printer){
        printers.put(key, printer);
    }

    public Printer getPrinter(String key){

        return printers.get(key);
    }

    // Read- only list of all printer IDs
    public List<String> getAllPrinterIDs(){
        return new ArrayList<>(printers.keySet());
        /*
        return list of Strings from printers
         */
    }

    // Stop all monitors
    public void haltMonitors() {
        for (PrinterMonitor m : monitors) {
            m.haltMonitor();
            }
        monitors.clear();

        /*
        add HALTED status to printer
        set all printers to halted
         */
    }
}