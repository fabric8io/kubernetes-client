
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
import io.fabric8.kubernetes.api.builder.Editable;
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@ToString
@EqualsAndHashCode
@Accessors(prefix = {
    "_",
    ""
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

}
