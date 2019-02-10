package sut.se.G09.Backend.Controller;

import sut.se.G09.Backend.Controller.LoginForm;
import sut.se.G09.Backend.Entity.EMData;
import sut.se.G09.Backend.Entity.MLData;
import sut.se.G09.Backend.Repository.EMDataRepository;
import sut.se.G09.Backend.Repository.MLDataRepository;
import sut.se.G09.Backend.Repository.MemberDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmLoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    EMDataRepository EMDataRepository;

    @PostMapping("/loginEM")
    public ResponseEntity<Object> loginAuth(@RequestBody LoginForm loginForm) throws InvalidKeySpecException, NoSuchAlgorithmException {
        EMData member = EMDataRepository.findByUserName(loginForm.getUsername());
        String password = member.getPassword();
        if(member.getPassword().equals(loginForm.getPassword()))
        {
            logger.info("login => "+member.getUserName());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);}

        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}