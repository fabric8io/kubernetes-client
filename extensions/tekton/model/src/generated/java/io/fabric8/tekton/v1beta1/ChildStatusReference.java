
package io.fabric8.tekton.v1beta1;

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

/**
 * ChildStatusReference is used to point to the statuses of individual TaskRuns and Runs within this PipelineRun.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "displayName",
    "name",
    "pipelineTaskName",
    "whenExpressions"
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
public class ChildStatusReference implements Editable<ChildStatusReferenceBuilder>, KubernetesResource
{

    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pipelineTaskName")
    private String pipelineTaskName;
    @JsonProperty("whenExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<WhenExpression> whenExpressions = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ChildStatusReference() {
    }

    public ChildStatusReference(String apiVersion, String displayName, String kind, String name, String pipelineTaskName, List<WhenExpression> whenExpressions) {
        super();
        this.apiVersion = apiVersion;
        this.displayName = displayName;
        this.kind = kind;
        this.name = name;
        this.pipelineTaskName = pipelineTaskName;
        this.whenExpressions = whenExpressions;
    }

    /**
     * ChildStatusReference is used to point to the statuses of individual TaskRuns and Runs within this PipelineRun.
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * ChildStatusReference is used to point to the statuses of individual TaskRuns and Runs within this PipelineRun.
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * DisplayName is a user-facing name of the pipelineTask that may be used to populate a UI.
     */
    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * DisplayName is a user-facing name of the pipelineTask that may be used to populate a UI.
     */
    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * ChildStatusReference is used to point to the statuses of individual TaskRuns and Runs within this PipelineRun.
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * ChildStatusReference is used to point to the statuses of individual TaskRuns and Runs within this PipelineRun.
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * Name is the name of the TaskRun or Run this is referencing.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name is the name of the TaskRun or Run this is referencing.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * PipelineTaskName is the name of the PipelineTask this is referencing.
     */
    @JsonProperty("pipelineTaskName")
    public String getPipelineTaskName() {
        return pipelineTaskName;
    }

    /**
     * PipelineTaskName is the name of the PipelineTask this is referencing.
     */
    @JsonProperty("pipelineTaskName")
    public void setPipelineTaskName(String pipelineTaskName) {
        this.pipelineTaskName = pipelineTaskName;
    }

    /**
     * WhenExpressions is the list of checks guarding the execution of the PipelineTask
     */
    @JsonProperty("whenExpressions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<WhenExpression> getWhenExpressions() {
        return whenExpressions;
    }

    /**
     * WhenExpressions is the list of checks guarding the execution of the PipelineTask
     */
    @JsonProperty("whenExpressions")
    public void setWhenExpressions(List<WhenExpression> whenExpressions) {
        this.whenExpressions = whenExpressions;
    }

    @JsonIgnore
    public ChildStatusReferenceBuilder edit() {
        return new ChildStatusReferenceBuilder(this);
    }

    @JsonIgnore
    public ChildStatusReferenceBuilder toBuilder() {
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
        if (!(o instanceof ChildStatusReference)) {
            return false;
        }
        ChildStatusReference other = (ChildStatusReference) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVersion = this.getApiVersion();
        Object other$apiVersion = other.getApiVersion();
        if (this$apiVersion == null ? other$apiVersion != null : !this$apiVersion.equals(other$apiVersion)) {
            return false;
        }
        Object this$displayName = this.getDisplayName();
        Object other$displayName = other.getDisplayName();
        if (this$displayName == null ? other$displayName != null : !this$displayName.equals(other$displayName)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$pipelineTaskName = this.getPipelineTaskName();
        Object other$pipelineTaskName = other.getPipelineTaskName();
        if (this$pipelineTaskName == null ? other$pipelineTaskName != null : !this$pipelineTaskName.equals(other$pipelineTaskName)) {
            return false;
        }
        Object this$whenExpressions = this.getWhenExpressions();
        Object other$whenExpressions = other.getWhenExpressions();
        if (this$whenExpressions == null ? other$whenExpressions != null : !this$whenExpressions.equals(other$whenExpressions)) {
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
        return other instanceof ChildStatusReference;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVersion = this.getApiVersion();
        result = result * prime + ($apiVersion == null ? 43 : $apiVersion.hashCode());
        Object $displayName = this.getDisplayName();
        result = result * prime + ($displayName == null ? 43 : $displayName.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $pipelineTaskName = this.getPipelineTaskName();
        result = result * prime + ($pipelineTaskName == null ? 43 : $pipelineTaskName.hashCode());
        Object $whenExpressions = this.getWhenExpressions();
        result = result * prime + ($whenExpressions == null ? 43 : $whenExpressions.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ChildStatusReference(" + "apiVersion=" + this.getApiVersion() + ", displayName=" + this.getDisplayName() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", pipelineTaskName=" + this.getPipelineTaskName() + ", whenExpressions=" + this.getWhenExpressions() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
