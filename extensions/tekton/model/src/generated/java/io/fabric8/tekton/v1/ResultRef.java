
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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
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

}
