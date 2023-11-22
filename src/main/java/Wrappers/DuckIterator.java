package Wrappers;

import Ducks.IQuackable;

import java.util.Iterator;
import java.util.List;

public class DuckIterator implements Iterator<IQuackable> {
    private List<IQuackable> ducks;
    private int position = 0;

    public DuckIterator(List<IQuackable> ducks) {
        this.ducks = ducks;
    }

    @Override
    public boolean hasNext() {
        return position < ducks.size();
    }

    @Override
    public IQuackable next() {
        if (hasNext()) {
            IQuackable duck = ducks.get(position);
            position++;
            return duck;
        } else {
            return null;
        }
    }
}





