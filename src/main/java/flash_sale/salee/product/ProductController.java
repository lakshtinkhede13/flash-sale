package flash_sale.salee.product;

import flash_sale.salee.ProductDto.Register;
import flash_sale.salee.ProductDto.Request;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private  final productservice productservice;

    @GetMapping("/get")
    public List<Request>responses(){
        return productservice.getallproduct();
    }

    @PutMapping("/{pid}")
    public Request response(@Valid @PathVariable Long pid , @RequestBody Register register){
        return productservice.response(pid, register);

    }
    @PostMapping("/register")
    public Request response(@Valid @RequestBody Register register) {
        return productservice.response(register);
    }
    @DeleteMapping("/{id}")
    public String delete(@Valid@PathVariable Long pid){
        return productservice.delete(pid);
    }
}
