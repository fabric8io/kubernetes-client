
package io.fabric8.openshift.api.model.config.v1;

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
    "ca",
    "claims",
    "clientID",
    "clientSecret",
    "extraAuthorizeParameters",
    "extraScopes",
    "issuer"
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
public class OpenIDIdentityProvider implements KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("claims")
    private OpenIDClaims claims;
    @JsonProperty("clientID")
    private java.lang.String clientID;
    @JsonProperty("clientSecret")
    private SecretNameReference clientSecret;
    @JsonProperty("extraAuthorizeParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> extraAuthorizeParameters = new LinkedHashMap<String, String>();
    @JsonProperty("extraScopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> extraScopes = new ArrayList<java.lang.String>();
    @JsonProperty("issuer")
    private java.lang.String issuer;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OpenIDIdentityProvider() {
    }

    public OpenIDIdentityProvider(ConfigMapNameReference ca, OpenIDClaims claims, java.lang.String clientID, SecretNameReference clientSecret, Map<String, String> extraAuthorizeParameters, List<java.lang.String> extraScopes, java.lang.String issuer) {
        super();
        this.ca = ca;
        this.claims = claims;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.extraAuthorizeParameters = extraAuthorizeParameters;
        this.extraScopes = extraScopes;
        this.issuer = issuer;
    }

    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    @JsonProperty("claims")
    public OpenIDClaims getClaims() {
        return claims;
    }

    @JsonProperty("claims")
    public void setClaims(OpenIDClaims claims) {
        this.claims = claims;
    }

    @JsonProperty("clientID")
    public java.lang.String getClientID() {
        return clientID;
    }

    @JsonProperty("clientID")
    public void setClientID(java.lang.String clientID) {
        this.clientID = clientID;
    }

    @JsonProperty("clientSecret")
    public SecretNameReference getClientSecret() {
        return clientSecret;
    }

    @JsonProperty("clientSecret")
    public void setClientSecret(SecretNameReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    @JsonProperty("extraAuthorizeParameters")
    public Map<String, String> getExtraAuthorizeParameters() {
        return extraAuthorizeParameters;
    }

    @JsonProperty("extraAuthorizeParameters")
    public void setExtraAuthorizeParameters(Map<String, String> extraAuthorizeParameters) {
        this.extraAuthorizeParameters = extraAuthorizeParameters;
    }

    @JsonProperty("extraScopes")
    public List<java.lang.String> getExtraScopes() {
        return extraScopes;
    }

    @JsonProperty("extraScopes")
    public void setExtraScopes(List<java.lang.String> extraScopes) {
        this.extraScopes = extraScopes;
    }

    @JsonProperty("issuer")
    public java.lang.String getIssuer() {
        return issuer;
    }

    @JsonProperty("issuer")
    public void setIssuer(java.lang.String issuer) {
        this.issuer = issuer;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
