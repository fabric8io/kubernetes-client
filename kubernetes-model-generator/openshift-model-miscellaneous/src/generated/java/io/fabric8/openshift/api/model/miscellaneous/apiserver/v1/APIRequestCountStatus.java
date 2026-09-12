
package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

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
    "conditions",
    "currentHour",
    "last24h",
    "removedInRelease",
    "requestCount"
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
public class APIRequestCountStatus implements Editable<APIRequestCountStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
    @JsonProperty("currentHour")
    private PerResourceAPIRequestLog currentHour;
    @JsonProperty("last24h")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PerResourceAPIRequestLog> last24h = new ArrayList<>();
    @JsonProperty("removedInRelease")
    private String removedInRelease;
    @JsonProperty("requestCount")
    private Long requestCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public APIRequestCountStatus() {
    }

    public APIRequestCountStatus(List<Condition> conditions, PerResourceAPIRequestLog currentHour, List<PerResourceAPIRequestLog> last24h, String removedInRelease, Long requestCount) {
        super();
        this.conditions = conditions;
        this.currentHour = currentHour;
        this.last24h = last24h;
        this.removedInRelease = removedInRelease;
        this.requestCount = requestCount;
    }

    /**
     * conditions contains details of the current status of this API Resource.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions contains details of the current status of this API Resource.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("currentHour")
    public PerResourceAPIRequestLog getCurrentHour() {
        return currentHour;
    }

    @JsonProperty("currentHour")
    public void setCurrentHour(PerResourceAPIRequestLog currentHour) {
        this.currentHour = currentHour;
    }

    /**
     * last24h contains request history for the last 24 hours, indexed by the hour, so 12:00AM-12:59 is in index 0, 6am-6:59am is index 6, etc. The index of the current hour is updated live and then duplicated into the requestsLastHour field.
     */
    @JsonProperty("last24h")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<PerResourceAPIRequestLog> getLast24h() {
        return last24h;
    }

    /**
     * last24h contains request history for the last 24 hours, indexed by the hour, so 12:00AM-12:59 is in index 0, 6am-6:59am is index 6, etc. The index of the current hour is updated live and then duplicated into the requestsLastHour field.
     */
    @JsonProperty("last24h")
    public void setLast24h(List<PerResourceAPIRequestLog> last24h) {
        this.last24h = last24h;
    }

    /**
     * removedInRelease is when the API will be removed.
     */
    @JsonProperty("removedInRelease")
    public String getRemovedInRelease() {
        return removedInRelease;
    }

    /**
     * removedInRelease is when the API will be removed.
     */
    @JsonProperty("removedInRelease")
    public void setRemovedInRelease(String removedInRelease) {
        this.removedInRelease = removedInRelease;
    }

    /**
     * requestCount is a sum of all requestCounts across all current hours, nodes, and users.
     */
    @JsonProperty("requestCount")
    public Long getRequestCount() {
        return requestCount;
    }

    /**
     * requestCount is a sum of all requestCounts across all current hours, nodes, and users.
     */
    @JsonProperty("requestCount")
    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    @JsonIgnore
    public APIRequestCountStatusBuilder edit() {
        return new APIRequestCountStatusBuilder(this);
    }

    @JsonIgnore
    public APIRequestCountStatusBuilder toBuilder() {
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
        if (!(o instanceof APIRequestCountStatus)) {
            return false;
        }
        APIRequestCountStatus other = (APIRequestCountStatus) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$conditions = this.getConditions();
        Object other$conditions = other.getConditions();
        if (this$conditions == null ? other$conditions != null : !this$conditions.equals(other$conditions)) {
            return false;
        }
        Object this$currentHour = this.getCurrentHour();
        Object other$currentHour = other.getCurrentHour();
        if (this$currentHour == null ? other$currentHour != null : !this$currentHour.equals(other$currentHour)) {
            return false;
        }
        Object this$last24h = this.getLast24h();
        Object other$last24h = other.getLast24h();
        if (this$last24h == null ? other$last24h != null : !this$last24h.equals(other$last24h)) {
            return false;
        }
        Object this$removedInRelease = this.getRemovedInRelease();
        Object other$removedInRelease = other.getRemovedInRelease();
        if (this$removedInRelease == null ? other$removedInRelease != null : !this$removedInRelease.equals(other$removedInRelease)) {
            return false;
        }
        Object this$requestCount = this.getRequestCount();
        Object other$requestCount = other.getRequestCount();
        if (this$requestCount == null ? other$requestCount != null : !this$requestCount.equals(other$requestCount)) {
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
        return other instanceof APIRequestCountStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $conditions = this.getConditions();
        result = result * prime + ($conditions == null ? 43 : $conditions.hashCode());
        Object $currentHour = this.getCurrentHour();
        result = result * prime + ($currentHour == null ? 43 : $currentHour.hashCode());
        Object $last24h = this.getLast24h();
        result = result * prime + ($last24h == null ? 43 : $last24h.hashCode());
        Object $removedInRelease = this.getRemovedInRelease();
        result = result * prime + ($removedInRelease == null ? 43 : $removedInRelease.hashCode());
        Object $requestCount = this.getRequestCount();
        result = result * prime + ($requestCount == null ? 43 : $requestCount.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "APIRequestCountStatus(" + "conditions=" + this.getConditions() + ", currentHour=" + this.getCurrentHour() + ", last24h=" + this.getLast24h() + ", removedInRelease=" + this.getRemovedInRelease() + ", requestCount=" + this.getRequestCount() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
