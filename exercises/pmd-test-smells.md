# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer
Dans "Apache commons collection" j'ai teste l'utilisation de assertTrue à la place de assertEquals (UseAssertTrueInsteadOfAssertEquals)
J'ai trouver plusieurs erreurs. 

```
Mar 07, 2023 11:06:59 AM net.sourceforge.pmd.PMD encourageToUseIncrementalAnalysis
WARNING: This analysis could be faster, please consider using Incremental Analysis: https://pmd.github.io/pmd-6.55.0/pmd_userdocs_incremental_analysis.html
/home/soazic/Documents/FAC/m2/VV/commons-collections/src/test/java/org/apache/commons/collections4/TransformerUtilsTest.java:128:	UseAssertTrueInsteadOfAssertEquals:	Use assertTrue(x)/assertFalse(x) instead of assertEquals(true, x)/assertEquals(false, x) or assertEquals(Boolean.TRUE, x)/assertEquals(Boolean.FALSE, x).
/home/soazic/Documents/FAC/m2/VV/commons-collections/src/test/java/org/apache/commons/collections4/TransformerUtilsTest.java:129:	UseAssertTrueInsteadOfAssertEquals:	Use assertTrue(x)/assertFalse(x) instead of assertEquals(true, x)/assertEquals(false, x) or assertEquals(Boolean.TRUE, x)/assertEquals(Boolean.FALSE, x).
/home/soazic/Documents/FAC/m2/VV/commons-collections/src/test/java/org/apache/commons/collections4/TransformerUtilsTest.java:130:	UseAssertTrueInsteadOfAssertEquals:	Use assertTrue(x)/assertFalse(x) instead of assertEquals(true, x)/assertEquals(false, x) or assertEquals(Boolean.TRUE, x)/assertEquals(Boolean.FALSE, x).
/home/soazic/Documents/FAC/m2/VV/commons-collections/src/test/java/org/apache/commons/collections4/TransformerUtilsTest.java:131:	UseAssertTrueInsteadOfAssertEquals:	Use assertTrue(x)/assertFalse(x) instead of assertEquals(true, x)/assertEquals(false, x) or assertEquals(Boolean.TRUE, x)/assertEquals(Boolean.FALSE, x).
/home/soazic/Documents/FAC/m2/VV/commons-collections/src/test/java/org/apache/commons/collections4/TransformerUtilsTest.java:290:	UseAssertTrueInsteadOfAssertEquals:	Use assertTrue(x)/assertFalse(x) instead of assertEquals(true, x)/assertEquals(false, x) or assertEquals(Boolean.TRUE, x)/assertEquals(Boolean.FALSE, x).
/home/soazic/Documents/FAC/m2/VV/commons-collections/src/test/java/org/apache/commons/collections4/TransformerUtilsTest.java:293:	UseAssertTrueInsteadOfAssertEquals:	Use assertTrue(x)/assertFalse(x) instead of assertEquals(true, x)/assertEquals(false, x) or assertEquals(Boolean.TRUE, x)/assertEquals(Boolean.FALSE, x).
```
Exemple d'erreurs trouvé dans le code :
```java
 @Test
    public void testPredicateTransformer() {
        assertEquals(Boolean.TRUE, TransformerUtils.asTransformer(TruePredicate.truePredicate()).transform(null));
        assertEquals(Boolean.TRUE, TransformerUtils.asTransformer(TruePredicate.truePredicate()).transform(cObject));
        assertEquals(Boolean.TRUE, TransformerUtils.asTransformer(TruePredicate.truePredicate()).transform(cString));
        assertEquals(Boolean.TRUE, TransformerUtils.asTransformer(TruePredicate.truePredicate()).transform(cInteger));

        assertThrows(IllegalArgumentException.class, () -> TransformerUtils.asTransformer((Predicate<Object>) null));
    }
```

Pour solution ces problème il faut juste mettre un assertTrue. 

