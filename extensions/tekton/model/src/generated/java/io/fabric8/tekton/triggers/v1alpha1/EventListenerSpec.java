
package io.fabric8.tekton.triggers.v1alpha1;

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
 * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labelSelector",
    "namespaceSelector",
    "resources",
    "serviceAccountName",
    "triggers"
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
public class EventListenerSpec implements Editable<EventListenerSpecBuilder>, KubernetesResource
{

    @JsonProperty("labelSelector")
    private LabelSelector labelSelector;
    @JsonProperty("namespaceSelector")
    private NamespaceSelector namespaceSelector;
    @JsonProperty("resources")
    private Resources resources;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("triggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<EventListenerTrigger> triggers = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public EventListenerSpec() {
    }

    public EventListenerSpec(LabelSelector labelSelector, NamespaceSelector namespaceSelector, Resources resources, String serviceAccountName, List<EventListenerTrigger> triggers) {
        super();
        this.labelSelector = labelSelector;
        this.namespaceSelector = namespaceSelector;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.triggers = triggers;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("labelSelector")
    public LabelSelector getLabelSelector() {
        return labelSelector;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("labelSelector")
    public void setLabelSelector(LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("namespaceSelector")
    public NamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(NamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("resources")
    public Resources getResources() {
        return resources;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("resources")
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("triggers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<EventListenerTrigger> getTriggers() {
        return triggers;
    }

    /**
     * EventListenerSpec defines the desired state of the EventListener, represented by a list of Triggers.
     */
    @JsonProperty("triggers")
    public void setTriggers(List<EventListenerTrigger> triggers) {
        this.triggers = triggers;
    }

    @JsonIgnore
    public EventListenerSpecBuilder edit() {
        return new EventListenerSpecBuilder(this);
    }

    @JsonIgnore
    public EventListenerSpecBuilder toBuilder() {
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
        if (!(o instanceof EventListenerSpec)) {
            return false;
        }
        EventListenerSpec other = (EventListenerSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$labelSelector = this.getLabelSelector();
        Object other$labelSelector = other.getLabelSelector();
        if (this$labelSelector == null ? other$labelSelector != null : !this$labelSelector.equals(other$labelSelector)) {
            return false;
        }
        Object this$namespaceSelector = this.getNamespaceSelector();
        Object other$namespaceSelector = other.getNamespaceSelector();
        if (this$namespaceSelector == null ? other$namespaceSelector != null : !this$namespaceSelector.equals(other$namespaceSelector)) {
            return false;
        }
        Object this$resources = this.getResources();
        Object other$resources = other.getResources();
        if (this$resources == null ? other$resources != null : !this$resources.equals(other$resources)) {
            return false;
        }
        Object this$serviceAccountName = this.getServiceAccountName();
        Object other$serviceAccountName = other.getServiceAccountName();
        if (this$serviceAccountName == null ? other$serviceAccountName != null : !this$serviceAccountName.equals(other$serviceAccountName)) {
            return false;
        }
        Object this$triggers = this.getTriggers();
        Object other$triggers = other.getTriggers();
        if (this$triggers == null ? other$triggers != null : !this$triggers.equals(other$triggers)) {
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
        return other instanceof EventListenerSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $labelSelector = this.getLabelSelector();
        result = result * prime + ($labelSelector == null ? 43 : $labelSelector.hashCode());
        Object $namespaceSelector = this.getNamespaceSelector();
        result = result * prime + ($namespaceSelector == null ? 43 : $namespaceSelector.hashCode());
        Object $resources = this.getResources();
        result = result * prime + ($resources == null ? 43 : $resources.hashCode());
        Object $serviceAccountName = this.getServiceAccountName();
        result = result * prime + ($serviceAccountName == null ? 43 : $serviceAccountName.hashCode());
        Object $triggers = this.getTriggers();
        result = result * prime + ($triggers == null ? 43 : $triggers.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EventListenerSpec(" + "labelSelector=" + this.getLabelSelector() + ", namespaceSelector=" + this.getNamespaceSelector() + ", resources=" + this.getResources() + ", serviceAccountName=" + this.getServiceAccountName() + ", triggers=" + this.getTriggers() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
