
package io.fabric8.openshift.api.model;

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
import io.fabric8.kubernetes.api.model.HasMetadata;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import io.sundr.transform.annotations.TemplateTransformation;
import io.sundr.transform.annotations.TemplateTransformations;
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
    "groupNames",
    "roleRef",
    "subjects",
    "userNames"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(io.fabric8.kubernetes.api.model.ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@TemplateTransformations({
    @TemplateTransformation(value = "/manifest.vm", outputPath = "META-INF/services/io.fabric8.kubernetes.api.model.KubernetesResource", gather = true)
})
@Version("v1")
@Group("authorization.openshift.io")
@Generated("jsonschema2pojo")
public class RoleBinding implements HasMetadata, Namespaced
{

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    private String apiVersion = "authorization.openshift.io/v1";
    @JsonProperty("groupNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> groupNames = new ArrayList<String>();
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    private String kind = "RoleBinding";
    @JsonProperty("metadata")
    private io.fabric8.kubernetes.api.model.ObjectMeta metadata;
    @JsonProperty("roleRef")
    private io.fabric8.kubernetes.api.model.ObjectReference roleRef;
    @JsonProperty("subjects")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<io.fabric8.kubernetes.api.model.ObjectReference> subjects = new ArrayList<io.fabric8.kubernetes.api.model.ObjectReference>();
    @JsonProperty("userNames")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> userNames = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public RoleBinding() {
    }

    public RoleBinding(String apiVersion, List<String> groupNames, String kind, io.fabric8.kubernetes.api.model.ObjectMeta metadata, io.fabric8.kubernetes.api.model.ObjectReference roleRef, List<io.fabric8.kubernetes.api.model.ObjectReference> subjects, List<String> userNames) {
        super();
        this.apiVersion = apiVersion;
        this.groupNames = groupNames;
        this.kind = kind;
        this.metadata = metadata;
        this.roleRef = roleRef;
        this.subjects = subjects;
        this.userNames = userNames;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("groupNames")
    public List<String> getGroupNames() {
        return groupNames;
    }

    @JsonProperty("groupNames")
    public void setGroupNames(List<String> groupNames) {
        this.groupNames = groupNames;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("metadata")
    public io.fabric8.kubernetes.api.model.ObjectMeta getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(io.fabric8.kubernetes.api.model.ObjectMeta metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("roleRef")
    public io.fabric8.kubernetes.api.model.ObjectReference getRoleRef() {
        return roleRef;
    }

    @JsonProperty("roleRef")
    public void setRoleRef(io.fabric8.kubernetes.api.model.ObjectReference roleRef) {
        this.roleRef = roleRef;
    }

    @JsonProperty("subjects")
    public List<io.fabric8.kubernetes.api.model.ObjectReference> getSubjects() {
        return subjects;
    }

    @JsonProperty("subjects")
    public void setSubjects(List<io.fabric8.kubernetes.api.model.ObjectReference> subjects) {
        this.subjects = subjects;
    }

    @JsonProperty("userNames")
    public List<String> getUserNames() {
        return userNames;
    }

    @JsonProperty("userNames")
    public void setUserNames(List<String> userNames) {
        this.userNames = userNames;
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
