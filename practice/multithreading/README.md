## 2021/2022 - Zadanie ćwiczeniowe - Programowanie wielowątkowe (oraz przypomnienie plików i kolekcji)

Twoim zadaniem jest napisanie dwóch klas implementujących metody tak, aby napisane testy jednostkowe skompilowały się i wykonały poprawnie. 

Opis problemu: 
- Zadanie polega na zaimplementowaniu uproszczonego "SearchEngine" czyli indeksu słów występujących w załączonych plikach, używając tzw. InvertedIndex (zob. https://en.wikipedia.org/wiki/Inverted_index), który mapuje słowa do lokalizacji (w tym przypadku nazwy pliku i numeru linii). Index służy do znajdowania plików zawierających interesujące nas słowa lub zwroty. Jest to uproszczony SearchEngine, więc zwraca tylko jedną, najlepszą opcję. W prostym przypadku pojedynczego szukanego słowa, SearchEngine zwraca nazwę pliku który ma najwięcej wystąpień danego słowa oraz pierwszą linię która zawiera to słowo (numer i cały tekst tej linii). W przypadku szukania fraz (trudniejsza opcja), SearchEngine szuka każdego słowa osobno, po czym wybiera wspólne lokalizacje (ten sam plik i ta sama linia). W przypadku kilku lokalizacji wybiera plik który ma najwięcej (wspólnych) wystąpień oraz pierwszą linię z wystąpieniem (czyli identycznie jak w przypadku pojedynczego słowa). Wątki które czytają pliki i budują index muszą byś zatrzymane synchroniczne na żądanie (funkcja stop).

Załączone pliki: 
- SearchEngine.java - poza definicją i utworzeniem struktur danych nie wymaga zmian
- SearchEngineTest.java - testy junit do wykonana
- data.zip - (w repo keencelia w katalogu lab15), do skopiowania do głównego katalogu projektu i odpakowania, 101 plików powinno się znaleźć w podkatalogu data 

Do zaimplementowania:
- DataLoader.java  - ładuje dane z plików przekazanych jako nazwa katalogu i wyrażenie regularne identyfikujące grupę plików
- InvertedIndex.java - buduje strukturę InvertedIndex, przeszukuje ją na żądanie (funkcja query)


Sygnatury klas to:

```java
/***
* Klasa do wczytywania słów
*/

public class DataLoader {

    // słowa do ominięcia
    private List<String> stdIgnore = ... 


    /**
     * czyta słowa z plików, omijając znaki przestankowe, jak np. .,;*"() oraz słowa z listy stdIgnore
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
     * czyta linię z pliku, (plik i linia wyszukane w indeksie), celem zwrócenia z zapytaniem
     * @param filename - plik ze ścieżką dostępu
     * @param line - numer linii
     * @return cała wczytana linia
     */
    public String load(String filename, int line) {

    }

    // inne prywatne funkcje do zwiększenia czytelności kodu

}
```

```java
/***
* Klasa do budowania odwróconego indeksu
*/
public class InvertedIndex {

    /**
     * Konstruktor
     */

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

    // inne prywatne funkcje dla zwiększenia czytelności kodu

    /**
     * pomocnicza klasa, do użycia jeśli potrzebna, może być modyfikowana według potrzeb
     */

    public class Location {
	...

    }

}
```


## Wskazówki
- Korzystaj z możliwości generowania kodu przez IntelliJ - ułatwia to w sposób znaczący pracę. 
- Pamiętaj o zasadach programowania obiektowego (nie dawaj dostępu do atrybutów i metod bez konieczności).
- Stosuj dziedziczenie między klasami, gdy ma to sens
- Pisz czytelny kod (komentarze, dodatkowe funkcje)
- Uruchamiaj testy zawsze korzystając z opcji debug.  
Dzieki temu ławiej jest znaleźć i zrozumieć dlaczego program nie działa tak jak trzeba.  Pamiętaj o możliwości stawiania breakpointów.
- Pamiętaj o umiejscowieniu kodu w odpowiednim pakiecie. Najlepiej zostaw pakiet użyty w przykładzie, ułatwia to poprawianie testu.

