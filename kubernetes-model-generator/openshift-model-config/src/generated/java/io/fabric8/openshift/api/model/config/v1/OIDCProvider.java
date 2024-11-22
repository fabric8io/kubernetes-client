
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claimMappings",
    "claimValidationRules",
    "issuer",
    "name",
    "oidcClients"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class OIDCProvider implements Editable<OIDCProviderBuilder> , KubernetesResource
{

    @JsonProperty("claimMappings")
    private TokenClaimMappings claimMappings;
    @JsonProperty("claimValidationRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TokenClaimValidationRule> claimValidationRules = new ArrayList<>();
    @JsonProperty("issuer")
    private TokenIssuer issuer;
    @JsonProperty("name")
    private String name;
    @JsonProperty("oidcClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OIDCClientConfig> oidcClients = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OIDCProvider() {
    }

    public OIDCProvider(TokenClaimMappings claimMappings, List<TokenClaimValidationRule> claimValidationRules, TokenIssuer issuer, String name, List<OIDCClientConfig> oidcClients) {
        super();
        this.claimMappings = claimMappings;
        this.claimValidationRules = claimValidationRules;
        this.issuer = issuer;
        this.name = name;
        this.oidcClients = oidcClients;
    }

    @JsonProperty("claimMappings")
    public TokenClaimMappings getClaimMappings() {
        return claimMappings;
    }

    @JsonProperty("claimMappings")
    public void setClaimMappings(TokenClaimMappings claimMappings) {
        this.claimMappings = claimMappings;
    }

    @JsonProperty("claimValidationRules")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TokenClaimValidationRule> getClaimValidationRules() {
        return claimValidationRules;
    }

    @JsonProperty("claimValidationRules")
    public void setClaimValidationRules(List<TokenClaimValidationRule> claimValidationRules) {
        this.claimValidationRules = claimValidationRules;
    }

    @JsonProperty("issuer")
    public TokenIssuer getIssuer() {
        return issuer;
    }

    @JsonProperty("issuer")
    public void setIssuer(TokenIssuer issuer) {
        this.issuer = issuer;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("oidcClients")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OIDCClientConfig> getOidcClients() {
        return oidcClients;
    }

    @JsonProperty("oidcClients")
    public void setOidcClients(List<OIDCClientConfig> oidcClients) {
        this.oidcClients = oidcClients;
    }

    @JsonIgnore
    public OIDCProviderBuilder edit() {
        return new OIDCProviderBuilder(this);
    }

    @JsonIgnore
    public OIDCProviderBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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
