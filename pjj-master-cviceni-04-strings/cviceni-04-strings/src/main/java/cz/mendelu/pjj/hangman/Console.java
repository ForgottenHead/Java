package cz.mendelu.pjj.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Methods to access the character-based console device, if any, associated
 * with the current Java virtual machine.
 */
public final class Console {

    private static Console console;

    /**
     * Returns the unique Console object associated with the current Java virtual machine.
     *
     * @return  Singltone of console.
     */
    public static Console console() {
        if (console == null) {
            synchronized (Console.class) {
                if (console == null) {
                    console = new Console();
                }
            }
        }
        return console;
    }

    private final PrintStream out;
    private final BufferedReader in;


    public Console() {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = System.out;
    }

    /**
     * A convenience method to write a formatted string to this console's
     * output stream using the specified format string and arguments.
     *
     * <p> An invocation of this method of the form <tt>con.printf(format,
     * args)</tt> behaves in exactly the same way as the invocation of
     * <pre>con.format(format, args)</pre>.
     *
     * @param  format
     *         A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>.
     *
     * @param  args
     *         Arguments referenced by the format specifiers in the format
     *         string.  If there are more arguments than format specifiers, the
     *         extra arguments are ignored.  The number of arguments is
     *         variable and may be zero.  The maximum number of arguments is
     *         limited by the maximum dimension of a Java array as defined by
     *         <cite>The Java&trade; Virtual Machine Specification</cite>.
     *         The behaviour on a
     *         <tt>null</tt> argument depends on the.
     *
     * @throws  IllegalFormatException
     *          If a format string contains an illegal syntax, a format
     *          specifier that is incompatible with the given arguments,
     *          insufficient arguments given the format string, or other
     *          illegal conditions.  For specification of all possible
     *          formatting errors.
     *
     * @return  This console
     */
    public Console printf(String format, Object... args) {
        out.printf(format, args);
        return this;
    }

    /**
     * Reads a single line of text from the
     * console.
     *
     * @throws  IllegalFormatException
     *          If a format string contains an illegal syntax, a format
     *          specifier that is incompatible with the given arguments,
     *          insufficient arguments given the format string, or other
     *          illegal conditions.  For specification of all possible
     *          formatting errors, see the <a
     *          href="../util/Formatter.html#detail">Details</a> section
     *          of the formatter class specification.
     *
     * @throws UnsupportedOperationException
     *         If an I/O error occurs.
     *
     * @return  A string containing the line read from the console, not
     *          including any line-termination characters, or <tt>null</tt>
     *          if an end of stream has been reached.
     */
    public String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /**
     * Provides a formatted prompt, then reads a single line of text from the
     * console.
     *
     * @param  fmt
     *         A format string as described in <a
     *         href="../util/Formatter.html#syntax">Format string syntax</a>.
     *
     * @param  args
     *         Arguments referenced by the format specifiers in the format
     *         string.  If there are more arguments than format specifiers, the
     *         extra arguments are ignored.  The maximum number of arguments is
     *         limited by the maximum dimension of a Java array as defined by
     *         <cite>The Java&trade; Virtual Machine Specification</cite>.
     *
     * @throws  IllegalFormatException
     *          If a format string contains an illegal syntax, a format
     *          specifier that is incompatible with the given arguments,
     *          insufficient arguments given the format string, or other
     *          illegal conditions.  For specification of all possible
     *          formatting errors, see the <a
     *          href="../util/Formatter.html#detail">Details</a> section
     *          of the formatter class specification.
     *
     * @throws UnsupportedOperationException
     *         If an I/O error occurs.
     *
     * @return  A string containing the line read from the console, not
     *          including any line-termination characters, or <tt>null</tt>
     *          if an end of stream has been reached.
     */
    public String readLine(String fmt, Object... args) {
        return printf(fmt, args).readLine();
    }
}

