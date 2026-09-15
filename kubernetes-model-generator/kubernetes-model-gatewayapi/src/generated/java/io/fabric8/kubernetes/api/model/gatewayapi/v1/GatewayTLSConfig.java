
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * GatewayTLSConfig specifies frontend and backend tls configuration for gateway.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "backend",
    "frontend"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class GatewayTLSConfig implements Editable<GatewayTLSConfigBuilder>, KubernetesResource
{

    @JsonProperty("backend")
    private GatewayBackendTLS backend;
    @JsonProperty("frontend")
    private FrontendTLSConfig frontend;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public GatewayTLSConfig() {
    }

    public GatewayTLSConfig(GatewayBackendTLS backend, FrontendTLSConfig frontend) {
        super();
        this.backend = backend;
        this.frontend = frontend;
    }

    /**
     * GatewayTLSConfig specifies frontend and backend tls configuration for gateway.
     */
    @JsonProperty("backend")
    public GatewayBackendTLS getBackend() {
        return backend;
    }

    /**
     * GatewayTLSConfig specifies frontend and backend tls configuration for gateway.
     */
    @JsonProperty("backend")
    public void setBackend(GatewayBackendTLS backend) {
        this.backend = backend;
    }

    /**
     * GatewayTLSConfig specifies frontend and backend tls configuration for gateway.
     */
    @JsonProperty("frontend")
    public FrontendTLSConfig getFrontend() {
        return frontend;
    }

    /**
     * GatewayTLSConfig specifies frontend and backend tls configuration for gateway.
     */
    @JsonProperty("frontend")
    public void setFrontend(FrontendTLSConfig frontend) {
        this.frontend = frontend;
    }

    @JsonIgnore
    public GatewayTLSConfigBuilder edit() {
        return new GatewayTLSConfigBuilder(this);
    }

    @JsonIgnore
    public GatewayTLSConfigBuilder toBuilder() {
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
        if (!(o instanceof GatewayTLSConfig)) {
            return false;
        }
        GatewayTLSConfig other = (GatewayTLSConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$backend = this.getBackend();
        Object other$backend = other.getBackend();
        if (this$backend == null ? other$backend != null : !this$backend.equals(other$backend)) {
            return false;
        }
        Object this$frontend = this.getFrontend();
        Object other$frontend = other.getFrontend();
        if (this$frontend == null ? other$frontend != null : !this$frontend.equals(other$frontend)) {
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
        return other instanceof GatewayTLSConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $backend = this.getBackend();
        result = result * prime + ($backend == null ? 43 : $backend.hashCode());
        Object $frontend = this.getFrontend();
        result = result * prime + ($frontend == null ? 43 : $frontend.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "GatewayTLSConfig(" + "backend=" + this.getBackend() + ", frontend=" + this.getFrontend() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
