import java.time.LocalDate;

public class Visitor
{
    private static int NEXT_VISITOR_NUMBER = 1;

    private int number;
    private String name;
    private String address;
    private String postCode;
    private LocalDate dateOfBirth;

    public Visitor(String aName, String anAddress, String aPostCode, LocalDate aDate)
    {
        this.name = aName;
        this.address = anAddress;
        this.postCode = aPostCode;
        this.dateOfBirth = aDate;

        this.number = Visitor.NEXT_VISITOR_NUMBER;
        Visitor.NEXT_VISITOR_NUMBER++;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public LocalDate getDateOfBirth()
    {
        return dateOfBirth;
    }

    public int getNumber()
    {
        return this.number;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public void displayDetails()
    {
        System.out.println(this.getNumber() + "\t" +  this.getName() + "\t" + this.getAddress() + "\t" + this.getPostCode()
        + "\t" + this.getDateOfBirth().toString());
    }

    @Override
    public boolean equals(Object obj)
    {
        boolean equal = false; // local variable to use to return whether the objects are considered equal

        if (obj == this) // if memory references of the two object match, we consider them equal by default
        {
            equal = true;
        }
        else // memory references do not match
        {
            if (obj instanceof Visitor) // if parameter object is an instance of the Visitor class (or one of its subclasses)
            {
                Visitor otherVisitor = (Visitor) obj; // cast the parameter object to an object of the Visitor class

                if (otherVisitor.getNumber() == this.getNumber()) // compare the IDs
                {
                    equal = true;  // return true if the IDs match
                }
            }
        }

        return equal;
    }




}
