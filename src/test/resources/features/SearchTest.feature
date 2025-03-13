Feature: Search Scenarios
  Background:
    Given Anasayfa Acilir

    @Chrome
  Scenario: Tablet Aramasi
    Then Anasayfa Kontol Edilir
    Then Kullanici Elektronik kategorisine gider
    Then Move to Element
    Then Tablet Secilir
    Then Cerezler Kabul Edilir
    Then Sayfa Kontrol Edilir
    Then Apple seceneğine kaydırılır
    Then Apple Markasi Secilir
    Then Ekran seceneğine kaydırılır
    Then Ekran Boyutu Secilir
    Then En pahali Urun Secilir
    Then Fiyat Kontrol
