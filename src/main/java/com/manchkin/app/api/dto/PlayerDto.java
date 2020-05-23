package com.manchkin.app.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PlayerDto {
    @NotNull @Size(min = 5, max = 64)
    private String login;

    @NotNull @Size(min = 5, max = 32)
    private String pass;
}
