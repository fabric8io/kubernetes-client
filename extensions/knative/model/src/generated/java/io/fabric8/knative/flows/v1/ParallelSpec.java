
package io.fabric8.knative.flows.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.knative.internal.pkg.apis.duck.v1.Destination;
import io.fabric8.knative.messaging.v1.ChannelTemplateSpec;
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
    "branches",
    "channelTemplate",
    "reply"
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
public class ParallelSpec implements KubernetesResource
{

    @JsonProperty("branches")
    private List<ParallelBranch> branches = new ArrayList<ParallelBranch>();
    @JsonProperty("channelTemplate")
    private ChannelTemplateSpec channelTemplate;
    @JsonProperty("reply")
    private Destination reply;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ParallelSpec() {
    }

    /**
     * 
     * @param branches
     * @param reply
     * @param channelTemplate
     */
    public ParallelSpec(List<ParallelBranch> branches, ChannelTemplateSpec channelTemplate, Destination reply) {
        super();
        this.branches = branches;
        this.channelTemplate = channelTemplate;
        this.reply = reply;
    }

    @JsonProperty("branches")
    public List<ParallelBranch> getBranches() {
        return branches;
    }

    @JsonProperty("branches")
    public void setBranches(List<ParallelBranch> branches) {
        this.branches = branches;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
