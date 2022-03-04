package com.company;

import java.util.Scanner;

public class ConsoleIO extends IO{
    Scanner scanner ;

    public ConsoleIO(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String read(){
        return scanner.nextLine();
    }

    @Override
    public void write(String str){
        System.out.println(str);
    }
}
