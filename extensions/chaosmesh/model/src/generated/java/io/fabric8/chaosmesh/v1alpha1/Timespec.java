
package io.fabric8.chaosmesh.v1alpha1;

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

/**
 * Timespec represents a time
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nsec",
    "sec"
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
public class Timespec implements Editable<TimespecBuilder>, KubernetesResource
{

    @JsonProperty("nsec")
    private Long nsec;
    @JsonProperty("sec")
    private Long sec;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Timespec() {
    }

    public Timespec(Long nsec, Long sec) {
        super();
        this.nsec = nsec;
        this.sec = sec;
    }

    /**
     * Timespec represents a time
     */
    @JsonProperty("nsec")
    public Long getNsec() {
        return nsec;
    }

    /**
     * Timespec represents a time
     */
    @JsonProperty("nsec")
    public void setNsec(Long nsec) {
        this.nsec = nsec;
    }

    /**
     * Timespec represents a time
     */
    @JsonProperty("sec")
    public Long getSec() {
        return sec;
    }

    /**
     * Timespec represents a time
     */
    @JsonProperty("sec")
    public void setSec(Long sec) {
        this.sec = sec;
    }

    @JsonIgnore
    public TimespecBuilder edit() {
        return new TimespecBuilder(this);
    }

    @JsonIgnore
    public TimespecBuilder toBuilder() {
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
        if (!(o instanceof Timespec)) {
            return false;
        }
        Timespec other = (Timespec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$nsec = this.getNsec();
        Object other$nsec = other.getNsec();
        if (this$nsec == null ? other$nsec != null : !this$nsec.equals(other$nsec)) {
            return false;
        }
        Object this$sec = this.getSec();
        Object other$sec = other.getSec();
        if (this$sec == null ? other$sec != null : !this$sec.equals(other$sec)) {
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
        return other instanceof Timespec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $nsec = this.getNsec();
        result = result * prime + ($nsec == null ? 43 : $nsec.hashCode());
        Object $sec = this.getSec();
        result = result * prime + ($sec == null ? 43 : $sec.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Timespec(" + "nsec=" + this.getNsec() + ", sec=" + this.getSec() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
