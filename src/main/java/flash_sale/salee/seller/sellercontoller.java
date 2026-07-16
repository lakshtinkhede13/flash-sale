package flash_sale.salee.seller;

import flash_sale.salee.seller_dto.Registerseller;
import flash_sale.salee.seller_dto.Responseseller;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seller")
@RequiredArgsConstructor
public class sellercontoller {
    private final sellerservice sellerservice;

    @GetMapping("/get")
    public List<Responseseller>responsesellers(){
        return sellerservice.getall();
    }

    @PostMapping("/register")

    public Responseseller responseseller(@Valid @RequestBody Registerseller registerseller){
        return sellerservice.responseseller(registerseller);

    }
    @PutMapping("/update")
    public Responseseller update(@Valid@PathVariable Long id , @RequestBody Registerseller registerseller){
        return sellerservice.responseseller(id, registerseller);

    }
    @DeleteMapping("/{id}")
    public String delete(@Valid@PathVariable Long id){
        return sellerservice.delete(id);

    }
}
