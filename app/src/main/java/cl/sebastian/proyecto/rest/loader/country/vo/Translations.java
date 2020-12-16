package cl.sebastian.proyecto.rest.loader.country.vo;

import cl.sebastian.proyecto.rest.persistence.model.BaseBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Translations extends BaseBean {

    @JsonProperty("de")
    private String de = null;

    @JsonProperty("es")
    private String es = null;

    @JsonProperty("fr")
    private String fr = null;

    @JsonProperty("ja")
    private String ja = null;

    @JsonProperty("it")
    private String it = null;

    @JsonProperty("br")
    private String br = null;

    @JsonProperty("pt")
    private String pt = null;

    @JsonProperty("nl")
    private String nl = null;

    @JsonProperty("hr")
    private String hr = null;

    @JsonProperty("fa")
    private String fa = null;

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    public String getEs() {
        return es;
    }

    public void setEs(String es) {
        this.es = es;
    }

    public String getFr() {
        return fr;
    }

    public void setFr(String fr) {
        this.fr = fr;
    }

    public String getJa() {
        return ja;
    }

    public void setJa(String ja) {
        this.ja = ja;
    }

    public String getIt() {
        return it;
    }

    public void setIt(String it) {
        this.it = it;
    }

    public String getBr() {
        return br;
    }

    public void setBr(String br) {
        this.br = br;
    }

    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getHr() {
        return hr;
    }

    public void setHr(String hr) {
        this.hr = hr;
    }

    public String getFa() {
        return fa;
    }

    public void setFa(String fa) {
        this.fa = fa;
    }
}
