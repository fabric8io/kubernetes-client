
package io.fabric8.istio.api.api.security.v1beta1;

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
    "audiences",
    "forwardOriginalToken",
    "fromCookies",
    "fromHeaders",
    "fromParams",
    "issuer",
    "jwks",
    "jwksUri",
    "outputClaimToHeaders",
    "outputPayloadToHeader",
    "timeout"
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
public class JWTRule implements Editable<JWTRuleBuilder> , KubernetesResource
{

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<>();
    @JsonProperty("forwardOriginalToken")
    private Boolean forwardOriginalToken;
    @JsonProperty("fromCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fromCookies = new ArrayList<>();
    @JsonProperty("fromHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JWTHeader> fromHeaders = new ArrayList<>();
    @JsonProperty("fromParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fromParams = new ArrayList<>();
    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("jwks")
    private String jwks;
    @JsonProperty("jwksUri")
    private String jwksUri;
    @JsonProperty("outputClaimToHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ClaimToHeader> outputClaimToHeaders = new ArrayList<>();
    @JsonProperty("outputPayloadToHeader")
    private String outputPayloadToHeader;
    @JsonProperty("timeout")
    private String timeout;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JWTRule() {
    }

    public JWTRule(List<String> audiences, Boolean forwardOriginalToken, List<String> fromCookies, List<JWTHeader> fromHeaders, List<String> fromParams, String issuer, String jwks, String jwksUri, List<ClaimToHeader> outputClaimToHeaders, String outputPayloadToHeader, String timeout) {
        super();
        this.audiences = audiences;
        this.forwardOriginalToken = forwardOriginalToken;
        this.fromCookies = fromCookies;
        this.fromHeaders = fromHeaders;
        this.fromParams = fromParams;
        this.issuer = issuer;
        this.jwks = jwks;
        this.jwksUri = jwksUri;
        this.outputClaimToHeaders = outputClaimToHeaders;
        this.outputPayloadToHeader = outputPayloadToHeader;
        this.timeout = timeout;
    }

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAudiences() {
        return audiences;
    }

    @JsonProperty("audiences")
    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    @JsonProperty("forwardOriginalToken")
    public Boolean getForwardOriginalToken() {
        return forwardOriginalToken;
    }

    @JsonProperty("forwardOriginalToken")
    public void setForwardOriginalToken(Boolean forwardOriginalToken) {
        this.forwardOriginalToken = forwardOriginalToken;
    }

    @JsonProperty("fromCookies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFromCookies() {
        return fromCookies;
    }

    @JsonProperty("fromCookies")
    public void setFromCookies(List<String> fromCookies) {
        this.fromCookies = fromCookies;
    }

    @JsonProperty("fromHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<JWTHeader> getFromHeaders() {
        return fromHeaders;
    }

    @JsonProperty("fromHeaders")
    public void setFromHeaders(List<JWTHeader> fromHeaders) {
        this.fromHeaders = fromHeaders;
    }

    @JsonProperty("fromParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFromParams() {
        return fromParams;
    }

    @JsonProperty("fromParams")
    public void setFromParams(List<String> fromParams) {
        this.fromParams = fromParams;
    }

    @JsonProperty("issuer")
    public String getIssuer() {
        return issuer;
    }

    @JsonProperty("issuer")
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @JsonProperty("jwks")
    public String getJwks() {
        return jwks;
    }

    @JsonProperty("jwks")
    public void setJwks(String jwks) {
        this.jwks = jwks;
    }

    @JsonProperty("jwksUri")
    public String getJwksUri() {
        return jwksUri;
    }

    @JsonProperty("jwksUri")
    public void setJwksUri(String jwksUri) {
        this.jwksUri = jwksUri;
    }

    @JsonProperty("outputClaimToHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ClaimToHeader> getOutputClaimToHeaders() {
        return outputClaimToHeaders;
    }

    @JsonProperty("outputClaimToHeaders")
    public void setOutputClaimToHeaders(List<ClaimToHeader> outputClaimToHeaders) {
        this.outputClaimToHeaders = outputClaimToHeaders;
    }

    @JsonProperty("outputPayloadToHeader")
    public String getOutputPayloadToHeader() {
        return outputPayloadToHeader;
    }

    @JsonProperty("outputPayloadToHeader")
    public void setOutputPayloadToHeader(String outputPayloadToHeader) {
        this.outputPayloadToHeader = outputPayloadToHeader;
    }

    @JsonProperty("timeout")
    public String getTimeout() {
        return timeout;
    }

    @JsonProperty("timeout")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @JsonIgnore
    public JWTRuleBuilder edit() {
        return new JWTRuleBuilder(this);
    }

    @JsonIgnore
    public JWTRuleBuilder toBuilder() {
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
