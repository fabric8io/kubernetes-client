
package io.fabric8.kubernetes.api.model.authorization.v1beta1;

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
    "extra",
    "group",
    "nonResourceAttributes",
    "resourceAttributes",
    "uid",
    "user"
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
public class SubjectAccessReviewSpec implements KubernetesResource
{

    @JsonProperty("extra")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, ArrayList<String>> extra = new LinkedHashMap<String, ArrayList<String>>();
    @JsonProperty("group")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<java.lang.String> group = new ArrayList<java.lang.String>();
    @JsonProperty("nonResourceAttributes")
    private NonResourceAttributes nonResourceAttributes;
    @JsonProperty("resourceAttributes")
    private ResourceAttributes resourceAttributes;
    @JsonProperty("uid")
    private java.lang.String uid;
    @JsonProperty("user")
    private java.lang.String user;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubjectAccessReviewSpec() {
    }

    public SubjectAccessReviewSpec(Map<String, ArrayList<String>> extra, List<java.lang.String> group, NonResourceAttributes nonResourceAttributes, ResourceAttributes resourceAttributes, java.lang.String uid, java.lang.String user) {
        super();
        this.extra = extra;
        this.group = group;
        this.nonResourceAttributes = nonResourceAttributes;
        this.resourceAttributes = resourceAttributes;
        this.uid = uid;
        this.user = user;
    }

    @JsonProperty("extra")
    public Map<String, ArrayList<String>> getExtra() {
        return extra;
    }

    @JsonProperty("extra")
    public void setExtra(Map<String, ArrayList<String>> extra) {
        this.extra = extra;
    }

    @JsonProperty("group")
    public List<java.lang.String> getGroup() {
        return group;
    }

    @JsonProperty("group")
    public void setGroup(List<java.lang.String> group) {
        this.group = group;
    }

    @JsonProperty("nonResourceAttributes")
    public NonResourceAttributes getNonResourceAttributes() {
        return nonResourceAttributes;
    }

    @JsonProperty("nonResourceAttributes")
    public void setNonResourceAttributes(NonResourceAttributes nonResourceAttributes) {
        this.nonResourceAttributes = nonResourceAttributes;
    }

    @JsonProperty("resourceAttributes")
    public ResourceAttributes getResourceAttributes() {
        return resourceAttributes;
    }

    @JsonProperty("resourceAttributes")
    public void setResourceAttributes(ResourceAttributes resourceAttributes) {
        this.resourceAttributes = resourceAttributes;
    }

    @JsonProperty("uid")
    public java.lang.String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    @JsonProperty("user")
    public java.lang.String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(java.lang.String user) {
        this.user = user;
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
