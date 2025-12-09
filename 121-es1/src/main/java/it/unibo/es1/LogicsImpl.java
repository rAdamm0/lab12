package it.unibo.es1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    // private static final String ERROR_MESSAGE = "Unimplemented method";
    private List<Integer> values;
    private List<Boolean> enabled;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.values = new ArrayList<>(Collections.nCopies(size, 0));
this.enabled = new ArrayList<>(Collections.nCopies(size, true));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.values.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return Collections.unmodifiableList(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return Collections.unmodifiableList(enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        int nextValue = values.get(elem);
        if (!enabled.get(elem)) {
        } else {
            nextValue++;
            if (nextValue == values.size()) {
                enabled.set(elem, false);
            }
            values.set(elem, nextValue);
        }
        return nextValue;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return "<<" + values.stream().map(a -> a.toString()).collect(Collectors.joining("|")) + ">>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return values.stream().distinct().count()==1;
    }
}
