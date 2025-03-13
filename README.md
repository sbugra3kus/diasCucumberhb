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
pom.xml: Maven bağımlılıklarını ve proje yapılandırmasını tanımlayan dosya. Bu dosya, projede kullanacağınız kütüphaneleri ve yapılandırmaları içerir.

README.md: Proje hakkında genel bilgi, kurulum talimatları, kullanım kılavuzu ve katkıda bulunma rehberi içeren dosya.

src/main/java
com.example.yourapp.Main.java: Ana uygulama sınıfı. Genellikle uygulamanın başlangıç noktasını içerir.

com.example.yourapp.utils.Helper.java: Yardımcı fonksiyonları barındıran sınıf. Projede tekrar kullanılabilir genel işlevleri içerir.

src/main/resources
application.properties: Uygulama yapılandırma dosyası. Uygulama ayarları, bağlantı bilgileri ve diğer yapılandırma detaylarını içerir.

src/test/java
com.example.yourapp.Runner.java: Cucumber testlerini çalıştırmak için kullanılan test çalıştırıcısı sınıfı. Test senaryolarının hangi dosyalardan alınacağını ve nasıl çalıştırılacağını tanımlar.

com.example.yourapp.stepdefs.StepDefinitions.java: Test adımlarını tanımlayan sınıf. Cucumber senaryolarında kullanılan adımları içerir.

com.example.yourapp.stepdefs.hooks.Hooks.java: Test öncesi ve sonrası işlemleri tanımlayan sınıf. Genellikle testlerin başında ve sonunda çalışacak kodları içerir.

com.example.yourapp.pages.HomePage.java: Ana sayfa ile ilgili web elemanlarını ve işlemleri içeren sınıf.

com.example.yourapp.pages.LoginPage.java: Giriş sayfası ile ilgili web elemanlarını ve işlemleri içeren sınıf.

src/test/resources
features/login.feature: Cucumber senaryolarını içeren özellik dosyası. Test senaryoları burada tanımlanır.

testng.xml:TestNG yapılandırma dosyası. Paralel test çalıştırma, gruplama ve diğer TestNG yapılandırmalarını içerir.
