import java.util.HashSet;
import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {
        HashSet<Visitor> visitors = new HashSet<>();

        LocalDate ld = LocalDate.now();
        Visitor v = new Visitor("bob", "9 Bob Road", "bt23 5ss", ld);

        visitors.add(v);

        Visitor v2 = v;
        visitors.add(v2);

        for (Visitor eachVisitor : visitors)
        {
            System.out.println(eachVisitor);
            eachVisitor.displayDetails();
        }


    }
}