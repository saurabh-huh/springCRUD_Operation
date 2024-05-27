package demo.spring.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private UUID id;

    private String firstName;

    private String lastName;

    private String email;

}
