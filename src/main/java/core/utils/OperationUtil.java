package core.utils;

import core.operations.Division;
import core.operations.Multiplication;
import core.operations.Operation;

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
