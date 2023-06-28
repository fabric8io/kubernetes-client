
package io.fabric8.kubernetes.api.model.batch.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
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
    "active",
    "lastScheduleTime",
    "lastSuccessfulTime"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CronJobStatus implements KubernetesResource
{

    @JsonProperty("active")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.ObjectReference> active = new ArrayList<io.fabric8.kubernetes.api.model.ObjectReference>();
    @JsonProperty("lastScheduleTime")
    private String lastScheduleTime;
    @JsonProperty("lastSuccessfulTime")
    private String lastSuccessfulTime;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CronJobStatus() {
    }

    public CronJobStatus(List<io.fabric8.kubernetes.api.model.ObjectReference> active, String lastScheduleTime, String lastSuccessfulTime) {
        super();
        this.active = active;
        this.lastScheduleTime = lastScheduleTime;
        this.lastSuccessfulTime = lastSuccessfulTime;
    }

    @JsonProperty("active")
    public List<io.fabric8.kubernetes.api.model.ObjectReference> getActive() {
        return active;
    }

    @JsonProperty("active")
    public void setActive(List<io.fabric8.kubernetes.api.model.ObjectReference> active) {
        this.active = active;
    }

    @JsonProperty("lastScheduleTime")
    public String getLastScheduleTime() {
        return lastScheduleTime;
    }

    @JsonProperty("lastScheduleTime")
    public void setLastScheduleTime(String lastScheduleTime) {
        this.lastScheduleTime = lastScheduleTime;
    }

    @JsonProperty("lastSuccessfulTime")
    public String getLastSuccessfulTime() {
        return lastSuccessfulTime;
    }

    @JsonProperty("lastSuccessfulTime")
    public void setLastSuccessfulTime(String lastSuccessfulTime) {
        this.lastSuccessfulTime = lastSuccessfulTime;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
