package cl.sebastian.proyecto.rest.loader.indicator.vo;

import cl.sebastian.proyecto.rest.persistence.model.BaseBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author https://experti.cl
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WBPageVO extends BaseBean {

    @JsonProperty("page")
    private Integer page = null;

    @JsonProperty("pages")
    private Integer pages = null;

    @JsonProperty("per_page")
    private Integer perPage = null;

    @JsonProperty("total")
    private Integer total = null;

    @JsonProperty("sourceid")
    private String sourceid = null;

    @JsonProperty("lastupdated")
    private String lastupdated = null;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getPerPage() {
        return perPage;
    }

    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }
}
