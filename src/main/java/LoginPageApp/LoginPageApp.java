package LoginPageApp;
/*

Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

         menü: kullanıcıya işlem seçimi için menü gösterilir.

         üye olma(register): kullanıcıdan ad-soyad, email ve şifre bilgileri alınız.
                             email ve şifre birer listede tutulur.
                             aynı email kabul edilmez.

         giriş(login): email ve şifre girilir.
                       email bulunamazsa kayıtlı değil, üye olun uyarısı verilir.
                       email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

         email validation: boşluk içermemeli
                         : @ içermeli
                         : gmail.com,hotmail.com veya yahoo.com ile bitmeli.
                         : mailin kullanıcı adı kısmında(@ den önce) sadece büyük-küçük harf,rakam yada -._ sembolleri olabilir.

         password validation: boşluk içermemeli
                            : en az 6 karakter olmalı
                            : en az bir tane küçük harf içermeli
                            : en az bir tane büyük harf içermeli
                            : en az bir tane rakam içermeli
                            : en az bir tane sembol içermeli
        */

import java.util.Scanner;

public class LoginPageApp {
    public static void main(String[] args) {
        start();

    }
    //1.adim
    private static void start(){
        Scanner scanner = new Scanner(System.in);
        int select; // CIKIS icin 0 secilsin

        //menu
        do {
            System.out.println("=====MY SITE WELCOME=====");
            System.out.println("1 - Uye Ol");
            System.out.println("2 - Giris Yap");
            System.out.println("0 - CIKIS");
            System.out.print("Seciminiz : ");
            select = scanner.nextInt(); //0,1,2

            switch (select){
                case 1 -> // uye olam islemi
                        System.out.println(); // bunu sonra sil
                case 2 -> // giris yapma islemleri
                        System.out.println(); //bunu sonra sil
                case 0 -> System.out.println("Iyi gunler dileriz"); //asagida uygulama direk durdurulacakti donguden cikilacaktir
                default -> System.out.println("HATALI Giris Lutfen 0 - 1 - 2 Degerlerinden Birini Giriniz");
            }

        }while (select != 0);
    }
}
