
package io.fabric8.kubernetes.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.version.Info;
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
    "BaseKubernetesList",
    "Info",
    "ObjectMeta",
    "ObjectReference",
    "Quantity",
    "Status",
    "TypeMeta",
    "V1RuntimeClass",
    "V1RuntimeClassList",
    "V1alpha1RuntimeClass",
    "V1alpha1RuntimeClassList",
    "V1beta1RuntimeClass",
    "V1beta1RuntimeClassList"
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
public class ValidationSchema {

    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("ObjectReference")
    private io.fabric8.kubernetes.api.model.ObjectReference objectReference;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("V1RuntimeClass")
    private io.fabric8.kubernetes.api.model.node.v1.RuntimeClass v1RuntimeClass;
    @JsonProperty("V1RuntimeClassList")
    private io.fabric8.kubernetes.api.model.node.v1.RuntimeClassList v1RuntimeClassList;
    @JsonProperty("V1alpha1RuntimeClass")
    private io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClass v1alpha1RuntimeClass;
    @JsonProperty("V1alpha1RuntimeClassList")
    private io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassList v1alpha1RuntimeClassList;
    @JsonProperty("V1beta1RuntimeClass")
    private io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass v1beta1RuntimeClass;
    @JsonProperty("V1beta1RuntimeClassList")
    private io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList v1beta1RuntimeClassList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    /**
     * 
     * @param quantity
     * @param v1RuntimeClassList
     * @param baseKubernetesList
     * @param v1beta1RuntimeClass
     * @param objectReference
     * @param v1RuntimeClass
     * @param typeMeta
     * @param objectMeta
     * @param v1alpha1RuntimeClass
     * @param v1alpha1RuntimeClassList
     * @param v1beta1RuntimeClassList
     * @param info
     * @param status
     */
    public ValidationSchema(BaseKubernetesList baseKubernetesList, Info info, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, io.fabric8.kubernetes.api.model.ObjectReference objectReference, Quantity quantity, Status status, TypeMeta typeMeta, io.fabric8.kubernetes.api.model.node.v1.RuntimeClass v1RuntimeClass, io.fabric8.kubernetes.api.model.node.v1.RuntimeClassList v1RuntimeClassList, io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClass v1alpha1RuntimeClass, io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassList v1alpha1RuntimeClassList, io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass v1beta1RuntimeClass, io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList v1beta1RuntimeClassList) {
        super();
        this.baseKubernetesList = baseKubernetesList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.objectReference = objectReference;
        this.quantity = quantity;
        this.status = status;
        this.typeMeta = typeMeta;
        this.v1RuntimeClass = v1RuntimeClass;
        this.v1RuntimeClassList = v1RuntimeClassList;
        this.v1alpha1RuntimeClass = v1alpha1RuntimeClass;
        this.v1alpha1RuntimeClassList = v1alpha1RuntimeClassList;
        this.v1beta1RuntimeClass = v1beta1RuntimeClass;
        this.v1beta1RuntimeClassList = v1beta1RuntimeClassList;
    }

    @JsonProperty("BaseKubernetesList")
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("ObjectReference")
    public io.fabric8.kubernetes.api.model.ObjectReference getObjectReference() {
        return objectReference;
    }

    @JsonProperty("ObjectReference")
    public void setObjectReference(io.fabric8.kubernetes.api.model.ObjectReference objectReference) {
        this.objectReference = objectReference;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonProperty("V1RuntimeClass")
    public io.fabric8.kubernetes.api.model.node.v1.RuntimeClass getV1RuntimeClass() {
        return v1RuntimeClass;
    }

    @JsonProperty("V1RuntimeClass")
    public void setV1RuntimeClass(io.fabric8.kubernetes.api.model.node.v1.RuntimeClass v1RuntimeClass) {
        this.v1RuntimeClass = v1RuntimeClass;
    }

    @JsonProperty("V1RuntimeClassList")
    public io.fabric8.kubernetes.api.model.node.v1.RuntimeClassList getV1RuntimeClassList() {
        return v1RuntimeClassList;
    }

    @JsonProperty("V1RuntimeClassList")
    public void setV1RuntimeClassList(io.fabric8.kubernetes.api.model.node.v1.RuntimeClassList v1RuntimeClassList) {
        this.v1RuntimeClassList = v1RuntimeClassList;
    }

    @JsonProperty("V1alpha1RuntimeClass")
    public io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClass getV1alpha1RuntimeClass() {
        return v1alpha1RuntimeClass;
    }

    @JsonProperty("V1alpha1RuntimeClass")
    public void setV1alpha1RuntimeClass(io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClass v1alpha1RuntimeClass) {
        this.v1alpha1RuntimeClass = v1alpha1RuntimeClass;
    }

    @JsonProperty("V1alpha1RuntimeClassList")
    public io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassList getV1alpha1RuntimeClassList() {
        return v1alpha1RuntimeClassList;
    }

    @JsonProperty("V1alpha1RuntimeClassList")
    public void setV1alpha1RuntimeClassList(io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassList v1alpha1RuntimeClassList) {
        this.v1alpha1RuntimeClassList = v1alpha1RuntimeClassList;
    }

    @JsonProperty("V1beta1RuntimeClass")
    public io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass getV1beta1RuntimeClass() {
        return v1beta1RuntimeClass;
    }

    @JsonProperty("V1beta1RuntimeClass")
    public void setV1beta1RuntimeClass(io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass v1beta1RuntimeClass) {
        this.v1beta1RuntimeClass = v1beta1RuntimeClass;
    }

    @JsonProperty("V1beta1RuntimeClassList")
    public io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList getV1beta1RuntimeClassList() {
        return v1beta1RuntimeClassList;
    }

    @JsonProperty("V1beta1RuntimeClassList")
    public void setV1beta1RuntimeClassList(io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList v1beta1RuntimeClassList) {
        this.v1beta1RuntimeClassList = v1beta1RuntimeClassList;
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
