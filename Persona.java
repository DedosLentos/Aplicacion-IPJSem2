package aplicacion;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JTextField;

public class Persona {

private int idPersona;
private String nombre;
private String apellido;
private String dptoResidencia;
private byte cantHijos;
private LocalDate fechaNac;
private LocalDate fechaAct;

public ArrayList<Vehiculo>vehiculo;

@Override
public String toString() {
	return "Persona: id: " + idPersona + ", nombre: " + nombre + ", apellido: " + apellido + ", Departamento: "
			+ dptoResidencia + ", Hijos: " + cantHijos + ", F/N: " + fechaNac + ", Fecha de ingreso:"+ fechaAct+ "\n";
}

public LocalDate getFechaAct() {
	return fechaAct;
}
public void setFechaAct(LocalDate fechaAct) {
	this.fechaAct=fechaAct;
}
public byte getCantHijos() {
	return cantHijos;
}
public void setCantHijos(byte cantHijos) {
	this.cantHijos = cantHijos;
}
public LocalDate getFechaNac() {
	return fechaNac;
}
public void setFechaNac(LocalDate fechaNac) {
	this.fechaNac = fechaNac;
}

public int getIdPersona() {
	return idPersona;
}
public void setIdPersona(int idPersona) {
	this.idPersona = idPersona;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getDptoResidencia() {
	return dptoResidencia;
}
public void setDptoResidencia(String dptoResidencia) {
	this.dptoResidencia = dptoResidencia;
}
public Persona(int idPersona, String nombre, String apellido, String dptoResidencia, byte cantHijos, LocalDate fechaNac, LocalDate fechaAct) {

	this.idPersona = idPersona;
	this.nombre = nombre;
	this.apellido = apellido;
	this.dptoResidencia = dptoResidencia;
	this.cantHijos = cantHijos;
	this.fechaNac=fechaNac;
	this.fechaAct=fechaAct;
}


public Persona(int idPersona, String nombre, String apellido, String dptoResidencia, byte cantHijos, LocalDate fechaNac,ArrayList<Vehiculo>vehiculo) {
	
	this.idPersona = idPersona;
	this.nombre = nombre;
	this.apellido = apellido;
	this.dptoResidencia = dptoResidencia;
	this.cantHijos = cantHijos;
	this.fechaNac = fechaNac;
	this.vehiculo = vehiculo;
}
public Persona() {
	
}

}
