
package io.fabric8.chaosmesh.v1alpha1;

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

/**
 * IOChaosSpec defines the desired state of IOChaos
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "action",
    "attr",
    "containerNames",
    "delay",
    "duration",
    "errno",
    "methods",
    "mistake",
    "mode",
    "path",
    "percent",
    "remoteCluster",
    "selector",
    "value",
    "volumePath"
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
public class IOChaosSpec implements Editable<IOChaosSpecBuilder>, KubernetesResource
{

    @JsonProperty("action")
    private String action;
    @JsonProperty("attr")
    private AttrOverrideSpec attr;
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> containerNames = new ArrayList<>();
    @JsonProperty("delay")
    private String delay;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("errno")
    private Long errno;
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> methods = new ArrayList<>();
    @JsonProperty("mistake")
    private MistakeSpec mistake;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("path")
    private String path;
    @JsonProperty("percent")
    private Integer percent;
    @JsonProperty("remoteCluster")
    private String remoteCluster;
    @JsonProperty("selector")
    private PodSelectorSpec selector;
    @JsonProperty("value")
    private String value;
    @JsonProperty("volumePath")
    private String volumePath;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public IOChaosSpec() {
    }

    public IOChaosSpec(String action, AttrOverrideSpec attr, List<String> containerNames, String delay, String duration, Long errno, List<String> methods, MistakeSpec mistake, String mode, String path, Integer percent, String remoteCluster, PodSelectorSpec selector, String value, String volumePath) {
        super();
        this.action = action;
        this.attr = attr;
        this.containerNames = containerNames;
        this.delay = delay;
        this.duration = duration;
        this.errno = errno;
        this.methods = methods;
        this.mistake = mistake;
        this.mode = mode;
        this.path = path;
        this.percent = percent;
        this.remoteCluster = remoteCluster;
        this.selector = selector;
        this.value = value;
        this.volumePath = volumePath;
    }

    /**
     * Action defines the specific pod chaos action. Supported action: latency / fault / attrOverride / mistake
     */
    @JsonProperty("action")
    public String getAction() {
        return action;
    }

    /**
     * Action defines the specific pod chaos action. Supported action: latency / fault / attrOverride / mistake
     */
    @JsonProperty("action")
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * IOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("attr")
    public AttrOverrideSpec getAttr() {
        return attr;
    }

    /**
     * IOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("attr")
    public void setAttr(AttrOverrideSpec attr) {
        this.attr = attr;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getContainerNames() {
        return containerNames;
    }

    /**
     * ContainerNames indicates list of the name of affected container. If not set, the first container will be injected
     */
    @JsonProperty("containerNames")
    public void setContainerNames(List<String> containerNames) {
        this.containerNames = containerNames;
    }

    /**
     * Delay defines the value of I/O chaos action delay. A delay string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("delay")
    public String getDelay() {
        return delay;
    }

    /**
     * Delay defines the value of I/O chaos action delay. A delay string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("delay")
    public void setDelay(String delay) {
        this.delay = delay;
    }

    /**
     * Duration represents the duration of the chaos action. It is required when the action is `PodFailureAction`. A duration string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "-1.5h" or "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    /**
     * Duration represents the duration of the chaos action. It is required when the action is `PodFailureAction`. A duration string is a possibly signed sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "-1.5h" or "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * Errno defines the error code that returned by I/O action. refer to: https://www-numi.fnal.gov/offline_software/srt_public_context/WebDocs/Errors/unix_system_errors.html
     */
    @JsonProperty("errno")
    public Long getErrno() {
        return errno;
    }

    /**
     * Errno defines the error code that returned by I/O action. refer to: https://www-numi.fnal.gov/offline_software/srt_public_context/WebDocs/Errors/unix_system_errors.html
     */
    @JsonProperty("errno")
    public void setErrno(Long errno) {
        this.errno = errno;
    }

    /**
     * Methods defines the I/O methods for injecting I/O chaos action. default: all I/O methods.
     */
    @JsonProperty("methods")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMethods() {
        return methods;
    }

    /**
     * Methods defines the I/O methods for injecting I/O chaos action. default: all I/O methods.
     */
    @JsonProperty("methods")
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    /**
     * IOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("mistake")
    public MistakeSpec getMistake() {
        return mistake;
    }

    /**
     * IOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("mistake")
    public void setMistake(MistakeSpec mistake) {
        this.mistake = mistake;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    /**
     * Mode defines the mode to run chaos action. Supported mode: one / all / fixed / fixed-percent / random-max-percent
     */
    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Path defines the path of files for injecting I/O chaos action.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * Path defines the path of files for injecting I/O chaos action.
     */
    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Percent defines the percentage of injection errors and provides a number from 0-100. default: 100.
     */
    @JsonProperty("percent")
    public Integer getPercent() {
        return percent;
    }

    /**
     * Percent defines the percentage of injection errors and provides a number from 0-100. default: 100.
     */
    @JsonProperty("percent")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public String getRemoteCluster() {
        return remoteCluster;
    }

    /**
     * RemoteCluster represents the remote cluster where the chaos will be deployed
     */
    @JsonProperty("remoteCluster")
    public void setRemoteCluster(String remoteCluster) {
        this.remoteCluster = remoteCluster;
    }

    /**
     * IOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("selector")
    public PodSelectorSpec getSelector() {
        return selector;
    }

    /**
     * IOChaosSpec defines the desired state of IOChaos
     */
    @JsonProperty("selector")
    public void setSelector(PodSelectorSpec selector) {
        this.selector = selector;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    /**
     * Value is required when the mode is set to `FixedMode` / `FixedPercentMode` / `RandomMaxPercentMode`. If `FixedMode`, provide an integer of pods to do chaos action. If `FixedPercentMode`, provide a number from 0-100 to specify the percent of pods the server can do chaos action. IF `RandomMaxPercentMode`,  provide a number from 0-100 to specify the max percent of pods to do chaos action
     */
    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * VolumePath represents the mount path of injected volume
     */
    @JsonProperty("volumePath")
    public String getVolumePath() {
        return volumePath;
    }

    /**
     * VolumePath represents the mount path of injected volume
     */
    @JsonProperty("volumePath")
    public void setVolumePath(String volumePath) {
        this.volumePath = volumePath;
    }

    @JsonIgnore
    public IOChaosSpecBuilder edit() {
        return new IOChaosSpecBuilder(this);
    }

    @JsonIgnore
    public IOChaosSpecBuilder toBuilder() {
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
        if (!(o instanceof IOChaosSpec)) {
            return false;
        }
        IOChaosSpec other = (IOChaosSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$action = this.getAction();
        Object other$action = other.getAction();
        if (this$action == null ? other$action != null : !this$action.equals(other$action)) {
            return false;
        }
        Object this$attr = this.getAttr();
        Object other$attr = other.getAttr();
        if (this$attr == null ? other$attr != null : !this$attr.equals(other$attr)) {
            return false;
        }
        Object this$containerNames = this.getContainerNames();
        Object other$containerNames = other.getContainerNames();
        if (this$containerNames == null ? other$containerNames != null : !this$containerNames.equals(other$containerNames)) {
            return false;
        }
        Object this$delay = this.getDelay();
        Object other$delay = other.getDelay();
        if (this$delay == null ? other$delay != null : !this$delay.equals(other$delay)) {
            return false;
        }
        Object this$duration = this.getDuration();
        Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) {
            return false;
        }
        Object this$errno = this.getErrno();
        Object other$errno = other.getErrno();
        if (this$errno == null ? other$errno != null : !this$errno.equals(other$errno)) {
            return false;
        }
        Object this$methods = this.getMethods();
        Object other$methods = other.getMethods();
        if (this$methods == null ? other$methods != null : !this$methods.equals(other$methods)) {
            return false;
        }
        Object this$mistake = this.getMistake();
        Object other$mistake = other.getMistake();
        if (this$mistake == null ? other$mistake != null : !this$mistake.equals(other$mistake)) {
            return false;
        }
        Object this$mode = this.getMode();
        Object other$mode = other.getMode();
        if (this$mode == null ? other$mode != null : !this$mode.equals(other$mode)) {
            return false;
        }
        Object this$path = this.getPath();
        Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) {
            return false;
        }
        Object this$percent = this.getPercent();
        Object other$percent = other.getPercent();
        if (this$percent == null ? other$percent != null : !this$percent.equals(other$percent)) {
            return false;
        }
        Object this$remoteCluster = this.getRemoteCluster();
        Object other$remoteCluster = other.getRemoteCluster();
        if (this$remoteCluster == null ? other$remoteCluster != null : !this$remoteCluster.equals(other$remoteCluster)) {
            return false;
        }
        Object this$selector = this.getSelector();
        Object other$selector = other.getSelector();
        if (this$selector == null ? other$selector != null : !this$selector.equals(other$selector)) {
            return false;
        }
        Object this$value = this.getValue();
        Object other$value = other.getValue();
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) {
            return false;
        }
        Object this$volumePath = this.getVolumePath();
        Object other$volumePath = other.getVolumePath();
        if (this$volumePath == null ? other$volumePath != null : !this$volumePath.equals(other$volumePath)) {
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
        return other instanceof IOChaosSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $action = this.getAction();
        result = result * prime + ($action == null ? 43 : $action.hashCode());
        Object $attr = this.getAttr();
        result = result * prime + ($attr == null ? 43 : $attr.hashCode());
        Object $containerNames = this.getContainerNames();
        result = result * prime + ($containerNames == null ? 43 : $containerNames.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $duration = this.getDuration();
        result = result * prime + ($duration == null ? 43 : $duration.hashCode());
        Object $errno = this.getErrno();
        result = result * prime + ($errno == null ? 43 : $errno.hashCode());
        Object $methods = this.getMethods();
        result = result * prime + ($methods == null ? 43 : $methods.hashCode());
        Object $mistake = this.getMistake();
        result = result * prime + ($mistake == null ? 43 : $mistake.hashCode());
        Object $mode = this.getMode();
        result = result * prime + ($mode == null ? 43 : $mode.hashCode());
        Object $path = this.getPath();
        result = result * prime + ($path == null ? 43 : $path.hashCode());
        Object $percent = this.getPercent();
        result = result * prime + ($percent == null ? 43 : $percent.hashCode());
        Object $remoteCluster = this.getRemoteCluster();
        result = result * prime + ($remoteCluster == null ? 43 : $remoteCluster.hashCode());
        Object $selector = this.getSelector();
        result = result * prime + ($selector == null ? 43 : $selector.hashCode());
        Object $value = this.getValue();
        result = result * prime + ($value == null ? 43 : $value.hashCode());
        Object $volumePath = this.getVolumePath();
        result = result * prime + ($volumePath == null ? 43 : $volumePath.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "IOChaosSpec(" + "action=" + this.getAction() + ", attr=" + this.getAttr() + ", containerNames=" + this.getContainerNames() + ", delay=" + this.getDelay() + ", duration=" + this.getDuration() + ", errno=" + this.getErrno() + ", methods=" + this.getMethods() + ", mistake=" + this.getMistake() + ", mode=" + this.getMode() + ", path=" + this.getPath() + ", percent=" + this.getPercent() + ", remoteCluster=" + this.getRemoteCluster() + ", selector=" + this.getSelector() + ", value=" + this.getValue() + ", volumePath=" + this.getVolumePath() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
