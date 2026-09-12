
package io.fabric8.openshift.api.model.insights.v1alpha2;

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

/**
 * DataGatherStatus contains information relating to the DataGather state.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "conditions",
    "finishTime",
    "gatherers",
    "insightsReport",
    "insightsRequestID",
    "relatedObjects",
    "startTime"
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

    public DataGatherStatus(List<Condition> conditions, String finishTime, List<GathererStatus> gatherers, InsightsReport insightsReport, String insightsRequestID, List<ObjectReference> relatedObjects, String startTime) {
        super();
        this.conditions = conditions;
        this.finishTime = finishTime;
        this.gatherers = gatherers;
        this.insightsReport = insightsReport;
        this.insightsRequestID = insightsRequestID;
        this.relatedObjects = relatedObjects;
        this.startTime = startTime;
    }

    /**
     * conditions is an optional field that provides details on the status of the gatherer job. It may not exceed 100 items and must not contain duplicates.<br><p> <br><p> The current condition types are DataUploaded, DataRecorded, DataProcessed, RemoteConfigurationNotAvailable, RemoteConfigurationInvalid<br><p> <br><p> The DataUploaded condition is used to represent whether or not the archive was successfully uploaded for further processing. When it has a status of True and a reason of Succeeded, the archive was successfully uploaded. When it has a status of Unknown and a reason of NoUploadYet, the upload has not occurred, or there was no data to upload. When it has a status of False and a reason Failed, the upload failed. The accompanying message will include the specific error encountered.<br><p> <br><p> The DataRecorded condition is used to represent whether or not the archive was successfully recorded. When it has a status of True and a reason of Succeeded, the archive was recorded successfully. When it has a status of Unknown and a reason of NoDataGatheringYet, the data gathering process has not started yet. When it has a status of False and a reason of RecordingFailed, the recording failed and a message will include the specific error encountered.<br><p> <br><p> The DataProcessed condition is used to represent whether or not the archive was processed by the processing service. When it has a status of True and a reason of Processed, the data was processed successfully. When it has a status of Unknown and a reason of NothingToProcessYet, there is no data to process at the moment. When it has a status of False and a reason of Failure, processing failed and a message will include the specific error encountered.<br><p> <br><p> The RemoteConfigurationAvailable condition is used to represent whether the remote configuration is available. When it has a status of Unknown and a reason of Unknown or RemoteConfigNotRequestedYet, the state of the remote configuration is unknown—typically at startup. When it has a status of True and a reason of Succeeded, the configuration is available. When it has a status of False and a reason of NoToken, the configuration was disabled by removing the cloud.openshift.com field from the pull secret. When it has a status of False and a reason of DisabledByConfiguration, the configuration was disabled in insightsdatagather.config.openshift.io.<br><p> <br><p> The RemoteConfigurationValid condition is used to represent whether the remote configuration is valid. When it has a status of Unknown and a reason of Unknown or NoValidationYet, the validity of the remote configuration is unknown—typically at startup. When it has a status of True and a reason of Succeeded, the configuration is valid. When it has a status of False and a reason of Invalid, the configuration is invalid.<br><p> <br><p> The Progressing condition is used to represent the phase of gathering When it has a status of False and the reason is DataGatherPending, the gathering has not started yet. When it has a status of True and reason is Gathering, the gathering is running. When it has a status of False and reason is GatheringSucceeded, the gathering succesfully finished. When it has a status of False and reason is GatheringFailed, the gathering failed.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions is an optional field that provides details on the status of the gatherer job. It may not exceed 100 items and must not contain duplicates.<br><p> <br><p> The current condition types are DataUploaded, DataRecorded, DataProcessed, RemoteConfigurationNotAvailable, RemoteConfigurationInvalid<br><p> <br><p> The DataUploaded condition is used to represent whether or not the archive was successfully uploaded for further processing. When it has a status of True and a reason of Succeeded, the archive was successfully uploaded. When it has a status of Unknown and a reason of NoUploadYet, the upload has not occurred, or there was no data to upload. When it has a status of False and a reason Failed, the upload failed. The accompanying message will include the specific error encountered.<br><p> <br><p> The DataRecorded condition is used to represent whether or not the archive was successfully recorded. When it has a status of True and a reason of Succeeded, the archive was recorded successfully. When it has a status of Unknown and a reason of NoDataGatheringYet, the data gathering process has not started yet. When it has a status of False and a reason of RecordingFailed, the recording failed and a message will include the specific error encountered.<br><p> <br><p> The DataProcessed condition is used to represent whether or not the archive was processed by the processing service. When it has a status of True and a reason of Processed, the data was processed successfully. When it has a status of Unknown and a reason of NothingToProcessYet, there is no data to process at the moment. When it has a status of False and a reason of Failure, processing failed and a message will include the specific error encountered.<br><p> <br><p> The RemoteConfigurationAvailable condition is used to represent whether the remote configuration is available. When it has a status of Unknown and a reason of Unknown or RemoteConfigNotRequestedYet, the state of the remote configuration is unknown—typically at startup. When it has a status of True and a reason of Succeeded, the configuration is available. When it has a status of False and a reason of NoToken, the configuration was disabled by removing the cloud.openshift.com field from the pull secret. When it has a status of False and a reason of DisabledByConfiguration, the configuration was disabled in insightsdatagather.config.openshift.io.<br><p> <br><p> The RemoteConfigurationValid condition is used to represent whether the remote configuration is valid. When it has a status of Unknown and a reason of Unknown or NoValidationYet, the validity of the remote configuration is unknown—typically at startup. When it has a status of True and a reason of Succeeded, the configuration is valid. When it has a status of False and a reason of Invalid, the configuration is invalid.<br><p> <br><p> The Progressing condition is used to represent the phase of gathering When it has a status of False and the reason is DataGatherPending, the gathering has not started yet. When it has a status of True and reason is Gathering, the gathering is running. When it has a status of False and reason is GatheringSucceeded, the gathering succesfully finished. When it has a status of False and reason is GatheringFailed, the gathering failed.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
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
     * insightsRequestID is an optional Insights request ID to track the status of the Insights analysis (in console.redhat.com processing pipeline) for the corresponding Insights data archive. It may not exceed 256 characters and is immutable once set.
     */
    @JsonProperty("insightsRequestID")
    public String getInsightsRequestID() {
        return insightsRequestID;
    }

    /**
     * insightsRequestID is an optional Insights request ID to track the status of the Insights analysis (in console.redhat.com processing pipeline) for the corresponding Insights data archive. It may not exceed 256 characters and is immutable once set.
     */
    @JsonProperty("insightsRequestID")
    public void setInsightsRequestID(String insightsRequestID) {
        this.insightsRequestID = insightsRequestID;
    }

    /**
     * relatedObjects is an optional list of resources which are useful when debugging or inspecting the data gathering Pod It may not exceed 100 items and must not contain duplicates.
     */
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    /**
     * relatedObjects is an optional list of resources which are useful when debugging or inspecting the data gathering Pod It may not exceed 100 items and must not contain duplicates.
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DataGatherStatus)) {
            return false;
        }
        DataGatherStatus other = (DataGatherStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$finishTime = this.getFinishTime();
        Object other$finishTime = other.getFinishTime();
        if (this$finishTime == null ? other$finishTime != null : !this$finishTime.equals(other$finishTime)) {
            return false;
        }
        Object this$gatherers = this.getGatherers();
        Object other$gatherers = other.getGatherers();
        if (this$gatherers == null ? other$gatherers != null : !this$gatherers.equals(other$gatherers)) {
            return false;
        }
        Object this$insightsReport = this.getInsightsReport();
        Object other$insightsReport = other.getInsightsReport();
        if (this$insightsReport == null ? other$insightsReport != null : !this$insightsReport.equals(other$insightsReport)) {
            return false;
        }
        Object this$insightsRequestID = this.getInsightsRequestID();
        Object other$insightsRequestID = other.getInsightsRequestID();
        if (this$insightsRequestID == null ? other$insightsRequestID != null : !this$insightsRequestID.equals(other$insightsRequestID)) {
            return false;
        }
        Object this$relatedObjects = this.getRelatedObjects();
        Object other$relatedObjects = other.getRelatedObjects();
        if (this$relatedObjects == null ? other$relatedObjects != null : !this$relatedObjects.equals(other$relatedObjects)) {
            return false;
        }
        Object this$startTime = this.getStartTime();
        Object other$startTime = other.getStartTime();
        if (this$startTime == null ? other$startTime != null : !this$startTime.equals(other$startTime)) {
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
        return other instanceof DataGatherStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $finishTime = this.getFinishTime();
        result = result * prime + ($finishTime == null ? 43 : $finishTime.hashCode());
        Object $gatherers = this.getGatherers();
        result = result * prime + ($gatherers == null ? 43 : $gatherers.hashCode());
        Object $insightsReport = this.getInsightsReport();
        result = result * prime + ($insightsReport == null ? 43 : $insightsReport.hashCode());
        Object $insightsRequestID = this.getInsightsRequestID();
        result = result * prime + ($insightsRequestID == null ? 43 : $insightsRequestID.hashCode());
        Object $relatedObjects = this.getRelatedObjects();
        result = result * prime + ($relatedObjects == null ? 43 : $relatedObjects.hashCode());
        Object $startTime = this.getStartTime();
        result = result * prime + ($startTime == null ? 43 : $startTime.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "DataGatherStatus(" + "conditions=" + this.getConditions() + ", finishTime=" + this.getFinishTime() + ", gatherers=" + this.getGatherers() + ", insightsReport=" + this.getInsightsReport() + ", insightsRequestID=" + this.getInsightsRequestID() + ", relatedObjects=" + this.getRelatedObjects() + ", startTime=" + this.getStartTime() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
