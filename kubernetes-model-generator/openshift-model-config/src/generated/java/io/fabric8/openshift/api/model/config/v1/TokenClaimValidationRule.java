
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
    "requiredClaim",
    "type"
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
public class TokenClaimValidationRule implements Editable<TokenClaimValidationRuleBuilder>, KubernetesResource
{

    @JsonProperty("requiredClaim")
    private TokenRequiredClaim requiredClaim;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenClaimValidationRule() {
    }

    public TokenClaimValidationRule(TokenRequiredClaim requiredClaim, String type) {
        super();
        this.requiredClaim = requiredClaim;
        this.type = type;
    }

    @JsonProperty("requiredClaim")
    public TokenRequiredClaim getRequiredClaim() {
        return requiredClaim;
    }

    @JsonProperty("requiredClaim")
    public void setRequiredClaim(TokenRequiredClaim requiredClaim) {
        this.requiredClaim = requiredClaim;
    }

    /**
     * type is an optional field that configures the type of the validation rule.<br><p> <br><p> Allowed values are 'RequiredClaim' and omitted (not provided or an empty string).<br><p> <br><p> When set to 'RequiredClaim', the Kubernetes API server will be configured to validate that the incoming JWT contains the required claim and that its value matches the required value.<br><p> <br><p> Defaults to 'RequiredClaim'.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is an optional field that configures the type of the validation rule.<br><p> <br><p> Allowed values are 'RequiredClaim' and omitted (not provided or an empty string).<br><p> <br><p> When set to 'RequiredClaim', the Kubernetes API server will be configured to validate that the incoming JWT contains the required claim and that its value matches the required value.<br><p> <br><p> Defaults to 'RequiredClaim'.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public TokenClaimValidationRuleBuilder edit() {
        return new TokenClaimValidationRuleBuilder(this);
    }

    @JsonIgnore
    public TokenClaimValidationRuleBuilder toBuilder() {
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
        if (!(o instanceof TokenClaimValidationRule)) {
            return false;
        }
        TokenClaimValidationRule other = (TokenClaimValidationRule) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$requiredClaim = this.getRequiredClaim();
        Object other$requiredClaim = other.getRequiredClaim();
        if (this$requiredClaim == null ? other$requiredClaim != null : !this$requiredClaim.equals(other$requiredClaim)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof TokenClaimValidationRule;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $requiredClaim = this.getRequiredClaim();
        result = result * prime + ($requiredClaim == null ? 43 : $requiredClaim.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TokenClaimValidationRule(" + "requiredClaim=" + this.getRequiredClaim() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
