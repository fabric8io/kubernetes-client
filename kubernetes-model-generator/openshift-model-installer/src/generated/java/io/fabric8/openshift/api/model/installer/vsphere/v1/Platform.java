
package io.fabric8.openshift.api.model.installer.vsphere.v1;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
import io.fabric8.openshift.api.model.config.v1.VSpherePlatformLoadBalancer;
import io.fabric8.openshift.api.model.config.v1.VSpherePlatformNodeNetworking;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;

/**
 * Platform stores any global configuration used for vsphere platforms.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "apiVIP",
    "apiVIPs",
    "cluster",
    "clusterOSImage",
    "datacenter",
    "defaultDatastore",
    "defaultMachinePlatform",
    "diskType",
    "failureDomains",
    "folder",
    "hosts",
    "ingressVIP",
    "ingressVIPs",
    "loadBalancer",
    "network",
    "nodeNetworking",
    "password",
    "resourcePool",
    "username",
    "vCenter",
    "vcenters"
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
public class Platform implements Editable<PlatformBuilder>, KubernetesResource
{

    @JsonProperty("apiVIP")
    private String apiVIP;
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> apiVIPs = new ArrayList<>();
    @JsonProperty("cluster")
    private String cluster;
    @JsonProperty("clusterOSImage")
    private String clusterOSImage;
    @JsonProperty("datacenter")
    private String datacenter;
    @JsonProperty("defaultDatastore")
    private String defaultDatastore;
    @JsonProperty("defaultMachinePlatform")
    private MachinePool defaultMachinePlatform;
    @JsonProperty("diskType")
    private String diskType;
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<FailureDomain> failureDomains = new ArrayList<>();
    @JsonProperty("folder")
    private String folder;
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Host> hosts = new ArrayList<>();
    @JsonProperty("ingressVIP")
    private String ingressVIP;
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> ingressVIPs = new ArrayList<>();
    @JsonProperty("loadBalancer")
    private VSpherePlatformLoadBalancer loadBalancer;
    @JsonProperty("network")
    private String network;
    @JsonProperty("nodeNetworking")
    private VSpherePlatformNodeNetworking nodeNetworking;
    @JsonProperty("password")
    private String password;
    @JsonProperty("resourcePool")
    private String resourcePool;
    @JsonProperty("username")
    private String username;
    @JsonProperty("vCenter")
    private String vCenter;
    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<VCenter> vcenters = new ArrayList<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public Platform() {
    }

    public Platform(String apiVIP, List<String> apiVIPs, String cluster, String clusterOSImage, String datacenter, String defaultDatastore, MachinePool defaultMachinePlatform, String diskType, List<FailureDomain> failureDomains, String folder, List<Host> hosts, String ingressVIP, List<String> ingressVIPs, VSpherePlatformLoadBalancer loadBalancer, String network, VSpherePlatformNodeNetworking nodeNetworking, String password, String resourcePool, String username, String vCenter, List<VCenter> vcenters) {
        super();
        this.apiVIP = apiVIP;
        this.apiVIPs = apiVIPs;
        this.cluster = cluster;
        this.clusterOSImage = clusterOSImage;
        this.datacenter = datacenter;
        this.defaultDatastore = defaultDatastore;
        this.defaultMachinePlatform = defaultMachinePlatform;
        this.diskType = diskType;
        this.failureDomains = failureDomains;
        this.folder = folder;
        this.hosts = hosts;
        this.ingressVIP = ingressVIP;
        this.ingressVIPs = ingressVIPs;
        this.loadBalancer = loadBalancer;
        this.network = network;
        this.nodeNetworking = nodeNetworking;
        this.password = password;
        this.resourcePool = resourcePool;
        this.username = username;
        this.vCenter = vCenter;
        this.vcenters = vcenters;
    }

    /**
     * DeprecatedAPIVIP is the virtual IP address for the api endpoint Deprecated: Use APIVIPs
     */
    @JsonProperty("apiVIP")
    public String getApiVIP() {
        return apiVIP;
    }

    /**
     * DeprecatedAPIVIP is the virtual IP address for the api endpoint Deprecated: Use APIVIPs
     */
    @JsonProperty("apiVIP")
    public void setApiVIP(String apiVIP) {
        this.apiVIP = apiVIP;
    }

    /**
     * APIVIPs contains the VIP(s) for the api endpoint. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("apiVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getApiVIPs() {
        return apiVIPs;
    }

    /**
     * APIVIPs contains the VIP(s) for the api endpoint. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("apiVIPs")
    public void setApiVIPs(List<String> apiVIPs) {
        this.apiVIPs = apiVIPs;
    }

    /**
     * Cluster is the name of the cluster virtual machines will be cloned into. Deprecated: Use FailureDomains.Topology.Cluster
     */
    @JsonProperty("cluster")
    public String getCluster() {
        return cluster;
    }

    /**
     * Cluster is the name of the cluster virtual machines will be cloned into. Deprecated: Use FailureDomains.Topology.Cluster
     */
    @JsonProperty("cluster")
    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    /**
     * ClusterOSImage overrides the url provided in rhcos.json to download the RHCOS OVA
     */
    @JsonProperty("clusterOSImage")
    public String getClusterOSImage() {
        return clusterOSImage;
    }

    /**
     * ClusterOSImage overrides the url provided in rhcos.json to download the RHCOS OVA
     */
    @JsonProperty("clusterOSImage")
    public void setClusterOSImage(String clusterOSImage) {
        this.clusterOSImage = clusterOSImage;
    }

    /**
     * Datacenter is the name of the datacenter to use in the vCenter. Deprecated: Use FailureDomains.Topology.Datacenter
     */
    @JsonProperty("datacenter")
    public String getDatacenter() {
        return datacenter;
    }

    /**
     * Datacenter is the name of the datacenter to use in the vCenter. Deprecated: Use FailureDomains.Topology.Datacenter
     */
    @JsonProperty("datacenter")
    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    /**
     * DefaultDatastore is the default datastore to use for provisioning volumes. Deprecated: Use FailureDomains.Topology.Datastore
     */
    @JsonProperty("defaultDatastore")
    public String getDefaultDatastore() {
        return defaultDatastore;
    }

    /**
     * DefaultDatastore is the default datastore to use for provisioning volumes. Deprecated: Use FailureDomains.Topology.Datastore
     */
    @JsonProperty("defaultDatastore")
    public void setDefaultDatastore(String defaultDatastore) {
        this.defaultDatastore = defaultDatastore;
    }

    /**
     * Platform stores any global configuration used for vsphere platforms.
     */
    @JsonProperty("defaultMachinePlatform")
    public MachinePool getDefaultMachinePlatform() {
        return defaultMachinePlatform;
    }

    /**
     * Platform stores any global configuration used for vsphere platforms.
     */
    @JsonProperty("defaultMachinePlatform")
    public void setDefaultMachinePlatform(MachinePool defaultMachinePlatform) {
        this.defaultMachinePlatform = defaultMachinePlatform;
    }

    /**
     * DiskType is the name of the disk provisioning type, valid values are thin, thick, and eagerZeroedThick. When not specified, it will be set according to the default storage policy of vsphere.
     */
    @JsonProperty("diskType")
    public String getDiskType() {
        return diskType;
    }

    /**
     * DiskType is the name of the disk provisioning type, valid values are thin, thick, and eagerZeroedThick. When not specified, it will be set according to the default storage policy of vsphere.
     */
    @JsonProperty("diskType")
    public void setDiskType(String diskType) {
        this.diskType = diskType;
    }

    /**
     * FailureDomains holds the VSpherePlatformFailureDomainSpec which contains the definition of region, zone and the vCenter topology. If this is omitted failure domains (regions and zones) will not be used.
     */
    @JsonProperty("failureDomains")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<FailureDomain> getFailureDomains() {
        return failureDomains;
    }

    /**
     * FailureDomains holds the VSpherePlatformFailureDomainSpec which contains the definition of region, zone and the vCenter topology. If this is omitted failure domains (regions and zones) will not be used.
     */
    @JsonProperty("failureDomains")
    public void setFailureDomains(List<FailureDomain> failureDomains) {
        this.failureDomains = failureDomains;
    }

    /**
     * Folder is the absolute path of the folder that will be used and/or created for virtual machines. The absolute path is of the form /&lt;datacenter&gt;/vm/&lt;folder&gt;/&lt;subfolder&gt;. Deprecated: Use FailureDomains.Topology.Folder
     */
    @JsonProperty("folder")
    public String getFolder() {
        return folder;
    }

    /**
     * Folder is the absolute path of the folder that will be used and/or created for virtual machines. The absolute path is of the form /&lt;datacenter&gt;/vm/&lt;folder&gt;/&lt;subfolder&gt;. Deprecated: Use FailureDomains.Topology.Folder
     */
    @JsonProperty("folder")
    public void setFolder(String folder) {
        this.folder = folder;
    }

    /**
     * Hosts defines network configurations to be applied by the installer. Hosts is available in TechPreview.
     */
    @JsonProperty("hosts")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Host> getHosts() {
        return hosts;
    }

    /**
     * Hosts defines network configurations to be applied by the installer. Hosts is available in TechPreview.
     */
    @JsonProperty("hosts")
    public void setHosts(List<Host> hosts) {
        this.hosts = hosts;
    }

    /**
     * DeprecatedIngressVIP is the virtual IP address for ingress Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public String getIngressVIP() {
        return ingressVIP;
    }

    /**
     * DeprecatedIngressVIP is the virtual IP address for ingress Deprecated: Use IngressVIPs
     */
    @JsonProperty("ingressVIP")
    public void setIngressVIP(String ingressVIP) {
        this.ingressVIP = ingressVIP;
    }

    /**
     * IngressVIPs contains the VIP(s) for ingress. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingressVIPs")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getIngressVIPs() {
        return ingressVIPs;
    }

    /**
     * IngressVIPs contains the VIP(s) for ingress. In dual stack clusters it contains an IPv4 and IPv6 address, otherwise only one VIP
     */
    @JsonProperty("ingressVIPs")
    public void setIngressVIPs(List<String> ingressVIPs) {
        this.ingressVIPs = ingressVIPs;
    }

    /**
     * Platform stores any global configuration used for vsphere platforms.
     */
    @JsonProperty("loadBalancer")
    public VSpherePlatformLoadBalancer getLoadBalancer() {
        return loadBalancer;
    }

    /**
     * Platform stores any global configuration used for vsphere platforms.
     */
    @JsonProperty("loadBalancer")
    public void setLoadBalancer(VSpherePlatformLoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    /**
     * Network specifies the name of the network to be used by the cluster. Deprecated: Use FailureDomains.Topology.Network
     */
    @JsonProperty("network")
    public String getNetwork() {
        return network;
    }

    /**
     * Network specifies the name of the network to be used by the cluster. Deprecated: Use FailureDomains.Topology.Network
     */
    @JsonProperty("network")
    public void setNetwork(String network) {
        this.network = network;
    }

    /**
     * Platform stores any global configuration used for vsphere platforms.
     */
    @JsonProperty("nodeNetworking")
    public VSpherePlatformNodeNetworking getNodeNetworking() {
        return nodeNetworking;
    }

    /**
     * Platform stores any global configuration used for vsphere platforms.
     */
    @JsonProperty("nodeNetworking")
    public void setNodeNetworking(VSpherePlatformNodeNetworking nodeNetworking) {
        this.nodeNetworking = nodeNetworking;
    }

    /**
     * Password is the password for the user to use to connect to the vCenter. Deprecated: Use VCenters.Password
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * Password is the password for the user to use to connect to the vCenter. Deprecated: Use VCenters.Password
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * ResourcePool is the absolute path of the resource pool where virtual machines will be created. The absolute path is of the form /&lt;datacenter&gt;/host/&lt;cluster&gt;/Resources/&lt;resourcepool&gt;. Deprecated: Use FailureDomains.Topology.ResourcePool
     */
    @JsonProperty("resourcePool")
    public String getResourcePool() {
        return resourcePool;
    }

    /**
     * ResourcePool is the absolute path of the resource pool where virtual machines will be created. The absolute path is of the form /&lt;datacenter&gt;/host/&lt;cluster&gt;/Resources/&lt;resourcepool&gt;. Deprecated: Use FailureDomains.Topology.ResourcePool
     */
    @JsonProperty("resourcePool")
    public void setResourcePool(String resourcePool) {
        this.resourcePool = resourcePool;
    }

    /**
     * Username is the name of the user to use to connect to the vCenter. Deprecated: Use VCenters.Username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * Username is the name of the user to use to connect to the vCenter. Deprecated: Use VCenters.Username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * VCenter is the domain name or IP address of the vCenter. Deprecated: Use VCenters.Server
     */
    @JsonProperty("vCenter")
    public String getVCenter() {
        return vCenter;
    }

    /**
     * VCenter is the domain name or IP address of the vCenter. Deprecated: Use VCenters.Server
     */
    @JsonProperty("vCenter")
    public void setVCenter(String vCenter) {
        this.vCenter = vCenter;
    }

    /**
     * VCenters holds the connection details for services to communicate with vCenter.
     */
    @JsonProperty("vcenters")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<VCenter> getVcenters() {
        return vcenters;
    }

    /**
     * VCenters holds the connection details for services to communicate with vCenter.
     */
    @JsonProperty("vcenters")
    public void setVcenters(List<VCenter> vcenters) {
        this.vcenters = vcenters;
    }

    @JsonIgnore
    public PlatformBuilder edit() {
        return new PlatformBuilder(this);
    }

    @JsonIgnore
    public PlatformBuilder toBuilder() {
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
        if (!(o instanceof Platform)) {
            return false;
        }
        Platform other = (Platform) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$apiVIP = this.getApiVIP();
        Object other$apiVIP = other.getApiVIP();
        if (this$apiVIP == null ? other$apiVIP != null : !this$apiVIP.equals(other$apiVIP)) {
            return false;
        }
        Object this$apiVIPs = this.getApiVIPs();
        Object other$apiVIPs = other.getApiVIPs();
        if (this$apiVIPs == null ? other$apiVIPs != null : !this$apiVIPs.equals(other$apiVIPs)) {
            return false;
        }
        Object this$cluster = this.getCluster();
        Object other$cluster = other.getCluster();
        if (this$cluster == null ? other$cluster != null : !this$cluster.equals(other$cluster)) {
            return false;
        }
        Object this$clusterOSImage = this.getClusterOSImage();
        Object other$clusterOSImage = other.getClusterOSImage();
        if (this$clusterOSImage == null ? other$clusterOSImage != null : !this$clusterOSImage.equals(other$clusterOSImage)) {
            return false;
        }
        Object this$datacenter = this.getDatacenter();
        Object other$datacenter = other.getDatacenter();
        if (this$datacenter == null ? other$datacenter != null : !this$datacenter.equals(other$datacenter)) {
            return false;
        }
        Object this$defaultDatastore = this.getDefaultDatastore();
        Object other$defaultDatastore = other.getDefaultDatastore();
        if (this$defaultDatastore == null ? other$defaultDatastore != null : !this$defaultDatastore.equals(other$defaultDatastore)) {
            return false;
        }
        Object this$defaultMachinePlatform = this.getDefaultMachinePlatform();
        Object other$defaultMachinePlatform = other.getDefaultMachinePlatform();
        if (this$defaultMachinePlatform == null ? other$defaultMachinePlatform != null : !this$defaultMachinePlatform.equals(other$defaultMachinePlatform)) {
            return false;
        }
        Object this$diskType = this.getDiskType();
        Object other$diskType = other.getDiskType();
        if (this$diskType == null ? other$diskType != null : !this$diskType.equals(other$diskType)) {
            return false;
        }
        Object this$failureDomains = this.getFailureDomains();
        Object other$failureDomains = other.getFailureDomains();
        if (this$failureDomains == null ? other$failureDomains != null : !this$failureDomains.equals(other$failureDomains)) {
            return false;
        }
        Object this$folder = this.getFolder();
        Object other$folder = other.getFolder();
        if (this$folder == null ? other$folder != null : !this$folder.equals(other$folder)) {
            return false;
        }
        Object this$hosts = this.getHosts();
        Object other$hosts = other.getHosts();
        if (this$hosts == null ? other$hosts != null : !this$hosts.equals(other$hosts)) {
            return false;
        }
        Object this$ingressVIP = this.getIngressVIP();
        Object other$ingressVIP = other.getIngressVIP();
        if (this$ingressVIP == null ? other$ingressVIP != null : !this$ingressVIP.equals(other$ingressVIP)) {
            return false;
        }
        Object this$ingressVIPs = this.getIngressVIPs();
        Object other$ingressVIPs = other.getIngressVIPs();
        if (this$ingressVIPs == null ? other$ingressVIPs != null : !this$ingressVIPs.equals(other$ingressVIPs)) {
            return false;
        }
        Object this$loadBalancer = this.getLoadBalancer();
        Object other$loadBalancer = other.getLoadBalancer();
        if (this$loadBalancer == null ? other$loadBalancer != null : !this$loadBalancer.equals(other$loadBalancer)) {
            return false;
        }
        Object this$network = this.getNetwork();
        Object other$network = other.getNetwork();
        if (this$network == null ? other$network != null : !this$network.equals(other$network)) {
            return false;
        }
        Object this$nodeNetworking = this.getNodeNetworking();
        Object other$nodeNetworking = other.getNodeNetworking();
        if (this$nodeNetworking == null ? other$nodeNetworking != null : !this$nodeNetworking.equals(other$nodeNetworking)) {
            return false;
        }
        Object this$password = this.getPassword();
        Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        Object this$resourcePool = this.getResourcePool();
        Object other$resourcePool = other.getResourcePool();
        if (this$resourcePool == null ? other$resourcePool != null : !this$resourcePool.equals(other$resourcePool)) {
            return false;
        }
        Object this$username = this.getUsername();
        Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
            return false;
        }
        Object this$vCenter = this.getVCenter();
        Object other$vCenter = other.getVCenter();
        if (this$vCenter == null ? other$vCenter != null : !this$vCenter.equals(other$vCenter)) {
            return false;
        }
        Object this$vcenters = this.getVcenters();
        Object other$vcenters = other.getVcenters();
        if (this$vcenters == null ? other$vcenters != null : !this$vcenters.equals(other$vcenters)) {
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
        return other instanceof Platform;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $apiVIP = this.getApiVIP();
        result = result * prime + ($apiVIP == null ? 43 : $apiVIP.hashCode());
        Object $apiVIPs = this.getApiVIPs();
        result = result * prime + ($apiVIPs == null ? 43 : $apiVIPs.hashCode());
        Object $cluster = this.getCluster();
        result = result * prime + ($cluster == null ? 43 : $cluster.hashCode());
        Object $clusterOSImage = this.getClusterOSImage();
        result = result * prime + ($clusterOSImage == null ? 43 : $clusterOSImage.hashCode());
        Object $datacenter = this.getDatacenter();
        result = result * prime + ($datacenter == null ? 43 : $datacenter.hashCode());
        Object $defaultDatastore = this.getDefaultDatastore();
        result = result * prime + ($defaultDatastore == null ? 43 : $defaultDatastore.hashCode());
        Object $defaultMachinePlatform = this.getDefaultMachinePlatform();
        result = result * prime + ($defaultMachinePlatform == null ? 43 : $defaultMachinePlatform.hashCode());
        Object $diskType = this.getDiskType();
        result = result * prime + ($diskType == null ? 43 : $diskType.hashCode());
        Object $failureDomains = this.getFailureDomains();
        result = result * prime + ($failureDomains == null ? 43 : $failureDomains.hashCode());
        Object $folder = this.getFolder();
        result = result * prime + ($folder == null ? 43 : $folder.hashCode());
        Object $hosts = this.getHosts();
        result = result * prime + ($hosts == null ? 43 : $hosts.hashCode());
        Object $ingressVIP = this.getIngressVIP();
        result = result * prime + ($ingressVIP == null ? 43 : $ingressVIP.hashCode());
        Object $ingressVIPs = this.getIngressVIPs();
        result = result * prime + ($ingressVIPs == null ? 43 : $ingressVIPs.hashCode());
        Object $loadBalancer = this.getLoadBalancer();
        result = result * prime + ($loadBalancer == null ? 43 : $loadBalancer.hashCode());
        Object $network = this.getNetwork();
        result = result * prime + ($network == null ? 43 : $network.hashCode());
        Object $nodeNetworking = this.getNodeNetworking();
        result = result * prime + ($nodeNetworking == null ? 43 : $nodeNetworking.hashCode());
        Object $password = this.getPassword();
        result = result * prime + ($password == null ? 43 : $password.hashCode());
        Object $resourcePool = this.getResourcePool();
        result = result * prime + ($resourcePool == null ? 43 : $resourcePool.hashCode());
        Object $username = this.getUsername();
        result = result * prime + ($username == null ? 43 : $username.hashCode());
        Object $vCenter = this.getVCenter();
        result = result * prime + ($vCenter == null ? 43 : $vCenter.hashCode());
        Object $vcenters = this.getVcenters();
        result = result * prime + ($vcenters == null ? 43 : $vcenters.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Platform(" + "apiVIP=" + this.getApiVIP() + ", apiVIPs=" + this.getApiVIPs() + ", cluster=" + this.getCluster() + ", clusterOSImage=" + this.getClusterOSImage() + ", datacenter=" + this.getDatacenter() + ", defaultDatastore=" + this.getDefaultDatastore() + ", defaultMachinePlatform=" + this.getDefaultMachinePlatform() + ", diskType=" + this.getDiskType() + ", failureDomains=" + this.getFailureDomains() + ", folder=" + this.getFolder() + ", hosts=" + this.getHosts() + ", ingressVIP=" + this.getIngressVIP() + ", ingressVIPs=" + this.getIngressVIPs() + ", loadBalancer=" + this.getLoadBalancer() + ", network=" + this.getNetwork() + ", nodeNetworking=" + this.getNodeNetworking() + ", password=" + this.getPassword() + ", resourcePool=" + this.getResourcePool() + ", username=" + this.getUsername() + ", vCenter=" + this.getVCenter() + ", vcenters=" + this.getVcenters() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
