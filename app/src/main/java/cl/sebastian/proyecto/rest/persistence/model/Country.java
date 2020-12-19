package cl.sebastian.proyecto.rest.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author https://experti.cl
 */
@Entity
@Table(name = "countries")
public class Country extends PkEntityBase {

    @Column(name = "lang", nullable = false)
    private String lang = null;

    @Column(name = "name", nullable = false)
    private String name = null;

    @Column(name = "code", nullable = false, unique = true)
    private String code = null;

    @Column(name = "abbr", nullable = false)
    private String abbr = null;

    @Column(name = "currency_name", nullable = false)
    private String currencyName = null;

    @Column(name = "currency_iso", nullable = false)
    private String currencyIso = null;

    @Column(name = "currency_code", nullable = false)
    private Integer currencyCode = null;

    @Column(name = "decimal_precision", nullable = false)
    private Integer decimalPrecision = null;

    @Column(name = "active", nullable = false)
    private boolean active = false;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyIso() {
        return currencyIso;
    }

    public void setCurrencyIso(String currencyIso) {
        this.currencyIso = currencyIso;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getDecimalPrecision() {
        return decimalPrecision;
    }

    public void setDecimalPrecision(Integer decimalPrecision) {
        this.decimalPrecision = decimalPrecision;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
