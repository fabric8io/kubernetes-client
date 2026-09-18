
package io.fabric8.kubernetes.api.model.apps;

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
 * StatefulSetPersistentVolumeClaimRetentionPolicy describes the policy used for PVCs created from the StatefulSet VolumeClaimTemplates.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "whenDeleted",
    "whenScaled"
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
public class StatefulSetPersistentVolumeClaimRetentionPolicy implements Editable<StatefulSetPersistentVolumeClaimRetentionPolicyBuilder>, KubernetesResource
{

    @JsonProperty("whenDeleted")
    private String whenDeleted;
    @JsonProperty("whenScaled")
    private String whenScaled;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public StatefulSetPersistentVolumeClaimRetentionPolicy() {
    }

    public StatefulSetPersistentVolumeClaimRetentionPolicy(String whenDeleted, String whenScaled) {
        super();
        this.whenDeleted = whenDeleted;
        this.whenScaled = whenScaled;
    }

    /**
     * WhenDeleted specifies what happens to PVCs created from StatefulSet VolumeClaimTemplates when the StatefulSet is deleted. The default policy of `Retain` causes PVCs to not be affected by StatefulSet deletion. The `Delete` policy causes those PVCs to be deleted.
     */
    @JsonProperty("whenDeleted")
    public String getWhenDeleted() {
        return whenDeleted;
    }

    /**
     * WhenDeleted specifies what happens to PVCs created from StatefulSet VolumeClaimTemplates when the StatefulSet is deleted. The default policy of `Retain` causes PVCs to not be affected by StatefulSet deletion. The `Delete` policy causes those PVCs to be deleted.
     */
    @JsonProperty("whenDeleted")
    public void setWhenDeleted(String whenDeleted) {
        this.whenDeleted = whenDeleted;
    }

    /**
     * WhenScaled specifies what happens to PVCs created from StatefulSet VolumeClaimTemplates when the StatefulSet is scaled down. The default policy of `Retain` causes PVCs to not be affected by a scaledown. The `Delete` policy causes the associated PVCs for any excess pods above the replica count to be deleted.
     */
    @JsonProperty("whenScaled")
    public String getWhenScaled() {
        return whenScaled;
    }

    /**
     * WhenScaled specifies what happens to PVCs created from StatefulSet VolumeClaimTemplates when the StatefulSet is scaled down. The default policy of `Retain` causes PVCs to not be affected by a scaledown. The `Delete` policy causes the associated PVCs for any excess pods above the replica count to be deleted.
     */
    @JsonProperty("whenScaled")
    public void setWhenScaled(String whenScaled) {
        this.whenScaled = whenScaled;
    }

    @JsonIgnore
    public StatefulSetPersistentVolumeClaimRetentionPolicyBuilder edit() {
        return new StatefulSetPersistentVolumeClaimRetentionPolicyBuilder(this);
    }

    @JsonIgnore
    public StatefulSetPersistentVolumeClaimRetentionPolicyBuilder toBuilder() {
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
        if (!(o instanceof StatefulSetPersistentVolumeClaimRetentionPolicy)) {
            return false;
        }
        StatefulSetPersistentVolumeClaimRetentionPolicy other = (StatefulSetPersistentVolumeClaimRetentionPolicy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$whenDeleted = this.getWhenDeleted();
        Object other$whenDeleted = other.getWhenDeleted();
        if (this$whenDeleted == null ? other$whenDeleted != null : !this$whenDeleted.equals(other$whenDeleted)) {
            return false;
        }
        Object this$whenScaled = this.getWhenScaled();
        Object other$whenScaled = other.getWhenScaled();
        if (this$whenScaled == null ? other$whenScaled != null : !this$whenScaled.equals(other$whenScaled)) {
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
        return other instanceof StatefulSetPersistentVolumeClaimRetentionPolicy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $whenDeleted = this.getWhenDeleted();
        result = result * prime + ($whenDeleted == null ? 43 : $whenDeleted.hashCode());
        Object $whenScaled = this.getWhenScaled();
        result = result * prime + ($whenScaled == null ? 43 : $whenScaled.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "StatefulSetPersistentVolumeClaimRetentionPolicy(" + "whenDeleted=" + this.getWhenDeleted() + ", whenScaled=" + this.getWhenScaled() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
