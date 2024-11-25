
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class HelmChartArgs implements Editable<HelmChartArgsBuilder>, KubernetesResource
{

    @JsonProperty("chartHome")
    private String chartHome;
    @JsonProperty("chartName")
    private String chartName;
    @JsonProperty("chartRepoName")
    private String chartRepoName;
    @JsonProperty("chartRepoUrl")
    private String chartRepoUrl;
    @JsonProperty("chartVersion")
    private String chartVersion;
    @JsonProperty("extraArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> extraArgs = new ArrayList<>();
    @JsonProperty("helmBin")
    private String helmBin;
    @JsonProperty("helmHome")
    private String helmHome;
    @JsonProperty("releaseName")
    private String releaseName;
    @JsonProperty("releaseNamespace")
    private String releaseNamespace;
    @JsonProperty("values")
    private String values;
    @JsonProperty("valuesLocal")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Object> valuesLocal = new LinkedHashMap<>();
    @JsonProperty("valuesMerge")
    private String valuesMerge;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HelmChartArgs() {
    }

    public HelmChartArgs(String chartHome, String chartName, String chartRepoName, String chartRepoUrl, String chartVersion, List<String> extraArgs, String helmBin, String helmHome, String releaseName, String releaseNamespace, String values, Map<String, Object> valuesLocal, String valuesMerge) {
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
    public String getChartHome() {
        return chartHome;
    }

    @JsonProperty("chartHome")
    public void setChartHome(String chartHome) {
        this.chartHome = chartHome;
    }

    @JsonProperty("chartName")
    public String getChartName() {
        return chartName;
    }

    @JsonProperty("chartName")
    public void setChartName(String chartName) {
        this.chartName = chartName;
    }

    @JsonProperty("chartRepoName")
    public String getChartRepoName() {
        return chartRepoName;
    }

    @JsonProperty("chartRepoName")
    public void setChartRepoName(String chartRepoName) {
        this.chartRepoName = chartRepoName;
    }

    @JsonProperty("chartRepoUrl")
    public String getChartRepoUrl() {
        return chartRepoUrl;
    }

    @JsonProperty("chartRepoUrl")
    public void setChartRepoUrl(String chartRepoUrl) {
        this.chartRepoUrl = chartRepoUrl;
    }

    @JsonProperty("chartVersion")
    public String getChartVersion() {
        return chartVersion;
    }

    @JsonProperty("chartVersion")
    public void setChartVersion(String chartVersion) {
        this.chartVersion = chartVersion;
    }

    @JsonProperty("extraArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExtraArgs() {
        return extraArgs;
    }

    @JsonProperty("extraArgs")
    public void setExtraArgs(List<String> extraArgs) {
        this.extraArgs = extraArgs;
    }

    @JsonProperty("helmBin")
    public String getHelmBin() {
        return helmBin;
    }

    @JsonProperty("helmBin")
    public void setHelmBin(String helmBin) {
        this.helmBin = helmBin;
    }

    @JsonProperty("helmHome")
    public String getHelmHome() {
        return helmHome;
    }

    @JsonProperty("helmHome")
    public void setHelmHome(String helmHome) {
        this.helmHome = helmHome;
    }

    @JsonProperty("releaseName")
    public String getReleaseName() {
        return releaseName;
    }

    @JsonProperty("releaseName")
    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
    }

    @JsonProperty("releaseNamespace")
    public String getReleaseNamespace() {
        return releaseNamespace;
    }

    @JsonProperty("releaseNamespace")
    public void setReleaseNamespace(String releaseNamespace) {
        this.releaseNamespace = releaseNamespace;
    }

    @JsonProperty("values")
    public String getValues() {
        return values;
    }

    @JsonProperty("values")
    public void setValues(String values) {
        this.values = values;
    }

    @JsonProperty("valuesLocal")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Object> getValuesLocal() {
        return valuesLocal;
    }

    @JsonProperty("valuesLocal")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializerForMap.class)
    public void setValuesLocal(Map<String, Object> valuesLocal) {
        this.valuesLocal = valuesLocal;
    }

    @JsonProperty("valuesMerge")
    public String getValuesMerge() {
        return valuesMerge;
    }

    @JsonProperty("valuesMerge")
    public void setValuesMerge(String valuesMerge) {
        this.valuesMerge = valuesMerge;
    }

    @JsonIgnore
    public HelmChartArgsBuilder edit() {
        return new HelmChartArgsBuilder(this);
    }

    @JsonIgnore
    public HelmChartArgsBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
