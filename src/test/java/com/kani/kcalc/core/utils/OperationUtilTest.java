package com.kani.kcalc.core.utils;

import com.kani.kcalc.core.operations.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class OperationUtilTest {

    @Test
    void getDivisionOrMultiplicationIndexes() {
        List<Operation> operationList = Arrays.asList(
                new Subtraction(),
                new Multiplication(),
                new Division(),
                new Addition(),
                new Addition(),
                new Division(),
                new Multiplication()
        );
        Queue<Integer> dormOpIdx = OperationUtil.getDivisionOrMultiplicationIndexes(operationList);

        assertEquals(4, dormOpIdx.size());

        assertEquals(1, dormOpIdx.poll().intValue());
        assertEquals(2, dormOpIdx.poll().intValue());
        assertEquals(5, dormOpIdx.poll().intValue());
        assertEquals(6, dormOpIdx.poll().intValue());
    }
}