class PatientRecord {

    // Different access modifiers
    private String patientId;
    String wardCode;                 // default
    protected double vitalsScore;
    public String facilityName;

    // Parameterized constructor
    public PatientRecord(
        String patientId,
        String wardCode,
        double vitalsScore,
        String facilityName
    ) {

        // Validation
        if (patientId == null ||
            patientId.trim().isEmpty() ||
            patientId.trim().length() < 4) {

            throw new IllegalArgumentException("Invalid patient ID");
        }

        this.patientId = patientId;
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }


    // Check access
    public static String classifyAccess(
        String fieldModifier,
        String accessorContext
    ) {

        // private
        if (fieldModifier.equals("private")) {

            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }

            return "DENIED";
        }


        // default
        if (fieldModifier.equals("default")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {

                return "ALLOWED";
            }

            return "DENIED";
        }


        // protected
        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {

                return "ALLOWED";
            }

            return "DENIED";
        }


        // public
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }


        return "DENIED";
    }


    // Process multiple attempts
    public static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] attempt : attempts) {

            String fieldModifier = attempt[0];
            String accessorContext = attempt[1];

            String result =
                classifyAccess(fieldModifier, accessorContext);

            if (result.equals("ALLOWED")) {
                allowed++;
            } else {
                denied++;
            }
        }

        return "Allowed: " + allowed +
               " | Denied: " + denied;
    }
}


public class Main {

    public static void main(String[] args) {

        // Example 1
        System.out.println(
            PatientRecord.classifyAccess(
                "private",
                "SAME_CLASS"
            )
        );


        // Example 2
        System.out.println(
            PatientRecord.classifyAccess(
                "default",
                "DIFFERENT_PACKAGE"
            )
        );


        // Example 3
        String[][] attempts = {

            {"protected", "SAME_PACKAGE"},
            {"protected", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            PatientRecord.summarizeBatch(attempts)
        );


        // Constructor validation
        try {

            PatientRecord p =
                new PatientRecord(
                    "ST1",
                    "W1",
                    98.5,
                    "Hospital"
                );

        } catch (IllegalArgumentException e) {

            System.out.println(
                e.getMessage()
            );
        }
    }
}