
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

import java.util.LinkedHashMap;
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
    "configHome"
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
public class HelmGlobals implements Editable<HelmGlobalsBuilder>, KubernetesResource
{

    @JsonProperty("chartHome")
    private String chartHome;
    @JsonProperty("configHome")
    private String configHome;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HelmGlobals() {
    }

    public HelmGlobals(String chartHome, String configHome) {
        super();
        this.chartHome = chartHome;
        this.configHome = configHome;
    }

    @JsonProperty("chartHome")
    public String getChartHome() {
        return chartHome;
    }

    @JsonProperty("chartHome")
    public void setChartHome(String chartHome) {
        this.chartHome = chartHome;
    }

    @JsonProperty("configHome")
    public String getConfigHome() {
        return configHome;
    }

    @JsonProperty("configHome")
    public void setConfigHome(String configHome) {
        this.configHome = configHome;
    }

    @JsonIgnore
    public HelmGlobalsBuilder edit() {
        return new HelmGlobalsBuilder(this);
    }

    @JsonIgnore
    public HelmGlobalsBuilder toBuilder() {
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
        if (!(o instanceof HelmGlobals)) {
            return false;
        }
        HelmGlobals other = (HelmGlobals) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$chartHome = this.getChartHome();
        Object other$chartHome = other.getChartHome();
        if (this$chartHome == null ? other$chartHome != null : !this$chartHome.equals(other$chartHome)) {
            return false;
        }
        Object this$configHome = this.getConfigHome();
        Object other$configHome = other.getConfigHome();
        if (this$configHome == null ? other$configHome != null : !this$configHome.equals(other$configHome)) {
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
        return other instanceof HelmGlobals;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $chartHome = this.getChartHome();
        result = result * prime + ($chartHome == null ? 43 : $chartHome.hashCode());
        Object $configHome = this.getConfigHome();
        result = result * prime + ($configHome == null ? 43 : $configHome.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HelmGlobals(" + "chartHome=" + this.getChartHome() + ", configHome=" + this.getConfigHome() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
