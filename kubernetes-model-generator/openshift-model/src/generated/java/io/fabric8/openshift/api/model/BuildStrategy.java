
package io.fabric8.openshift.api.model;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * BuildStrategy contains the details of how to perform a build.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "customStrategy",
    "dockerStrategy",
    "jenkinsPipelineStrategy",
    "sourceStrategy",
    "type"
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class BuildStrategy implements Editable<BuildStrategyBuilder>, KubernetesResource
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
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public BuildStrategy() {
    }

    public BuildStrategy(CustomBuildStrategy customStrategy, DockerBuildStrategy dockerStrategy, JenkinsPipelineBuildStrategy jenkinsPipelineStrategy, SourceBuildStrategy sourceStrategy, String type) {
        super();
        this.customStrategy = customStrategy;
        this.dockerStrategy = dockerStrategy;
        this.jenkinsPipelineStrategy = jenkinsPipelineStrategy;
        this.sourceStrategy = sourceStrategy;
        this.type = type;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("customStrategy")
    public CustomBuildStrategy getCustomStrategy() {
        return customStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("customStrategy")
    public void setCustomStrategy(CustomBuildStrategy customStrategy) {
        this.customStrategy = customStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("dockerStrategy")
    public DockerBuildStrategy getDockerStrategy() {
        return dockerStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("dockerStrategy")
    public void setDockerStrategy(DockerBuildStrategy dockerStrategy) {
        this.dockerStrategy = dockerStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("jenkinsPipelineStrategy")
    public JenkinsPipelineBuildStrategy getJenkinsPipelineStrategy() {
        return jenkinsPipelineStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("jenkinsPipelineStrategy")
    public void setJenkinsPipelineStrategy(JenkinsPipelineBuildStrategy jenkinsPipelineStrategy) {
        this.jenkinsPipelineStrategy = jenkinsPipelineStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("sourceStrategy")
    public SourceBuildStrategy getSourceStrategy() {
        return sourceStrategy;
    }

    /**
     * BuildStrategy contains the details of how to perform a build.
     */
    @JsonProperty("sourceStrategy")
    public void setSourceStrategy(SourceBuildStrategy sourceStrategy) {
        this.sourceStrategy = sourceStrategy;
    }

    /**
     * type is the kind of build strategy.
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type is the kind of build strategy.
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public BuildStrategyBuilder edit() {
        return new BuildStrategyBuilder(this);
    }

    @JsonIgnore
    public BuildStrategyBuilder toBuilder() {
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
        if (!(o instanceof BuildStrategy)) {
            return false;
        }
        BuildStrategy other = (BuildStrategy) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$customStrategy = this.getCustomStrategy();
        Object other$customStrategy = other.getCustomStrategy();
        if (this$customStrategy == null ? other$customStrategy != null : !this$customStrategy.equals(other$customStrategy)) {
            return false;
        }
        Object this$dockerStrategy = this.getDockerStrategy();
        Object other$dockerStrategy = other.getDockerStrategy();
        if (this$dockerStrategy == null ? other$dockerStrategy != null : !this$dockerStrategy.equals(other$dockerStrategy)) {
            return false;
        }
        Object this$jenkinsPipelineStrategy = this.getJenkinsPipelineStrategy();
        Object other$jenkinsPipelineStrategy = other.getJenkinsPipelineStrategy();
        if (this$jenkinsPipelineStrategy == null ? other$jenkinsPipelineStrategy != null : !this$jenkinsPipelineStrategy.equals(other$jenkinsPipelineStrategy)) {
            return false;
        }
        Object this$sourceStrategy = this.getSourceStrategy();
        Object other$sourceStrategy = other.getSourceStrategy();
        if (this$sourceStrategy == null ? other$sourceStrategy != null : !this$sourceStrategy.equals(other$sourceStrategy)) {
            return false;
        }
        Object this$type = this.getType();
        Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) {
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
        return other instanceof BuildStrategy;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $customStrategy = this.getCustomStrategy();
        result = result * prime + ($customStrategy == null ? 43 : $customStrategy.hashCode());
        Object $dockerStrategy = this.getDockerStrategy();
        result = result * prime + ($dockerStrategy == null ? 43 : $dockerStrategy.hashCode());
        Object $jenkinsPipelineStrategy = this.getJenkinsPipelineStrategy();
        result = result * prime + ($jenkinsPipelineStrategy == null ? 43 : $jenkinsPipelineStrategy.hashCode());
        Object $sourceStrategy = this.getSourceStrategy();
        result = result * prime + ($sourceStrategy == null ? 43 : $sourceStrategy.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BuildStrategy(" + "customStrategy=" + this.getCustomStrategy() + ", dockerStrategy=" + this.getDockerStrategy() + ", jenkinsPipelineStrategy=" + this.getJenkinsPipelineStrategy() + ", sourceStrategy=" + this.getSourceStrategy() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
