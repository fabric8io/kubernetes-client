
package io.fabric8.openshift.api.model.insights.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
 * DataGatherStatus contains information relating to the DataGather state.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "dataGatherState",
    "finishTime",
    "gatherers",
    "insightsReport",
    "insightsRequestID",
    "relatedObjects",
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class DataGatherStatus implements Editable<DataGatherStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("dataGatherState")
    private String dataGatherState;
    @JsonProperty("finishTime")
    private String finishTime;
    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<GathererStatus> gatherers = new ArrayList<>();
    @JsonProperty("insightsReport")
    private InsightsReport insightsReport;
    @JsonProperty("insightsRequestID")
    private String insightsRequestID;
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ObjectReference> relatedObjects = new ArrayList<>();
    @JsonProperty("startTime")
    private String startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public DataGatherStatus() {
    }

    public DataGatherStatus(List<Condition> conditions, String dataGatherState, String finishTime, List<GathererStatus> gatherers, InsightsReport insightsReport, String insightsRequestID, List<ObjectReference> relatedObjects, String startTime) {
        super();
        this.conditions = conditions;
        this.dataGatherState = dataGatherState;
        this.finishTime = finishTime;
        this.gatherers = gatherers;
        this.insightsReport = insightsReport;
        this.insightsRequestID = insightsRequestID;
        this.relatedObjects = relatedObjects;
        this.startTime = startTime;
    }

    /**
     * conditions provide details on the status of the gatherer job.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions provide details on the status of the gatherer job.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * dataGatherState reflects the current state of the data gathering process.
     */
    @JsonProperty("dataGatherState")
    public String getDataGatherState() {
        return dataGatherState;
    }

    /**
     * dataGatherState reflects the current state of the data gathering process.
     */
    @JsonProperty("dataGatherState")
    public void setDataGatherState(String dataGatherState) {
        this.dataGatherState = dataGatherState;
    }

    /**
     * DataGatherStatus contains information relating to the DataGather state.
     */
    @JsonProperty("finishTime")
    public String getFinishTime() {
        return finishTime;
    }

    /**
     * DataGatherStatus contains information relating to the DataGather state.
     */
    @JsonProperty("finishTime")
    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * gatherers is a list of active gatherers (and their statuses) in the last gathering.
     */
    @JsonProperty("gatherers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<GathererStatus> getGatherers() {
        return gatherers;
    }

    /**
     * gatherers is a list of active gatherers (and their statuses) in the last gathering.
     */
    @JsonProperty("gatherers")
    public void setGatherers(List<GathererStatus> gatherers) {
        this.gatherers = gatherers;
    }

    /**
     * DataGatherStatus contains information relating to the DataGather state.
     */
    @JsonProperty("insightsReport")
    public InsightsReport getInsightsReport() {
        return insightsReport;
    }

    /**
     * DataGatherStatus contains information relating to the DataGather state.
     */
    @JsonProperty("insightsReport")
    public void setInsightsReport(InsightsReport insightsReport) {
        this.insightsReport = insightsReport;
    }

    /**
     * insightsRequestID is an Insights request ID to track the status of the Insights analysis (in console.redhat.com processing pipeline) for the corresponding Insights data archive.
     */
    @JsonProperty("insightsRequestID")
    public String getInsightsRequestID() {
        return insightsRequestID;
    }

    /**
     * insightsRequestID is an Insights request ID to track the status of the Insights analysis (in console.redhat.com processing pipeline) for the corresponding Insights data archive.
     */
    @JsonProperty("insightsRequestID")
    public void setInsightsRequestID(String insightsRequestID) {
        this.insightsRequestID = insightsRequestID;
    }

    /**
     * relatedObjects is a list of resources which are useful when debugging or inspecting the data gathering Pod
     */
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    /**
     * relatedObjects is a list of resources which are useful when debugging or inspecting the data gathering Pod
     */
    @JsonProperty("relatedObjects")
    public void setRelatedObjects(List<ObjectReference> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    /**
     * DataGatherStatus contains information relating to the DataGather state.
     */
    @JsonProperty("startTime")
    public String getStartTime() {
        return startTime;
    }

    /**
     * DataGatherStatus contains information relating to the DataGather state.
     */
    @JsonProperty("startTime")
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @JsonIgnore
    public DataGatherStatusBuilder edit() {
        return new DataGatherStatusBuilder(this);
    }

    @JsonIgnore
    public DataGatherStatusBuilder toBuilder() {
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
