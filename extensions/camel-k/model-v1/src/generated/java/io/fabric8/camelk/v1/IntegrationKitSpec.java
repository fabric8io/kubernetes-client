
package io.fabric8.camelk.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "configuration",
    "dependencies",
    "image",
    "profile",
    "repositories",
    "traits"
})
@ToString
@EqualsAndHashCode
@Setter
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
public class IntegrationKitSpec implements KubernetesResource
{

    @JsonProperty("configuration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigurationSpec> configuration = new ArrayList<ConfigurationSpec>();
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> dependencies = new ArrayList<java.lang.String>();
    @JsonProperty("image")
    private java.lang.String image;
    @JsonProperty("profile")
    private java.lang.String profile;
    @JsonProperty("repositories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> repositories = new ArrayList<java.lang.String>();
    @JsonProperty("traits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, TraitSpec> traits = new LinkedHashMap<String, TraitSpec>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationKitSpec() {
    }

    /**
     * 
     * @param image
     * @param traits
     * @param configuration
     * @param repositories
     * @param profile
     * @param dependencies
     */
    public IntegrationKitSpec(List<ConfigurationSpec> configuration, List<java.lang.String> dependencies, java.lang.String image, java.lang.String profile, List<java.lang.String> repositories, Map<String, TraitSpec> traits) {
        super();
        this.configuration = configuration;
        this.dependencies = dependencies;
        this.image = image;
        this.profile = profile;
        this.repositories = repositories;
        this.traits = traits;
    }

    @JsonProperty("configuration")
    public List<ConfigurationSpec> getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(List<ConfigurationSpec> configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("dependencies")
    public List<java.lang.String> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<java.lang.String> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("image")
    public java.lang.String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(java.lang.String image) {
        this.image = image;
    }

    @JsonProperty("profile")
    public java.lang.String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(java.lang.String profile) {
        this.profile = profile;
    }

    @JsonProperty("repositories")
    public List<java.lang.String> getRepositories() {
        return repositories;
    }

    @JsonProperty("repositories")
    public void setRepositories(List<java.lang.String> repositories) {
        this.repositories = repositories;
    }

    @JsonProperty("traits")
    public Map<String, TraitSpec> getTraits() {
        return traits;
    }

    @JsonProperty("traits")
    public void setTraits(Map<String, TraitSpec> traits) {
        this.traits = traits;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
