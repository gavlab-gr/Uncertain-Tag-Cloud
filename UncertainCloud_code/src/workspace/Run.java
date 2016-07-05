package workspace;

/**
 *
 * @author Evi
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import wordcloud.*;
import wordcloud.nlp.*;

public class Run {
    public static void main(String[] args) {
        final FrequencyAnalizer frequencyAnalizer = new FrequencyAnalizer();
        frequencyAnalizer.setWordFrequencesToReturn(300);
        page1 n = new page1();
        n.setVisible(true);
    }

    public static InputStream getInputStream(String file) throws FileNotFoundException {
        return new FileInputStream(file) ;
    }

    public static List<WordFrequency> myInput()	{
        List<WordFrequency> wordFrequencies = new ArrayList<>();
        return wordFrequencies;
    }
}
