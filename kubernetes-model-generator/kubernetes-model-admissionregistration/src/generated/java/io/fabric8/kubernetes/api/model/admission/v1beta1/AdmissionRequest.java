
package io.fabric8.kubernetes.api.model.admission.v1beta1;

import java.util.LinkedHashMap;
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
import io.fabric8.kubernetes.api.model.Volume;
import io.fabric8.kubernetes.api.model.VolumeMount;
import io.fabric8.kubernetes.api.model.authentication.UserInfo;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

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
public class AdmissionRequest implements Editable<AdmissionRequestBuilder>, KubernetesResource
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdmissionRequest)) {
            return false;
        }
        AdmissionRequest other = (AdmissionRequest) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$dryRun = this.getDryRun();
        Object other$dryRun = other.getDryRun();
        if (this$dryRun == null ? other$dryRun != null : !this$dryRun.equals(other$dryRun)) {
            return false;
        }
        Object this$kind = this.getKind();
        Object other$kind = other.getKind();
        if (this$kind == null ? other$kind != null : !this$kind.equals(other$kind)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$namespace = this.getNamespace();
        Object other$namespace = other.getNamespace();
        if (this$namespace == null ? other$namespace != null : !this$namespace.equals(other$namespace)) {
            return false;
        }
        Object this$object = this.getObject();
        Object other$object = other.getObject();
        if (this$object == null ? other$object != null : !this$object.equals(other$object)) {
            return false;
        }
        Object this$oldObject = this.getOldObject();
        Object other$oldObject = other.getOldObject();
        if (this$oldObject == null ? other$oldObject != null : !this$oldObject.equals(other$oldObject)) {
            return false;
        }
        Object this$operation = this.getOperation();
        Object other$operation = other.getOperation();
        if (this$operation == null ? other$operation != null : !this$operation.equals(other$operation)) {
            return false;
        }
        Object this$options = this.getOptions();
        Object other$options = other.getOptions();
        if (this$options == null ? other$options != null : !this$options.equals(other$options)) {
            return false;
        }
        Object this$requestKind = this.getRequestKind();
        Object other$requestKind = other.getRequestKind();
        if (this$requestKind == null ? other$requestKind != null : !this$requestKind.equals(other$requestKind)) {
            return false;
        }
        Object this$requestResource = this.getRequestResource();
        Object other$requestResource = other.getRequestResource();
        if (this$requestResource == null ? other$requestResource != null : !this$requestResource.equals(other$requestResource)) {
            return false;
        }
        Object this$requestSubResource = this.getRequestSubResource();
        Object other$requestSubResource = other.getRequestSubResource();
        if (this$requestSubResource == null ? other$requestSubResource != null : !this$requestSubResource.equals(other$requestSubResource)) {
            return false;
        }
        Object this$resource = this.getResource();
        Object other$resource = other.getResource();
        if (this$resource == null ? other$resource != null : !this$resource.equals(other$resource)) {
            return false;
        }
        Object this$subResource = this.getSubResource();
        Object other$subResource = other.getSubResource();
        if (this$subResource == null ? other$subResource != null : !this$subResource.equals(other$subResource)) {
            return false;
        }
        Object this$uid = this.getUid();
        Object other$uid = other.getUid();
        if (this$uid == null ? other$uid != null : !this$uid.equals(other$uid)) {
            return false;
        }
        Object this$userInfo = this.getUserInfo();
        Object other$userInfo = other.getUserInfo();
        if (this$userInfo == null ? other$userInfo != null : !this$userInfo.equals(other$userInfo)) {
            return false;
        }
        Object this$additionalProperties = this.getAdditionalProperties();
        Object other$additionalProperties = other.getAdditionalProperties();
        if (this$additionalProperties == null ? other$additionalProperties != null : !this$additionalProperties.equals(other$additionalProperties)) {
            return false;
        }
        return true;
    }

    protected boolean canEqual(Object other) {
        return other instanceof AdmissionRequest;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $dryRun = this.getDryRun();
        result = result * prime + ($dryRun == null ? 43 : $dryRun.hashCode());
        Object $kind = this.getKind();
        result = result * prime + ($kind == null ? 43 : $kind.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $namespace = this.getNamespace();
        result = result * prime + ($namespace == null ? 43 : $namespace.hashCode());
        Object $object = this.getObject();
        result = result * prime + ($object == null ? 43 : $object.hashCode());
        Object $oldObject = this.getOldObject();
        result = result * prime + ($oldObject == null ? 43 : $oldObject.hashCode());
        Object $operation = this.getOperation();
        result = result * prime + ($operation == null ? 43 : $operation.hashCode());
        Object $options = this.getOptions();
        result = result * prime + ($options == null ? 43 : $options.hashCode());
        Object $requestKind = this.getRequestKind();
        result = result * prime + ($requestKind == null ? 43 : $requestKind.hashCode());
        Object $requestResource = this.getRequestResource();
        result = result * prime + ($requestResource == null ? 43 : $requestResource.hashCode());
        Object $requestSubResource = this.getRequestSubResource();
        result = result * prime + ($requestSubResource == null ? 43 : $requestSubResource.hashCode());
        Object $resource = this.getResource();
        result = result * prime + ($resource == null ? 43 : $resource.hashCode());
        Object $subResource = this.getSubResource();
        result = result * prime + ($subResource == null ? 43 : $subResource.hashCode());
        Object $uid = this.getUid();
        result = result * prime + ($uid == null ? 43 : $uid.hashCode());
        Object $userInfo = this.getUserInfo();
        result = result * prime + ($userInfo == null ? 43 : $userInfo.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "AdmissionRequest(" + "dryRun=" + this.getDryRun() + ", kind=" + this.getKind() + ", name=" + this.getName() + ", namespace=" + this.getNamespace() + ", object=" + this.getObject() + ", oldObject=" + this.getOldObject() + ", operation=" + this.getOperation() + ", options=" + this.getOptions() + ", requestKind=" + this.getRequestKind() + ", requestResource=" + this.getRequestResource() + ", requestSubResource=" + this.getRequestSubResource() + ", resource=" + this.getResource() + ", subResource=" + this.getSubResource() + ", uid=" + this.getUid() + ", userInfo=" + this.getUserInfo() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
