
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private KubernetesList baseKubernetesList;
    private Info info;
    private ObjectMeta objectMeta;
    private ObjectReference objectReference;
    private Quantity quantity;
    private Status status;
    private TypeMeta typeMeta;
    private io.fabric8.kubernetes.api.model.node.v1.RuntimeClass v1RuntimeClass;
    private io.fabric8.kubernetes.api.model.node.v1.RuntimeClassList v1RuntimeClassList;
    private io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClass v1alpha1RuntimeClass;
    private io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassList v1alpha1RuntimeClassList;
    private io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass v1beta1RuntimeClass;
    private io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList v1beta1RuntimeClassList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(KubernetesList baseKubernetesList, Info info, ObjectMeta objectMeta, ObjectReference objectReference, Quantity quantity, Status status, TypeMeta typeMeta, io.fabric8.kubernetes.api.model.node.v1.RuntimeClass v1RuntimeClass, io.fabric8.kubernetes.api.model.node.v1.RuntimeClassList v1RuntimeClassList, io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClass v1alpha1RuntimeClass, io.fabric8.kubernetes.api.model.node.v1alpha1.RuntimeClassList v1alpha1RuntimeClassList, io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClass v1beta1RuntimeClass, io.fabric8.kubernetes.api.model.node.v1beta1.RuntimeClassList v1beta1RuntimeClassList) {
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
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
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
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("ObjectReference")
    public ObjectReference getObjectReference() {
        return objectReference;
    }

    @JsonProperty("ObjectReference")
    public void setObjectReference(ObjectReference objectReference) {
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
