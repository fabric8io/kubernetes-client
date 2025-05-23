
package io.fabric8.tekton.v1alpha1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "completionTime",
    "extraFields",
    "results",
    "retriesStatus",
    "startTime"
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
public class RunStatusFields implements Editable<RunStatusFieldsBuilder>, KubernetesResource
{

    @JsonProperty("completionTime")
    private String completionTime;
    @JsonProperty("extraFields")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object extraFields;
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RunResult> results = new ArrayList<>();
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<RunStatus> retriesStatus = new ArrayList<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public RunStatusFields() {
    }

    public RunStatusFields(String completionTime, Object extraFields, List<RunResult> results, List<RunStatus> retriesStatus, String startTime) {
        super();
        this.completionTime = completionTime;
        this.extraFields = extraFields;
        this.results = results;
        this.retriesStatus = retriesStatus;
        this.startTime = startTime;
    }

    /**
     * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("completionTime")
    public String getCompletionTime() {
        return completionTime;
    }

    /**
     * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("completionTime")
    public void setCompletionTime(String completionTime) {
        this.completionTime = completionTime;
    }

    /**
     * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("extraFields")
    public Object getExtraFields() {
        return extraFields;
    }

    /**
     * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("extraFields")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setExtraFields(Object extraFields) {
        this.extraFields = extraFields;
    }

    /**
     * Results reports any output result values to be consumed by later tasks in a pipeline.
     */
    @JsonProperty("results")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RunResult> getResults() {
        return results;
    }

    /**
     * Results reports any output result values to be consumed by later tasks in a pipeline.
     */
    @JsonProperty("results")
    public void setResults(List<RunResult> results) {
        this.results = results;
    }

    /**
     * RetriesStatus contains the history of RunStatus, in case of a retry.
     */
    @JsonProperty("retriesStatus")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<RunStatus> getRetriesStatus() {
        return retriesStatus;
    }

    /**
     * RetriesStatus contains the history of RunStatus, in case of a retry.
     */
    @JsonProperty("retriesStatus")
    public void setRetriesStatus(List<RunStatus> retriesStatus) {
        this.retriesStatus = retriesStatus;
    }

    /**
     * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * RunStatusFields holds the fields of Run's status.  This is defined separately and inlined so that other types can readily consume these fields via duck typing.
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public RunStatusFieldsBuilder edit() {
        return new RunStatusFieldsBuilder(this);
    }

    @JsonIgnore
    public RunStatusFieldsBuilder toBuilder() {
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
