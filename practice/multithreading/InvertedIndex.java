package mini.java.task;


public class InvertedIndex {


    public InvertedIndex(index) {

    }


    /**
     * czyta zawartość kolejki i buduje z niej index, kolejka musi mieć słowa oraz ich lokację (plik+numer linii)
     * @param queue - odpowiednia struktura z danymi
     * @return
     */
    public void build(queue) {

    }

    /**
     * przeszukuje index celem znalezienia lokalizacji słów, zwraca tylko jedną lokalizację według następujących zasad
     * jeśli jest tylko jedno słowo: znajduje plik który ma najwięcej wystąpień danego słowa i zwraca pierwszą linię ze słowem w pliku
     * jeśli jest więcej słów (w testach 2 lub 3, znajduje wspólny plik i wspólny numer linii, 
     * jeśli więcej plików znalezionych, to ten który ma najwięcej wystąpień obu słów)
     * opcja z więcej niż jednym słowem jest trudniejsza, dobrze widziana pomysłowość
     * @param words - jedno lub więcej słów do wyszukania
     * @return Entry zawierające nazwę pliku i nr linii
     */
    public SearchEngine.Entry query(String words) {

    }

    /**
     * zatrzymuje synchronicznie wątek
     */
    public void stop() {

    }




    /**
     * pomocnicza klasa, do użycia jeśli potrzebna, może być modyfikowana według potrzeb
     */

    public class Location {

        public Location(String filename, int line) {
            this.fileName = filename;
            this.lines = new ArrayList<Integer>();
            lines.add(line);
        }

        public Location(String filename, List<Integer> lines) {
            this.fileName = filename;
            this.lines = lines;
        }


        public boolean equals(Object o) {
            if (o.getClass() != this.getClass()) return false;

            Location l = (Location)o;

            return (this.fileName.equals(l.fileName)) && (Objects.equals(this.lines, l.lines));
        }

        public Location intersection(Location l) {
            if (!this.fileName.equals(l.fileName)) return null;

            List<Integer> lines = new ArrayList<Integer>();

            for (Integer n: this.getLines()) {
                if (l.getLines().contains(n)) lines.add(n);
            }

            if (lines.isEmpty()) return null;

            Location nl = new Location(this.fileName, lines);
            return nl;
        }

        public String getFileName() {
            return fileName;
        }

        public List<Integer> getLines() {
            return lines;
        }

        public void addLine(int line) {
            this.lines.add(line);
        }

        private String fileName;
        private List<Integer> lines;
    }



}
