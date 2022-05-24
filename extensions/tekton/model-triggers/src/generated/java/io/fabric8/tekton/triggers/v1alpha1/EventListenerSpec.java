
package io.fabric8.tekton.triggers.v1alpha1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.ContainerPort;
import io.fabric8.kubernetes.api.model.EnvVar;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
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
    "labelSelector",
    "namespaceSelector",
    "podTemplate",
    "replicas",
    "resources",
    "serviceAccountName",
    "serviceType",
    "triggers"
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
    @BuildableReference(io.fabric8.kubernetes.api.model.LabelSelector.class),
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
public class EventListenerSpec implements KubernetesResource
{

    @JsonProperty("labelSelector")
    private io.fabric8.kubernetes.api.model.LabelSelector labelSelector;
    @JsonProperty("namespaceSelector")
    private NamespaceSelector namespaceSelector;
    @JsonProperty("podTemplate")
    private PodTemplate podTemplate;
    @JsonProperty("replicas")
    private Integer replicas;
    @JsonProperty("resources")
    private Resources resources;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceType")
    private String serviceType;
    @JsonProperty("triggers")
    private List<EventListenerTrigger> triggers = new ArrayList<EventListenerTrigger>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public EventListenerSpec() {
    }

    /**
     * 
     * @param serviceType
     * @param replicas
     * @param serviceAccountName
     * @param labelSelector
     * @param namespaceSelector
     * @param podTemplate
     * @param resources
     * @param triggers
     */
    public EventListenerSpec(io.fabric8.kubernetes.api.model.LabelSelector labelSelector, NamespaceSelector namespaceSelector, PodTemplate podTemplate, Integer replicas, Resources resources, String serviceAccountName, String serviceType, List<EventListenerTrigger> triggers) {
        super();
        this.labelSelector = labelSelector;
        this.namespaceSelector = namespaceSelector;
        this.podTemplate = podTemplate;
        this.replicas = replicas;
        this.resources = resources;
        this.serviceAccountName = serviceAccountName;
        this.serviceType = serviceType;
        this.triggers = triggers;
    }

    @JsonProperty("labelSelector")
    public io.fabric8.kubernetes.api.model.LabelSelector getLabelSelector() {
        return labelSelector;
    }

    @JsonProperty("labelSelector")
    public void setLabelSelector(io.fabric8.kubernetes.api.model.LabelSelector labelSelector) {
        this.labelSelector = labelSelector;
    }

    @JsonProperty("namespaceSelector")
    public NamespaceSelector getNamespaceSelector() {
        return namespaceSelector;
    }

    @JsonProperty("namespaceSelector")
    public void setNamespaceSelector(NamespaceSelector namespaceSelector) {
        this.namespaceSelector = namespaceSelector;
    }

    @JsonProperty("podTemplate")
    public PodTemplate getPodTemplate() {
        return podTemplate;
    }

    @JsonProperty("podTemplate")
    public void setPodTemplate(PodTemplate podTemplate) {
        this.podTemplate = podTemplate;
    }

    @JsonProperty("replicas")
    public Integer getReplicas() {
        return replicas;
    }

    @JsonProperty("replicas")
    public void setReplicas(Integer replicas) {
        this.replicas = replicas;
    }

    @JsonProperty("resources")
    public Resources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    @JsonProperty("serviceType")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("serviceType")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonProperty("triggers")
    public List<EventListenerTrigger> getTriggers() {
        return triggers;
    }

    @JsonProperty("triggers")
    public void setTriggers(List<EventListenerTrigger> triggers) {
        this.triggers = triggers;
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
