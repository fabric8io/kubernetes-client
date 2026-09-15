
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
    "prefix",
    "prefixPolicy"
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
public class UsernameClaimMapping implements Editable<UsernameClaimMappingBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private String claim;
    @JsonProperty("prefix")
    private UsernamePrefix prefix;
    @JsonProperty("prefixPolicy")
    private String prefixPolicy;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public UsernameClaimMapping() {
    }

    public UsernameClaimMapping(String claim, UsernamePrefix prefix, String prefixPolicy) {
        super();
        this.claim = claim;
        this.prefix = prefix;
        this.prefixPolicy = prefixPolicy;
    }

    /**
     * claim is a required field that configures the JWT token claim whose value is assigned to the cluster identity field associated with this mapping.<br><p> <br><p> claim must not be an empty string ("") and must not exceed 256 characters.
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * claim is a required field that configures the JWT token claim whose value is assigned to the cluster identity field associated with this mapping.<br><p> <br><p> claim must not be an empty string ("") and must not exceed 256 characters.
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    @JsonProperty("prefix")
    public UsernamePrefix getPrefix() {
        return prefix;
    }

    @JsonProperty("prefix")
    public void setPrefix(UsernamePrefix prefix) {
        this.prefix = prefix;
    }

    /**
     * prefixPolicy is an optional field that configures how a prefix should be applied to the value of the JWT claim specified in the 'claim' field.<br><p> <br><p> Allowed values are 'Prefix', 'NoPrefix', and omitted (not provided or an empty string).<br><p> <br><p> When set to 'Prefix', the value specified in the prefix field will be prepended to the value of the JWT claim. The prefix field must be set when prefixPolicy is 'Prefix'.<br><p> <br><p> When set to 'NoPrefix', no prefix will be prepended to the value of the JWT claim.<br><p> <br><p> When omitted, this means no opinion and the platform is left to choose any prefixes that are applied which is subject to change over time. Currently, the platform prepends `{issuerURL}#` to the value of the JWT claim when the claim is not 'email'. As an example, consider the following scenario:<br><p>    `prefix` is unset, `issuerURL` is set to `https://myoidc.tld`,<br><p>    the JWT claims include "username":"userA" and "email":"userA@myoidc.tld",<br><p>    and `claim` is set to:<br><p>    - "username": the mapped value will be "https://myoidc.tld#userA"<br><p>    - "email": the mapped value will be "userA@myoidc.tld"
     */
    @JsonProperty("prefixPolicy")
    public String getPrefixPolicy() {
        return prefixPolicy;
    }

    /**
     * prefixPolicy is an optional field that configures how a prefix should be applied to the value of the JWT claim specified in the 'claim' field.<br><p> <br><p> Allowed values are 'Prefix', 'NoPrefix', and omitted (not provided or an empty string).<br><p> <br><p> When set to 'Prefix', the value specified in the prefix field will be prepended to the value of the JWT claim. The prefix field must be set when prefixPolicy is 'Prefix'.<br><p> <br><p> When set to 'NoPrefix', no prefix will be prepended to the value of the JWT claim.<br><p> <br><p> When omitted, this means no opinion and the platform is left to choose any prefixes that are applied which is subject to change over time. Currently, the platform prepends `{issuerURL}#` to the value of the JWT claim when the claim is not 'email'. As an example, consider the following scenario:<br><p>    `prefix` is unset, `issuerURL` is set to `https://myoidc.tld`,<br><p>    the JWT claims include "username":"userA" and "email":"userA@myoidc.tld",<br><p>    and `claim` is set to:<br><p>    - "username": the mapped value will be "https://myoidc.tld#userA"<br><p>    - "email": the mapped value will be "userA@myoidc.tld"
     */
    @JsonProperty("prefixPolicy")
    public void setPrefixPolicy(String prefixPolicy) {
        this.prefixPolicy = prefixPolicy;
    }

    @JsonIgnore
    public UsernameClaimMappingBuilder edit() {
        return new UsernameClaimMappingBuilder(this);
    }

    @JsonIgnore
    public UsernameClaimMappingBuilder toBuilder() {
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
        if (!(o instanceof UsernameClaimMapping)) {
            return false;
        }
        UsernameClaimMapping other = (UsernameClaimMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$claim = this.getClaim();
        Object other$claim = other.getClaim();
        if (this$claim == null ? other$claim != null : !this$claim.equals(other$claim)) {
            return false;
        }
        Object this$prefix = this.getPrefix();
        Object other$prefix = other.getPrefix();
        if (this$prefix == null ? other$prefix != null : !this$prefix.equals(other$prefix)) {
            return false;
        }
        Object this$prefixPolicy = this.getPrefixPolicy();
        Object other$prefixPolicy = other.getPrefixPolicy();
        if (this$prefixPolicy == null ? other$prefixPolicy != null : !this$prefixPolicy.equals(other$prefixPolicy)) {
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
        return other instanceof UsernameClaimMapping;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $claim = this.getClaim();
        result = result * prime + ($claim == null ? 43 : $claim.hashCode());
        Object $prefix = this.getPrefix();
        result = result * prime + ($prefix == null ? 43 : $prefix.hashCode());
        Object $prefixPolicy = this.getPrefixPolicy();
        result = result * prime + ($prefixPolicy == null ? 43 : $prefixPolicy.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "UsernameClaimMapping(" + "claim=" + this.getClaim() + ", prefix=" + this.getPrefix() + ", prefixPolicy=" + this.getPrefixPolicy() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
