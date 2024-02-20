
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.admissionregistration.v1.RuleWithOperations;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.rbac.PolicyRule;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifest;
import io.fabric8.openshift.api.model.operatorhub.lifecyclemanager.v1.PackageManifestList;
import io.fabric8.openshift.api.model.operatorhub.v1.OLMConfig;
import io.fabric8.openshift.api.model.operatorhub.v1.OLMConfigList;
import io.fabric8.openshift.api.model.operatorhub.v1.Operator;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorCondition;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorConditionList;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorGroup;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorGroupList;
import io.fabric8.openshift.api.model.operatorhub.v1.OperatorList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSource;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.CatalogSourceList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersion;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.ClusterServiceVersionList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallPlan;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.InstallPlanList;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.Subscription;
import io.fabric8.openshift.api.model.operatorhub.v1alpha1.SubscriptionList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private CatalogSource catalogSource;
    private CatalogSourceList catalogSourceList;
    private ClusterServiceVersion clusterServiceVersion;
    private ClusterServiceVersionList clusterServiceVersionList;
    private Deployment deployment;
    private Info info;
    private InstallPlan installPlan;
    private InstallPlanList installPlanList;
    private OLMConfig oLMConfig;
    private OLMConfigList oLMConfigList;
    private ObjectMeta objectMeta;
    private Operator operator;
    private OperatorCondition operatorCondition;
    private OperatorConditionList operatorConditionList;
    private OperatorGroup operatorGroup;
    private OperatorGroupList operatorGroupList;
    private OperatorList operatorList;
    private PackageManifest packageManifest;
    private PackageManifestList packageManifestList;
    private Patch patch;
    private PolicyRule policyRule;
    private Quantity quantity;
    private RuleWithOperations ruleWithOperations;
    private Status status;
    private Subscription subscription;
    private SubscriptionList subscriptionList;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, CatalogSource catalogSource, CatalogSourceList catalogSourceList, ClusterServiceVersion clusterServiceVersion, ClusterServiceVersionList clusterServiceVersionList, Deployment deployment, Info info, InstallPlan installPlan, InstallPlanList installPlanList, OLMConfig oLMConfig, OLMConfigList oLMConfigList, ObjectMeta objectMeta, Operator operator, OperatorCondition operatorCondition, OperatorConditionList operatorConditionList, OperatorGroup operatorGroup, OperatorGroupList operatorGroupList, OperatorList operatorList, PackageManifest packageManifest, PackageManifestList packageManifestList, Patch patch, PolicyRule policyRule, Quantity quantity, RuleWithOperations ruleWithOperations, Status status, Subscription subscription, SubscriptionList subscriptionList, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.catalogSource = catalogSource;
        this.catalogSourceList = catalogSourceList;
        this.clusterServiceVersion = clusterServiceVersion;
        this.clusterServiceVersionList = clusterServiceVersionList;
        this.deployment = deployment;
        this.info = info;
        this.installPlan = installPlan;
        this.installPlanList = installPlanList;
        this.oLMConfig = oLMConfig;
        this.oLMConfigList = oLMConfigList;
        this.objectMeta = objectMeta;
        this.operator = operator;
        this.operatorCondition = operatorCondition;
        this.operatorConditionList = operatorConditionList;
        this.operatorGroup = operatorGroup;
        this.operatorGroupList = operatorGroupList;
        this.operatorList = operatorList;
        this.packageManifest = packageManifest;
        this.packageManifestList = packageManifestList;
        this.patch = patch;
        this.policyRule = policyRule;
        this.quantity = quantity;
        this.ruleWithOperations = ruleWithOperations;
        this.status = status;
        this.subscription = subscription;
        this.subscriptionList = subscriptionList;
        this.time = time;
        this.typeMeta = typeMeta;
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
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("CatalogSource")
    public CatalogSource getCatalogSource() {
        return catalogSource;
    }

    @JsonProperty("CatalogSource")
    public void setCatalogSource(CatalogSource catalogSource) {
        this.catalogSource = catalogSource;
    }

    @JsonProperty("CatalogSourceList")
    public CatalogSourceList getCatalogSourceList() {
        return catalogSourceList;
    }

    @JsonProperty("CatalogSourceList")
    public void setCatalogSourceList(CatalogSourceList catalogSourceList) {
        this.catalogSourceList = catalogSourceList;
    }

    @JsonProperty("ClusterServiceVersion")
    public ClusterServiceVersion getClusterServiceVersion() {
        return clusterServiceVersion;
    }

    @JsonProperty("ClusterServiceVersion")
    public void setClusterServiceVersion(ClusterServiceVersion clusterServiceVersion) {
        this.clusterServiceVersion = clusterServiceVersion;
    }

    @JsonProperty("ClusterServiceVersionList")
    public ClusterServiceVersionList getClusterServiceVersionList() {
        return clusterServiceVersionList;
    }

    @JsonProperty("ClusterServiceVersionList")
    public void setClusterServiceVersionList(ClusterServiceVersionList clusterServiceVersionList) {
        this.clusterServiceVersionList = clusterServiceVersionList;
    }

    @JsonProperty("Deployment")
    public Deployment getDeployment() {
        return deployment;
    }

    @JsonProperty("Deployment")
    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("InstallPlan")
    public InstallPlan getInstallPlan() {
        return installPlan;
    }

    @JsonProperty("InstallPlan")
    public void setInstallPlan(InstallPlan installPlan) {
        this.installPlan = installPlan;
    }

    @JsonProperty("InstallPlanList")
    public InstallPlanList getInstallPlanList() {
        return installPlanList;
    }

    @JsonProperty("InstallPlanList")
    public void setInstallPlanList(InstallPlanList installPlanList) {
        this.installPlanList = installPlanList;
    }

    @JsonProperty("OLMConfig")
    public OLMConfig getOLMConfig() {
        return oLMConfig;
    }

    @JsonProperty("OLMConfig")
    public void setOLMConfig(OLMConfig oLMConfig) {
        this.oLMConfig = oLMConfig;
    }

    @JsonProperty("OLMConfigList")
    public OLMConfigList getOLMConfigList() {
        return oLMConfigList;
    }

    @JsonProperty("OLMConfigList")
    public void setOLMConfigList(OLMConfigList oLMConfigList) {
        this.oLMConfigList = oLMConfigList;
    }

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Operator")
    public Operator getOperator() {
        return operator;
    }

    @JsonProperty("Operator")
    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    @JsonProperty("OperatorCondition")
    public OperatorCondition getOperatorCondition() {
        return operatorCondition;
    }

    @JsonProperty("OperatorCondition")
    public void setOperatorCondition(OperatorCondition operatorCondition) {
        this.operatorCondition = operatorCondition;
    }

    @JsonProperty("OperatorConditionList")
    public OperatorConditionList getOperatorConditionList() {
        return operatorConditionList;
    }

    @JsonProperty("OperatorConditionList")
    public void setOperatorConditionList(OperatorConditionList operatorConditionList) {
        this.operatorConditionList = operatorConditionList;
    }

    @JsonProperty("OperatorGroup")
    public OperatorGroup getOperatorGroup() {
        return operatorGroup;
    }

    @JsonProperty("OperatorGroup")
    public void setOperatorGroup(OperatorGroup operatorGroup) {
        this.operatorGroup = operatorGroup;
    }

    @JsonProperty("OperatorGroupList")
    public OperatorGroupList getOperatorGroupList() {
        return operatorGroupList;
    }

    @JsonProperty("OperatorGroupList")
    public void setOperatorGroupList(OperatorGroupList operatorGroupList) {
        this.operatorGroupList = operatorGroupList;
    }

    @JsonProperty("OperatorList")
    public OperatorList getOperatorList() {
        return operatorList;
    }

    @JsonProperty("OperatorList")
    public void setOperatorList(OperatorList operatorList) {
        this.operatorList = operatorList;
    }

    @JsonProperty("PackageManifest")
    public PackageManifest getPackageManifest() {
        return packageManifest;
    }

    @JsonProperty("PackageManifest")
    public void setPackageManifest(PackageManifest packageManifest) {
        this.packageManifest = packageManifest;
    }

    @JsonProperty("PackageManifestList")
    public PackageManifestList getPackageManifestList() {
        return packageManifestList;
    }

    @JsonProperty("PackageManifestList")
    public void setPackageManifestList(PackageManifestList packageManifestList) {
        this.packageManifestList = packageManifestList;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("PolicyRule")
    public PolicyRule getPolicyRule() {
        return policyRule;
    }

    @JsonProperty("PolicyRule")
    public void setPolicyRule(PolicyRule policyRule) {
        this.policyRule = policyRule;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("RuleWithOperations")
    public RuleWithOperations getRuleWithOperations() {
        return ruleWithOperations;
    }

    @JsonProperty("RuleWithOperations")
    public void setRuleWithOperations(RuleWithOperations ruleWithOperations) {
        this.ruleWithOperations = ruleWithOperations;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("Subscription")
    public Subscription getSubscription() {
        return subscription;
    }

    @JsonProperty("Subscription")
    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    @JsonProperty("SubscriptionList")
    public SubscriptionList getSubscriptionList() {
        return subscriptionList;
    }

    @JsonProperty("SubscriptionList")
    public void setSubscriptionList(SubscriptionList subscriptionList) {
        this.subscriptionList = subscriptionList;
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

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
