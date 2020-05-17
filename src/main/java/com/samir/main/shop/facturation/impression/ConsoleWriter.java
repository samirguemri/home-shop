package com.samir.main.shop.facturation.impression;

public class ConsoleWriter implements Writer {
    /**
     * Start writing process
     */
    @Override
    public void start() {

    }

    /**
     * Write on line
     *
     * @param line
     */
    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    /**
     * Stop writing process
     */
    @Override
    public void stop() {

    }
}
