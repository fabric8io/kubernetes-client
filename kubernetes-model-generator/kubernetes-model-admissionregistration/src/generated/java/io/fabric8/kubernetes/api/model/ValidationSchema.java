
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
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
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
    "CreateOptions",
    "DeleteOptions",
    "GetOptions",
    "Info",
    "K8sLocalSubjectAccessReview",
    "K8sSubjectAccessReview",
    "ListOptions",
    "MutatingWebhookConfiguration",
    "MutatingWebhookConfigurationList",
    "ObjectMeta",
    "Patch",
    "PatchOptions",
    "Quantity",
    "RootPaths",
    "Rule",
    "RuleWithOperations",
    "SelfSubjectAccessReview",
    "SelfSubjectRulesReview",
    "ServiceReference",
    "Status",
    "Time",
    "TokenReview",
    "TypeMeta",
    "UpdateOptions",
    "V1AdmissionRequest",
    "V1AdmissionResponse",
    "V1AdmissionReview",
    "V1Beta1AdmissionRequest",
    "V1Beta1AdmissionResponse",
    "V1Beta1AdmissionReview",
    "V1Beta1Operation",
    "V1Beta1PatchType",
    "V1MutatingWebhookConfiguration",
    "V1MutatingWebhookConfigurationList",
    "V1Operation",
    "V1PatchType",
    "V1Rule",
    "V1RuleWithOperations",
    "V1ServiceReference",
    "V1ValidatingWebhookConfiguration",
    "V1ValidatingWebhookConfigurationList",
    "V1beta1K8sLocalSubjectAccessReview",
    "V1beta1K8sSubjectAccessReview",
    "V1beta1SelfSubjectAccessReview",
    "V1beta1SelfSubjectRulesReview",
    "ValidatingWebhookConfiguration",
    "ValidatingWebhookConfigurationList"
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
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("K8sLocalSubjectAccessReview")
    private io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview k8sLocalSubjectAccessReview;
    @JsonProperty("K8sSubjectAccessReview")
    private io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview k8sSubjectAccessReview;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("MutatingWebhookConfiguration")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration mutatingWebhookConfiguration;
    @JsonProperty("MutatingWebhookConfigurationList")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList mutatingWebhookConfigurationList;
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
    @JsonProperty("Rule")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.Rule rule;
    @JsonProperty("RuleWithOperations")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.RuleWithOperations ruleWithOperations;
    @JsonProperty("SelfSubjectAccessReview")
    private io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview selfSubjectAccessReview;
    @JsonProperty("SelfSubjectRulesReview")
    private io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview selfSubjectRulesReview;
    @JsonProperty("ServiceReference")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ServiceReference serviceReference;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TokenReview")
    private TokenReview tokenReview;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("V1AdmissionRequest")
    private io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest v1AdmissionRequest;
    @JsonProperty("V1AdmissionResponse")
    private io.fabric8.kubernetes.api.model.admission.v1.AdmissionResponse v1AdmissionResponse;
    @JsonProperty("V1AdmissionReview")
    private io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview v1AdmissionReview;
    @JsonProperty("V1Beta1AdmissionRequest")
    private io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionRequest v1Beta1AdmissionRequest;
    @JsonProperty("V1Beta1AdmissionResponse")
    private io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionResponse v1Beta1AdmissionResponse;
    @JsonProperty("V1Beta1AdmissionReview")
    private io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionReview v1Beta1AdmissionReview;
    @JsonProperty("V1Beta1Operation")
    private java.lang.String v1Beta1Operation;
    @JsonProperty("V1Beta1PatchType")
    private java.lang.String v1Beta1PatchType;
    @JsonProperty("V1MutatingWebhookConfiguration")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration v1MutatingWebhookConfiguration;
    @JsonProperty("V1MutatingWebhookConfigurationList")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationList v1MutatingWebhookConfigurationList;
    @JsonProperty("V1Operation")
    private java.lang.String v1Operation;
    @JsonProperty("V1PatchType")
    private java.lang.String v1PatchType;
    @JsonProperty("V1Rule")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.Rule v1Rule;
    @JsonProperty("V1RuleWithOperations")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations v1RuleWithOperations;
    @JsonProperty("V1ServiceReference")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.ServiceReference v1ServiceReference;
    @JsonProperty("V1ValidatingWebhookConfiguration")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration v1ValidatingWebhookConfiguration;
    @JsonProperty("V1ValidatingWebhookConfigurationList")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationList v1ValidatingWebhookConfigurationList;
    @JsonProperty("V1beta1K8sLocalSubjectAccessReview")
    private io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview v1beta1K8sLocalSubjectAccessReview;
    @JsonProperty("V1beta1K8sSubjectAccessReview")
    private io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview v1beta1K8sSubjectAccessReview;
    @JsonProperty("V1beta1SelfSubjectAccessReview")
    private io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview v1beta1SelfSubjectAccessReview;
    @JsonProperty("V1beta1SelfSubjectRulesReview")
    private io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview v1beta1SelfSubjectRulesReview;
    @JsonProperty("ValidatingWebhookConfiguration")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration validatingWebhookConfiguration;
    @JsonProperty("ValidatingWebhookConfigurationList")
    private io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList validatingWebhookConfigurationList;
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
     * @param v1AdmissionReview
     * @param aPIGroupList
     * @param validatingWebhookConfigurationList
     * @param v1RuleWithOperations
     * @param k8sLocalSubjectAccessReview
     * @param patch
     * @param v1AdmissionResponse
     * @param v1Beta1AdmissionReview
     * @param v1Beta1PatchType
     * @param v1beta1K8sSubjectAccessReview
     * @param info
     * @param deleteOptions
     * @param v1Rule
     * @param v1beta1SelfSubjectAccessReview
     * @param ruleWithOperations
     * @param v1Beta1AdmissionResponse
     * @param v1Beta1AdmissionRequest
     * @param v1AdmissionRequest
     * @param v1Operation
     * @param v1ValidatingWebhookConfiguration
     * @param validatingWebhookConfiguration
     * @param k8sSubjectAccessReview
     * @param v1PatchType
     * @param tokenReview
     * @param getOptions
     * @param mutatingWebhookConfiguration
     * @param status
     * @param serviceReference
     * @param selfSubjectRulesReview
     * @param baseKubernetesList
     * @param rule
     * @param updateOptions
     * @param v1beta1K8sLocalSubjectAccessReview
     * @param mutatingWebhookConfigurationList
     * @param rootPaths
     * @param v1MutatingWebhookConfigurationList
     * @param v1Beta1Operation
     * @param v1MutatingWebhookConfiguration
     * @param patchOptions
     * @param quantity
     * @param v1ServiceReference
     * @param v1ValidatingWebhookConfigurationList
     * @param createOptions
     * @param selfSubjectAccessReview
     * @param aPIGroup
     * @param v1beta1SelfSubjectRulesReview
     * @param typeMeta
     * @param objectMeta
     * @param time
     */
    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, BaseKubernetesList baseKubernetesList, CreateOptions createOptions, DeleteOptions deleteOptions, GetOptions getOptions, Info info, io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview k8sLocalSubjectAccessReview, io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview k8sSubjectAccessReview, ListOptions listOptions, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration mutatingWebhookConfiguration, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList mutatingWebhookConfigurationList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, Quantity quantity, RootPaths rootPaths, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.Rule rule, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.RuleWithOperations ruleWithOperations, io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview selfSubjectAccessReview, io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview selfSubjectRulesReview, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ServiceReference serviceReference, Status status, String time, TokenReview tokenReview, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest v1AdmissionRequest, io.fabric8.kubernetes.api.model.admission.v1.AdmissionResponse v1AdmissionResponse, io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview v1AdmissionReview, io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionRequest v1Beta1AdmissionRequest, io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionResponse v1Beta1AdmissionResponse, io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionReview v1Beta1AdmissionReview, java.lang.String v1Beta1Operation, java.lang.String v1Beta1PatchType, io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration v1MutatingWebhookConfiguration, io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationList v1MutatingWebhookConfigurationList, java.lang.String v1Operation, java.lang.String v1PatchType, io.fabric8.kubernetes.api.model.admissionregistration.v1.Rule v1Rule, io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations v1RuleWithOperations, io.fabric8.kubernetes.api.model.admissionregistration.v1.ServiceReference v1ServiceReference, io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration v1ValidatingWebhookConfiguration, io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationList v1ValidatingWebhookConfigurationList, io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview v1beta1K8sLocalSubjectAccessReview, io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview v1beta1K8sSubjectAccessReview, io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview v1beta1SelfSubjectAccessReview, io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview v1beta1SelfSubjectRulesReview, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration validatingWebhookConfiguration, io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList validatingWebhookConfigurationList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.k8sLocalSubjectAccessReview = k8sLocalSubjectAccessReview;
        this.k8sSubjectAccessReview = k8sSubjectAccessReview;
        this.listOptions = listOptions;
        this.mutatingWebhookConfiguration = mutatingWebhookConfiguration;
        this.mutatingWebhookConfigurationList = mutatingWebhookConfigurationList;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.quantity = quantity;
        this.rootPaths = rootPaths;
        this.rule = rule;
        this.ruleWithOperations = ruleWithOperations;
        this.selfSubjectAccessReview = selfSubjectAccessReview;
        this.selfSubjectRulesReview = selfSubjectRulesReview;
        this.serviceReference = serviceReference;
        this.status = status;
        this.time = time;
        this.tokenReview = tokenReview;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1AdmissionRequest = v1AdmissionRequest;
        this.v1AdmissionResponse = v1AdmissionResponse;
        this.v1AdmissionReview = v1AdmissionReview;
        this.v1Beta1AdmissionRequest = v1Beta1AdmissionRequest;
        this.v1Beta1AdmissionResponse = v1Beta1AdmissionResponse;
        this.v1Beta1AdmissionReview = v1Beta1AdmissionReview;
        this.v1Beta1Operation = v1Beta1Operation;
        this.v1Beta1PatchType = v1Beta1PatchType;
        this.v1MutatingWebhookConfiguration = v1MutatingWebhookConfiguration;
        this.v1MutatingWebhookConfigurationList = v1MutatingWebhookConfigurationList;
        this.v1Operation = v1Operation;
        this.v1PatchType = v1PatchType;
        this.v1Rule = v1Rule;
        this.v1RuleWithOperations = v1RuleWithOperations;
        this.v1ServiceReference = v1ServiceReference;
        this.v1ValidatingWebhookConfiguration = v1ValidatingWebhookConfiguration;
        this.v1ValidatingWebhookConfigurationList = v1ValidatingWebhookConfigurationList;
        this.v1beta1K8sLocalSubjectAccessReview = v1beta1K8sLocalSubjectAccessReview;
        this.v1beta1K8sSubjectAccessReview = v1beta1K8sSubjectAccessReview;
        this.v1beta1SelfSubjectAccessReview = v1beta1SelfSubjectAccessReview;
        this.v1beta1SelfSubjectRulesReview = v1beta1SelfSubjectRulesReview;
        this.validatingWebhookConfiguration = validatingWebhookConfiguration;
        this.validatingWebhookConfigurationList = validatingWebhookConfigurationList;
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

    @JsonProperty("K8sLocalSubjectAccessReview")
    public io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview getK8sLocalSubjectAccessReview() {
        return k8sLocalSubjectAccessReview;
    }

    @JsonProperty("K8sLocalSubjectAccessReview")
    public void setK8sLocalSubjectAccessReview(io.fabric8.kubernetes.api.model.authorization.v1.LocalSubjectAccessReview k8sLocalSubjectAccessReview) {
        this.k8sLocalSubjectAccessReview = k8sLocalSubjectAccessReview;
    }

    @JsonProperty("K8sSubjectAccessReview")
    public io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview getK8sSubjectAccessReview() {
        return k8sSubjectAccessReview;
    }

    @JsonProperty("K8sSubjectAccessReview")
    public void setK8sSubjectAccessReview(io.fabric8.kubernetes.api.model.authorization.v1.SubjectAccessReview k8sSubjectAccessReview) {
        this.k8sSubjectAccessReview = k8sSubjectAccessReview;
    }

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
    }

    @JsonProperty("MutatingWebhookConfiguration")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration getMutatingWebhookConfiguration() {
        return mutatingWebhookConfiguration;
    }

    @JsonProperty("MutatingWebhookConfiguration")
    public void setMutatingWebhookConfiguration(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfiguration mutatingWebhookConfiguration) {
        this.mutatingWebhookConfiguration = mutatingWebhookConfiguration;
    }

    @JsonProperty("MutatingWebhookConfigurationList")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList getMutatingWebhookConfigurationList() {
        return mutatingWebhookConfigurationList;
    }

    @JsonProperty("MutatingWebhookConfigurationList")
    public void setMutatingWebhookConfigurationList(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.MutatingWebhookConfigurationList mutatingWebhookConfigurationList) {
        this.mutatingWebhookConfigurationList = mutatingWebhookConfigurationList;
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

    @JsonProperty("Rule")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.Rule getRule() {
        return rule;
    }

    @JsonProperty("Rule")
    public void setRule(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.Rule rule) {
        this.rule = rule;
    }

    @JsonProperty("RuleWithOperations")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.RuleWithOperations getRuleWithOperations() {
        return ruleWithOperations;
    }

    @JsonProperty("RuleWithOperations")
    public void setRuleWithOperations(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.RuleWithOperations ruleWithOperations) {
        this.ruleWithOperations = ruleWithOperations;
    }

    @JsonProperty("SelfSubjectAccessReview")
    public io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview getSelfSubjectAccessReview() {
        return selfSubjectAccessReview;
    }

    @JsonProperty("SelfSubjectAccessReview")
    public void setSelfSubjectAccessReview(io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectAccessReview selfSubjectAccessReview) {
        this.selfSubjectAccessReview = selfSubjectAccessReview;
    }

    @JsonProperty("SelfSubjectRulesReview")
    public io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview getSelfSubjectRulesReview() {
        return selfSubjectRulesReview;
    }

    @JsonProperty("SelfSubjectRulesReview")
    public void setSelfSubjectRulesReview(io.fabric8.kubernetes.api.model.authorization.v1.SelfSubjectRulesReview selfSubjectRulesReview) {
        this.selfSubjectRulesReview = selfSubjectRulesReview;
    }

    @JsonProperty("ServiceReference")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ServiceReference getServiceReference() {
        return serviceReference;
    }

    @JsonProperty("ServiceReference")
    public void setServiceReference(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ServiceReference serviceReference) {
        this.serviceReference = serviceReference;
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

    @JsonProperty("TokenReview")
    public TokenReview getTokenReview() {
        return tokenReview;
    }

    @JsonProperty("TokenReview")
    public void setTokenReview(TokenReview tokenReview) {
        this.tokenReview = tokenReview;
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

    @JsonProperty("V1AdmissionRequest")
    public io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest getV1AdmissionRequest() {
        return v1AdmissionRequest;
    }

    @JsonProperty("V1AdmissionRequest")
    public void setV1AdmissionRequest(io.fabric8.kubernetes.api.model.admission.v1.AdmissionRequest v1AdmissionRequest) {
        this.v1AdmissionRequest = v1AdmissionRequest;
    }

    @JsonProperty("V1AdmissionResponse")
    public io.fabric8.kubernetes.api.model.admission.v1.AdmissionResponse getV1AdmissionResponse() {
        return v1AdmissionResponse;
    }

    @JsonProperty("V1AdmissionResponse")
    public void setV1AdmissionResponse(io.fabric8.kubernetes.api.model.admission.v1.AdmissionResponse v1AdmissionResponse) {
        this.v1AdmissionResponse = v1AdmissionResponse;
    }

    @JsonProperty("V1AdmissionReview")
    public io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview getV1AdmissionReview() {
        return v1AdmissionReview;
    }

    @JsonProperty("V1AdmissionReview")
    public void setV1AdmissionReview(io.fabric8.kubernetes.api.model.admission.v1.AdmissionReview v1AdmissionReview) {
        this.v1AdmissionReview = v1AdmissionReview;
    }

    @JsonProperty("V1Beta1AdmissionRequest")
    public io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionRequest getV1Beta1AdmissionRequest() {
        return v1Beta1AdmissionRequest;
    }

    @JsonProperty("V1Beta1AdmissionRequest")
    public void setV1Beta1AdmissionRequest(io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionRequest v1Beta1AdmissionRequest) {
        this.v1Beta1AdmissionRequest = v1Beta1AdmissionRequest;
    }

    @JsonProperty("V1Beta1AdmissionResponse")
    public io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionResponse getV1Beta1AdmissionResponse() {
        return v1Beta1AdmissionResponse;
    }

    @JsonProperty("V1Beta1AdmissionResponse")
    public void setV1Beta1AdmissionResponse(io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionResponse v1Beta1AdmissionResponse) {
        this.v1Beta1AdmissionResponse = v1Beta1AdmissionResponse;
    }

    @JsonProperty("V1Beta1AdmissionReview")
    public io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionReview getV1Beta1AdmissionReview() {
        return v1Beta1AdmissionReview;
    }

    @JsonProperty("V1Beta1AdmissionReview")
    public void setV1Beta1AdmissionReview(io.fabric8.kubernetes.api.model.admission.v1beta1.AdmissionReview v1Beta1AdmissionReview) {
        this.v1Beta1AdmissionReview = v1Beta1AdmissionReview;
    }

    @JsonProperty("V1Beta1Operation")
    public java.lang.String getV1Beta1Operation() {
        return v1Beta1Operation;
    }

    @JsonProperty("V1Beta1Operation")
    public void setV1Beta1Operation(java.lang.String v1Beta1Operation) {
        this.v1Beta1Operation = v1Beta1Operation;
    }

    @JsonProperty("V1Beta1PatchType")
    public java.lang.String getV1Beta1PatchType() {
        return v1Beta1PatchType;
    }

    @JsonProperty("V1Beta1PatchType")
    public void setV1Beta1PatchType(java.lang.String v1Beta1PatchType) {
        this.v1Beta1PatchType = v1Beta1PatchType;
    }

    @JsonProperty("V1MutatingWebhookConfiguration")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration getV1MutatingWebhookConfiguration() {
        return v1MutatingWebhookConfiguration;
    }

    @JsonProperty("V1MutatingWebhookConfiguration")
    public void setV1MutatingWebhookConfiguration(io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfiguration v1MutatingWebhookConfiguration) {
        this.v1MutatingWebhookConfiguration = v1MutatingWebhookConfiguration;
    }

    @JsonProperty("V1MutatingWebhookConfigurationList")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationList getV1MutatingWebhookConfigurationList() {
        return v1MutatingWebhookConfigurationList;
    }

    @JsonProperty("V1MutatingWebhookConfigurationList")
    public void setV1MutatingWebhookConfigurationList(io.fabric8.kubernetes.api.model.admissionregistration.v1.MutatingWebhookConfigurationList v1MutatingWebhookConfigurationList) {
        this.v1MutatingWebhookConfigurationList = v1MutatingWebhookConfigurationList;
    }

    @JsonProperty("V1Operation")
    public java.lang.String getV1Operation() {
        return v1Operation;
    }

    @JsonProperty("V1Operation")
    public void setV1Operation(java.lang.String v1Operation) {
        this.v1Operation = v1Operation;
    }

    @JsonProperty("V1PatchType")
    public java.lang.String getV1PatchType() {
        return v1PatchType;
    }

    @JsonProperty("V1PatchType")
    public void setV1PatchType(java.lang.String v1PatchType) {
        this.v1PatchType = v1PatchType;
    }

    @JsonProperty("V1Rule")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.Rule getV1Rule() {
        return v1Rule;
    }

    @JsonProperty("V1Rule")
    public void setV1Rule(io.fabric8.kubernetes.api.model.admissionregistration.v1.Rule v1Rule) {
        this.v1Rule = v1Rule;
    }

    @JsonProperty("V1RuleWithOperations")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations getV1RuleWithOperations() {
        return v1RuleWithOperations;
    }

    @JsonProperty("V1RuleWithOperations")
    public void setV1RuleWithOperations(io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations v1RuleWithOperations) {
        this.v1RuleWithOperations = v1RuleWithOperations;
    }

    @JsonProperty("V1ServiceReference")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.ServiceReference getV1ServiceReference() {
        return v1ServiceReference;
    }

    @JsonProperty("V1ServiceReference")
    public void setV1ServiceReference(io.fabric8.kubernetes.api.model.admissionregistration.v1.ServiceReference v1ServiceReference) {
        this.v1ServiceReference = v1ServiceReference;
    }

    @JsonProperty("V1ValidatingWebhookConfiguration")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration getV1ValidatingWebhookConfiguration() {
        return v1ValidatingWebhookConfiguration;
    }

    @JsonProperty("V1ValidatingWebhookConfiguration")
    public void setV1ValidatingWebhookConfiguration(io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfiguration v1ValidatingWebhookConfiguration) {
        this.v1ValidatingWebhookConfiguration = v1ValidatingWebhookConfiguration;
    }

    @JsonProperty("V1ValidatingWebhookConfigurationList")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationList getV1ValidatingWebhookConfigurationList() {
        return v1ValidatingWebhookConfigurationList;
    }

    @JsonProperty("V1ValidatingWebhookConfigurationList")
    public void setV1ValidatingWebhookConfigurationList(io.fabric8.kubernetes.api.model.admissionregistration.v1.ValidatingWebhookConfigurationList v1ValidatingWebhookConfigurationList) {
        this.v1ValidatingWebhookConfigurationList = v1ValidatingWebhookConfigurationList;
    }

    @JsonProperty("V1beta1K8sLocalSubjectAccessReview")
    public io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview getV1beta1K8sLocalSubjectAccessReview() {
        return v1beta1K8sLocalSubjectAccessReview;
    }

    @JsonProperty("V1beta1K8sLocalSubjectAccessReview")
    public void setV1beta1K8sLocalSubjectAccessReview(io.fabric8.kubernetes.api.model.authorization.v1beta1.LocalSubjectAccessReview v1beta1K8sLocalSubjectAccessReview) {
        this.v1beta1K8sLocalSubjectAccessReview = v1beta1K8sLocalSubjectAccessReview;
    }

    @JsonProperty("V1beta1K8sSubjectAccessReview")
    public io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview getV1beta1K8sSubjectAccessReview() {
        return v1beta1K8sSubjectAccessReview;
    }

    @JsonProperty("V1beta1K8sSubjectAccessReview")
    public void setV1beta1K8sSubjectAccessReview(io.fabric8.kubernetes.api.model.authorization.v1beta1.SubjectAccessReview v1beta1K8sSubjectAccessReview) {
        this.v1beta1K8sSubjectAccessReview = v1beta1K8sSubjectAccessReview;
    }

    @JsonProperty("V1beta1SelfSubjectAccessReview")
    public io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview getV1beta1SelfSubjectAccessReview() {
        return v1beta1SelfSubjectAccessReview;
    }

    @JsonProperty("V1beta1SelfSubjectAccessReview")
    public void setV1beta1SelfSubjectAccessReview(io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectAccessReview v1beta1SelfSubjectAccessReview) {
        this.v1beta1SelfSubjectAccessReview = v1beta1SelfSubjectAccessReview;
    }

    @JsonProperty("V1beta1SelfSubjectRulesReview")
    public io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview getV1beta1SelfSubjectRulesReview() {
        return v1beta1SelfSubjectRulesReview;
    }

    @JsonProperty("V1beta1SelfSubjectRulesReview")
    public void setV1beta1SelfSubjectRulesReview(io.fabric8.kubernetes.api.model.authorization.v1beta1.SelfSubjectRulesReview v1beta1SelfSubjectRulesReview) {
        this.v1beta1SelfSubjectRulesReview = v1beta1SelfSubjectRulesReview;
    }

    @JsonProperty("ValidatingWebhookConfiguration")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration getValidatingWebhookConfiguration() {
        return validatingWebhookConfiguration;
    }

    @JsonProperty("ValidatingWebhookConfiguration")
    public void setValidatingWebhookConfiguration(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfiguration validatingWebhookConfiguration) {
        this.validatingWebhookConfiguration = validatingWebhookConfiguration;
    }

    @JsonProperty("ValidatingWebhookConfigurationList")
    public io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList getValidatingWebhookConfigurationList() {
        return validatingWebhookConfigurationList;
    }

    @JsonProperty("ValidatingWebhookConfigurationList")
    public void setValidatingWebhookConfigurationList(io.fabric8.kubernetes.api.model.admissionregistration.v1beta1.ValidatingWebhookConfigurationList validatingWebhookConfigurationList) {
        this.validatingWebhookConfigurationList = validatingWebhookConfigurationList;
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
