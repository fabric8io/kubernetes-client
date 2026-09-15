
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ca",
    "claims",
    "clientID",
    "clientSecret",
    "extraAuthorizeParameters",
    "extraScopes",
    "issuer"
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
public class OpenIDIdentityProvider implements Editable<OpenIDIdentityProviderBuilder>, KubernetesResource
{

    @JsonProperty("ca")
    private ConfigMapNameReference ca;
    @JsonProperty("claims")
    private OpenIDClaims claims;
    @JsonProperty("clientID")
    private String clientID;
    @JsonProperty("clientSecret")
    private SecretNameReference clientSecret;
    @JsonProperty("extraAuthorizeParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> extraAuthorizeParameters = new LinkedHashMap<>();
    @JsonProperty("extraScopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> extraScopes = new ArrayList<>();
    @JsonProperty("issuer")
    private String issuer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpenIDIdentityProvider() {
    }

    public OpenIDIdentityProvider(ConfigMapNameReference ca, OpenIDClaims claims, String clientID, SecretNameReference clientSecret, Map<String, String> extraAuthorizeParameters, List<String> extraScopes, String issuer) {
        super();
        this.ca = ca;
        this.claims = claims;
        this.clientID = clientID;
        this.clientSecret = clientSecret;
        this.extraAuthorizeParameters = extraAuthorizeParameters;
        this.extraScopes = extraScopes;
        this.issuer = issuer;
    }

    /**
     * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
     */
    @JsonProperty("ca")
    public ConfigMapNameReference getCa() {
        return ca;
    }

    /**
     * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
     */
    @JsonProperty("ca")
    public void setCa(ConfigMapNameReference ca) {
        this.ca = ca;
    }

    /**
     * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
     */
    @JsonProperty("claims")
    public OpenIDClaims getClaims() {
        return claims;
    }

    /**
     * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
     */
    @JsonProperty("claims")
    public void setClaims(OpenIDClaims claims) {
        this.claims = claims;
    }

    /**
     * clientID is the oauth client ID
     */
    @JsonProperty("clientID")
    public String getClientID() {
        return clientID;
    }

    /**
     * clientID is the oauth client ID
     */
    @JsonProperty("clientID")
    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    /**
     * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
     */
    @JsonProperty("clientSecret")
    public SecretNameReference getClientSecret() {
        return clientSecret;
    }

    /**
     * OpenIDIdentityProvider provides identities for users authenticating using OpenID credentials
     */
    @JsonProperty("clientSecret")
    public void setClientSecret(SecretNameReference clientSecret) {
        this.clientSecret = clientSecret;
    }

    /**
     * extraAuthorizeParameters are any custom parameters to add to the authorize request.
     */
    @JsonProperty("extraAuthorizeParameters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getExtraAuthorizeParameters() {
        return extraAuthorizeParameters;
    }

    /**
     * extraAuthorizeParameters are any custom parameters to add to the authorize request.
     */
    @JsonProperty("extraAuthorizeParameters")
    public void setExtraAuthorizeParameters(Map<String, String> extraAuthorizeParameters) {
        this.extraAuthorizeParameters = extraAuthorizeParameters;
    }

    /**
     * extraScopes are any scopes to request in addition to the standard "openid" scope.
     */
    @JsonProperty("extraScopes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getExtraScopes() {
        return extraScopes;
    }

    /**
     * extraScopes are any scopes to request in addition to the standard "openid" scope.
     */
    @JsonProperty("extraScopes")
    public void setExtraScopes(List<String> extraScopes) {
        this.extraScopes = extraScopes;
    }

    /**
     * issuer is the URL that the OpenID Provider asserts as its Issuer Identifier. It must use the https scheme with no query or fragment component.
     */
    @JsonProperty("issuer")
    public String getIssuer() {
        return issuer;
    }

    /**
     * issuer is the URL that the OpenID Provider asserts as its Issuer Identifier. It must use the https scheme with no query or fragment component.
     */
    @JsonProperty("issuer")
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    @JsonIgnore
    public OpenIDIdentityProviderBuilder edit() {
        return new OpenIDIdentityProviderBuilder(this);
    }

    @JsonIgnore
    public OpenIDIdentityProviderBuilder toBuilder() {
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
        if (!(o instanceof OpenIDIdentityProvider)) {
            return false;
        }
        OpenIDIdentityProvider other = (OpenIDIdentityProvider) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$ca = this.getCa();
        Object other$ca = other.getCa();
        if (this$ca == null ? other$ca != null : !this$ca.equals(other$ca)) {
            return false;
        }
        Object this$claims = this.getClaims();
        Object other$claims = other.getClaims();
        if (this$claims == null ? other$claims != null : !this$claims.equals(other$claims)) {
            return false;
        }
        Object this$clientID = this.getClientID();
        Object other$clientID = other.getClientID();
        if (this$clientID == null ? other$clientID != null : !this$clientID.equals(other$clientID)) {
            return false;
        }
        Object this$clientSecret = this.getClientSecret();
        Object other$clientSecret = other.getClientSecret();
        if (this$clientSecret == null ? other$clientSecret != null : !this$clientSecret.equals(other$clientSecret)) {
            return false;
        }
        Object this$extraAuthorizeParameters = this.getExtraAuthorizeParameters();
        Object other$extraAuthorizeParameters = other.getExtraAuthorizeParameters();
        if (this$extraAuthorizeParameters == null ? other$extraAuthorizeParameters != null : !this$extraAuthorizeParameters.equals(other$extraAuthorizeParameters)) {
            return false;
        }
        Object this$extraScopes = this.getExtraScopes();
        Object other$extraScopes = other.getExtraScopes();
        if (this$extraScopes == null ? other$extraScopes != null : !this$extraScopes.equals(other$extraScopes)) {
            return false;
        }
        Object this$issuer = this.getIssuer();
        Object other$issuer = other.getIssuer();
        if (this$issuer == null ? other$issuer != null : !this$issuer.equals(other$issuer)) {
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
        return other instanceof OpenIDIdentityProvider;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $ca = this.getCa();
        result = result * prime + ($ca == null ? 43 : $ca.hashCode());
        Object $claims = this.getClaims();
        result = result * prime + ($claims == null ? 43 : $claims.hashCode());
        Object $clientID = this.getClientID();
        result = result * prime + ($clientID == null ? 43 : $clientID.hashCode());
        Object $clientSecret = this.getClientSecret();
        result = result * prime + ($clientSecret == null ? 43 : $clientSecret.hashCode());
        Object $extraAuthorizeParameters = this.getExtraAuthorizeParameters();
        result = result * prime + ($extraAuthorizeParameters == null ? 43 : $extraAuthorizeParameters.hashCode());
        Object $extraScopes = this.getExtraScopes();
        result = result * prime + ($extraScopes == null ? 43 : $extraScopes.hashCode());
        Object $issuer = this.getIssuer();
        result = result * prime + ($issuer == null ? 43 : $issuer.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "OpenIDIdentityProvider(" + "ca=" + this.getCa() + ", claims=" + this.getClaims() + ", clientID=" + this.getClientID() + ", clientSecret=" + this.getClientSecret() + ", extraAuthorizeParameters=" + this.getExtraAuthorizeParameters() + ", extraScopes=" + this.getExtraScopes() + ", issuer=" + this.getIssuer() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
