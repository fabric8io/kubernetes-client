
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;
import tools.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = tools.jackson.databind.ValueDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "expression",
    "prefix",
    "prefixPolicy"
})
@ToString
@EqualsAndHashCode
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
    @JsonProperty("expression")
    private String expression;
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

    public UsernameClaimMapping(String claim, String expression, UsernamePrefix prefix, String prefixPolicy) {
        super();
        this.claim = claim;
        this.expression = expression;
        this.prefix = prefix;
        this.prefixPolicy = prefixPolicy;
    }

    /**
     * claim is an optional field that configures the JWT token claim whose value is assigned to the cluster identity field associated with this mapping. claim is required when the ExternalOIDCWithUpstreamParity feature gate is not enabled. When the ExternalOIDCWithUpstreamParity feature gate is enabled, claim must not be set when expression is set.<br><p> <br><p> claim must not be an empty string ("") and must not exceed 256 characters.
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * claim is an optional field that configures the JWT token claim whose value is assigned to the cluster identity field associated with this mapping. claim is required when the ExternalOIDCWithUpstreamParity feature gate is not enabled. When the ExternalOIDCWithUpstreamParity feature gate is enabled, claim must not be set when expression is set.<br><p> <br><p> claim must not be an empty string ("") and must not exceed 256 characters.
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    /**
     * expression is an optional CEL expression used to derive the username from JWT claims.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'.<br><p> <br><p> expression must be at least 1 character and must not exceed 1024 characters in length. expression must not be set when claim is set.
     */
    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    /**
     * expression is an optional CEL expression used to derive the username from JWT claims.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'.<br><p> <br><p> expression must be at least 1 character and must not exceed 1024 characters in length. expression must not be set when claim is set.
     */
    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
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
     * prefixPolicy is an optional field that configures how a prefix should be applied to the value of the JWT claim specified in the 'claim' field.<br><p> <br><p> Allowed values are 'Prefix', 'NoPrefix', and omitted (not provided or an empty string).<br><p> <br><p> When set to 'Prefix', the value specified in the prefix field will be prepended to the value of the JWT claim. The prefix field must be set when prefixPolicy is 'Prefix'. Must not be set to 'Prefix' when expression is set. When set to 'NoPrefix', no prefix will be prepended to the value of the JWT claim. When omitted, this means no opinion and the platform is left to choose any prefixes that are applied which is subject to change over time. Currently, the platform prepends `{issuerURL}#` to the value of the JWT claim when the claim is not 'email'.<br><p> <br><p> As an example, consider the following scenario:<br><p> <br><p>    `prefix` is unset, `issuerURL` is set to `https://myoidc.tld`,<br><p>    the JWT claims include "username":"userA" and "email":"userA@myoidc.tld",<br><p>    and `claim` is set to:<br><p>    - "username": the mapped value will be "https://myoidc.tld#userA"<br><p>    - "email": the mapped value will be "userA@myoidc.tld"<br><p> <br><p> <br><p> Possible enum values:<br><p>  - `""` let's the cluster assign prefixes. If the username claim is email, there is no prefix If the username claim is anything else, it is prefixed by the issuerURL<br><p>  - `"NoPrefix"` means the username claim value will not have any prefix<br><p>  - `"Prefix"` means the prefix value must be specified. It cannot be empty
     */
    @JsonProperty("prefixPolicy")
    public String getPrefixPolicy() {
        return prefixPolicy;
    }

    /**
     * prefixPolicy is an optional field that configures how a prefix should be applied to the value of the JWT claim specified in the 'claim' field.<br><p> <br><p> Allowed values are 'Prefix', 'NoPrefix', and omitted (not provided or an empty string).<br><p> <br><p> When set to 'Prefix', the value specified in the prefix field will be prepended to the value of the JWT claim. The prefix field must be set when prefixPolicy is 'Prefix'. Must not be set to 'Prefix' when expression is set. When set to 'NoPrefix', no prefix will be prepended to the value of the JWT claim. When omitted, this means no opinion and the platform is left to choose any prefixes that are applied which is subject to change over time. Currently, the platform prepends `{issuerURL}#` to the value of the JWT claim when the claim is not 'email'.<br><p> <br><p> As an example, consider the following scenario:<br><p> <br><p>    `prefix` is unset, `issuerURL` is set to `https://myoidc.tld`,<br><p>    the JWT claims include "username":"userA" and "email":"userA@myoidc.tld",<br><p>    and `claim` is set to:<br><p>    - "username": the mapped value will be "https://myoidc.tld#userA"<br><p>    - "email": the mapped value will be "userA@myoidc.tld"<br><p> <br><p> <br><p> Possible enum values:<br><p>  - `""` let's the cluster assign prefixes. If the username claim is email, there is no prefix If the username claim is anything else, it is prefixed by the issuerURL<br><p>  - `"NoPrefix"` means the username claim value will not have any prefix<br><p>  - `"Prefix"` means the prefix value must be specified. It cannot be empty
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

}
