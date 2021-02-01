public class Word {
    private String word;
    private int wordsRepeated;

    Word(String word){
        this.setWord(word);
        this.setWordsRepeated();
    }

    public String getWord() { 
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordsRepeated() {
        return wordsRepeated;
    }

    public void setWordsRepeated() {
        wordsRepeated++;
    }

    @Override
    public String toString() {
        return word +" "+ wordsRepeated;
    }




    

    
}
