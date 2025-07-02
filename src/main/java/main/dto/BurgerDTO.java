package main.dto;


import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BurgerDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
}
