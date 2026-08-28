class BookIssue {
    private String title;
    private String borrowerName;
    private int daysOverdue;

    BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    double fineAmount() {
        if (daysOverdue > 0)
            return daysOverdue * 5;
        return 0;
    }

    boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    String getTitle() {
        return title;
    }

    static double totalFineCollected(BookIssue[] issues) {
        double total = 0;

        for (BookIssue issue : issues) {
            total += issue.fineAmount();
        }

        return total;
    }
}

public class messfine {
    public static void main(String[] args) {

        BookIssue[] issues = {
            new BookIssue("Clean Code", "Alice", 18),
            new BookIssue("Effective Java", "Bob", 5),
            new BookIssue("Refactoring", "Charlie", 0),
            new BookIssue("DSA Handbook", "David", 21),
            new BookIssue("Design Patterns", "Eve", 9)
        };

        for (BookIssue issue : issues) {
            String status;

            if (issue.isSeverelyOverdue())
                status = "Severely overdue";
            else
                status = "OK";

            System.out.println(issue.getTitle() + " - "
                    + issue.fineAmount() + " days - " + status);
        }

        System.out.println("Total fine collected: Rs "
                + BookIssue.totalFineCollected(issues));
    }
}