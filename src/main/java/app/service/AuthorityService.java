package app.service;

import app.entity.Authority;
import app.repository.AuthorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class AuthorityService {

    @Autowired
    private AuthorityRepo authorityRepo;

    @Transactional
    public void saveAuthority(Authority authority){

        authorityRepo.saveAuthority(authority);
    }
}
