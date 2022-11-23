//this adds modifications to a car within a game

//Code for classes
public interface Car {
	String modify();
}

public class CarImpl implements Car {
	
	@override
	public string modify() {
		return "Car";
	}
}

public abstract class CarModify implements Car {
	private Car Car;
	
	@override
	public string modify() {
		return car.modify();
	}
}

//Car modifers
public class Front Bumper extends CarModify {
	
	public Front Bumper(Car Car) {
		super(Car);
	}
	
	public string modify() {
		return super.modify() + ModifyWithFrontBumper();
	}
	
	private string ModifyWithFrontBumper() {
		return " with Front Bumper";
	}
}

public class Spoiler extends CarModify {
	
	public Spoiler(Car Car) {
		super(Car);
	}
	
	public string modify() {
		return super.modify() + ModifyWithSpoiler();
	}
	
	private string ModifyWithSpoiler() {
		return " with Spoiler";
	}
}

public class Exhaust extends CarModify {
	
	public Exhaust(Car Car) {
		super(Car);
	}
	
	public string modify() {
		return super.modify() + ModifyWithExhaust();
	}
	
	private string ModifyWithExhaust() {
		return " with Exhaust";
	}
}
//decorators modifying car
public void whenDecoratorsInjectedAtRuntime_thenConfigSuccness() {
	Car Car1 = new EngineUp(new CarImpl());
	assertEquals(Car1.modify(),
	"Car with Engine Upgrade");
	
	Car Car2 = new Front Bumper(
	new(EngineUp(new CarImpl())));
	assertEquals(Car2.modify(),
	"Car with EngineUp with Front Bumper");
	
	Car Car3 = new GearboxUp(new CarImpl());
	assertEquals(Car3.modify(),
	"Car with Gearbox Upgrade");
	
	Car Car4 = new Spoiler(
	new(GearboxUp(new CarImpl())));
	assertEquals(Car4.modify(),
	"Car with Gearbox Upgrade with Spoiler");
	
	Car Car5 = new BrakesUp(new CarImpl());
	assertEquals(Car5.modify(),
	"Car with Brakes Upgrade");
	
	Car Car6 = new Exhaust(
	new(BrakesUp(new CarImpl())));
	assertEquals(Car6.modify(),
	"Car with Brakes Upgrade and Exhaust");
	
	
	
	
	

