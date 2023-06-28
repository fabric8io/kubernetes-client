
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "actionDescriptors",
    "description",
    "displayName",
    "name",
    "resources",
    "specDescriptors",
    "statusDescriptors",
    "version"
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
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class CRDDescription implements KubernetesResource
{

    @JsonProperty("actionDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ActionDescriptor> actionDescriptors = new ArrayList<ActionDescriptor>();
    @JsonProperty("description")
    private String description;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("kind")
    private String kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<APIResourceReference> resources = new ArrayList<APIResourceReference>();
    @JsonProperty("specDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SpecDescriptor> specDescriptors = new ArrayList<SpecDescriptor>();
    @JsonProperty("statusDescriptors")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<StatusDescriptor> statusDescriptors = new ArrayList<StatusDescriptor>();
    @JsonProperty("version")
    private String version;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public CRDDescription() {
    }

    public CRDDescription(List<ActionDescriptor> actionDescriptors, String description, String displayName, String kind, String name, List<APIResourceReference> resources, List<SpecDescriptor> specDescriptors, List<StatusDescriptor> statusDescriptors, String version) {
        super();
        this.actionDescriptors = actionDescriptors;
        this.description = description;
        this.displayName = displayName;
        this.kind = kind;
        this.name = name;
        this.resources = resources;
        this.specDescriptors = specDescriptors;
        this.statusDescriptors = statusDescriptors;
        this.version = version;
    }

    @JsonProperty("actionDescriptors")
    public List<ActionDescriptor> getActionDescriptors() {
        return actionDescriptors;
    }

    @JsonProperty("actionDescriptors")
    public void setActionDescriptors(List<ActionDescriptor> actionDescriptors) {
        this.actionDescriptors = actionDescriptors;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("resources")
    public List<APIResourceReference> getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(List<APIResourceReference> resources) {
        this.resources = resources;
    }

    @JsonProperty("specDescriptors")
    public List<SpecDescriptor> getSpecDescriptors() {
        return specDescriptors;
    }

    @JsonProperty("specDescriptors")
    public void setSpecDescriptors(List<SpecDescriptor> specDescriptors) {
        this.specDescriptors = specDescriptors;
    }

    @JsonProperty("statusDescriptors")
    public List<StatusDescriptor> getStatusDescriptors() {
        return statusDescriptors;
    }

    @JsonProperty("statusDescriptors")
    public void setStatusDescriptors(List<StatusDescriptor> statusDescriptors) {
        this.statusDescriptors = statusDescriptors;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
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
