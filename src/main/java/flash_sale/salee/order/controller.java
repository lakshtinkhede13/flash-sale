package flash_sale.salee.order;

import flash_sale.salee.DTO.Requestorder;
import flash_sale.salee.DTO.Responseorder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@AllArgsConstructor
public class controller {


    private final orderservice orderservice;

    @PostMapping("/register")
    public Responseorder responseorder(@Valid  @RequestBody Requestorder requestorder) {

        return orderservice.responseorder(requestorder);

    }
}
