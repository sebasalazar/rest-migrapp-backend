package cl.sebastian.proyecto.rest.persistence.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "indicators", uniqueConstraints = @UniqueConstraint(columnNames = {"country_fk", "code", "year"}))
public class Indicator extends PkEntityBase {

    @JoinColumn(name = "country_fk", referencedColumnName = "pk", nullable = false)
    @ManyToOne
    private Country country = null;

    @Column(name = "code", nullable = false)
    private Code code = null;

    @Column(name = "year", nullable = false)
    private Integer year = null;

    @Column(name = "value", nullable = false)
    private BigDecimal value = null;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
