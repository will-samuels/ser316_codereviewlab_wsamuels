package banking.primitive.core;


public abstract class Account implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public enum State {
        OPEN, CLOSED, OVERDRAWN
    };

    protected float balance = 0.0F;
    protected String name;
    private State state;

    protected Account(String _name) {
        name = _name;
        state = State.OPEN;
    }

    protected Account(String _name, float b) {
        this(_name); 
        balance = b;
    }

    /**
     * @return name of the Account
     */
    public final String getName() {
        return name;
    }

    /**
     * @return balance in the Account
     */
    public final float getBalance() {
        return balance;
    }

    /**
     * Adds money to an account. May not be done if the account is CLOSED
     * 
     * @param parameter
     *            amount is a deposit and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean deposit(float amount);

    /**
     * Takes money out of an account. If the balance falls below 0 then the
     * account is moved to an OVERDRAWN state
     * 
     * @param parameter
     *            amount is a withdrawal and must be > 0
     * @return true if the deposit was successful, false if not due to amount or
     *         invalid state
     */
    public abstract boolean withdraw(float amount);

    /**
     * declaration of getters and setters for states
     */
    public abstract String getType();

    /**
     * getter that returns state
     */
    protected final State getState() {
        return state;
    }
    /**
     * setter that sets state
     */
    protected final void setState(State s) {
        state = s;
    }

    public String toString() {
        return "Account " + name + " has $" + balance + "and is " + getState()
                + "\n";
    }
}
