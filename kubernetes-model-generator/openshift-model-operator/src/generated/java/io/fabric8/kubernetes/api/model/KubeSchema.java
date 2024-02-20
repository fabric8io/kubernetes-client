
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.config.v1.ConfigMapFileReference;
import io.fabric8.openshift.api.model.config.v1.SecretNameReference;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheck;
import io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.PodNetworkConnectivityCheckList;
import io.fabric8.openshift.api.model.operator.v1.Authentication;
import io.fabric8.openshift.api.model.operator.v1.AuthenticationList;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotController;
import io.fabric8.openshift.api.model.operator.v1.CSISnapshotControllerList;
import io.fabric8.openshift.api.model.operator.v1.CloudCredential;
import io.fabric8.openshift.api.model.operator.v1.CloudCredentialList;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriver;
import io.fabric8.openshift.api.model.operator.v1.ClusterCSIDriverList;
import io.fabric8.openshift.api.model.operator.v1.Config;
import io.fabric8.openshift.api.model.operator.v1.ConfigList;
import io.fabric8.openshift.api.model.operator.v1.Console;
import io.fabric8.openshift.api.model.operator.v1.ConsoleList;
import io.fabric8.openshift.api.model.operator.v1.DNS;
import io.fabric8.openshift.api.model.operator.v1.DNSList;
import io.fabric8.openshift.api.model.operator.v1.DNSRecord;
import io.fabric8.openshift.api.model.operator.v1.DNSRecordList;
import io.fabric8.openshift.api.model.operator.v1.Etcd;
import io.fabric8.openshift.api.model.operator.v1.EtcdList;
import io.fabric8.openshift.api.model.operator.v1.ImagePruner;
import io.fabric8.openshift.api.model.operator.v1.ImagePrunerList;
import io.fabric8.openshift.api.model.operator.v1.IngressController;
import io.fabric8.openshift.api.model.operator.v1.IngressControllerList;
import io.fabric8.openshift.api.model.operator.v1.KubeAPIServer;
import io.fabric8.openshift.api.model.operator.v1.KubeAPIServerList;
import io.fabric8.openshift.api.model.operator.v1.KubeControllerManager;
import io.fabric8.openshift.api.model.operator.v1.KubeControllerManagerList;
import io.fabric8.openshift.api.model.operator.v1.KubeScheduler;
import io.fabric8.openshift.api.model.operator.v1.KubeSchedulerList;
import io.fabric8.openshift.api.model.operator.v1.KubeStorageVersionMigrator;
import io.fabric8.openshift.api.model.operator.v1.KubeStorageVersionMigratorList;
import io.fabric8.openshift.api.model.operator.v1.Network;
import io.fabric8.openshift.api.model.operator.v1.NetworkList;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftAPIServer;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftAPIServerList;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftControllerManager;
import io.fabric8.openshift.api.model.operator.v1.OpenShiftControllerManagerList;
import io.fabric8.openshift.api.model.operator.v1.ServiceCA;
import io.fabric8.openshift.api.model.operator.v1.ServiceCAList;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogAPIServer;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogAPIServerList;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogControllerManager;
import io.fabric8.openshift.api.model.operator.v1.ServiceCatalogControllerManagerList;
import io.fabric8.openshift.api.model.operator.v1.Storage;
import io.fabric8.openshift.api.model.operator.v1.StorageList;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicy;
import io.fabric8.openshift.api.model.operator.v1alpha1.ImageContentSourcePolicyList;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private Authentication authentication;
    private AuthenticationList authenticationList;
    private KubernetesList baseKubernetesList;
    private CSISnapshotController cSISnapshotController;
    private CSISnapshotControllerList cSISnapshotControllerList;
    private CloudCredential cloudCredential;
    private CloudCredentialList cloudCredentialList;
    private ClusterCSIDriver clusterCSIDriver;
    private ClusterCSIDriverList clusterCSIDriverList;
    private Config config;
    private ConfigList configList;
    private ConfigMapFileReference configMapFileReference;
    private Console console;
    private ConsoleList consoleList;
    private DNS dns;
    private DNSList dNSList;
    private DNSRecord dNSRecord;
    private DNSRecordList dNSRecordList;
    private Etcd etcd;
    private EtcdList etcdList;
    private ImageContentSourcePolicy imageContentSourcePolicy;
    private ImageContentSourcePolicyList imageContentSourcePolicyList;
    private ImagePruner imagePruner;
    private ImagePrunerList imagePrunerList;
    private Info info;
    private IngressController ingressController;
    private IngressControllerList ingressControllerList;
    private KubeAPIServer kubeAPIServer;
    private KubeAPIServerList kubeAPIServerList;
    private KubeControllerManager kubeControllerManager;
    private KubeControllerManagerList kubeControllerManagerList;
    private KubeScheduler kubeScheduler;
    private KubeSchedulerList kubeSchedulerList;
    private KubeStorageVersionMigrator kubeStorageVersionMigrator;
    private KubeStorageVersionMigratorList kubeStorageVersionMigratorList;
    private Network network;
    private NetworkList networkList;
    private ObjectMeta objectMeta;
    private OpenShiftAPIServer openShiftAPIServer;
    private OpenShiftAPIServerList openShiftAPIServerList;
    private OpenShiftControllerManager openShiftContollerManager;
    private OpenShiftControllerManagerList openShiftControllerManagerList;
    private Patch patch;
    private PodNetworkConnectivityCheck podNetworkConnectivityCheck;
    private PodNetworkConnectivityCheckList podNetworkConnectivityCheckList;
    private Quantity quantity;
    private SecretNameReference secretNameReference;
    private ServiceCA serviceCA;
    private ServiceCAList serviceCAList;
    private ServiceCatalogAPIServer serviceCatalogAPIServer;
    private ServiceCatalogAPIServerList serviceCatalogAPIServerList;
    private ServiceCatalogControllerManager serviceCatalogControllerManager;
    private ServiceCatalogControllerManagerList serviceCatalogControllerManagerList;
    private Status status;
    private Storage storage;
    private StorageList storageList;
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

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, Authentication authentication, AuthenticationList authenticationList, KubernetesList baseKubernetesList, CSISnapshotController cSISnapshotController, CSISnapshotControllerList cSISnapshotControllerList, CloudCredential cloudCredential, CloudCredentialList cloudCredentialList, ClusterCSIDriver clusterCSIDriver, ClusterCSIDriverList clusterCSIDriverList, Config config, ConfigList configList, ConfigMapFileReference configMapFileReference, Console console, ConsoleList consoleList, DNS dns, DNSList dNSList, DNSRecord dNSRecord, DNSRecordList dNSRecordList, Etcd etcd, EtcdList etcdList, ImageContentSourcePolicy imageContentSourcePolicy, ImageContentSourcePolicyList imageContentSourcePolicyList, ImagePruner imagePruner, ImagePrunerList imagePrunerList, Info info, IngressController ingressController, IngressControllerList ingressControllerList, KubeAPIServer kubeAPIServer, KubeAPIServerList kubeAPIServerList, KubeControllerManager kubeControllerManager, KubeControllerManagerList kubeControllerManagerList, KubeScheduler kubeScheduler, KubeSchedulerList kubeSchedulerList, KubeStorageVersionMigrator kubeStorageVersionMigrator, KubeStorageVersionMigratorList kubeStorageVersionMigratorList, Network network, NetworkList networkList, ObjectMeta objectMeta, OpenShiftAPIServer openShiftAPIServer, OpenShiftAPIServerList openShiftAPIServerList, OpenShiftControllerManager openShiftContollerManager, OpenShiftControllerManagerList openShiftControllerManagerList, Patch patch, PodNetworkConnectivityCheck podNetworkConnectivityCheck, PodNetworkConnectivityCheckList podNetworkConnectivityCheckList, Quantity quantity, SecretNameReference secretNameReference, ServiceCA serviceCA, ServiceCAList serviceCAList, ServiceCatalogAPIServer serviceCatalogAPIServer, ServiceCatalogAPIServerList serviceCatalogAPIServerList, ServiceCatalogControllerManager serviceCatalogControllerManager, ServiceCatalogControllerManagerList serviceCatalogControllerManagerList, Status status, Storage storage, StorageList storageList, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.authentication = authentication;
        this.authenticationList = authenticationList;
        this.baseKubernetesList = baseKubernetesList;
        this.cSISnapshotController = cSISnapshotController;
        this.cSISnapshotControllerList = cSISnapshotControllerList;
        this.cloudCredential = cloudCredential;
        this.cloudCredentialList = cloudCredentialList;
        this.clusterCSIDriver = clusterCSIDriver;
        this.clusterCSIDriverList = clusterCSIDriverList;
        this.config = config;
        this.configList = configList;
        this.configMapFileReference = configMapFileReference;
        this.console = console;
        this.consoleList = consoleList;
        this.dns = dns;
        this.dNSList = dNSList;
        this.dNSRecord = dNSRecord;
        this.dNSRecordList = dNSRecordList;
        this.etcd = etcd;
        this.etcdList = etcdList;
        this.imageContentSourcePolicy = imageContentSourcePolicy;
        this.imageContentSourcePolicyList = imageContentSourcePolicyList;
        this.imagePruner = imagePruner;
        this.imagePrunerList = imagePrunerList;
        this.info = info;
        this.ingressController = ingressController;
        this.ingressControllerList = ingressControllerList;
        this.kubeAPIServer = kubeAPIServer;
        this.kubeAPIServerList = kubeAPIServerList;
        this.kubeControllerManager = kubeControllerManager;
        this.kubeControllerManagerList = kubeControllerManagerList;
        this.kubeScheduler = kubeScheduler;
        this.kubeSchedulerList = kubeSchedulerList;
        this.kubeStorageVersionMigrator = kubeStorageVersionMigrator;
        this.kubeStorageVersionMigratorList = kubeStorageVersionMigratorList;
        this.network = network;
        this.networkList = networkList;
        this.objectMeta = objectMeta;
        this.openShiftAPIServer = openShiftAPIServer;
        this.openShiftAPIServerList = openShiftAPIServerList;
        this.openShiftContollerManager = openShiftContollerManager;
        this.openShiftControllerManagerList = openShiftControllerManagerList;
        this.patch = patch;
        this.podNetworkConnectivityCheck = podNetworkConnectivityCheck;
        this.podNetworkConnectivityCheckList = podNetworkConnectivityCheckList;
        this.quantity = quantity;
        this.secretNameReference = secretNameReference;
        this.serviceCA = serviceCA;
        this.serviceCAList = serviceCAList;
        this.serviceCatalogAPIServer = serviceCatalogAPIServer;
        this.serviceCatalogAPIServerList = serviceCatalogAPIServerList;
        this.serviceCatalogControllerManager = serviceCatalogControllerManager;
        this.serviceCatalogControllerManagerList = serviceCatalogControllerManagerList;
        this.status = status;
        this.storage = storage;
        this.storageList = storageList;
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

    @JsonProperty("CSISnapshotController")
    public CSISnapshotController getCSISnapshotController() {
        return cSISnapshotController;
    }

    @JsonProperty("CSISnapshotController")
    public void setCSISnapshotController(CSISnapshotController cSISnapshotController) {
        this.cSISnapshotController = cSISnapshotController;
    }

    @JsonProperty("CSISnapshotControllerList")
    public CSISnapshotControllerList getCSISnapshotControllerList() {
        return cSISnapshotControllerList;
    }

    @JsonProperty("CSISnapshotControllerList")
    public void setCSISnapshotControllerList(CSISnapshotControllerList cSISnapshotControllerList) {
        this.cSISnapshotControllerList = cSISnapshotControllerList;
    }

    @JsonProperty("CloudCredential")
    public CloudCredential getCloudCredential() {
        return cloudCredential;
    }

    @JsonProperty("CloudCredential")
    public void setCloudCredential(CloudCredential cloudCredential) {
        this.cloudCredential = cloudCredential;
    }

    @JsonProperty("CloudCredentialList")
    public CloudCredentialList getCloudCredentialList() {
        return cloudCredentialList;
    }

    @JsonProperty("CloudCredentialList")
    public void setCloudCredentialList(CloudCredentialList cloudCredentialList) {
        this.cloudCredentialList = cloudCredentialList;
    }

    @JsonProperty("ClusterCSIDriver")
    public ClusterCSIDriver getClusterCSIDriver() {
        return clusterCSIDriver;
    }

    @JsonProperty("ClusterCSIDriver")
    public void setClusterCSIDriver(ClusterCSIDriver clusterCSIDriver) {
        this.clusterCSIDriver = clusterCSIDriver;
    }

    @JsonProperty("ClusterCSIDriverList")
    public ClusterCSIDriverList getClusterCSIDriverList() {
        return clusterCSIDriverList;
    }

    @JsonProperty("ClusterCSIDriverList")
    public void setClusterCSIDriverList(ClusterCSIDriverList clusterCSIDriverList) {
        this.clusterCSIDriverList = clusterCSIDriverList;
    }

    @JsonProperty("Config")
    public Config getConfig() {
        return config;
    }

    @JsonProperty("Config")
    public void setConfig(Config config) {
        this.config = config;
    }

    @JsonProperty("ConfigList")
    public ConfigList getConfigList() {
        return configList;
    }

    @JsonProperty("ConfigList")
    public void setConfigList(ConfigList configList) {
        this.configList = configList;
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

    @JsonProperty("DNSRecord")
    public DNSRecord getDNSRecord() {
        return dNSRecord;
    }

    @JsonProperty("DNSRecord")
    public void setDNSRecord(DNSRecord dNSRecord) {
        this.dNSRecord = dNSRecord;
    }

    @JsonProperty("DNSRecordList")
    public DNSRecordList getDNSRecordList() {
        return dNSRecordList;
    }

    @JsonProperty("DNSRecordList")
    public void setDNSRecordList(DNSRecordList dNSRecordList) {
        this.dNSRecordList = dNSRecordList;
    }

    @JsonProperty("Etcd")
    public Etcd getEtcd() {
        return etcd;
    }

    @JsonProperty("Etcd")
    public void setEtcd(Etcd etcd) {
        this.etcd = etcd;
    }

    @JsonProperty("EtcdList")
    public EtcdList getEtcdList() {
        return etcdList;
    }

    @JsonProperty("EtcdList")
    public void setEtcdList(EtcdList etcdList) {
        this.etcdList = etcdList;
    }

    @JsonProperty("ImageContentSourcePolicy")
    public ImageContentSourcePolicy getImageContentSourcePolicy() {
        return imageContentSourcePolicy;
    }

    @JsonProperty("ImageContentSourcePolicy")
    public void setImageContentSourcePolicy(ImageContentSourcePolicy imageContentSourcePolicy) {
        this.imageContentSourcePolicy = imageContentSourcePolicy;
    }

    @JsonProperty("ImageContentSourcePolicyList")
    public ImageContentSourcePolicyList getImageContentSourcePolicyList() {
        return imageContentSourcePolicyList;
    }

    @JsonProperty("ImageContentSourcePolicyList")
    public void setImageContentSourcePolicyList(ImageContentSourcePolicyList imageContentSourcePolicyList) {
        this.imageContentSourcePolicyList = imageContentSourcePolicyList;
    }

    @JsonProperty("ImagePruner")
    public ImagePruner getImagePruner() {
        return imagePruner;
    }

    @JsonProperty("ImagePruner")
    public void setImagePruner(ImagePruner imagePruner) {
        this.imagePruner = imagePruner;
    }

    @JsonProperty("ImagePrunerList")
    public ImagePrunerList getImagePrunerList() {
        return imagePrunerList;
    }

    @JsonProperty("ImagePrunerList")
    public void setImagePrunerList(ImagePrunerList imagePrunerList) {
        this.imagePrunerList = imagePrunerList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("IngressController")
    public IngressController getIngressController() {
        return ingressController;
    }

    @JsonProperty("IngressController")
    public void setIngressController(IngressController ingressController) {
        this.ingressController = ingressController;
    }

    @JsonProperty("IngressControllerList")
    public IngressControllerList getIngressControllerList() {
        return ingressControllerList;
    }

    @JsonProperty("IngressControllerList")
    public void setIngressControllerList(IngressControllerList ingressControllerList) {
        this.ingressControllerList = ingressControllerList;
    }

    @JsonProperty("KubeAPIServer")
    public KubeAPIServer getKubeAPIServer() {
        return kubeAPIServer;
    }

    @JsonProperty("KubeAPIServer")
    public void setKubeAPIServer(KubeAPIServer kubeAPIServer) {
        this.kubeAPIServer = kubeAPIServer;
    }

    @JsonProperty("KubeAPIServerList")
    public KubeAPIServerList getKubeAPIServerList() {
        return kubeAPIServerList;
    }

    @JsonProperty("KubeAPIServerList")
    public void setKubeAPIServerList(KubeAPIServerList kubeAPIServerList) {
        this.kubeAPIServerList = kubeAPIServerList;
    }

    @JsonProperty("KubeControllerManager")
    public KubeControllerManager getKubeControllerManager() {
        return kubeControllerManager;
    }

    @JsonProperty("KubeControllerManager")
    public void setKubeControllerManager(KubeControllerManager kubeControllerManager) {
        this.kubeControllerManager = kubeControllerManager;
    }

    @JsonProperty("KubeControllerManagerList")
    public KubeControllerManagerList getKubeControllerManagerList() {
        return kubeControllerManagerList;
    }

    @JsonProperty("KubeControllerManagerList")
    public void setKubeControllerManagerList(KubeControllerManagerList kubeControllerManagerList) {
        this.kubeControllerManagerList = kubeControllerManagerList;
    }

    @JsonProperty("KubeScheduler")
    public KubeScheduler getKubeScheduler() {
        return kubeScheduler;
    }

    @JsonProperty("KubeScheduler")
    public void setKubeScheduler(KubeScheduler kubeScheduler) {
        this.kubeScheduler = kubeScheduler;
    }

    @JsonProperty("KubeSchedulerList")
    public KubeSchedulerList getKubeSchedulerList() {
        return kubeSchedulerList;
    }

    @JsonProperty("KubeSchedulerList")
    public void setKubeSchedulerList(KubeSchedulerList kubeSchedulerList) {
        this.kubeSchedulerList = kubeSchedulerList;
    }

    @JsonProperty("KubeStorageVersionMigrator")
    public KubeStorageVersionMigrator getKubeStorageVersionMigrator() {
        return kubeStorageVersionMigrator;
    }

    @JsonProperty("KubeStorageVersionMigrator")
    public void setKubeStorageVersionMigrator(KubeStorageVersionMigrator kubeStorageVersionMigrator) {
        this.kubeStorageVersionMigrator = kubeStorageVersionMigrator;
    }

    @JsonProperty("KubeStorageVersionMigratorList")
    public KubeStorageVersionMigratorList getKubeStorageVersionMigratorList() {
        return kubeStorageVersionMigratorList;
    }

    @JsonProperty("KubeStorageVersionMigratorList")
    public void setKubeStorageVersionMigratorList(KubeStorageVersionMigratorList kubeStorageVersionMigratorList) {
        this.kubeStorageVersionMigratorList = kubeStorageVersionMigratorList;
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

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("OpenShiftAPIServer")
    public OpenShiftAPIServer getOpenShiftAPIServer() {
        return openShiftAPIServer;
    }

    @JsonProperty("OpenShiftAPIServer")
    public void setOpenShiftAPIServer(OpenShiftAPIServer openShiftAPIServer) {
        this.openShiftAPIServer = openShiftAPIServer;
    }

    @JsonProperty("OpenShiftAPIServerList")
    public OpenShiftAPIServerList getOpenShiftAPIServerList() {
        return openShiftAPIServerList;
    }

    @JsonProperty("OpenShiftAPIServerList")
    public void setOpenShiftAPIServerList(OpenShiftAPIServerList openShiftAPIServerList) {
        this.openShiftAPIServerList = openShiftAPIServerList;
    }

    @JsonProperty("OpenShiftContollerManager")
    public OpenShiftControllerManager getOpenShiftContollerManager() {
        return openShiftContollerManager;
    }

    @JsonProperty("OpenShiftContollerManager")
    public void setOpenShiftContollerManager(OpenShiftControllerManager openShiftContollerManager) {
        this.openShiftContollerManager = openShiftContollerManager;
    }

    @JsonProperty("OpenShiftControllerManagerList")
    public OpenShiftControllerManagerList getOpenShiftControllerManagerList() {
        return openShiftControllerManagerList;
    }

    @JsonProperty("OpenShiftControllerManagerList")
    public void setOpenShiftControllerManagerList(OpenShiftControllerManagerList openShiftControllerManagerList) {
        this.openShiftControllerManagerList = openShiftControllerManagerList;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("PodNetworkConnectivityCheck")
    public PodNetworkConnectivityCheck getPodNetworkConnectivityCheck() {
        return podNetworkConnectivityCheck;
    }

    @JsonProperty("PodNetworkConnectivityCheck")
    public void setPodNetworkConnectivityCheck(PodNetworkConnectivityCheck podNetworkConnectivityCheck) {
        this.podNetworkConnectivityCheck = podNetworkConnectivityCheck;
    }

    @JsonProperty("PodNetworkConnectivityCheckList")
    public PodNetworkConnectivityCheckList getPodNetworkConnectivityCheckList() {
        return podNetworkConnectivityCheckList;
    }

    @JsonProperty("PodNetworkConnectivityCheckList")
    public void setPodNetworkConnectivityCheckList(PodNetworkConnectivityCheckList podNetworkConnectivityCheckList) {
        this.podNetworkConnectivityCheckList = podNetworkConnectivityCheckList;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("SecretNameReference")
    public SecretNameReference getSecretNameReference() {
        return secretNameReference;
    }

    @JsonProperty("SecretNameReference")
    public void setSecretNameReference(SecretNameReference secretNameReference) {
        this.secretNameReference = secretNameReference;
    }

    @JsonProperty("ServiceCA")
    public ServiceCA getServiceCA() {
        return serviceCA;
    }

    @JsonProperty("ServiceCA")
    public void setServiceCA(ServiceCA serviceCA) {
        this.serviceCA = serviceCA;
    }

    @JsonProperty("ServiceCAList")
    public ServiceCAList getServiceCAList() {
        return serviceCAList;
    }

    @JsonProperty("ServiceCAList")
    public void setServiceCAList(ServiceCAList serviceCAList) {
        this.serviceCAList = serviceCAList;
    }

    @JsonProperty("ServiceCatalogAPIServer")
    public ServiceCatalogAPIServer getServiceCatalogAPIServer() {
        return serviceCatalogAPIServer;
    }

    @JsonProperty("ServiceCatalogAPIServer")
    public void setServiceCatalogAPIServer(ServiceCatalogAPIServer serviceCatalogAPIServer) {
        this.serviceCatalogAPIServer = serviceCatalogAPIServer;
    }

    @JsonProperty("ServiceCatalogAPIServerList")
    public ServiceCatalogAPIServerList getServiceCatalogAPIServerList() {
        return serviceCatalogAPIServerList;
    }

    @JsonProperty("ServiceCatalogAPIServerList")
    public void setServiceCatalogAPIServerList(ServiceCatalogAPIServerList serviceCatalogAPIServerList) {
        this.serviceCatalogAPIServerList = serviceCatalogAPIServerList;
    }

    @JsonProperty("ServiceCatalogControllerManager")
    public ServiceCatalogControllerManager getServiceCatalogControllerManager() {
        return serviceCatalogControllerManager;
    }

    @JsonProperty("ServiceCatalogControllerManager")
    public void setServiceCatalogControllerManager(ServiceCatalogControllerManager serviceCatalogControllerManager) {
        this.serviceCatalogControllerManager = serviceCatalogControllerManager;
    }

    @JsonProperty("ServiceCatalogControllerManagerList")
    public ServiceCatalogControllerManagerList getServiceCatalogControllerManagerList() {
        return serviceCatalogControllerManagerList;
    }

    @JsonProperty("ServiceCatalogControllerManagerList")
    public void setServiceCatalogControllerManagerList(ServiceCatalogControllerManagerList serviceCatalogControllerManagerList) {
        this.serviceCatalogControllerManagerList = serviceCatalogControllerManagerList;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("Storage")
    public Storage getStorage() {
        return storage;
    }

    @JsonProperty("Storage")
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @JsonProperty("StorageList")
    public StorageList getStorageList() {
        return storageList;
    }

    @JsonProperty("StorageList")
    public void setStorageList(StorageList storageList) {
        this.storageList = storageList;
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
