
package io.fabric8.openshift.api.model.hive.v1;

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
 * SecretMapping defines a source and destination for a secret to be synced by a SyncSet
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sourceRef",
    "targetRef"
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
public class SecretMapping implements Editable<SecretMappingBuilder>, KubernetesResource
{

    @JsonProperty("sourceRef")
    private SecretReference sourceRef;
    @JsonProperty("targetRef")
    private SecretReference targetRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SecretMapping() {
    }

    public SecretMapping(SecretReference sourceRef, SecretReference targetRef) {
        super();
        this.sourceRef = sourceRef;
        this.targetRef = targetRef;
    }

    /**
     * SecretMapping defines a source and destination for a secret to be synced by a SyncSet
     */
    @JsonProperty("sourceRef")
    public SecretReference getSourceRef() {
        return sourceRef;
    }

    /**
     * SecretMapping defines a source and destination for a secret to be synced by a SyncSet
     */
    @JsonProperty("sourceRef")
    public void setSourceRef(SecretReference sourceRef) {
        this.sourceRef = sourceRef;
    }

    /**
     * SecretMapping defines a source and destination for a secret to be synced by a SyncSet
     */
    @JsonProperty("targetRef")
    public SecretReference getTargetRef() {
        return targetRef;
    }

    /**
     * SecretMapping defines a source and destination for a secret to be synced by a SyncSet
     */
    @JsonProperty("targetRef")
    public void setTargetRef(SecretReference targetRef) {
        this.targetRef = targetRef;
    }

    @JsonIgnore
    public SecretMappingBuilder edit() {
        return new SecretMappingBuilder(this);
    }

    @JsonIgnore
    public SecretMappingBuilder toBuilder() {
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
        if (!(o instanceof SecretMapping)) {
            return false;
        }
        SecretMapping other = (SecretMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$sourceRef = this.getSourceRef();
        Object other$sourceRef = other.getSourceRef();
        if (this$sourceRef == null ? other$sourceRef != null : !this$sourceRef.equals(other$sourceRef)) {
            return false;
        }
        Object this$targetRef = this.getTargetRef();
        Object other$targetRef = other.getTargetRef();
        if (this$targetRef == null ? other$targetRef != null : !this$targetRef.equals(other$targetRef)) {
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
        return other instanceof SecretMapping;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $sourceRef = this.getSourceRef();
        result = result * prime + ($sourceRef == null ? 43 : $sourceRef.hashCode());
        Object $targetRef = this.getTargetRef();
        result = result * prime + ($targetRef == null ? 43 : $targetRef.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SecretMapping(" + "sourceRef=" + this.getSourceRef() + ", targetRef=" + this.getTargetRef() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
