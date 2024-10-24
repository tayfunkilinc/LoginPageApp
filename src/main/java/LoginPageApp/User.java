package LoginPageApp;

//POJO - Plain Old Java Object -->  sadece objeyi ilgilendiren veriler varsa buna POJO class denir ve asagidaki bilgileri icerir
//field: private
//constructor
//getter-setter
//toString
// bir class sadece bir islem yapmali
public class User {
    //ad - soyad, username(email), password
    private String name; //null
    private String email; //null
    private String password; //null

    //user olusturuldugunda fieldlarin atanmis olmasini istiyorum bunun icin parametreli constructure olurmaliyim

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


    //getter -setter

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
