package com.company;

public class ConsoleIO extends IO{
    public String read(){return System.console().readLine();}
    public void write(String str){System.out.println(str);}
}
