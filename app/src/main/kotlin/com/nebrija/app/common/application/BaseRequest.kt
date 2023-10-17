package com.nebrija.app.common.application

import org.springframework.validation.BeanPropertyBindingResult
import org.springframework.validation.Validator
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus
import org.springframework.validation.Errors
import org.springframework.validation.ValidationUtils

abstract class BaseRequest(protected val validator: Validator) {
    init {
        this.populate()

        if (this.autoValidateRequest()) {
            this.validate()
        }
    }

    open fun getRequest(): Map<String, Any?> {
        return emptyMap()
    }

    protected open fun autoValidateRequest(): Boolean {
        return true
    }

    protected fun populate() {
        val request = this.getRequest()
        val bindingResult = BeanPropertyBindingResult(this, this.javaClass.name)

        for ((property, value) in request) {
            if (propertyExists(property)) {
                this.setPropertyValue(property, value, bindingResult)
            }
        }
    }

    private fun propertyExists(propertyName: String): Boolean {
        return try {
            this.javaClass.getDeclaredField(propertyName)
            true
        } catch (e: NoSuchFieldException) {
            false
        }
    }

    private fun setPropertyValue(property: String, value: Any?, bindingResult: BeanPropertyBindingResult) {
    }

    open fun validate() {
        val errors = BeanPropertyBindingResult(this, this.javaClass.name)
        this.validate(errors)

        if (errors.hasErrors()) {
            throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Validation failed: ${errors.allErrors.map { it.defaultMessage }.joinToString(", ")}")
        }
    }

    protected open fun validate(errors: Errors) {
        ValidationUtils.invokeValidator(this.validator, this, errors)
    }
}