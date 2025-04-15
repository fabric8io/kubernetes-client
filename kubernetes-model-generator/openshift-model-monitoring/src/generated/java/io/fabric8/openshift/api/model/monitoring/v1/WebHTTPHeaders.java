
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
     * Set the Content-Security-Policy header to HTTP responses. Unset if blank.
     */
    @JsonProperty("contentSecurityPolicy")
    public String getContentSecurityPolicy() {
        return contentSecurityPolicy;
    }

    /**
     * Set the Content-Security-Policy header to HTTP responses. Unset if blank.
     */
    @JsonProperty("contentSecurityPolicy")
    public void setContentSecurityPolicy(String contentSecurityPolicy) {
        this.contentSecurityPolicy = contentSecurityPolicy;
    }

    /**
     * Set the Strict-Transport-Security header to HTTP responses. Unset if blank. Please make sure that you use this with care as this header might force browsers to load Prometheus and the other applications hosted on the same domain and subdomains over HTTPS. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security
     */
    @JsonProperty("strictTransportSecurity")
    public String getStrictTransportSecurity() {
        return strictTransportSecurity;
    }

    /**
     * Set the Strict-Transport-Security header to HTTP responses. Unset if blank. Please make sure that you use this with care as this header might force browsers to load Prometheus and the other applications hosted on the same domain and subdomains over HTTPS. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Strict-Transport-Security
     */
    @JsonProperty("strictTransportSecurity")
    public void setStrictTransportSecurity(String strictTransportSecurity) {
        this.strictTransportSecurity = strictTransportSecurity;
    }

    /**
     * Set the X-Content-Type-Options header to HTTP responses. Unset if blank. Accepted value is nosniff. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options
     */
    @JsonProperty("xContentTypeOptions")
    public String getXContentTypeOptions() {
        return xContentTypeOptions;
    }

    /**
     * Set the X-Content-Type-Options header to HTTP responses. Unset if blank. Accepted value is nosniff. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Content-Type-Options
     */
    @JsonProperty("xContentTypeOptions")
    public void setXContentTypeOptions(String xContentTypeOptions) {
        this.xContentTypeOptions = xContentTypeOptions;
    }

    /**
     * Set the X-Frame-Options header to HTTP responses. Unset if blank. Accepted values are deny and sameorigin. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options
     */
    @JsonProperty("xFrameOptions")
    public String getXFrameOptions() {
        return xFrameOptions;
    }

    /**
     * Set the X-Frame-Options header to HTTP responses. Unset if blank. Accepted values are deny and sameorigin. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-Frame-Options
     */
    @JsonProperty("xFrameOptions")
    public void setXFrameOptions(String xFrameOptions) {
        this.xFrameOptions = xFrameOptions;
    }

    /**
     * Set the X-XSS-Protection header to all responses. Unset if blank. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection
     */
    @JsonProperty("xXSSProtection")
    public String getXXSSProtection() {
        return xXSSProtection;
    }

    /**
     * Set the X-XSS-Protection header to all responses. Unset if blank. https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/X-XSS-Protection
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
