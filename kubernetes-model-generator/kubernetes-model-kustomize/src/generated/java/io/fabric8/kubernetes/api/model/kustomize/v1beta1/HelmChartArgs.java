
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
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
    @JsonIgnore
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HelmChartArgs)) {
            return false;
        }
        HelmChartArgs other = (HelmChartArgs) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$chartHome = this.getChartHome();
        Object other$chartHome = other.getChartHome();
        if (this$chartHome == null ? other$chartHome != null : !this$chartHome.equals(other$chartHome)) {
            return false;
        }
        Object this$chartName = this.getChartName();
        Object other$chartName = other.getChartName();
        if (this$chartName == null ? other$chartName != null : !this$chartName.equals(other$chartName)) {
            return false;
        }
        Object this$chartRepoName = this.getChartRepoName();
        Object other$chartRepoName = other.getChartRepoName();
        if (this$chartRepoName == null ? other$chartRepoName != null : !this$chartRepoName.equals(other$chartRepoName)) {
            return false;
        }
        Object this$chartRepoUrl = this.getChartRepoUrl();
        Object other$chartRepoUrl = other.getChartRepoUrl();
        if (this$chartRepoUrl == null ? other$chartRepoUrl != null : !this$chartRepoUrl.equals(other$chartRepoUrl)) {
            return false;
        }
        Object this$chartVersion = this.getChartVersion();
        Object other$chartVersion = other.getChartVersion();
        if (this$chartVersion == null ? other$chartVersion != null : !this$chartVersion.equals(other$chartVersion)) {
            return false;
        }
        Object this$extraArgs = this.getExtraArgs();
        Object other$extraArgs = other.getExtraArgs();
        if (this$extraArgs == null ? other$extraArgs != null : !this$extraArgs.equals(other$extraArgs)) {
            return false;
        }
        Object this$helmBin = this.getHelmBin();
        Object other$helmBin = other.getHelmBin();
        if (this$helmBin == null ? other$helmBin != null : !this$helmBin.equals(other$helmBin)) {
            return false;
        }
        Object this$helmHome = this.getHelmHome();
        Object other$helmHome = other.getHelmHome();
        if (this$helmHome == null ? other$helmHome != null : !this$helmHome.equals(other$helmHome)) {
            return false;
        }
        Object this$releaseName = this.getReleaseName();
        Object other$releaseName = other.getReleaseName();
        if (this$releaseName == null ? other$releaseName != null : !this$releaseName.equals(other$releaseName)) {
            return false;
        }
        Object this$releaseNamespace = this.getReleaseNamespace();
        Object other$releaseNamespace = other.getReleaseNamespace();
        if (this$releaseNamespace == null ? other$releaseNamespace != null : !this$releaseNamespace.equals(other$releaseNamespace)) {
            return false;
        }
        Object this$values = this.getValues();
        Object other$values = other.getValues();
        if (this$values == null ? other$values != null : !this$values.equals(other$values)) {
            return false;
        }
        Object this$valuesLocal = this.getValuesLocal();
        Object other$valuesLocal = other.getValuesLocal();
        if (this$valuesLocal == null ? other$valuesLocal != null : !this$valuesLocal.equals(other$valuesLocal)) {
            return false;
        }
        Object this$valuesMerge = this.getValuesMerge();
        Object other$valuesMerge = other.getValuesMerge();
        if (this$valuesMerge == null ? other$valuesMerge != null : !this$valuesMerge.equals(other$valuesMerge)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof HelmChartArgs;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $chartHome = this.getChartHome();
        result = result * prime + ($chartHome == null ? 43 : $chartHome.hashCode());
        Object $chartName = this.getChartName();
        result = result * prime + ($chartName == null ? 43 : $chartName.hashCode());
        Object $chartRepoName = this.getChartRepoName();
        result = result * prime + ($chartRepoName == null ? 43 : $chartRepoName.hashCode());
        Object $chartRepoUrl = this.getChartRepoUrl();
        result = result * prime + ($chartRepoUrl == null ? 43 : $chartRepoUrl.hashCode());
        Object $chartVersion = this.getChartVersion();
        result = result * prime + ($chartVersion == null ? 43 : $chartVersion.hashCode());
        Object $extraArgs = this.getExtraArgs();
        result = result * prime + ($extraArgs == null ? 43 : $extraArgs.hashCode());
        Object $helmBin = this.getHelmBin();
        result = result * prime + ($helmBin == null ? 43 : $helmBin.hashCode());
        Object $helmHome = this.getHelmHome();
        result = result * prime + ($helmHome == null ? 43 : $helmHome.hashCode());
        Object $releaseName = this.getReleaseName();
        result = result * prime + ($releaseName == null ? 43 : $releaseName.hashCode());
        Object $releaseNamespace = this.getReleaseNamespace();
        result = result * prime + ($releaseNamespace == null ? 43 : $releaseNamespace.hashCode());
        Object $values = this.getValues();
        result = result * prime + ($values == null ? 43 : $values.hashCode());
        Object $valuesLocal = this.getValuesLocal();
        result = result * prime + ($valuesLocal == null ? 43 : $valuesLocal.hashCode());
        Object $valuesMerge = this.getValuesMerge();
        result = result * prime + ($valuesMerge == null ? 43 : $valuesMerge.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HelmChartArgs(" + "chartHome=" + this.getChartHome() + ", chartName=" + this.getChartName() + ", chartRepoName=" + this.getChartRepoName() + ", chartRepoUrl=" + this.getChartRepoUrl() + ", chartVersion=" + this.getChartVersion() + ", extraArgs=" + this.getExtraArgs() + ", helmBin=" + this.getHelmBin() + ", helmHome=" + this.getHelmHome() + ", releaseName=" + this.getReleaseName() + ", releaseNamespace=" + this.getReleaseNamespace() + ", values=" + this.getValues() + ", valuesLocal=" + this.getValuesLocal() + ", valuesMerge=" + this.getValuesMerge() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
