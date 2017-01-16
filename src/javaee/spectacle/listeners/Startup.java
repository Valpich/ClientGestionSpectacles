package javaee.spectacle.listeners;

import java.util.HashSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import javaee.spectacle.beans.Client;

/**
 * Application Lifecycle Listener implementation class Startup
 *
 */
@WebListener
public class Startup implements ServletContextListener {
  private ServletContext context = null;

  /**
   * @see ServletContextListener#contextDestroyed(ServletContextEvent)
   */
  @Override
  public void contextDestroyed(ServletContextEvent event) {}

  /**
   * @see ServletContextListener#contextInitialized(ServletContextEvent)
   */
  @Override
  public void contextInitialized(ServletContextEvent event) {
    // Indique le bon lancement de l'application
    System.out.println("Application lancée!");
    this.context = event.getServletContext();
    // Met dans la portée application la liste et le nombre de clients
    this.context.setAttribute("logins", new HashSet<Client>());
    this.context.setAttribute("nombreClientsConnectés", new Integer(0));
  }

}
