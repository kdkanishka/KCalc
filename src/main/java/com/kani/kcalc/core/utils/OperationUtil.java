package com.kani.kcalc.core.utils;

import com.kani.kcalc.core.operations.Division;
import com.kani.kcalc.core.operations.Multiplication;
import com.kani.kcalc.core.operations.Operation;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OperationUtil {

    private OperationUtil(){
    }

    public static Queue<Integer> getDivisionOrMultiplicationIndexes(List<Operation> operations){
        Queue<Integer> indexes = new LinkedList<>();

        int idx = 0;
        for(Operation operation : operations){
            if(operation instanceof Division || operation instanceof Multiplication){
                indexes.add(idx);
            }
            idx++;
        }
        return indexes;
    }
}
