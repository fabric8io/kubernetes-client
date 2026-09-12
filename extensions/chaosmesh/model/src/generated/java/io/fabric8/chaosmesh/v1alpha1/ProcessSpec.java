
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
    "process",
    "recoverCmd",
    "signal"
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
public class ProcessSpec implements Editable<ProcessSpecBuilder>, KubernetesResource
{

    @JsonProperty("process")
    private String process;
    @JsonProperty("recoverCmd")
    private String recoverCmd;
    @JsonProperty("signal")
    private Integer signal;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProcessSpec() {
    }

    public ProcessSpec(String process, String recoverCmd, Integer signal) {
        super();
        this.process = process;
        this.recoverCmd = recoverCmd;
        this.signal = signal;
    }

    /**
     * the process name or the process ID
     */
    @JsonProperty("process")
    public String getProcess() {
        return process;
    }

    /**
     * the process name or the process ID
     */
    @JsonProperty("process")
    public void setProcess(String process) {
        this.process = process;
    }

    /**
     * the command to be run when recovering experiment
     */
    @JsonProperty("recoverCmd")
    public String getRecoverCmd() {
        return recoverCmd;
    }

    /**
     * the command to be run when recovering experiment
     */
    @JsonProperty("recoverCmd")
    public void setRecoverCmd(String recoverCmd) {
        this.recoverCmd = recoverCmd;
    }

    /**
     * the signal number to send
     */
    @JsonProperty("signal")
    public Integer getSignal() {
        return signal;
    }

    /**
     * the signal number to send
     */
    @JsonProperty("signal")
    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    @JsonIgnore
    public ProcessSpecBuilder edit() {
        return new ProcessSpecBuilder(this);
    }

    @JsonIgnore
    public ProcessSpecBuilder toBuilder() {
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
        if (!(o instanceof ProcessSpec)) {
            return false;
        }
        ProcessSpec other = (ProcessSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$process = this.getProcess();
        Object other$process = other.getProcess();
        if (this$process == null ? other$process != null : !this$process.equals(other$process)) {
            return false;
        }
        Object this$recoverCmd = this.getRecoverCmd();
        Object other$recoverCmd = other.getRecoverCmd();
        if (this$recoverCmd == null ? other$recoverCmd != null : !this$recoverCmd.equals(other$recoverCmd)) {
            return false;
        }
        Object this$signal = this.getSignal();
        Object other$signal = other.getSignal();
        if (this$signal == null ? other$signal != null : !this$signal.equals(other$signal)) {
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
        return other instanceof ProcessSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $process = this.getProcess();
        result = result * prime + ($process == null ? 43 : $process.hashCode());
        Object $recoverCmd = this.getRecoverCmd();
        result = result * prime + ($recoverCmd == null ? 43 : $recoverCmd.hashCode());
        Object $signal = this.getSignal();
        result = result * prime + ($signal == null ? 43 : $signal.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "ProcessSpec(" + "process=" + this.getProcess() + ", recoverCmd=" + this.getRecoverCmd() + ", signal=" + this.getSignal() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
