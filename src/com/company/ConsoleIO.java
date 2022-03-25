package com.company;

import java.util.Scanner;

public class ConsoleIO extends IO{
    Scanner scanner ;

    /**
     * constructor
     */
    public ConsoleIO(){
        this.scanner = new Scanner(System.in);
    }

    /**
     * read input from user
     * @return the input from user
     */
    @Override
    public String read(){
        return scanner.nextLine();
    }

    /**
     * Write output on GUI
     * @param str the output to write
     */
    @Override
    public void write(String str){
        System.out.println(str);
    }
}
