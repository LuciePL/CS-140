package assignment09;

import java.util.function.BinaryOperator;

public class Group<T> extends Set<T> {
    private BinaryOperator<T> binop;

    public Group(BinaryOperator<T> binop) {
        this.binop = binop;
    }

    public T combine(T a, T b) throws NotInException {
        if(!this.contains(a) || !this.contains(b)) {
            throw new NotInException();
        }
        return this.binop.apply(a, b);
    }
    
}