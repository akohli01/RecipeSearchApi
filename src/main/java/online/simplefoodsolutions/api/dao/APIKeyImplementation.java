package online.simplefoodsolutions.api.dao;

import online.simplefoodsolutions.api.utility.SHA1Hasher;
import online.simplefoodsolutions.api.utility.SessionUtility;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class APIKeyImplementation implements APIKeyDAO
{
    @Override
    public boolean isAPIKeyCorrect(String apiKey)
    {

        Session session = SessionUtility.getSession();
        Query query = session.createQuery("select count(*) from APIKey where hashedAPIKey like ?1");
        query.setParameter(1, SHA1Hasher.sha1Hasher(apiKey));

        int result = ((Number) query.uniqueResult()).intValue();

        if (result == 1) return true;

        return false;
    }


}
