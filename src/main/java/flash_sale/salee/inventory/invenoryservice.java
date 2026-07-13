package flash_sale.salee.inventory;

import org.springframework.stereotype.Service;

@Service
public class invenoryservice {
    private final Inventoryrepo inventoryrepo;

    public invenoryservice(Inventoryrepo inventoryrepo) {
        this.inventoryrepo = inventoryrepo;
    }
}
