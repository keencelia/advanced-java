package mini.java.task;


public class SearchEngine {

    private Thread loaderThread;
    private Thread[] indexerThreads;
    private DataLoader loader;
    private InvertedIndex[] indexers;
    private queue;
    private index;

    /**
     * Konstruuje SearchEngine 
     * @param dir - nazwa katalogu
     * @param pattern - nazwa pliku lub wzoru plików wg wyrażeń regularnych (nie wildcard !!!)
     * @param indexerNum - liczba indeksujących wątków
     */

    public SearchEngine(String dir, String pattern, int indexerNum) {

	// TODO: utwórz queue oraz index

        loader = new DataLoader();

        indexerNum = Math.max(1,indexerNum);

        indexers = new InvertedIndex[indexerNum];
        indexerThreads = new Thread[indexerNum];

        for (int i = 0; i<indexerNum; i++) {
            indexers[i] = new InvertedIndex(index);
        }

        loaderThread = new Thread(new Runnable() {
            @Override
            public void run() {
                loader.read(dir, pattern, queue);
            }
        });

        for (int i = 0; i < indexerNum; i++) {
            int finalI = i;
            indexerThreads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    indexers[finalI].build(queue);
                }
            });
        }
    }

    /**
     * startuje wszystkie wątki które budują index
     */
    public void build () {
        loaderThread.start();
        for (int i = 0; i < indexerThreads.length; i++) {
            indexerThreads[i].start();
        }
    }

    /**
     * przeszukuje index celem znalezienia lokalizacji słów, po czym czyta z pliku odpowiednią linię
     * indexer przeszukuje index wg zasad wyjaśnionych w opisie metody w InvertedIndex
     * DataLoader wczytuje linię (w głównym, nie w osobnym wątku)
     * @param words - jedno lub więcej słów do wyszukania
     * @return Entry zawierające nazwę pliku, nr linii, oraz daną linię wczytaną z pliku (na żądanie)
     */

    public Entry query(String words) {
        Entry entry =  indexers[0].query(words);
        if (entry == null) return null;
        entry.setText(loader.load(entry.getFilename(), entry.getLine()));
        return entry;
    }

    /**
     * zatrzymuje budowanie indeksu(poprzez zastopowanie wszystkich wątków)
     */
    public void stop() {
        loader.stop();
        for (int i = 0; i < indexerThreads.length; i++) {
            indexers[i].stop();
        }
    }

    /**
     * zwraca rozmiar indeksu
     * @return liczba kluczy w indeksie
     */
    public int getSize() {
        return index.size();
    }

    /**
     * zwraca wszystkie słowa w indeksie, posortowane
     * @return all keys in the index, sorted
     */
    public List<String> getWords() {
        ArrayList <String> list = new ArrayList <>();
        list.addAll(index.keySet());
        Collections.sort(list);
        return list;
    }

    /**
     * sprawdza czy wszystkie wątki pracują
     * @return
     */
    public boolean isRunning() {
        boolean isRunning =  !loaderThread.getState().equals(Thread.State.TERMINATED);

        for (int i = 0; i < indexerThreads.length; i++) {
            isRunning = isRunning && !indexerThreads[i].getState().equals(Thread.State.TERMINATED);
        }

        return isRunning;
    }

    /**
     * sprawdza czy wszystkie wątki się zakończyły
     * @return
     */
    public boolean isStopped() {

        boolean isStopped =  loaderThread.getState().equals(Thread.State.TERMINATED);

        for (int i = 0; i < indexerThreads.length; i++) {
            isStopped = isStopped && indexerThreads[i].getState().equals(Thread.State.TERMINATED);
        }

        return isStopped;
    }


    /**
     * podklasa Entry do zwracania rezultatów
     */
    static public class Entry {

        private String text;
        private String filename;
        private int line;


        public Entry(String filename, int line) {
            this.filename = filename;
            this.line = line;
        }

        public Entry(String filename, int line, String text) {
            this.filename = filename;
            this.line = line;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public String getFilename() {
            return filename;
        }

        public int getLine() {
            return line;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

}
