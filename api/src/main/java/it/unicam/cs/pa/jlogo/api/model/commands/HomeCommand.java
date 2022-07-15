package it.unicam.cs.pa.jlogo.api.model.commands;

import it.unicam.cs.pa.jlogo.api.model.Angle;

/**
 * This interface has the responsibility to represent the "Home" command.
 *
 * @author Luca Bianchi
 */
public class HomeCommand implements Command {

    /*
     * This implementation of the equals() method just checks if the class is the same
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        return obj.getClass() == this.getClass();
    }
}
