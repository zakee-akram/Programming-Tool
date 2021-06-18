package objects;

public class user {
    private int Id;
    private String Username, SecondName, FirstName, Password, Email;

    public user(int Id, String Username, String FirstName, String Password, String Email,String SecondName) {
        this.Id = Id;
        this.Username = Username;
        this.FirstName = FirstName;
        this.Password = Password;
        this.Email = Email;
        this.SecondName = SecondName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
}
