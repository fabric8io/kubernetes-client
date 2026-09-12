
package io.fabric8.kubernetes.api.model.storage;

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
 * TokenRequest contains parameters of a service account token.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "audience",
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
public class TokenRequest implements Editable<TokenRequestBuilder>, KubernetesResource
{

    @JsonProperty("audience")
    private String audience;
    @JsonProperty("expirationSeconds")
    private Long expirationSeconds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenRequest() {
    }

    public TokenRequest(String audience, Long expirationSeconds) {
        super();
        this.audience = audience;
        this.expirationSeconds = expirationSeconds;
    }

    /**
     * audience is the intended audience of the token in "TokenRequestSpec". It will default to the audiences of kube apiserver.
     */
    @JsonProperty("audience")
    public String getAudience() {
        return audience;
    }

    /**
     * audience is the intended audience of the token in "TokenRequestSpec". It will default to the audiences of kube apiserver.
     */
    @JsonProperty("audience")
    public void setAudience(String audience) {
        this.audience = audience;
    }

    /**
     * expirationSeconds is the duration of validity of the token in "TokenRequestSpec". It has the same default value of "ExpirationSeconds" in "TokenRequestSpec".
     */
    @JsonProperty("expirationSeconds")
    public Long getExpirationSeconds() {
        return expirationSeconds;
    }

    /**
     * expirationSeconds is the duration of validity of the token in "TokenRequestSpec". It has the same default value of "ExpirationSeconds" in "TokenRequestSpec".
     */
    @JsonProperty("expirationSeconds")
    public void setExpirationSeconds(Long expirationSeconds) {
        this.expirationSeconds = expirationSeconds;
    }

    @JsonIgnore
    public TokenRequestBuilder edit() {
        return new TokenRequestBuilder(this);
    }

    @JsonIgnore
    public TokenRequestBuilder toBuilder() {
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
        if (!(o instanceof TokenRequest)) {
            return false;
        }
        TokenRequest other = (TokenRequest) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$audience = this.getAudience();
        Object other$audience = other.getAudience();
        if (this$audience == null ? other$audience != null : !this$audience.equals(other$audience)) {
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
        return other instanceof TokenRequest;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $audience = this.getAudience();
        result = result * prime + ($audience == null ? 43 : $audience.hashCode());
        Object $expirationSeconds = this.getExpirationSeconds();
        result = result * prime + ($expirationSeconds == null ? 43 : $expirationSeconds.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenRequest(" + "audience=" + this.getAudience() + ", expirationSeconds=" + this.getExpirationSeconds() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
