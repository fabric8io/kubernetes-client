
package io.fabric8.istio.api.api.networking.v1alpha3;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "allowCredentials",
    "allowHeaders",
    "allowMethods",
    "allowOrigin",
    "allowOrigins",
    "exposeHeaders",
    "maxAge",
    "unmatchedPreflights"
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
public class CorsPolicy implements Editable<CorsPolicyBuilder>, KubernetesResource
{

    @JsonProperty("allowCredentials")
    private Boolean allowCredentials;
    @JsonProperty("allowHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowHeaders = new ArrayList<>();
    @JsonProperty("allowMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> allowMethods = new ArrayList<>();
    @JsonProperty("allowOrigin")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> deprecatedAllowOrigin = new ArrayList<>();
    @JsonProperty("allowOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StringMatch> allowOrigins = new ArrayList<>();
    @JsonProperty("exposeHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> exposeHeaders = new ArrayList<>();
    @JsonProperty("maxAge")
    private String maxAge;
    @JsonProperty("unmatchedPreflights")
    private CorsPolicyUnmatchedPreflights unmatchedPreflights;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public CorsPolicy() {
    }

    public CorsPolicy(Boolean allowCredentials, List<String> allowHeaders, List<String> allowMethods, List<String> deprecatedAllowOrigin, List<StringMatch> allowOrigins, List<String> exposeHeaders, String maxAge, CorsPolicyUnmatchedPreflights unmatchedPreflights) {
        super();
        this.allowCredentials = allowCredentials;
        this.allowHeaders = allowHeaders;
        this.allowMethods = allowMethods;
        this.deprecatedAllowOrigin = deprecatedAllowOrigin;
        this.allowOrigins = allowOrigins;
        this.exposeHeaders = exposeHeaders;
        this.maxAge = maxAge;
        this.unmatchedPreflights = unmatchedPreflights;
    }

    @JsonProperty("allowCredentials")
    public Boolean getAllowCredentials() {
        return allowCredentials;
    }

    @JsonProperty("allowCredentials")
    public void setAllowCredentials(Boolean allowCredentials) {
        this.allowCredentials = allowCredentials;
    }

    @JsonProperty("allowHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowHeaders() {
        return allowHeaders;
    }

    @JsonProperty("allowHeaders")
    public void setAllowHeaders(List<String> allowHeaders) {
        this.allowHeaders = allowHeaders;
    }

    @JsonProperty("allowMethods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowMethods() {
        return allowMethods;
    }

    @JsonProperty("allowMethods")
    public void setAllowMethods(List<String> allowMethods) {
        this.allowMethods = allowMethods;
    }

    @JsonProperty("allowOrigin")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAllowOrigin() {
        return deprecatedAllowOrigin;
    }

    @JsonProperty("allowOrigin")
    public void setAllowOrigin(List<String> deprecatedAllowOrigin) {
        this.deprecatedAllowOrigin = deprecatedAllowOrigin;
    }

    @JsonProperty("allowOrigins")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<StringMatch> getAllowOrigins() {
        return allowOrigins;
    }

    @JsonProperty("allowOrigins")
    public void setAllowOrigins(List<StringMatch> allowOrigins) {
        this.allowOrigins = allowOrigins;
    }

    @JsonProperty("exposeHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExposeHeaders() {
        return exposeHeaders;
    }

    @JsonProperty("exposeHeaders")
    public void setExposeHeaders(List<String> exposeHeaders) {
        this.exposeHeaders = exposeHeaders;
    }

    @JsonProperty("maxAge")
    public String getMaxAge() {
        return maxAge;
    }

    @JsonProperty("maxAge")
    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    @JsonProperty("unmatchedPreflights")
    public CorsPolicyUnmatchedPreflights getUnmatchedPreflights() {
        return unmatchedPreflights;
    }

    @JsonProperty("unmatchedPreflights")
    public void setUnmatchedPreflights(CorsPolicyUnmatchedPreflights unmatchedPreflights) {
        this.unmatchedPreflights = unmatchedPreflights;
    }

    @JsonIgnore
    public CorsPolicyBuilder edit() {
        return new CorsPolicyBuilder(this);
    }

    @JsonIgnore
    public CorsPolicyBuilder toBuilder() {
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
