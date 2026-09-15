
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

/**
 * WebHTTPConfig defines HTTP parameters for web server.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "headers",
    "http2"
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
public class WebHTTPConfig implements Editable<WebHTTPConfigBuilder>, KubernetesResource
{

    @JsonProperty("headers")
    private WebHTTPHeaders headers;
    @JsonProperty("http2")
    private Boolean http2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebHTTPConfig() {
    }

    public WebHTTPConfig(WebHTTPHeaders headers, Boolean http2) {
        super();
        this.headers = headers;
        this.http2 = http2;
    }

    /**
     * WebHTTPConfig defines HTTP parameters for web server.
     */
    @JsonProperty("headers")
    public WebHTTPHeaders getHeaders() {
        return headers;
    }

    /**
     * WebHTTPConfig defines HTTP parameters for web server.
     */
    @JsonProperty("headers")
    public void setHeaders(WebHTTPHeaders headers) {
        this.headers = headers;
    }

    /**
     * http2 enable HTTP/2 support. Note that HTTP/2 is only supported with TLS. When TLSConfig is not configured, HTTP/2 will be disabled. Whenever the value of the field changes, a rolling update will be triggered.
     */
    @JsonProperty("http2")
    public Boolean getHttp2() {
        return http2;
    }

    /**
     * http2 enable HTTP/2 support. Note that HTTP/2 is only supported with TLS. When TLSConfig is not configured, HTTP/2 will be disabled. Whenever the value of the field changes, a rolling update will be triggered.
     */
    @JsonProperty("http2")
    public void setHttp2(Boolean http2) {
        this.http2 = http2;
    }

    @JsonIgnore
    public WebHTTPConfigBuilder edit() {
        return new WebHTTPConfigBuilder(this);
    }

    @JsonIgnore
    public WebHTTPConfigBuilder toBuilder() {
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
        if (!(o instanceof WebHTTPConfig)) {
            return false;
        }
        WebHTTPConfig other = (WebHTTPConfig) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$headers = this.getHeaders();
        Object other$headers = other.getHeaders();
        if (this$headers == null ? other$headers != null : !this$headers.equals(other$headers)) {
            return false;
        }
        Object this$http2 = this.getHttp2();
        Object other$http2 = other.getHttp2();
        if (this$http2 == null ? other$http2 != null : !this$http2.equals(other$http2)) {
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
        return other instanceof WebHTTPConfig;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $headers = this.getHeaders();
        result = result * prime + ($headers == null ? 43 : $headers.hashCode());
        Object $http2 = this.getHttp2();
        result = result * prime + ($http2 == null ? 43 : $http2.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WebHTTPConfig(" + "headers=" + this.getHeaders() + ", http2=" + this.getHttp2() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
