package com.company;

public class ConsoleIO extends IO{
    public abstract String read(){return System.console().readLine();}
    public abstract void write(String str){System.out.println(str);}
}
