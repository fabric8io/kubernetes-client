
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
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
    "annotations",
    "creationTimestamp",
    "deletionGracePeriodSeconds",
    "deletionTimestamp",
    "finalizers",
    "generateName",
    "generation",
    "labels",
    "managedFields",
    "name",
    "namespace",
    "ownerReferences",
    "resourceVersion",
    "selfLink",
    "uid"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class ObjectMeta implements KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<String, String>();
    @JsonProperty("creationTimestamp")
    private String creationTimestamp;
    @JsonProperty("deletionGracePeriodSeconds")
    private Long deletionGracePeriodSeconds;
    @JsonProperty("deletionTimestamp")
    private String deletionTimestamp;
    @JsonProperty("finalizers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> finalizers = new ArrayList<java.lang.String>();
    @JsonProperty("generateName")
    private java.lang.String generateName;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<String, String>();
    @JsonProperty("managedFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManagedFieldsEntry> managedFields = new ArrayList<ManagedFieldsEntry>();
    @JsonProperty("name")
    private java.lang.String name;
    @JsonProperty("namespace")
    private java.lang.String namespace;
    @JsonProperty("ownerReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OwnerReference> ownerReferences = new ArrayList<OwnerReference>();
    @JsonProperty("resourceVersion")
    private java.lang.String resourceVersion;
    @JsonProperty("selfLink")
    private java.lang.String selfLink;
    @JsonProperty("uid")
    private java.lang.String uid;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ObjectMeta() {
    }

    public ObjectMeta(Map<String, String> annotations, String creationTimestamp, Long deletionGracePeriodSeconds, String deletionTimestamp, List<java.lang.String> finalizers, java.lang.String generateName, Long generation, Map<String, String> labels, List<ManagedFieldsEntry> managedFields, java.lang.String name, java.lang.String namespace, List<OwnerReference> ownerReferences, java.lang.String resourceVersion, java.lang.String selfLink, java.lang.String uid) {
        super();
        this.annotations = annotations;
        this.creationTimestamp = creationTimestamp;
        this.deletionGracePeriodSeconds = deletionGracePeriodSeconds;
        this.deletionTimestamp = deletionTimestamp;
        this.finalizers = finalizers;
        this.generateName = generateName;
        this.generation = generation;
        this.labels = labels;
        this.managedFields = managedFields;
        this.name = name;
        this.namespace = namespace;
        this.ownerReferences = ownerReferences;
        this.resourceVersion = resourceVersion;
        this.selfLink = selfLink;
        this.uid = uid;
    }

    @JsonProperty("annotations")
    public Map<String, String> getAnnotations() {
        return annotations;
    }

    @JsonProperty("annotations")
    public void setAnnotations(Map<String, String> annotations) {
        this.annotations = annotations;
    }

    @JsonProperty("creationTimestamp")
    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @JsonProperty("deletionGracePeriodSeconds")
    public Long getDeletionGracePeriodSeconds() {
        return deletionGracePeriodSeconds;
    }

    @JsonProperty("deletionGracePeriodSeconds")
    public void setDeletionGracePeriodSeconds(Long deletionGracePeriodSeconds) {
        this.deletionGracePeriodSeconds = deletionGracePeriodSeconds;
    }

    @JsonProperty("deletionTimestamp")
    public String getDeletionTimestamp() {
        return deletionTimestamp;
    }

    @JsonProperty("deletionTimestamp")
    public void setDeletionTimestamp(String deletionTimestamp) {
        this.deletionTimestamp = deletionTimestamp;
    }

    @JsonProperty("finalizers")
    public List<java.lang.String> getFinalizers() {
        return finalizers;
    }

    @JsonProperty("finalizers")
    public void setFinalizers(List<java.lang.String> finalizers) {
        this.finalizers = finalizers;
    }

    @JsonProperty("generateName")
    public java.lang.String getGenerateName() {
        return generateName;
    }

    @JsonProperty("generateName")
    public void setGenerateName(java.lang.String generateName) {
        this.generateName = generateName;
    }

    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    @JsonProperty("labels")
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("managedFields")
    public List<ManagedFieldsEntry> getManagedFields() {
        return managedFields;
    }

    @JsonProperty("managedFields")
    public void setManagedFields(List<ManagedFieldsEntry> managedFields) {
        this.managedFields = managedFields;
    }

    @JsonProperty("name")
    public java.lang.String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(java.lang.String name) {
        this.name = name;
    }

    @JsonProperty("namespace")
    public java.lang.String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(java.lang.String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("ownerReferences")
    public List<OwnerReference> getOwnerReferences() {
        return ownerReferences;
    }

    @JsonProperty("ownerReferences")
    public void setOwnerReferences(List<OwnerReference> ownerReferences) {
        this.ownerReferences = ownerReferences;
    }

    @JsonProperty("resourceVersion")
    public java.lang.String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(java.lang.String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @JsonProperty("selfLink")
    public java.lang.String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(java.lang.String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("uid")
    public java.lang.String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
