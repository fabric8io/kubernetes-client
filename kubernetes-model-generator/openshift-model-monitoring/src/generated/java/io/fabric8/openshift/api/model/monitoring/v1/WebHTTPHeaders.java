
package io.fabric8.openshift.api.model.monitoring.v1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
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
    "contentSecurityPolicy",
    "strictTransportSecurity",
    "xContentTypeOptions",
    "xFrameOptions",
    "xXSSProtection"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class WebHTTPHeaders implements Editable<WebHTTPHeadersBuilder> , KubernetesResource
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
     * 
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

    @JsonProperty("contentSecurityPolicy")
    public String getContentSecurityPolicy() {
        return contentSecurityPolicy;
    }

    @JsonProperty("contentSecurityPolicy")
    public void setContentSecurityPolicy(String contentSecurityPolicy) {
        this.contentSecurityPolicy = contentSecurityPolicy;
    }

    @JsonProperty("strictTransportSecurity")
    public String getStrictTransportSecurity() {
        return strictTransportSecurity;
    }

    @JsonProperty("strictTransportSecurity")
    public void setStrictTransportSecurity(String strictTransportSecurity) {
        this.strictTransportSecurity = strictTransportSecurity;
    }

    @JsonProperty("xContentTypeOptions")
    public String getXContentTypeOptions() {
        return xContentTypeOptions;
    }

    @JsonProperty("xContentTypeOptions")
    public void setXContentTypeOptions(String xContentTypeOptions) {
        this.xContentTypeOptions = xContentTypeOptions;
    }

    @JsonProperty("xFrameOptions")
    public String getXFrameOptions() {
        return xFrameOptions;
    }

    @JsonProperty("xFrameOptions")
    public void setXFrameOptions(String xFrameOptions) {
        this.xFrameOptions = xFrameOptions;
    }

    @JsonProperty("xXSSProtection")
    public String getXXSSProtection() {
        return xXSSProtection;
    }

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

}
