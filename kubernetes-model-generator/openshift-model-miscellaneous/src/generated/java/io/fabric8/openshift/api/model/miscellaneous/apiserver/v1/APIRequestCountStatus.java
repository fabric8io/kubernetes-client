
package io.fabric8.openshift.api.model.miscellaneous.apiserver.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "currentHour",
    "last24h",
    "removedInRelease",
    "requestCount"
})
@ToString
@EqualsAndHashCode
@Setter
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class APIRequestCountStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("currentHour")
    private PerResourceAPIRequestLog currentHour;
    @JsonProperty("last24h")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<PerResourceAPIRequestLog> last24h = new ArrayList<PerResourceAPIRequestLog>();
    @JsonProperty("removedInRelease")
    private String removedInRelease;
    @JsonProperty("requestCount")
    private Long requestCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
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

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

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

    @JsonProperty("last24h")
    public List<PerResourceAPIRequestLog> getLast24h() {
        return last24h;
    }

    @JsonProperty("last24h")
    public void setLast24h(List<PerResourceAPIRequestLog> last24h) {
        this.last24h = last24h;
    }

    @JsonProperty("removedInRelease")
    public String getRemovedInRelease() {
        return removedInRelease;
    }

    @JsonProperty("removedInRelease")
    public void setRemovedInRelease(String removedInRelease) {
        this.removedInRelease = removedInRelease;
    }

    @JsonProperty("requestCount")
    public Long getRequestCount() {
        return requestCount;
    }

    @JsonProperty("requestCount")
    public void setRequestCount(Long requestCount) {
        this.requestCount = requestCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
