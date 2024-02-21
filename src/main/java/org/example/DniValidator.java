/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import com.vaadin.flow.data.binder.ValidationResult;
import com.vaadin.flow.data.binder.ValueContext;
import com.vaadin.flow.data.validator.AbstractValidator;

/**
 *
 * @author Javier
 */
public class DniValidator extends AbstractValidator<String> {

    public DniValidator(String message) {
        super(message);
    }

    @Override
    public ValidationResult apply(String value, ValueContext context) {
        if (value == null || value.isEmpty()) {
            return ValidationResult.error("El DNI no puede estar vacío");
        }

        // Verificar que el DNI tenga 9 caracteres
        if (value.length() != 9) {
            return ValidationResult.error("El DNI debe tener exactamente 9 caracteres");
        }

        // Verificar que los primeros 8 caracteres sean números
        String numeros = value.substring(0, 8);
        if (!numeros.matches("\\d+")) {
            return ValidationResult.error("Los primeros 8 caracteres deben ser números");
        }

        // Verificar que el último carácter sea una letra
        char letra = value.charAt(8);
        if (!Character.isLetter(letra)) {
            return ValidationResult.error("El último caracter debe ser una letra");
        }

        return ValidationResult.ok();
    }
}
