
package io.fabric8.certmanager.api.model.acme.v1;

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

/**
 * ACMEAuthorization contains data returned from the ACME server on an authorization that must be completed in order validate a DNS name on an ACME Order resource.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "challenges",
    "identifier",
    "initialState",
    "url",
    "wildcard"
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
public class ACMEAuthorization implements Editable<ACMEAuthorizationBuilder>, KubernetesResource
{

    @JsonProperty("challenges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ACMEChallenge> challenges = new ArrayList<>();
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("initialState")
    private String initialState;
    @JsonProperty("url")
    private String url;
    @JsonProperty("wildcard")
    private Boolean wildcard;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ACMEAuthorization() {
    }

    public ACMEAuthorization(List<ACMEChallenge> challenges, String identifier, String initialState, String url, Boolean wildcard) {
        super();
        this.challenges = challenges;
        this.identifier = identifier;
        this.initialState = initialState;
        this.url = url;
        this.wildcard = wildcard;
    }

    /**
     * Challenges specifies the challenge types offered by the ACME server. One of these challenge types will be selected when validating the DNS name and an appropriate Challenge resource will be created to perform the ACME challenge process.
     */
    @JsonProperty("challenges")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ACMEChallenge> getChallenges() {
        return challenges;
    }

    /**
     * Challenges specifies the challenge types offered by the ACME server. One of these challenge types will be selected when validating the DNS name and an appropriate Challenge resource will be created to perform the ACME challenge process.
     */
    @JsonProperty("challenges")
    public void setChallenges(List<ACMEChallenge> challenges) {
        this.challenges = challenges;
    }

    /**
     * Identifier is the DNS name to be validated as part of this authorization
     */
    @JsonProperty("identifier")
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Identifier is the DNS name to be validated as part of this authorization
     */
    @JsonProperty("identifier")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * InitialState is the initial state of the ACME authorization when first fetched from the ACME server. If an Authorization is already 'valid', the Order controller will not create a Challenge resource for the authorization. This will occur when working with an ACME server that enables 'authz reuse' (such as Let's Encrypt's production endpoint). If not set and 'identifier' is set, the state is assumed to be pending and a Challenge will be created.
     */
    @JsonProperty("initialState")
    public String getInitialState() {
        return initialState;
    }

    /**
     * InitialState is the initial state of the ACME authorization when first fetched from the ACME server. If an Authorization is already 'valid', the Order controller will not create a Challenge resource for the authorization. This will occur when working with an ACME server that enables 'authz reuse' (such as Let's Encrypt's production endpoint). If not set and 'identifier' is set, the state is assumed to be pending and a Challenge will be created.
     */
    @JsonProperty("initialState")
    public void setInitialState(String initialState) {
        this.initialState = initialState;
    }

    /**
     * URL is the URL of the Authorization that must be completed
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * URL is the URL of the Authorization that must be completed
     */
    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Wildcard will be true if this authorization is for a wildcard DNS name. If this is true, the identifier will be the &#42;non-wildcard&#42; version of the DNS name. For example, if '&#42;.example.com' is the DNS name being validated, this field will be 'true' and the 'identifier' field will be 'example.com'.
     */
    @JsonProperty("wildcard")
    public Boolean getWildcard() {
        return wildcard;
    }

    /**
     * Wildcard will be true if this authorization is for a wildcard DNS name. If this is true, the identifier will be the &#42;non-wildcard&#42; version of the DNS name. For example, if '&#42;.example.com' is the DNS name being validated, this field will be 'true' and the 'identifier' field will be 'example.com'.
     */
    @JsonProperty("wildcard")
    public void setWildcard(Boolean wildcard) {
        this.wildcard = wildcard;
    }

    @JsonIgnore
    public ACMEAuthorizationBuilder edit() {
        return new ACMEAuthorizationBuilder(this);
    }

    @JsonIgnore
    public ACMEAuthorizationBuilder toBuilder() {
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
