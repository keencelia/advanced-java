# 2022/2023 - Lab1 - Środowisko IntelliJ, Nowy Projekt, HelloWorld

### Zadanie 1.
Zainstalowanie IntelliJ
Utworzenie Nowego Projektu
Java Class Hello

```java
package mini.java.basic.objects;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
```

### Zadanie 2.
Dziedziczenie

```java
package mini.java.basic.objects;

public class Vehicle {
    protected String name;
    protected String[] manufacturerNames;
    protected int price;
}

public class Plane extends Vehicle {
    private int flightSpeed;
    private int altitude;
}

public class Car extends Vehicle {
    private int speed;
}

public class Bicycle extends Vehicle {
    private boolean twoPerson;
}
```

### Zadanie 3.
Zaprogramuj klasę która znajduje oraz wypisuje liczby pierwsze aż do parametru pmax.



## Wskazówki
- Korzystaj z możliwości generowania kodu przez IntelliJ - ułatwia to w sposób znaczący pracę. 
- Pamiętaj o zasadach programowania obiektowego (nie dawaj dostępu do atrybutów i metod bez konieczności).
- Stosuj dziedziczenie między klasami, gdy ma to sens
- Uruchamiaj testy zawsze korzystając z opcji debug.  
Dzięki temu łatwiej jest znaleźć i zrozumieć dlaczego program nie działa tak jak trzeba.  Pamiętaj o możliwości stawiania breakpointów.
- Pamiętaj o umiejscowieniu kodu w odpowiednim pakiecie. 
Najprościej, jeśli utworzysz nowy projekt, dodasz plik z testem i pozwolisz `Alt+Enter` 
na nazwie pakietu wykonać swoją magię.

