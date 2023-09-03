package app.service;


import app.AdditionalClass;
import app.entity.Motorization;
import app.entity.User;
import app.repository.MotorizationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class MotorizationService {

    @Autowired
    public MotorizationRepo motorizationRepo;

    List<Motorization> motorizationList;

    AdditionalClass additionalClass;

    @Transactional
    public void saveMotorization(Motorization motorization, User user){

        motorizationRepo.saveMotorization(motorization,user);
    }

    @Transactional
    public List<Motorization> getMotorization_with_filter(AdditionalClass additionalClass){

        motorizationList=motorizationRepo.getMotorizations(additionalClass);

        return motorizationList;

    }
    @Transactional
    public void updateMotorization(Motorization motorization,Long id){

        motorizationRepo.updateMotorization(motorization,id);
    }
    @Transactional
    public Motorization getMotorization(Long id){

        Motorization motorization=motorizationRepo.getMotorization(id);

        return motorization;
    }
}
