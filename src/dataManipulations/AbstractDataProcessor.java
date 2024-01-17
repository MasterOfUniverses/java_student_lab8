package dataManipulations;

import java.util.stream.Stream;


public interface AbstractDataProcessor<T> {
    @DataProcessor
    public abstract T work(String data);
}
