package app.repository;


import app.AdditionalClass;
import app.entity.Motorization;
import app.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MotorizationRepo {

    @Autowired
    SessionFactory sf;

    List<Motorization> motorizationList;

    public Motorization getMotorization(Long id){

        Session session=sf.getCurrentSession();

        Motorization motorization=session.get(Motorization.class,id);

        return motorization;
    }

    public void saveMotorization(Motorization motorization, User user){

        Session session=sf.getCurrentSession();

        Motorization motorization_for_table=new Motorization();

        motorization_for_table.setColor(motorization.getColor());

        motorization_for_table.setDescription(motorization.getDescription());

        motorization_for_table.setBrand(motorization.getBrand());

        motorization_for_table.setPrice(motorization.getPrice());

        motorization_for_table.setType(motorization.getType());

        motorization_for_table.setYear(motorization.getYear());

        motorization_for_table.setTitle(motorization.getTitle());

        motorization_for_table.setUser(user);

        session.save(motorization_for_table);
    }

    public List<Motorization> getMotorizations(AdditionalClass additionalClass){

        Session session=sf.getCurrentSession();

        motorizationList=new ArrayList<>();

        Query query;

        int price_from=additionalClass.getMotorizationFirst().getPrice();

        int price_to=additionalClass.getMotorizationSecond().getPrice();

        int year_from=additionalClass.getMotorizationFirst().getYear();

        int year_to=additionalClass.getMotorizationSecond().getYear();

        String color=additionalClass.getMotorizationFirst().getColor();

        String brand=additionalClass.getMotorizationFirst().getBrand();

        String type=additionalClass.getMotorizationFirst().getType();

        if(type.equals("wszystkie")){if(color.equals("wszystkie")){
             query=session.createQuery("select m from Motorization m where m.brand=:brand and m.price>:price_from and m.price<:price_to " +
                     "and m.year>:year_from and m.year<:year_to",Motorization.class).setParameter("brand",brand).
                     setParameter("price_from",price_from).setParameter("price_to",price_to).setParameter("year_from",year_from).
                     setParameter("year_to",year_to);
             motorizationList=query.getResultList();}
             else {query=session.createQuery("select m from Motorization m where m.brand=:brand and m.price>:price_od and m.price<:price" +
                 "and m.color=:color and m.year>:year_od and m.year<:year_do",Motorization.class).setParameter("brand",brand).
                setParameter("price_od",price_from).setParameter("price_do",price_to).setParameter("year_od",year_from).setParameter("year_do",year_to);
             motorizationList=query.getResultList();}
        }
        else { if(color.equals("wszystkie")) {query=session.createQuery("select m from Motorization m where m.type=:type and m.brand=:brand and m.price>:price_od and " +
                "m.price<:cena_do and type=:type and m.year>:year_od and m.year<:year_do",Motorization.class).setParameter("type",type).setParameter("brand",brand).
                setParameter("price_od",price_from).setParameter("price_do",price_to).setParameter("year_od",year_from).setParameter("year_do",year_to);
               motorizationList= query.getResultList();}

                else {
                    query = session.createQuery("select m from Motorization m where m.type=:type and m.brand=:brand and m.color=:color and m.price>:cena_od " +
                    "and m.price<:cena_do and m.year>:year_od and m.year<:year_do", Motorization.class).setParameter("type", type).setParameter("brand", brand).
                    setParameter("color", color).setParameter("cena_od", price_from).setParameter("cena_do", price_to).setParameter("year_do", year_to).setParameter("year_od", year_from);

                motorizationList= query.getResultList();
                }
        }
        return  motorizationList;


    }
    public void updateMotorization(Motorization motorization,Long id){

        Session session=sf.getCurrentSession();

        String queryString="update Motorization set title=:title, price=:price, color=:color, type=:type," +
                "  year=:year, description=:description where id=:id";

        Query query=session.createQuery(queryString);

        query.setParameter("title",motorization.getTitle());

        query.setParameter("price",motorization.getPrice());

        query.setParameter("color",motorization.getColor());

        query.setParameter("type",motorization.getType());

        query.setParameter("year",motorization.getYear());

        query.setParameter("description",motorization.getDescription());

        query.setParameter("id",id);

        query.executeUpdate();

    }
}
