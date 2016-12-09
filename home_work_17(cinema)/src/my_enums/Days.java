package my_enums;

public enum Days {

	
	
	MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);
	
	int nomberOfDay;

	private Days(int nomberOfDay) {
		this.nomberOfDay = nomberOfDay;
	}

	public int getNomberOfDay() {
		return nomberOfDay;
	}

	public void setNomberOfDay(int nomberOfDay) {
		this.nomberOfDay = nomberOfDay;
	}
	
	
}