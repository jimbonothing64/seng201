package Game;
/**
 * cow is a type of farm animal and 
 * child class that inherits from animal super class
 */

/**
 * calls the super() constructor of the
 * animal superclass with default
 * attributes of the cow class
 * @author will
 */
public class Cow extends Animal {
	public Cow() {
		super("cow", 9, 1, 2, 1);
	}
}