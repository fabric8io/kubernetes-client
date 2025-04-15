
package io.fabric8.openshift.api.model.config.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
 * OpenIDClaims contains a list of OpenID claims to use when authenticating with an OpenID identity provider
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "groups",
    "name",
    "preferredUsername"
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
public class OpenIDClaims implements Editable<OpenIDClaimsBuilder>, KubernetesResource
{

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> email = new ArrayList<>();
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groups = new ArrayList<>();
    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> name = new ArrayList<>();
    @JsonProperty("preferredUsername")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> preferredUsername = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public OpenIDClaims() {
    }

    public OpenIDClaims(List<String> email, List<String> groups, List<String> name, List<String> preferredUsername) {
        super();
        this.email = email;
        this.groups = groups;
        this.name = name;
        this.preferredUsername = preferredUsername;
    }

    /**
     * email is the list of claims whose values should be used as the email address. Optional. If unspecified, no email is set for the identity
     */
    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmail() {
        return email;
    }

    /**
     * email is the list of claims whose values should be used as the email address. Optional. If unspecified, no email is set for the identity
     */
    @JsonProperty("email")
    public void setEmail(List<String> email) {
        this.email = email;
    }

    /**
     * groups is the list of claims value of which should be used to synchronize groups from the OIDC provider to OpenShift for the user. If multiple claims are specified, the first one with a non-empty value is used.
     */
    @JsonProperty("groups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getGroups() {
        return groups;
    }

    /**
     * groups is the list of claims value of which should be used to synchronize groups from the OIDC provider to OpenShift for the user. If multiple claims are specified, the first one with a non-empty value is used.
     */
    @JsonProperty("groups")
    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    /**
     * name is the list of claims whose values should be used as the display name. Optional. If unspecified, no display name is set for the identity
     */
    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getName() {
        return name;
    }

    /**
     * name is the list of claims whose values should be used as the display name. Optional. If unspecified, no display name is set for the identity
     */
    @JsonProperty("name")
    public void setName(List<String> name) {
        this.name = name;
    }

    /**
     * preferredUsername is the list of claims whose values should be used as the preferred username. If unspecified, the preferred username is determined from the value of the sub claim
     */
    @JsonProperty("preferredUsername")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPreferredUsername() {
        return preferredUsername;
    }

    /**
     * preferredUsername is the list of claims whose values should be used as the preferred username. If unspecified, the preferred username is determined from the value of the sub claim
     */
    @JsonProperty("preferredUsername")
    public void setPreferredUsername(List<String> preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    @JsonIgnore
    public OpenIDClaimsBuilder edit() {
        return new OpenIDClaimsBuilder(this);
    }

    @JsonIgnore
    public OpenIDClaimsBuilder toBuilder() {
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
