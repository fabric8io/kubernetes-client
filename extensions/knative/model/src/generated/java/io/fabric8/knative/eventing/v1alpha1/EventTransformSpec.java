
package io.fabric8.knative.eventing.v1alpha1;

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
import io.fabric8.knative.duck.v1.Destination;
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
    "jsonata",
    "reply",
    "sink"
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
public class EventTransformSpec implements Editable<EventTransformSpecBuilder>, KubernetesResource
{

    @JsonProperty("jsonata")
    private JsonataEventTransformationSpec jsonata;
    @JsonProperty("reply")
    private ReplySpec reply;
    @JsonProperty("sink")
    private Destination sink;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventTransformSpec() {
    }

    public EventTransformSpec(JsonataEventTransformationSpec jsonata, ReplySpec reply, Destination sink) {
        super();
        this.jsonata = jsonata;
        this.reply = reply;
        this.sink = sink;
    }

    @JsonProperty("jsonata")
    public JsonataEventTransformationSpec getJsonata() {
        return jsonata;
    }

    @JsonProperty("jsonata")
    public void setJsonata(JsonataEventTransformationSpec jsonata) {
        this.jsonata = jsonata;
    }

    @JsonProperty("reply")
    public ReplySpec getReply() {
        return reply;
    }

    @JsonProperty("reply")
    public void setReply(ReplySpec reply) {
        this.reply = reply;
    }

    @JsonProperty("sink")
    public Destination getSink() {
        return sink;
    }

    @JsonProperty("sink")
    public void setSink(Destination sink) {
        this.sink = sink;
    }

    @JsonIgnore
    public EventTransformSpecBuilder edit() {
        return new EventTransformSpecBuilder(this);
    }

    @JsonIgnore
    public EventTransformSpecBuilder toBuilder() {
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
        if (!(o instanceof EventTransformSpec)) {
            return false;
        }
        EventTransformSpec other = (EventTransformSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$jsonata = this.getJsonata();
        Object other$jsonata = other.getJsonata();
        if (this$jsonata == null ? other$jsonata != null : !this$jsonata.equals(other$jsonata)) {
            return false;
        }
        Object this$reply = this.getReply();
        Object other$reply = other.getReply();
        if (this$reply == null ? other$reply != null : !this$reply.equals(other$reply)) {
            return false;
        }
        Object this$sink = this.getSink();
        Object other$sink = other.getSink();
        if (this$sink == null ? other$sink != null : !this$sink.equals(other$sink)) {
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
        return other instanceof EventTransformSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $jsonata = this.getJsonata();
        result = result * prime + ($jsonata == null ? 43 : $jsonata.hashCode());
        Object $reply = this.getReply();
        result = result * prime + ($reply == null ? 43 : $reply.hashCode());
        Object $sink = this.getSink();
        result = result * prime + ($sink == null ? 43 : $sink.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventTransformSpec(" + "jsonata=" + this.getJsonata() + ", reply=" + this.getReply() + ", sink=" + this.getSink() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
