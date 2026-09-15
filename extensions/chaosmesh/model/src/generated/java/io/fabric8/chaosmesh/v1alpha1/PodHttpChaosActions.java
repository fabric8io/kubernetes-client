
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

/**
 * PodHttpChaosActions defines possible actions of HttpChaos.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "abort",
    "delay",
    "patch",
    "replace"
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
public class PodHttpChaosActions implements Editable<PodHttpChaosActionsBuilder>, KubernetesResource
{

    @JsonProperty("abort")
    private Boolean abort;
    @JsonProperty("delay")
    private String delay;
    @JsonProperty("patch")
    private PodHttpChaosPatchActions patch;
    @JsonProperty("replace")
    private PodHttpChaosReplaceActions replace;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PodHttpChaosActions() {
    }

    public PodHttpChaosActions(Boolean abort, String delay, PodHttpChaosPatchActions patch, PodHttpChaosReplaceActions replace) {
        super();
        this.abort = abort;
        this.delay = delay;
        this.patch = patch;
        this.replace = replace;
    }

    /**
     * Abort is a rule to abort a http session.
     */
    @JsonProperty("abort")
    public Boolean getAbort() {
        return abort;
    }

    /**
     * Abort is a rule to abort a http session.
     */
    @JsonProperty("abort")
    public void setAbort(Boolean abort) {
        this.abort = abort;
    }

    /**
     * Delay represents the delay of the target request/response. A duration string is a possibly unsigned sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("delay")
    public String getDelay() {
        return delay;
    }

    /**
     * Delay represents the delay of the target request/response. A duration string is a possibly unsigned sequence of decimal numbers, each with optional fraction and a unit suffix, such as "300ms", "2h45m". Valid time units are "ns", "us" (or "µs"), "ms", "s", "m", "h".
     */
    @JsonProperty("delay")
    public void setDelay(String delay) {
        this.delay = delay;
    }

    /**
     * PodHttpChaosActions defines possible actions of HttpChaos.
     */
    @JsonProperty("patch")
    public PodHttpChaosPatchActions getPatch() {
        return patch;
    }

    /**
     * PodHttpChaosActions defines possible actions of HttpChaos.
     */
    @JsonProperty("patch")
    public void setPatch(PodHttpChaosPatchActions patch) {
        this.patch = patch;
    }

    /**
     * PodHttpChaosActions defines possible actions of HttpChaos.
     */
    @JsonProperty("replace")
    public PodHttpChaosReplaceActions getReplace() {
        return replace;
    }

    /**
     * PodHttpChaosActions defines possible actions of HttpChaos.
     */
    @JsonProperty("replace")
    public void setReplace(PodHttpChaosReplaceActions replace) {
        this.replace = replace;
    }

    @JsonIgnore
    public PodHttpChaosActionsBuilder edit() {
        return new PodHttpChaosActionsBuilder(this);
    }

    @JsonIgnore
    public PodHttpChaosActionsBuilder toBuilder() {
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
        if (!(o instanceof PodHttpChaosActions)) {
            return false;
        }
        PodHttpChaosActions other = (PodHttpChaosActions) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$abort = this.getAbort();
        Object other$abort = other.getAbort();
        if (this$abort == null ? other$abort != null : !this$abort.equals(other$abort)) {
            return false;
        }
        Object this$delay = this.getDelay();
        Object other$delay = other.getDelay();
        if (this$delay == null ? other$delay != null : !this$delay.equals(other$delay)) {
            return false;
        }
        Object this$patch = this.getPatch();
        Object other$patch = other.getPatch();
        if (this$patch == null ? other$patch != null : !this$patch.equals(other$patch)) {
            return false;
        }
        Object this$replace = this.getReplace();
        Object other$replace = other.getReplace();
        if (this$replace == null ? other$replace != null : !this$replace.equals(other$replace)) {
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
        return other instanceof PodHttpChaosActions;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $abort = this.getAbort();
        result = result * prime + ($abort == null ? 43 : $abort.hashCode());
        Object $delay = this.getDelay();
        result = result * prime + ($delay == null ? 43 : $delay.hashCode());
        Object $patch = this.getPatch();
        result = result * prime + ($patch == null ? 43 : $patch.hashCode());
        Object $replace = this.getReplace();
        result = result * prime + ($replace == null ? 43 : $replace.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PodHttpChaosActions(" + "abort=" + this.getAbort() + ", delay=" + this.getDelay() + ", patch=" + this.getPatch() + ", replace=" + this.getReplace() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
