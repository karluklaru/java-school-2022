package ru.croc.task4;

//[^/]
public class Task4 {

    public static void formatString(String str) {
        str = str.replaceAll("(/\\*)+((\\n)?.*?)*?(\\*/)", "");
        str = str.replaceAll("//.*", "");
        while (str.charAt(0) == '\n') {
            str = str.substring(1);
        }
        while (str.charAt(str.length() - 1) == '\n') {
            str = str.substring(0, str.length() - 2);
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        String source = """
                /*/* Comment
                                * My first ever /* program in Java!
                               /*/
                        class Hello { // class body starts here
                                
                            /*// main method */
                            public static void main(String[] args/* we put command line arguments here*/) {
                                // this line prints my first greeting to the screen
                                System.out.println("Hi!"); // :)
                            }
                        } // the end
                // to be continued...
                """;
        Task4.formatString(source);
    }
}
