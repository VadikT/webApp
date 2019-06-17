package Web;

import java.io.PrintWriter;

public class Index extends Page {

    @Override
    protected void writeContentTo(PrintWriter writer) {
        writer.println(
                "<h1>Welcome!</h1>" +
                        "<p>Enter your query in the box below: " +
                        "<form><input type=\"text\" name=\"q\" />" +
                        "<input type=\"submit\">" +
                        "</form>" +
                        "</p>");
    }

}