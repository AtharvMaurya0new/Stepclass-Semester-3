class PatientRecord {

    private String patientId;

    String wardCode;              // default

    protected double vitalsScore;

    public String facilityName;


    public PatientRecord(
        String patientId,
        String wardCode,
        double vitalsScore,
        String facilityName
    ) {

        if (patientId == null ||
            patientId.trim().isEmpty() ||
            patientId.trim().length() < 4) {

            throw new IllegalArgumentException(
                "Invalid patient ID"
            );
        }

        this.patientId = patientId;
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }


    public static String classifyAccess(
        String fieldModifier,
        String accessorContext
    ) {

        // --------------------
        // PRIVATE
        // --------------------
        if (fieldModifier.equals("private")) {

            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }

            return "DENIED";
        }


        // --------------------
        // DEFAULT
        // --------------------
        if (fieldModifier.equals("default")) {

            if (accessorContext.equals("SAME_CLASS") ||
                accessorContext.equals("SAME_PACKAGE")) {

                return "ALLOWED";
            }

            return "DENIED";
        }


        // --------------------
        // PROTECTED
        // --------------------
        if (fieldModifier.equals("protected")) {

            // Same class
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }

            // Same package
            if (accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }

            // Subclass in different package
            // accessing inherited member through its own object
            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

                return "ALLOWED";
            }

            // Parent-type reference in another package
            if (accessorContext.equals(
                    "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

                return "DENIED";
            }

            // Ordinary different-package class
            return "DENIED";
        }


        // --------------------
        // PUBLIC
        // --------------------
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }


        return "DENIED";
    }


    // Convert underscore code to title case
    public static String describeContext(
        String accessorContext
    ) {

        String[] words =
            accessorContext.toLowerCase().split("_");

        String result = "";

        for (String word : words) {

            result +=
                Character.toUpperCase(word.charAt(0))
                + word.substring(1)
                + " ";
        }

        return result.trim();
    }
}


public class Main2 {

    public static void main(String[] args) {

        System.out.println(
            PatientRecord.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );


        System.out.println(
            PatientRecord.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );


        System.out.println(
            PatientRecord.describeContext(
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );
    }
}