package wordcloud;

/**
 * Created by kenny on 6/29/14.
 */
public class WordFrequency implements Comparable<WordFrequency> {

    private final String word;

    private final int frequency;
    
    private final int uncertainty;

    public WordFrequency(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
        this.uncertainty = 255;
        System.out.println("Added word " + word);
    }
    
    /*
     * Add uncertainty alpha value as int in [0-255]
     */
    public WordFrequency(String word, int frequency, int uncertainty) {
        this.word = word;
        this.frequency = frequency;
        this.uncertainty = uncertainty;
    }
    
    /*
     * Add uncertainty alpha value as float in [0.0, 1.0]
     */
    public WordFrequency(String word, int frequency, float uncertainty) {
        this.word = word;
        this.frequency = frequency;
        this.uncertainty = (int) (255 * uncertainty);
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }
    
    public int getUncertainty(){
    	return uncertainty;
	}

    @Override
    public int compareTo(WordFrequency wordFrequency) {
        return wordFrequency.frequency - frequency;
    }

}
