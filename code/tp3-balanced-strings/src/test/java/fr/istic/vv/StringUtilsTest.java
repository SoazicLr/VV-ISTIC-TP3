package fr.istic.vv;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "()", "[]", "{}","[()]", "[[]]", "{[]}","{[][]}({})",
    })
    void testTrue(String str){
        assertTrue(StringUtils.isBalanced(str));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "(", ")", "[", "}","][", ")(", "}{","([)]"
    })
    void testFalse(String str){
        assertFalse(StringUtils.isBalanced(str));
    }
}