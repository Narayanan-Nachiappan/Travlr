package com.y.flickr;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
public class JettyLauncher {
	public static void main(String[] args) throws Exception
    {
        Server server = new Server(8000);
 
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        
        context.setContextPath("/travlr");
        ServletHolder holder = new ServletHolder(new FlickrServlet());
        
        holder.setInitParameter("org.apache.velocity.properties", "velocity.properties");
        context.addServlet(holder,"/*");

       // context.addServlet(new ServletHolder(new FlickrServlet()),"/ajax/*");
        server.setHandler(context);

        server.start();
        server.join();
    }

}
