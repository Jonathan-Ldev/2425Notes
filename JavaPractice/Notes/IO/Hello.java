//The class name MUST match the name of your file.

// public -> Anyone (in this file's scope) can interact with it
// class -> type of file -> Group of Objects -> What will be compiled
// Hello -> Filename and again, spelled the exact same way as the file...






public class Hello {
    //comment out one line of code
    /*
     * public -> Anyone (in this file's scoped) can interact with it
     * static -> doesn't move - unchanging... kind of... or doesn't need an object
     * void -> empty or null -> does not return anything
     * main(String[] args) -> main or starting f() tjat needs an array of strings, we call it args
     */
    // print('Hello World')
    public static void main(String[] args){
        /*
         * System -> System module to handle objects and f() that deals with the sys
         * out -> subclass that deals with output of information
         * println() -> print with a new line at the end of the data
         */
        System.out.println("Hello World");

        //print("Hello World",end="\n")
        System.out.print("Another print statement+\n")
        /*
         * Escape Characters basically a special character
         * \n -> new line
         * \t -> tab
         * \s -> space
         * \\ -> \
         * \" -> "
         */


        System.out.print("Hello Again");
        System.out.print("Hello Again");

        //               (regex,data)
        System.out.printf("%2.2f%n",12345.6789);    //

        ui.close();
    }  
}
