/**
 * Zone class holding category of the zone and capacity of cage it can hold
 */
public class Zone {
	String category;
	int cageCapity;
	int zoneCount;

	Zone(String category, int cageCapity) {
		this.category = category;
		this.cageCapity = cageCapity;
	}
	public int getZoneCount() {
		return zoneCount;
	}
}
