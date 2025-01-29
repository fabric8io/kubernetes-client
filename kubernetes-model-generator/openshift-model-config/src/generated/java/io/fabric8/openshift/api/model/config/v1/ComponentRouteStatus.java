
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
import io.fabric8.kubernetes.api.model.Condition;
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
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * ComponentRouteStatus contains information allowing configuration of a route's hostname and serving certificate.
 */
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
    @BuildableReference(PersistentVolumeClaim.class),
    @BuildableReference(EnvVar.class),
    @BuildableReference(ContainerPort.class),
    @BuildableReference(Volume.class),
    @BuildableReference(VolumeMount.class)
})
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ComponentRouteStatus implements Editable<ComponentRouteStatusBuilder>, KubernetesResource
{

    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Condition> conditions = new ArrayList<>();
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
    private List<ObjectReference> relatedObjects = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ComponentRouteStatus() {
    }

    public ComponentRouteStatus(List<Condition> conditions, List<String> consumingUsers, List<String> currentHostnames, String defaultHostname, String name, String namespace, List<ObjectReference> relatedObjects) {
        super();
        this.conditions = conditions;
        this.consumingUsers = consumingUsers;
        this.currentHostnames = currentHostnames;
        this.defaultHostname = defaultHostname;
        this.name = name;
        this.namespace = namespace;
        this.relatedObjects = relatedObjects;
    }

    /**
     * conditions are used to communicate the state of the componentRoutes entry.<br><p> <br><p> Supported conditions include Available, Degraded and Progressing.<br><p> <br><p> If available is true, the content served by the route can be accessed by users. This includes cases where a default may continue to serve content while the customized route specified by the cluster-admin is being configured.<br><p> <br><p> If Degraded is true, that means something has gone wrong trying to handle the componentRoutes entry. The currentHostnames field may or may not be in effect.<br><p> <br><p> If Progressing is true, that means the component is taking some action related to the componentRoutes entry.
     */
    @JsonProperty("conditions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Condition> getConditions() {
        return conditions;
    }

    /**
     * conditions are used to communicate the state of the componentRoutes entry.<br><p> <br><p> Supported conditions include Available, Degraded and Progressing.<br><p> <br><p> If available is true, the content served by the route can be accessed by users. This includes cases where a default may continue to serve content while the customized route specified by the cluster-admin is being configured.<br><p> <br><p> If Degraded is true, that means something has gone wrong trying to handle the componentRoutes entry. The currentHostnames field may or may not be in effect.<br><p> <br><p> If Progressing is true, that means the component is taking some action related to the componentRoutes entry.
     */
    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    /**
     * consumingUsers is a slice of ServiceAccounts that need to have read permission on the servingCertKeyPairSecret secret.
     */
    @JsonProperty("consumingUsers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getConsumingUsers() {
        return consumingUsers;
    }

    /**
     * consumingUsers is a slice of ServiceAccounts that need to have read permission on the servingCertKeyPairSecret secret.
     */
    @JsonProperty("consumingUsers")
    public void setConsumingUsers(List<String> consumingUsers) {
        this.consumingUsers = consumingUsers;
    }

    /**
     * currentHostnames is the list of current names used by the route. Typically, this list should consist of a single hostname, but if multiple hostnames are supported by the route the operator may write multiple entries to this list.
     */
    @JsonProperty("currentHostnames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getCurrentHostnames() {
        return currentHostnames;
    }

    /**
     * currentHostnames is the list of current names used by the route. Typically, this list should consist of a single hostname, but if multiple hostnames are supported by the route the operator may write multiple entries to this list.
     */
    @JsonProperty("currentHostnames")
    public void setCurrentHostnames(List<String> currentHostnames) {
        this.currentHostnames = currentHostnames;
    }

    /**
     * defaultHostname is the hostname of this route prior to customization.
     */
    @JsonProperty("defaultHostname")
    public String getDefaultHostname() {
        return defaultHostname;
    }

    /**
     * defaultHostname is the hostname of this route prior to customization.
     */
    @JsonProperty("defaultHostname")
    public void setDefaultHostname(String defaultHostname) {
        this.defaultHostname = defaultHostname;
    }

    /**
     * name is the logical name of the route to customize. It does not have to be the actual name of a route resource but it cannot be renamed.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of spec.componentRoutes if the route is to be customized.
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name is the logical name of the route to customize. It does not have to be the actual name of a route resource but it cannot be renamed.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of spec.componentRoutes if the route is to be customized.
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * namespace is the namespace of the route to customize. It must be a real namespace. Using an actual namespace ensures that no two components will conflict and the same component can be installed multiple times.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of spec.componentRoutes if the route is to be customized.
     */
    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    /**
     * namespace is the namespace of the route to customize. It must be a real namespace. Using an actual namespace ensures that no two components will conflict and the same component can be installed multiple times.<br><p> <br><p> The namespace and name of this componentRoute must match a corresponding entry in the list of spec.componentRoutes if the route is to be customized.
     */
    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * relatedObjects is a list of resources which are useful when debugging or inspecting how spec.componentRoutes is applied.
     */
    @JsonProperty("relatedObjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ObjectReference> getRelatedObjects() {
        return relatedObjects;
    }

    /**
     * relatedObjects is a list of resources which are useful when debugging or inspecting how spec.componentRoutes is applied.
     */
    @JsonProperty("relatedObjects")
    public void setRelatedObjects(List<ObjectReference> relatedObjects) {
        this.relatedObjects = relatedObjects;
    }

    @JsonIgnore
    public ComponentRouteStatusBuilder edit() {
        return new ComponentRouteStatusBuilder(this);
    }

    @JsonIgnore
    public ComponentRouteStatusBuilder toBuilder() {
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
