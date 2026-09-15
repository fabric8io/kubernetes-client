
package io.fabric8.kubernetes.api.model.authentication;

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

/**
 * TokenRequestStatus is the result of a token request.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "expirationTimestamp",
    "token"
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
public class TokenRequestStatus implements Editable<TokenRequestStatusBuilder>, KubernetesResource
{

    @JsonProperty("expirationTimestamp")
    private String expirationTimestamp;
    @JsonProperty("token")
    private String token;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenRequestStatus() {
    }

    public TokenRequestStatus(String expirationTimestamp, String token) {
        super();
        this.expirationTimestamp = expirationTimestamp;
        this.token = token;
    }

    /**
     * TokenRequestStatus is the result of a token request.
     */
    @JsonProperty("expirationTimestamp")
    public String getExpirationTimestamp() {
        return expirationTimestamp;
    }

    /**
     * TokenRequestStatus is the result of a token request.
     */
    @JsonProperty("expirationTimestamp")
    public void setExpirationTimestamp(String expirationTimestamp) {
        this.expirationTimestamp = expirationTimestamp;
    }

    /**
     * token is the opaque bearer token.
     */
    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    /**
     * token is the opaque bearer token.
     */
    @JsonProperty("token")
    public void setToken(String token) {
        this.token = token;
    }

    @JsonIgnore
    public TokenRequestStatusBuilder edit() {
        return new TokenRequestStatusBuilder(this);
    }

    @JsonIgnore
    public TokenRequestStatusBuilder toBuilder() {
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
        if (!(o instanceof TokenRequestStatus)) {
            return false;
        }
        TokenRequestStatus other = (TokenRequestStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$expirationTimestamp = this.getExpirationTimestamp();
        Object other$expirationTimestamp = other.getExpirationTimestamp();
        if (this$expirationTimestamp == null ? other$expirationTimestamp != null : !this$expirationTimestamp.equals(other$expirationTimestamp)) {
            return false;
        }
        Object this$token = this.getToken();
        Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) {
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
        return other instanceof TokenRequestStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $expirationTimestamp = this.getExpirationTimestamp();
        result = result * prime + ($expirationTimestamp == null ? 43 : $expirationTimestamp.hashCode());
        Object $token = this.getToken();
        result = result * prime + ($token == null ? 43 : $token.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenRequestStatus(" + "expirationTimestamp=" + this.getExpirationTimestamp() + ", token=" + this.getToken() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
