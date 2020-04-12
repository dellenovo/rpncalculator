package com.lifei.rpncalculator.util;

import com.google.common.base.Splitter;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberUtilsTest {
    @Test
    public void test(){
        assertThat(NumberUtils.isNumber("1.2")).isTrue();
        assertThat(NumberUtils.isNumber("100")).isTrue();
        assertThat(NumberUtils.isNumber("0.2000")).isTrue();
        assertThat(NumberUtils.isNumber("0.0001")).isTrue();
        assertThat(NumberUtils.isNumber("-8")).isTrue();

//        assertThat(NumberUtils.isNumber("01")).isFalse();
//        assertThat(NumberUtils.isNumber("1.")).isFalse();
        assertThat(NumberUtils.isNumber("01")).isTrue();
        assertThat(NumberUtils.isNumber("1.")).isTrue();
        assertThat(NumberUtils.isNumber("2 3")).isFalse();
    }

    @Test
    public void testSplitString() {
        String line = "   1 2  ";
        System.out.println(Arrays.toString(line.split("\\s+")));

        List<String> line2 = Splitter.on(Pattern.compile("\\s+")).omitEmptyStrings().splitToList(line);

        System.out.println(line2.size());
        System.out.println(line2);
    }
}
