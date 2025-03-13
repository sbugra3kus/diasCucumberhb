DiasCucumberHB Projesi
Bu proje, DiasCucumberHB adı verilen bir web otomasyon test projesidir. Proje, Selenium, Cucumber, ve Java kullanarak test otomasyonu sağlamaktadır.

Başlangıç
Gereksinimler
Bu projeyi çalıştırmak için aşağıdaki yazılımlara ihtiyacınız olacak:

Java 8+

Maven 3.6+

IntelliJ IDEA veya başka bir IDE

Kurulum
Projeyi yerel makinenize klonlamak için aşağıdaki adımları izleyin:

Proje dosyalarını indirin:

bash
git clone https://github.com/sbugra3kus/diasCucumberhb.git
cd diasCucumberhb
Bağımlılıkları yükleyin:

bash
mvn clean install
Testlerin Çalıştırılması
Projede yer alan testleri çalıştırmak için aşağıdaki adımları izleyin:

Testleri çalıştırın:

bash
mvn test
Raporlama
Test sonuçları, target/cucumber-reports dizininde yer alan HTML raporlarında bulunabilir.

Proje Yapısı
src/test/java: Test dosyalarının bulunduğu dizin.

src/main/java: Ana uygulama dosyalarının bulunduğu dizin.

pom.xml: Maven proje yapılandırma dosyası.


diasCucumberhb
├── pom.xml
├── README.md
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── yourapp
    │   │               ├── Main.java
    │   │               └── utils
    │   │                   └── Helper.java
    │   └── resources
    │       └── application.properties
    └── test
        ├── java
        │   └── com
        │       └── example
        │           └── yourapp
        │               ├── Runner.java
        │               ├── stepdefs
        │               │   ├── StepDefinitions.java
        │               │   └── hooks
        │               │       └── Hooks.java
        │               └── pages
        │                   ├── HomePage.java
        │                   └── LoginPage.java
        └── resources
            ├── features
            │   └── login.feature
            └── testng.xml
