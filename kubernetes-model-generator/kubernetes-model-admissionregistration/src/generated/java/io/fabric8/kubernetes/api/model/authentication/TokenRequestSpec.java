
package io.fabric8.kubernetes.api.model.authentication;

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
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * TokenRequestSpec contains client provided parameters of a token request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "attestations",
    "audiences",
    "boundObjectRef",
    "expirationSeconds"
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
public class TokenRequestSpec implements Editable<TokenRequestSpecBuilder>, KubernetesResource
{

    @JsonProperty("attestations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, List<String>> attestations = new LinkedHashMap<>();
    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> audiences = new ArrayList<>();
    @JsonProperty("boundObjectRef")
    private BoundObjectReference boundObjectRef;
    @JsonProperty("expirationSeconds")
    private Long expirationSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenRequestSpec() {
    }

    public TokenRequestSpec(Map<String, List<String>> attestations, List<String> audiences, BoundObjectReference boundObjectRef, Long expirationSeconds) {
        super();
        this.attestations = attestations;
        this.audiences = audiences;
        this.boundObjectRef = boundObjectRef;
        this.expirationSeconds = expirationSeconds;
    }

    /**
     * attestations is a map of well-known keys to string-slice values. The values for each key have a specific semantic meaning, which is documented on the key definition. Requesters of tokens may ask the Kubernetes API Server to attest to certain claims. The API Server may perform authorization checks depending on the key of this map.
     */
    @JsonProperty("attestations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, List<String>> getAttestations() {
        return attestations;
    }

    /**
     * attestations is a map of well-known keys to string-slice values. The values for each key have a specific semantic meaning, which is documented on the key definition. Requesters of tokens may ask the Kubernetes API Server to attest to certain claims. The API Server may perform authorization checks depending on the key of this map.
     */
    @JsonProperty("attestations")
    public void setAttestations(Map<String, List<String>> attestations) {
        this.attestations = attestations;
    }

    /**
     * audiences are the intendend audiences of the token. A recipient of a token must identify themself with an identifier in the list of audiences of the token, and otherwise should reject the token. A token issued for multiple audiences may be used to authenticate against any of the audiences listed but implies a high degree of trust between the target audiences.
     */
    @JsonProperty("audiences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAudiences() {
        return audiences;
    }

    /**
     * audiences are the intendend audiences of the token. A recipient of a token must identify themself with an identifier in the list of audiences of the token, and otherwise should reject the token. A token issued for multiple audiences may be used to authenticate against any of the audiences listed but implies a high degree of trust between the target audiences.
     */
    @JsonProperty("audiences")
    public void setAudiences(List<String> audiences) {
        this.audiences = audiences;
    }

    /**
     * TokenRequestSpec contains client provided parameters of a token request.
     */
    @JsonProperty("boundObjectRef")
    public BoundObjectReference getBoundObjectRef() {
        return boundObjectRef;
    }

    /**
     * TokenRequestSpec contains client provided parameters of a token request.
     */
    @JsonProperty("boundObjectRef")
    public void setBoundObjectRef(BoundObjectReference boundObjectRef) {
        this.boundObjectRef = boundObjectRef;
    }

    /**
     * expirationSeconds is the requested duration of validity of the request. The token issuer may return a token with a different validity duration so a client needs to check the 'expiration' field in a response.
     */
    @JsonProperty("expirationSeconds")
    public Long getExpirationSeconds() {
        return expirationSeconds;
    }

    /**
     * expirationSeconds is the requested duration of validity of the request. The token issuer may return a token with a different validity duration so a client needs to check the 'expiration' field in a response.
     */
    @JsonProperty("expirationSeconds")
    public void setExpirationSeconds(Long expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
    }

    @JsonIgnore
    public TokenRequestSpecBuilder edit() {
        return new TokenRequestSpecBuilder(this);
    }

    @JsonIgnore
    public TokenRequestSpecBuilder toBuilder() {
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
        if (!(o instanceof TokenRequestSpec)) {
            return false;
        }
        TokenRequestSpec other = (TokenRequestSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$attestations = this.getAttestations();
        Object other$attestations = other.getAttestations();
        if (this$attestations == null ? other$attestations != null : !this$attestations.equals(other$attestations)) {
            return false;
        }
        Object this$audiences = this.getAudiences();
        Object other$audiences = other.getAudiences();
        if (this$audiences == null ? other$audiences != null : !this$audiences.equals(other$audiences)) {
            return false;
        }
        Object this$boundObjectRef = this.getBoundObjectRef();
        Object other$boundObjectRef = other.getBoundObjectRef();
        if (this$boundObjectRef == null ? other$boundObjectRef != null : !this$boundObjectRef.equals(other$boundObjectRef)) {
            return false;
        }
        Object this$expirationSeconds = this.getExpirationSeconds();
        Object other$expirationSeconds = other.getExpirationSeconds();
        if (this$expirationSeconds == null ? other$expirationSeconds != null : !this$expirationSeconds.equals(other$expirationSeconds)) {
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
        return other instanceof TokenRequestSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $attestations = this.getAttestations();
        result = result * prime + ($attestations == null ? 43 : $attestations.hashCode());
        Object $audiences = this.getAudiences();
        result = result * prime + ($audiences == null ? 43 : $audiences.hashCode());
        Object $boundObjectRef = this.getBoundObjectRef();
        result = result * prime + ($boundObjectRef == null ? 43 : $boundObjectRef.hashCode());
        Object $expirationSeconds = this.getExpirationSeconds();
        result = result * prime + ($expirationSeconds == null ? 43 : $expirationSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenRequestSpec(" + "attestations=" + this.getAttestations() + ", audiences=" + this.getAudiences() + ", boundObjectRef=" + this.getBoundObjectRef() + ", expirationSeconds=" + this.getExpirationSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
