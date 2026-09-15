
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
 * WebHTTPHeaders defines the list of headers that can be added to HTTP responses.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "contentSecurityPolicy",
    "strictTransportSecurity",
    "xContentTypeOptions",
    "xFrameOptions",
    "xXSSProtection"
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
public class WebHTTPHeaders implements Editable<WebHTTPHeadersBuilder>, KubernetesResource
{

    @JsonProperty("contentSecurityPolicy")
    private String contentSecurityPolicy;
    @JsonProperty("strictTransportSecurity")
    private String strictTransportSecurity;
    @JsonProperty("xContentTypeOptions")
    private String xContentTypeOptions;
    @JsonProperty("xFrameOptions")
    private String xFrameOptions;
    @JsonProperty("xXSSProtection")
    private String xXSSProtection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public WebHTTPHeaders() {
    }

    public WebHTTPHeaders(String contentSecurityPolicy, String strictTransportSecurity, String xContentTypeOptions, String xFrameOptions, String xXSSProtection) {
        super();
        this.contentSecurityPolicy = contentSecurityPolicy;
        this.strictTransportSecurity = strictTransportSecurity;
        this.xContentTypeOptions = xContentTypeOptions;
        this.xFrameOptions = xFrameOptions;
        this.xXSSProtection = xXSSProtection;
    }

    /**
     * contentSecurityPolicy defines the Content-Security-Policy header to HTTP responses. Unset if blank.
     */
    @JsonProperty("contentSecurityPolicy")
    public String getContentSecurityPolicy() {
        return contentSecurityPolicy;
    }

    /**
     * contentSecurityPolicy defines the Content-Security-Policy header to HTTP responses. Unset if blank.
     */
    @JsonProperty("contentSecurityPolicy")
    public void setContentSecurityPolicy(String contentSecurityPolicy) {
        this.contentSecurityPolicy = contentSecurityPolicy;
    }

    /**
     * strictTransportSecurity defines the Strict-Transport-Security header to HTTP responses. Unset if blank. Please make sure that you use this with care as this header might force browsers to load Prometheus and the other applications hosted on the same domain and subdomains over HTTPS. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security
     */
    @JsonProperty("strictTransportSecurity")
    public String getStrictTransportSecurity() {
        return strictTransportSecurity;
    }

    /**
     * strictTransportSecurity defines the Strict-Transport-Security header to HTTP responses. Unset if blank. Please make sure that you use this with care as this header might force browsers to load Prometheus and the other applications hosted on the same domain and subdomains over HTTPS. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security
     */
    @JsonProperty("strictTransportSecurity")
    public void setStrictTransportSecurity(String strictTransportSecurity) {
        this.strictTransportSecurity = strictTransportSecurity;
    }

    /**
     * xContentTypeOptions defines the X-Content-Type-Options header to HTTP responses. Unset if blank. Accepted value is nosniff. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options
     */
    @JsonProperty("xContentTypeOptions")
    public String getXContentTypeOptions() {
        return xContentTypeOptions;
    }

    /**
     * xContentTypeOptions defines the X-Content-Type-Options header to HTTP responses. Unset if blank. Accepted value is nosniff. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options
     */
    @JsonProperty("xContentTypeOptions")
    public void setXContentTypeOptions(String xContentTypeOptions) {
        this.xContentTypeOptions = xContentTypeOptions;
    }

    /**
     * xFrameOptions defines the X-Frame-Options header to HTTP responses. Unset if blank. Accepted values are deny and sameorigin. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options
     */
    @JsonProperty("xFrameOptions")
    public String getXFrameOptions() {
        return xFrameOptions;
    }

    /**
     * xFrameOptions defines the X-Frame-Options header to HTTP responses. Unset if blank. Accepted values are deny and sameorigin. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options
     */
    @JsonProperty("xFrameOptions")
    public void setXFrameOptions(String xFrameOptions) {
        this.xFrameOptions = xFrameOptions;
    }

    /**
     * xXSSProtection defines the X-XSS-Protection header to all responses. Unset if blank. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection
     */
    @JsonProperty("xXSSProtection")
    public String getXXSSProtection() {
        return xXSSProtection;
    }

    /**
     * xXSSProtection defines the X-XSS-Protection header to all responses. Unset if blank. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection
     */
    @JsonProperty("xXSSProtection")
    public void setXXSSProtection(String xXSSProtection) {
        this.xXSSProtection = xXSSProtection;
    }

    @JsonIgnore
    public WebHTTPHeadersBuilder edit() {
        return new WebHTTPHeadersBuilder(this);
    }

    @JsonIgnore
    public WebHTTPHeadersBuilder toBuilder() {
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
        if (!(o instanceof WebHTTPHeaders)) {
            return false;
        }
        WebHTTPHeaders other = (WebHTTPHeaders) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$contentSecurityPolicy = this.getContentSecurityPolicy();
        Object other$contentSecurityPolicy = other.getContentSecurityPolicy();
        if (this$contentSecurityPolicy == null ? other$contentSecurityPolicy != null : !this$contentSecurityPolicy.equals(other$contentSecurityPolicy)) {
            return false;
        }
        Object this$strictTransportSecurity = this.getStrictTransportSecurity();
        Object other$strictTransportSecurity = other.getStrictTransportSecurity();
        if (this$strictTransportSecurity == null ? other$strictTransportSecurity != null : !this$strictTransportSecurity.equals(other$strictTransportSecurity)) {
            return false;
        }
        Object this$xContentTypeOptions = this.getXContentTypeOptions();
        Object other$xContentTypeOptions = other.getXContentTypeOptions();
        if (this$xContentTypeOptions == null ? other$xContentTypeOptions != null : !this$xContentTypeOptions.equals(other$xContentTypeOptions)) {
            return false;
        }
        Object this$xFrameOptions = this.getXFrameOptions();
        Object other$xFrameOptions = other.getXFrameOptions();
        if (this$xFrameOptions == null ? other$xFrameOptions != null : !this$xFrameOptions.equals(other$xFrameOptions)) {
            return false;
        }
        Object this$xXSSProtection = this.getXXSSProtection();
        Object other$xXSSProtection = other.getXXSSProtection();
        if (this$xXSSProtection == null ? other$xXSSProtection != null : !this$xXSSProtection.equals(other$xXSSProtection)) {
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
        return other instanceof WebHTTPHeaders;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $contentSecurityPolicy = this.getContentSecurityPolicy();
        result = result * prime + ($contentSecurityPolicy == null ? 43 : $contentSecurityPolicy.hashCode());
        Object $strictTransportSecurity = this.getStrictTransportSecurity();
        result = result * prime + ($strictTransportSecurity == null ? 43 : $strictTransportSecurity.hashCode());
        Object $xContentTypeOptions = this.getXContentTypeOptions();
        result = result * prime + ($xContentTypeOptions == null ? 43 : $xContentTypeOptions.hashCode());
        Object $xFrameOptions = this.getXFrameOptions();
        result = result * prime + ($xFrameOptions == null ? 43 : $xFrameOptions.hashCode());
        Object $xXSSProtection = this.getXXSSProtection();
        result = result * prime + ($xXSSProtection == null ? 43 : $xXSSProtection.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "WebHTTPHeaders(" + "contentSecurityPolicy=" + this.getContentSecurityPolicy() + ", strictTransportSecurity=" + this.getStrictTransportSecurity() + ", xContentTypeOptions=" + this.getXContentTypeOptions() + ", xFrameOptions=" + this.getXFrameOptions() + ", xXSSProtection=" + this.getXXSSProtection() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
