package flash_sale.salee.seller;

import flash_sale.salee.seller_dto.Registerseller;
import flash_sale.salee.seller_dto.Responseseller;
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

    public Responseseller responseseller(@RequestBody Registerseller registerseller){
        return sellerservice.responseseller(registerseller);

    }
    @PutMapping("/update")
    public Responseseller update(@PathVariable Long id , @RequestBody Registerseller registerseller){
        return sellerservice.responseseller(registerseller);

    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        return sellerservice.delete(id);

    }
}
