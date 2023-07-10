package com.fabianPalma.FamiliarizarEnrutamiento;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class DojoController {
	@RequestMapping("{dojo}")
    public String getDojo(@PathVariable String dojo) {
        if (dojo.equals("dojo")) {
            return "¡El Dojo es increíble!";
        } else if (dojo.equals("burbank-dojo")) {
            return "El Dojo Burbank está localizado al sur de California";
        } else if (dojo.equals("san-jose")) {
            return "El Dojo SJ es el cuartel general";
        } else {
            return "Ruta no válida";
        }
    }
}
