
package io.fabric8.openshift.api.model.config.v1;

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
public class IngressStatusComponentRoutes implements Editable<IngressStatusComponentRoutesBuilder> , KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressStatusCRConditions> conditions = new ArrayList<>();
    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> consumingUsers = new ArrayList<>();
    @JsonProperty("currentHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> currentHostnames = new ArrayList<>();
    @JsonProperty("defaultHostname")
    private String defaultHostname;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<IngressStatusCRRelatedObjects> relatedObjects = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public IngressStatusComponentRoutes() {
    }

    public IngressStatusComponentRoutes(List<IngressStatusCRConditions> conditions, List<String> consumingUsers, List<String> currentHostnames, String defaultHostname, String name, String namespace, List<IngressStatusCRRelatedObjects> relatedObjects) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressStatusCRConditions> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<IngressStatusCRConditions> conditions) {
        this.conditions = conditions;
    }

    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConsumingUsers() {
        return consumingUsers;
    }

    @JsonProperty("consumingUsers")
    public void setConsumingUsers(List<String> consumingUsers) {
        this.consumingUsers = consumingUsers;
    }

    @JsonProperty("currentHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<IngressStatusCRRelatedObjects> getRelatedObjects() {
        return relatedObjects;
    }

    @JsonProperty("relatedObjects")
    public void setRelatedObjects(List<IngressStatusCRRelatedObjects> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    @JsonIgnore
    public IngressStatusComponentRoutesBuilder edit() {
        return new IngressStatusComponentRoutesBuilder(this);
    }

    @JsonIgnore
    public IngressStatusComponentRoutesBuilder toBuilder() {
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
