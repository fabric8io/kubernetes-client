
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
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * LDAPAttributeMapping maps LDAP attributes to OpenShift identity fields
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "email",
    "id",
    "name",
    "preferredUsername"
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
public class LDAPAttributeMapping implements Editable<LDAPAttributeMappingBuilder>, KubernetesResource
{

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> email = new ArrayList<>();
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> id = new ArrayList<>();
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
    public LDAPAttributeMapping() {
    }

    public LDAPAttributeMapping(List<String> email, List<String> id, List<String> name, List<String> preferredUsername) {
        super();
        this.email = email;
        this.id = id;
        this.name = name;
        this.preferredUsername = preferredUsername;
    }

    /**
     * email is the list of attributes whose values should be used as the email address. Optional. If unspecified, no email is set for the identity
     */
    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getEmail() {
        return email;
    }

    /**
     * email is the list of attributes whose values should be used as the email address. Optional. If unspecified, no email is set for the identity
     */
    @JsonProperty("email")
    public void setEmail(List<String> email) {
        this.email = email;
    }

    /**
     * id is the list of attributes whose values should be used as the user ID. Required. First non-empty attribute is used. At least one attribute is required. If none of the listed attribute have a value, authentication fails. LDAP standard identity attribute is "dn"
     */
    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getId() {
        return id;
    }

    /**
     * id is the list of attributes whose values should be used as the user ID. Required. First non-empty attribute is used. At least one attribute is required. If none of the listed attribute have a value, authentication fails. LDAP standard identity attribute is "dn"
     */
    @JsonProperty("id")
    public void setId(List<String> id) {
        this.id = id;
    }

    /**
     * name is the list of attributes whose values should be used as the display name. Optional. If unspecified, no display name is set for the identity LDAP standard display name attribute is "cn"
     */
    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getName() {
        return name;
    }

    /**
     * name is the list of attributes whose values should be used as the display name. Optional. If unspecified, no display name is set for the identity LDAP standard display name attribute is "cn"
     */
    @JsonProperty("name")
    public void setName(List<String> name) {
        this.name = name;
    }

    /**
     * preferredUsername is the list of attributes whose values should be used as the preferred username. LDAP standard login attribute is "uid"
     */
    @JsonProperty("preferredUsername")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getPreferredUsername() {
        return preferredUsername;
    }

    /**
     * preferredUsername is the list of attributes whose values should be used as the preferred username. LDAP standard login attribute is "uid"
     */
    @JsonProperty("preferredUsername")
    public void setPreferredUsername(List<String> preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    @JsonIgnore
    public LDAPAttributeMappingBuilder edit() {
        return new LDAPAttributeMappingBuilder(this);
    }

    @JsonIgnore
    public LDAPAttributeMappingBuilder toBuilder() {
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
        if (!(o instanceof LDAPAttributeMapping)) {
            return false;
        }
        LDAPAttributeMapping other = (LDAPAttributeMapping) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$email = this.getEmail();
        Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) {
            return false;
        }
        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$preferredUsername = this.getPreferredUsername();
        Object other$preferredUsername = other.getPreferredUsername();
        if (this$preferredUsername == null ? other$preferredUsername != null : !this$preferredUsername.equals(other$preferredUsername)) {
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
        return other instanceof LDAPAttributeMapping;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $email = this.getEmail();
        result = result * prime + ($email == null ? 43 : $email.hashCode());
        Object $id = this.getId();
        result = result * prime + ($id == null ? 43 : $id.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $preferredUsername = this.getPreferredUsername();
        result = result * prime + ($preferredUsername == null ? 43 : $preferredUsername.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "LDAPAttributeMapping(" + "email=" + this.getEmail() + ", id=" + this.getId() + ", name=" + this.getName() + ", preferredUsername=" + this.getPreferredUsername() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
