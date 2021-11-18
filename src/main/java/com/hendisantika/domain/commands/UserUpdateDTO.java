package com.hendisantika.domain.commands;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * Project : user-registration-command-pattern
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 19/11/21
 * Time: 05.52
 */
@Data
@ApiModel(description = "User Update Model")
public class UserUpdateDTO {

    @ApiModelProperty(notes = "First Name", example = "Charles", required = true)
    @NotNull
    @Size(min = 1, message = "First Name should have at least 1 character")
    private String firstName;

    @ApiModelProperty(notes = "Last Name", example = "Darwin", required = true)
    @NotNull
    @Size(min = 1, message = "Last Name should have at least 1 character")
    private String lastName;

    @ApiModelProperty(notes = "Email Id for communication", example = "charles.darwin@gmail.com", required = true)
    @NotNull
    @Email(message = "Email should be valid")
    private String email;
}
