
package io.fabric8.chaosmesh.v1alpha1;

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

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clock-ids-slice",
    "pid",
    "time-offset"
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
public class ClockSpec implements Editable<ClockSpecBuilder>, KubernetesResource
{

    @JsonProperty("clock-ids-slice")
    private String clockIdsSlice;
    @JsonProperty("pid")
    private Integer pid;
    @JsonProperty("time-offset")
    private String timeOffset;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ClockSpec() {
    }

    public ClockSpec(String clockIdsSlice, Integer pid, String timeOffset) {
        super();
        this.clockIdsSlice = clockIdsSlice;
        this.pid = pid;
        this.timeOffset = timeOffset;
    }

    /**
     * the identifier of the particular clock on which to act. More clock description in linux kernel can be found in man page of clock_getres, clock_gettime, clock_settime. Muti clock ids should be split with ","
     */
    @JsonProperty("clock-ids-slice")
    public String getClockIdsSlice() {
        return clockIdsSlice;
    }

    /**
     * the identifier of the particular clock on which to act. More clock description in linux kernel can be found in man page of clock_getres, clock_gettime, clock_settime. Muti clock ids should be split with ","
     */
    @JsonProperty("clock-ids-slice")
    public void setClockIdsSlice(String clockIdsSlice) {
        this.clockIdsSlice = clockIdsSlice;
    }

    /**
     * the pid of target program.
     */
    @JsonProperty("pid")
    public Integer getPid() {
        return pid;
    }

    /**
     * the pid of target program.
     */
    @JsonProperty("pid")
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * specifies the length of time offset.
     */
    @JsonProperty("time-offset")
    public String getTimeOffset() {
        return timeOffset;
    }

    /**
     * specifies the length of time offset.
     */
    @JsonProperty("time-offset")
    public void setTimeOffset(String timeOffset) {
        this.timeOffset = timeOffset;
    }

    @JsonIgnore
    public ClockSpecBuilder edit() {
        return new ClockSpecBuilder(this);
    }

    @JsonIgnore
    public ClockSpecBuilder toBuilder() {
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
        if (!(o instanceof ClockSpec)) {
            return false;
        }
        ClockSpec other = (ClockSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$clockIdsSlice = this.getClockIdsSlice();
        Object other$clockIdsSlice = other.getClockIdsSlice();
        if (this$clockIdsSlice == null ? other$clockIdsSlice != null : !this$clockIdsSlice.equals(other$clockIdsSlice)) {
            return false;
        }
        Object this$pid = this.getPid();
        Object other$pid = other.getPid();
        if (this$pid == null ? other$pid != null : !this$pid.equals(other$pid)) {
            return false;
        }
        Object this$timeOffset = this.getTimeOffset();
        Object other$timeOffset = other.getTimeOffset();
        if (this$timeOffset == null ? other$timeOffset != null : !this$timeOffset.equals(other$timeOffset)) {
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
        return other instanceof ClockSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $clockIdsSlice = this.getClockIdsSlice();
        result = result * prime + ($clockIdsSlice == null ? 43 : $clockIdsSlice.hashCode());
        Object $pid = this.getPid();
        result = result * prime + ($pid == null ? 43 : $pid.hashCode());
        Object $timeOffset = this.getTimeOffset();
        result = result * prime + ($timeOffset == null ? 43 : $timeOffset.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ClockSpec(" + "clockIdsSlice=" + this.getClockIdsSlice() + ", pid=" + this.getPid() + ", timeOffset=" + this.getTimeOffset() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
