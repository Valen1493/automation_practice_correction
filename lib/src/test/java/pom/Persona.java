package pom;

public class Persona {

	private String nombre;
	private String cedula;
	private static Persona persona;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	public static Persona getInstance(String nombre,String cedula){
		if(persona == null){
			return new Persona(nombre,cedula);
		} else {
			return persona;
		}
	}
	
	private Persona(String nombre, String cedula){
		this.nombre = nombre;
		this.cedula = cedula;
		
	}
}
