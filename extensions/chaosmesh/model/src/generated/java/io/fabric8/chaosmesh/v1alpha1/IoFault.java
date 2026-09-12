
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
 * IoFault represents the fault to inject and their weight
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errno",
    "weight"
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
public class IoFault implements Editable<IoFaultBuilder>, KubernetesResource
{

    @JsonProperty("errno")
    private Long errno;
    @JsonProperty("weight")
    private Integer weight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IoFault() {
    }

    public IoFault(Long errno, Integer weight) {
        super();
        this.errno = errno;
        this.weight = weight;
    }

    /**
     * IoFault represents the fault to inject and their weight
     */
    @JsonProperty("errno")
    public Long getErrno() {
        return errno;
    }

    /**
     * IoFault represents the fault to inject and their weight
     */
    @JsonProperty("errno")
    public void setErrno(Long errno) {
        this.errno = errno;
    }

    /**
     * IoFault represents the fault to inject and their weight
     */
    @JsonProperty("weight")
    public Integer getWeight() {
        return weight;
    }

    /**
     * IoFault represents the fault to inject and their weight
     */
    @JsonProperty("weight")
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @JsonIgnore
    public IoFaultBuilder edit() {
        return new IoFaultBuilder(this);
    }

    @JsonIgnore
    public IoFaultBuilder toBuilder() {
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
        if (!(o instanceof IoFault)) {
            return false;
        }
        IoFault other = (IoFault) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$errno = this.getErrno();
        Object other$errno = other.getErrno();
        if (this$errno == null ? other$errno != null : !this$errno.equals(other$errno)) {
            return false;
        }
        Object this$weight = this.getWeight();
        Object other$weight = other.getWeight();
        if (this$weight == null ? other$weight != null : !this$weight.equals(other$weight)) {
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
        return other instanceof IoFault;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $errno = this.getErrno();
        result = result * prime + ($errno == null ? 43 : $errno.hashCode());
        Object $weight = this.getWeight();
        result = result * prime + ($weight == null ? 43 : $weight.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IoFault(" + "errno=" + this.getErrno() + ", weight=" + this.getWeight() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
