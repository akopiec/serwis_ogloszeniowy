package app.service;


import app.entity.Motorization;
import app.entity.User;
import app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
 public class UserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    public void saveUser(User user){

        userRepo.saveUser(user);

    }
    @Transactional
    public User getUser(String username){

        User user=userRepo.getUser(username);

        return user;
    }
    @Transactional
    public List<Motorization> getUserAccount(User username){

        List<Motorization> motorizationList=userRepo.getUserAccount(username);

        return motorizationList;
    }
}
