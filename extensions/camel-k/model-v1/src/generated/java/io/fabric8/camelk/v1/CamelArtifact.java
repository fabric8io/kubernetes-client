
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
    "artifactId",
    "dataformats",
    "dependencies",
    "exclusions",
    "groupId",
    "javaTypes",
    "languages",
    "schemes",
    "version"
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
public class CamelArtifact implements KubernetesResource
{

    @JsonProperty("artifactId")
    private String artifactId;
    @JsonProperty("dataformats")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> dataformats = new ArrayList<String>();
    @JsonProperty("dependencies")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CamelArtifactDependency> dependencies = new ArrayList<CamelArtifactDependency>();
    @JsonProperty("exclusions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CamelArtifactExclusion> exclusions = new ArrayList<CamelArtifactExclusion>();
    @JsonProperty("groupId")
    private String groupId;
    @JsonProperty("javaTypes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> javaTypes = new ArrayList<String>();
    @JsonProperty("languages")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> languages = new ArrayList<String>();
    @JsonProperty("schemes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<CamelScheme> schemes = new ArrayList<CamelScheme>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CamelArtifact() {
    }

    /**
     * 
     * @param javaTypes
     * @param languages
     * @param groupId
     * @param artifactId
     * @param exclusions
     * @param schemes
     * @param version
     * @param dataformats
     * @param dependencies
     */
    public CamelArtifact(String artifactId, List<String> dataformats, List<CamelArtifactDependency> dependencies, List<CamelArtifactExclusion> exclusions, String groupId, List<String> javaTypes, List<String> languages, List<CamelScheme> schemes, String version) {
        super();
        this.artifactId = artifactId;
        this.dataformats = dataformats;
        this.dependencies = dependencies;
        this.exclusions = exclusions;
        this.groupId = groupId;
        this.javaTypes = javaTypes;
        this.languages = languages;
        this.schemes = schemes;
        this.version = version;
    }

    @JsonProperty("artifactId")
    public String getArtifactId() {
        return artifactId;
    }

    @JsonProperty("artifactId")
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    @JsonProperty("dataformats")
    public List<String> getDataformats() {
        return dataformats;
    }

    @JsonProperty("dataformats")
    public void setDataformats(List<String> dataformats) {
        this.dataformats = dataformats;
    }

    @JsonProperty("dependencies")
    public List<CamelArtifactDependency> getDependencies() {
        return dependencies;
    }

    @JsonProperty("dependencies")
    public void setDependencies(List<CamelArtifactDependency> dependencies) {
        this.dependencies = dependencies;
    }

    @JsonProperty("exclusions")
    public List<CamelArtifactExclusion> getExclusions() {
        return exclusions;
    }

    @JsonProperty("exclusions")
    public void setExclusions(List<CamelArtifactExclusion> exclusions) {
        this.exclusions = exclusions;
    }

    @JsonProperty("groupId")
    public String getGroupId() {
        return groupId;
    }

    @JsonProperty("groupId")
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("javaTypes")
    public List<String> getJavaTypes() {
        return javaTypes;
    }

    @JsonProperty("javaTypes")
    public void setJavaTypes(List<String> javaTypes) {
        this.javaTypes = javaTypes;
    }

    @JsonProperty("languages")
    public List<String> getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @JsonProperty("schemes")
    public List<CamelScheme> getSchemes() {
        return schemes;
    }

    @JsonProperty("schemes")
    public void setSchemes(List<CamelScheme> schemes) {
        this.schemes = schemes;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
