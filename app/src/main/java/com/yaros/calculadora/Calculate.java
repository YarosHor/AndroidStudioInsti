package com.yaros.calculadora;

import java.io.IOException;

public class Calculate {
    public double calculate(StringBuilder sb) throws Exception {
        double result = 0;
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        double secondD;
        Character symbol = null;
        boolean done;
        char charsSymbolSimple[] = {'+','-'};
        Exception IOException = new Exception();

        //Repeats for every char inputted
        for(int i = 0; i< sb.length(); i++){
            done = false;
            //if first char is symbol
            if(i == 0 && isSymbol(sb.charAt(i))){
                throw IOException;
            }
            //if last char is symbol
            else if(i == sb.length() -1 && isSymbol(sb.charAt(i))){
                throw IOException;
            }
            else{
                //if char is symbol
                if(isSymbol(sb.charAt(i))){
                    //if there is char in front or behind char
                    if(isSymbol(sb.charAt(i - 1)))
                        throw IOException;
                    if(isSymbol(sb.charAt(i + 1)))
                        throw IOException;
                    // if char is point
                    if(sb.charAt(i) == '.'){
                        if(symbol == null)
                            first.append(sb.charAt(i));
                        else
                            second.append(sb.charAt(i));
                    }

                    //if no operation char
                    else if(symbol == null) {
                        symbol = sb.charAt(i);
                    }
                    //if yes operation char
                    else{
                        for (int j = 0; j < charsSymbolSimple.length; j++){
                            //If next is simple operation
                            if(sb.charAt(i) == charsSymbolSimple[j]){
                                 result = result + operation(Double.parseDouble(first.toString()), Double.parseDouble(second.toString()), symbol);
                                 first.delete(0, first.length());
                                 first.append(result);
                                 second.delete(0, second.length());
                                 symbol = sb.charAt(i);
                                 result = 0;
                                 done = true;
                            }
                        }
                        //If next is complicated operation
                        if(done != true){
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(second);
                            stringBuilder.append(sb.substring(i, sb.length()));
                            return result + operation(Double.parseDouble(first.toString()), calculate(stringBuilder), symbol);
                        }
                    }
                }
                //if char is number
                else if(sb.charAt(i) % 1 == 0){
                    if(symbol == null)
                        first.append(sb.charAt(i));
                    else
                        second.append(sb.charAt(i));
                }
            }
        }
        if(symbol != null)
            return operation(Double.parseDouble(first.toString()), Double.parseDouble(second.toString()), symbol);
        return Double.parseDouble(first.toString());
    }
    public boolean isSymbol(char c){
        boolean symbol = false;
        char charsSymbolPoint[] = {'%','/','x','-','+','.'};
        for(int i = 0; i < charsSymbolPoint.length; i++){
            if(charsSymbolPoint[i] == c)
                symbol = true;
        }
        return symbol;
    }


    public double operation(double first, double second, char c){
        if(c == 'x')
            return first * second;
        else if(c == '/')
            return first / second;
        else if(c == '%')
            return first % second;
        else if(c == '+')
            return first + second;
        else if(c == '-')
            return first - second;
        else
            return 0;
    }
}
