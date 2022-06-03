
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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
    "flows",
    "integrationKit",
    "kit",
    "profile",
    "replicas",
    "repositories",
    "resources",
    "serviceAccountName",
    "sources",
    "template",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class IntegrationSpec implements KubernetesResource
{

    @JsonProperty("configuration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigurationSpec> configuration = new ArrayList<ConfigurationSpec>();
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> dependencies = new ArrayList<java.lang.String>();
    @JsonProperty("flows")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<JsonNode> flows = new ArrayList<JsonNode>();
    @JsonProperty("integrationKit")
    private io.fabric8.kubernetes.api.model.ObjectReference integrationKit;
    @JsonProperty("kit")
    private java.lang.String kit;
    @JsonProperty("profile")
    private java.lang.String profile;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("repositories")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> repositories = new ArrayList<java.lang.String>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceSpec> resources = new ArrayList<ResourceSpec>();
    @JsonProperty("serviceAccountName")
    private java.lang.String serviceAccountName;
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SourceSpec> sources = new ArrayList<SourceSpec>();
    @JsonProperty("template")
    private PodSpecTemplate template;
    @JsonProperty("traits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, TraitSpec> traits = new LinkedHashMap<String, TraitSpec>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationSpec() {
    }

    /**
     * 
     * @param template
     * @param traits
     * @param sources
     * @param configuration
     * @param integrationKit
     * @param replicas
     * @param serviceAccountName
     * @param profile
     * @param resources
     * @param dependencies
     * @param flows
     * @param repositories
     * @param kit
     */
    public IntegrationSpec(List<ConfigurationSpec> configuration, List<java.lang.String> dependencies, List<JsonNode> flows, io.fabric8.kubernetes.api.model.ObjectReference integrationKit, java.lang.String kit, java.lang.String profile, Integer replicas, List<java.lang.String> repositories, List<ResourceSpec> resources, java.lang.String serviceAccountName, List<SourceSpec> sources, PodSpecTemplate template, Map<String, TraitSpec> traits) {
        super();
        this.configuration = configuration;
        this.dependencies = dependencies;
        this.flows = flows;
        this.integrationKit = integrationKit;
        this.kit = kit;
        this.profile = profile;
        this.replicas = replicas;
        this.repositories = repositories;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.sources = sources;
        this.template = template;
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

    @JsonProperty("flows")
    public List<JsonNode> getFlows() {
        return flows;
    }

    @JsonProperty("flows")
    public void setFlows(List<JsonNode> flows) {
        this.flows = flows;
    }

    @JsonProperty("integrationKit")
    public io.fabric8.kubernetes.api.model.ObjectReference getIntegrationKit() {
        return integrationKit;
    }

    @JsonProperty("integrationKit")
    public void setIntegrationKit(io.fabric8.kubernetes.api.model.ObjectReference integrationKit) {
        this.integrationKit = integrationKit;
    }

    @JsonProperty("kit")
    public java.lang.String getKit() {
        return kit;
    }

    @JsonProperty("kit")
    public void setKit(java.lang.String kit) {
        this.kit = kit;
    }

    @JsonProperty("profile")
    public java.lang.String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(java.lang.String profile) {
        this.profile = profile;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("repositories")
    public List<java.lang.String> getRepositories() {
        return repositories;
    }

    @JsonProperty("repositories")
    public void setRepositories(List<java.lang.String> repositories) {
        this.repositories = repositories;
    }

    @JsonProperty("resources")
    public List<ResourceSpec> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<ResourceSpec> resources) {
        this.resources = resources;
    }

    @JsonProperty("serviceAccountName")
    public java.lang.String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(java.lang.String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("sources")
    public List<SourceSpec> getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(List<SourceSpec> sources) {
        this.sources = sources;
    }

    @JsonProperty("template")
    public PodSpecTemplate getTemplate() {
        return template;
    }

    @JsonProperty("template")
    public void setTemplate(PodSpecTemplate template) {
        this.template = template;
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
