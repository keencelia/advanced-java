## 2021/2022 - Zadanie ćwiczeniowe - Programowanie strumieniowe 

Twoim zadaniem jest napisanie metod operujących na dużych macierzach, które mogą być rozproszonych wierszami (tzw. sharding).  W takim przypadku chcemy mieć dostęp do strumienia wierszy. (np. Spark zapewnia taki dostęp przy pomocy RDD).     
Wczytaj dołączony plik danych, po rozpakowaniu. Jest to bardzo duży plik więc wczytaj liniami tylko tyle ile udźwignie Twój system (ale aby była to wielokrotność 200 linii).  

Dane opisują zachowanie osobników w stadzie, każda grupa liczy 200 osobników (numer grupy to pierwsza kolumna), ostatnia kolumna wypisuje czy stado porusza się w sposób zsynchronizowany czy nie (0/1).  

Pozostałe kolumny opisują  
x,y - pozycja osobnika  
xVel, yVel - prędkość  
xA, yA - wektor wyrównania  
xS, yS - decor separacji  
xC, yC - wektor kohezji  
nAc - liczba osobników w promieniu wyrównania/kohezji  
nS - liczba osobników w promieniu separacji  



Opis problemu:  
Napisz klasę BigMatrixUtil, która zapewni odpowiednią strukturę danych dla dużej macierzy, oraz udostępni metody:  
- obliczenie średniej dowolnej kolumny  
- obliczenie wariancji dowolnej kolumny  
- obliczenie macierzy kowariancji X<sup>T</sup>X, gdzie X jest wejściową macierzą    
- obliczenie macierzy korelacji (cov<sub>xy</sub>/sqrt(var<sub>x</sub>)sqrt(var<sub>y</sub>)), gdzie x i y to dowolne kolumny  



Używając narzędzi klasy BigMatrixUtil policz:
- macierz kowariancji oraz korelacji dla wartości wczytanej macierzy bez uwzględnienia pierwszej i ostatniej kolumny.  
- średnią prędkość dla każdej grupy, (policz prędkość jako jeden wektor)  
- średnią odległość między osobnikami i wariancję dla wszystkich group zsynchronizowanych i niezsynchronizowanych (ostatnia kolumna), podaj wynik.  

Metody powinny być zaimplementowane przy pomocy strumieni, unikając używania FOR, WHILE, IF.  



## Wskazówki
- Korzystaj z możliwości generowania kodu przez IntelliJ - ułatwia to w sposób znaczący pracę. 
- Pamiętaj o zasadach programowania obiektowego (nie dawaj dostępu do atrybutów i metod bez konieczności).
- Stosuj dziedziczenie między klasami, gdy ma to sens
- Pisz czytelny kod (komentarze, dodatkowe funkcje)
- Uruchamiaj testy zawsze korzystając z opcji debug.  
Dzieki temu ławiej jest znaleźć i zrozumieć dlaczego program nie działa tak jak trzeba.  Pamiętaj o możliwości stawiania breakpointów.
- Pamiętaj o umiejscowieniu kodu w odpowiednim pakiecie. Najlepiej zostaw pakiet użyty w przykładzie, ułatwia to poprawianie testu.

