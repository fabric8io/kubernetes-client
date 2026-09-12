
package io.fabric8.openshift.api.model.config.v1;

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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "requiredValue"
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
public class TokenRequiredClaim implements Editable<TokenRequiredClaimBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private String claim;
    @JsonProperty("requiredValue")
    private String requiredValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenRequiredClaim() {
    }

    public TokenRequiredClaim(String claim, String requiredValue) {
        super();
        this.claim = claim;
        this.requiredValue = requiredValue;
    }

    /**
     * claim is a required field that configures the name of the required claim. When taken from the JWT claims, claim must be a string value.<br><p> <br><p> claim must not be an empty string ("").
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * claim is a required field that configures the name of the required claim. When taken from the JWT claims, claim must be a string value.<br><p> <br><p> claim must not be an empty string ("").
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    /**
     * requiredValue is a required field that configures the value that 'claim' must have when taken from the incoming JWT claims. If the value in the JWT claims does not match, the token will be rejected for authentication.<br><p> <br><p> requiredValue must not be an empty string ("").
     */
    @JsonProperty("requiredValue")
    public String getRequiredValue() {
        return requiredValue;
    }

    /**
     * requiredValue is a required field that configures the value that 'claim' must have when taken from the incoming JWT claims. If the value in the JWT claims does not match, the token will be rejected for authentication.<br><p> <br><p> requiredValue must not be an empty string ("").
     */
    @JsonProperty("requiredValue")
    public void setRequiredValue(String requiredValue) {
        this.requiredValue = requiredValue;
    }

    @JsonIgnore
    public TokenRequiredClaimBuilder edit() {
        return new TokenRequiredClaimBuilder(this);
    }

    @JsonIgnore
    public TokenRequiredClaimBuilder toBuilder() {
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
        if (!(o instanceof TokenRequiredClaim)) {
            return false;
        }
        TokenRequiredClaim other = (TokenRequiredClaim) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claim = this.getClaim();
        Object other$claim = other.getClaim();
        if (this$claim == null ? other$claim != null : !this$claim.equals(other$claim)) {
            return false;
        }
        Object this$requiredValue = this.getRequiredValue();
        Object other$requiredValue = other.getRequiredValue();
        if (this$requiredValue == null ? other$requiredValue != null : !this$requiredValue.equals(other$requiredValue)) {
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
        return other instanceof TokenRequiredClaim;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claim = this.getClaim();
        result = result * prime + ($claim == null ? 43 : $claim.hashCode());
        Object $requiredValue = this.getRequiredValue();
        result = result * prime + ($requiredValue == null ? 43 : $requiredValue.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenRequiredClaim(" + "claim=" + this.getClaim() + ", requiredValue=" + this.getRequiredValue() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
