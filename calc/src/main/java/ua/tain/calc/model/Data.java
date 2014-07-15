package ua.tain.calc.model;

/**
 * Simple data bean, to work with Views
 * @author polar
 *
 */
public class Data {

	private Pair fields[];

	public Pair[] getFields() {
		return fields;
	}

	public void setFields(Pair[] fields) {
		this.fields = fields;
	}

	public Data(Pair[] fields) {
		super();
		this.fields = fields;
	}

	public Data() {
		super();
		this.fields = null;
	}

}
