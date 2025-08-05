
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
     * claim is a JWT token claim to be used in the mapping
     */
    @JsonProperty("claim")
    public String getClaim() {
        return claim;
    }

    /**
     * claim is a JWT token claim to be used in the mapping
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
     * prefixPolicy specifies how a prefix should apply.<br><p> <br><p> By default, claims other than `email` will be prefixed with the issuer URL to prevent naming clashes with other plugins.<br><p> <br><p> Set to "NoPrefix" to disable prefixing.<br><p> <br><p> Example:<br><p>     (1) `prefix` is set to "myoidc:" and `claim` is set to "username".<br><p>         If the JWT claim `username` contains value `userA`, the resulting<br><p>         mapped value will be "myoidc:userA".<br><p>     (2) `prefix` is set to "myoidc:" and `claim` is set to "email". If the<br><p>         JWT `email` claim contains value "userA@myoidc.tld", the resulting<br><p>         mapped value will be "myoidc:userA@myoidc.tld".<br><p>     (3) `prefix` is unset, `issuerURL` is set to `https://myoidc.tld`,<br><p>         the JWT claims include "username":"userA" and "email":"userA@myoidc.tld",<br><p>         and `claim` is set to:<br><p>         (a) "username": the mapped value will be "https://myoidc.tld#userA"<br><p>         (b) "email": the mapped value will be "userA@myoidc.tld"
     */
    @JsonProperty("prefixPolicy")
    public String getPrefixPolicy() {
        return prefixPolicy;
    }

    /**
     * prefixPolicy specifies how a prefix should apply.<br><p> <br><p> By default, claims other than `email` will be prefixed with the issuer URL to prevent naming clashes with other plugins.<br><p> <br><p> Set to "NoPrefix" to disable prefixing.<br><p> <br><p> Example:<br><p>     (1) `prefix` is set to "myoidc:" and `claim` is set to "username".<br><p>         If the JWT claim `username` contains value `userA`, the resulting<br><p>         mapped value will be "myoidc:userA".<br><p>     (2) `prefix` is set to "myoidc:" and `claim` is set to "email". If the<br><p>         JWT `email` claim contains value "userA@myoidc.tld", the resulting<br><p>         mapped value will be "myoidc:userA@myoidc.tld".<br><p>     (3) `prefix` is unset, `issuerURL` is set to `https://myoidc.tld`,<br><p>         the JWT claims include "username":"userA" and "email":"userA@myoidc.tld",<br><p>         and `claim` is set to:<br><p>         (a) "username": the mapped value will be "https://myoidc.tld#userA"<br><p>         (b) "email": the mapped value will be "userA@myoidc.tld"
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
