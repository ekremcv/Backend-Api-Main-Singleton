package com.ekrem.Falcon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDtoFilter {
    String firstname;
    String lastname;
    String email;
}
