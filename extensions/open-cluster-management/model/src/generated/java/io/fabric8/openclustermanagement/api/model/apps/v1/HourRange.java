
package io.fabric8.openclustermanagement.api.model.apps.v1;

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
 * HourRange defines the time format, refer to https://golang.org/pkg/time/#pkg-constants
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "end",
    "start"
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
public class HourRange implements Editable<HourRangeBuilder>, KubernetesResource
{

    @JsonProperty("end")
    private String end;
    @JsonProperty("start")
    private String start;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public HourRange() {
    }

    public HourRange(String end, String start) {
        super();
        this.end = end;
        this.start = start;
    }

    /**
     * End time of the hour range
     */
    @JsonProperty("end")
    public String getEnd() {
        return end;
    }

    /**
     * End time of the hour range
     */
    @JsonProperty("end")
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * Start time of the hour range
     */
    @JsonProperty("start")
    public String getStart() {
        return start;
    }

    /**
     * Start time of the hour range
     */
    @JsonProperty("start")
    public void setStart(String start) {
        this.start = start;
    }

    @JsonIgnore
    public HourRangeBuilder edit() {
        return new HourRangeBuilder(this);
    }

    @JsonIgnore
    public HourRangeBuilder toBuilder() {
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
        if (!(o instanceof HourRange)) {
            return false;
        }
        HourRange other = (HourRange) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$end = this.getEnd();
        Object other$end = other.getEnd();
        if (this$end == null ? other$end != null : !this$end.equals(other$end)) {
            return false;
        }
        Object this$start = this.getStart();
        Object other$start = other.getStart();
        if (this$start == null ? other$start != null : !this$start.equals(other$start)) {
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
        return other instanceof HourRange;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $end = this.getEnd();
        result = result * prime + ($end == null ? 43 : $end.hashCode());
        Object $start = this.getStart();
        result = result * prime + ($start == null ? 43 : $start.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "HourRange(" + "end=" + this.getEnd() + ", start=" + this.getStart() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
