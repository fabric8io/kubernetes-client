
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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim",
    "prefix"
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
public class PrefixedClaimMapping implements Editable<PrefixedClaimMappingBuilder>, KubernetesResource
{

    @JsonProperty("claim")
    private String claim;
    @JsonProperty("prefix")
    private String prefix;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PrefixedClaimMapping() {
    }

    public PrefixedClaimMapping(String claim, String prefix) {
        super();
        this.claim = claim;
        this.prefix = prefix;
    }

    /**
     * Claim is a JWT token claim to be used in the mapping
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * Claim is a JWT token claim to be used in the mapping
     */
    @JsonProperty("claim")
    public void setClaim(String claim) {
        this.claim = claim;
    }

    /**
     * Prefix is a string to prefix the value from the token in the result of the claim mapping.<br><p> <br><p> By default, no prefixing occurs.<br><p> <br><p> Example: if `prefix` is set to "myoidc:"" and the `claim` in JWT contains an array of strings "a", "b" and  "c", the mapping will result in an array of string "myoidc:a", "myoidc:b" and "myoidc:c".
     */
    @JsonProperty("prefix")
    public String getPrefix() {
        return prefix;
    }

    /**
     * Prefix is a string to prefix the value from the token in the result of the claim mapping.<br><p> <br><p> By default, no prefixing occurs.<br><p> <br><p> Example: if `prefix` is set to "myoidc:"" and the `claim` in JWT contains an array of strings "a", "b" and  "c", the mapping will result in an array of string "myoidc:a", "myoidc:b" and "myoidc:c".
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

}
