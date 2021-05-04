
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
import io.fabric8.kubernetes.api.model.rbac.AggregationRule;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.APIServer;
import io.fabric8.openshift.api.model.APIServerList;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuota;
import io.fabric8.openshift.api.model.AppliedClusterResourceQuotaList;
import io.fabric8.openshift.api.model.BuildConfigList;
import io.fabric8.openshift.api.model.BuildList;
import io.fabric8.openshift.api.model.BuildRequest;
import io.fabric8.openshift.api.model.ClusterNetwork;
import io.fabric8.openshift.api.model.ClusterNetworkList;
import io.fabric8.openshift.api.model.ClusterOperator;
import io.fabric8.openshift.api.model.ClusterOperatorList;
import io.fabric8.openshift.api.model.ClusterResourceQuota;
import io.fabric8.openshift.api.model.ClusterResourceQuotaList;
import io.fabric8.openshift.api.model.ClusterRole;
import io.fabric8.openshift.api.model.ClusterRoleBinding;
import io.fabric8.openshift.api.model.ClusterRoleBindingList;
import io.fabric8.openshift.api.model.ClusterRoleList;
import io.fabric8.openshift.api.model.ClusterRoleScopeRestriction;
import io.fabric8.openshift.api.model.ClusterVersion;
import io.fabric8.openshift.api.model.ClusterVersionList;
import io.fabric8.openshift.api.model.ConfigMapFileReference;
import io.fabric8.openshift.api.model.DNSZone;
import io.fabric8.openshift.api.model.DeploymentConfig;
import io.fabric8.openshift.api.model.DeploymentConfigList;
import io.fabric8.openshift.api.model.EgressNetworkPolicy;
import io.fabric8.openshift.api.model.EgressNetworkPolicyList;
import io.fabric8.openshift.api.model.FeatureGate;
import io.fabric8.openshift.api.model.FeatureGateList;
import io.fabric8.openshift.api.model.Group;
import io.fabric8.openshift.api.model.GroupList;
import io.fabric8.openshift.api.model.Identity;
import io.fabric8.openshift.api.model.IdentityList;
import io.fabric8.openshift.api.model.ImageList;
import io.fabric8.openshift.api.model.ImageStreamImage;
import io.fabric8.openshift.api.model.ImageStreamImport;
import io.fabric8.openshift.api.model.ImageStreamList;
import io.fabric8.openshift.api.model.ImageStreamMapping;
import io.fabric8.openshift.api.model.ImageStreamTagList;
import io.fabric8.openshift.api.model.ImageTag;
import io.fabric8.openshift.api.model.ImageTagList;
import io.fabric8.openshift.api.model.Infrastructure;
import io.fabric8.openshift.api.model.InfrastructureList;
import io.fabric8.openshift.api.model.Ingress;
import io.fabric8.openshift.api.model.IngressList;
import io.fabric8.openshift.api.model.LocalResourceAccessReview;
import io.fabric8.openshift.api.model.LocalSubjectAccessReview;
import io.fabric8.openshift.api.model.NetNamespace;
import io.fabric8.openshift.api.model.NetNamespaceList;
import io.fabric8.openshift.api.model.OAuth;
import io.fabric8.openshift.api.model.OAuthAccessToken;
import io.fabric8.openshift.api.model.OAuthAccessTokenList;
import io.fabric8.openshift.api.model.OAuthAuthorizeToken;
import io.fabric8.openshift.api.model.OAuthAuthorizeTokenList;
import io.fabric8.openshift.api.model.OAuthClient;
import io.fabric8.openshift.api.model.OAuthClientAuthorization;
import io.fabric8.openshift.api.model.OAuthClientAuthorizationList;
import io.fabric8.openshift.api.model.OAuthClientList;
import io.fabric8.openshift.api.model.OAuthList;
import io.fabric8.openshift.api.model.OperatorHub;
import io.fabric8.openshift.api.model.OperatorHubList;
import io.fabric8.openshift.api.model.PodSecurityPolicyReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySelfSubjectReview;
import io.fabric8.openshift.api.model.PodSecurityPolicySubjectReview;
import io.fabric8.openshift.api.model.Project;
import io.fabric8.openshift.api.model.ProjectList;
import io.fabric8.openshift.api.model.ProjectRequest;
import io.fabric8.openshift.api.model.Proxy;
import io.fabric8.openshift.api.model.ProxyList;
import io.fabric8.openshift.api.model.RangeAllocation;
import io.fabric8.openshift.api.model.RangeAllocationList;
import io.fabric8.openshift.api.model.ResourceAccessReview;
import io.fabric8.openshift.api.model.Role;
import io.fabric8.openshift.api.model.RoleBinding;
import io.fabric8.openshift.api.model.RoleBindingList;
import io.fabric8.openshift.api.model.RoleBindingRestriction;
import io.fabric8.openshift.api.model.RoleBindingRestrictionSpec;
import io.fabric8.openshift.api.model.RoleList;
import io.fabric8.openshift.api.model.Route;
import io.fabric8.openshift.api.model.RouteList;
import io.fabric8.openshift.api.model.Scheduler;
import io.fabric8.openshift.api.model.SchedulerList;
import io.fabric8.openshift.api.model.SecretNameReference;
import io.fabric8.openshift.api.model.SecurityContextConstraints;
import io.fabric8.openshift.api.model.SecurityContextConstraintsList;
import io.fabric8.openshift.api.model.SelfSubjectRulesReview;
import io.fabric8.openshift.api.model.SubjectAccessReview;
import io.fabric8.openshift.api.model.SubjectAccessReviewResponse;
import io.fabric8.openshift.api.model.SubjectRulesReview;
import io.fabric8.openshift.api.model.TLSProfileSpec;
import io.fabric8.openshift.api.model.TagEvent;
import io.fabric8.openshift.api.model.Template;
import io.fabric8.openshift.api.model.TemplateList;
import io.fabric8.openshift.api.model.User;
import io.fabric8.openshift.api.model.UserList;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVersion",
    "kind",
    "metadata",
    "APIGroup",
    "APIGroupList",
    "APIServer",
    "APIServerList",
    "AggregationRule",
    "AppliedClusterResourceQuota",
    "AppliedClusterResourceQuotaList",
    "BaseKubernetesList",
    "BuildConfigList",
    "BuildList",
    "BuildRequest",
    "ClusterNetwork",
    "ClusterNetworkList",
    "ClusterOperator",
    "ClusterOperatorList",
    "ClusterResourceQuota",
    "ClusterResourceQuotaList",
    "ClusterVersion",
    "ClusterVersionList",
    "Config",
    "ConfigMapFileReference",
    "CreateOptions",
    "DNSZone",
    "DeleteOptions",
    "DeploymentConfig",
    "DeploymentConfigList",
    "EgressNetworkPolicy",
    "EgressNetworkPolicyList",
    "FeatureGate",
    "FeatureGateList",
    "GetOptions",
    "Group",
    "GroupList",
    "Identity",
    "IdentityList",
    "ImageList",
    "ImageStreamImage",
    "ImageStreamImport",
    "ImageStreamList",
    "ImageStreamMapping",
    "ImageStreamTagList",
    "ImageTag",
    "ImageTagList",
    "Info",
    "Infrastructure",
    "InfrastructureList",
    "Ingress",
    "IngressList",
    "ListOptions",
    "LocalResourceAccessReview",
    "LocalSubjectAccessReview",
    "NetNamespace",
    "NetNamespaceList",
    "OAuth",
    "OAuthAccessToken",
    "OAuthAccessTokenList",
    "OAuthAuthorizeToken",
    "OAuthAuthorizeTokenList",
    "OAuthClient",
    "OAuthClientAuthorization",
    "OAuthClientAuthorizationList",
    "OAuthClientList",
    "OAuthList",
    "ObjectMeta",
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
    "OperatorHub",
    "OperatorHubList",
    "Patch",
    "PatchOptions",
    "PodSecurityPolicyReview",
    "PodSecurityPolicySelfSubjectReview",
    "PodSecurityPolicySubjectReview",
    "Project",
    "ProjectList",
    "ProjectRequest",
    "Proxy",
    "ProxyList",
    "Quantity",
    "RangeAllocation",
    "RangeAllocationList",
    "ResourceAccessReview",
    "RootPaths",
    "Route",
    "RouteList",
    "Scheduler",
    "SchedulerList",
    "SecretNameReference",
    "SecurityContextConstraints",
    "SecurityContextConstraintsList",
    "SelfSubjectRulesReview",
    "Status",
    "SubjectAccessReview",
    "SubjectAccessReviewResponse",
    "SubjectRulesReview",
    "TLSProfileSpec",
    "TagEvent",
    "Template",
    "TemplateList",
    "Time",
    "TokenReview",
    "TypeMeta",
    "UpdateOptions",
    "User",
    "UserList"
})
@ToString
@EqualsAndHashCode
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
public class KubeSchema {

    @JsonProperty("APIGroup")
    private APIGroup aPIGroup;
    @JsonProperty("APIGroupList")
    private APIGroupList aPIGroupList;
    @JsonProperty("APIServer")
    private APIServer aPIServer;
    @JsonProperty("APIServerList")
    private APIServerList aPIServerList;
    @JsonProperty("AggregationRule")
    private AggregationRule aggregationRule;
    @JsonProperty("AppliedClusterResourceQuota")
    private AppliedClusterResourceQuota appliedClusterResourceQuota;
    @JsonProperty("AppliedClusterResourceQuotaList")
    private AppliedClusterResourceQuotaList appliedClusterResourceQuotaList;
    @JsonProperty("BaseKubernetesList")
    private BaseKubernetesList baseKubernetesList;
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
    @JsonProperty("ClusterOperator")
    private ClusterOperator clusterOperator;
    @JsonProperty("ClusterOperatorList")
    private ClusterOperatorList clusterOperatorList;
    @JsonProperty("ClusterResourceQuota")
    private ClusterResourceQuota clusterResourceQuota;
    @JsonProperty("ClusterResourceQuotaList")
    private ClusterResourceQuotaList clusterResourceQuotaList;
    @JsonProperty("ClusterVersion")
    private ClusterVersion clusterVersion;
    @JsonProperty("ClusterVersionList")
    private ClusterVersionList clusterVersionList;
    @JsonProperty("Config")
    private Config config;
    @JsonProperty("ConfigMapFileReference")
    private ConfigMapFileReference configMapFileReference;
    @JsonProperty("CreateOptions")
    private CreateOptions createOptions;
    @JsonProperty("DNSZone")
    private DNSZone dNSZone;
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
    @JsonProperty("FeatureGate")
    private FeatureGate featureGate;
    @JsonProperty("FeatureGateList")
    private FeatureGateList featureGateList;
    @JsonProperty("GetOptions")
    private GetOptions getOptions;
    @JsonProperty("Group")
    private Group group;
    @JsonProperty("GroupList")
    private GroupList groupList;
    @JsonProperty("Identity")
    private Identity identity;
    @JsonProperty("IdentityList")
    private IdentityList identityList;
    @JsonProperty("ImageList")
    private ImageList imageList;
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
    @JsonProperty("Infrastructure")
    private Infrastructure infrastructure;
    @JsonProperty("InfrastructureList")
    private InfrastructureList infrastructureList;
    @JsonProperty("Ingress")
    private Ingress ingress;
    @JsonProperty("IngressList")
    private IngressList ingressList;
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
    @JsonProperty("OAuth")
    private OAuth oAuth;
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
    @JsonProperty("OAuthList")
    private OAuthList oAuthList;
    @JsonProperty("ObjectMeta")
    private io.fabric8.kubernetes.api.model.ObjectMeta objectMeta;
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
    @JsonProperty("OperatorHub")
    private OperatorHub operatorHub;
    @JsonProperty("OperatorHubList")
    private OperatorHubList operatorHubList;
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
    @JsonProperty("Proxy")
    private Proxy proxy;
    @JsonProperty("ProxyList")
    private ProxyList proxyList;
    @JsonProperty("Quantity")
    private Quantity quantity;
    @JsonProperty("RangeAllocation")
    private RangeAllocation rangeAllocation;
    @JsonProperty("RangeAllocationList")
    private RangeAllocationList rangeAllocationList;
    @JsonProperty("ResourceAccessReview")
    private ResourceAccessReview resourceAccessReview;
    @JsonProperty("RootPaths")
    private RootPaths rootPaths;
    @JsonProperty("Route")
    private Route route;
    @JsonProperty("RouteList")
    private RouteList routeList;
    @JsonProperty("Scheduler")
    private Scheduler scheduler;
    @JsonProperty("SchedulerList")
    private SchedulerList schedulerList;
    @JsonProperty("SecretNameReference")
    private SecretNameReference secretNameReference;
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
    @JsonProperty("TLSProfileSpec")
    private TLSProfileSpec tLSProfileSpec;
    @JsonProperty("TagEvent")
    private TagEvent tagEvent;
    @JsonProperty("Template")
    private Template template;
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
    @JsonProperty("UserList")
    private UserList userList;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    /**
     * 
     * @param listOptions
     * @param aPIGroupList
     * @param schedulerList
     * @param aggregationRule
     * @param openshiftClusterRole
     * @param patch
     * @param securityContextConstraintsList
     * @param oAuthClientAuthorizationList
     * @param userList
     * @param oAuthList
     * @param openshiftClusterRoleBindingList
     * @param appliedClusterResourceQuota
     * @param deleteOptions
     * @param clusterResourceQuotaList
     * @param operatorHubList
     * @param clusterVersionList
     * @param imageStreamImage
     * @param groupList
     * @param tagEvent
     * @param imageTagList
     * @param projectRequest
     * @param clusterResourceQuota
     * @param proxy
     * @param route
     * @param tokenReview
     * @param getOptions
     * @param imageList
     * @param status
     * @param template
     * @param buildRequest
     * @param rangeAllocationList
     * @param ingressList
     * @param selfSubjectRulesReview
     * @param baseKubernetesList
     * @param subjectAccessReviewResponse
     * @param clusterNetwork
     * @param openshiftRoleBindingList
     * @param subjectRulesReview
     * @param egressNetworkPolicyList
     * @param identity
     * @param oAuthAccessTokenList
     * @param buildList
     * @param rootPaths
     * @param featureGate
     * @param oAuthClientList
     * @param patchOptions
     * @param oAuthAuthorizeTokenList
     * @param aPIServerList
     * @param imageStreamMapping
     * @param openshiftRoleBindingRestrictionSpec
     * @param rangeAllocation
     * @param createOptions
     * @param openshiftRoleBindingRestriction
     * @param aPIGroup
     * @param objectMeta
     * @param oAuthClient
     * @param config
     * @param routeList
     * @param securityContextConstraints
     * @param resourceAccessReview
     * @param secretNameReference
     * @param openshiftRole
     * @param infrastructureList
     * @param netNamespaceList
     * @param openshiftClusterRoleScopeRestriction
     * @param project
     * @param oAuth
     * @param clusterOperator
     * @param podSecurityPolicyReview
     * @param deploymentConfig
     * @param openshiftClusterRoleBinding
     * @param egressNetworkPolicy
     * @param group
     * @param info
     * @param projectList
     * @param oAuthAccessToken
     * @param openshiftClusterRoleList
     * @param operatorHub
     * @param imageStreamImport
     * @param aPIServer
     * @param imageStreamList
     * @param oAuthClientAuthorization
     * @param localResourceAccessReview
     * @param imageStreamTagList
     * @param openshiftRoleList
     * @param dNSZone
     * @param buildConfigList
     * @param ingress
     * @param proxyList
     * @param identityList
     * @param configMapFileReference
     * @param subjectAccessReview
     * @param openshiftRoleBinding
     * @param featureGateList
     * @param clusterNetworkList
     * @param podSecurityPolicySubjectReview
     * @param updateOptions
     * @param clusterVersion
     * @param scheduler
     * @param netNamespace
     * @param oAuthAuthorizeToken
     * @param clusterOperatorList
     * @param appliedClusterResourceQuotaList
     * @param localSubjectAccessReview
     * @param quantity
     * @param templateList
     * @param deploymentConfigList
     * @param podSecurityPolicySelfSubjectReview
     * @param typeMeta
     * @param infrastructure
     * @param tLSProfileSpec
     * @param time
     * @param imageTag
     * @param user
     */
    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, APIServer aPIServer, APIServerList aPIServerList, AggregationRule aggregationRule, AppliedClusterResourceQuota appliedClusterResourceQuota, AppliedClusterResourceQuotaList appliedClusterResourceQuotaList, BaseKubernetesList baseKubernetesList, BuildConfigList buildConfigList, BuildList buildList, BuildRequest buildRequest, ClusterNetwork clusterNetwork, ClusterNetworkList clusterNetworkList, ClusterOperator clusterOperator, ClusterOperatorList clusterOperatorList, ClusterResourceQuota clusterResourceQuota, ClusterResourceQuotaList clusterResourceQuotaList, ClusterVersion clusterVersion, ClusterVersionList clusterVersionList, Config config, ConfigMapFileReference configMapFileReference, CreateOptions createOptions, DNSZone dNSZone, DeleteOptions deleteOptions, DeploymentConfig deploymentConfig, DeploymentConfigList deploymentConfigList, EgressNetworkPolicy egressNetworkPolicy, EgressNetworkPolicyList egressNetworkPolicyList, FeatureGate featureGate, FeatureGateList featureGateList, GetOptions getOptions, Group group, GroupList groupList, Identity identity, IdentityList identityList, ImageList imageList, ImageStreamImage imageStreamImage, ImageStreamImport imageStreamImport, ImageStreamList imageStreamList, ImageStreamMapping imageStreamMapping, ImageStreamTagList imageStreamTagList, ImageTag imageTag, ImageTagList imageTagList, Info info, Infrastructure infrastructure, InfrastructureList infrastructureList, Ingress ingress, IngressList ingressList, ListOptions listOptions, LocalResourceAccessReview localResourceAccessReview, LocalSubjectAccessReview localSubjectAccessReview, NetNamespace netNamespace, NetNamespaceList netNamespaceList, OAuth oAuth, OAuthAccessToken oAuthAccessToken, OAuthAccessTokenList oAuthAccessTokenList, OAuthAuthorizeToken oAuthAuthorizeToken, OAuthAuthorizeTokenList oAuthAuthorizeTokenList, OAuthClient oAuthClient, OAuthClientAuthorization oAuthClientAuthorization, OAuthClientAuthorizationList oAuthClientAuthorizationList, OAuthClientList oAuthClientList, OAuthList oAuthList, io.fabric8.kubernetes.api.model.ObjectMeta objectMeta, ClusterRole openshiftClusterRole, ClusterRoleBinding openshiftClusterRoleBinding, ClusterRoleBindingList openshiftClusterRoleBindingList, ClusterRoleList openshiftClusterRoleList, ClusterRoleScopeRestriction openshiftClusterRoleScopeRestriction, Role openshiftRole, RoleBinding openshiftRoleBinding, RoleBindingList openshiftRoleBindingList, RoleBindingRestriction openshiftRoleBindingRestriction, RoleBindingRestrictionSpec openshiftRoleBindingRestrictionSpec, RoleList openshiftRoleList, OperatorHub operatorHub, OperatorHubList operatorHubList, Patch patch, PatchOptions patchOptions, PodSecurityPolicyReview podSecurityPolicyReview, PodSecurityPolicySelfSubjectReview podSecurityPolicySelfSubjectReview, PodSecurityPolicySubjectReview podSecurityPolicySubjectReview, Project project, ProjectList projectList, ProjectRequest projectRequest, Proxy proxy, ProxyList proxyList, Quantity quantity, RangeAllocation rangeAllocation, RangeAllocationList rangeAllocationList, ResourceAccessReview resourceAccessReview, RootPaths rootPaths, Route route, RouteList routeList, Scheduler scheduler, SchedulerList schedulerList, SecretNameReference secretNameReference, SecurityContextConstraints securityContextConstraints, SecurityContextConstraintsList securityContextConstraintsList, SelfSubjectRulesReview selfSubjectRulesReview, Status status, SubjectAccessReview subjectAccessReview, SubjectAccessReviewResponse subjectAccessReviewResponse, SubjectRulesReview subjectRulesReview, TLSProfileSpec tLSProfileSpec, TagEvent tagEvent, Template template, TemplateList templateList, String time, TokenReview tokenReview, TypeMeta typeMeta, UpdateOptions updateOptions, User user, UserList userList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.aPIServer = aPIServer;
        this.aPIServerList = aPIServerList;
        this.aggregationRule = aggregationRule;
        this.appliedClusterResourceQuota = appliedClusterResourceQuota;
        this.appliedClusterResourceQuotaList = appliedClusterResourceQuotaList;
        this.baseKubernetesList = baseKubernetesList;
        this.buildConfigList = buildConfigList;
        this.buildList = buildList;
        this.buildRequest = buildRequest;
        this.clusterNetwork = clusterNetwork;
        this.clusterNetworkList = clusterNetworkList;
        this.clusterOperator = clusterOperator;
        this.clusterOperatorList = clusterOperatorList;
        this.clusterResourceQuota = clusterResourceQuota;
        this.clusterResourceQuotaList = clusterResourceQuotaList;
        this.clusterVersion = clusterVersion;
        this.clusterVersionList = clusterVersionList;
        this.config = config;
        this.configMapFileReference = configMapFileReference;
        this.createOptions = createOptions;
        this.dNSZone = dNSZone;
        this.deleteOptions = deleteOptions;
        this.deploymentConfig = deploymentConfig;
        this.deploymentConfigList = deploymentConfigList;
        this.egressNetworkPolicy = egressNetworkPolicy;
        this.egressNetworkPolicyList = egressNetworkPolicyList;
        this.featureGate = featureGate;
        this.featureGateList = featureGateList;
        this.getOptions = getOptions;
        this.group = group;
        this.groupList = groupList;
        this.identity = identity;
        this.identityList = identityList;
        this.imageList = imageList;
        this.imageStreamImage = imageStreamImage;
        this.imageStreamImport = imageStreamImport;
        this.imageStreamList = imageStreamList;
        this.imageStreamMapping = imageStreamMapping;
        this.imageStreamTagList = imageStreamTagList;
        this.imageTag = imageTag;
        this.imageTagList = imageTagList;
        this.info = info;
        this.infrastructure = infrastructure;
        this.infrastructureList = infrastructureList;
        this.ingress = ingress;
        this.ingressList = ingressList;
        this.listOptions = listOptions;
        this.localResourceAccessReview = localResourceAccessReview;
        this.localSubjectAccessReview = localSubjectAccessReview;
        this.netNamespace = netNamespace;
        this.netNamespaceList = netNamespaceList;
        this.oAuth = oAuth;
        this.oAuthAccessToken = oAuthAccessToken;
        this.oAuthAccessTokenList = oAuthAccessTokenList;
        this.oAuthAuthorizeToken = oAuthAuthorizeToken;
        this.oAuthAuthorizeTokenList = oAuthAuthorizeTokenList;
        this.oAuthClient = oAuthClient;
        this.oAuthClientAuthorization = oAuthClientAuthorization;
        this.oAuthClientAuthorizationList = oAuthClientAuthorizationList;
        this.oAuthClientList = oAuthClientList;
        this.oAuthList = oAuthList;
        this.objectMeta = objectMeta;
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
        this.operatorHub = operatorHub;
        this.operatorHubList = operatorHubList;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.podSecurityPolicyReview = podSecurityPolicyReview;
        this.podSecurityPolicySelfSubjectReview = podSecurityPolicySelfSubjectReview;
        this.podSecurityPolicySubjectReview = podSecurityPolicySubjectReview;
        this.project = project;
        this.projectList = projectList;
        this.projectRequest = projectRequest;
        this.proxy = proxy;
        this.proxyList = proxyList;
        this.quantity = quantity;
        this.rangeAllocation = rangeAllocation;
        this.rangeAllocationList = rangeAllocationList;
        this.resourceAccessReview = resourceAccessReview;
        this.rootPaths = rootPaths;
        this.route = route;
        this.routeList = routeList;
        this.scheduler = scheduler;
        this.schedulerList = schedulerList;
        this.secretNameReference = secretNameReference;
        this.securityContextConstraints = securityContextConstraints;
        this.securityContextConstraintsList = securityContextConstraintsList;
        this.selfSubjectRulesReview = selfSubjectRulesReview;
        this.status = status;
        this.subjectAccessReview = subjectAccessReview;
        this.subjectAccessReviewResponse = subjectAccessReviewResponse;
        this.subjectRulesReview = subjectRulesReview;
        this.tLSProfileSpec = tLSProfileSpec;
        this.tagEvent = tagEvent;
        this.template = template;
        this.templateList = templateList;
        this.time = time;
        this.tokenReview = tokenReview;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.user = user;
        this.userList = userList;
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

    @JsonProperty("APIServer")
    public APIServer getAPIServer() {
        return aPIServer;
    }

    @JsonProperty("APIServer")
    public void setAPIServer(APIServer aPIServer) {
        this.aPIServer = aPIServer;
    }

    @JsonProperty("APIServerList")
    public APIServerList getAPIServerList() {
        return aPIServerList;
    }

    @JsonProperty("APIServerList")
    public void setAPIServerList(APIServerList aPIServerList) {
        this.aPIServerList = aPIServerList;
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
    public BaseKubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(BaseKubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
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

    @JsonProperty("ClusterOperator")
    public ClusterOperator getClusterOperator() {
        return clusterOperator;
    }

    @JsonProperty("ClusterOperator")
    public void setClusterOperator(ClusterOperator clusterOperator) {
        this.clusterOperator = clusterOperator;
    }

    @JsonProperty("ClusterOperatorList")
    public ClusterOperatorList getClusterOperatorList() {
        return clusterOperatorList;
    }

    @JsonProperty("ClusterOperatorList")
    public void setClusterOperatorList(ClusterOperatorList clusterOperatorList) {
        this.clusterOperatorList = clusterOperatorList;
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

    @JsonProperty("ClusterVersion")
    public ClusterVersion getClusterVersion() {
        return clusterVersion;
    }

    @JsonProperty("ClusterVersion")
    public void setClusterVersion(ClusterVersion clusterVersion) {
        this.clusterVersion = clusterVersion;
    }

    @JsonProperty("ClusterVersionList")
    public ClusterVersionList getClusterVersionList() {
        return clusterVersionList;
    }

    @JsonProperty("ClusterVersionList")
    public void setClusterVersionList(ClusterVersionList clusterVersionList) {
        this.clusterVersionList = clusterVersionList;
    }

    @JsonProperty("Config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("Config")
    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("ConfigMapFileReference")
    public ConfigMapFileReference getConfigMapFileReference() {
        return configMapFileReference;
    }

    @JsonProperty("ConfigMapFileReference")
    public void setConfigMapFileReference(ConfigMapFileReference configMapFileReference) {
        this.configMapFileReference = configMapFileReference;
    }

    @JsonProperty("CreateOptions")
    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    @JsonProperty("CreateOptions")
    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    @JsonProperty("DNSZone")
    public DNSZone getDNSZone() {
        return dNSZone;
    }

    @JsonProperty("DNSZone")
    public void setDNSZone(DNSZone dNSZone) {
        this.dNSZone = dNSZone;
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

    @JsonProperty("FeatureGate")
    public FeatureGate getFeatureGate() {
        return featureGate;
    }

    @JsonProperty("FeatureGate")
    public void setFeatureGate(FeatureGate featureGate) {
        this.featureGate = featureGate;
    }

    @JsonProperty("FeatureGateList")
    public FeatureGateList getFeatureGateList() {
        return featureGateList;
    }

    @JsonProperty("FeatureGateList")
    public void setFeatureGateList(FeatureGateList featureGateList) {
        this.featureGateList = featureGateList;
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

    @JsonProperty("Infrastructure")
    public Infrastructure getInfrastructure() {
        return infrastructure;
    }

    @JsonProperty("Infrastructure")
    public void setInfrastructure(Infrastructure infrastructure) {
        this.infrastructure = infrastructure;
    }

    @JsonProperty("InfrastructureList")
    public InfrastructureList getInfrastructureList() {
        return infrastructureList;
    }

    @JsonProperty("InfrastructureList")
    public void setInfrastructureList(InfrastructureList infrastructureList) {
        this.infrastructureList = infrastructureList;
    }

    @JsonProperty("Ingress")
    public Ingress getIngress() {
        return ingress;
    }

    @JsonProperty("Ingress")
    public void setIngress(Ingress ingress) {
        this.ingress = ingress;
    }

    @JsonProperty("IngressList")
    public IngressList getIngressList() {
        return ingressList;
    }

    @JsonProperty("IngressList")
    public void setIngressList(IngressList ingressList) {
        this.ingressList = ingressList;
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

    @JsonProperty("OAuth")
    public OAuth getOAuth() {
        return oAuth;
    }

    @JsonProperty("OAuth")
    public void setOAuth(OAuth oAuth) {
        this.oAuth = oAuth;
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

    @JsonProperty("OAuthList")
    public OAuthList getOAuthList() {
        return oAuthList;
    }

    @JsonProperty("OAuthList")
    public void setOAuthList(OAuthList oAuthList) {
        this.oAuthList = oAuthList;
    }

    @JsonProperty("ObjectMeta")
    public io.fabric8.kubernetes.api.model.ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(io.fabric8.kubernetes.api.model.ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
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

    @JsonProperty("OperatorHub")
    public OperatorHub getOperatorHub() {
        return operatorHub;
    }

    @JsonProperty("OperatorHub")
    public void setOperatorHub(OperatorHub operatorHub) {
        this.operatorHub = operatorHub;
    }

    @JsonProperty("OperatorHubList")
    public OperatorHubList getOperatorHubList() {
        return operatorHubList;
    }

    @JsonProperty("OperatorHubList")
    public void setOperatorHubList(OperatorHubList operatorHubList) {
        this.operatorHubList = operatorHubList;
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

    @JsonProperty("Proxy")
    public Proxy getProxy() {
        return proxy;
    }

    @JsonProperty("Proxy")
    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @JsonProperty("ProxyList")
    public ProxyList getProxyList() {
        return proxyList;
    }

    @JsonProperty("ProxyList")
    public void setProxyList(ProxyList proxyList) {
        this.proxyList = proxyList;
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

    @JsonProperty("Scheduler")
    public Scheduler getScheduler() {
        return scheduler;
    }

    @JsonProperty("Scheduler")
    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @JsonProperty("SchedulerList")
    public SchedulerList getSchedulerList() {
        return schedulerList;
    }

    @JsonProperty("SchedulerList")
    public void setSchedulerList(SchedulerList schedulerList) {
        this.schedulerList = schedulerList;
    }

    @JsonProperty("SecretNameReference")
    public SecretNameReference getSecretNameReference() {
        return secretNameReference;
    }

    @JsonProperty("SecretNameReference")
    public void setSecretNameReference(SecretNameReference secretNameReference) {
        this.secretNameReference = secretNameReference;
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

    @JsonProperty("TLSProfileSpec")
    public TLSProfileSpec getTLSProfileSpec() {
        return tLSProfileSpec;
    }

    @JsonProperty("TLSProfileSpec")
    public void setTLSProfileSpec(TLSProfileSpec tLSProfileSpec) {
        this.tLSProfileSpec = tLSProfileSpec;
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

    @JsonProperty("UserList")
    public UserList getUserList() {
        return userList;
    }

    @JsonProperty("UserList")
    public void setUserList(UserList userList) {
        this.userList = userList;
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
