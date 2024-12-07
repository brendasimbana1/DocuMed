package controller;

public class ValidateByER {
	public static boolean ValidateCi(String cedula) {
        if (cedula == null || !cedula.matches("\\d{10}")) {
            return false;
        }
        int[] coeficientes = {2, 1, 2, 1, 2, 1, 2, 1, 2};
        int suma = 0;
        
        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerDigito > 6) {
            return false;
        }

        for (int i = 0; i < 9; i++) {
            int digito = Character.getNumericValue(cedula.charAt(i));
            int producto = digito * coeficientes[i];
            suma += (producto >= 10) ? producto - 9 : producto;
        }

        int ultimoDigito = Integer.parseInt(cedula.substring(9, 10));
        int verificador = (10 - (suma % 10)) % 10;

        return ultimoDigito == verificador;
	}
	public static boolean validateNames (String name) {
		return name.matches("^([A-ZÁ-Ú][a-zá-ú]+[ ]?){1,4}$");
	}
	public static boolean validateEmail(String email) {
		return email.matches("^[a-zA-Z0-9_.-]+[@][a-z]+(.com)$");
	}
	public static boolean validatePhone (String phone) {
		return phone.matches("^([0-9]+){9,10,7}$");
	}
	public static boolean validateText(String text) {
		return text.matches("^[A-ZÁ-Úa-zá-ú]+$");
	}
}
