package com.bnjmnbrmn.antlrgradleproj;

public class MyHelloListener extends HelloBaseListener {
    // This method is called when the parser enters the 'r' rule.
    @Override
    public void enterR(HelloParser.RContext ctx) {
        System.out.println("MyHelloListener: Entering 'r' rule.");
    }

    // This method is called when the parser exits the 'r' rule.
    @Override
    public void exitR(HelloParser.RContext ctx) {
        System.out.println("MyHelloListener: Exiting 'r' rule.");
    }

    // This method is called when the parser enters the 'helloMessage' rule.
    @Override
    public void enterHelloMessage(HelloParser.HelloMessageContext ctx) {
        // We can still access the context to get token text, just like in a visitor
        System.out.println("MyHelloListener: Entering 'helloMessage' rule. Found: '" + ctx.HELLO().getText() + "' and '" + ctx.ID().getText() + "'");
    }

    // This method is called when the parser exits the 'helloMessage' rule.
    @Override
    public void exitHelloMessage(HelloParser.HelloMessageContext ctx) {
        System.out.println("MyHelloListener: Exiting 'helloMessage' rule.");
    }

    // This method is called when the parser enters the 'farewellMessage' rule.
    @Override
    public void enterFarewellMessage(HelloParser.FarewellMessageContext ctx) {
        System.out.println("MyHelloListener: Entering 'farewellMessage' rule. Found: '" + ctx.GOODBYE().getText() + "' and '" + ctx.ID().getText() + "'");
    }

    // This method is called when the parser exits the 'farewellMessage' rule.
    @Override
    public void exitFarewellMessage(HelloParser.FarewellMessageContext ctx) {
        System.out.println("MyHelloListener: Exiting 'farewellMessage' rule.");
    }

    // We can also override methods for entering/exiting individual tokens (TerminalNodes)
    // @Override
    // public void visitTerminal(org.antlr.v4.runtime.tree.TerminalNode node) {
    //     System.out.println("MyHelloListener: Visiting terminal: " + node.getText());
    // }
}
