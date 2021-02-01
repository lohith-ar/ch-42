import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Task42 {
    static int noofrecords = 0;
    // static SinglyLinkedList sl = new SinglyLinkedList();
    static LinkedList<Word> sll = new LinkedList<Word>();
    static ArrayList<String> al = new ArrayList<String>();
    // static Word w;



    public static void main(String[] args) {
        try {
            Task42.readFromFile("daffodils.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        long start = System.currentTimeMillis();
        for(Word w:sll){
            System.out.println(w);
        }
        long end = System.currentTimeMillis();
        // System.out.println("\ntime taken for adding elements: " + (end - start)+"\n");

        System.out.println("\n-------------Sorted order-------------");
        start = System.currentTimeMillis();
        Collections.sort(sll, new SortWordsasc());        end = System.currentTimeMillis();

        for(Word w:sll){
            System.out.println(w);
        }
        System.out.println("\ntime taken for sorting elements: " + (end - start)+"\n");
        
        System.out.println("\n-------------descending order-------------");
        start = System.currentTimeMillis();
        Collections.sort(sll, new SortWordsdesc());        end = System.currentTimeMillis();
        for(Word w:sll){
            System.out.println(w);
        }
        System.out.println("\ntime taken for sorting elements descending: " + (end - start));
        
        System.out.println("\n-------------word count descending order-------------");
        start = System.currentTimeMillis();
        Collections.sort(sll, new SortWordCounts());
        Collections.reverse(sll);
        end = System.currentTimeMillis();
        for(Word w:sll){
            System.out.println(w);
        }
        System.out.println("\ntime taken for sorting elements based on word count frequency: " + (end - start));
    }

    public static void readFromFile(String fileName) throws Exception {
        File file = new File(fileName);

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            String[] words = null;
            while ((line = br.readLine()) != null) {

                line = line.toLowerCase().replaceAll("[,':;.?]", " ");
                words = line.split(" ");

                for (String word : words) { /*sll.contains(new Word(word).getWord()) */
                    Word w = new Word(word); 
                    if(al.contains(w.getWord())){
                        int i = al.indexOf(w.getWord()); 
                        sll.get(i).setWordsRepeated();
                    }else{
                    sll.add(w);
                    al.add(w.getWord());
                    noofrecords++;
                    }
                }
            }
        }
    }
}


class SortWordsasc implements Comparator<Word>{

    @Override
    public int compare(Word o1, Word o2) {
        if(o1.getWord().compareTo(o2.getWord())>0){
            return 1;
        }if(o1.getWord().compareTo(o2.getWord())==0){
            return 0;
        }else 
        return -1;
    }
    
}

class SortWordsdesc implements Comparator<Word>{

    @Override
    public int compare(Word o1, Word o2) {
        if(o1.getWord().compareTo(o2.getWord())<0){
            return 1;
        }if(o1.getWord().compareTo(o2.getWord())==0){
            return 0;
        }else 
        return -1;
    }
} 


class SortWordCounts implements Comparator<Word>{
    @Override
    public int compare(Word o1, Word o2) {
        if(o1.getWordsRepeated() > o2.getWordsRepeated()){
            return 1;
        }else 
        return -1;

    }
    
}

