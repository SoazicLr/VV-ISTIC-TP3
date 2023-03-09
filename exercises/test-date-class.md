# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer


1-   
**CreationDate** :
Exception : 300,3000,303

**IsValide()** :   
- valide : (1,1,2020),(10,03,2019),(31,03,2018), (29,02,2024),  
- non valide : (0,0,0), (31,04,2022), (29,02,2023), (20,14,2009), (40,05,2010)  

**isLeapYear()** :    
- valide : 2004, 2008, 2016, 4 ,400 
- non valide : 2003, 2005, 2010, 2011, 2015, 100 

**nextDate()** :   
- 2/1/2020 : (1,1,2020)  
- 13/03/2019 : (12,03,2019)  
- 02/04/2018 : (01,04,2018)  
- 02/02/2024 : (01,02,2024)  
- 01/01/2022 : (31,12,2021)  

**previousDate()** :  
- 31/12/2019 : (1,1,2020)  
- 11/03/2019 : (12,03,2019)  
- 31/03/2018 : (01,04,2018)  
- 29/02/2024 : (01,02,2024)  
- 30/12/2021 : (31,12,2021)  

**compareTo()** :  
- 0  :   
      -> (1,1,2019) : (1,1,2019)  
- positive :    
        -> (1,1,2010) : (3,4,2019)  
        -> (4,4,2000) : (5,4,2000)  
        -> (22,10,2000) : (3,11,2000)
- negative :   
        -> (3,4,2019) : (1,1,2010)   
        -> (5,4,2000) : (4,4,2000)  
        -> (3,11,2000) : (22,10,2000)
- Execption :   
        -> (3,4,2019) : null


2-  100% de coverage 
![img_2.png](img_2.png)


3-  
![img_3.png](img_3.png)
Dans le cas de ce predicat tout à été testé, des années normale, bissextile, et aussi la scas plus particulier avec 100 et 400.
![img_4.png](img_4.png)
Dans ce prédicat tout n'as pas forcément été tester mais il n'y a pas de raison que cela pose problème.

4-  
![img_5.png](img_5.png)
On remarque que les "mutation coverage" est de 94%, il ya 3 mutants qui ont survécu. 
Dans le detail on peut voir quels prédicat sont concernés.
![img_6.png](img_6.png)
Nous avons essayer de rajouter des tests mais nous n'avons pas reussi à regler ce problème.  
Mais 94% ne semble pas être un si mauvais résultat. 