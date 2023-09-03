package app.repository;

import app.entity.Motorization;
import app.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    private SessionFactory sf;



    public void saveUser(User user){

        Session session= sf.getCurrentSession();

        User user_for_table=new User();

        user_for_table.setUsername(user.getUsername());

        user_for_table.setE_mail(user.getE_mail());

        user_for_table.setPassword(user.getPassword());

        user_for_table.setTelephone(user.getTelephone());

        session.save(user_for_table);

    }

    public User getUser(String username){

        Session session=sf.getCurrentSession();

        User user=session.get(User.class,username);

        if (user!=null) return user; else return null;

    }
    public List<Motorization> getUserAccount(User user){

        Session session=sf.getCurrentSession();

        Query query=session.createQuery("select m from Motorization m where m.user=:id",Motorization.class).
                setParameter("id",user);

        List<Motorization> motorizationList= query.getResultList();

        return motorizationList;
    }
}
