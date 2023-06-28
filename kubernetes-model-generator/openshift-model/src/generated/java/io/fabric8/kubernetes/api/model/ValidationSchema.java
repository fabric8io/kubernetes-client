
package io.fabric8.kubernetes.api.model;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.fabric8.kubernetes.api.model.authentication.TokenReview;
import io.fabric8.kubernetes.api.model.rbac.AggregationRule;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuota;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuotaList;
import io.fabric8.openshift.api.model.BrokerTemplateInstance;
import io.fabric8.openshift.api.model.BrokerTemplateInstanceList;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.ClusterNetwork;
import io.fabric8.openshift.api.model.ClusterNetworkList;
import io.fabric8.openshift.api.model.ClusterResourceQuota;
import io.fabric8.openshift.api.model.ClusterResourceQuotaList;
import io.fabric8.openshift.api.model.ClusterRole;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.ClusterRoleBindingList;
import io.fabric8.openshift.api.model.ClusterRoleList;
import io.fabric8.openshift.api.model.ClusterRoleScopeRestriction;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.EgressNetworkPolicy;
import io.fabric8.openshift.api.model.EgressNetworkPolicyList;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.HelmChartRepository;
import io.fabric8.openshift.api.model.HelmChartRepositoryList;
import io.fabric8.openshift.api.model.HostSubnet;
import io.fabric8.openshift.api.model.HostSubnetList;
import io.fabric8.openshift.api.model.Identity;
import io.fabric8.openshift.api.model.IdentityList;
import io.fabric8.openshift.api.model.ImageList;
import io.fabric8.openshift.api.model.ImageSignature;
import io.fabric8.openshift.api.model.ImageStreamImage;
import io.fabric8.openshift.api.model.ImageStreamImport;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.ImageStreamMapping;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.api.model.ImageTag;
import io.fabric8.openshift.api.model.ImageTagList;
import io.fabric8.openshift.api.model.LocalResourceAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.NetNamespaceList;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientAuthorization;
import io.fabric8.openshift.api.model.OAuthClientAuthorizationList;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.PodSecurityPolicyReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySelfSubjectReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySubjectReview;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.RangeAllocation;
import io.fabric8.openshift.api.model.RangeAllocationList;
import io.fabric8.openshift.api.model.ResourceAccessReview;
import io.fabric8.openshift.api.model.ResourceAccessReviewResponse;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.RoleBindingRestriction;
import io.fabric8.openshift.api.model.RoleBindingRestrictionList;
import io.fabric8.openshift.api.model.RoleBindingRestrictionSpec;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectRulesReview;
import io.fabric8.openshift.api.model.TagEvent;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateInstance;
import io.fabric8.openshift.api.model.TemplateInstanceList;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserIdentityMapping;
import io.fabric8.openshift.api.model.UserList;
import io.fabric8.openshift.api.model.UserOAuthAccessToken;
import io.fabric8.openshift.api.model.UserOAuthAccessTokenList;
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
    "AggregationRule",
    "AppliedClusterResourceQuota",
    "AppliedClusterResourceQuotaList",
    "BaseKubernetesList",
    "BrokerTemplateInstance",
    "BrokerTemplateInstanceList",
    "BuildConfigList",
    "BuildList",
    "BuildRequest",
    "ClusterNetwork",
    "ClusterNetworkList",
    "ClusterResourceQuota",
    "ClusterResourceQuotaList",
    "Config",
    "CreateOptions",
    "DeleteOptions",
    "DeploymentConfig",
    "DeploymentConfigList",
    "EgressNetworkPolicy",
    "EgressNetworkPolicyList",
    "GetOptions",
    "Group",
    "GroupList",
    "HelmChartRepository",
    "HelmChartRepositoryList",
    "HostSubnet",
    "HostSubnetList",
    "Identity",
    "IdentityList",
    "ImageList",
    "ImageSignature",
    "ImageStreamImage",
    "ImageStreamImport",
    "ImageStreamList",
    "ImageStreamMapping",
    "ImageStreamTagList",
    "ImageTag",
    "ImageTagList",
    "Info",
    "ListOptions",
    "LocalResourceAccessReview",
    "LocalSubjectAccessReview",
    "NetNamespace",
    "NetNamespaceList",
    "OAuthAccessToken",
    "OAuthAccessTokenList",
    "OAuthAuthorizeToken",
    "OAuthAuthorizeTokenList",
    "OAuthClient",
    "OAuthClientAuthorization",
    "OAuthClientAuthorizationList",
    "OAuthClientList",
    "ObjectMeta",
    "OpenShiftRoleBindingRestrictionList",
    "OpenshiftClusterRole",
    "OpenshiftClusterRoleBinding",
    "OpenshiftClusterRoleBindingList",
    "OpenshiftClusterRoleList",
    "OpenshiftClusterRoleScopeRestriction",
    "OpenshiftRole",
    "OpenshiftRoleBinding",
    "OpenshiftRoleBindingList",
    "OpenshiftRoleBindingRestriction",
    "OpenshiftRoleBindingRestrictionSpec",
    "OpenshiftRoleList",
    "Patch",
    "PatchOptions",
    "PodSecurityPolicyReview",
    "PodSecurityPolicySelfSubjectReview",
    "PodSecurityPolicySubjectReview",
    "Project",
    "ProjectList",
    "ProjectRequest",
    "Quantity",
    "RangeAllocation",
    "RangeAllocationList",
    "ResourceAccessReview",
    "ResourceAccessReviewResponse",
    "RootPaths",
    "Route",
    "RouteList",
    "SecurityContextConstraints",
    "SecurityContextConstraintsList",
    "SelfSubjectRulesReview",
    "Status",
    "SubjectAccessReview",
    "SubjectAccessReviewResponse",
    "SubjectRulesReview",
    "TagEvent",
    "Template",
    "TemplateInstance",
    "TemplateInstanceList",
    "TemplateList",
    "Time",
    "TokenReview",
    "TypeMeta",
    "UpdateOptions",
    "User",
    "UserIdentityMapping",
    "UserList",
    "UserOAuthAccessToken",
    "UserOAuthAccessTokenList"
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
@Generated("jsonschema2pojo")
public class ValidationSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("AggregationRule")
    private AggregationRule aggregationRule;
    @JsonProperty("AppliedClusterResourceQuota")
    private AppliedClusterResourceQuota appliedClusterResourceQuota;
    @JsonProperty("AppliedClusterResourceQuotaList")
    private AppliedClusterResourceQuotaList appliedClusterResourceQuotaList;
    @JsonProperty("BaseKubernetesList")
    private KubernetesList baseKubernetesList;
    @JsonProperty("BrokerTemplateInstance")
    private BrokerTemplateInstance brokerTemplateInstance;
    @JsonProperty("BrokerTemplateInstanceList")
    private BrokerTemplateInstanceList brokerTemplateInstanceList;
    @JsonProperty("BuildConfigList")
    private BuildConfigList buildConfigList;
    @JsonProperty("BuildList")
    private BuildList buildList;
    @JsonProperty("BuildRequest")
    private BuildRequest buildRequest;
    @JsonProperty("ClusterNetwork")
    private ClusterNetwork clusterNetwork;
    @JsonProperty("ClusterNetworkList")
    private ClusterNetworkList clusterNetworkList;
    @JsonProperty("ClusterResourceQuota")
    private ClusterResourceQuota clusterResourceQuota;
    @JsonProperty("ClusterResourceQuotaList")
    private ClusterResourceQuotaList clusterResourceQuotaList;
    @JsonProperty("Config")
    private Config config;
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DeleteOptions")
    private DeleteOptions deleteOptions;
    @JsonProperty("DeploymentConfig")
    private DeploymentConfig deploymentConfig;
    @JsonProperty("DeploymentConfigList")
    private DeploymentConfigList deploymentConfigList;
    @JsonProperty("EgressNetworkPolicy")
    private EgressNetworkPolicy egressNetworkPolicy;
    @JsonProperty("EgressNetworkPolicyList")
    private EgressNetworkPolicyList egressNetworkPolicyList;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Group")
    private Group group;
    @JsonProperty("GroupList")
    private GroupList groupList;
    @JsonProperty("HelmChartRepository")
    private HelmChartRepository helmChartRepository;
    @JsonProperty("HelmChartRepositoryList")
    private HelmChartRepositoryList helmChartRepositoryList;
    @JsonProperty("HostSubnet")
    private HostSubnet hostSubnet;
    @JsonProperty("HostSubnetList")
    private HostSubnetList hostSubnetList;
    @JsonProperty("Identity")
    private Identity identity;
    @JsonProperty("IdentityList")
    private IdentityList identityList;
    @JsonProperty("ImageList")
    private ImageList imageList;
    @JsonProperty("ImageSignature")
    private ImageSignature imageSignature;
    @JsonProperty("ImageStreamImage")
    private ImageStreamImage imageStreamImage;
    @JsonProperty("ImageStreamImport")
    private ImageStreamImport imageStreamImport;
    @JsonProperty("ImageStreamList")
    private ImageStreamList imageStreamList;
    @JsonProperty("ImageStreamMapping")
    private ImageStreamMapping imageStreamMapping;
    @JsonProperty("ImageStreamTagList")
    private ImageStreamTagList imageStreamTagList;
    @JsonProperty("ImageTag")
    private ImageTag imageTag;
    @JsonProperty("ImageTagList")
    private ImageTagList imageTagList;
    @JsonProperty("Info")
    private Info info;
    @JsonProperty("ListOptions")
    private ListOptions listOptions;
    @JsonProperty("LocalResourceAccessReview")
    private LocalResourceAccessReview localResourceAccessReview;
    @JsonProperty("LocalSubjectAccessReview")
    private LocalSubjectAccessReview localSubjectAccessReview;
    @JsonProperty("NetNamespace")
    private NetNamespace netNamespace;
    @JsonProperty("NetNamespaceList")
    private NetNamespaceList netNamespaceList;
    @JsonProperty("OAuthAccessToken")
    private OAuthAccessToken oAuthAccessToken;
    @JsonProperty("OAuthAccessTokenList")
    private OAuthAccessTokenList oAuthAccessTokenList;
    @JsonProperty("OAuthAuthorizeToken")
    private OAuthAuthorizeToken oAuthAuthorizeToken;
    @JsonProperty("OAuthAuthorizeTokenList")
    private OAuthAuthorizeTokenList oAuthAuthorizeTokenList;
    @JsonProperty("OAuthClient")
    private OAuthClient oAuthClient;
    @JsonProperty("OAuthClientAuthorization")
    private OAuthClientAuthorization oAuthClientAuthorization;
    @JsonProperty("OAuthClientAuthorizationList")
    private OAuthClientAuthorizationList oAuthClientAuthorizationList;
    @JsonProperty("OAuthClientList")
    private OAuthClientList oAuthClientList;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
    @JsonProperty("OpenShiftRoleBindingRestrictionList")
    private RoleBindingRestrictionList openShiftRoleBindingRestrictionList;
    @JsonProperty("OpenshiftClusterRole")
    private ClusterRole openshiftClusterRole;
    @JsonProperty("OpenshiftClusterRoleBinding")
    private ClusterRoleBinding openshiftClusterRoleBinding;
    @JsonProperty("OpenshiftClusterRoleBindingList")
    private ClusterRoleBindingList openshiftClusterRoleBindingList;
    @JsonProperty("OpenshiftClusterRoleList")
    private ClusterRoleList openshiftClusterRoleList;
    @JsonProperty("OpenshiftClusterRoleScopeRestriction")
    private ClusterRoleScopeRestriction openshiftClusterRoleScopeRestriction;
    @JsonProperty("OpenshiftRole")
    private Role openshiftRole;
    @JsonProperty("OpenshiftRoleBinding")
    private RoleBinding openshiftRoleBinding;
    @JsonProperty("OpenshiftRoleBindingList")
    private RoleBindingList openshiftRoleBindingList;
    @JsonProperty("OpenshiftRoleBindingRestriction")
    private RoleBindingRestriction openshiftRoleBindingRestriction;
    @JsonProperty("OpenshiftRoleBindingRestrictionSpec")
    private RoleBindingRestrictionSpec openshiftRoleBindingRestrictionSpec;
    @JsonProperty("OpenshiftRoleList")
    private RoleList openshiftRoleList;
    @JsonProperty("Patch")
    private Patch patch;
    @JsonProperty("PatchOptions")
    private PatchOptions patchOptions;
    @JsonProperty("PodSecurityPolicyReview")
    private PodSecurityPolicyReview podSecurityPolicyReview;
    @JsonProperty("PodSecurityPolicySelfSubjectReview")
    private PodSecurityPolicySelfSubjectReview podSecurityPolicySelfSubjectReview;
    @JsonProperty("PodSecurityPolicySubjectReview")
    private PodSecurityPolicySubjectReview podSecurityPolicySubjectReview;
    @JsonProperty("Project")
    private Project project;
    @JsonProperty("ProjectList")
    private ProjectList projectList;
    @JsonProperty("ProjectRequest")
    private ProjectRequest projectRequest;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("RangeAllocation")
    private RangeAllocation rangeAllocation;
    @JsonProperty("RangeAllocationList")
    private RangeAllocationList rangeAllocationList;
    @JsonProperty("ResourceAccessReview")
    private ResourceAccessReview resourceAccessReview;
    @JsonProperty("ResourceAccessReviewResponse")
    private ResourceAccessReviewResponse resourceAccessReviewResponse;
    @JsonProperty("RootPaths")
    private RootPaths rootPaths;
    @JsonProperty("Route")
    private Route route;
    @JsonProperty("RouteList")
    private RouteList routeList;
    @JsonProperty("SecurityContextConstraints")
    private SecurityContextConstraints securityContextConstraints;
    @JsonProperty("SecurityContextConstraintsList")
    private SecurityContextConstraintsList securityContextConstraintsList;
    @JsonProperty("SelfSubjectRulesReview")
    private SelfSubjectRulesReview selfSubjectRulesReview;
    @JsonProperty("Status")
    private Status status;
    @JsonProperty("SubjectAccessReview")
    private SubjectAccessReview subjectAccessReview;
    @JsonProperty("SubjectAccessReviewResponse")
    private SubjectAccessReviewResponse subjectAccessReviewResponse;
    @JsonProperty("SubjectRulesReview")
    private SubjectRulesReview subjectRulesReview;
    @JsonProperty("TagEvent")
    private TagEvent tagEvent;
    @JsonProperty("Template")
    private Template template;
    @JsonProperty("TemplateInstance")
    private TemplateInstance templateInstance;
    @JsonProperty("TemplateInstanceList")
    private TemplateInstanceList templateInstanceList;
    @JsonProperty("TemplateList")
    private TemplateList templateList;
    @JsonProperty("Time")
    private String time;
    @JsonProperty("TokenReview")
    private TokenReview tokenReview;
    @JsonProperty("TypeMeta")
    private TypeMeta typeMeta;
    @JsonProperty("UpdateOptions")
    private UpdateOptions updateOptions;
    @JsonProperty("User")
    private User user;
    @JsonProperty("UserIdentityMapping")
    private UserIdentityMapping userIdentityMapping;
    @JsonProperty("UserList")
    private UserList userList;
    @JsonProperty("UserOAuthAccessToken")
    private UserOAuthAccessToken userOAuthAccessToken;
    @JsonProperty("UserOAuthAccessTokenList")
    private UserOAuthAccessTokenList userOAuthAccessTokenList;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, AggregationRule aggregationRule, AppliedClusterResourceQuota appliedClusterResourceQuota, AppliedClusterResourceQuotaList appliedClusterResourceQuotaList, KubernetesList baseKubernetesList, BrokerTemplateInstance brokerTemplateInstance, BrokerTemplateInstanceList brokerTemplateInstanceList, BuildConfigList buildConfigList, BuildList buildList, BuildRequest buildRequest, ClusterNetwork clusterNetwork, ClusterNetworkList clusterNetworkList, ClusterResourceQuota clusterResourceQuota, ClusterResourceQuotaList clusterResourceQuotaList, Config config, CreateOptions createOptions, DeleteOptions deleteOptions, DeploymentConfig deploymentConfig, DeploymentConfigList deploymentConfigList, EgressNetworkPolicy egressNetworkPolicy, EgressNetworkPolicyList egressNetworkPolicyList, GetOptions getOptions, Group group, GroupList groupList, HelmChartRepository helmChartRepository, HelmChartRepositoryList helmChartRepositoryList, HostSubnet hostSubnet, HostSubnetList hostSubnetList, Identity identity, IdentityList identityList, ImageList imageList, ImageSignature imageSignature, ImageStreamImage imageStreamImage, ImageStreamImport imageStreamImport, ImageStreamList imageStreamList, ImageStreamMapping imageStreamMapping, ImageStreamTagList imageStreamTagList, ImageTag imageTag, ImageTagList imageTagList, Info info, ListOptions listOptions, LocalResourceAccessReview localResourceAccessReview, LocalSubjectAccessReview localSubjectAccessReview, NetNamespace netNamespace, NetNamespaceList netNamespaceList, OAuthAccessToken oAuthAccessToken, OAuthAccessTokenList oAuthAccessTokenList, OAuthAuthorizeToken oAuthAuthorizeToken, OAuthAuthorizeTokenList oAuthAuthorizeTokenList, OAuthClient oAuthClient, OAuthClientAuthorization oAuthClientAuthorization, OAuthClientAuthorizationList oAuthClientAuthorizationList, OAuthClientList oAuthClientList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, RoleBindingRestrictionList openShiftRoleBindingRestrictionList, ClusterRole openshiftClusterRole, ClusterRoleBinding openshiftClusterRoleBinding, ClusterRoleBindingList openshiftClusterRoleBindingList, ClusterRoleList openshiftClusterRoleList, ClusterRoleScopeRestriction openshiftClusterRoleScopeRestriction, Role openshiftRole, RoleBinding openshiftRoleBinding, RoleBindingList openshiftRoleBindingList, RoleBindingRestriction openshiftRoleBindingRestriction, RoleBindingRestrictionSpec openshiftRoleBindingRestrictionSpec, RoleList openshiftRoleList, Patch patch, PatchOptions patchOptions, PodSecurityPolicyReview podSecurityPolicyReview, PodSecurityPolicySelfSubjectReview podSecurityPolicySelfSubjectReview, PodSecurityPolicySubjectReview podSecurityPolicySubjectReview, Project project, ProjectList projectList, ProjectRequest projectRequest, Quantity quantity, RangeAllocation rangeAllocation, RangeAllocationList rangeAllocationList, ResourceAccessReview resourceAccessReview, ResourceAccessReviewResponse resourceAccessReviewResponse, RootPaths rootPaths, Route route, RouteList routeList, SecurityContextConstraints securityContextConstraints, SecurityContextConstraintsList securityContextConstraintsList, SelfSubjectRulesReview selfSubjectRulesReview, Status status, SubjectAccessReview subjectAccessReview, SubjectAccessReviewResponse subjectAccessReviewResponse, SubjectRulesReview subjectRulesReview, TagEvent tagEvent, Template template, TemplateInstance templateInstance, TemplateInstanceList templateInstanceList, TemplateList templateList, String time, TokenReview tokenReview, TypeMeta typeMeta, UpdateOptions updateOptions, User user, UserIdentityMapping userIdentityMapping, UserList userList, UserOAuthAccessToken userOAuthAccessToken, UserOAuthAccessTokenList userOAuthAccessTokenList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.aggregationRule = aggregationRule;
        this.appliedClusterResourceQuota = appliedClusterResourceQuota;
        this.appliedClusterResourceQuotaList = appliedClusterResourceQuotaList;
        this.baseKubernetesList = baseKubernetesList;
        this.brokerTemplateInstance = brokerTemplateInstance;
        this.brokerTemplateInstanceList = brokerTemplateInstanceList;
        this.buildConfigList = buildConfigList;
        this.buildList = buildList;
        this.buildRequest = buildRequest;
        this.clusterNetwork = clusterNetwork;
        this.clusterNetworkList = clusterNetworkList;
        this.clusterResourceQuota = clusterResourceQuota;
        this.clusterResourceQuotaList = clusterResourceQuotaList;
        this.config = config;
        this.createOptions = createOptions;
        this.deleteOptions = deleteOptions;
        this.deploymentConfig = deploymentConfig;
        this.deploymentConfigList = deploymentConfigList;
        this.egressNetworkPolicy = egressNetworkPolicy;
        this.egressNetworkPolicyList = egressNetworkPolicyList;
        this.getOptions = getOptions;
        this.group = group;
        this.groupList = groupList;
        this.helmChartRepository = helmChartRepository;
        this.helmChartRepositoryList = helmChartRepositoryList;
        this.hostSubnet = hostSubnet;
        this.hostSubnetList = hostSubnetList;
        this.identity = identity;
        this.identityList = identityList;
        this.imageList = imageList;
        this.imageSignature = imageSignature;
        this.imageStreamImage = imageStreamImage;
        this.imageStreamImport = imageStreamImport;
        this.imageStreamList = imageStreamList;
        this.imageStreamMapping = imageStreamMapping;
        this.imageStreamTagList = imageStreamTagList;
        this.imageTag = imageTag;
        this.imageTagList = imageTagList;
        this.info = info;
        this.listOptions = listOptions;
        this.localResourceAccessReview = localResourceAccessReview;
        this.localSubjectAccessReview = localSubjectAccessReview;
        this.netNamespace = netNamespace;
        this.netNamespaceList = netNamespaceList;
        this.oAuthAccessToken = oAuthAccessToken;
        this.oAuthAccessTokenList = oAuthAccessTokenList;
        this.oAuthAuthorizeToken = oAuthAuthorizeToken;
        this.oAuthAuthorizeTokenList = oAuthAuthorizeTokenList;
        this.oAuthClient = oAuthClient;
        this.oAuthClientAuthorization = oAuthClientAuthorization;
        this.oAuthClientAuthorizationList = oAuthClientAuthorizationList;
        this.oAuthClientList = oAuthClientList;
        this.objectMeta = objectMeta;
        this.openShiftRoleBindingRestrictionList = openShiftRoleBindingRestrictionList;
        this.openshiftClusterRole = openshiftClusterRole;
        this.openshiftClusterRoleBinding = openshiftClusterRoleBinding;
        this.openshiftClusterRoleBindingList = openshiftClusterRoleBindingList;
        this.openshiftClusterRoleList = openshiftClusterRoleList;
        this.openshiftClusterRoleScopeRestriction = openshiftClusterRoleScopeRestriction;
        this.openshiftRole = openshiftRole;
        this.openshiftRoleBinding = openshiftRoleBinding;
        this.openshiftRoleBindingList = openshiftRoleBindingList;
        this.openshiftRoleBindingRestriction = openshiftRoleBindingRestriction;
        this.openshiftRoleBindingRestrictionSpec = openshiftRoleBindingRestrictionSpec;
        this.openshiftRoleList = openshiftRoleList;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.podSecurityPolicyReview = podSecurityPolicyReview;
        this.podSecurityPolicySelfSubjectReview = podSecurityPolicySelfSubjectReview;
        this.podSecurityPolicySubjectReview = podSecurityPolicySubjectReview;
        this.project = project;
        this.projectList = projectList;
        this.projectRequest = projectRequest;
        this.quantity = quantity;
        this.rangeAllocation = rangeAllocation;
        this.rangeAllocationList = rangeAllocationList;
        this.resourceAccessReview = resourceAccessReview;
        this.resourceAccessReviewResponse = resourceAccessReviewResponse;
        this.rootPaths = rootPaths;
        this.route = route;
        this.routeList = routeList;
        this.securityContextConstraints = securityContextConstraints;
        this.securityContextConstraintsList = securityContextConstraintsList;
        this.selfSubjectRulesReview = selfSubjectRulesReview;
        this.status = status;
        this.subjectAccessReview = subjectAccessReview;
        this.subjectAccessReviewResponse = subjectAccessReviewResponse;
        this.subjectRulesReview = subjectRulesReview;
        this.tagEvent = tagEvent;
        this.template = template;
        this.templateInstance = templateInstance;
        this.templateInstanceList = templateInstanceList;
        this.templateList = templateList;
        this.time = time;
        this.tokenReview = tokenReview;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.user = user;
        this.userIdentityMapping = userIdentityMapping;
        this.userList = userList;
        this.userOAuthAccessToken = userOAuthAccessToken;
        this.userOAuthAccessTokenList = userOAuthAccessTokenList;
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

    @JsonProperty("AggregationRule")
    public AggregationRule getAggregationRule() {
        return aggregationRule;
    }

    @JsonProperty("AggregationRule")
    public void setAggregationRule(AggregationRule aggregationRule) {
        this.aggregationRule = aggregationRule;
    }

    @JsonProperty("AppliedClusterResourceQuota")
    public AppliedClusterResourceQuota getAppliedClusterResourceQuota() {
        return appliedClusterResourceQuota;
    }

    @JsonProperty("AppliedClusterResourceQuota")
    public void setAppliedClusterResourceQuota(AppliedClusterResourceQuota appliedClusterResourceQuota) {
        this.appliedClusterResourceQuota = appliedClusterResourceQuota;
    }

    @JsonProperty("AppliedClusterResourceQuotaList")
    public AppliedClusterResourceQuotaList getAppliedClusterResourceQuotaList() {
        return appliedClusterResourceQuotaList;
    }

    @JsonProperty("AppliedClusterResourceQuotaList")
    public void setAppliedClusterResourceQuotaList(AppliedClusterResourceQuotaList appliedClusterResourceQuotaList) {
        this.appliedClusterResourceQuotaList = appliedClusterResourceQuotaList;
    }

    @JsonProperty("BaseKubernetesList")
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("BrokerTemplateInstance")
    public BrokerTemplateInstance getBrokerTemplateInstance() {
        return brokerTemplateInstance;
    }

    @JsonProperty("BrokerTemplateInstance")
    public void setBrokerTemplateInstance(BrokerTemplateInstance brokerTemplateInstance) {
        this.brokerTemplateInstance = brokerTemplateInstance;
    }

    @JsonProperty("BrokerTemplateInstanceList")
    public BrokerTemplateInstanceList getBrokerTemplateInstanceList() {
        return brokerTemplateInstanceList;
    }

    @JsonProperty("BrokerTemplateInstanceList")
    public void setBrokerTemplateInstanceList(BrokerTemplateInstanceList brokerTemplateInstanceList) {
        this.brokerTemplateInstanceList = brokerTemplateInstanceList;
    }

    @JsonProperty("BuildConfigList")
    public BuildConfigList getBuildConfigList() {
        return buildConfigList;
    }

    @JsonProperty("BuildConfigList")
    public void setBuildConfigList(BuildConfigList buildConfigList) {
        this.buildConfigList = buildConfigList;
    }

    @JsonProperty("BuildList")
    public BuildList getBuildList() {
        return buildList;
    }

    @JsonProperty("BuildList")
    public void setBuildList(BuildList buildList) {
        this.buildList = buildList;
    }

    @JsonProperty("BuildRequest")
    public BuildRequest getBuildRequest() {
        return buildRequest;
    }

    @JsonProperty("BuildRequest")
    public void setBuildRequest(BuildRequest buildRequest) {
        this.buildRequest = buildRequest;
    }

    @JsonProperty("ClusterNetwork")
    public ClusterNetwork getClusterNetwork() {
        return clusterNetwork;
    }

    @JsonProperty("ClusterNetwork")
    public void setClusterNetwork(ClusterNetwork clusterNetwork) {
        this.clusterNetwork = clusterNetwork;
    }

    @JsonProperty("ClusterNetworkList")
    public ClusterNetworkList getClusterNetworkList() {
        return clusterNetworkList;
    }

    @JsonProperty("ClusterNetworkList")
    public void setClusterNetworkList(ClusterNetworkList clusterNetworkList) {
        this.clusterNetworkList = clusterNetworkList;
    }

    @JsonProperty("ClusterResourceQuota")
    public ClusterResourceQuota getClusterResourceQuota() {
        return clusterResourceQuota;
    }

    @JsonProperty("ClusterResourceQuota")
    public void setClusterResourceQuota(ClusterResourceQuota clusterResourceQuota) {
        this.clusterResourceQuota = clusterResourceQuota;
    }

    @JsonProperty("ClusterResourceQuotaList")
    public ClusterResourceQuotaList getClusterResourceQuotaList() {
        return clusterResourceQuotaList;
    }

    @JsonProperty("ClusterResourceQuotaList")
    public void setClusterResourceQuotaList(ClusterResourceQuotaList clusterResourceQuotaList) {
        this.clusterResourceQuotaList = clusterResourceQuotaList;
    }

    @JsonProperty("Config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("Config")
    public void setConfig(Config config) {
        this.config = config;
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

    @JsonProperty("DeploymentConfig")
    public DeploymentConfig getDeploymentConfig() {
        return deploymentConfig;
    }

    @JsonProperty("DeploymentConfig")
    public void setDeploymentConfig(DeploymentConfig deploymentConfig) {
        this.deploymentConfig = deploymentConfig;
    }

    @JsonProperty("DeploymentConfigList")
    public DeploymentConfigList getDeploymentConfigList() {
        return deploymentConfigList;
    }

    @JsonProperty("DeploymentConfigList")
    public void setDeploymentConfigList(DeploymentConfigList deploymentConfigList) {
        this.deploymentConfigList = deploymentConfigList;
    }

    @JsonProperty("EgressNetworkPolicy")
    public EgressNetworkPolicy getEgressNetworkPolicy() {
        return egressNetworkPolicy;
    }

    @JsonProperty("EgressNetworkPolicy")
    public void setEgressNetworkPolicy(EgressNetworkPolicy egressNetworkPolicy) {
        this.egressNetworkPolicy = egressNetworkPolicy;
    }

    @JsonProperty("EgressNetworkPolicyList")
    public EgressNetworkPolicyList getEgressNetworkPolicyList() {
        return egressNetworkPolicyList;
    }

    @JsonProperty("EgressNetworkPolicyList")
    public void setEgressNetworkPolicyList(EgressNetworkPolicyList egressNetworkPolicyList) {
        this.egressNetworkPolicyList = egressNetworkPolicyList;
    }

    @JsonProperty("GetOptions")
    public GetOptions getGetOptions() {
        return getOptions;
    }

    @JsonProperty("GetOptions")
    public void setGetOptions(GetOptions getOptions) {
        this.getOptions = getOptions;
    }

    @JsonProperty("Group")
    public Group getGroup() {
        return group;
    }

    @JsonProperty("Group")
    public void setGroup(Group group) {
        this.group = group;
    }

    @JsonProperty("GroupList")
    public GroupList getGroupList() {
        return groupList;
    }

    @JsonProperty("GroupList")
    public void setGroupList(GroupList groupList) {
        this.groupList = groupList;
    }

    @JsonProperty("HelmChartRepository")
    public HelmChartRepository getHelmChartRepository() {
        return helmChartRepository;
    }

    @JsonProperty("HelmChartRepository")
    public void setHelmChartRepository(HelmChartRepository helmChartRepository) {
        this.helmChartRepository = helmChartRepository;
    }

    @JsonProperty("HelmChartRepositoryList")
    public HelmChartRepositoryList getHelmChartRepositoryList() {
        return helmChartRepositoryList;
    }

    @JsonProperty("HelmChartRepositoryList")
    public void setHelmChartRepositoryList(HelmChartRepositoryList helmChartRepositoryList) {
        this.helmChartRepositoryList = helmChartRepositoryList;
    }

    @JsonProperty("HostSubnet")
    public HostSubnet getHostSubnet() {
        return hostSubnet;
    }

    @JsonProperty("HostSubnet")
    public void setHostSubnet(HostSubnet hostSubnet) {
        this.hostSubnet = hostSubnet;
    }

    @JsonProperty("HostSubnetList")
    public HostSubnetList getHostSubnetList() {
        return hostSubnetList;
    }

    @JsonProperty("HostSubnetList")
    public void setHostSubnetList(HostSubnetList hostSubnetList) {
        this.hostSubnetList = hostSubnetList;
    }

    @JsonProperty("Identity")
    public Identity getIdentity() {
        return identity;
    }

    @JsonProperty("Identity")
    public void setIdentity(Identity identity) {
        this.identity = identity;
    }

    @JsonProperty("IdentityList")
    public IdentityList getIdentityList() {
        return identityList;
    }

    @JsonProperty("IdentityList")
    public void setIdentityList(IdentityList identityList) {
        this.identityList = identityList;
    }

    @JsonProperty("ImageList")
    public ImageList getImageList() {
        return imageList;
    }

    @JsonProperty("ImageList")
    public void setImageList(ImageList imageList) {
        this.imageList = imageList;
    }

    @JsonProperty("ImageSignature")
    public ImageSignature getImageSignature() {
        return imageSignature;
    }

    @JsonProperty("ImageSignature")
    public void setImageSignature(ImageSignature imageSignature) {
        this.imageSignature = imageSignature;
    }

    @JsonProperty("ImageStreamImage")
    public ImageStreamImage getImageStreamImage() {
        return imageStreamImage;
    }

    @JsonProperty("ImageStreamImage")
    public void setImageStreamImage(ImageStreamImage imageStreamImage) {
        this.imageStreamImage = imageStreamImage;
    }

    @JsonProperty("ImageStreamImport")
    public ImageStreamImport getImageStreamImport() {
        return imageStreamImport;
    }

    @JsonProperty("ImageStreamImport")
    public void setImageStreamImport(ImageStreamImport imageStreamImport) {
        this.imageStreamImport = imageStreamImport;
    }

    @JsonProperty("ImageStreamList")
    public ImageStreamList getImageStreamList() {
        return imageStreamList;
    }

    @JsonProperty("ImageStreamList")
    public void setImageStreamList(ImageStreamList imageStreamList) {
        this.imageStreamList = imageStreamList;
    }

    @JsonProperty("ImageStreamMapping")
    public ImageStreamMapping getImageStreamMapping() {
        return imageStreamMapping;
    }

    @JsonProperty("ImageStreamMapping")
    public void setImageStreamMapping(ImageStreamMapping imageStreamMapping) {
        this.imageStreamMapping = imageStreamMapping;
    }

    @JsonProperty("ImageStreamTagList")
    public ImageStreamTagList getImageStreamTagList() {
        return imageStreamTagList;
    }

    @JsonProperty("ImageStreamTagList")
    public void setImageStreamTagList(ImageStreamTagList imageStreamTagList) {
        this.imageStreamTagList = imageStreamTagList;
    }

    @JsonProperty("ImageTag")
    public ImageTag getImageTag() {
        return imageTag;
    }

    @JsonProperty("ImageTag")
    public void setImageTag(ImageTag imageTag) {
        this.imageTag = imageTag;
    }

    @JsonProperty("ImageTagList")
    public ImageTagList getImageTagList() {
        return imageTagList;
    }

    @JsonProperty("ImageTagList")
    public void setImageTagList(ImageTagList imageTagList) {
        this.imageTagList = imageTagList;
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

    @JsonProperty("LocalResourceAccessReview")
    public LocalResourceAccessReview getLocalResourceAccessReview() {
        return localResourceAccessReview;
    }

    @JsonProperty("LocalResourceAccessReview")
    public void setLocalResourceAccessReview(LocalResourceAccessReview localResourceAccessReview) {
        this.localResourceAccessReview = localResourceAccessReview;
    }

    @JsonProperty("LocalSubjectAccessReview")
    public LocalSubjectAccessReview getLocalSubjectAccessReview() {
        return localSubjectAccessReview;
    }

    @JsonProperty("LocalSubjectAccessReview")
    public void setLocalSubjectAccessReview(LocalSubjectAccessReview localSubjectAccessReview) {
        this.localSubjectAccessReview = localSubjectAccessReview;
    }

    @JsonProperty("NetNamespace")
    public NetNamespace getNetNamespace() {
        return netNamespace;
    }

    @JsonProperty("NetNamespace")
    public void setNetNamespace(NetNamespace netNamespace) {
        this.netNamespace = netNamespace;
    }

    @JsonProperty("NetNamespaceList")
    public NetNamespaceList getNetNamespaceList() {
        return netNamespaceList;
    }

    @JsonProperty("NetNamespaceList")
    public void setNetNamespaceList(NetNamespaceList netNamespaceList) {
        this.netNamespaceList = netNamespaceList;
    }

    @JsonProperty("OAuthAccessToken")
    public OAuthAccessToken getOAuthAccessToken() {
        return oAuthAccessToken;
    }

    @JsonProperty("OAuthAccessToken")
    public void setOAuthAccessToken(OAuthAccessToken oAuthAccessToken) {
        this.oAuthAccessToken = oAuthAccessToken;
    }

    @JsonProperty("OAuthAccessTokenList")
    public OAuthAccessTokenList getOAuthAccessTokenList() {
        return oAuthAccessTokenList;
    }

    @JsonProperty("OAuthAccessTokenList")
    public void setOAuthAccessTokenList(OAuthAccessTokenList oAuthAccessTokenList) {
        this.oAuthAccessTokenList = oAuthAccessTokenList;
    }

    @JsonProperty("OAuthAuthorizeToken")
    public OAuthAuthorizeToken getOAuthAuthorizeToken() {
        return oAuthAuthorizeToken;
    }

    @JsonProperty("OAuthAuthorizeToken")
    public void setOAuthAuthorizeToken(OAuthAuthorizeToken oAuthAuthorizeToken) {
        this.oAuthAuthorizeToken = oAuthAuthorizeToken;
    }

    @JsonProperty("OAuthAuthorizeTokenList")
    public OAuthAuthorizeTokenList getOAuthAuthorizeTokenList() {
        return oAuthAuthorizeTokenList;
    }

    @JsonProperty("OAuthAuthorizeTokenList")
    public void setOAuthAuthorizeTokenList(OAuthAuthorizeTokenList oAuthAuthorizeTokenList) {
        this.oAuthAuthorizeTokenList = oAuthAuthorizeTokenList;
    }

    @JsonProperty("OAuthClient")
    public OAuthClient getOAuthClient() {
        return oAuthClient;
    }

    @JsonProperty("OAuthClient")
    public void setOAuthClient(OAuthClient oAuthClient) {
        this.oAuthClient = oAuthClient;
    }

    @JsonProperty("OAuthClientAuthorization")
    public OAuthClientAuthorization getOAuthClientAuthorization() {
        return oAuthClientAuthorization;
    }

    @JsonProperty("OAuthClientAuthorization")
    public void setOAuthClientAuthorization(OAuthClientAuthorization oAuthClientAuthorization) {
        this.oAuthClientAuthorization = oAuthClientAuthorization;
    }

    @JsonProperty("OAuthClientAuthorizationList")
    public OAuthClientAuthorizationList getOAuthClientAuthorizationList() {
        return oAuthClientAuthorizationList;
    }

    @JsonProperty("OAuthClientAuthorizationList")
    public void setOAuthClientAuthorizationList(OAuthClientAuthorizationList oAuthClientAuthorizationList) {
        this.oAuthClientAuthorizationList = oAuthClientAuthorizationList;
    }

    @JsonProperty("OAuthClientList")
    public OAuthClientList getOAuthClientList() {
        return oAuthClientList;
    }

    @JsonProperty("OAuthClientList")
    public void setOAuthClientList(OAuthClientList oAuthClientList) {
        this.oAuthClientList = oAuthClientList;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("OpenShiftRoleBindingRestrictionList")
    public RoleBindingRestrictionList getOpenShiftRoleBindingRestrictionList() {
        return openShiftRoleBindingRestrictionList;
    }

    @JsonProperty("OpenShiftRoleBindingRestrictionList")
    public void setOpenShiftRoleBindingRestrictionList(RoleBindingRestrictionList openShiftRoleBindingRestrictionList) {
        this.openShiftRoleBindingRestrictionList = openShiftRoleBindingRestrictionList;
    }

    @JsonProperty("OpenshiftClusterRole")
    public ClusterRole getOpenshiftClusterRole() {
        return openshiftClusterRole;
    }

    @JsonProperty("OpenshiftClusterRole")
    public void setOpenshiftClusterRole(ClusterRole openshiftClusterRole) {
        this.openshiftClusterRole = openshiftClusterRole;
    }

    @JsonProperty("OpenshiftClusterRoleBinding")
    public ClusterRoleBinding getOpenshiftClusterRoleBinding() {
        return openshiftClusterRoleBinding;
    }

    @JsonProperty("OpenshiftClusterRoleBinding")
    public void setOpenshiftClusterRoleBinding(ClusterRoleBinding openshiftClusterRoleBinding) {
        this.openshiftClusterRoleBinding = openshiftClusterRoleBinding;
    }

    @JsonProperty("OpenshiftClusterRoleBindingList")
    public ClusterRoleBindingList getOpenshiftClusterRoleBindingList() {
        return openshiftClusterRoleBindingList;
    }

    @JsonProperty("OpenshiftClusterRoleBindingList")
    public void setOpenshiftClusterRoleBindingList(ClusterRoleBindingList openshiftClusterRoleBindingList) {
        this.openshiftClusterRoleBindingList = openshiftClusterRoleBindingList;
    }

    @JsonProperty("OpenshiftClusterRoleList")
    public ClusterRoleList getOpenshiftClusterRoleList() {
        return openshiftClusterRoleList;
    }

    @JsonProperty("OpenshiftClusterRoleList")
    public void setOpenshiftClusterRoleList(ClusterRoleList openshiftClusterRoleList) {
        this.openshiftClusterRoleList = openshiftClusterRoleList;
    }

    @JsonProperty("OpenshiftClusterRoleScopeRestriction")
    public ClusterRoleScopeRestriction getOpenshiftClusterRoleScopeRestriction() {
        return openshiftClusterRoleScopeRestriction;
    }

    @JsonProperty("OpenshiftClusterRoleScopeRestriction")
    public void setOpenshiftClusterRoleScopeRestriction(ClusterRoleScopeRestriction openshiftClusterRoleScopeRestriction) {
        this.openshiftClusterRoleScopeRestriction = openshiftClusterRoleScopeRestriction;
    }

    @JsonProperty("OpenshiftRole")
    public Role getOpenshiftRole() {
        return openshiftRole;
    }

    @JsonProperty("OpenshiftRole")
    public void setOpenshiftRole(Role openshiftRole) {
        this.openshiftRole = openshiftRole;
    }

    @JsonProperty("OpenshiftRoleBinding")
    public RoleBinding getOpenshiftRoleBinding() {
        return openshiftRoleBinding;
    }

    @JsonProperty("OpenshiftRoleBinding")
    public void setOpenshiftRoleBinding(RoleBinding openshiftRoleBinding) {
        this.openshiftRoleBinding = openshiftRoleBinding;
    }

    @JsonProperty("OpenshiftRoleBindingList")
    public RoleBindingList getOpenshiftRoleBindingList() {
        return openshiftRoleBindingList;
    }

    @JsonProperty("OpenshiftRoleBindingList")
    public void setOpenshiftRoleBindingList(RoleBindingList openshiftRoleBindingList) {
        this.openshiftRoleBindingList = openshiftRoleBindingList;
    }

    @JsonProperty("OpenshiftRoleBindingRestriction")
    public RoleBindingRestriction getOpenshiftRoleBindingRestriction() {
        return openshiftRoleBindingRestriction;
    }

    @JsonProperty("OpenshiftRoleBindingRestriction")
    public void setOpenshiftRoleBindingRestriction(RoleBindingRestriction openshiftRoleBindingRestriction) {
        this.openshiftRoleBindingRestriction = openshiftRoleBindingRestriction;
    }

    @JsonProperty("OpenshiftRoleBindingRestrictionSpec")
    public RoleBindingRestrictionSpec getOpenshiftRoleBindingRestrictionSpec() {
        return openshiftRoleBindingRestrictionSpec;
    }

    @JsonProperty("OpenshiftRoleBindingRestrictionSpec")
    public void setOpenshiftRoleBindingRestrictionSpec(RoleBindingRestrictionSpec openshiftRoleBindingRestrictionSpec) {
        this.openshiftRoleBindingRestrictionSpec = openshiftRoleBindingRestrictionSpec;
    }

    @JsonProperty("OpenshiftRoleList")
    public RoleList getOpenshiftRoleList() {
        return openshiftRoleList;
    }

    @JsonProperty("OpenshiftRoleList")
    public void setOpenshiftRoleList(RoleList openshiftRoleList) {
        this.openshiftRoleList = openshiftRoleList;
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

    @JsonProperty("PodSecurityPolicyReview")
    public PodSecurityPolicyReview getPodSecurityPolicyReview() {
        return podSecurityPolicyReview;
    }

    @JsonProperty("PodSecurityPolicyReview")
    public void setPodSecurityPolicyReview(PodSecurityPolicyReview podSecurityPolicyReview) {
        this.podSecurityPolicyReview = podSecurityPolicyReview;
    }

    @JsonProperty("PodSecurityPolicySelfSubjectReview")
    public PodSecurityPolicySelfSubjectReview getPodSecurityPolicySelfSubjectReview() {
        return podSecurityPolicySelfSubjectReview;
    }

    @JsonProperty("PodSecurityPolicySelfSubjectReview")
    public void setPodSecurityPolicySelfSubjectReview(PodSecurityPolicySelfSubjectReview podSecurityPolicySelfSubjectReview) {
        this.podSecurityPolicySelfSubjectReview = podSecurityPolicySelfSubjectReview;
    }

    @JsonProperty("PodSecurityPolicySubjectReview")
    public PodSecurityPolicySubjectReview getPodSecurityPolicySubjectReview() {
        return podSecurityPolicySubjectReview;
    }

    @JsonProperty("PodSecurityPolicySubjectReview")
    public void setPodSecurityPolicySubjectReview(PodSecurityPolicySubjectReview podSecurityPolicySubjectReview) {
        this.podSecurityPolicySubjectReview = podSecurityPolicySubjectReview;
    }

    @JsonProperty("Project")
    public Project getProject() {
        return project;
    }

    @JsonProperty("Project")
    public void setProject(Project project) {
        this.project = project;
    }

    @JsonProperty("ProjectList")
    public ProjectList getProjectList() {
        return projectList;
    }

    @JsonProperty("ProjectList")
    public void setProjectList(ProjectList projectList) {
        this.projectList = projectList;
    }

    @JsonProperty("ProjectRequest")
    public ProjectRequest getProjectRequest() {
        return projectRequest;
    }

    @JsonProperty("ProjectRequest")
    public void setProjectRequest(ProjectRequest projectRequest) {
        this.projectRequest = projectRequest;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("RangeAllocation")
    public RangeAllocation getRangeAllocation() {
        return rangeAllocation;
    }

    @JsonProperty("RangeAllocation")
    public void setRangeAllocation(RangeAllocation rangeAllocation) {
        this.rangeAllocation = rangeAllocation;
    }

    @JsonProperty("RangeAllocationList")
    public RangeAllocationList getRangeAllocationList() {
        return rangeAllocationList;
    }

    @JsonProperty("RangeAllocationList")
    public void setRangeAllocationList(RangeAllocationList rangeAllocationList) {
        this.rangeAllocationList = rangeAllocationList;
    }

    @JsonProperty("ResourceAccessReview")
    public ResourceAccessReview getResourceAccessReview() {
        return resourceAccessReview;
    }

    @JsonProperty("ResourceAccessReview")
    public void setResourceAccessReview(ResourceAccessReview resourceAccessReview) {
        this.resourceAccessReview = resourceAccessReview;
    }

    @JsonProperty("ResourceAccessReviewResponse")
    public ResourceAccessReviewResponse getResourceAccessReviewResponse() {
        return resourceAccessReviewResponse;
    }

    @JsonProperty("ResourceAccessReviewResponse")
    public void setResourceAccessReviewResponse(ResourceAccessReviewResponse resourceAccessReviewResponse) {
        this.resourceAccessReviewResponse = resourceAccessReviewResponse;
    }

    @JsonProperty("RootPaths")
    public RootPaths getRootPaths() {
        return rootPaths;
    }

    @JsonProperty("RootPaths")
    public void setRootPaths(RootPaths rootPaths) {
        this.rootPaths = rootPaths;
    }

    @JsonProperty("Route")
    public Route getRoute() {
        return route;
    }

    @JsonProperty("Route")
    public void setRoute(Route route) {
        this.route = route;
    }

    @JsonProperty("RouteList")
    public RouteList getRouteList() {
        return routeList;
    }

    @JsonProperty("RouteList")
    public void setRouteList(RouteList routeList) {
        this.routeList = routeList;
    }

    @JsonProperty("SecurityContextConstraints")
    public SecurityContextConstraints getSecurityContextConstraints() {
        return securityContextConstraints;
    }

    @JsonProperty("SecurityContextConstraints")
    public void setSecurityContextConstraints(SecurityContextConstraints securityContextConstraints) {
        this.securityContextConstraints = securityContextConstraints;
    }

    @JsonProperty("SecurityContextConstraintsList")
    public SecurityContextConstraintsList getSecurityContextConstraintsList() {
        return securityContextConstraintsList;
    }

    @JsonProperty("SecurityContextConstraintsList")
    public void setSecurityContextConstraintsList(SecurityContextConstraintsList securityContextConstraintsList) {
        this.securityContextConstraintsList = securityContextConstraintsList;
    }

    @JsonProperty("SelfSubjectRulesReview")
    public SelfSubjectRulesReview getSelfSubjectRulesReview() {
        return selfSubjectRulesReview;
    }

    @JsonProperty("SelfSubjectRulesReview")
    public void setSelfSubjectRulesReview(SelfSubjectRulesReview selfSubjectRulesReview) {
        this.selfSubjectRulesReview = selfSubjectRulesReview;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("SubjectAccessReview")
    public SubjectAccessReview getSubjectAccessReview() {
        return subjectAccessReview;
    }

    @JsonProperty("SubjectAccessReview")
    public void setSubjectAccessReview(SubjectAccessReview subjectAccessReview) {
        this.subjectAccessReview = subjectAccessReview;
    }

    @JsonProperty("SubjectAccessReviewResponse")
    public SubjectAccessReviewResponse getSubjectAccessReviewResponse() {
        return subjectAccessReviewResponse;
    }

    @JsonProperty("SubjectAccessReviewResponse")
    public void setSubjectAccessReviewResponse(SubjectAccessReviewResponse subjectAccessReviewResponse) {
        this.subjectAccessReviewResponse = subjectAccessReviewResponse;
    }

    @JsonProperty("SubjectRulesReview")
    public SubjectRulesReview getSubjectRulesReview() {
        return subjectRulesReview;
    }

    @JsonProperty("SubjectRulesReview")
    public void setSubjectRulesReview(SubjectRulesReview subjectRulesReview) {
        this.subjectRulesReview = subjectRulesReview;
    }

    @JsonProperty("TagEvent")
    public TagEvent getTagEvent() {
        return tagEvent;
    }

    @JsonProperty("TagEvent")
    public void setTagEvent(TagEvent tagEvent) {
        this.tagEvent = tagEvent;
    }

    @JsonProperty("Template")
    public Template getTemplate() {
        return template;
    }

    @JsonProperty("Template")
    public void setTemplate(Template template) {
        this.template = template;
    }

    @JsonProperty("TemplateInstance")
    public TemplateInstance getTemplateInstance() {
        return templateInstance;
    }

    @JsonProperty("TemplateInstance")
    public void setTemplateInstance(TemplateInstance templateInstance) {
        this.templateInstance = templateInstance;
    }

    @JsonProperty("TemplateInstanceList")
    public TemplateInstanceList getTemplateInstanceList() {
        return templateInstanceList;
    }

    @JsonProperty("TemplateInstanceList")
    public void setTemplateInstanceList(TemplateInstanceList templateInstanceList) {
        this.templateInstanceList = templateInstanceList;
    }

    @JsonProperty("TemplateList")
    public TemplateList getTemplateList() {
        return templateList;
    }

    @JsonProperty("TemplateList")
    public void setTemplateList(TemplateList templateList) {
        this.templateList = templateList;
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

    @JsonProperty("User")
    public User getUser() {
        return user;
    }

    @JsonProperty("User")
    public void setUser(User user) {
        this.user = user;
    }

    @JsonProperty("UserIdentityMapping")
    public UserIdentityMapping getUserIdentityMapping() {
        return userIdentityMapping;
    }

    @JsonProperty("UserIdentityMapping")
    public void setUserIdentityMapping(UserIdentityMapping userIdentityMapping) {
        this.userIdentityMapping = userIdentityMapping;
    }

    @JsonProperty("UserList")
    public UserList getUserList() {
        return userList;
    }

    @JsonProperty("UserList")
    public void setUserList(UserList userList) {
        this.userList = userList;
    }

    @JsonProperty("UserOAuthAccessToken")
    public UserOAuthAccessToken getUserOAuthAccessToken() {
        return userOAuthAccessToken;
    }

    @JsonProperty("UserOAuthAccessToken")
    public void setUserOAuthAccessToken(UserOAuthAccessToken userOAuthAccessToken) {
        this.userOAuthAccessToken = userOAuthAccessToken;
    }

    @JsonProperty("UserOAuthAccessTokenList")
    public UserOAuthAccessTokenList getUserOAuthAccessTokenList() {
        return userOAuthAccessTokenList;
    }

    @JsonProperty("UserOAuthAccessTokenList")
    public void setUserOAuthAccessTokenList(UserOAuthAccessTokenList userOAuthAccessTokenList) {
        this.userOAuthAccessTokenList = userOAuthAccessTokenList;
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
