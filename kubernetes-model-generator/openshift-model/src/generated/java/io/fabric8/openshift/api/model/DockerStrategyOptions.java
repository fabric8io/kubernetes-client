
package io.fabric8.openshift.api.model;

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
 * DockerStrategyOptions contains extra strategy options for container image builds
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "buildArgs",
    "noCache"
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
public class DockerStrategyOptions implements Editable<DockerStrategyOptionsBuilder>, KubernetesResource
{

    @JsonProperty("buildArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EnvVar> buildArgs = new ArrayList<>();
    @JsonProperty("noCache")
    private Boolean noCache;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DockerStrategyOptions() {
    }

    public DockerStrategyOptions(List<EnvVar> buildArgs, Boolean noCache) {
        super();
        this.buildArgs = buildArgs;
        this.noCache = noCache;
    }

    /**
     * Args contains any build arguments that are to be passed to Docker.  See https://docs.docker.com/engine/reference/builder/#/arg for more details
     */
    @JsonProperty("buildArgs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EnvVar> getBuildArgs() {
        return buildArgs;
    }

    /**
     * Args contains any build arguments that are to be passed to Docker.  See https://docs.docker.com/engine/reference/builder/#/arg for more details
     */
    @JsonProperty("buildArgs")
    public void setBuildArgs(List<EnvVar> buildArgs) {
        this.buildArgs = buildArgs;
    }

    /**
     * noCache overrides the docker-strategy noCache option in the build config
     */
    @JsonProperty("noCache")
    public Boolean getNoCache() {
        return noCache;
    }

    /**
     * noCache overrides the docker-strategy noCache option in the build config
     */
    @JsonProperty("noCache")
    public void setNoCache(Boolean noCache) {
        this.noCache = noCache;
    }

    @JsonIgnore
    public DockerStrategyOptionsBuilder edit() {
        return new DockerStrategyOptionsBuilder(this);
    }

    @JsonIgnore
    public DockerStrategyOptionsBuilder toBuilder() {
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
        if (!(o instanceof DockerStrategyOptions)) {
            return false;
        }
        DockerStrategyOptions other = (DockerStrategyOptions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$buildArgs = this.getBuildArgs();
        Object other$buildArgs = other.getBuildArgs();
        if (this$buildArgs == null ? other$buildArgs != null : !this$buildArgs.equals(other$buildArgs)) {
            return false;
        }
        Object this$noCache = this.getNoCache();
        Object other$noCache = other.getNoCache();
        if (this$noCache == null ? other$noCache != null : !this$noCache.equals(other$noCache)) {
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
        return other instanceof DockerStrategyOptions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $buildArgs = this.getBuildArgs();
        result = result * prime + ($buildArgs == null ? 43 : $buildArgs.hashCode());
        Object $noCache = this.getNoCache();
        result = result * prime + ($noCache == null ? 43 : $noCache.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DockerStrategyOptions(" + "buildArgs=" + this.getBuildArgs() + ", noCache=" + this.getNoCache() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
