package flash_sale.salee.user;


import flash_sale.salee.DTO.RegisterRequest;
import flash_sale.salee.DTO.UserResponse;
import flash_sale.salee.Exceptionhandler.usernotfound;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service

public class Userservice {

    private final Userrepository userrepository ;


    public Userservice(Userrepository userrepository) {
        this.userrepository = userrepository;


        }


    public List<UserResponse> getAllUsers() {


         List<Users> users = userrepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();
        for (Users user : users){

           UserResponse response = new UserResponse();

        response.setUsername(user.getUsername());
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setNumber(user.getNumber());

        userResponses.add(response);

    }

        return userResponses;

    }




    public UserResponse registeruser(RegisterRequest request) {

        if (userrepository.existsByemail(request.getEmail())) {
            throw new usernotfound("email already exist");
        }


        Users user = new Users();
        user.setCreatedat(LocalDateTime.now());
        user.setCustomerid(UUID.randomUUID().toString());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setNumber(request.getNumber());

        userrepository.save(user);

        UserResponse userResponse = new UserResponse();

        userResponse.setId(user.getId());
        userResponse.setEmail(user.getEmail());
        userResponse.setUsername(user.getUsername());







        return userResponse;


}

public UserResponse update(Long id ,RegisterRequest request){

        UserResponse response = new UserResponse();
        Users users = userrepository.findById(id)
                .orElseThrow( ()->new RuntimeException("user not found"));
                        users.setUsername(request.getUsername());
                users.setEmail(request.getEmail());
                users.setPassword(request.getPassword());
                users.setNumber(request.getNumber());
                userrepository.save(users);

                return response;
}




        public String delete(Long id){

            Users users = userrepository.findById(id)
                    .orElseThrow( ()->new usernotfound("user not found"));
            userrepository.deleteById(id);
            return "user deleteed succefully";


        }






    }


