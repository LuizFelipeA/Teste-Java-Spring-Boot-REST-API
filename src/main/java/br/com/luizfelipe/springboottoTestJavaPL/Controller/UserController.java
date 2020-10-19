package br.com.luizfelipe.springboottoTestJavaPL.Controller;

import br.com.luizfelipe.springboottoTestJavaPL.Controller.dto.UserRq;
import br.com.luizfelipe.springboottoTestJavaPL.Controller.dto.UserRs;
import br.com.luizfelipe.springboottoTestJavaPL.Model.User;
import br.com.luizfelipe.springboottoTestJavaPL.Repository.UserCustomRepository;
import br.com.luizfelipe.springboottoTestJavaPL.Repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;
    private final UserCustomRepository userCustomRepository;

    public UserController(UserRepository userRepository, UserCustomRepository userCustomRepository){
        this.userRepository = userRepository;
        this.userCustomRepository = userCustomRepository;
    }

    @ApiOperation(value = "Register user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return a list of users"),
            @ApiResponse(code = 403, message = "You have not permission to access this route"),
            @ApiResponse(code = 500, message = "A exception was generated"),
    })
    @PostMapping("/")
    public ResponseEntity<User> saveUser(@RequestBody UserRq user){
        try{
            var u = new User();
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            u.setBirthdate(user.getBirthdate());

            userRepository.save(u);

            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "Modify user")
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserRq user) {
        var u = userRepository.findById(id);

        if(u.isPresent()) {
            var userSave = u.get();
            userSave.setName(user.getName());
            userSave.setBirthdate(user.getBirthdate());

            return new ResponseEntity<>(userRepository.save(userSave), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiOperation(value = "Query custom users")
    @GetMapping("/")
    public List<UserRs> getAllUsers(
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "bithdate", required = false) Date birthdate
    ) throws Exception {

        try {
            return userCustomRepository.find(email, name, birthdate)
                    .stream()
                    .map(UserRs::converter)
                    .collect(Collectors.toList());
        } catch(Exception ex) {
            throw new Exception("Internal Server error: " + ex);
        }
    }

}
