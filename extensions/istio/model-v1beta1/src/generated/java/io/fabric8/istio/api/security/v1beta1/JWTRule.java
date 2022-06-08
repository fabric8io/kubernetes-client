
package io.fabric8.istio.api.security.v1beta1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "audiences",
    "forwardOriginalToken",
    "fromHeaders",
    "fromParams",
    "issuer",
    "jwks",
    "jwksUri",
    "outputPayloadToHeader"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class JWTRule implements KubernetesResource
{

    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<String>();
    @JsonProperty("forwardOriginalToken")
    private Boolean forwardOriginalToken;
    @JsonProperty("fromHeaders")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JWTHeader> fromHeaders = new ArrayList<JWTHeader>();
    @JsonProperty("fromParams")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> fromParams = new ArrayList<String>();
    @JsonProperty("issuer")
    private String issuer;
    @JsonProperty("jwks")
    private String jwks;
    @JsonProperty("jwksUri")
    private String jwksUri;
    @JsonProperty("outputPayloadToHeader")
    private String outputPayloadToHeader;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public JWTRule() {
    }

    /**
     * 
     * @param fromHeaders
     * @param jwks
     * @param fromParams
     * @param audiences
     * @param jwksUri
     * @param outputPayloadToHeader
     * @param forwardOriginalToken
     * @param issuer
     */
    public JWTRule(List<String> audiences, Boolean forwardOriginalToken, List<JWTHeader> fromHeaders, List<String> fromParams, String issuer, String jwks, String jwksUri, String outputPayloadToHeader) {
        super();
        this.audiences = audiences;
        this.forwardOriginalToken = forwardOriginalToken;
        this.fromHeaders = fromHeaders;
        this.fromParams = fromParams;
        this.issuer = issuer;
        this.jwks = jwks;
        this.jwksUri = jwksUri;
        this.outputPayloadToHeader = outputPayloadToHeader;
    }

    @JsonProperty("audiences")
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

    @JsonProperty("fromHeaders")
    public List<JWTHeader> getFromHeaders() {
        return fromHeaders;
    }

    @JsonProperty("fromHeaders")
    public void setFromHeaders(List<JWTHeader> fromHeaders) {
        this.fromHeaders = fromHeaders;
    }

    @JsonProperty("fromParams")
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

    @JsonProperty("outputPayloadToHeader")
    public String getOutputPayloadToHeader() {
        return outputPayloadToHeader;
    }

    @JsonProperty("outputPayloadToHeader")
    public void setOutputPayloadToHeader(String outputPayloadToHeader) {
        this.outputPayloadToHeader = outputPayloadToHeader;
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
