
package io.fabric8.kubernetes.api.model.kustomize.v1beta1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "path",
    "source",
    "sourceValue",
    "targets"
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
public class ReplacementField implements Editable<ReplacementFieldBuilder>, KubernetesResource
{

    @JsonProperty("path")
    private String path;
    @JsonProperty("source")
    private SourceSelector source;
    @JsonProperty("sourceValue")
    private String sourceValue;
    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TargetSelector> targets = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ReplacementField() {
    }

    public ReplacementField(String path, SourceSelector source, String sourceValue, List<TargetSelector> targets) {
        super();
        this.path = path;
        this.source = source;
        this.sourceValue = sourceValue;
        this.targets = targets;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("source")
    public SourceSelector getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(SourceSelector source) {
        this.source = source;
    }

    @JsonProperty("sourceValue")
    public String getSourceValue() {
        return sourceValue;
    }

    @JsonProperty("sourceValue")
    public void setSourceValue(String sourceValue) {
        this.sourceValue = sourceValue;
    }

    @JsonProperty("targets")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<TargetSelector> getTargets() {
        return targets;
    }

    @JsonProperty("targets")
    public void setTargets(List<TargetSelector> targets) {
        this.targets = targets;
    }

    @JsonIgnore
    public ReplacementFieldBuilder edit() {
        return new ReplacementFieldBuilder(this);
    }

    @JsonIgnore
    public ReplacementFieldBuilder toBuilder() {
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
        if (!(o instanceof ReplacementField)) {
            return false;
        }
        ReplacementField other = (ReplacementField) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$source = this.getSource();
        Object other$source = other.getSource();
        if (this$source == null ? other$source != null : !this$source.equals(other$source)) {
            return false;
        }
        Object this$sourceValue = this.getSourceValue();
        Object other$sourceValue = other.getSourceValue();
        if (this$sourceValue == null ? other$sourceValue != null : !this$sourceValue.equals(other$sourceValue)) {
            return false;
        }
        Object this$targets = this.getTargets();
        Object other$targets = other.getTargets();
        if (this$targets == null ? other$targets != null : !this$targets.equals(other$targets)) {
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
        return other instanceof ReplacementField;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $source = this.getSource();
        result = result * prime + ($source == null ? 43 : $source.hashCode());
        Object $sourceValue = this.getSourceValue();
        result = result * prime + ($sourceValue == null ? 43 : $sourceValue.hashCode());
        Object $targets = this.getTargets();
        result = result * prime + ($targets == null ? 43 : $targets.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ReplacementField(" + "path=" + this.getPath() + ", source=" + this.getSource() + ", sourceValue=" + this.getSourceValue() + ", targets=" + this.getTargets() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
