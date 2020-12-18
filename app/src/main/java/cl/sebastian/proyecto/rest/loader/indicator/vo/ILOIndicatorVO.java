package cl.sebastian.proyecto.rest.loader.indicator.vo;

import cl.sebastian.proyecto.rest.persistence.model.BaseBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ILOIndicatorVO extends BaseBean {

    @JsonProperty("collection")
    private String collection = null;

    @JsonProperty("collection_Label")
    private String collectionLabel = null;

    @JsonProperty("refarea")
    private String refarea = null;

    @JsonProperty("refarea_Label")
    private String refareaLabel = null;

    @JsonProperty("indicator")
    private String indicator = null;

    @JsonProperty("indicator_Label")
    private String indicatorLabel = null;

    @JsonProperty("measure")
    private String measure = null;

    @JsonProperty("measure_Label")
    private String measureLabel = null;

    @JsonProperty("classification0")
    private Object classification0 = null;

    @JsonProperty("classification0_Label")
    private String classification0Label = null;

    @JsonProperty("classification1")
    private Object classification1 = null;

    @JsonProperty("classification1_Label")
    private String classification1Label = null;

    @JsonProperty("classification2")
    private Object classification2 = null;

    @JsonProperty("classification2_Label")
    private String classification2Label = null;

    @JsonProperty("classification3")
    private Object classification3 = null;

    @JsonProperty("classification3_Label")
    private String classification3Label = null;

    @JsonProperty("classification4")
    private Object classification4 = null;

    @JsonProperty("classification4_Label")
    private String classification4Label = null;

    @JsonProperty("classification5")
    private Object classification5 = null;

    @JsonProperty("classification5_Label")
    private String classification5Label = null;

    @JsonProperty("source")
    private String source = null;

    @JsonProperty("source_Lable")
    private String sourceLable = null;

    @JsonProperty("frequency")
    private String frequency = null;

    @JsonProperty("frequency_Label")
    private String frequencyLabel = null;

    @JsonProperty("time_Period")
    private String timePeriod = null;

    @JsonProperty("obs_Value")
    private Integer obsValue = null;

    @JsonProperty("upper_Bound")
    private Object upperBound = null;

    @JsonProperty("lower_Bound")
    private Object lowerBound = null;

    @JsonProperty("obs_Status")
    private String obsStatus = null;

    @JsonProperty("obs_Status_Label")
    private String obsStatusLabel = null;

    @JsonProperty("source_Note")
    private String sourceNote = null;

    @JsonProperty("indicator_Note")
    private String indicatorNote = null;

    @JsonProperty("classification_Note")
    private String classificationNote = null;

    @JsonProperty("currency")
    private String currency = null;

    @JsonProperty("unitMeasureType")
    private String unitMeasureType = null;

    @JsonProperty("unitMeasureType_Label")
    private String unitMeasureTypeLabel = null;

    @JsonProperty("unitMeasure")
    private String unitMeasure = null;

    @JsonProperty("unitMeasure_Label")
    private String unitMeasureLabel = null;

    @JsonProperty("unitMultiplier")
    private String unitMultiplier = null;

    @JsonProperty("unitMultiplier_Label")
    private String unitMultiplierLabel = null;

    @JsonProperty("decimals")
    private Integer decimals = null;

    @JsonProperty("surveyId")
    private Integer surveyId = null;

    @JsonProperty("survey_Label")
    private String surveyLabel = null;

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getCollectionLabel() {
        return collectionLabel;
    }

    public void setCollectionLabel(String collectionLabel) {
        this.collectionLabel = collectionLabel;
    }

    public String getRefarea() {
        return refarea;
    }

    public void setRefarea(String refarea) {
        this.refarea = refarea;
    }

    public String getRefareaLabel() {
        return refareaLabel;
    }

    public void setRefareaLabel(String refareaLabel) {
        this.refareaLabel = refareaLabel;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public String getIndicatorLabel() {
        return indicatorLabel;
    }

    public void setIndicatorLabel(String indicatorLabel) {
        this.indicatorLabel = indicatorLabel;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getMeasureLabel() {
        return measureLabel;
    }

    public void setMeasureLabel(String measureLabel) {
        this.measureLabel = measureLabel;
    }

    public Object getClassification0() {
        return classification0;
    }

    public void setClassification0(Object classification0) {
        this.classification0 = classification0;
    }

    public String getClassification0Label() {
        return classification0Label;
    }

    public void setClassification0Label(String classification0Label) {
        this.classification0Label = classification0Label;
    }

    public Object getClassification1() {
        return classification1;
    }

    public void setClassification1(Object classification1) {
        this.classification1 = classification1;
    }

    public String getClassification1Label() {
        return classification1Label;
    }

    public void setClassification1Label(String classification1Label) {
        this.classification1Label = classification1Label;
    }

    public Object getClassification2() {
        return classification2;
    }

    public void setClassification2(Object classification2) {
        this.classification2 = classification2;
    }

    public String getClassification2Label() {
        return classification2Label;
    }

    public void setClassification2Label(String classification2Label) {
        this.classification2Label = classification2Label;
    }

    public Object getClassification3() {
        return classification3;
    }

    public void setClassification3(Object classification3) {
        this.classification3 = classification3;
    }

    public String getClassification3Label() {
        return classification3Label;
    }

    public void setClassification3Label(String classification3Label) {
        this.classification3Label = classification3Label;
    }

    public Object getClassification4() {
        return classification4;
    }

    public void setClassification4(Object classification4) {
        this.classification4 = classification4;
    }

    public String getClassification4Label() {
        return classification4Label;
    }

    public void setClassification4Label(String classification4Label) {
        this.classification4Label = classification4Label;
    }

    public Object getClassification5() {
        return classification5;
    }

    public void setClassification5(Object classification5) {
        this.classification5 = classification5;
    }

    public String getClassification5Label() {
        return classification5Label;
    }

    public void setClassification5Label(String classification5Label) {
        this.classification5Label = classification5Label;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceLable() {
        return sourceLable;
    }

    public void setSourceLable(String sourceLable) {
        this.sourceLable = sourceLable;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getFrequencyLabel() {
        return frequencyLabel;
    }

    public void setFrequencyLabel(String frequencyLabel) {
        this.frequencyLabel = frequencyLabel;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Integer getObsValue() {
        return obsValue;
    }

    public void setObsValue(Integer obsValue) {
        this.obsValue = obsValue;
    }

    public Object getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(Object upperBound) {
        this.upperBound = upperBound;
    }

    public Object getLowerBound() {
        return lowerBound;
    }

    public void setLowerBound(Object lowerBound) {
        this.lowerBound = lowerBound;
    }

    public String getObsStatus() {
        return obsStatus;
    }

    public void setObsStatus(String obsStatus) {
        this.obsStatus = obsStatus;
    }

    public String getObsStatusLabel() {
        return obsStatusLabel;
    }

    public void setObsStatusLabel(String obsStatusLabel) {
        this.obsStatusLabel = obsStatusLabel;
    }

    public String getSourceNote() {
        return sourceNote;
    }

    public void setSourceNote(String sourceNote) {
        this.sourceNote = sourceNote;
    }

    public String getIndicatorNote() {
        return indicatorNote;
    }

    public void setIndicatorNote(String indicatorNote) {
        this.indicatorNote = indicatorNote;
    }

    public String getClassificationNote() {
        return classificationNote;
    }

    public void setClassificationNote(String classificationNote) {
        this.classificationNote = classificationNote;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUnitMeasureType() {
        return unitMeasureType;
    }

    public void setUnitMeasureType(String unitMeasureType) {
        this.unitMeasureType = unitMeasureType;
    }

    public String getUnitMeasureTypeLabel() {
        return unitMeasureTypeLabel;
    }

    public void setUnitMeasureTypeLabel(String unitMeasureTypeLabel) {
        this.unitMeasureTypeLabel = unitMeasureTypeLabel;
    }

    public String getUnitMeasure() {
        return unitMeasure;
    }

    public void setUnitMeasure(String unitMeasure) {
        this.unitMeasure = unitMeasure;
    }

    public String getUnitMeasureLabel() {
        return unitMeasureLabel;
    }

    public void setUnitMeasureLabel(String unitMeasureLabel) {
        this.unitMeasureLabel = unitMeasureLabel;
    }

    public String getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(String unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }

    public String getUnitMultiplierLabel() {
        return unitMultiplierLabel;
    }

    public void setUnitMultiplierLabel(String unitMultiplierLabel) {
        this.unitMultiplierLabel = unitMultiplierLabel;
    }

    public Integer getDecimals() {
        return decimals;
    }

    public void setDecimals(Integer decimals) {
        this.decimals = decimals;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyLabel() {
        return surveyLabel;
    }

    public void setSurveyLabel(String surveyLabel) {
        this.surveyLabel = surveyLabel;
    }
}
