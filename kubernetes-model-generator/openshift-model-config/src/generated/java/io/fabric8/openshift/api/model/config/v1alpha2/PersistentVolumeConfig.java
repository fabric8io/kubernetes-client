
package io.fabric8.openshift.api.model.config.v1alpha2;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * persistentVolumeConfig provides configuration options for PersistentVolume storage.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "mountPath"
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

}
