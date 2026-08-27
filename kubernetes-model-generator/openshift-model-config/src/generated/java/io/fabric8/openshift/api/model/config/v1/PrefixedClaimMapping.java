
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
import tools.jackson.databind.annotation.JsonDeserialize;

/**
 * PrefixedClaimMapping configures a claim mapping that allows for an optional prefix.
 */
@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "expression",
    "prefix"
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
public class PrefixedClaimMapping implements Editable<PrefixedClaimMappingBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private String claim;
    @JsonProperty("expression")
    private String expression;
    @JsonProperty("prefix")
    private String prefix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrefixedClaimMapping() {
    }

    public PrefixedClaimMapping(String claim, String expression, String prefix) {
        super();
        this.claim = claim;
        this.expression = expression;
        this.prefix = prefix;
    }

    /**
     * claim is an optional field for specifying the JWT token claim that is used in the mapping. The value of this claim will be assigned to the field in which this mapping is associated. claim must not exceed 256 characters in length. When set to the empty string `""`, this means that no named claim should be used for the group mapping. claim is required when the ExternalOIDCWithUpstreamParity feature gate is not enabled.
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * claim is an optional field for specifying the JWT token claim that is used in the mapping. The value of this claim will be assigned to the field in which this mapping is associated. claim must not exceed 256 characters in length. When set to the empty string `""`, this means that no named claim should be used for the group mapping. claim is required when the ExternalOIDCWithUpstreamParity feature gate is not enabled.
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    /**
     * expression is an optional CEL expression used to derive group values from JWT claims.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'.<br><p> <br><p> expression must be at least 1 character and must not exceed 1024 characters in length .<br><p> <br><p> When specified, claim must not be set or be explicitly set to the empty string (`""`).
     */
    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    /**
     * expression is an optional CEL expression used to derive group values from JWT claims.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'.<br><p> <br><p> expression must be at least 1 character and must not exceed 1024 characters in length .<br><p> <br><p> When specified, claim must not be set or be explicitly set to the empty string (`""`).
     */
    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    /**
     * prefix is an optional field that configures the prefix that will be applied to the cluster identity attribute during the process of mapping JWT claims to cluster identity attributes.<br><p> <br><p> When omitted or set to an empty string (""), no prefix is applied to the cluster identity attribute. Must not be set to a non-empty value when expression is set.<br><p> <br><p> Example: if `prefix` is set to "myoidc:" and the `claim` in JWT contains an array of strings "a", "b" and "c", the mapping will result in an array of string "myoidc:a", "myoidc:b" and "myoidc:c".
     */
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    /**
     * prefix is an optional field that configures the prefix that will be applied to the cluster identity attribute during the process of mapping JWT claims to cluster identity attributes.<br><p> <br><p> When omitted or set to an empty string (""), no prefix is applied to the cluster identity attribute. Must not be set to a non-empty value when expression is set.<br><p> <br><p> Example: if `prefix` is set to "myoidc:" and the `claim` in JWT contains an array of strings "a", "b" and "c", the mapping will result in an array of string "myoidc:a", "myoidc:b" and "myoidc:c".
     */
    @JsonProperty("prefix")
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @JsonIgnore
    public PrefixedClaimMappingBuilder edit() {
        return new PrefixedClaimMappingBuilder(this);
    }

    @JsonIgnore
    public PrefixedClaimMappingBuilder toBuilder() {
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
        if (!(o instanceof PrefixedClaimMapping)) {
            return false;
        }
        PrefixedClaimMapping other = (PrefixedClaimMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claim = this.getClaim();
        Object other$claim = other.getClaim();
        if (this$claim == null ? other$claim != null : !this$claim.equals(other$claim)) {
            return false;
        }
        Object this$expression = this.getExpression();
        Object other$expression = other.getExpression();
        if (this$expression == null ? other$expression != null : !this$expression.equals(other$expression)) {
            return false;
        }
        Object this$prefix = this.getPrefix();
        Object other$prefix = other.getPrefix();
        if (this$prefix == null ? other$prefix != null : !this$prefix.equals(other$prefix)) {
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
        return other instanceof PrefixedClaimMapping;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claim = this.getClaim();
        result = result * prime + ($claim == null ? 43 : $claim.hashCode());
        Object $expression = this.getExpression();
        result = result * prime + ($expression == null ? 43 : $expression.hashCode());
        Object $prefix = this.getPrefix();
        result = result * prime + ($prefix == null ? 43 : $prefix.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PrefixedClaimMapping(" + "claim=" + this.getClaim() + ", expression=" + this.getExpression() + ", prefix=" + this.getPrefix() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
