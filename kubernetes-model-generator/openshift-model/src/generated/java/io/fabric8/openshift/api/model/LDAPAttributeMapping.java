
package io.fabric8.openshift.api.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "email",
    "id",
    "name",
    "preferredUsername"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class LDAPAttributeMapping implements KubernetesResource
{

    @JsonProperty("email")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> email = new ArrayList<String>();
    @JsonProperty("id")
    private List<String> id = new ArrayList<String>();
    @JsonProperty("name")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> name = new ArrayList<String>();
    @JsonProperty("preferredUsername")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> preferredUsername = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public LDAPAttributeMapping() {
    }

    /**
     * 
     * @param preferredUsername
     * @param name
     * @param id
     * @param email
     */
    public LDAPAttributeMapping(List<String> email, List<String> id, List<String> name, List<String> preferredUsername) {
        super();
        this.email = email;
        this.id = id;
        this.name = name;
        this.preferredUsername = preferredUsername;
    }

    @JsonProperty("email")
    public List<String> getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(List<String> email) {
        this.email = email;
    }

    @JsonProperty("id")
    public List<String> getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(List<String> id) {
        this.id = id;
    }

    @JsonProperty("name")
    public List<String> getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(List<String> name) {
        this.name = name;
    }

    @JsonProperty("preferredUsername")
    public List<String> getPreferredUsername() {
        return preferredUsername;
    }

    @JsonProperty("preferredUsername")
    public void setPreferredUsername(List<String> preferredUsername) {
        this.preferredUsername = preferredUsername;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
