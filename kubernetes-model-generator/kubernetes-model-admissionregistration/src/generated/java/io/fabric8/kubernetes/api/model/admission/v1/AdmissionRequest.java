
package io.fabric8.kubernetes.api.model.admission.v1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.GroupVersionKind;
import io.fabric8.kubernetes.api.model.GroupVersionResource;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.authentication.UserInfo;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "dryRun",
    "name",
    "namespace",
    "object",
    "oldObject",
    "operation",
    "options",
    "requestKind",
    "requestResource",
    "requestSubResource",
    "resource",
    "subResource",
    "uid",
    "userInfo"
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
public class AdmissionRequest implements Editable<AdmissionRequestBuilder> , KubernetesResource
{

    @JsonProperty("dryRun")
    private Boolean dryRun;
    @JsonProperty("kind")
    private GroupVersionKind kind;
    @JsonProperty("name")
    private String name;
    @JsonProperty("namespace")
    private String namespace;
    @JsonProperty("object")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object object;
    @JsonProperty("oldObject")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object oldObject;
    @JsonProperty("operation")
    private String operation;
    @JsonProperty("options")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    private Object options;
    @JsonProperty("requestKind")
    private GroupVersionKind requestKind;
    @JsonProperty("requestResource")
    private GroupVersionResource requestResource;
    @JsonProperty("requestSubResource")
    private String requestSubResource;
    @JsonProperty("resource")
    private GroupVersionResource resource;
    @JsonProperty("subResource")
    private String subResource;
    @JsonProperty("uid")
    private String uid;
    @JsonProperty("userInfo")
    private UserInfo userInfo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AdmissionRequest() {
    }

    public AdmissionRequest(Boolean dryRun, GroupVersionKind kind, String name, String namespace, Object object, Object oldObject, String operation, Object options, GroupVersionKind requestKind, GroupVersionResource requestResource, String requestSubResource, GroupVersionResource resource, String subResource, String uid, UserInfo userInfo) {
        super();
        this.dryRun = dryRun;
        this.kind = kind;
        this.name = name;
        this.namespace = namespace;
        this.object = object;
        this.oldObject = oldObject;
        this.operation = operation;
        this.options = options;
        this.requestKind = requestKind;
        this.requestResource = requestResource;
        this.requestSubResource = requestSubResource;
        this.resource = resource;
        this.subResource = subResource;
        this.uid = uid;
        this.userInfo = userInfo;
    }

    @JsonProperty("dryRun")
    public Boolean getDryRun() {
        return dryRun;
    }

    @JsonProperty("dryRun")
    public void setDryRun(Boolean dryRun) {
        this.dryRun = dryRun;
    }

    @JsonProperty("kind")
    public GroupVersionKind getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(GroupVersionKind kind) {
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

    @JsonProperty("namespace")
    public String getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("object")
    public Object getObject() {
        return object;
    }

    @JsonProperty("object")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setObject(Object object) {
        this.object = object;
    }

    @JsonProperty("oldObject")
    public Object getOldObject() {
        return oldObject;
    }

    @JsonProperty("oldObject")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setOldObject(Object oldObject) {
        this.oldObject = oldObject;
    }

    @JsonProperty("operation")
    public String getOperation() {
        return operation;
    }

    @JsonProperty("operation")
    public void setOperation(String operation) {
        this.operation = operation;
    }

    @JsonProperty("options")
    public Object getOptions() {
        return options;
    }

    @JsonProperty("options")
    @JsonDeserialize(using = io.fabric8.kubernetes.internal.KubernetesDeserializer.class)
    public void setOptions(Object options) {
        this.options = options;
    }

    @JsonProperty("requestKind")
    public GroupVersionKind getRequestKind() {
        return requestKind;
    }

    @JsonProperty("requestKind")
    public void setRequestKind(GroupVersionKind requestKind) {
        this.requestKind = requestKind;
    }

    @JsonProperty("requestResource")
    public GroupVersionResource getRequestResource() {
        return requestResource;
    }

    @JsonProperty("requestResource")
    public void setRequestResource(GroupVersionResource requestResource) {
        this.requestResource = requestResource;
    }

    @JsonProperty("requestSubResource")
    public String getRequestSubResource() {
        return requestSubResource;
    }

    @JsonProperty("requestSubResource")
    public void setRequestSubResource(String requestSubResource) {
        this.requestSubResource = requestSubResource;
    }

    @JsonProperty("resource")
    public GroupVersionResource getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(GroupVersionResource resource) {
        this.resource = resource;
    }

    @JsonProperty("subResource")
    public String getSubResource() {
        return subResource;
    }

    @JsonProperty("subResource")
    public void setSubResource(String subResource) {
        this.subResource = subResource;
    }

    @JsonProperty("uid")
    public String getUid() {
        return uid;
    }

    @JsonProperty("uid")
    public void setUid(String uid) {
        this.uid = uid;
    }

    @JsonProperty("userInfo")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @JsonProperty("userInfo")
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @JsonIgnore
    public AdmissionRequestBuilder edit() {
        return new AdmissionRequestBuilder(this);
    }

    @JsonIgnore
    public AdmissionRequestBuilder toBuilder() {
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
