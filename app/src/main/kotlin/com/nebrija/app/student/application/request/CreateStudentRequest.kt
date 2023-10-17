package com.nebrija.app.student.application.request

import com.nebrija.app.common.application.BaseRequest
import org.springframework.validation.Validator
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

class CreateStudentRequest(validator: Validator) : BaseRequest(validator){
    @field:NotBlank(message = "Name is required")
    @field:Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    var firstName: String = "";

    @field:NotBlank(message = "Last name is required")
    @field:Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    var lastName: String = "";

    @field:NotBlank(message = "Grade is required")
    @field:Size(min = 2, max = 50, message = "Grade must be between 2 and 50 characters")
    var grade: String = "";

    @field:NotBlank(message = "Group is required")
    @field:Size(min = 2, max = 50, message = "Group must be between 2 and 50 characters")
    var group: String = "";
}