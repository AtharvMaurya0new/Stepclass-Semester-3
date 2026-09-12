class AccessChecker {

    static final String SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE =
        "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE";

    static final String SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE =
        "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE";

    static String classifyAccess(String fieldModifier,
                                  String accessorContext) {

        if (fieldModifier.equals("protected")) {

            if (accessorContext.equals(
                    SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE)) {

                return "ALLOWED";
            }

            if (accessorContext.equals(
                    SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE)) {

                return "DENIED";
            }
        }

        return "DENIED";
    }

    static String describeContext(String context) {

        String[] words = context.split("_");

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            if (i > 0) {
                result.append(" ");
            }

            result.append(
                words[i].substring(0, 1).toUpperCase()
                + words[i].substring(1).toLowerCase()
            );
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );

        System.out.println(
            describeContext(
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );
    }
}