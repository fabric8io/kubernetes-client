
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
    "build",
    "cluster",
    "configuration",
    "kamelet",
    "profile",
    "resources",
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
public class IntegrationPlatformSpec implements KubernetesResource
{

    @JsonProperty("build")
    private IntegrationPlatformBuildSpec build;
    @JsonProperty("cluster")
    private java.lang.String cluster;
    @JsonProperty("configuration")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ConfigurationSpec> configuration = new ArrayList<ConfigurationSpec>();
    @JsonProperty("kamelet")
    private IntegrationPlatformKameletSpec kamelet;
    @JsonProperty("profile")
    private java.lang.String profile;
    @JsonProperty("resources")
    private IntegrationPlatformResourcesSpec resources;
    @JsonProperty("traits")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, TraitSpec> traits = new LinkedHashMap<String, TraitSpec>();
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IntegrationPlatformSpec() {
    }

    /**
     * 
     * @param cluster
     * @param traits
     * @param build
     * @param configuration
     * @param profile
     * @param resources
     * @param kamelet
     */
    public IntegrationPlatformSpec(IntegrationPlatformBuildSpec build, java.lang.String cluster, List<ConfigurationSpec> configuration, IntegrationPlatformKameletSpec kamelet, java.lang.String profile, IntegrationPlatformResourcesSpec resources, Map<String, TraitSpec> traits) {
        super();
        this.build = build;
        this.cluster = cluster;
        this.configuration = configuration;
        this.kamelet = kamelet;
        this.profile = profile;
        this.resources = resources;
        this.traits = traits;
    }

    @JsonProperty("build")
    public IntegrationPlatformBuildSpec getBuild() {
        return build;
    }

    @JsonProperty("build")
    public void setBuild(IntegrationPlatformBuildSpec build) {
        this.build = build;
    }

    @JsonProperty("cluster")
    public java.lang.String getCluster() {
        return cluster;
    }

    @JsonProperty("cluster")
    public void setCluster(java.lang.String cluster) {
        this.cluster = cluster;
    }

    @JsonProperty("configuration")
    public List<ConfigurationSpec> getConfiguration() {
        return configuration;
    }

    @JsonProperty("configuration")
    public void setConfiguration(List<ConfigurationSpec> configuration) {
        this.configuration = configuration;
    }

    @JsonProperty("kamelet")
    public IntegrationPlatformKameletSpec getKamelet() {
        return kamelet;
    }

    @JsonProperty("kamelet")
    public void setKamelet(IntegrationPlatformKameletSpec kamelet) {
        this.kamelet = kamelet;
    }

    @JsonProperty("profile")
    public java.lang.String getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(java.lang.String profile) {
        this.profile = profile;
    }

    @JsonProperty("resources")
    public IntegrationPlatformResourcesSpec getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(IntegrationPlatformResourcesSpec resources) {
        this.resources = resources;
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
