
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
import io.sundr.builder.annotations.Buildable;
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
    "awsElasticBlockStore",
    "azureDisk",
    "azureFile",
    "cephfs",
    "cinder",
    "configMap",
    "csi",
    "downwardAPI",
    "emptyDir",
    "ephemeral",
    "fc",
    "flexVolume",
    "flocker",
    "gcePersistentDisk",
    "gitRepo",
    "glusterfs",
    "hostPath",
    "iscsi",
    "name",
    "nfs",
    "persistentVolumeClaim",
    "photonPersistentDisk",
    "portworxVolume",
    "projected",
    "quobyte",
    "rbd",
    "scaleIO",
    "secret",
    "storageos",
    "vsphereVolume"
})
@ToString
@EqualsAndHashCode
@Setter
@Accessors(prefix = {
    "_",
    ""
})
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = true, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("jsonschema2pojo")
public class Volume implements KubernetesResource
{

    @JsonProperty("awsElasticBlockStore")
    private AWSElasticBlockStoreVolumeSource awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private AzureDiskVolumeSource azureDisk;
    @JsonProperty("azureFile")
    private AzureFileVolumeSource azureFile;
    @JsonProperty("cephfs")
    private CephFSVolumeSource cephfs;
    @JsonProperty("cinder")
    private CinderVolumeSource cinder;
    @JsonProperty("configMap")
    private ConfigMapVolumeSource configMap;
    @JsonProperty("csi")
    private CSIVolumeSource csi;
    @JsonProperty("downwardAPI")
    private DownwardAPIVolumeSource downwardAPI;
    @JsonProperty("emptyDir")
    private EmptyDirVolumeSource emptyDir;
    @JsonProperty("ephemeral")
    private EphemeralVolumeSource ephemeral;
    @JsonProperty("fc")
    private FCVolumeSource fc;
    @JsonProperty("flexVolume")
    private FlexVolumeSource flexVolume;
    @JsonProperty("flocker")
    private FlockerVolumeSource flocker;
    @JsonProperty("gcePersistentDisk")
    private GCEPersistentDiskVolumeSource gcePersistentDisk;
    @JsonProperty("gitRepo")
    private GitRepoVolumeSource gitRepo;
    @JsonProperty("glusterfs")
    private GlusterfsVolumeSource glusterfs;
    @JsonProperty("hostPath")
    private HostPathVolumeSource hostPath;
    @JsonProperty("iscsi")
    private ISCSIVolumeSource iscsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nfs")
    private NFSVolumeSource nfs;
    @JsonProperty("persistentVolumeClaim")
    private PersistentVolumeClaimVolumeSource persistentVolumeClaim;
    @JsonProperty("photonPersistentDisk")
    private PhotonPersistentDiskVolumeSource photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private PortworxVolumeSource portworxVolume;
    @JsonProperty("projected")
    private ProjectedVolumeSource projected;
    @JsonProperty("quobyte")
    private QuobyteVolumeSource quobyte;
    @JsonProperty("rbd")
    private RBDVolumeSource rbd;
    @JsonProperty("scaleIO")
    private ScaleIOVolumeSource scaleIO;
    @JsonProperty("secret")
    private SecretVolumeSource secret;
    @JsonProperty("storageos")
    private StorageOSVolumeSource storageos;
    @JsonProperty("vsphereVolume")
    private VsphereVirtualDiskVolumeSource vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Volume() {
    }

    public Volume(AWSElasticBlockStoreVolumeSource awsElasticBlockStore, AzureDiskVolumeSource azureDisk, AzureFileVolumeSource azureFile, CephFSVolumeSource cephfs, CinderVolumeSource cinder, ConfigMapVolumeSource configMap, CSIVolumeSource csi, DownwardAPIVolumeSource downwardAPI, EmptyDirVolumeSource emptyDir, EphemeralVolumeSource ephemeral, FCVolumeSource fc, FlexVolumeSource flexVolume, FlockerVolumeSource flocker, GCEPersistentDiskVolumeSource gcePersistentDisk, GitRepoVolumeSource gitRepo, GlusterfsVolumeSource glusterfs, HostPathVolumeSource hostPath, ISCSIVolumeSource iscsi, String name, NFSVolumeSource nfs, PersistentVolumeClaimVolumeSource persistentVolumeClaim, PhotonPersistentDiskVolumeSource photonPersistentDisk, PortworxVolumeSource portworxVolume, ProjectedVolumeSource projected, QuobyteVolumeSource quobyte, RBDVolumeSource rbd, ScaleIOVolumeSource scaleIO, SecretVolumeSource secret, StorageOSVolumeSource storageos, VsphereVirtualDiskVolumeSource vsphereVolume) {
        super();
        this.awsElasticBlockStore = awsElasticBlockStore;
        this.azureDisk = azureDisk;
        this.azureFile = azureFile;
        this.cephfs = cephfs;
        this.cinder = cinder;
        this.configMap = configMap;
        this.csi = csi;
        this.downwardAPI = downwardAPI;
        this.emptyDir = emptyDir;
        this.ephemeral = ephemeral;
        this.fc = fc;
        this.flexVolume = flexVolume;
        this.flocker = flocker;
        this.gcePersistentDisk = gcePersistentDisk;
        this.gitRepo = gitRepo;
        this.glusterfs = glusterfs;
        this.hostPath = hostPath;
        this.iscsi = iscsi;
        this.name = name;
        this.nfs = nfs;
        this.persistentVolumeClaim = persistentVolumeClaim;
        this.photonPersistentDisk = photonPersistentDisk;
        this.portworxVolume = portworxVolume;
        this.projected = projected;
        this.quobyte = quobyte;
        this.rbd = rbd;
        this.scaleIO = scaleIO;
        this.secret = secret;
        this.storageos = storageos;
        this.vsphereVolume = vsphereVolume;
    }

    @JsonProperty("awsElasticBlockStore")
    public AWSElasticBlockStoreVolumeSource getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(AWSElasticBlockStoreVolumeSource awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    @JsonProperty("azureDisk")
    public AzureDiskVolumeSource getAzureDisk() {
        return azureDisk;
    }

    @JsonProperty("azureDisk")
    public void setAzureDisk(AzureDiskVolumeSource azureDisk) {
        this.azureDisk = azureDisk;
    }

    @JsonProperty("azureFile")
    public AzureFileVolumeSource getAzureFile() {
        return azureFile;
    }

    @JsonProperty("azureFile")
    public void setAzureFile(AzureFileVolumeSource azureFile) {
        this.azureFile = azureFile;
    }

    @JsonProperty("cephfs")
    public CephFSVolumeSource getCephfs() {
        return cephfs;
    }

    @JsonProperty("cephfs")
    public void setCephfs(CephFSVolumeSource cephfs) {
        this.cephfs = cephfs;
    }

    @JsonProperty("cinder")
    public CinderVolumeSource getCinder() {
        return cinder;
    }

    @JsonProperty("cinder")
    public void setCinder(CinderVolumeSource cinder) {
        this.cinder = cinder;
    }

    @JsonProperty("configMap")
    public ConfigMapVolumeSource getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapVolumeSource configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public CSIVolumeSource getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(CSIVolumeSource csi) {
        this.csi = csi;
    }

    @JsonProperty("downwardAPI")
    public DownwardAPIVolumeSource getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(DownwardAPIVolumeSource downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("emptyDir")
    public EmptyDirVolumeSource getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(EmptyDirVolumeSource emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public EphemeralVolumeSource getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(EphemeralVolumeSource ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("fc")
    public FCVolumeSource getFc() {
        return fc;
    }

    @JsonProperty("fc")
    public void setFc(FCVolumeSource fc) {
        this.fc = fc;
    }

    @JsonProperty("flexVolume")
    public FlexVolumeSource getFlexVolume() {
        return flexVolume;
    }

    @JsonProperty("flexVolume")
    public void setFlexVolume(FlexVolumeSource flexVolume) {
        this.flexVolume = flexVolume;
    }

    @JsonProperty("flocker")
    public FlockerVolumeSource getFlocker() {
        return flocker;
    }

    @JsonProperty("flocker")
    public void setFlocker(FlockerVolumeSource flocker) {
        this.flocker = flocker;
    }

    @JsonProperty("gcePersistentDisk")
    public GCEPersistentDiskVolumeSource getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(GCEPersistentDiskVolumeSource gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    @JsonProperty("gitRepo")
    public GitRepoVolumeSource getGitRepo() {
        return gitRepo;
    }

    @JsonProperty("gitRepo")
    public void setGitRepo(GitRepoVolumeSource gitRepo) {
        this.gitRepo = gitRepo;
    }

    @JsonProperty("glusterfs")
    public GlusterfsVolumeSource getGlusterfs() {
        return glusterfs;
    }

    @JsonProperty("glusterfs")
    public void setGlusterfs(GlusterfsVolumeSource glusterfs) {
        this.glusterfs = glusterfs;
    }

    @JsonProperty("hostPath")
    public HostPathVolumeSource getHostPath() {
        return hostPath;
    }

    @JsonProperty("hostPath")
    public void setHostPath(HostPathVolumeSource hostPath) {
        this.hostPath = hostPath;
    }

    @JsonProperty("iscsi")
    public ISCSIVolumeSource getIscsi() {
        return iscsi;
    }

    @JsonProperty("iscsi")
    public void setIscsi(ISCSIVolumeSource iscsi) {
        this.iscsi = iscsi;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("nfs")
    public NFSVolumeSource getNfs() {
        return nfs;
    }

    @JsonProperty("nfs")
    public void setNfs(NFSVolumeSource nfs) {
        this.nfs = nfs;
    }

    @JsonProperty("persistentVolumeClaim")
    public PersistentVolumeClaimVolumeSource getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("photonPersistentDisk")
    public PhotonPersistentDiskVolumeSource getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(PhotonPersistentDiskVolumeSource photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    @JsonProperty("portworxVolume")
    public PortworxVolumeSource getPortworxVolume() {
        return portworxVolume;
    }

    @JsonProperty("portworxVolume")
    public void setPortworxVolume(PortworxVolumeSource portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    @JsonProperty("projected")
    public ProjectedVolumeSource getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(ProjectedVolumeSource projected) {
        this.projected = projected;
    }

    @JsonProperty("quobyte")
    public QuobyteVolumeSource getQuobyte() {
        return quobyte;
    }

    @JsonProperty("quobyte")
    public void setQuobyte(QuobyteVolumeSource quobyte) {
        this.quobyte = quobyte;
    }

    @JsonProperty("rbd")
    public RBDVolumeSource getRbd() {
        return rbd;
    }

    @JsonProperty("rbd")
    public void setRbd(RBDVolumeSource rbd) {
        this.rbd = rbd;
    }

    @JsonProperty("scaleIO")
    public ScaleIOVolumeSource getScaleIO() {
        return scaleIO;
    }

    @JsonProperty("scaleIO")
    public void setScaleIO(ScaleIOVolumeSource scaleIO) {
        this.scaleIO = scaleIO;
    }

    @JsonProperty("secret")
    public SecretVolumeSource getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(SecretVolumeSource secret) {
        this.secret = secret;
    }

    @JsonProperty("storageos")
    public StorageOSVolumeSource getStorageos() {
        return storageos;
    }

    @JsonProperty("storageos")
    public void setStorageos(StorageOSVolumeSource storageos) {
        this.storageos = storageos;
    }

    @JsonProperty("vsphereVolume")
    public VsphereVirtualDiskVolumeSource getVsphereVolume() {
        return vsphereVolume;
    }

    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(VsphereVirtualDiskVolumeSource vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
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
