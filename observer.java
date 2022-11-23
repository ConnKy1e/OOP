//this sends notification to subscribers of a channel when a new upload releases

public interface Notification 
{
    public void attach(Observer o);
    public void detach(Observer o);
    public void notifyUpdate(Notify m);
}
 
public class NotificationBump implements Notification  {
     
    private List<Observer> observers = new ArrayList<>();
 
    @Override
    public void attach(Observer o) {
        observers.add(o);
    }
 
    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }
 
    @Override
    public void notifyUpdate(Notify m) {
        for(Observer o: observers) {
            o.update(m);
        }
    }
}

public interface Observer 
{
    public void update(Notify m);
}

public class NotifySubscriberOne implements Observer 
{
    @Override
    public void update(Notify m) {
        System.out.println("UpdateNotificationOne :: " + m.getNotificationContent());
    }
}

public class NotifySubscriberTwo implements Observer 
{
    @Override
    public void update(Notify m) {
        System.out.println("UpdateNotificationTwo :: " + m.getNotificationContent());
    }
}
public class NotifySubscriberThree implements Observer 
{
    @Override
    public void update(Notify m) {
        System.out.println("UpdateNotificationThree :: " + m.getNotificationContent());
    }
}

public class Notification 
{
    final String NotificationContent;
     
    public Notification (String m) {
        this.NotificationContent = m;
    }
 
    public String getNotificationContent() {
        return NotificationContent;
    }
}

public class Main 
{
    public static void main(String[] args) 
    {
        NotifySubscriberOne s1 = new NotifySubscriberOne();
        NotifySubscriberTwo s2 = new NotifySubscriberTwo();
        NotifySubscriberThree s3 = new NotifySubscriberThree();
         
        NotifyPublisher p = new NotifyPublisher();
         
        p.attach(s1);
        p.attach(s2);
         
        p.notifyUpdate(new Notification("First Notification"));   //s1 and s2 will receive the update
         
        p.detach(s1);
        p.attach(s3);
         
        p.notifyUpdate(new Notification("Second Notification")); //s2 and s3 will receive the update
    }
}