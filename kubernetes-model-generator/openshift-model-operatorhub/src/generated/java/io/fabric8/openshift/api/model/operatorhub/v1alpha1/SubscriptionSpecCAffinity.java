
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.builder.Editable;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeAffinity",
    "podAffinity",
    "podAntiAffinity"
})
@ToString
@EqualsAndHashCode
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class SubscriptionSpecCAffinity implements Editable<SubscriptionSpecCAffinityBuilder> , KubernetesResource
{

    @JsonProperty("nodeAffinity")
    private SubscriptionSpecCANodeAffinity nodeAffinity;
    @JsonProperty("podAffinity")
    private SubscriptionSpecCAPodAffinity podAffinity;
    @JsonProperty("podAntiAffinity")
    private SubscriptionSpecCAPodAntiAffinity podAntiAffinity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpecCAffinity() {
    }

    public SubscriptionSpecCAffinity(SubscriptionSpecCANodeAffinity nodeAffinity, SubscriptionSpecCAPodAffinity podAffinity, SubscriptionSpecCAPodAntiAffinity podAntiAffinity) {
        super();
        this.nodeAffinity = nodeAffinity;
        this.podAffinity = podAffinity;
        this.podAntiAffinity = podAntiAffinity;
    }

    @JsonProperty("nodeAffinity")
    public SubscriptionSpecCANodeAffinity getNodeAffinity() {
        return nodeAffinity;
    }

    @JsonProperty("nodeAffinity")
    public void setNodeAffinity(SubscriptionSpecCANodeAffinity nodeAffinity) {
        this.nodeAffinity = nodeAffinity;
    }

    @JsonProperty("podAffinity")
    public SubscriptionSpecCAPodAffinity getPodAffinity() {
        return podAffinity;
    }

    @JsonProperty("podAffinity")
    public void setPodAffinity(SubscriptionSpecCAPodAffinity podAffinity) {
        this.podAffinity = podAffinity;
    }

    @JsonProperty("podAntiAffinity")
    public SubscriptionSpecCAPodAntiAffinity getPodAntiAffinity() {
        return podAntiAffinity;
    }

    @JsonProperty("podAntiAffinity")
    public void setPodAntiAffinity(SubscriptionSpecCAPodAntiAffinity podAntiAffinity) {
        this.podAntiAffinity = podAntiAffinity;
    }

    @JsonIgnore
    public SubscriptionSpecCAffinityBuilder edit() {
        return new SubscriptionSpecCAffinityBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecCAffinityBuilder toBuilder() {
        return edit();
    }

    @JsonAnyGetter
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

}
