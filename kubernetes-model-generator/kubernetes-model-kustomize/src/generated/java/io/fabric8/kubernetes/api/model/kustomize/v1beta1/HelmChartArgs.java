
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "chartHome",
    "chartName",
    "chartRepoName",
    "chartRepoUrl",
    "chartVersion",
    "extraArgs",
    "helmBin",
    "helmHome",
    "releaseName",
    "releaseNamespace",
    "values",
    "valuesLocal",
    "valuesMerge"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class HelmChartArgs implements KubernetesResource
{

    @JsonProperty("chartHome")
    private java.lang.String chartHome;
    @JsonProperty("chartName")
    private java.lang.String chartName;
    @JsonProperty("chartRepoName")
    private java.lang.String chartRepoName;
    @JsonProperty("chartRepoUrl")
    private java.lang.String chartRepoUrl;
    @JsonProperty("chartVersion")
    private java.lang.String chartVersion;
    @JsonProperty("extraArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> extraArgs = new ArrayList<java.lang.String>();
    @JsonProperty("helmBin")
    private java.lang.String helmBin;
    @JsonProperty("helmHome")
    private java.lang.String helmHome;
    @JsonProperty("releaseName")
    private java.lang.String releaseName;
    @JsonProperty("releaseNamespace")
    private java.lang.String releaseNamespace;
    @JsonProperty("values")
    private java.lang.String values;
    @JsonProperty("valuesLocal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> valuesLocal = new LinkedHashMap<String, Object>();
    @JsonProperty("valuesMerge")
    private java.lang.String valuesMerge;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HelmChartArgs() {
    }

    public HelmChartArgs(java.lang.String chartHome, java.lang.String chartName, java.lang.String chartRepoName, java.lang.String chartRepoUrl, java.lang.String chartVersion, List<java.lang.String> extraArgs, java.lang.String helmBin, java.lang.String helmHome, java.lang.String releaseName, java.lang.String releaseNamespace, java.lang.String values, Map<String, Object> valuesLocal, java.lang.String valuesMerge) {
        super();
        this.chartHome = chartHome;
        this.chartName = chartName;
        this.chartRepoName = chartRepoName;
        this.chartRepoUrl = chartRepoUrl;
        this.chartVersion = chartVersion;
        this.extraArgs = extraArgs;
        this.helmBin = helmBin;
        this.helmHome = helmHome;
        this.releaseName = releaseName;
        this.releaseNamespace = releaseNamespace;
        this.values = values;
        this.valuesLocal = valuesLocal;
        this.valuesMerge = valuesMerge;
    }

    @JsonProperty("chartHome")
    public java.lang.String getChartHome() {
        return chartHome;
    }

    @JsonProperty("chartHome")
    public void setChartHome(java.lang.String chartHome) {
        this.chartHome = chartHome;
    }

    @JsonProperty("chartName")
    public java.lang.String getChartName() {
        return chartName;
    }

    @JsonProperty("chartName")
    public void setChartName(java.lang.String chartName) {
        this.chartName = chartName;
    }

    @JsonProperty("chartRepoName")
    public java.lang.String getChartRepoName() {
        return chartRepoName;
    }

    @JsonProperty("chartRepoName")
    public void setChartRepoName(java.lang.String chartRepoName) {
        this.chartRepoName = chartRepoName;
    }

    @JsonProperty("chartRepoUrl")
    public java.lang.String getChartRepoUrl() {
        return chartRepoUrl;
    }

    @JsonProperty("chartRepoUrl")
    public void setChartRepoUrl(java.lang.String chartRepoUrl) {
        this.chartRepoUrl = chartRepoUrl;
    }

    @JsonProperty("chartVersion")
    public java.lang.String getChartVersion() {
        return chartVersion;
    }

    @JsonProperty("chartVersion")
    public void setChartVersion(java.lang.String chartVersion) {
        this.chartVersion = chartVersion;
    }

    @JsonProperty("extraArgs")
    public List<java.lang.String> getExtraArgs() {
        return extraArgs;
    }

    @JsonProperty("extraArgs")
    public void setExtraArgs(List<java.lang.String> extraArgs) {
        this.extraArgs = extraArgs;
    }

    @JsonProperty("helmBin")
    public java.lang.String getHelmBin() {
        return helmBin;
    }

    @JsonProperty("helmBin")
    public void setHelmBin(java.lang.String helmBin) {
        this.helmBin = helmBin;
    }

    @JsonProperty("helmHome")
    public java.lang.String getHelmHome() {
        return helmHome;
    }

    @JsonProperty("helmHome")
    public void setHelmHome(java.lang.String helmHome) {
        this.helmHome = helmHome;
    }

    @JsonProperty("releaseName")
    public java.lang.String getReleaseName() {
        return releaseName;
    }

    @JsonProperty("releaseName")
    public void setReleaseName(java.lang.String releaseName) {
        this.releaseName = releaseName;
    }

    @JsonProperty("releaseNamespace")
    public java.lang.String getReleaseNamespace() {
        return releaseNamespace;
    }

    @JsonProperty("releaseNamespace")
    public void setReleaseNamespace(java.lang.String releaseNamespace) {
        this.releaseNamespace = releaseNamespace;
    }

    @JsonProperty("values")
    public java.lang.String getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(java.lang.String values) {
        this.values = values;
    }

    @JsonProperty("valuesLocal")
    public Map<String, Object> getValuesLocal() {
        return valuesLocal;
    }

    @JsonProperty("valuesLocal")
    public void setValuesLocal(Map<String, Object> valuesLocal) {
        this.valuesLocal = valuesLocal;
    }

    @JsonProperty("valuesMerge")
    public java.lang.String getValuesMerge() {
        return valuesMerge;
    }

    @JsonProperty("valuesMerge")
    public void setValuesMerge(java.lang.String valuesMerge) {
        this.valuesMerge = valuesMerge;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
