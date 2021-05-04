
package io.fabric8.openshift.api.model;

import java.util.HashMap;
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
    "customStrategy",
    "dockerStrategy",
    "jenkinsPipelineStrategy",
    "sourceStrategy",
    "type"
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
public class BuildStrategy implements KubernetesResource
{

    @JsonProperty("customStrategy")
    private CustomBuildStrategy customStrategy;
    @JsonProperty("dockerStrategy")
    private DockerBuildStrategy dockerStrategy;
    @JsonProperty("jenkinsPipelineStrategy")
    private JenkinsPipelineBuildStrategy jenkinsPipelineStrategy;
    @JsonProperty("sourceStrategy")
    private SourceBuildStrategy sourceStrategy;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BuildStrategy() {
    }

    /**
     * 
     * @param jenkinsPipelineStrategy
     * @param sourceStrategy
     * @param dockerStrategy
     * @param type
     * @param customStrategy
     */
    public BuildStrategy(CustomBuildStrategy customStrategy, DockerBuildStrategy dockerStrategy, JenkinsPipelineBuildStrategy jenkinsPipelineStrategy, SourceBuildStrategy sourceStrategy, String type) {
        super();
        this.customStrategy = customStrategy;
        this.dockerStrategy = dockerStrategy;
        this.jenkinsPipelineStrategy = jenkinsPipelineStrategy;
        this.sourceStrategy = sourceStrategy;
        this.type = type;
    }

    @JsonProperty("customStrategy")
    public CustomBuildStrategy getCustomStrategy() {
        return customStrategy;
    }

    @JsonProperty("customStrategy")
    public void setCustomStrategy(CustomBuildStrategy customStrategy) {
        this.customStrategy = customStrategy;
    }

    @JsonProperty("dockerStrategy")
    public DockerBuildStrategy getDockerStrategy() {
        return dockerStrategy;
    }

    @JsonProperty("dockerStrategy")
    public void setDockerStrategy(DockerBuildStrategy dockerStrategy) {
        this.dockerStrategy = dockerStrategy;
    }

    @JsonProperty("jenkinsPipelineStrategy")
    public JenkinsPipelineBuildStrategy getJenkinsPipelineStrategy() {
        return jenkinsPipelineStrategy;
    }

    @JsonProperty("jenkinsPipelineStrategy")
    public void setJenkinsPipelineStrategy(JenkinsPipelineBuildStrategy jenkinsPipelineStrategy) {
        this.jenkinsPipelineStrategy = jenkinsPipelineStrategy;
    }

    @JsonProperty("sourceStrategy")
    public SourceBuildStrategy getSourceStrategy() {
        return sourceStrategy;
    }

    @JsonProperty("sourceStrategy")
    public void setSourceStrategy(SourceBuildStrategy sourceStrategy) {
        this.sourceStrategy = sourceStrategy;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
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
