package com.bnjmnbrmn.antlrgradleproj;

import com.bnjmnbrmn.antlrgradleproj.ast.Message;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

import com.bnjmnbrmn.antlrgradleproj.HelloLexer;
import com.bnjmnbrmn.antlrgradleproj.HelloParser;
import org.antlr.v4.runtime.tree.ParseTreeWalker;


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

        parser.removeErrorListeners();
        parser.addErrorListener(new ConsoleErrorListener());

        ParseTree tree = parser.r(); // Invoke the start rule 'r'

        System.out.println("Raw Parse Tree: " + tree.toStringTree(parser));

        // --- Using the Visitor to build AST ---
        System.out.println("\n--- Visitor (AST) Output ---");
        MyHelloVisitor visitor = new MyHelloVisitor();
        // The visitor now returns a 'Message' object (our AST node)
        Message ast = visitor.visit(tree); // <--- Changed type to Message

        // Check if an AST was successfully built before printing
        if (ast != null) {
            System.out.println("Generated AST: " + ast.toString()); // <--- Print the AST object
        } else {
            System.out.println("Generated AST: null (Parsing failed or no valid message)");
        }

        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.println("Parsing finished with errors.");
        } else {
            System.out.println("Parsing finished successfully!");
        }
    }
}
