package online.simplefoodsolutions.api.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtility
{
    private static SessionUtility instance = new SessionUtility();
    private SessionFactory sessionFactory;

    private SessionUtility()
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        sessionFactory = configuration.buildSessionFactory();
    }

    private static SessionUtility getInstance()
    {
        return instance;
    }

    public static Session getSession()
    {
        return getInstance().sessionFactory.openSession();
    }
}
