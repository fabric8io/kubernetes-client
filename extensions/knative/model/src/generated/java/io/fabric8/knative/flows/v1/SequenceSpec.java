
package io.fabric8.knative.flows.v1;

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
import io.fabric8.knative.duck.v1.Destination;
import io.fabric8.knative.messaging.v1.ChannelTemplateSpec;
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
    "channelTemplate",
    "reply",
    "steps"
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
public class SequenceSpec implements Editable<SequenceSpecBuilder>, KubernetesResource
{

    @JsonProperty("channelTemplate")
    private ChannelTemplateSpec channelTemplate;
    @JsonProperty("reply")
    private Destination reply;
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SequenceStep> steps = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public SequenceSpec() {
    }

    public SequenceSpec(ChannelTemplateSpec channelTemplate, Destination reply, List<SequenceStep> steps) {
        super();
        this.channelTemplate = channelTemplate;
        this.reply = reply;
        this.steps = steps;
    }

    @JsonProperty("channelTemplate")
    public ChannelTemplateSpec getChannelTemplate() {
        return channelTemplate;
    }

    @JsonProperty("channelTemplate")
    public void setChannelTemplate(ChannelTemplateSpec channelTemplate) {
        this.channelTemplate = channelTemplate;
    }

    @JsonProperty("reply")
    public Destination getReply() {
        return reply;
    }

    @JsonProperty("reply")
    public void setReply(Destination reply) {
        this.reply = reply;
    }

    /**
     * Steps is the list of Destinations (processors / functions) that will be called in the order provided. Each step has its own delivery options
     */
    @JsonProperty("steps")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<SequenceStep> getSteps() {
        return steps;
    }

    /**
     * Steps is the list of Destinations (processors / functions) that will be called in the order provided. Each step has its own delivery options
     */
    @JsonProperty("steps")
    public void setSteps(List<SequenceStep> steps) {
        this.steps = steps;
    }

    @JsonIgnore
    public SequenceSpecBuilder edit() {
        return new SequenceSpecBuilder(this);
    }

    @JsonIgnore
    public SequenceSpecBuilder toBuilder() {
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
        if (!(o instanceof SequenceSpec)) {
            return false;
        }
        SequenceSpec other = (SequenceSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$channelTemplate = this.getChannelTemplate();
        Object other$channelTemplate = other.getChannelTemplate();
        if (this$channelTemplate == null ? other$channelTemplate != null : !this$channelTemplate.equals(other$channelTemplate)) {
            return false;
        }
        Object this$reply = this.getReply();
        Object other$reply = other.getReply();
        if (this$reply == null ? other$reply != null : !this$reply.equals(other$reply)) {
            return false;
        }
        Object this$steps = this.getSteps();
        Object other$steps = other.getSteps();
        if (this$steps == null ? other$steps != null : !this$steps.equals(other$steps)) {
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
        return other instanceof SequenceSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $channelTemplate = this.getChannelTemplate();
        result = result * prime + ($channelTemplate == null ? 43 : $channelTemplate.hashCode());
        Object $reply = this.getReply();
        result = result * prime + ($reply == null ? 43 : $reply.hashCode());
        Object $steps = this.getSteps();
        result = result * prime + ($steps == null ? 43 : $steps.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "SequenceSpec(" + "channelTemplate=" + this.getChannelTemplate() + ", reply=" + this.getReply() + ", steps=" + this.getSteps() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
