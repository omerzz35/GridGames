package com.company;

public class ConsoleIO extends IO{

    public String read(){
        String temp = System.console().readLine();
        return temp;
    }
    public void write(String str){
        System.out.println(str);
    }
}
