package main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SubmarinesDTO {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
}
