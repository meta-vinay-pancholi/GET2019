/**
 *Lion class extending Mammal class
 */
class Lion extends Mammal {
	public Lion(int id, String name, int age, int weight) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight =weight;
	}
	@Override
	public String getSound() {
		return "roar";
	}
}