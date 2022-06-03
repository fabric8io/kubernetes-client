
package io.fabric8.openclustermanagement.api.model.multiclusterobservabilityoperator.apps.v1beta2;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "blockDuration",
    "deleteDelay",
    "retentionInLocal",
    "retentionResolution1h",
    "retentionResolution5m",
    "retentionResolutionRaw"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class RetentionConfig implements KubernetesResource
{

    @JsonProperty("blockDuration")
    private String blockDuration;
    @JsonProperty("deleteDelay")
    private String deleteDelay;
    @JsonProperty("retentionInLocal")
    private String retentionInLocal;
    @JsonProperty("retentionResolution1h")
    private String retentionResolution1h;
    @JsonProperty("retentionResolution5m")
    private String retentionResolution5m;
    @JsonProperty("retentionResolutionRaw")
    private String retentionResolutionRaw;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RetentionConfig() {
    }

    /**
     * 
     * @param retentionInLocal
     * @param blockDuration
     * @param retentionResolution5m
     * @param deleteDelay
     * @param retentionResolution1h
     * @param retentionResolutionRaw
     */
    public RetentionConfig(String blockDuration, String deleteDelay, String retentionInLocal, String retentionResolution1h, String retentionResolution5m, String retentionResolutionRaw) {
        super();
        this.blockDuration = blockDuration;
        this.deleteDelay = deleteDelay;
        this.retentionInLocal = retentionInLocal;
        this.retentionResolution1h = retentionResolution1h;
        this.retentionResolution5m = retentionResolution5m;
        this.retentionResolutionRaw = retentionResolutionRaw;
    }

    @JsonProperty("blockDuration")
    public String getBlockDuration() {
        return blockDuration;
    }

    @JsonProperty("blockDuration")
    public void setBlockDuration(String blockDuration) {
        this.blockDuration = blockDuration;
    }

    @JsonProperty("deleteDelay")
    public String getDeleteDelay() {
        return deleteDelay;
    }

    @JsonProperty("deleteDelay")
    public void setDeleteDelay(String deleteDelay) {
        this.deleteDelay = deleteDelay;
    }

    @JsonProperty("retentionInLocal")
    public String getRetentionInLocal() {
        return retentionInLocal;
    }

    @JsonProperty("retentionInLocal")
    public void setRetentionInLocal(String retentionInLocal) {
        this.retentionInLocal = retentionInLocal;
    }

    @JsonProperty("retentionResolution1h")
    public String getRetentionResolution1h() {
        return retentionResolution1h;
    }

    @JsonProperty("retentionResolution1h")
    public void setRetentionResolution1h(String retentionResolution1h) {
        this.retentionResolution1h = retentionResolution1h;
    }

    @JsonProperty("retentionResolution5m")
    public String getRetentionResolution5m() {
        return retentionResolution5m;
    }

    @JsonProperty("retentionResolution5m")
    public void setRetentionResolution5m(String retentionResolution5m) {
        this.retentionResolution5m = retentionResolution5m;
    }

    @JsonProperty("retentionResolutionRaw")
    public String getRetentionResolutionRaw() {
        return retentionResolutionRaw;
    }

    @JsonProperty("retentionResolutionRaw")
    public void setRetentionResolutionRaw(String retentionResolutionRaw) {
        this.retentionResolutionRaw = retentionResolutionRaw;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
