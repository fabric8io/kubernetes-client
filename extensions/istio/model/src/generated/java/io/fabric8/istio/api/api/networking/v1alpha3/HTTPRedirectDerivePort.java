
package io.fabric8.istio.api.api.networking.v1alpha3;

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
 * On a redirect, dynamically set the port: &#42; FROM_PROTOCOL_DEFAULT: automatically set to 80 for HTTP and 443 for HTTPS. &#42; FROM_REQUEST_PORT: automatically use the port of the request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "derivePort"
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
public class HTTPRedirectDerivePort implements IsHTTPRedirectRedirectPort, Editable<HTTPRedirectDerivePortBuilder>, KubernetesResource
{

    @JsonProperty("derivePort")
    private HTTPRedirectRedirectPortSelection derivePort;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HTTPRedirectDerivePort() {
    }

    public HTTPRedirectDerivePort(HTTPRedirectRedirectPortSelection derivePort) {
        super();
        this.derivePort = derivePort;
    }

    /**
     * On a redirect, dynamically set the port: &#42; FROM_PROTOCOL_DEFAULT: automatically set to 80 for HTTP and 443 for HTTPS. &#42; FROM_REQUEST_PORT: automatically use the port of the request.
     */
    @JsonProperty("derivePort")
    public HTTPRedirectRedirectPortSelection getDerivePort() {
        return derivePort;
    }

    /**
     * On a redirect, dynamically set the port: &#42; FROM_PROTOCOL_DEFAULT: automatically set to 80 for HTTP and 443 for HTTPS. &#42; FROM_REQUEST_PORT: automatically use the port of the request.
     */
    @JsonProperty("derivePort")
    public void setDerivePort(HTTPRedirectRedirectPortSelection derivePort) {
        this.derivePort = derivePort;
    }

    @JsonIgnore
    public HTTPRedirectDerivePortBuilder edit() {
        return new HTTPRedirectDerivePortBuilder(this);
    }

    @JsonIgnore
    public HTTPRedirectDerivePortBuilder toBuilder() {
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
        if (!(o instanceof HTTPRedirectDerivePort)) {
            return false;
        }
        HTTPRedirectDerivePort other = (HTTPRedirectDerivePort) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$derivePort = this.getDerivePort();
        Object other$derivePort = other.getDerivePort();
        if (this$derivePort == null ? other$derivePort != null : !this$derivePort.equals(other$derivePort)) {
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
        return other instanceof HTTPRedirectDerivePort;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $derivePort = this.getDerivePort();
        result = result * prime + ($derivePort == null ? 43 : $derivePort.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HTTPRedirectDerivePort(" + "derivePort=" + this.getDerivePort() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
