package ua.tain.calc.model;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Simple name/value pair bean
 * @author polar
 *
 */
public class Pair {

	/**
	 * Name of the field
	 */
	private String name;
	
	/**
	 * Value (for calculation)
	 */
	@NotEmpty @Valid
	private float value;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public Pair(String name, float value) {
		super();
		this.name = name;
		this.value = value;
	}
	public Pair() {
		super();
		this.name = "unnamed";
		this.value = -1;
	}
}
