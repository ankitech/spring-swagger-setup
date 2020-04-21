package ankitech.springswagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@ApiModel(description = "user object")
@Getter
@Setter
@Builder
public class User {
    @ApiModelProperty(position = -2,
            notes = "unique user id",
            readOnly = true)
    private String id;

    @ApiModelProperty(position = -1,
            notes = "phone number of the user",
            example = "917894561235",
            required = true)
    private String phone;

    @ApiModelProperty(notes = "Email id of the user",
            example = "name@domian.com")
    private String email;

    @ApiModelProperty(notes = "first name",
            example = "First")
    private String firstName;

    @ApiModelProperty(position = 1,
            notes = "last name", example = "Last")
    private String lastName;

    @ApiModelProperty(notes = "Date of birth",
            example = "2020-04-19")
    private LocalDate dob;

    @ApiModelProperty(notes = "Record create time")
    private LocalDateTime rCreTime;

    @ApiModelProperty(notes = "Record modification time")
    private LocalDateTime rModTime;
}
