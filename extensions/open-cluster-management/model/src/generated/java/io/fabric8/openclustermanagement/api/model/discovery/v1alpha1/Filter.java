
package io.fabric8.openclustermanagement.api.model.discovery.v1alpha1;

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

/**
 * Filter ...
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lastActive",
    "openShiftVersions"
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
public class Filter implements Editable<FilterBuilder>, KubernetesResource
{

    @JsonProperty("lastActive")
    private Integer lastActive;
    @JsonProperty("openShiftVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> openShiftVersions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Filter() {
    }

    public Filter(Integer lastActive, List<String> openShiftVersions) {
        super();
        this.lastActive = lastActive;
        this.openShiftVersions = openShiftVersions;
    }

    /**
     * LastActive is the last active in days of clusters to discover, determined by activity timestamp
     */
    @JsonProperty("lastActive")
    public Integer getLastActive() {
        return lastActive;
    }

    /**
     * LastActive is the last active in days of clusters to discover, determined by activity timestamp
     */
    @JsonProperty("lastActive")
    public void setLastActive(Integer lastActive) {
        this.lastActive = lastActive;
    }

    /**
     * OpenShiftVersions is the list of release versions of OpenShift of the form "&lt;Major&gt;.&lt;Minor&gt;"
     */
    @JsonProperty("openShiftVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOpenShiftVersions() {
        return openShiftVersions;
    }

    /**
     * OpenShiftVersions is the list of release versions of OpenShift of the form "&lt;Major&gt;.&lt;Minor&gt;"
     */
    @JsonProperty("openShiftVersions")
    public void setOpenShiftVersions(List<String> openShiftVersions) {
        this.openShiftVersions = openShiftVersions;
    }

    @JsonIgnore
    public FilterBuilder edit() {
        return new FilterBuilder(this);
    }

    @JsonIgnore
    public FilterBuilder toBuilder() {
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
        if (!(o instanceof Filter)) {
            return false;
        }
        Filter other = (Filter) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$lastActive = this.getLastActive();
        Object other$lastActive = other.getLastActive();
        if (this$lastActive == null ? other$lastActive != null : !this$lastActive.equals(other$lastActive)) {
            return false;
        }
        Object this$openShiftVersions = this.getOpenShiftVersions();
        Object other$openShiftVersions = other.getOpenShiftVersions();
        if (this$openShiftVersions == null ? other$openShiftVersions != null : !this$openShiftVersions.equals(other$openShiftVersions)) {
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
        return other instanceof Filter;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $lastActive = this.getLastActive();
        result = result * prime + ($lastActive == null ? 43 : $lastActive.hashCode());
        Object $openShiftVersions = this.getOpenShiftVersions();
        result = result * prime + ($openShiftVersions == null ? 43 : $openShiftVersions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Filter(" + "lastActive=" + this.getLastActive() + ", openShiftVersions=" + this.getOpenShiftVersions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
