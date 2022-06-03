
package io.fabric8.camelk.v1;

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
    "baseImage",
    "buildDir",
    "dependencies",
    "maven",
    "name",
    "resources",
    "runtime",
    "sources",
    "steps"
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
public class BuilderTask implements KubernetesResource
{

    @JsonProperty("baseImage")
    private String baseImage;
    @JsonProperty("buildDir")
    private String buildDir;
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dependencies = new ArrayList<String>();
    @JsonProperty("maven")
    private MavenBuildSpec maven;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ResourceSpec> resources = new ArrayList<ResourceSpec>();
    @JsonProperty("runtime")
    private RuntimeSpec runtime;
    @JsonProperty("sources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SourceSpec> sources = new ArrayList<SourceSpec>();
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> steps = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuilderTask() {
    }

    /**
     * 
     * @param sources
     * @param buildDir
     * @param maven
     * @param baseImage
     * @param name
     * @param resources
     * @param runtime
     * @param steps
     * @param dependencies
     */
    public BuilderTask(String baseImage, String buildDir, List<String> dependencies, MavenBuildSpec maven, String name, List<ResourceSpec> resources, RuntimeSpec runtime, List<SourceSpec> sources, List<String> steps) {
        super();
        this.baseImage = baseImage;
        this.buildDir = buildDir;
        this.dependencies = dependencies;
        this.maven = maven;
        this.name = name;
        this.resources = resources;
        this.runtime = runtime;
        this.sources = sources;
        this.steps = steps;
    }

    @JsonProperty("baseImage")
    public String getBaseImage() {
        return baseImage;
    }

    @JsonProperty("baseImage")
    public void setBaseImage(String baseImage) {
        this.baseImage = baseImage;
    }

    @JsonProperty("buildDir")
    public String getBuildDir() {
        return buildDir;
    }

    @JsonProperty("buildDir")
    public void setBuildDir(String buildDir) {
        this.buildDir = buildDir;
    }

    @JsonProperty("dependencies")
    public List<String> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<String> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("maven")
    public MavenBuildSpec getMaven() {
        return maven;
    }

    @JsonProperty("maven")
    public void setMaven(MavenBuildSpec maven) {
        this.maven = maven;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("resources")
    public List<ResourceSpec> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<ResourceSpec> resources) {
        this.resources = resources;
    }

    @JsonProperty("runtime")
    public RuntimeSpec getRuntime() {
        return runtime;
    }

    @JsonProperty("runtime")
    public void setRuntime(RuntimeSpec runtime) {
        this.runtime = runtime;
    }

    @JsonProperty("sources")
    public List<SourceSpec> getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(List<SourceSpec> sources) {
        this.sources = sources;
    }

    @JsonProperty("steps")
    public List<String> getSteps() {
        return steps;
    }

    @JsonProperty("steps")
    public void setSteps(List<String> steps) {
        this.steps = steps;
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
