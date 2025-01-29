
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class ObjectMeta implements Editable<ObjectMetaBuilder>, KubernetesResource
{

    @JsonProperty("annotations")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> annotations = new LinkedHashMap<>();
    @JsonProperty("creationTimestamp")
    private String creationTimestamp;
    @JsonProperty("deletionGracePeriodSeconds")
    private Long deletionGracePeriodSeconds;
    @JsonProperty("deletionTimestamp")
    private String deletionTimestamp;
    @JsonProperty("finalizers")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> finalizers = new ArrayList<>();
    @JsonProperty("generateName")
    private String generateName;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("labels")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, String> labels = new LinkedHashMap<>();
    @JsonProperty("managedFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ManagedFieldsEntry> managedFields = new ArrayList<>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("ownerReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<OwnerReference> ownerReferences = new ArrayList<>();
    @JsonProperty("resourceVersion")
    private String resourceVersion;
    @JsonProperty("selfLink")
    private String selfLink;
    @JsonProperty("uid")
    private String uid;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public ObjectMeta() {
    }

    public ObjectMeta(Map<String, String> annotations, String creationTimestamp, Long deletionGracePeriodSeconds, String deletionTimestamp, List<String> finalizers, String generateName, Long generation, Map<String, String> labels, List<ManagedFieldsEntry> managedFields, String name, String namespace, List<OwnerReference> ownerReferences, String resourceVersion, String selfLink, String uid) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getFinalizers() {
        return finalizers;
    }

    @JsonProperty("finalizers")
    public void setFinalizers(List<String> finalizers) {
        this.finalizers = finalizers;
    }

    @JsonProperty("generateName")
    public String getGenerateName() {
        return generateName;
    }

    @JsonProperty("generateName")
    public void setGenerateName(String generateName) {
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, String> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(Map<String, String> labels) {
        this.labels = labels;
    }

    @JsonProperty("managedFields")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<ManagedFieldsEntry> getManagedFields() {
        return managedFields;
    }

    @JsonProperty("managedFields")
    public void setManagedFields(List<ManagedFieldsEntry> managedFields) {
        this.managedFields = managedFields;
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

    @JsonProperty("ownerReferences")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<OwnerReference> getOwnerReferences() {
        return ownerReferences;
    }

    @JsonProperty("ownerReferences")
    public void setOwnerReferences(List<OwnerReference> ownerReferences) {
        this.ownerReferences = ownerReferences;
    }

    @JsonProperty("resourceVersion")
    public String getResourceVersion() {
        return resourceVersion;
    }

    @JsonProperty("resourceVersion")
    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonIgnore
    public ObjectMetaBuilder edit() {
        return new ObjectMetaBuilder(this);
    }

    @JsonIgnore
    public ObjectMetaBuilder toBuilder() {
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
