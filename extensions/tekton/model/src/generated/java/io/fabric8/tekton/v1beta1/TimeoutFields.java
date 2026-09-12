
package io.fabric8.tekton.v1beta1;

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
import io.fabric8.kubernetes.api.model.Duration;
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
 * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "finally",
    "pipeline",
    "tasks"
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
public class TimeoutFields implements Editable<TimeoutFieldsBuilder>, KubernetesResource
{

    @JsonProperty("finally")
    private Duration _finally;
    @JsonProperty("pipeline")
    private Duration pipeline;
    @JsonProperty("tasks")
    private Duration tasks;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public TimeoutFields() {
    }

    public TimeoutFields(Duration _finally, Duration pipeline, Duration tasks) {
        super();
        this._finally = _finally;
        this.pipeline = pipeline;
        this.tasks = tasks;
    }

    /**
     * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
     */
    @JsonProperty("finally")
    public Duration getFinally() {
        return _finally;
    }

    /**
     * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
     */
    @JsonProperty("finally")
    public void setFinally(Duration _finally) {
        this._finally = _finally;
    }

    /**
     * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
     */
    @JsonProperty("pipeline")
    public Duration getPipeline() {
        return pipeline;
    }

    /**
     * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
     */
    @JsonProperty("pipeline")
    public void setPipeline(Duration pipeline) {
        this.pipeline = pipeline;
    }

    /**
     * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
     */
    @JsonProperty("tasks")
    public Duration getTasks() {
        return tasks;
    }

    /**
     * TimeoutFields allows granular specification of pipeline, task, and finally timeouts
     */
    @JsonProperty("tasks")
    public void setTasks(Duration tasks) {
        this.tasks = tasks;
    }

    @JsonIgnore
    public TimeoutFieldsBuilder edit() {
        return new TimeoutFieldsBuilder(this);
    }

    @JsonIgnore
    public TimeoutFieldsBuilder toBuilder() {
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
        if (!(o instanceof TimeoutFields)) {
            return false;
        }
        TimeoutFields other = (TimeoutFields) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$_finally = this.getFinally();
        Object other$_finally = other.getFinally();
        if (this$_finally == null ? other$_finally != null : !this$_finally.equals(other$_finally)) {
            return false;
        }
        Object this$pipeline = this.getPipeline();
        Object other$pipeline = other.getPipeline();
        if (this$pipeline == null ? other$pipeline != null : !this$pipeline.equals(other$pipeline)) {
            return false;
        }
        Object this$tasks = this.getTasks();
        Object other$tasks = other.getTasks();
        if (this$tasks == null ? other$tasks != null : !this$tasks.equals(other$tasks)) {
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
        return other instanceof TimeoutFields;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $_finally = this.getFinally();
        result = result * prime + ($_finally == null ? 43 : $_finally.hashCode());
        Object $pipeline = this.getPipeline();
        result = result * prime + ($pipeline == null ? 43 : $pipeline.hashCode());
        Object $tasks = this.getTasks();
        result = result * prime + ($tasks == null ? 43 : $tasks.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TimeoutFields(" + "_finally=" + this.getFinally() + ", pipeline=" + this.getPipeline() + ", tasks=" + this.getTasks() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
