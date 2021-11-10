package mini.java.task;


public class DataLoader {


    private List<String> stdIgnore = Arrays.asList(new String [] {"a", "able", "about", "all", "an", "and", "any", "are", "as", "at", "be", "been", "by",
            "can", "can't", "could", "couldn't", "do", "does", "doesn't", "don't", "down", "has", "hasn't", "have", "haven't", "he", "here", "his", "how",
            "I", "I'm", "if", "in", "is", "it", "its", "it's", "just", "like", "many", "much", "no", "not", "now", "of", "on", "one",
            "or", "she", "so", "than", "that", "the", "them", "then", "there", "these", "they", "this", "those", "to", "too", "up", "very", "was", "we", "were",
            "what", "when", "where", "which", "who", "will", "won't", "would", "you", "you'd", "you'll"}).stream().map(x->x.toLowerCase()).collect(Collectors.toList());



    /**
     * czyta słowa z plików, omijając znaki przestankowe: .,;*"() oraz słowa z listy stdIgnore
     * @param dir - nazwa katalogu
     * @param pattern - nazwa pliku lub wzoru plików wg wyrażeń regularnych (nie wildcard !!!)
     * @param queue - odpowiednia struktura dla wczytywanych danych
     * @return
     */
    public void read(String dir, String pattern, queue) {

    }

    /**
     * zatrzymuje synchronicznie wątek
     */

    public void stop() {

    }


    /**
     * czyta linię z pliku, celem zwrócenia z zapytaniem
     * @param filename - plik ze ścieżka dostępu
     * @param line - numer linii
     * @return cała wczytana linia
     */
    public String load(String filename, int line) {

    }


}
