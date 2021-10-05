package com.kani.kcalc.core.utils;

import com.kani.kcalc.core.operations.Division;
import com.kani.kcalc.core.operations.Multiplication;
import com.kani.kcalc.core.operations.Operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Contains supporting methods to deal with operations
 */
public class OperationUtil {

    private OperationUtil() {
    }

    /**
     * Identifies the indexes of multiplication and division indexes in a given list of operations
     *
     * @param operations
     * @return a queue of indexes with division or multiplication operations, in the given list of operations
     */
    public static Queue<Integer> getDivisionOrMultiplicationIndexes(List<Operation> operations) {
        Queue<Integer> indexes = new LinkedList<>();

        int idx = 0;
        for (Operation operation : operations) {
            if (operation instanceof Division || operation instanceof Multiplication) {
                indexes.add(idx);
            }
            idx++;
        }
        return indexes;
    }
}
