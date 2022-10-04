# 2022/2023 - Lab1 - IntelliJ, nowe pakiety, przypomnienie Javy.

### Zadanie 1.
Dodaj pakiety do IntelliJ, wykorzystamy je w kolejnych zadaniach 
Apache Commons Math
Apache Commons Text


### Zadanie 2.
Strumienie, oraz elementy grafiki. Do grafiki użyjemy JavaFX, ale trzeba ten pakiet zainstalować (od wersji Java11, JavaFX nie jest już częścią standardowego  jdk).
1. Instalacja JavaFX, kroki:
   - Tu (https://openjfx.io) znajdziesz pakiet z plikami jar dla javafx (redyrekcja z oracle.com), skopiuj do dowolnego katalogu, powiedzmy {path}
  
   - Dodaj {path}/javafx-sdk-??.?.?/lib do listy bibliotek do kompilacji w IntelliJ: File-> Project Structure->Modules, +, Jar/Library, Stage: Compile, zastąp ? odpowiednią wersją

   - W opcji Run -> Edit Configuration, dodaj parametr VM: 
  -p {path}/javafx-sdk-??.?.?/lib --add-modules javafx.base,javafx.graphics,javafx.controls

### Zadanie 3.
Narysuj standardową krzywą Gaussa w przedziale (-10,10). Skorzystaj z pliku LineGraphics.java
Zaimplementuj klasę GaussianData uzywając klasy z biblioteki Apache Commons Math do obliczenia wartości rozkładu Gaussa (normalnego) .


## Wskazówki
- Korzystaj z możliwości generowania kodu przez IntelliJ - ułatwia to w sposób znaczący pracę. 
- Pamiętaj o zasadach programowania obiektowego (nie dawaj dostępu do atrybutów i metod bez konieczności).
- Stosuj dziedziczenie między klasami, gdy ma to sens
- Uruchamiaj testy zawsze korzystając z opcji debug.  
Dzięki temu łatwiej jest znaleźć i zrozumieć dlaczego program nie działa tak jak trzeba.  Pamiętaj o możliwości stawiania breakpointów.
- Pamiętaj o umiejscowieniu kodu w odpowiednim pakiecie. 
Najprościej, jeśli utworzysz nowy projekt, dodasz plik z testem i pozwolisz `Alt+Enter` 
na nazwie pakietu wykonać swoją magię.

