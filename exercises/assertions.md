# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. Cela échoue car on multiplie un int et un float. 
   
2. La méthode assertEquals vérifie si deux objets ont la même valeur, alors que la méthode assertSame vérifie s'ils sont identiques en termes de référence mémoire
```java
 List<String> list1 = Arrays.asList("one", "two", "three");
 List<String> list2 = new ArrayList<>(list1);

// assertEquals : Vérifie si les valeurs sont égales
assertEquals(list1, list2); // passe, les deux listes ont les mêmes valeurs

// assertSame : Vérifie si les références sont les mêmes
assertSame(list1, list2); // échoue, les deux listes sont stockées dans des objets différents

```

3. Pour marquer une fonctionnalité qui n'a pas encore été implémentée : Dans ce cas, on peut utiliser fail comme substitut temporaire pour une fonctionnalité manquante, en signalant qu'elle n'a pas encore été implémentée. Par exemple :  

```java
public void testMethod() {
// À implémenter
fail("La fonctionnalité n'est pas encore implémentée");
}
```

4. Permet de spécifier plus précisément les conditions dans lesquelles une exception doit être levée.  
   Meilleure lisibilité du code : assertThrows permet de mettre en évidence les vérifications d'exception dans
   le corps du test, c'est plus lisible et plus facile à comprendre. 

