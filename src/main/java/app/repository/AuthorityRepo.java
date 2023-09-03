package app.repository;


import app.entity.Authority;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityRepo {

    @Autowired
    private SessionFactory sf;

    public void saveAuthority(Authority authority){

        Session session=sf.getCurrentSession();

        session.save(authority);

    }
}
