package ex5;

public class SuperAdmin implements UserActions,AdminActions{
    @Override
    public void logActivity(String activity){
        AdminActions.super.logActivity(activity);
    }
}
