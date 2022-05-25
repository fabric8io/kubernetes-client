
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
import io.fabric8.kubernetes.api.model.ObjectReference;
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
    "APIGroup",
    "APIGroupList",
    "BaseKubernetesList",
    "CertificateSigningRequest",
    "CertificateSigningRequestCondition",
    "CertificateSigningRequestList",
    "CertificateSigningRequestSpec",
    "CertificateSigningRequestStatus",
    "CreateOptions",
    "DeleteOptions",
    "GetOptions",
    "Info",
    "ListOptions",
    "ObjectMeta",
    "Patch",
    "PatchOptions",
    "Quantity",
    "RootPaths",
    "Status",
    "Time",
    "TypeMeta",
    "UpdateOptions",
    "V1Beta1CertificateSigningRequest",
    "V1Beta1CertificateSigningRequestCondition",
    "V1Beta1CertificateSigningRequestList",
    "V1Beta1CertificateSigningRequestSpec",
    "V1Beta1CertificateSigningRequestStatus"
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
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
    @JsonProperty("CertificateSigningRequest")
    private io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest certificateSigningRequest;
    @JsonProperty("CertificateSigningRequestCondition")
    private io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition certificateSigningRequestCondition;
    @JsonProperty("CertificateSigningRequestList")
    private io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList certificateSigningRequestList;
    @JsonProperty("CertificateSigningRequestSpec")
    private io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestSpec certificateSigningRequestSpec;
    @JsonProperty("CertificateSigningRequestStatus")
    private io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatus certificateSigningRequestStatus;
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("PatchOptions")
    private PatchOptions patchOptions;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("RootPaths")
    private RootPaths rootPaths;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("V1Beta1CertificateSigningRequest")
    private io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest v1Beta1CertificateSigningRequest;
    @JsonProperty("V1Beta1CertificateSigningRequestCondition")
    private io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestCondition v1Beta1CertificateSigningRequestCondition;
    @JsonProperty("V1Beta1CertificateSigningRequestList")
    private io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList v1Beta1CertificateSigningRequestList;
    @JsonProperty("V1Beta1CertificateSigningRequestSpec")
    private io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestSpec v1Beta1CertificateSigningRequestSpec;
    @JsonProperty("V1Beta1CertificateSigningRequestStatus")
    private io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestStatus v1Beta1CertificateSigningRequestStatus;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    /**
     * 
     * @param listOptions
     * @param aPIGroupList
     * @param baseKubernetesList
     * @param certificateSigningRequestSpec
     * @param updateOptions
     * @param certificateSigningRequest
     * @param patch
     * @param v1Beta1CertificateSigningRequestCondition
     * @param v1Beta1CertificateSigningRequestSpec
     * @param rootPaths
     * @param certificateSigningRequestStatus
     * @param info
     * @param patchOptions
     * @param deleteOptions
     * @param quantity
     * @param certificateSigningRequestList
     * @param createOptions
     * @param aPIGroup
     * @param typeMeta
     * @param objectMeta
     * @param v1Beta1CertificateSigningRequestList
     * @param v1Beta1CertificateSigningRequestStatus
     * @param getOptions
     * @param time
     * @param certificateSigningRequestCondition
     * @param status
     * @param v1Beta1CertificateSigningRequest
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest certificateSigningRequest, io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition certificateSigningRequestCondition, io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList certificateSigningRequestList, io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestSpec certificateSigningRequestSpec, io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatus certificateSigningRequestStatus, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, ListOptions listOptions, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest v1Beta1CertificateSigningRequest, io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestCondition v1Beta1CertificateSigningRequestCondition, io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList v1Beta1CertificateSigningRequestList, io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestSpec v1Beta1CertificateSigningRequestSpec, io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestStatus v1Beta1CertificateSigningRequestStatus) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.certificateSigningRequest = certificateSigningRequest;
        this.certificateSigningRequestCondition = certificateSigningRequestCondition;
        this.certificateSigningRequestList = certificateSigningRequestList;
        this.certificateSigningRequestSpec = certificateSigningRequestSpec;
        this.certificateSigningRequestStatus = certificateSigningRequestStatus;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.listOptions = listOptions;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.quantity = quantity;
        this.rootPaths = rootPaths;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1Beta1CertificateSigningRequest = v1Beta1CertificateSigningRequest;
        this.v1Beta1CertificateSigningRequestCondition = v1Beta1CertificateSigningRequestCondition;
        this.v1Beta1CertificateSigningRequestList = v1Beta1CertificateSigningRequestList;
        this.v1Beta1CertificateSigningRequestSpec = v1Beta1CertificateSigningRequestSpec;
        this.v1Beta1CertificateSigningRequestStatus = v1Beta1CertificateSigningRequestStatus;
    }

    @JsonProperty("APIGroup")
    public APIGroup getAPIGroup() {
        return aPIGroup;
    }

    @JsonProperty("APIGroup")
    public void setAPIGroup(APIGroup aPIGroup) {
        this.aPIGroup = aPIGroup;
    }

    @JsonProperty("APIGroupList")
    public APIGroupList getAPIGroupList() {
        return aPIGroupList;
    }

    @JsonProperty("APIGroupList")
    public void setAPIGroupList(APIGroupList aPIGroupList) {
        this.aPIGroupList = aPIGroupList;
    }

    @JsonProperty("BaseKubernetesList")
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("CertificateSigningRequest")
    public io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest getCertificateSigningRequest() {
        return certificateSigningRequest;
    }

    @JsonProperty("CertificateSigningRequest")
    public void setCertificateSigningRequest(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequest certificateSigningRequest) {
        this.certificateSigningRequest = certificateSigningRequest;
    }

    @JsonProperty("CertificateSigningRequestCondition")
    public io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition getCertificateSigningRequestCondition() {
        return certificateSigningRequestCondition;
    }

    @JsonProperty("CertificateSigningRequestCondition")
    public void setCertificateSigningRequestCondition(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestCondition certificateSigningRequestCondition) {
        this.certificateSigningRequestCondition = certificateSigningRequestCondition;
    }

    @JsonProperty("CertificateSigningRequestList")
    public io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList getCertificateSigningRequestList() {
        return certificateSigningRequestList;
    }

    @JsonProperty("CertificateSigningRequestList")
    public void setCertificateSigningRequestList(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestList certificateSigningRequestList) {
        this.certificateSigningRequestList = certificateSigningRequestList;
    }

    @JsonProperty("CertificateSigningRequestSpec")
    public io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestSpec getCertificateSigningRequestSpec() {
        return certificateSigningRequestSpec;
    }

    @JsonProperty("CertificateSigningRequestSpec")
    public void setCertificateSigningRequestSpec(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestSpec certificateSigningRequestSpec) {
        this.certificateSigningRequestSpec = certificateSigningRequestSpec;
    }

    @JsonProperty("CertificateSigningRequestStatus")
    public io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatus getCertificateSigningRequestStatus() {
        return certificateSigningRequestStatus;
    }

    @JsonProperty("CertificateSigningRequestStatus")
    public void setCertificateSigningRequestStatus(io.fabric8.kubernetes.api.model.certificates.v1.CertificateSigningRequestStatus certificateSigningRequestStatus) {
        this.certificateSigningRequestStatus = certificateSigningRequestStatus;
    }

    @JsonProperty("CreateOptions")
    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    @JsonProperty("CreateOptions")
    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    @JsonProperty("DeleteOptions")
    public DeleteOptions getDeleteOptions() {
        return deleteOptions;
    }

    @JsonProperty("DeleteOptions")
    public void setDeleteOptions(DeleteOptions deleteOptions) {
        this.deleteOptions = deleteOptions;
    }

    @JsonProperty("GetOptions")
    public GetOptions getGetOptions() {
        return getOptions;
    }

    @JsonProperty("GetOptions")
    public void setGetOptions(GetOptions getOptions) {
        this.getOptions = getOptions;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("PatchOptions")
    public PatchOptions getPatchOptions() {
        return patchOptions;
    }

    @JsonProperty("PatchOptions")
    public void setPatchOptions(PatchOptions patchOptions) {
        this.patchOptions = patchOptions;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("RootPaths")
    public RootPaths getRootPaths() {
        return rootPaths;
    }

    @JsonProperty("RootPaths")
    public void setRootPaths(RootPaths rootPaths) {
        this.rootPaths = rootPaths;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonProperty("UpdateOptions")
    public UpdateOptions getUpdateOptions() {
        return updateOptions;
    }

    @JsonProperty("UpdateOptions")
    public void setUpdateOptions(UpdateOptions updateOptions) {
        this.updateOptions = updateOptions;
    }

    @JsonProperty("V1Beta1CertificateSigningRequest")
    public io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest getV1Beta1CertificateSigningRequest() {
        return v1Beta1CertificateSigningRequest;
    }

    @JsonProperty("V1Beta1CertificateSigningRequest")
    public void setV1Beta1CertificateSigningRequest(io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequest v1Beta1CertificateSigningRequest) {
        this.v1Beta1CertificateSigningRequest = v1Beta1CertificateSigningRequest;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestCondition")
    public io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestCondition getV1Beta1CertificateSigningRequestCondition() {
        return v1Beta1CertificateSigningRequestCondition;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestCondition")
    public void setV1Beta1CertificateSigningRequestCondition(io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestCondition v1Beta1CertificateSigningRequestCondition) {
        this.v1Beta1CertificateSigningRequestCondition = v1Beta1CertificateSigningRequestCondition;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestList")
    public io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList getV1Beta1CertificateSigningRequestList() {
        return v1Beta1CertificateSigningRequestList;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestList")
    public void setV1Beta1CertificateSigningRequestList(io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestList v1Beta1CertificateSigningRequestList) {
        this.v1Beta1CertificateSigningRequestList = v1Beta1CertificateSigningRequestList;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestSpec")
    public io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestSpec getV1Beta1CertificateSigningRequestSpec() {
        return v1Beta1CertificateSigningRequestSpec;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestSpec")
    public void setV1Beta1CertificateSigningRequestSpec(io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestSpec v1Beta1CertificateSigningRequestSpec) {
        this.v1Beta1CertificateSigningRequestSpec = v1Beta1CertificateSigningRequestSpec;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestStatus")
    public io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestStatus getV1Beta1CertificateSigningRequestStatus() {
        return v1Beta1CertificateSigningRequestStatus;
    }

    @JsonProperty("V1Beta1CertificateSigningRequestStatus")
    public void setV1Beta1CertificateSigningRequestStatus(io.fabric8.kubernetes.api.model.certificates.v1beta1.CertificateSigningRequestStatus v1Beta1CertificateSigningRequestStatus) {
        this.v1Beta1CertificateSigningRequestStatus = v1Beta1CertificateSigningRequestStatus;
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
