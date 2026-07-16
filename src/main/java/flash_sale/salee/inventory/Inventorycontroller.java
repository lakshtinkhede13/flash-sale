package flash_sale.salee.inventory;

import flash_sale.salee.DtOINventory.Response;
import flash_sale.salee.DtOINventory.register;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
@AllArgsConstructor
public class Inventorycontroller {

    private final invenoryservice invenoryservice;


    @PostMapping("/register")
    public Response responses(@Valid @RequestBody register register){

        return invenoryservice.request(register);
    }

    @GetMapping("/get")
    public List<Response>responses(){
        return invenoryservice.getall();
    }
}
