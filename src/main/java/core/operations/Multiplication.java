package core.operations;

public class Multiplication implements Operation {
    @Override
    public double exec(double n1, double n2) {
        return n1 * n2;
    }
}
