/**
 * Processing the input file
 */
package com.example.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.config.CashRegisterProperties;
import com.example.service.CashRegisterService;
import com.example.service.FileInputProcessor;

@Component
public class FileProcessorRunner implements CommandLineRunner {

    private final CashRegisterService service;
    private final CashRegisterProperties props;

    public FileProcessorRunner(CashRegisterService service, CashRegisterProperties props) {
        this.service = service;
        this.props = props;
    }

@Override
public void run(String... args) throws Exception {
    FileInputProcessor inputProcessor = new FileInputProcessor(props.getInputFile());
    inputProcessor.readLines()
        .map(line -> {
            String[] parts = line.split(",");
            int owed = (int) Math.round(Double.parseDouble(parts[0]) * 100);
            int paid = (int) Math.round(Double.parseDouble(parts[1]) * 100);
            if (owed < 0 || paid < 0) {
                return "Negative input";
            }
            // calculate change and print in correct format
            return service.calculateChange(owed, paid);
        })
        .forEach(System.out::println);
}

}
