
package io.fabric8.openshift.api.model.insights.v1alpha2;

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

/**
 * persistentVolumeConfig provides configuration options for PersistentVolume storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "mountPath"
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
public class PersistentVolumeConfig implements Editable<PersistentVolumeConfigBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private PersistentVolumeClaimReference claim;
    @JsonProperty("mountPath")
    private String mountPath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PersistentVolumeConfig() {
    }

    public PersistentVolumeConfig(PersistentVolumeClaimReference claim, String mountPath) {
        super();
        this.claim = claim;
        this.mountPath = mountPath;
    }

    /**
     * persistentVolumeConfig provides configuration options for PersistentVolume storage.
     */
    @JsonProperty("claim")
    public PersistentVolumeClaimReference getClaim() {
        return claim;
    }

    /**
     * persistentVolumeConfig provides configuration options for PersistentVolume storage.
     */
    @JsonProperty("claim")
    public void setClaim(PersistentVolumeClaimReference claim) {
        this.claim = claim;
    }

    /**
     * mountPath is an optional field specifying the directory where the PVC will be mounted inside the Insights data gathering Pod. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default mount path is /var/lib/insights-operator The path may not exceed 1024 characters and must not contain a colon.
     */
    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    /**
     * mountPath is an optional field specifying the directory where the PVC will be mounted inside the Insights data gathering Pod. When omitted, this means no opinion and the platform is left to choose a reasonable default, which is subject to change over time. The current default mount path is /var/lib/insights-operator The path may not exceed 1024 characters and must not contain a colon.
     */
    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    @JsonIgnore
    public PersistentVolumeConfigBuilder edit() {
        return new PersistentVolumeConfigBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeConfigBuilder toBuilder() {
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
        if (!(o instanceof PersistentVolumeConfig)) {
            return false;
        }
        PersistentVolumeConfig other = (PersistentVolumeConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claim = this.getClaim();
        Object other$claim = other.getClaim();
        if (this$claim == null ? other$claim != null : !this$claim.equals(other$claim)) {
            return false;
        }
        Object this$mountPath = this.getMountPath();
        Object other$mountPath = other.getMountPath();
        if (this$mountPath == null ? other$mountPath != null : !this$mountPath.equals(other$mountPath)) {
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
        return other instanceof PersistentVolumeConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claim = this.getClaim();
        result = result * prime + ($claim == null ? 43 : $claim.hashCode());
        Object $mountPath = this.getMountPath();
        result = result * prime + ($mountPath == null ? 43 : $mountPath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PersistentVolumeConfig(" + "claim=" + this.getClaim() + ", mountPath=" + this.getMountPath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
