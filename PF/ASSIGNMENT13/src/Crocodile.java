/**
 * Crocodile extending Reptile class
 */
class Crocodile extends Reptile {
	Crocodile(int id, String name, int age, int weight) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}
	@Override
	public String getSound() {
		return "Hiss";
	}
}