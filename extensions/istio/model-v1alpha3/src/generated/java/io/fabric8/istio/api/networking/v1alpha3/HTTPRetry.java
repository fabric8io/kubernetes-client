
package io.fabric8.istio.api.networking.v1alpha3;

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
    "attempts",
    "perTryTimeout",
    "retryOn",
    "retryRemoteLocalities"
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
public class HTTPRetry implements KubernetesResource
{

    @JsonProperty("attempts")
    private Integer attempts;
    @JsonProperty("perTryTimeout")
    private String perTryTimeout;
    @JsonProperty("retryOn")
    private String retryOn;
    @JsonProperty("retryRemoteLocalities")
    private Boolean retryRemoteLocalities;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public HTTPRetry() {
    }

    /**
     * 
     * @param perTryTimeout
     * @param retryRemoteLocalities
     * @param attempts
     * @param retryOn
     */
    public HTTPRetry(Integer attempts, String perTryTimeout, String retryOn, Boolean retryRemoteLocalities) {
        super();
        this.attempts = attempts;
        this.perTryTimeout = perTryTimeout;
        this.retryOn = retryOn;
        this.retryRemoteLocalities = retryRemoteLocalities;
    }

    @JsonProperty("attempts")
    public Integer getAttempts() {
        return attempts;
    }

    @JsonProperty("attempts")
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    @JsonProperty("perTryTimeout")
    public String getPerTryTimeout() {
        return perTryTimeout;
    }

    @JsonProperty("perTryTimeout")
    public void setPerTryTimeout(String perTryTimeout) {
        this.perTryTimeout = perTryTimeout;
    }

    @JsonProperty("retryOn")
    public String getRetryOn() {
        return retryOn;
    }

    @JsonProperty("retryOn")
    public void setRetryOn(String retryOn) {
        this.retryOn = retryOn;
    }

    @JsonProperty("retryRemoteLocalities")
    public Boolean getRetryRemoteLocalities() {
        return retryRemoteLocalities;
    }

    @JsonProperty("retryRemoteLocalities")
    public void setRetryRemoteLocalities(Boolean retryRemoteLocalities) {
        this.retryRemoteLocalities = retryRemoteLocalities;
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
