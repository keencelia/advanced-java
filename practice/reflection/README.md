# 2021/2022 - Zadanie ćwiczeniowe - Refleksje i wszystko co do tej pory.


### Zadanie 1.

Celem zadania jest stworzenie aplikacji do gry w statki pomiędzy komputerem a użytkownikiem. Interfejs może być tekstowy. Aplikacja przechowuje dwie tablice 10x10, numerowane liczbowo na osi X, literowo na osi Y, dla siebie i dla użytkownika (chętni mogą dodać GUI), oraz pozycje statków, i cele "strzałów". Pozycje inicjalne użytkownika należy wczytać z pliku battleship.properties, oraz utworzyć i skonfigurować statki przy pomocy refleksji. Standardowo properties (atrybuty/parametry) wczytujemy przy pomocy metody Properties::load(*), która tworzy hash-mapę parametrów (czyli nie trzeba tego robić ręcznie). Plik umieszczamy w tym samym katalogu co klasę czytającą. Nazwy statków w kolejności rozmiarów (malejącej): carrier, battleship, destroyer, patrol boat. W zależności od reguł są to rozmiary 5:2 albo 4:1.
Każdy rodzaj statku należy do osobnej klasy, aczkolwiek mają one wiele cech wspólnych. Każda klasa ma dwa konstruktory - domyślny, który wybiera losową pozycję, oraz konstruktor który wymaga czterech parametrów typu int, pozycja lewa/górna oraz pozycja prawa/dolna.  

Czas jest ograniczony, więc następujące czynności powinny mieć priorytet:  
1. zaprojektowanie klas, interfejsów, metod z pełnymi sygnaturami, struktur danych do przechowywania elementów gry.  
2. wczytanie pozycji wejściowej użytkownika z pliku i zainicjowanie jego tablicy  
3. losowe wygenerowanie wejściowej pozycji komputera  
4. wczytanie "strzału" użytkownika z klawiatury i zapisanie, wypisanie efektu  
5. wygenerowanie "strzału" komputera, wypisanie celu i efektu  
6. kontynuacja gry aż do wygranej jednej ze stron  
  
7. Następne w kolejności byłoby opracowanie strategii ataku, zamiast ataku losowego.   



### Skopiuj katalog src z plikami do github'a: (add, commit, push)



## Wskazówki
- Korzystaj z możliwości generowania kodu przez IntelliJ - ułatwia to w sposób znaczący pracę. 
- Pamiętaj o zasadach programowania obiektowego (nie dawaj dostępu do atrybutów i metod bez konieczności).
- Stosuj dziedziczenie między klasami, gdy ma to sens
- Uruchamiaj testy zawsze korzystając z opcji debug.  
Dzięki temu łatwiej jest znaleźć i zrozumieć dlaczego program nie działa tak jak trzeba.  Pamiętaj o możliwości stawiania breakpointów.
- Pamiętaj o umiejscowieniu kodu w odpowiednim pakiecie. 
Najprościej, jeśli utworzysz nowy projekt, dodasz plik z testem i pozwolisz `Alt+Enter` 
na nazwie pakietu wykonać swoją magię.

