
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.Condition;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "conditions",
    "consumingUsers",
    "currentHostnames",
    "defaultHostname",
    "name",
    "namespace",
    "relatedObjects"
})
@ToString
@EqualsAndHashCode
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ComponentRouteStatus implements KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<Condition>();
    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> consumingUsers = new ArrayList<String>();
    @JsonProperty("currentHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> currentHostnames = new ArrayList<String>();
    @JsonProperty("defaultHostname")
    private String defaultHostname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("relatedObjects")
    private List<io.fabric8.openshift.api.model.ObjectReference> relatedObjects = new ArrayList<io.fabric8.openshift.api.model.ObjectReference>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ComponentRouteStatus() {
    }

    /**
     * 
     * @param consumingUsers
     * @param name
     * @param namespace
     * @param conditions
     * @param currentHostnames
     * @param defaultHostname
     * @param relatedObjects
     */
    public ComponentRouteStatus(List<Condition> conditions, List<String> consumingUsers, List<String> currentHostnames, String defaultHostname, String name, String namespace, List<io.fabric8.openshift.api.model.ObjectReference> relatedObjects) {
        super();
        this.conditions = conditions;
        this.consumingUsers = consumingUsers;
        this.currentHostnames = currentHostnames;
        this.defaultHostname = defaultHostname;
        this.name = name;
        this.namespace = namespace;
        this.relatedObjects = relatedObjects;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("consumingUsers")
    public List<String> getConsumingUsers() {
        return consumingUsers;
    }

    @JsonProperty("consumingUsers")
    public void setConsumingUsers(List<String> consumingUsers) {
        this.consumingUsers = consumingUsers;
    }

    @JsonProperty("currentHostnames")
    public List<String> getCurrentHostnames() {
        return currentHostnames;
    }

    @JsonProperty("currentHostnames")
    public void setCurrentHostnames(List<String> currentHostnames) {
        this.currentHostnames = currentHostnames;
    }

    @JsonProperty("defaultHostname")
    public String getDefaultHostname() {
        return defaultHostname;
    }

    @JsonProperty("defaultHostname")
    public void setDefaultHostname(String defaultHostname) {
        this.defaultHostname = defaultHostname;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("relatedObjects")
    public List<io.fabric8.openshift.api.model.ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    @JsonProperty("relatedObjects")
    public void setRelatedObjects(List<io.fabric8.openshift.api.model.ObjectReference> relatedObjects) {
        this.relatedObjects = relatedObjects;
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
