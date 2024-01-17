package dataManipulations;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.*;

public class DataManager {
    private ArrayList<Object> processors;
    private Stream<String> data;
    public DataManager(){
        processors = new ArrayList<>();
    }
    public void registerDataProcessor(Object processor)throws Exception{
        if(processor.getClass().isAnnotationPresent(DataProcessor.class)){
            this.processors.add(processor);
        }else{
            throw new UnsupportedOperationException("Object "+processor.getClass().toString()+" has no @DataProcessor annotation");
        }
    }

    public void loadData(String source)throws Exception{
        data = Files.lines(Path.of(source));
    }
    public void processData() throws Exception{
        for(Object processor:processors){
            Method[] methods = processor.getClass().getDeclaredMethods();
            for(Method method:methods){
                if(method.isAnnotationPresent(DataProcessor.class)){
                    data=method.invoke(processor,data);
                }
            }
        }
    }
    public void saveData(String destination) throws Exception{
        PrintWriter output = new PrintWriter(destination);
        data.forEach(output::println);
        output.close();
    }
}
