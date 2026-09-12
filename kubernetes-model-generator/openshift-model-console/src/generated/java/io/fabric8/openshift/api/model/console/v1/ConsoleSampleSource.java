
package io.fabric8.openshift.api.model.console.v1;

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

/**
 * ConsoleSampleSource is the actual sample definition and can hold different sample types. Unsupported sample types will be ignored in the web console.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "containerImport",
    "gitImport",
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
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ConsoleSampleSource implements Editable<ConsoleSampleSourceBuilder>, KubernetesResource
{

    @JsonProperty("containerImport")
    private ConsoleSampleContainerImportSource containerImport;
    @JsonProperty("gitImport")
    private ConsoleSampleGitImportSource gitImport;
    @JsonProperty("type")
    private String type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ConsoleSampleSource() {
    }

    public ConsoleSampleSource(ConsoleSampleContainerImportSource containerImport, ConsoleSampleGitImportSource gitImport, String type) {
        super();
        this.containerImport = containerImport;
        this.gitImport = gitImport;
        this.type = type;
    }

    /**
     * ConsoleSampleSource is the actual sample definition and can hold different sample types. Unsupported sample types will be ignored in the web console.
     */
    @JsonProperty("containerImport")
    public ConsoleSampleContainerImportSource getContainerImport() {
        return containerImport;
    }

    /**
     * ConsoleSampleSource is the actual sample definition and can hold different sample types. Unsupported sample types will be ignored in the web console.
     */
    @JsonProperty("containerImport")
    public void setContainerImport(ConsoleSampleContainerImportSource containerImport) {
        this.containerImport = containerImport;
    }

    /**
     * ConsoleSampleSource is the actual sample definition and can hold different sample types. Unsupported sample types will be ignored in the web console.
     */
    @JsonProperty("gitImport")
    public ConsoleSampleGitImportSource getGitImport() {
        return gitImport;
    }

    /**
     * ConsoleSampleSource is the actual sample definition and can hold different sample types. Unsupported sample types will be ignored in the web console.
     */
    @JsonProperty("gitImport")
    public void setGitImport(ConsoleSampleGitImportSource gitImport) {
        this.gitImport = gitImport;
    }

    /**
     * type of the sample, currently supported: "GitImport";"ContainerImport"
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * type of the sample, currently supported: "GitImport";"ContainerImport"
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonIgnore
    public ConsoleSampleSourceBuilder edit() {
        return new ConsoleSampleSourceBuilder(this);
    }

    @JsonIgnore
    public ConsoleSampleSourceBuilder toBuilder() {
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
        if (!(o instanceof ConsoleSampleSource)) {
            return false;
        }
        ConsoleSampleSource other = (ConsoleSampleSource) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$containerImport = this.getContainerImport();
        Object other$containerImport = other.getContainerImport();
        if (this$containerImport == null ? other$containerImport != null : !this$containerImport.equals(other$containerImport)) {
            return false;
        }
        Object this$gitImport = this.getGitImport();
        Object other$gitImport = other.getGitImport();
        if (this$gitImport == null ? other$gitImport != null : !this$gitImport.equals(other$gitImport)) {
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
        return other instanceof ConsoleSampleSource;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $containerImport = this.getContainerImport();
        result = result * prime + ($containerImport == null ? 43 : $containerImport.hashCode());
        Object $gitImport = this.getGitImport();
        result = result * prime + ($gitImport == null ? 43 : $gitImport.hashCode());
        Object $type = this.getType();
        result = result * prime + ($type == null ? 43 : $type.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ConsoleSampleSource(" + "containerImport=" + this.getContainerImport() + ", gitImport=" + this.getGitImport() + ", type=" + this.getType() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
