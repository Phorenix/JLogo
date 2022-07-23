package it.unicam.cs.pa.jlogo.api.model.commands;

/**
 * This class represents a "Clear Screen" Command
 *
 * @author Luca Bianchi
 */
public class ClearScreenCommand implements Command {

    /*
     * This implementation of the equals() method just checks if the class is the same (the default implementation just
     * checks if the object in memory is the same)
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        return obj != null && obj.getClass() == this.getClass();
    }
}
