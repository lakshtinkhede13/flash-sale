package flash_sale.salee.user;

import flash_sale.salee.DTO.RegisterRequest;
import flash_sale.salee.DTO.UserResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final Userservice userservice;

    public  UserController (Userservice userservice){
        this.userservice=userservice;

        } @PostMapping("/register")
        public UserResponse registeruser(@Valid @RequestBody RegisterRequest request){
        return userservice.registeruser(request);
    }

        @GetMapping("get")
    public List<UserResponse>userResponses(){
        return userservice.getAllUsers();
        }
        @PutMapping("/{id}")

    public UserResponse update(@Valid@PathVariable Long id,@RequestBody RegisterRequest request){


            return userservice.update(id,request);

        }

        @DeleteMapping("/{id}")

    public String delete(@Valid @PathVariable  long id){
        return userservice.delete(id);

        }


        }





