# 2021/2022 - Lab2 - Multithreaded programming, Generics, Files

Rozwijamy zadanie z lab1

### Zadanie 1.
Zmień  klasę GaussianData na DistributionData tak aby obsługiwała również inne rozklady, np: Gamma, Uniform (użyj generyków lub interfejsów)

### Zadanie 2.
Zaprojektuj klasę DistributionData aby pracowała w swoim własnym wątku, zwracając dane (po jednym punkcie) w odpowiednim (dla programowania wielowątkowego) buforze. Zaprojektuj bufor tak aby czytający blokował się gdy nie ma danych, a piszący gdy bufor jest pełny. Zacznij z buforem o rozmiarze 100.

### Zadanie 3.
Dodaj kod w klasie DistributionData do zapisywania danych do pliku tekstowego, w dwóch kolumnach z nagłówkiem:  
x y  
-5.0 0.0  
...  
0.0 0.40  
...  

Zwróć uwagę na zaokrąglenia liczb rzeczywistych. 


## Wskazówki
- Korzystaj z możliwości generowania kodu przez IntelliJ - ułatwia to w sposób znaczący pracę. 
- Pamiętaj o zasadach programowania obiektowego (nie dawaj dostępu do atrybutów i metod bez konieczności).
- Stosuj dziedziczenie między klasami, gdy ma to sens
- Uruchamiaj testy zawsze korzystając z opcji debug.  
Dzięki temu łatwiej jest znaleźć i zrozumieć dlaczego program nie działa tak jak trzeba.  Pamiętaj o możliwości stawiania breakpointów.
- Pamiętaj o umiejscowieniu kodu w odpowiednim pakiecie. 
Najprościej, jeśli utworzysz nowy projekt, dodasz plik z testem i pozwolisz `Alt+Enter` 
na nazwie pakietu wykonać swoją magię.

