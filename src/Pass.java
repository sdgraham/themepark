import java.time.LocalDate;
import java.util.HashSet;

public abstract class Pass
{
    public static int NEXT_PASS_NUMBER = 1;

    private int number;
    private int credits;
    private boolean active;
    private LocalDate dateActivated;
    private LocalDate dateClosed;
    private Visitor visitor;
    private HashSet<Transaction> transactions;

    public Pass(Visitor aVisitor)
    {
        this.visitor = aVisitor;
        this.credits = 0;
        this.active = false;
        this.dateActivated = null;
        this.dateClosed = null;
        this.transactions = new HashSet<>();

        this.number = Pass.NEXT_PASS_NUMBER;
        Pass.NEXT_PASS_NUMBER++;
    }

    public Visitor getVisitor()
    {
        return this.visitor;
    }

    public int getNumber()
    {
        return this.number;
    }

    public boolean isActive()
    {
        return this.active;
    }

    /**
     * Activates the pass and records the date activated
     */
    public void activate()
    {
        this.active = true;
        this.dateActivated = LocalDate.now();
    }

    /**
     * Deactivates the pass and records the date deactivated
     */
    public void deactivate()
    {
        this.active = false;
        this.dateClosed = LocalDate.now();
    }

    /**
     * Returns the date on which the pass was activated as a String
     * @return the date on which the pass was activated as a String
     */
    public String getDateActivated()
    {
        String date;

        if (this.dateActivated != null)
        {
            date = this.dateActivated.toString();
        }
        else
        {
            date = "The pass has not been activated.";
        }


        return date;
    }

    /**
     * Returns the date on which the pass was deactivated as a String
     * @return the date on which the pass was deactivated as a String
     */
    public String getDateDeactivated()
    {
        String date;

        if (this.dateActivated == null)
        {
            date = "The pass has not been activated.";
        }
        else if (this.dateActivated != null && this.dateClosed == null)
        {
            date = "The pass is still active.";
        }
        else
        {
            date = this.dateClosed.toString();
        }

        return date;
    }

    /**
     * Returns the number of credits currently on the pass
     * @return the number of credits currently on the pass
     */
    public int getCredits()
    {
        return this.credits;
    }

    public void addCredits(int numCredits)
    {
        this.credits += numCredits;
    }

    public void useCredits(int numCredits)
    {
        if (numCredits <= this.credits)
        {
            this.credits -= numCredits;
        }
    }

    public int numberOfTransactions()
    {
        return this.transactions.size();
    }

    public void addTransaction(Transaction t)
    {
        this.transactions.add(t);
    }

    public void displayDetails()
    {
        String status;
        String date;

        if (this.isActive())
        {
            status = " PASS ACTIVE";
            date = this.getDateActivated();
        }
        else
        {
            status = " PASS CLOSED";
            date = this.getDateDeactivated();
        }

        System.out.println(this.getVisitor().getNumber() + " credits: " + this.getCredits() + ", " + status + ", " + date);
    }

    public void showTransactions()
    {
        System.out.println("Type\tCredits\tDate/time\tID");

        for (Transaction t : this.transactions)
        {
            t.showDetails();
        }
    }

}
