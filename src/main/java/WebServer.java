
import application.QueryProcessor;
import Web.Response;
import Web.Index;
import Web.Result;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class WebServer {

    public WebServer() throws Exception {
        Server server = new Server(8080);

        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(new ServletHolder(new Website()), "/*");
        handler.addServletWithMapping(new ServletHolder(new Api()), "/api/*");
        server.setHandler(handler);

        server.start();
    }

    static class Website extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String query = req.getParameter("q");
            if (query == null) {
                new Index().writeTo(resp);
            } else {
                new Result(query, new QueryProcessor().process(query)).writeTo(resp);
            }
        }
    }

    static class Api extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String query = req.getParameter("q");
            new Response(new QueryProcessor().process(query)).writeTo(resp);
        }
    }

    public static void main(String[] args) throws Exception {
        new WebServer();
    }
}
