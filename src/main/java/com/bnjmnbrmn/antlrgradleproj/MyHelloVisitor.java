package com.bnjmnbrmn.antlrgradleproj;

import com.bnjmnbrmn.antlrgradleproj.ast.FarewellMessage;
import com.bnjmnbrmn.antlrgradleproj.ast.HelloMessage;
import com.bnjmnbrmn.antlrgradleproj.ast.Message;

public class MyHelloVisitor extends HelloBaseVisitor<Message> {

    @Override
    public Message visitR(HelloParser.RContext ctx) {
        if (ctx.getChildCount() > 0) {
            // The 'r' rule delegates to its children (helloMessage or farewellMessage)
            // We visit the child and return the Message object it produces.
            return visit(ctx.getChild(0));
        }
        // If parsing failed or no valid message, return null or throw an error
        System.err.println("Visitor Error: No valid message found for 'r' rule in parse tree.");
        return null;
    }

    @Override
    public Message visitHelloMessage(HelloParser.HelloMessageContext ctx) {
        // Get the text of the ID token
        String idText = ctx.ID().getText();

        // Create and return an instance of our AST HelloMessage
        System.out.println("MyHelloVisitor: Building HelloMessage AST node for ID: " + idText);
        return new HelloMessage(idText);
    }

    @Override
    public Message visitFarewellMessage(HelloParser.FarewellMessageContext ctx) {
        // Get the text of the ID token
        String idText = ctx.ID().getText();

        // Create and return an instance of our AST FarewellMessage
        System.out.println("MyHelloVisitor: Building FarewellMessage AST node for ID: " + idText);
        return new FarewellMessage(idText);
    }

    // You might want to override visitErrorNode to handle errors in the parse tree itself
    @Override
    public Message visitErrorNode(org.antlr.v4.runtime.tree.ErrorNode node) {
        System.err.println("MyHelloVisitor: Encountered an error node in the parse tree: " + node.getText());
        return null; // Or return a specific error AST node
    }
}
