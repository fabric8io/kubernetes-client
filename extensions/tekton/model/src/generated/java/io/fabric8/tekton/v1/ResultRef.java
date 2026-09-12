
package io.fabric8.tekton.v1;

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
 * ResultRef is a type that represents a reference to a task run result
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pipelineTask",
    "property",
    "result",
    "resultsIndex"
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
public class ResultRef implements Editable<ResultRefBuilder>, KubernetesResource
{

    @JsonProperty("pipelineTask")
    private String pipelineTask;
    @JsonProperty("property")
    private String property;
    @JsonProperty("result")
    private String result;
    @JsonProperty("resultsIndex")
    private Integer resultsIndex;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ResultRef() {
    }

    public ResultRef(String pipelineTask, String property, String result, Integer resultsIndex) {
        super();
        this.pipelineTask = pipelineTask;
        this.property = property;
        this.result = result;
        this.resultsIndex = resultsIndex;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("pipelineTask")
    public String getPipelineTask() {
        return pipelineTask;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("pipelineTask")
    public void setPipelineTask(String pipelineTask) {
        this.pipelineTask = pipelineTask;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("property")
    public String getProperty() {
        return property;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("property")
    public void setProperty(String property) {
        this.property = property;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("result")
    public String getResult() {
        return result;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("result")
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("resultsIndex")
    public Integer getResultsIndex() {
        return resultsIndex;
    }

    /**
     * ResultRef is a type that represents a reference to a task run result
     */
    @JsonProperty("resultsIndex")
    public void setResultsIndex(Integer resultsIndex) {
        this.resultsIndex = resultsIndex;
    }

    @JsonIgnore
    public ResultRefBuilder edit() {
        return new ResultRefBuilder(this);
    }

    @JsonIgnore
    public ResultRefBuilder toBuilder() {
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
        if (!(o instanceof ResultRef)) {
            return false;
        }
        ResultRef other = (ResultRef) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$pipelineTask = this.getPipelineTask();
        Object other$pipelineTask = other.getPipelineTask();
        if (this$pipelineTask == null ? other$pipelineTask != null : !this$pipelineTask.equals(other$pipelineTask)) {
            return false;
        }
        Object this$property = this.getProperty();
        Object other$property = other.getProperty();
        if (this$property == null ? other$property != null : !this$property.equals(other$property)) {
            return false;
        }
        Object this$result = this.getResult();
        Object other$result = other.getResult();
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) {
            return false;
        }
        Object this$resultsIndex = this.getResultsIndex();
        Object other$resultsIndex = other.getResultsIndex();
        if (this$resultsIndex == null ? other$resultsIndex != null : !this$resultsIndex.equals(other$resultsIndex)) {
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
        return other instanceof ResultRef;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $pipelineTask = this.getPipelineTask();
        result = result * prime + ($pipelineTask == null ? 43 : $pipelineTask.hashCode());
        Object $property = this.getProperty();
        result = result * prime + ($property == null ? 43 : $property.hashCode());
        Object $result = this.getResult();
        result = result * prime + ($result == null ? 43 : $result.hashCode());
        Object $resultsIndex = this.getResultsIndex();
        result = result * prime + ($resultsIndex == null ? 43 : $resultsIndex.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ResultRef(" + "pipelineTask=" + this.getPipelineTask() + ", property=" + this.getProperty() + ", result=" + this.getResult() + ", resultsIndex=" + this.getResultsIndex() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
