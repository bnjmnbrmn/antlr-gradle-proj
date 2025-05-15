package com.bnjmnbrmn.antlrgradleproj;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.bnjmnbrmn.antlrgradleproj.HelloLexer;
import com.bnjmnbrmn.antlrgradleproj.HelloParser;


public class AntlrApp {
    public static void main(String[] args) throws Exception {
        testParsing("hello gradle");
        System.out.println("\n-----------------------------------\n");
        testParsing("goodbye world");
        System.out.println("\n-----------------------------------\n");
        testParsing("invalid input");
    }

    private static void testParsing(String input) {
        System.out.println("Input: \"" + input + "\"");

        CharStream charStream = CharStreams.fromString(input);
        HelloLexer lexer = new HelloLexer(charStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);

        ParseTree tree = parser.r(); // Invoke the start rule 'r'

        System.out.println("Raw Parse Tree: " + tree.toStringTree(parser));

        // <--- Crucial lines for invoking the visitor ---
        MyHelloVisitor visitor = new MyHelloVisitor();
        String result = visitor.visit(tree); // This line invokes the visitor traversal!
        System.out.println("Visitor Result: '" + result + "'");
        // ---------------------------------------------

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Parsing finished with errors.");
        } else {
            System.out.println("Parsing finished successfully!");
        }
    }
}
