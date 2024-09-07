import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private Category category;
}



