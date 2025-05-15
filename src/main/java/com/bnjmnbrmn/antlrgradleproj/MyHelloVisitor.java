package com.bnjmnbrmn.antlrgradleproj;

public class MyHelloVisitor extends HelloBaseVisitor<String> {

    @Override
    public String visitR(HelloParser.RContext ctx) {
        // It's important that visit() is called on the child here
        // If ctx has no children (e.g., if parsing failed completely),
        // this might throw an error or return null.
        if (ctx.getChildCount() > 0) {
            return visit(ctx.getChild(0));
        }
        return "ERROR: No valid message found in 'r' rule."; // Fallback
    }

    @Override
    public String visitHelloMessage(HelloParser.HelloMessageContext ctx) {
        String helloText = ctx.HELLO().getText();
        String idText = ctx.ID().getText();

        System.out.println("MyHelloVisitor: Detected a HELLO message!"); // <--- This line should print
        return "MESSAGE: " + helloText + " " + idText;
    }

    @Override
    public String visitFarewellMessage(HelloParser.FarewellMessageContext ctx) {
        String goodbyeText = ctx.GOODBYE().getText();
        String idText = ctx.ID().getText();

        System.out.println("MyHelloVisitor: Detected a GOODBYE message!"); // <--- This line should print
        return "FAREWELL: " + goodbyeText + " " + idText + "!";
    }
}
