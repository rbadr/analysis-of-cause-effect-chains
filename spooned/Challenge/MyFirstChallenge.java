

package Challenge;


public class MyFirstChallenge<I> implements Challenge.Challenge<I> {
    public java.lang.Class<? extends I> getInputFormat() {
        return ((java.lang.Class<? extends I>) (java.lang.Integer.class));
    }

    public java.util.List getInputs() {
        return java.util.Arrays.asList(new java.lang.String[]{ "1" , "test" });
    }

    public java.lang.String getJavaProgram() {
        return "public Object doIt(String input){ return Integer.parseInt(input)}";
    }

    public void challenge(I input) {
        try {
            java.lang.System.out.println(("Do it " + input));
            doIt(input);
        } catch (java.lang.Exception e) {
            java.lang.System.out.println("exception");
        }
    }

    public java.lang.Object doIt(I input) {
        java.lang.String inputToParse = ((java.lang.String) (input));
        java.lang.String test = "inutile";
        return java.lang.Integer.parseInt(inputToParse);
    }
}

