
package io.fabric8.knative.internal.networking.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Duration;
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
 * HTTPRetry is DEPRECATED. Retry is not used in KIngress.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attempts",
    "perTryTimeout"
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
public class HTTPRetry implements Editable<HTTPRetryBuilder>, KubernetesResource
{

    @JsonProperty("attempts")
    private Integer attempts;
    @JsonProperty("perTryTimeout")
    private Duration perTryTimeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRetry() {
    }

    public HTTPRetry(Integer attempts, Duration perTryTimeout) {
        super();
        this.attempts = attempts;
        this.perTryTimeout = perTryTimeout;
    }

    /**
     * Number of retries for a given request.
     */
    @JsonProperty("attempts")
    public Integer getAttempts() {
        return attempts;
    }

    /**
     * Number of retries for a given request.
     */
    @JsonProperty("attempts")
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    /**
     * HTTPRetry is DEPRECATED. Retry is not used in KIngress.
     */
    @JsonProperty("perTryTimeout")
    public Duration getPerTryTimeout() {
        return perTryTimeout;
    }

    /**
     * HTTPRetry is DEPRECATED. Retry is not used in KIngress.
     */
    @JsonProperty("perTryTimeout")
    public void setPerTryTimeout(Duration perTryTimeout) {
        this.perTryTimeout = perTryTimeout;
    }

    @JsonIgnore
    public HTTPRetryBuilder edit() {
        return new HTTPRetryBuilder(this);
    }

    @JsonIgnore
    public HTTPRetryBuilder toBuilder() {
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
        if (!(o instanceof HTTPRetry)) {
            return false;
        }
        HTTPRetry other = (HTTPRetry) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attempts = this.getAttempts();
        Object other$attempts = other.getAttempts();
        if (this$attempts == null ? other$attempts != null : !this$attempts.equals(other$attempts)) {
            return false;
        }
        Object this$perTryTimeout = this.getPerTryTimeout();
        Object other$perTryTimeout = other.getPerTryTimeout();
        if (this$perTryTimeout == null ? other$perTryTimeout != null : !this$perTryTimeout.equals(other$perTryTimeout)) {
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
        return other instanceof HTTPRetry;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attempts = this.getAttempts();
        result = result * prime + ($attempts == null ? 43 : $attempts.hashCode());
        Object $perTryTimeout = this.getPerTryTimeout();
        result = result * prime + ($perTryTimeout == null ? 43 : $perTryTimeout.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPRetry(" + "attempts=" + this.getAttempts() + ", perTryTimeout=" + this.getPerTryTimeout() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
