/**
 *Peacock class extending from bird class
 */
class Peacock extends Bird {
	Peacock(int id, String name, int age, int weight) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
	}

	@Override
	public String getSound() {
		return "Scream";
	}
}