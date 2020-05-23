package com.manchkin.app.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PlayerDto {
    @Null
    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String pass;
}
