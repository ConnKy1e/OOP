//this sends notification to subscribers of a channel when a new upload releases

public interface Notification //notification interface
{
    public void attach(Observer o); //attach state
    public void detach(Observer o); //detach state
    public void notifyUpdate(Notify m); //notifyupdate state
}
 
public class NotificationBump implements Notification  { //class for sending notifications
     
    private List<Observer> observers = new ArrayList<>(); //create array for observers 
 
    @Override //overide parent class
    public void attach(Observer o) { //attaching notification
        observers.add(o); //adding variable
    }
 
    @Override //override parent class
    public void detach(Observer o) { //detaching notification
        observers.remove(o); //adding variable
    }
 
    @Override //override parernt class
    public void notifyUpdate(Notify m) { //updating notification
        for(Observer o: observers) { //adding variable
            o.update(m); //update with notification received
        }
    }
}

public interface Observer //variable
{
    public void update(Notify m); //update observer if any change
}

public class NotifySubscriberOne implements Observer //implementation
{
    @Override //override parent class
    public void update(Notify m) { //update observer
        System.out.println("UpdateNotificationOne :: " + m.getNotificationContent()); //output update notification of subscriber one
    }
}

public class NotifySubscriberTwo implements Observer //implementation
{
    @Override //override parent class
    public void update(Notify m) { //update observer
        System.out.println("UpdateNotificationTwo :: " + m.getNotificationContent()); //output update notification of subscriber two
    }
}
public class NotifySubscriberThree implements Observer //implementation
{
    @Override //override parent class
    public void update(Notify m) { //update observer
        System.out.println("UpdateNotificationThree :: " + m.getNotificationContent()); //output update notification of subscriber three
    }
}

public class Notification //notifiction class
{
    final String NotificationContent; //cant be modified
     
    public Notification (String m) { //context of notification
        this.NotificationContent = m; //refers to current object
    }
 
    public String getNotificationContent() { // recieve message within notification
        return NotificationContent; //output message recieved
    }
}

public class Main //test program
{
    public static void main(String[] args) //allows to be run public
    {
        NotifySubscriberOne s1 = new NotifySubscriberOne(); //variable created for subscriber one
        NotifySubscriberTwo s2 = new NotifySubscriberTwo(); //variable created for subscriber two
        NotifySubscriberThree s3 = new NotifySubscriberThree(); //variable created for subscriber three
         
        NotifyPublisher p = new NotifyPublisher(); //variable created for notifier
         
        p.attach(s1); //attach subscriber one 
        p.attach(s2); //attack subscruber two 
        p.attach(s3); //attach subscruber three to notification
        
        p.notifyUpdate(new Notification("First Notification"));   //all subscribers will recieve notification
         
       
        
    }
}
