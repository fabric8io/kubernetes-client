
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
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
import io.sundr.builder.annotations.Buildable;

/**
 * Volume represents a named volume in a pod that may be accessed by any container in the pod.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
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
    "image",
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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder")
@Generated("io.fabric8.kubernetes.schema.generator.model.ModelGenerator")
public class Volume implements Editable<VolumeBuilder>, KubernetesResource
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
    @JsonProperty("image")
    private ImageVolumeSource image;
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
     */
    public Volume() {
    }

    public Volume(AWSElasticBlockStoreVolumeSource awsElasticBlockStore, AzureDiskVolumeSource azureDisk, AzureFileVolumeSource azureFile, CephFSVolumeSource cephfs, CinderVolumeSource cinder, ConfigMapVolumeSource configMap, CSIVolumeSource csi, DownwardAPIVolumeSource downwardAPI, EmptyDirVolumeSource emptyDir, EphemeralVolumeSource ephemeral, FCVolumeSource fc, FlexVolumeSource flexVolume, FlockerVolumeSource flocker, GCEPersistentDiskVolumeSource gcePersistentDisk, GitRepoVolumeSource gitRepo, GlusterfsVolumeSource glusterfs, HostPathVolumeSource hostPath, ImageVolumeSource image, ISCSIVolumeSource iscsi, String name, NFSVolumeSource nfs, PersistentVolumeClaimVolumeSource persistentVolumeClaim, PhotonPersistentDiskVolumeSource photonPersistentDisk, PortworxVolumeSource portworxVolume, ProjectedVolumeSource projected, QuobyteVolumeSource quobyte, RBDVolumeSource rbd, ScaleIOVolumeSource scaleIO, SecretVolumeSource secret, StorageOSVolumeSource storageos, VsphereVirtualDiskVolumeSource vsphereVolume) {
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
        this.image = image;
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

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("awsElasticBlockStore")
    public AWSElasticBlockStoreVolumeSource getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(AWSElasticBlockStoreVolumeSource awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("azureDisk")
    public AzureDiskVolumeSource getAzureDisk() {
        return azureDisk;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("azureDisk")
    public void setAzureDisk(AzureDiskVolumeSource azureDisk) {
        this.azureDisk = azureDisk;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("azureFile")
    public AzureFileVolumeSource getAzureFile() {
        return azureFile;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("azureFile")
    public void setAzureFile(AzureFileVolumeSource azureFile) {
        this.azureFile = azureFile;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("cephfs")
    public CephFSVolumeSource getCephfs() {
        return cephfs;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("cephfs")
    public void setCephfs(CephFSVolumeSource cephfs) {
        this.cephfs = cephfs;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("cinder")
    public CinderVolumeSource getCinder() {
        return cinder;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("cinder")
    public void setCinder(CinderVolumeSource cinder) {
        this.cinder = cinder;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("configMap")
    public ConfigMapVolumeSource getConfigMap() {
        return configMap;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("configMap")
    public void setConfigMap(ConfigMapVolumeSource configMap) {
        this.configMap = configMap;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("csi")
    public CSIVolumeSource getCsi() {
        return csi;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("csi")
    public void setCsi(CSIVolumeSource csi) {
        this.csi = csi;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("downwardAPI")
    public DownwardAPIVolumeSource getDownwardAPI() {
        return downwardAPI;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("downwardAPI")
    public void setDownwardAPI(DownwardAPIVolumeSource downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("emptyDir")
    public EmptyDirVolumeSource getEmptyDir() {
        return emptyDir;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("emptyDir")
    public void setEmptyDir(EmptyDirVolumeSource emptyDir) {
        this.emptyDir = emptyDir;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("ephemeral")
    public EphemeralVolumeSource getEphemeral() {
        return ephemeral;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("ephemeral")
    public void setEphemeral(EphemeralVolumeSource ephemeral) {
        this.ephemeral = ephemeral;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("fc")
    public FCVolumeSource getFc() {
        return fc;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("fc")
    public void setFc(FCVolumeSource fc) {
        this.fc = fc;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("flexVolume")
    public FlexVolumeSource getFlexVolume() {
        return flexVolume;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("flexVolume")
    public void setFlexVolume(FlexVolumeSource flexVolume) {
        this.flexVolume = flexVolume;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("flocker")
    public FlockerVolumeSource getFlocker() {
        return flocker;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("flocker")
    public void setFlocker(FlockerVolumeSource flocker) {
        this.flocker = flocker;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("gcePersistentDisk")
    public GCEPersistentDiskVolumeSource getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(GCEPersistentDiskVolumeSource gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("gitRepo")
    public GitRepoVolumeSource getGitRepo() {
        return gitRepo;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("gitRepo")
    public void setGitRepo(GitRepoVolumeSource gitRepo) {
        this.gitRepo = gitRepo;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("glusterfs")
    public GlusterfsVolumeSource getGlusterfs() {
        return glusterfs;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("glusterfs")
    public void setGlusterfs(GlusterfsVolumeSource glusterfs) {
        this.glusterfs = glusterfs;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("hostPath")
    public HostPathVolumeSource getHostPath() {
        return hostPath;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("hostPath")
    public void setHostPath(HostPathVolumeSource hostPath) {
        this.hostPath = hostPath;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("image")
    public ImageVolumeSource getImage() {
        return image;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("image")
    public void setImage(ImageVolumeSource image) {
        this.image = image;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("iscsi")
    public ISCSIVolumeSource getIscsi() {
        return iscsi;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("iscsi")
    public void setIscsi(ISCSIVolumeSource iscsi) {
        this.iscsi = iscsi;
    }

    /**
     * name of the volume. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * name of the volume. Must be a DNS_LABEL and unique within the pod. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("nfs")
    public NFSVolumeSource getNfs() {
        return nfs;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("nfs")
    public void setNfs(NFSVolumeSource nfs) {
        this.nfs = nfs;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("persistentVolumeClaim")
    public PersistentVolumeClaimVolumeSource getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("photonPersistentDisk")
    public PhotonPersistentDiskVolumeSource getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(PhotonPersistentDiskVolumeSource photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("portworxVolume")
    public PortworxVolumeSource getPortworxVolume() {
        return portworxVolume;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("portworxVolume")
    public void setPortworxVolume(PortworxVolumeSource portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("projected")
    public ProjectedVolumeSource getProjected() {
        return projected;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("projected")
    public void setProjected(ProjectedVolumeSource projected) {
        this.projected = projected;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("quobyte")
    public QuobyteVolumeSource getQuobyte() {
        return quobyte;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("quobyte")
    public void setQuobyte(QuobyteVolumeSource quobyte) {
        this.quobyte = quobyte;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("rbd")
    public RBDVolumeSource getRbd() {
        return rbd;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("rbd")
    public void setRbd(RBDVolumeSource rbd) {
        this.rbd = rbd;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("scaleIO")
    public ScaleIOVolumeSource getScaleIO() {
        return scaleIO;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("scaleIO")
    public void setScaleIO(ScaleIOVolumeSource scaleIO) {
        this.scaleIO = scaleIO;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("secret")
    public SecretVolumeSource getSecret() {
        return secret;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("secret")
    public void setSecret(SecretVolumeSource secret) {
        this.secret = secret;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("storageos")
    public StorageOSVolumeSource getStorageos() {
        return storageos;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("storageos")
    public void setStorageos(StorageOSVolumeSource storageos) {
        this.storageos = storageos;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("vsphereVolume")
    public VsphereVirtualDiskVolumeSource getVsphereVolume() {
        return vsphereVolume;
    }

    /**
     * Volume represents a named volume in a pod that may be accessed by any container in the pod.
     */
    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(VsphereVirtualDiskVolumeSource vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public VolumeBuilder edit() {
        return new VolumeBuilder(this);
    }

    @JsonIgnore
    public VolumeBuilder toBuilder() {
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
        if (!(o instanceof Volume)) {
            return false;
        }
        Volume other = (Volume) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$awsElasticBlockStore = this.getAwsElasticBlockStore();
        Object other$awsElasticBlockStore = other.getAwsElasticBlockStore();
        if (this$awsElasticBlockStore == null ? other$awsElasticBlockStore != null : !this$awsElasticBlockStore.equals(other$awsElasticBlockStore)) {
            return false;
        }
        Object this$azureDisk = this.getAzureDisk();
        Object other$azureDisk = other.getAzureDisk();
        if (this$azureDisk == null ? other$azureDisk != null : !this$azureDisk.equals(other$azureDisk)) {
            return false;
        }
        Object this$azureFile = this.getAzureFile();
        Object other$azureFile = other.getAzureFile();
        if (this$azureFile == null ? other$azureFile != null : !this$azureFile.equals(other$azureFile)) {
            return false;
        }
        Object this$cephfs = this.getCephfs();
        Object other$cephfs = other.getCephfs();
        if (this$cephfs == null ? other$cephfs != null : !this$cephfs.equals(other$cephfs)) {
            return false;
        }
        Object this$cinder = this.getCinder();
        Object other$cinder = other.getCinder();
        if (this$cinder == null ? other$cinder != null : !this$cinder.equals(other$cinder)) {
            return false;
        }
        Object this$configMap = this.getConfigMap();
        Object other$configMap = other.getConfigMap();
        if (this$configMap == null ? other$configMap != null : !this$configMap.equals(other$configMap)) {
            return false;
        }
        Object this$csi = this.getCsi();
        Object other$csi = other.getCsi();
        if (this$csi == null ? other$csi != null : !this$csi.equals(other$csi)) {
            return false;
        }
        Object this$downwardAPI = this.getDownwardAPI();
        Object other$downwardAPI = other.getDownwardAPI();
        if (this$downwardAPI == null ? other$downwardAPI != null : !this$downwardAPI.equals(other$downwardAPI)) {
            return false;
        }
        Object this$emptyDir = this.getEmptyDir();
        Object other$emptyDir = other.getEmptyDir();
        if (this$emptyDir == null ? other$emptyDir != null : !this$emptyDir.equals(other$emptyDir)) {
            return false;
        }
        Object this$ephemeral = this.getEphemeral();
        Object other$ephemeral = other.getEphemeral();
        if (this$ephemeral == null ? other$ephemeral != null : !this$ephemeral.equals(other$ephemeral)) {
            return false;
        }
        Object this$fc = this.getFc();
        Object other$fc = other.getFc();
        if (this$fc == null ? other$fc != null : !this$fc.equals(other$fc)) {
            return false;
        }
        Object this$flexVolume = this.getFlexVolume();
        Object other$flexVolume = other.getFlexVolume();
        if (this$flexVolume == null ? other$flexVolume != null : !this$flexVolume.equals(other$flexVolume)) {
            return false;
        }
        Object this$flocker = this.getFlocker();
        Object other$flocker = other.getFlocker();
        if (this$flocker == null ? other$flocker != null : !this$flocker.equals(other$flocker)) {
            return false;
        }
        Object this$gcePersistentDisk = this.getGcePersistentDisk();
        Object other$gcePersistentDisk = other.getGcePersistentDisk();
        if (this$gcePersistentDisk == null ? other$gcePersistentDisk != null : !this$gcePersistentDisk.equals(other$gcePersistentDisk)) {
            return false;
        }
        Object this$gitRepo = this.getGitRepo();
        Object other$gitRepo = other.getGitRepo();
        if (this$gitRepo == null ? other$gitRepo != null : !this$gitRepo.equals(other$gitRepo)) {
            return false;
        }
        Object this$glusterfs = this.getGlusterfs();
        Object other$glusterfs = other.getGlusterfs();
        if (this$glusterfs == null ? other$glusterfs != null : !this$glusterfs.equals(other$glusterfs)) {
            return false;
        }
        Object this$hostPath = this.getHostPath();
        Object other$hostPath = other.getHostPath();
        if (this$hostPath == null ? other$hostPath != null : !this$hostPath.equals(other$hostPath)) {
            return false;
        }
        Object this$image = this.getImage();
        Object other$image = other.getImage();
        if (this$image == null ? other$image != null : !this$image.equals(other$image)) {
            return false;
        }
        Object this$iscsi = this.getIscsi();
        Object other$iscsi = other.getIscsi();
        if (this$iscsi == null ? other$iscsi != null : !this$iscsi.equals(other$iscsi)) {
            return false;
        }
        Object this$name = this.getName();
        Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) {
            return false;
        }
        Object this$nfs = this.getNfs();
        Object other$nfs = other.getNfs();
        if (this$nfs == null ? other$nfs != null : !this$nfs.equals(other$nfs)) {
            return false;
        }
        Object this$persistentVolumeClaim = this.getPersistentVolumeClaim();
        Object other$persistentVolumeClaim = other.getPersistentVolumeClaim();
        if (this$persistentVolumeClaim == null ? other$persistentVolumeClaim != null : !this$persistentVolumeClaim.equals(other$persistentVolumeClaim)) {
            return false;
        }
        Object this$photonPersistentDisk = this.getPhotonPersistentDisk();
        Object other$photonPersistentDisk = other.getPhotonPersistentDisk();
        if (this$photonPersistentDisk == null ? other$photonPersistentDisk != null : !this$photonPersistentDisk.equals(other$photonPersistentDisk)) {
            return false;
        }
        Object this$portworxVolume = this.getPortworxVolume();
        Object other$portworxVolume = other.getPortworxVolume();
        if (this$portworxVolume == null ? other$portworxVolume != null : !this$portworxVolume.equals(other$portworxVolume)) {
            return false;
        }
        Object this$projected = this.getProjected();
        Object other$projected = other.getProjected();
        if (this$projected == null ? other$projected != null : !this$projected.equals(other$projected)) {
            return false;
        }
        Object this$quobyte = this.getQuobyte();
        Object other$quobyte = other.getQuobyte();
        if (this$quobyte == null ? other$quobyte != null : !this$quobyte.equals(other$quobyte)) {
            return false;
        }
        Object this$rbd = this.getRbd();
        Object other$rbd = other.getRbd();
        if (this$rbd == null ? other$rbd != null : !this$rbd.equals(other$rbd)) {
            return false;
        }
        Object this$scaleIO = this.getScaleIO();
        Object other$scaleIO = other.getScaleIO();
        if (this$scaleIO == null ? other$scaleIO != null : !this$scaleIO.equals(other$scaleIO)) {
            return false;
        }
        Object this$secret = this.getSecret();
        Object other$secret = other.getSecret();
        if (this$secret == null ? other$secret != null : !this$secret.equals(other$secret)) {
            return false;
        }
        Object this$storageos = this.getStorageos();
        Object other$storageos = other.getStorageos();
        if (this$storageos == null ? other$storageos != null : !this$storageos.equals(other$storageos)) {
            return false;
        }
        Object this$vsphereVolume = this.getVsphereVolume();
        Object other$vsphereVolume = other.getVsphereVolume();
        if (this$vsphereVolume == null ? other$vsphereVolume != null : !this$vsphereVolume.equals(other$vsphereVolume)) {
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
        return other instanceof Volume;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $awsElasticBlockStore = this.getAwsElasticBlockStore();
        result = result * prime + ($awsElasticBlockStore == null ? 43 : $awsElasticBlockStore.hashCode());
        Object $azureDisk = this.getAzureDisk();
        result = result * prime + ($azureDisk == null ? 43 : $azureDisk.hashCode());
        Object $azureFile = this.getAzureFile();
        result = result * prime + ($azureFile == null ? 43 : $azureFile.hashCode());
        Object $cephfs = this.getCephfs();
        result = result * prime + ($cephfs == null ? 43 : $cephfs.hashCode());
        Object $cinder = this.getCinder();
        result = result * prime + ($cinder == null ? 43 : $cinder.hashCode());
        Object $configMap = this.getConfigMap();
        result = result * prime + ($configMap == null ? 43 : $configMap.hashCode());
        Object $csi = this.getCsi();
        result = result * prime + ($csi == null ? 43 : $csi.hashCode());
        Object $downwardAPI = this.getDownwardAPI();
        result = result * prime + ($downwardAPI == null ? 43 : $downwardAPI.hashCode());
        Object $emptyDir = this.getEmptyDir();
        result = result * prime + ($emptyDir == null ? 43 : $emptyDir.hashCode());
        Object $ephemeral = this.getEphemeral();
        result = result * prime + ($ephemeral == null ? 43 : $ephemeral.hashCode());
        Object $fc = this.getFc();
        result = result * prime + ($fc == null ? 43 : $fc.hashCode());
        Object $flexVolume = this.getFlexVolume();
        result = result * prime + ($flexVolume == null ? 43 : $flexVolume.hashCode());
        Object $flocker = this.getFlocker();
        result = result * prime + ($flocker == null ? 43 : $flocker.hashCode());
        Object $gcePersistentDisk = this.getGcePersistentDisk();
        result = result * prime + ($gcePersistentDisk == null ? 43 : $gcePersistentDisk.hashCode());
        Object $gitRepo = this.getGitRepo();
        result = result * prime + ($gitRepo == null ? 43 : $gitRepo.hashCode());
        Object $glusterfs = this.getGlusterfs();
        result = result * prime + ($glusterfs == null ? 43 : $glusterfs.hashCode());
        Object $hostPath = this.getHostPath();
        result = result * prime + ($hostPath == null ? 43 : $hostPath.hashCode());
        Object $image = this.getImage();
        result = result * prime + ($image == null ? 43 : $image.hashCode());
        Object $iscsi = this.getIscsi();
        result = result * prime + ($iscsi == null ? 43 : $iscsi.hashCode());
        Object $name = this.getName();
        result = result * prime + ($name == null ? 43 : $name.hashCode());
        Object $nfs = this.getNfs();
        result = result * prime + ($nfs == null ? 43 : $nfs.hashCode());
        Object $persistentVolumeClaim = this.getPersistentVolumeClaim();
        result = result * prime + ($persistentVolumeClaim == null ? 43 : $persistentVolumeClaim.hashCode());
        Object $photonPersistentDisk = this.getPhotonPersistentDisk();
        result = result * prime + ($photonPersistentDisk == null ? 43 : $photonPersistentDisk.hashCode());
        Object $portworxVolume = this.getPortworxVolume();
        result = result * prime + ($portworxVolume == null ? 43 : $portworxVolume.hashCode());
        Object $projected = this.getProjected();
        result = result * prime + ($projected == null ? 43 : $projected.hashCode());
        Object $quobyte = this.getQuobyte();
        result = result * prime + ($quobyte == null ? 43 : $quobyte.hashCode());
        Object $rbd = this.getRbd();
        result = result * prime + ($rbd == null ? 43 : $rbd.hashCode());
        Object $scaleIO = this.getScaleIO();
        result = result * prime + ($scaleIO == null ? 43 : $scaleIO.hashCode());
        Object $secret = this.getSecret();
        result = result * prime + ($secret == null ? 43 : $secret.hashCode());
        Object $storageos = this.getStorageos();
        result = result * prime + ($storageos == null ? 43 : $storageos.hashCode());
        Object $vsphereVolume = this.getVsphereVolume();
        result = result * prime + ($vsphereVolume == null ? 43 : $vsphereVolume.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Volume(" + "awsElasticBlockStore=" + this.getAwsElasticBlockStore() + ", azureDisk=" + this.getAzureDisk() + ", azureFile=" + this.getAzureFile() + ", cephfs=" + this.getCephfs() + ", cinder=" + this.getCinder() + ", configMap=" + this.getConfigMap() + ", csi=" + this.getCsi() + ", downwardAPI=" + this.getDownwardAPI() + ", emptyDir=" + this.getEmptyDir() + ", ephemeral=" + this.getEphemeral() + ", fc=" + this.getFc() + ", flexVolume=" + this.getFlexVolume() + ", flocker=" + this.getFlocker() + ", gcePersistentDisk=" + this.getGcePersistentDisk() + ", gitRepo=" + this.getGitRepo() + ", glusterfs=" + this.getGlusterfs() + ", hostPath=" + this.getHostPath() + ", image=" + this.getImage() + ", iscsi=" + this.getIscsi() + ", name=" + this.getName() + ", nfs=" + this.getNfs() + ", persistentVolumeClaim=" + this.getPersistentVolumeClaim() + ", photonPersistentDisk=" + this.getPhotonPersistentDisk() + ", portworxVolume=" + this.getPortworxVolume() + ", projected=" + this.getProjected() + ", quobyte=" + this.getQuobyte() + ", rbd=" + this.getRbd() + ", scaleIO=" + this.getScaleIO() + ", secret=" + this.getSecret() + ", storageos=" + this.getStorageos() + ", vsphereVolume=" + this.getVsphereVolume() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
