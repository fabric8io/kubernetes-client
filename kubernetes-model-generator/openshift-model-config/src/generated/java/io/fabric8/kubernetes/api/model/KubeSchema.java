
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.authorization.v1.ResourceAttributes;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.config.v1.APIServer;
import io.fabric8.openshift.api.model.config.v1.APIServerList;
import io.fabric8.openshift.api.model.config.v1.Authentication;
import io.fabric8.openshift.api.model.config.v1.AuthenticationList;
import io.fabric8.openshift.api.model.config.v1.Build;
import io.fabric8.openshift.api.model.config.v1.BuildList;
import io.fabric8.openshift.api.model.config.v1.ClusterOperator;
import io.fabric8.openshift.api.model.config.v1.ClusterOperatorList;
import io.fabric8.openshift.api.model.config.v1.ClusterVersion;
import io.fabric8.openshift.api.model.config.v1.ClusterVersionList;
import io.fabric8.openshift.api.model.config.v1.ConfigMapFileReference;
import io.fabric8.openshift.api.model.config.v1.Console;
import io.fabric8.openshift.api.model.config.v1.ConsoleList;
import io.fabric8.openshift.api.model.config.v1.DNS;
import io.fabric8.openshift.api.model.config.v1.DNSList;
import io.fabric8.openshift.api.model.config.v1.DNSZone;
import io.fabric8.openshift.api.model.config.v1.FeatureGate;
import io.fabric8.openshift.api.model.config.v1.FeatureGateList;
import io.fabric8.openshift.api.model.config.v1.Image;
import io.fabric8.openshift.api.model.config.v1.ImageContentPolicy;
import io.fabric8.openshift.api.model.config.v1.ImageContentPolicyList;
import io.fabric8.openshift.api.model.config.v1.ImageDigestMirrorSet;
import io.fabric8.openshift.api.model.config.v1.ImageDigestMirrorSetList;
import io.fabric8.openshift.api.model.config.v1.ImageList;
import io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSet;
import io.fabric8.openshift.api.model.config.v1.ImageTagMirrorSetList;
import io.fabric8.openshift.api.model.config.v1.Infrastructure;
import io.fabric8.openshift.api.model.config.v1.InfrastructureList;
import io.fabric8.openshift.api.model.config.v1.Ingress;
import io.fabric8.openshift.api.model.config.v1.IngressList;
import io.fabric8.openshift.api.model.config.v1.Network;
import io.fabric8.openshift.api.model.config.v1.NetworkList;
import io.fabric8.openshift.api.model.config.v1.OAuth;
import io.fabric8.openshift.api.model.config.v1.OAuthList;
import io.fabric8.openshift.api.model.config.v1.OperatorHub;
import io.fabric8.openshift.api.model.config.v1.OperatorHubList;
import io.fabric8.openshift.api.model.config.v1.Project;
import io.fabric8.openshift.api.model.config.v1.ProjectList;
import io.fabric8.openshift.api.model.config.v1.Proxy;
import io.fabric8.openshift.api.model.config.v1.ProxyList;
import io.fabric8.openshift.api.model.config.v1.Scheduler;
import io.fabric8.openshift.api.model.config.v1.SchedulerList;
import io.fabric8.openshift.api.model.config.v1.SecretNameReference;
import io.fabric8.openshift.api.model.config.v1.TLSProfileSpec;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private APIServer aPIServer;
    private APIServerList aPIServerList;
    private Authentication authentication;
    private AuthenticationList authenticationList;
    private KubernetesList baseKubernetesList;
    private Build build;
    private BuildList buildList;
    private ClusterOperator clusterOperator;
    private ClusterOperatorList clusterOperatorList;
    private ClusterVersion clusterVersion;
    private ClusterVersionList clusterVersionList;
    private ConfigMapFileReference configMapFileReference;
    private Console console;
    private ConsoleList consoleList;
    private DNS dns;
    private DNSList dNSList;
    private DNSZone dNSZone;
    private FeatureGate featureGate;
    private FeatureGateList featureGateList;
    private Image image;
    private ImageContentPolicy imageContentPolicy;
    private ImageContentPolicyList imageContentPolicyList;
    private ImageDigestMirrorSet imageDigestMirrorSet;
    private ImageDigestMirrorSetList imageDigestMirrorSetList;
    private ImageList imageList;
    private ImageTagMirrorSet imageTagMirrorSet;
    private ImageTagMirrorSetList imageTagMirrorSetList;
    private Info info;
    private Infrastructure infrastructure;
    private InfrastructureList infrastructureList;
    private Ingress ingress;
    private IngressList ingressList;
    private Network network;
    private NetworkList networkList;
    private OAuth oAuth;
    private OAuthList oAuthList;
    private ObjectMeta objectMeta;
    private OperatorHub operatorHub;
    private OperatorHubList operatorHubList;
    private Patch patch;
    private Project project;
    private ProjectList projectList;
    private Proxy proxy;
    private ProxyList proxyList;
    private ResourceAttributes resourceAttributes;
    private Scheduler scheduler;
    private SchedulerList schedulerList;
    private SecretNameReference secretNameReference;
    private Status status;
    private TLSProfileSpec tLSProfileSpec;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, APIServer aPIServer, APIServerList aPIServerList, Authentication authentication, AuthenticationList authenticationList, KubernetesList baseKubernetesList, Build build, BuildList buildList, ClusterOperator clusterOperator, ClusterOperatorList clusterOperatorList, ClusterVersion clusterVersion, ClusterVersionList clusterVersionList, ConfigMapFileReference configMapFileReference, Console console, ConsoleList consoleList, DNS dns, DNSList dNSList, DNSZone dNSZone, FeatureGate featureGate, FeatureGateList featureGateList, Image image, ImageContentPolicy imageContentPolicy, ImageContentPolicyList imageContentPolicyList, ImageDigestMirrorSet imageDigestMirrorSet, ImageDigestMirrorSetList imageDigestMirrorSetList, ImageList imageList, ImageTagMirrorSet imageTagMirrorSet, ImageTagMirrorSetList imageTagMirrorSetList, Info info, Infrastructure infrastructure, InfrastructureList infrastructureList, Ingress ingress, IngressList ingressList, Network network, NetworkList networkList, OAuth oAuth, OAuthList oAuthList, ObjectMeta objectMeta, OperatorHub operatorHub, OperatorHubList operatorHubList, Patch patch, Project project, ProjectList projectList, Proxy proxy, ProxyList proxyList, ResourceAttributes resourceAttributes, Scheduler scheduler, SchedulerList schedulerList, SecretNameReference secretNameReference, Status status, TLSProfileSpec tLSProfileSpec, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.aPIServer = aPIServer;
        this.aPIServerList = aPIServerList;
        this.authentication = authentication;
        this.authenticationList = authenticationList;
        this.baseKubernetesList = baseKubernetesList;
        this.build = build;
        this.buildList = buildList;
        this.clusterOperator = clusterOperator;
        this.clusterOperatorList = clusterOperatorList;
        this.clusterVersion = clusterVersion;
        this.clusterVersionList = clusterVersionList;
        this.configMapFileReference = configMapFileReference;
        this.console = console;
        this.consoleList = consoleList;
        this.dns = dns;
        this.dNSList = dNSList;
        this.dNSZone = dNSZone;
        this.featureGate = featureGate;
        this.featureGateList = featureGateList;
        this.image = image;
        this.imageContentPolicy = imageContentPolicy;
        this.imageContentPolicyList = imageContentPolicyList;
        this.imageDigestMirrorSet = imageDigestMirrorSet;
        this.imageDigestMirrorSetList = imageDigestMirrorSetList;
        this.imageList = imageList;
        this.imageTagMirrorSet = imageTagMirrorSet;
        this.imageTagMirrorSetList = imageTagMirrorSetList;
        this.info = info;
        this.infrastructure = infrastructure;
        this.infrastructureList = infrastructureList;
        this.ingress = ingress;
        this.ingressList = ingressList;
        this.network = network;
        this.networkList = networkList;
        this.oAuth = oAuth;
        this.oAuthList = oAuthList;
        this.objectMeta = objectMeta;
        this.operatorHub = operatorHub;
        this.operatorHubList = operatorHubList;
        this.patch = patch;
        this.project = project;
        this.projectList = projectList;
        this.proxy = proxy;
        this.proxyList = proxyList;
        this.resourceAttributes = resourceAttributes;
        this.scheduler = scheduler;
        this.schedulerList = schedulerList;
        this.secretNameReference = secretNameReference;
        this.status = status;
        this.tLSProfileSpec = tLSProfileSpec;
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

    @JsonProperty("Authentication")
    public Authentication getAuthentication() {
        return authentication;
    }

    @JsonProperty("Authentication")
    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    @JsonProperty("AuthenticationList")
    public AuthenticationList getAuthenticationList() {
        return authenticationList;
    }

    @JsonProperty("AuthenticationList")
    public void setAuthenticationList(AuthenticationList authenticationList) {
        this.authenticationList = authenticationList;
    }

    @JsonProperty("BaseKubernetesList")
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Build")
    public Build getBuild() {
        return build;
    }

    @JsonProperty("Build")
    public void setBuild(Build build) {
        this.build = build;
    }

    @JsonProperty("BuildList")
    public BuildList getBuildList() {
        return buildList;
    }

    @JsonProperty("BuildList")
    public void setBuildList(BuildList buildList) {
        this.buildList = buildList;
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

    @JsonProperty("ConfigMapFileReference")
    public ConfigMapFileReference getConfigMapFileReference() {
        return configMapFileReference;
    }

    @JsonProperty("ConfigMapFileReference")
    public void setConfigMapFileReference(ConfigMapFileReference configMapFileReference) {
        this.configMapFileReference = configMapFileReference;
    }

    @JsonProperty("Console")
    public Console getConsole() {
        return console;
    }

    @JsonProperty("Console")
    public void setConsole(Console console) {
        this.console = console;
    }

    @JsonProperty("ConsoleList")
    public ConsoleList getConsoleList() {
        return consoleList;
    }

    @JsonProperty("ConsoleList")
    public void setConsoleList(ConsoleList consoleList) {
        this.consoleList = consoleList;
    }

    @JsonProperty("DNS")
    public DNS getDns() {
        return dns;
    }

    @JsonProperty("DNS")
    public void setDns(DNS dns) {
        this.dns = dns;
    }

    @JsonProperty("DNSList")
    public DNSList getDNSList() {
        return dNSList;
    }

    @JsonProperty("DNSList")
    public void setDNSList(DNSList dNSList) {
        this.dNSList = dNSList;
    }

    @JsonProperty("DNSZone")
    public DNSZone getDNSZone() {
        return dNSZone;
    }

    @JsonProperty("DNSZone")
    public void setDNSZone(DNSZone dNSZone) {
        this.dNSZone = dNSZone;
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

    @JsonProperty("Image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("Image")
    public void setImage(Image image) {
        this.image = image;
    }

    @JsonProperty("ImageContentPolicy")
    public ImageContentPolicy getImageContentPolicy() {
        return imageContentPolicy;
    }

    @JsonProperty("ImageContentPolicy")
    public void setImageContentPolicy(ImageContentPolicy imageContentPolicy) {
        this.imageContentPolicy = imageContentPolicy;
    }

    @JsonProperty("ImageContentPolicyList")
    public ImageContentPolicyList getImageContentPolicyList() {
        return imageContentPolicyList;
    }

    @JsonProperty("ImageContentPolicyList")
    public void setImageContentPolicyList(ImageContentPolicyList imageContentPolicyList) {
        this.imageContentPolicyList = imageContentPolicyList;
    }

    @JsonProperty("ImageDigestMirrorSet")
    public ImageDigestMirrorSet getImageDigestMirrorSet() {
        return imageDigestMirrorSet;
    }

    @JsonProperty("ImageDigestMirrorSet")
    public void setImageDigestMirrorSet(ImageDigestMirrorSet imageDigestMirrorSet) {
        this.imageDigestMirrorSet = imageDigestMirrorSet;
    }

    @JsonProperty("ImageDigestMirrorSetList")
    public ImageDigestMirrorSetList getImageDigestMirrorSetList() {
        return imageDigestMirrorSetList;
    }

    @JsonProperty("ImageDigestMirrorSetList")
    public void setImageDigestMirrorSetList(ImageDigestMirrorSetList imageDigestMirrorSetList) {
        this.imageDigestMirrorSetList = imageDigestMirrorSetList;
    }

    @JsonProperty("ImageList")
    public ImageList getImageList() {
        return imageList;
    }

    @JsonProperty("ImageList")
    public void setImageList(ImageList imageList) {
        this.imageList = imageList;
    }

    @JsonProperty("ImageTagMirrorSet")
    public ImageTagMirrorSet getImageTagMirrorSet() {
        return imageTagMirrorSet;
    }

    @JsonProperty("ImageTagMirrorSet")
    public void setImageTagMirrorSet(ImageTagMirrorSet imageTagMirrorSet) {
        this.imageTagMirrorSet = imageTagMirrorSet;
    }

    @JsonProperty("ImageTagMirrorSetList")
    public ImageTagMirrorSetList getImageTagMirrorSetList() {
        return imageTagMirrorSetList;
    }

    @JsonProperty("ImageTagMirrorSetList")
    public void setImageTagMirrorSetList(ImageTagMirrorSetList imageTagMirrorSetList) {
        this.imageTagMirrorSetList = imageTagMirrorSetList;
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

    @JsonProperty("Network")
    public Network getNetwork() {
        return network;
    }

    @JsonProperty("Network")
    public void setNetwork(Network network) {
        this.network = network;
    }

    @JsonProperty("NetworkList")
    public NetworkList getNetworkList() {
        return networkList;
    }

    @JsonProperty("NetworkList")
    public void setNetworkList(NetworkList networkList) {
        this.networkList = networkList;
    }

    @JsonProperty("OAuth")
    public OAuth getOAuth() {
        return oAuth;
    }

    @JsonProperty("OAuth")
    public void setOAuth(OAuth oAuth) {
        this.oAuth = oAuth;
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
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
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

    @JsonProperty("ResourceAttributes")
    public ResourceAttributes getResourceAttributes() {
        return resourceAttributes;
    }

    @JsonProperty("ResourceAttributes")
    public void setResourceAttributes(ResourceAttributes resourceAttributes) {
        this.resourceAttributes = resourceAttributes;
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

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("TLSProfileSpec")
    public TLSProfileSpec getTLSProfileSpec() {
        return tLSProfileSpec;
    }

    @JsonProperty("TLSProfileSpec")
    public void setTLSProfileSpec(TLSProfileSpec tLSProfileSpec) {
        this.tLSProfileSpec = tLSProfileSpec;
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

    public void setAdditionalProperties(Map<java.lang.String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
