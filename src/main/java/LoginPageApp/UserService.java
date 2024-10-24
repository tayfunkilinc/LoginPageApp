package LoginPageApp;

import java.util.*;

//user ile ilgili methotlar icin bu class kullanilacak
public class UserService {

    Scanner scanner = new Scanner(System.in);

    // List<User> users = new ArrayList<>(); // burda User veri tiplerini tutacagiz normalde bu sekilde saklanir // bunu kullanmayi ssen bir dene
    Map<String,String> userInfo = new HashMap<>(); // K:email , V:Password

    //4-adim: uye olma islemi
    public void register(){
        System.out.println("Ad-Soyad Giriniz");
        String name = scanner.nextLine();

        String email;
        boolean isValid; //true ise gecerli false ise email gecersizdir
        //email gecerli mi? gecersizse tekrar sorulmali dogru olana kadar
        do {
            System.out.println("Email Giriniz: ");
            email = scanner.nextLine();
            //gecerli mi?
            isValid = validateEmail(email); // kontrol sonunda buraya true false donecek ve isValid e atanacak ve dongu buna gore hareket edecek

            //email unique olmali: bu email ile daha once kayitli kullanici var mi diye kontrol etmeliyiz
            boolean isExistEmail = this.userInfo.containsKey(email); // bu email kayitli kullanicilar arasinda varsa true donderir. yoksa false donderir
            if (isExistEmail){
                System.out.println("Bu Email ile Kayitli Kullanici ZAten Var!");
                isValid = false; // burda dongunun tekrar devam etmesi icin bu atamayi yaptik
            }

        }while (!isValid);

        // gecerli bir sifre olusturalim
        String password;
        boolean isValidPassword;
        do {
            System.out.println("Sifrenizi Olusturunuz ");
            password = scanner.nextLine();
           isValidPassword = validatePassword(password);

        }while (!isValidPassword);

        //User olusturalim
        User user = new User(name, email, password);
        System.out.println(user.getEmail());
        //user bilgilerini userInfo ya ekleyelim

        this.userInfo.put(user.getEmail(), user.getPassword());
        System.out.println(this.userInfo.containsKey(email));


        System.out.println("Sayin "+user.getName()+ " tebrikler kayit islemi basariyla gerceklesti.");
        System.out.println("Email. ve Sifrenizi Kullanarak Sisteme Giris Yapabilirsiniz");
    }
    //7-adim: giris islemi icin method tanimlayalim
    public void login(){
        System.out.println("Email Giriniz: ");
        String email = scanner.nextLine(); // asd@gmail.com

        //kullanici kaydi var mi?
        System.out.println(email);
        System.out.println(this.userInfo.containsKey(email));
        if (this.userInfo.containsKey(email)){ // kullanici varsa
            // sifre soralim email dogru ise
            boolean isSuccess = false;
            int counter = 3;

            while ( !isSuccess && counter>0 ){
                System.out.println("Sifrenizi Giriniz: ");
                String password = scanner.nextLine();
                //email le karsilik gelen password dogrumu eslesmesini kontrol edecegiz
                if (this.userInfo.get(email).equals(password)){
                    //giris basarili
                    System.out.println("Harika Sisteme Giris Yaptiniz. Hosgeldiniz");
                    isSuccess = true; // giris yapidigi icin donguden bu sekilde ciktik
                }else {
                    //sifre yalnissa
                    counter--;
                    if (counter==0){
                        System.out.println("3 Defa Hatali Giris Yaptiniz Ana Sayfaya Yonlendiriliyorsunuz");
                    }else {
                        System.out.println("Sifrenizi Yalnis Girdiniz Tekrar Deneyiniz Kalan Hakkini" + counter);
                    }
                }
            }

        }else { // kullanici yoksa
            System.out.println("Sisteme Bu Email Ile Kayitli Kullanici Bulunamadi");
            System.out.println("Uye Iseniz Bilgilerinizi Kontrol Ediniz veya Uye Degilseniz Uye Olunuz");
        }
    }



    //5-email dogrulama islemi icin method olusturalim
    private boolean validateEmail (String email){
        //email gecersizse hata mesaji ver geriye false donder
        boolean isValid = true;

        boolean hasSpace = email.contains(" ");
        boolean hasAtSymbol = email.contains("@");
        if (hasSpace){
            System.out.println("Email Bosluk Iceremez");
            isValid =false;
        } else if (!hasAtSymbol) {
            System.out.println("Email @ Sembolu Icermelidir");
            isValid = false;
        }else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean isExistsInvalidChar = firstPart.replaceAll("[A-Za-z0-9-._]", "").length()>0;
            // burda istedigimiz karekterileri cikarinca herhangi bir karekter kaliyorsa gecersiz email olacak

            boolean isValidDomain = secondPart.equals("gmail.com") ||
                    secondPart.equals("yahoo.com") ||
                    secondPart.equals("hotmail.com");

            if (isExistsInvalidChar){
                System.out.println("Email harf rakam ve -._ disinda karakter iceremez");
                isValid = false;
            } else if (!isValidDomain) {
                System.out.println("Sisteme Sadece gmail, yahoo ve hotmail ile kayit olabilrisiniz");
                isValid =false;
            }

        }
        if (!isValid){
            System.out.println("Gecersiz Email Tekrar Deneyiniz");
        }
        return isValid;
    }

    //6-adim: password dogrulama methodunu yazin ODEV bunu yap
    private boolean validatePassword(String password){
        return true;
    }




}
