package dataManipulations;

import java.util.stream.*;
@DataProcessor
public class Filter{
    @DataProcessor
    public void work1(Stream<String> data,Stream<String> out){
        out=data.filter(str->str.length()>2);
        //return data.filter(str->str.length()>2);
    }
    @DataProcessor
    public void work2(Stream<String> data,Stream<String> out){
        out=data.filter(str->str.substring(0,1).equals("a"));
        //return data.filter(str->str.substring(0,1).equals("a"));
    }
    public void work3(Stream<String> data,Stream<Integer> out){
        out=data.map((str)->str.length());
        //return data.map((str)->str.length());
    }
    public void work4(Stream<Integer> data,Stream<Integer> out){
        out=data.sorted();
        //return data.sorted();
    }
    public void work5(Stream<Integer> data,Stream<String> out){
        out=data.map(String::valueOf);
        //return data.map(String::valueOf);
    }
}
