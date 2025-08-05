
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * TokenClaimOrExpressionMapping allows specifying either a JWT token claim or CEL expression to be used when mapping claims from an authentication token to cluster identities.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "expression"
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
public class TokenClaimOrExpressionMapping implements Editable<TokenClaimOrExpressionMappingBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private String claim;
    @JsonProperty("expression")
    private String expression;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TokenClaimOrExpressionMapping() {
    }

    public TokenClaimOrExpressionMapping(String claim, String expression) {
        super();
        this.claim = claim;
        this.expression = expression;
    }

    /**
     * claim is an optional field for specifying the JWT token claim that is used in the mapping. The value of this claim will be assigned to the field in which this mapping is associated.<br><p> <br><p> Precisely one of claim or expression must be set. claim must not be specified when expression is set. When specified, claim must be at least 1 character in length and must not exceed 256 characters in length.
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * claim is an optional field for specifying the JWT token claim that is used in the mapping. The value of this claim will be assigned to the field in which this mapping is associated.<br><p> <br><p> Precisely one of claim or expression must be set. claim must not be specified when expression is set. When specified, claim must be at least 1 character in length and must not exceed 256 characters in length.
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    /**
     * expression is an optional field for specifying a CEL expression that produces a string value from JWT token claims.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'. 'claims' is a map of claim names to claim values. For example, the 'sub' claim value can be accessed as 'claims.sub'. Nested claims can be accessed using dot notation ('claims.foo.bar').<br><p> <br><p> Precisely one of claim or expression must be set. expression must not be specified when claim is set. When specified, expression must be at least 1 character in length and must not exceed 4096 characters in length.
     */
    @JsonProperty("expression")
    public String getExpression() {
        return expression;
    }

    /**
     * expression is an optional field for specifying a CEL expression that produces a string value from JWT token claims.<br><p> <br><p> CEL expressions have access to the token claims through a CEL variable, 'claims'. 'claims' is a map of claim names to claim values. For example, the 'sub' claim value can be accessed as 'claims.sub'. Nested claims can be accessed using dot notation ('claims.foo.bar').<br><p> <br><p> Precisely one of claim or expression must be set. expression must not be specified when claim is set. When specified, expression must be at least 1 character in length and must not exceed 4096 characters in length.
     */
    @JsonProperty("expression")
    public void setExpression(String expression) {
        this.expression = expression;
    }

    @JsonIgnore
    public TokenClaimOrExpressionMappingBuilder edit() {
        return new TokenClaimOrExpressionMappingBuilder(this);
    }

    @JsonIgnore
    public TokenClaimOrExpressionMappingBuilder toBuilder() {
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
