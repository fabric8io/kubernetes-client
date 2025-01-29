
package io.fabric8.openshift.api.model.operator.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * IngressControllerHTTPHeaders specifies how the IngressController handles certain HTTP headers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "actions",
    "forwardedHeaderPolicy",
    "headerNameCaseAdjustments",
    "uniqueId"
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
public class IngressControllerHTTPHeaders implements Editable<IngressControllerHTTPHeadersBuilder>, KubernetesResource
{

    @JsonProperty("actions")
    private IngressControllerHTTPHeaderActions actions;
    @JsonProperty("forwardedHeaderPolicy")
    private String forwardedHeaderPolicy;
    @JsonProperty("headerNameCaseAdjustments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> headerNameCaseAdjustments = new ArrayList<>();
    @JsonProperty("uniqueId")
    private IngressControllerHTTPUniqueIdHeaderPolicy uniqueId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IngressControllerHTTPHeaders() {
    }

    public IngressControllerHTTPHeaders(IngressControllerHTTPHeaderActions actions, String forwardedHeaderPolicy, List<String> headerNameCaseAdjustments, IngressControllerHTTPUniqueIdHeaderPolicy uniqueId) {
        super();
        this.actions = actions;
        this.forwardedHeaderPolicy = forwardedHeaderPolicy;
        this.headerNameCaseAdjustments = headerNameCaseAdjustments;
        this.uniqueId = uniqueId;
    }

    /**
     * IngressControllerHTTPHeaders specifies how the IngressController handles certain HTTP headers.
     */
    @JsonProperty("actions")
    public IngressControllerHTTPHeaderActions getActions() {
        return actions;
    }

    /**
     * IngressControllerHTTPHeaders specifies how the IngressController handles certain HTTP headers.
     */
    @JsonProperty("actions")
    public void setActions(IngressControllerHTTPHeaderActions actions) {
        this.actions = actions;
    }

    /**
     * forwardedHeaderPolicy specifies when and how the IngressController sets the Forwarded, X-Forwarded-For, X-Forwarded-Host, X-Forwarded-Port, X-Forwarded-Proto, and X-Forwarded-Proto-Version HTTP headers.  The value may be one of the following:<br><p> <br><p> &#42; "Append", which specifies that the IngressController appends the<br><p>   headers, preserving existing headers.<br><p> <br><p> &#42; "Replace", which specifies that the IngressController sets the<br><p>   headers, replacing any existing Forwarded or X-Forwarded-&#42; headers.<br><p> <br><p> &#42; "IfNone", which specifies that the IngressController sets the<br><p>   headers if they are not already set.<br><p> <br><p> &#42; "Never", which specifies that the IngressController never sets the<br><p>   headers, preserving any existing headers.<br><p> <br><p> By default, the policy is "Append".
     */
    @JsonProperty("forwardedHeaderPolicy")
    public String getForwardedHeaderPolicy() {
        return forwardedHeaderPolicy;
    }

    /**
     * forwardedHeaderPolicy specifies when and how the IngressController sets the Forwarded, X-Forwarded-For, X-Forwarded-Host, X-Forwarded-Port, X-Forwarded-Proto, and X-Forwarded-Proto-Version HTTP headers.  The value may be one of the following:<br><p> <br><p> &#42; "Append", which specifies that the IngressController appends the<br><p>   headers, preserving existing headers.<br><p> <br><p> &#42; "Replace", which specifies that the IngressController sets the<br><p>   headers, replacing any existing Forwarded or X-Forwarded-&#42; headers.<br><p> <br><p> &#42; "IfNone", which specifies that the IngressController sets the<br><p>   headers if they are not already set.<br><p> <br><p> &#42; "Never", which specifies that the IngressController never sets the<br><p>   headers, preserving any existing headers.<br><p> <br><p> By default, the policy is "Append".
     */
    @JsonProperty("forwardedHeaderPolicy")
    public void setForwardedHeaderPolicy(String forwardedHeaderPolicy) {
        this.forwardedHeaderPolicy = forwardedHeaderPolicy;
    }

    /**
     * headerNameCaseAdjustments specifies case adjustments that can be applied to HTTP header names.  Each adjustment is specified as an HTTP header name with the desired capitalization.  For example, specifying "X-Forwarded-For" indicates that the "x-forwarded-for" HTTP header should be adjusted to have the specified capitalization.<br><p> <br><p> These adjustments are only applied to cleartext, edge-terminated, and re-encrypt routes, and only when using HTTP/1.<br><p> <br><p> For request headers, these adjustments are applied only for routes that have the haproxy.router.openshift.io/h1-adjust-case=true annotation.  For response headers, these adjustments are applied to all HTTP responses.<br><p> <br><p> If this field is empty, no request headers are adjusted.
     */
    @JsonProperty("headerNameCaseAdjustments")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getHeaderNameCaseAdjustments() {
        return headerNameCaseAdjustments;
    }

    /**
     * headerNameCaseAdjustments specifies case adjustments that can be applied to HTTP header names.  Each adjustment is specified as an HTTP header name with the desired capitalization.  For example, specifying "X-Forwarded-For" indicates that the "x-forwarded-for" HTTP header should be adjusted to have the specified capitalization.<br><p> <br><p> These adjustments are only applied to cleartext, edge-terminated, and re-encrypt routes, and only when using HTTP/1.<br><p> <br><p> For request headers, these adjustments are applied only for routes that have the haproxy.router.openshift.io/h1-adjust-case=true annotation.  For response headers, these adjustments are applied to all HTTP responses.<br><p> <br><p> If this field is empty, no request headers are adjusted.
     */
    @JsonProperty("headerNameCaseAdjustments")
    public void setHeaderNameCaseAdjustments(List<String> headerNameCaseAdjustments) {
        this.headerNameCaseAdjustments = headerNameCaseAdjustments;
    }

    /**
     * IngressControllerHTTPHeaders specifies how the IngressController handles certain HTTP headers.
     */
    @JsonProperty("uniqueId")
    public IngressControllerHTTPUniqueIdHeaderPolicy getUniqueId() {
        return uniqueId;
    }

    /**
     * IngressControllerHTTPHeaders specifies how the IngressController handles certain HTTP headers.
     */
    @JsonProperty("uniqueId")
    public void setUniqueId(IngressControllerHTTPUniqueIdHeaderPolicy uniqueId) {
        this.uniqueId = uniqueId;
    }

    @JsonIgnore
    public IngressControllerHTTPHeadersBuilder edit() {
        return new IngressControllerHTTPHeadersBuilder(this);
    }

    @JsonIgnore
    public IngressControllerHTTPHeadersBuilder toBuilder() {
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
