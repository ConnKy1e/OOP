//this adds modifications to a car within a game

//Code for classes
public interface Car { // this is the component interface
	String modify(); //variable to modify car class
}

public class CarImpl implements Car { //component implementation
	
	@override //overriding parent class
	public string modify() { //modify car class
		return "Car"; //output changed car class
	}
}

public abstract class CarModify implements Car { //component implementation
	private Car Car; //selecting car class
	
	@override //overriding parent class
	public string modify() { //modify class
		return car.modify(); //output car class and the modification
	}
}

//Car modifers
public class Front Bumper extends CarModify { //decorators
	
	public Front Bumper(Car Car) { //add front bumper onto car class
		super(Car); //refering to parent class
	}
	
	public string modify() { //modify class
		return super.modify() + ModifyWithFrontBumper(); //output modify class with added modification
	}
	
	private string ModifyWithFrontBumper() { //modify variable
		return " with Front Bumper"; //output to user added modification
	}
}

public class Spoiler extends CarModify { //decorators
	
	public Spoiler(Car Car) { //add spoiler onto car class
		super(Car); //refering to parent class
	}
	
	public string modify() { //modify class
		return super.modify() + ModifyWithSpoiler(); //output modification with spoiler
	}
	
	private string ModifyWithSpoiler() { //modify variable
		return " with Spoiler"; //output to user added with spolier
	}
}

public class Exhaust extends CarModify { //decorators
	
	public Exhaust(Car Car) { //add exhuast onto car class
		super(Car); //refering to parent class
	}
	
	public string modify() { //modify class
		return super.modify() + ModifyWithExhaust(); //output modification with exhaust
	}
	
	private string ModifyWithExhaust() { //modify variable
		return " with Exhaust"; //output to user added with exhaust
	}
}
//testing program
//decorators modifying car
public void whenDecoratorsInjectedAtRuntime_thenConfigSuccness() { //modifications added start output
	Car Car1 = new EngineUp(new CarImpl()); //new modifier 
	assertEquals(Car1.modify(), //objects are equal
	"Car with Engine Upgrade"); //output car with engine upgrade
	
	Car Car2 = new Front Bumper( //car added with front bumper
	new(EngineUp(new CarImpl()))); //engine upgrade added to variable
	assertEquals(Car2.modify(), //objects are equal
	"Car with EngineUp with Front Bumper"); //output car with both modifications
	
	Car Car3 = new GearboxUp(new CarImpl()); //new modification variable
	assertEquals(Car3.modify(), //objects are equal
	"Car with Gearbox Upgrade"); //output new gearbox modification
	
	Car Car4 = new Spoiler( //car added with spoiler
	new(GearboxUp(new CarImpl()))); //variable added with gearbox upgrade
	assertEquals(Car4.modify(), //objects are equal
	"Car with Gearbox Upgrade with Spoiler"); //output both modifications
	
	Car Car5 = new BrakesUp(new CarImpl()); //new modifications variable 
	assertEquals(Car5.modify(), //objects are equal
	"Car with Brakes Upgrade"); //output new brakes modification
	
	Car Car6 = new Exhaust( //car added with exhaust
	new(BrakesUp(new CarImpl()))); //variable added with modification
	assertEquals(Car6.modify(), //objects are equal
	"Car with Brakes Upgrade and Exhaust"); //output both modifications
	
	
	
	
	

