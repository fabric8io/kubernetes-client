
package io.fabric8.kubernetes.api.model.admissionregistration.v1;

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
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * NamedRuleWithOperations is a tuple of Operations and Resources with ResourceNames.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiGroups",
    "apiVersions",
    "operations",
    "resourceNames",
    "resources",
    "scope"
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
public class NamedRuleWithOperations implements Editable<NamedRuleWithOperationsBuilder>, KubernetesResource
{

    @JsonProperty("apiGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiGroups = new ArrayList<>();
    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVersions = new ArrayList<>();
    @JsonProperty("operations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> operations = new ArrayList<>();
    @JsonProperty("resourceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resourceNames = new ArrayList<>();
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> resources = new ArrayList<>();
    @JsonProperty("scope")
    private String scope;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public NamedRuleWithOperations() {
    }

    public NamedRuleWithOperations(List<String> apiGroups, List<String> apiVersions, List<String> operations, List<String> resourceNames, List<String> resources, String scope) {
        super();
        this.apiGroups = apiGroups;
        this.apiVersions = apiVersions;
        this.operations = operations;
        this.resourceNames = resourceNames;
        this.resources = resources;
        this.scope = scope;
    }

    /**
     * APIGroups is the API groups the resources belong to. '&#42;' is all groups. If '&#42;' is present, the length of the slice must be one. Required.
     */
    @JsonProperty("apiGroups")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiGroups() {
        return apiGroups;
    }

    /**
     * APIGroups is the API groups the resources belong to. '&#42;' is all groups. If '&#42;' is present, the length of the slice must be one. Required.
     */
    @JsonProperty("apiGroups")
    public void setApiGroups(List<String> apiGroups) {
        this.apiGroups = apiGroups;
    }

    /**
     * APIVersions is the API versions the resources belong to. '&#42;' is all versions. If '&#42;' is present, the length of the slice must be one. Required.
     */
    @JsonProperty("apiVersions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVersions() {
        return apiVersions;
    }

    /**
     * APIVersions is the API versions the resources belong to. '&#42;' is all versions. If '&#42;' is present, the length of the slice must be one. Required.
     */
    @JsonProperty("apiVersions")
    public void setApiVersions(List<String> apiVersions) {
        this.apiVersions = apiVersions;
    }

    /**
     * Operations is the operations the admission hook cares about - CREATE, UPDATE, DELETE, CONNECT or &#42; for all of those operations and any future admission operations that are added. If '&#42;' is present, the length of the slice must be one. Required.
     */
    @JsonProperty("operations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getOperations() {
        return operations;
    }

    /**
     * Operations is the operations the admission hook cares about - CREATE, UPDATE, DELETE, CONNECT or &#42; for all of those operations and any future admission operations that are added. If '&#42;' is present, the length of the slice must be one. Required.
     */
    @JsonProperty("operations")
    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    /**
     * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
     */
    @JsonProperty("resourceNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResourceNames() {
        return resourceNames;
    }

    /**
     * ResourceNames is an optional white list of names that the rule applies to.  An empty set means that everything is allowed.
     */
    @JsonProperty("resourceNames")
    public void setResourceNames(List<String> resourceNames) {
        this.resourceNames = resourceNames;
    }

    /**
     * Resources is a list of resources this rule applies to.<br><p> <br><p> For example: 'pods' means pods. 'pods/log' means the log subresource of pods. '&#42;' means all resources, but not subresources. 'pods/&#42;' means all subresources of pods. '&#42;/scale' means all scale subresources. '&#42;/&#42;' means all resources and their subresources.<br><p> <br><p> If wildcard is present, the validation rule will ensure resources do not overlap with each other.<br><p> <br><p> Depending on the enclosing object, subresources might not be allowed. Required.
     */
    @JsonProperty("resources")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getResources() {
        return resources;
    }

    /**
     * Resources is a list of resources this rule applies to.<br><p> <br><p> For example: 'pods' means pods. 'pods/log' means the log subresource of pods. '&#42;' means all resources, but not subresources. 'pods/&#42;' means all subresources of pods. '&#42;/scale' means all scale subresources. '&#42;/&#42;' means all resources and their subresources.<br><p> <br><p> If wildcard is present, the validation rule will ensure resources do not overlap with each other.<br><p> <br><p> Depending on the enclosing object, subresources might not be allowed. Required.
     */
    @JsonProperty("resources")
    public void setResources(List<String> resources) {
        this.resources = resources;
    }

    /**
     * scope specifies the scope of this rule. Valid values are "Cluster", "Namespaced", and "&#42;" "Cluster" means that only cluster-scoped resources will match this rule. Namespace API objects are cluster-scoped. "Namespaced" means that only namespaced resources will match this rule. "&#42;" means that there are no scope restrictions. Subresources match the scope of their parent resource. Default is "&#42;".
     */
    @JsonProperty("scope")
    public String getScope() {
        return scope;
    }

    /**
     * scope specifies the scope of this rule. Valid values are "Cluster", "Namespaced", and "&#42;" "Cluster" means that only cluster-scoped resources will match this rule. Namespace API objects are cluster-scoped. "Namespaced" means that only namespaced resources will match this rule. "&#42;" means that there are no scope restrictions. Subresources match the scope of their parent resource. Default is "&#42;".
     */
    @JsonProperty("scope")
    public void setScope(String scope) {
        this.scope = scope;
    }

    @JsonIgnore
    public NamedRuleWithOperationsBuilder edit() {
        return new NamedRuleWithOperationsBuilder(this);
    }

    @JsonIgnore
    public NamedRuleWithOperationsBuilder toBuilder() {
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
