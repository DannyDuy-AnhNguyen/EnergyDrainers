package com.example.energiedrainers.Session;

//This class will show the userdata after the user is logged in.
public class UserSession {
    private static UserSession setSession;

    private int id;
    private String username;  // Add other fields as needed
    private String phonenumber;

    private UserSession(int id, String username, String phonenumber)
    {
        this.id = id;
        this.username = username;
        this.phonenumber = phonenumber;
    }

    // Singleton instance getter
    public static void setSession(int id, String username, String phonenumber) {
        if (setSession == null) {
            setSession = new UserSession(id, username, phonenumber);
            System.out.println("Session created: " + id + ", " + username + ", " + phonenumber);
        } else if(UserSession.getSession() == null){
            System.out.println("User is not logged in!");
        } else{
            System.out.println("Session has already been created🤓.");
        }
    }

    public static UserSession getSession(){
        return setSession;
    }

    // 💀Clear the session
    public static void clearSession() {
        setSession = null;
    }

    public static String getUsername(){
        if (setSession != null) {
            return setSession.username;  // Return the username from the current session
        } else {
            return "No user logged in";  // Return a default message if no session is active
        }
    }

    public static String getPhoneNumber(){
        if (setSession != null) {
            return setSession.phonenumber;  // Return the username from the current session
        } else {
            return "No user logged in";  // Return a default message if no session is active
        }
    }

    public static int getID(){
        if (setSession != null) {
            return setSession.id;  // Return the username from the current session
        } else {
            return 0;  // Return a default message if no session is active
        }
    }


    // Optional: Add a toString method for debugging
    @Override
    public String toString() {
        return "UserSession{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", telefoonnummer='" + phonenumber + '\'' +
                '}';
    }
}

