package data.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="products")
public class LaptopEntity {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    @JsonProperty(value = "Nazwa produktu")
    private String nazwaProduktu;

    @JsonProperty(value = "Cena")
    private String cena;
    @JsonProperty(value = "Kategoria")
    private String kategoria;
    @JsonProperty(value = "Procesor")
    private String procesor;
    @JsonProperty(value = "Pamięć RAM")
    private String pamiecRAM;
    @JsonProperty(value = "Ilość gniazd pamięci")
    private String iloscGniazdPamieci;
    @JsonProperty(value = "Wbudowane napędy optyczne")
    private String wbudowaneNapedyOptyczne;
    @JsonProperty(value = "Typ ekranu")
    private String typEkranu;
    @JsonProperty(value = "Przekątna ekranu")
    private String przekatnaEkranu;
    @JsonProperty(value = "Rozdzielczość ekranu")
    private String rozdzielczoscEkranu;
    @JsonProperty(value = "Kamera internetowa")
    private String kameraInternetowa;
    @JsonProperty(value = "Bateria")
    private String bateria;
    @JsonProperty(value = "Wysokość")
    private String wysokosc;
    @JsonProperty(value = "Szerokość")
    private String szerokosc;
    @JsonProperty(value = "Głębokość")
    private String glebokosc;
    @JsonProperty(value = "Gwarancja")
    private String gwarancja;
    @JsonProperty(value = "Karta graficzna")
    private String kartaGraficzna;
    @JsonProperty(value = "Łączność")
    private String lacznosc;
    @JsonProperty(value = "Dołączone akcesoria")
    private String dolaczoneAkcesoria;
    @JsonProperty(value = "Komponenty rozszerzone")
    private String komponentyRozszerzone;
    @JsonProperty(value = "Dodatkowe informacje")
    private String dodatkoweInformacje;
    @JsonProperty(value = "Dźwięk")
    private String dzwiek;
    @JsonProperty(value = "Waga")
    private String waga;
    @JsonProperty(value = "Zainstalowany system operacyjny")
    private String zainstalowanySystemOperacyjny;
    @JsonProperty(value = "Dołączone oprogramowanie")
    private String dolaczoneOprogramowanie;

    public LaptopEntity() {
    }

    public LaptopEntity(Integer id, String cena, String nazwaProduktu, String procesor, String pamiecRAM, String iloscGniazdPamieci, String wbudowaneNapedyOptyczne,
                        String typEkranu, String przekatnaEkranu, String rozdzielczoscEkranu, String kameraInternetowa,
                        String bateria, String wysokosc, String szerokosc, String glebokosc, String gwarancja, String kartaGraficzna,
                        String lacznosc, String dolaczoneAkcesoria, String komponentyRozszerzone, String dodatkoweInformacje,
                        String dzwiek, String waga, String zainstalowanySystemOperacyjny, String dolaczoneOprogramowanie,
                        String kategoria) {
        this.id = id;
        this.nazwaProduktu = nazwaProduktu;
        this.cena = cena;
        this.kategoria = kategoria;
        this.procesor = procesor;
        this.pamiecRAM = pamiecRAM;
        this.iloscGniazdPamieci = iloscGniazdPamieci;
        this.wbudowaneNapedyOptyczne = wbudowaneNapedyOptyczne;
        this.typEkranu = typEkranu;
        this.przekatnaEkranu = przekatnaEkranu;
        this.rozdzielczoscEkranu = rozdzielczoscEkranu;
        this.kameraInternetowa = kameraInternetowa;
        this.bateria = bateria;
        this.wysokosc = wysokosc;
        this.szerokosc = szerokosc;
        this.glebokosc = glebokosc;
        this.gwarancja = gwarancja;
        this.kartaGraficzna = kartaGraficzna;
        this.lacznosc = lacznosc;
        this.dolaczoneAkcesoria = dolaczoneAkcesoria;
        this.komponentyRozszerzone = komponentyRozszerzone;
        this.dodatkoweInformacje = dodatkoweInformacje;
        this.dzwiek = dzwiek;
        this.waga = waga;
        this.zainstalowanySystemOperacyjny = zainstalowanySystemOperacyjny;
        this.dolaczoneOprogramowanie = dolaczoneOprogramowanie;
    }

    public String getNazwaProduktu() {
        return nazwaProduktu;
    }

    public void setNazwaProduktu(String nazwaProduktu) {
        this.nazwaProduktu = nazwaProduktu;
    }

    public String getProcesor() {
        return procesor;
    }

    public void setProcesor(String procesor) {
        this.procesor = procesor;
    }

    public String getPamiecRAM() {
        return pamiecRAM;
    }

    public void setPamiecRAM(String pamiecRAM) {
        this.pamiecRAM = pamiecRAM;
    }

    public String getIloscGniazdPamieci() {
        return iloscGniazdPamieci;
    }

    public void setIloscGniazdPamieci(String iloscGniazdPamieci) {
        this.iloscGniazdPamieci = iloscGniazdPamieci;
    }

    public String getWbudowaneNapedyOptyczne() {
        return wbudowaneNapedyOptyczne;
    }

    public void setWbudowaneNapedyOptyczne(String wbudowaneNapedyOptyczne) {
        this.wbudowaneNapedyOptyczne = wbudowaneNapedyOptyczne;
    }

    public String getTypEkranu() {
        return typEkranu;
    }

    public void setTypEkranu(String typEkranu) {
        this.typEkranu = typEkranu;
    }

    public String getPrzekatnaEkranu() {
        return przekatnaEkranu;
    }

    public void setPrzekatnaEkranu(String przekatnaEkranu) {
        this.przekatnaEkranu = przekatnaEkranu;
    }

    public String getRozdzielczoscEkranu() {
        return rozdzielczoscEkranu;
    }

    public void setRozdzielczoscEkranu(String rozdzielczoscEkranu) {
        this.rozdzielczoscEkranu = rozdzielczoscEkranu;
    }

    public String getKameraInternetowa() {
        return kameraInternetowa;
    }

    public void setKameraInternetowa(String kameraInternetowa) {
        this.kameraInternetowa = kameraInternetowa;
    }

    public String getBateria() {
        return bateria;
    }

    public void setBateria(String bateria) {
        this.bateria = bateria;
    }

    public String getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(String wysokosc) {
        this.wysokosc = wysokosc;
    }

    public String getSzerokosc() {
        return szerokosc;
    }

    public void setSzerokosc(String szerokosc) {
        this.szerokosc = szerokosc;
    }

    public String getGlebokosc() {
        return glebokosc;
    }

    public void setGlebokosc(String glebokosc) {
        this.glebokosc = glebokosc;
    }

    public String getGwarancja() {
        return gwarancja;
    }

    public void setGwarancja(String gwarancja) {
        this.gwarancja = gwarancja;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getKartaGraficzna() {
        return kartaGraficzna;
    }

    public void setKartaGraficzna(String kartaGraficzna) {
        this.kartaGraficzna = kartaGraficzna;
    }

    public String getLacznosc() {
        return lacznosc;
    }

    public void setLacznosc(String lacznosc) {
        this.lacznosc = lacznosc;
    }

    public String getDolaczoneAkcesoria() {
        return dolaczoneAkcesoria;
    }

    public void setDolaczoneAkcesoria(String dolaczoneAkcesoria) {
        this.dolaczoneAkcesoria = dolaczoneAkcesoria;
    }

    public String getKomponentyRozszerzone() {
        return komponentyRozszerzone;
    }

    public void setKomponentyRozszerzone(String komponentyRozszerzone) {
        this.komponentyRozszerzone = komponentyRozszerzone;
    }

    public String getIodatkoweInformacje() {
        return dodatkoweInformacje;
    }

    public void setIodatkoweInformacje(String iodatkoweInformacje) {
        dodatkoweInformacje = iodatkoweInformacje;
    }

    public String getDzwiek() {
        return dzwiek;
    }

    public void setDzwiek(String dzwiek) {
        this.dzwiek = dzwiek;
    }

    public String getWaga() {
        return waga;
    }

    public void setWaga(String waga) {
        this.waga = waga;
    }

    public String getZainstalowanySystemOperacyjny() {
        return zainstalowanySystemOperacyjny;
    }

    public void setZainstalowanySystemOperacyjny(String zainstalowanySystemOperacyjny) {
        this.zainstalowanySystemOperacyjny = zainstalowanySystemOperacyjny;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    public String getDolaczoneOprogramowanie() {
        return dolaczoneOprogramowanie;
    }

    public void setDolaczoneOprogramowanie(String dolaczoneOprogramowanie) {
        this.dolaczoneOprogramowanie = dolaczoneOprogramowanie;
    }

    public Integer getId() {
        return id;
    }

    public void setValueByKey(String key, String value){
        switch (key){
            case "Nazwa produktu" : setNazwaProduktu(value); break;
            case "Cena" : setCena(value); break;
            case "Kategoria" : setKategoria(value); break;
            case "Procesor" : setProcesor(value); break;
            case "Bateria" : setBateria(value); break;
            case "Waga" : setWaga(value); break;
            case "Szerokość" : setSzerokosc(value); break;
            case "Pamięć RAM" : setPamiecRAM(value); break;
            case "Typ ekranu" : setTypEkranu(value); break;
            case "Głębokość" : setGlebokosc(value); break;
            case "Gwarancja" : setGwarancja(value); break;
            case "Karta graficzna" : setKartaGraficzna(value); break;
            case "Dołączone akcesoria" : setDolaczoneAkcesoria(value); break;
            case "Ilość gniazd pamięci" : setIloscGniazdPamieci(value); break;
            case "Wbudowane napędy optyczne" : setWbudowaneNapedyOptyczne(value); break;
            case "Przekątna ekranu" : setPrzekatnaEkranu(value); break;
            case "Rozdzielczość ekranu" : setRozdzielczoscEkranu(value); break;
            case "Kamera internetowa" : setKameraInternetowa(value); break;
            case "Wysokość" : setWysokosc(value); break;
            case "Łączność" : setLacznosc(value); break;
            case "Komponenty rozszerzone" : setKomponentyRozszerzone(value); break;
            case "Dodatkowe informacje" : setDodatkoweInformacje(value); break;
            case "Dźwięk" : setDzwiek(value); break;
            case "Dołączone oprogramowanie" : setDolaczoneOprogramowanie(value); break;
            case "Zainstalowany system operacyjny" : setZainstalowanySystemOperacyjny(value); break;
            default: break;
        }
    }

    public String getDodatkoweInformacje() {
        return dodatkoweInformacje;
    }

    public void setDodatkoweInformacje(String dodatkoweInformacje) {
        this.dodatkoweInformacje = dodatkoweInformacje;
    }

    @Override
    public String toString() {
        return nazwaProduktu + ":" +

                ", Cena=" + cena +
                ", Kategoria=" + kategoria +
                ", Procesor=" + procesor +
                ", pamiecRAM=" + pamiecRAM +
                ", iloscGniazdPamieci=" + iloscGniazdPamieci +
                ", wbudowaneNapedyOptyczne=" + wbudowaneNapedyOptyczne +
                ", typEkranu=" + typEkranu +
                ", przekatnaEkranu=" + przekatnaEkranu +
                ", rozdzielczoscEkranu=" + rozdzielczoscEkranu +
                ", kameraInternetowa=" + kameraInternetowa +
                ", Bateria=" + bateria +
                ", wysokosc=" + wysokosc +
                ", Szerokość=" + szerokosc +
                ", glebokosc=" + glebokosc +
                ", gwarancja=" + gwarancja +
                ", kartaGraficzna=" + kartaGraficzna +
                ", lacznosc=" + lacznosc +
                ", dolaczoneAkcesoria=" + dolaczoneAkcesoria +
                ", komponentyRozszerzone=" + komponentyRozszerzone +
                ", dodatkoweInformacje=" + dodatkoweInformacje +
                ", Dźwięk=" + dzwiek +
                ", Waga=" + waga +
                ", zainstalowanySystemOperacyjny=" + zainstalowanySystemOperacyjny +
                ", dolaczoneOprogramowanie=" + dolaczoneOprogramowanie;
    }
}
