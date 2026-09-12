
package io.fabric8.openshift.api.model.monitoring.v1;

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
    "maxSize"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Exemplars implements Editable<ExemplarsBuilder>, KubernetesResource
{

    @JsonProperty("maxSize")
    private Long maxSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Exemplars() {
    }

    public Exemplars(Long maxSize) {
        super();
        this.maxSize = maxSize;
    }

    /**
     * maxSize defines the maximum number of exemplars stored in memory for all series.<br><p> <br><p> exemplar-storage itself must be enabled using the `spec.enableFeature` option for exemplars to be scraped in the first place.<br><p> <br><p> If not set, Prometheus uses its default value. A value of zero or less than zero disables the storage.
     */
    @JsonProperty("maxSize")
    public Long getMaxSize() {
        return maxSize;
    }

    /**
     * maxSize defines the maximum number of exemplars stored in memory for all series.<br><p> <br><p> exemplar-storage itself must be enabled using the `spec.enableFeature` option for exemplars to be scraped in the first place.<br><p> <br><p> If not set, Prometheus uses its default value. A value of zero or less than zero disables the storage.
     */
    @JsonProperty("maxSize")
    public void setMaxSize(Long maxSize) {
        this.maxSize = maxSize;
    }

    @JsonIgnore
    public ExemplarsBuilder edit() {
        return new ExemplarsBuilder(this);
    }

    @JsonIgnore
    public ExemplarsBuilder toBuilder() {
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
        if (!(o instanceof Exemplars)) {
            return false;
        }
        Exemplars other = (Exemplars) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$maxSize = this.getMaxSize();
        Object other$maxSize = other.getMaxSize();
        if (this$maxSize == null ? other$maxSize != null : !this$maxSize.equals(other$maxSize)) {
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
        return other instanceof Exemplars;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $maxSize = this.getMaxSize();
        result = result * prime + ($maxSize == null ? 43 : $maxSize.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Exemplars(" + "maxSize=" + this.getMaxSize() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
