package cl.sebastian.proyecto.rest.loader.country.vo;

import cl.sebastian.proyecto.rest.persistence.model.BaseBean;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RestCountry extends BaseBean {

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("topLevelDomain")
    private List<String> topLevelDomain = null;

    @JsonProperty("alpha2Code")
    private String alpha2Code = null;

    @JsonProperty("alpha3Code")
    private String alpha3Code = null;

    @JsonProperty("callingCodes")
    private List<String> callingCodes = null;

    @JsonProperty("capital")
    private String capital = null;

    @JsonProperty("altSpellings")
    private List<String> altSpellings = null;

    @JsonProperty("region")
    private String region = null;

    @JsonProperty("subregion")
    private String subregion = null;

    @JsonProperty("population")
    private Integer population = null;

    @JsonProperty("latlng")
    private List<Integer> latlng = null;

    @JsonProperty("demonym")
    private String demonym = null;

    @JsonProperty("area")
    private Integer area = null;

    @JsonProperty("gini")
    private Double gini = null;

    @JsonProperty("timezones")
    private List<String> timezones = null;

    @JsonProperty("borders")
    private List<String> borders = null;

    @JsonProperty("nativeName")
    private String nativeName = null;

    @JsonProperty("numericCode")
    private String numericCode = null;

    @JsonProperty("currencies")
    private List<Currency> currencies = null;

    @JsonProperty("languages")
    private List<Language> languages = null;

    @JsonProperty("translations")
    private Translations translations = null;

    @JsonProperty("flag")
    private String flag = null;

    @JsonProperty("regionalBlocs")
    private List<RegionalBloc> regionalBlocs = null;

    @JsonProperty("cioc")
    private String cioc = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<String> getAltSpellings() {
        return altSpellings;
    }

    public void setAltSpellings(List<String> altSpellings) {
        this.altSpellings = altSpellings;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public List<Integer> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Integer> latlng) {
        this.latlng = latlng;
    }

    public String getDemonym() {
        return demonym;
    }

    public void setDemonym(String demonym) {
        this.demonym = demonym;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getGini() {
        return gini;
    }

    public void setGini(Double gini) {
        this.gini = gini;
    }

    public List<String> getTimezones() {
        return timezones;
    }

    public void setTimezones(List<String> timezones) {
        this.timezones = timezones;
    }

    public List<String> getBorders() {
        return borders;
    }

    public void setBorders(List<String> borders) {
        this.borders = borders;
    }

    public String getNativeName() {
        return nativeName;
    }

    public void setNativeName(String nativeName) {
        this.nativeName = nativeName;
    }

    public String getNumericCode() {
        return numericCode;
    }

    public void setNumericCode(String numericCode) {
        this.numericCode = numericCode;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public Translations getTranslations() {
        return translations;
    }

    public void setTranslations(Translations translations) {
        this.translations = translations;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<RegionalBloc> getRegionalBlocs() {
        return regionalBlocs;
    }

    public void setRegionalBlocs(List<RegionalBloc> regionalBlocs) {
        this.regionalBlocs = regionalBlocs;
    }

    public String getCioc() {
        return cioc;
    }

    public void setCioc(String cioc) {
        this.cioc = cioc;
    }
}
