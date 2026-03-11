
package io.fabric8.kubernetes.api.model.gatewayapi.v1;

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
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ListenerSetSpec defines the desired state of a ListenerSet.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "listeners",
    "parentRef"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ListenerSetSpec implements Editable<ListenerSetSpecBuilder>, KubernetesResource
{

    @JsonProperty("listeners")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ListenerEntry> listeners = new ArrayList<>();
    @JsonProperty("parentRef")
    private ParentGatewayReference parentRef;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ListenerSetSpec() {
    }

    public ListenerSetSpec(List<ListenerEntry> listeners, ParentGatewayReference parentRef) {
        super();
        this.listeners = listeners;
        this.parentRef = parentRef;
    }

    /**
     * Listeners associated with this ListenerSet. Listeners define logical endpoints that are bound on this referenced parent Gateway's addresses.<br><p> <br><p> Listeners in a `Gateway` and their attached `ListenerSets` are concatenated as a list when programming the underlying infrastructure. Each listener name does not need to be unique across the Gateway and ListenerSets. See ListenerEntry.Name for more details.<br><p> <br><p> Implementations MUST treat the parent Gateway as having the merged list of all listeners from itself and attached ListenerSets using the following precedence:<br><p> <br><p> 1. "parent" Gateway 2. ListenerSet ordered by creation time (oldest first) 3. ListenerSet ordered alphabetically by "{namespace}/{name}".<br><p> <br><p> An implementation MAY reject listeners by setting the ListenerEntryStatus `Accepted` condition to False with the Reason `TooManyListeners`<br><p> <br><p> If a listener has a conflict, this will be reported in the Status.ListenerEntryStatus setting the `Conflicted` condition to True.<br><p> <br><p> Implementations SHOULD be cautious about what information from the parent or siblings are reported to avoid accidentally leaking sensitive information that the child would not otherwise have access to. This can include contents of secrets etc.
     */
    @JsonProperty("listeners")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ListenerEntry> getListeners() {
        return listeners;
    }

    /**
     * Listeners associated with this ListenerSet. Listeners define logical endpoints that are bound on this referenced parent Gateway's addresses.<br><p> <br><p> Listeners in a `Gateway` and their attached `ListenerSets` are concatenated as a list when programming the underlying infrastructure. Each listener name does not need to be unique across the Gateway and ListenerSets. See ListenerEntry.Name for more details.<br><p> <br><p> Implementations MUST treat the parent Gateway as having the merged list of all listeners from itself and attached ListenerSets using the following precedence:<br><p> <br><p> 1. "parent" Gateway 2. ListenerSet ordered by creation time (oldest first) 3. ListenerSet ordered alphabetically by "{namespace}/{name}".<br><p> <br><p> An implementation MAY reject listeners by setting the ListenerEntryStatus `Accepted` condition to False with the Reason `TooManyListeners`<br><p> <br><p> If a listener has a conflict, this will be reported in the Status.ListenerEntryStatus setting the `Conflicted` condition to True.<br><p> <br><p> Implementations SHOULD be cautious about what information from the parent or siblings are reported to avoid accidentally leaking sensitive information that the child would not otherwise have access to. This can include contents of secrets etc.
     */
    @JsonProperty("listeners")
    public void setListeners(List<ListenerEntry> listeners) {
        this.listeners = listeners;
    }

    /**
     * ListenerSetSpec defines the desired state of a ListenerSet.
     */
    @JsonProperty("parentRef")
    public ParentGatewayReference getParentRef() {
        return parentRef;
    }

    /**
     * ListenerSetSpec defines the desired state of a ListenerSet.
     */
    @JsonProperty("parentRef")
    public void setParentRef(ParentGatewayReference parentRef) {
        this.parentRef = parentRef;
    }

    @JsonIgnore
    public ListenerSetSpecBuilder edit() {
        return new ListenerSetSpecBuilder(this);
    }

    @JsonIgnore
    public ListenerSetSpecBuilder toBuilder() {
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

}
