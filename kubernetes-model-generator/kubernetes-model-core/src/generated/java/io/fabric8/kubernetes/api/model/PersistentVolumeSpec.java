
package io.fabric8.kubernetes.api.model;

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
import io.sundr.builder.annotations.Buildable;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * PersistentVolumeSpec is the specification of a persistent volume.
 */
@JsonDeserialize(using = com.fasterxml.jackson.databind.JsonDeserializer.None.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "accessModes",
    "awsElasticBlockStore",
    "azureDisk",
    "azureFile",
    "capacity",
    "cephfs",
    "cinder",
    "claimRef",
    "csi",
    "fc",
    "flexVolume",
    "flocker",
    "gcePersistentDisk",
    "glusterfs",
    "hostPath",
    "iscsi",
    "local",
    "mountOptions",
    "nfs",
    "nodeAffinity",
    "persistentVolumeReclaimPolicy",
    "photonPersistentDisk",
    "portworxVolume",
    "quobyte",
    "rbd",
    "scaleIO",
    "storageClassName",
    "storageos",
    "volumeAttributesClassName",
    "volumeMode",
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
public class PersistentVolumeSpec implements Editable<PersistentVolumeSpecBuilder>, KubernetesResource
{

    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> accessModes = new ArrayList<>();
    @JsonProperty("awsElasticBlockStore")
    private AWSElasticBlockStoreVolumeSource awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private AzureDiskVolumeSource azureDisk;
    @JsonProperty("azureFile")
    private AzureFilePersistentVolumeSource azureFile;
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Map<String, Quantity> capacity = new LinkedHashMap<>();
    @JsonProperty("cephfs")
    private CephFSPersistentVolumeSource cephfs;
    @JsonProperty("cinder")
    private CinderPersistentVolumeSource cinder;
    @JsonProperty("claimRef")
    private ObjectReference claimRef;
    @JsonProperty("csi")
    private CSIPersistentVolumeSource csi;
    @JsonProperty("fc")
    private FCVolumeSource fc;
    @JsonProperty("flexVolume")
    private FlexPersistentVolumeSource flexVolume;
    @JsonProperty("flocker")
    private FlockerVolumeSource flocker;
    @JsonProperty("gcePersistentDisk")
    private GCEPersistentDiskVolumeSource gcePersistentDisk;
    @JsonProperty("glusterfs")
    private GlusterfsPersistentVolumeSource glusterfs;
    @JsonProperty("hostPath")
    private HostPathVolumeSource hostPath;
    @JsonProperty("iscsi")
    private ISCSIPersistentVolumeSource iscsi;
    @JsonProperty("local")
    private LocalVolumeSource local;
    @JsonProperty("mountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> mountOptions = new ArrayList<>();
    @JsonProperty("nfs")
    private NFSVolumeSource nfs;
    @JsonProperty("nodeAffinity")
    private VolumeNodeAffinity nodeAffinity;
    @JsonProperty("persistentVolumeReclaimPolicy")
    private String persistentVolumeReclaimPolicy;
    @JsonProperty("photonPersistentDisk")
    private PhotonPersistentDiskVolumeSource photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private PortworxVolumeSource portworxVolume;
    @JsonProperty("quobyte")
    private QuobyteVolumeSource quobyte;
    @JsonProperty("rbd")
    private RBDPersistentVolumeSource rbd;
    @JsonProperty("scaleIO")
    private ScaleIOPersistentVolumeSource scaleIO;
    @JsonProperty("storageClassName")
    private String storageClassName;
    @JsonProperty("storageos")
    private StorageOSPersistentVolumeSource storageos;
    @JsonProperty("volumeAttributesClassName")
    private String volumeAttributesClassName;
    @JsonProperty("volumeMode")
    private String volumeMode;
    @JsonProperty("vsphereVolume")
    private VsphereVirtualDiskVolumeSource vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     */
    public PersistentVolumeSpec() {
    }

    public PersistentVolumeSpec(List<String> accessModes, AWSElasticBlockStoreVolumeSource awsElasticBlockStore, AzureDiskVolumeSource azureDisk, AzureFilePersistentVolumeSource azureFile, Map<String, Quantity> capacity, CephFSPersistentVolumeSource cephfs, CinderPersistentVolumeSource cinder, ObjectReference claimRef, CSIPersistentVolumeSource csi, FCVolumeSource fc, FlexPersistentVolumeSource flexVolume, FlockerVolumeSource flocker, GCEPersistentDiskVolumeSource gcePersistentDisk, GlusterfsPersistentVolumeSource glusterfs, HostPathVolumeSource hostPath, ISCSIPersistentVolumeSource iscsi, LocalVolumeSource local, List<String> mountOptions, NFSVolumeSource nfs, VolumeNodeAffinity nodeAffinity, String persistentVolumeReclaimPolicy, PhotonPersistentDiskVolumeSource photonPersistentDisk, PortworxVolumeSource portworxVolume, QuobyteVolumeSource quobyte, RBDPersistentVolumeSource rbd, ScaleIOPersistentVolumeSource scaleIO, String storageClassName, StorageOSPersistentVolumeSource storageos, String volumeAttributesClassName, String volumeMode, VsphereVirtualDiskVolumeSource vsphereVolume) {
        super();
        this.accessModes = accessModes;
        this.awsElasticBlockStore = awsElasticBlockStore;
        this.azureDisk = azureDisk;
        this.azureFile = azureFile;
        this.capacity = capacity;
        this.cephfs = cephfs;
        this.cinder = cinder;
        this.claimRef = claimRef;
        this.csi = csi;
        this.fc = fc;
        this.flexVolume = flexVolume;
        this.flocker = flocker;
        this.gcePersistentDisk = gcePersistentDisk;
        this.glusterfs = glusterfs;
        this.hostPath = hostPath;
        this.iscsi = iscsi;
        this.local = local;
        this.mountOptions = mountOptions;
        this.nfs = nfs;
        this.nodeAffinity = nodeAffinity;
        this.persistentVolumeReclaimPolicy = persistentVolumeReclaimPolicy;
        this.photonPersistentDisk = photonPersistentDisk;
        this.portworxVolume = portworxVolume;
        this.quobyte = quobyte;
        this.rbd = rbd;
        this.scaleIO = scaleIO;
        this.storageClassName = storageClassName;
        this.storageos = storageos;
        this.volumeAttributesClassName = volumeAttributesClassName;
        this.volumeMode = volumeMode;
        this.vsphereVolume = vsphereVolume;
    }

    /**
     * accessModes contains all ways the volume can be mounted. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes
     */
    @JsonProperty("accessModes")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getAccessModes() {
        return accessModes;
    }

    /**
     * accessModes contains all ways the volume can be mounted. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#access-modes
     */
    @JsonProperty("accessModes")
    public void setAccessModes(List<String> accessModes) {
        this.accessModes = accessModes;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("awsElasticBlockStore")
    public AWSElasticBlockStoreVolumeSource getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(AWSElasticBlockStoreVolumeSource awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("azureDisk")
    public AzureDiskVolumeSource getAzureDisk() {
        return azureDisk;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("azureDisk")
    public void setAzureDisk(AzureDiskVolumeSource azureDisk) {
        this.azureDisk = azureDisk;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("azureFile")
    public AzureFilePersistentVolumeSource getAzureFile() {
        return azureFile;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("azureFile")
    public void setAzureFile(AzureFilePersistentVolumeSource azureFile) {
        this.azureFile = azureFile;
    }

    /**
     * capacity is the description of the persistent volume's resources and capacity. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#capacity
     */
    @JsonProperty("capacity")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Map<String, Quantity> getCapacity() {
        return capacity;
    }

    /**
     * capacity is the description of the persistent volume's resources and capacity. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#capacity
     */
    @JsonProperty("capacity")
    public void setCapacity(Map<String, Quantity> capacity) {
        this.capacity = capacity;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("cephfs")
    public CephFSPersistentVolumeSource getCephfs() {
        return cephfs;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("cephfs")
    public void setCephfs(CephFSPersistentVolumeSource cephfs) {
        this.cephfs = cephfs;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("cinder")
    public CinderPersistentVolumeSource getCinder() {
        return cinder;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("cinder")
    public void setCinder(CinderPersistentVolumeSource cinder) {
        this.cinder = cinder;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("claimRef")
    public ObjectReference getClaimRef() {
        return claimRef;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("claimRef")
    public void setClaimRef(ObjectReference claimRef) {
        this.claimRef = claimRef;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("csi")
    public CSIPersistentVolumeSource getCsi() {
        return csi;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("csi")
    public void setCsi(CSIPersistentVolumeSource csi) {
        this.csi = csi;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("fc")
    public FCVolumeSource getFc() {
        return fc;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("fc")
    public void setFc(FCVolumeSource fc) {
        this.fc = fc;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("flexVolume")
    public FlexPersistentVolumeSource getFlexVolume() {
        return flexVolume;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("flexVolume")
    public void setFlexVolume(FlexPersistentVolumeSource flexVolume) {
        this.flexVolume = flexVolume;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("flocker")
    public FlockerVolumeSource getFlocker() {
        return flocker;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("flocker")
    public void setFlocker(FlockerVolumeSource flocker) {
        this.flocker = flocker;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("gcePersistentDisk")
    public GCEPersistentDiskVolumeSource getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(GCEPersistentDiskVolumeSource gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("glusterfs")
    public GlusterfsPersistentVolumeSource getGlusterfs() {
        return glusterfs;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("glusterfs")
    public void setGlusterfs(GlusterfsPersistentVolumeSource glusterfs) {
        this.glusterfs = glusterfs;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("hostPath")
    public HostPathVolumeSource getHostPath() {
        return hostPath;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("hostPath")
    public void setHostPath(HostPathVolumeSource hostPath) {
        this.hostPath = hostPath;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("iscsi")
    public ISCSIPersistentVolumeSource getIscsi() {
        return iscsi;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("iscsi")
    public void setIscsi(ISCSIPersistentVolumeSource iscsi) {
        this.iscsi = iscsi;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("local")
    public LocalVolumeSource getLocal() {
        return local;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("local")
    public void setLocal(LocalVolumeSource local) {
        this.local = local;
    }

    /**
     * mountOptions is the list of mount options, e.g. ["ro", "soft"]. Not validated - mount will simply fail if one is invalid. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes/#mount-options
     */
    @JsonProperty("mountOptions")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<String> getMountOptions() {
        return mountOptions;
    }

    /**
     * mountOptions is the list of mount options, e.g. ["ro", "soft"]. Not validated - mount will simply fail if one is invalid. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes/#mount-options
     */
    @JsonProperty("mountOptions")
    public void setMountOptions(List<String> mountOptions) {
        this.mountOptions = mountOptions;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("nfs")
    public NFSVolumeSource getNfs() {
        return nfs;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("nfs")
    public void setNfs(NFSVolumeSource nfs) {
        this.nfs = nfs;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("nodeAffinity")
    public VolumeNodeAffinity getNodeAffinity() {
        return nodeAffinity;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("nodeAffinity")
    public void setNodeAffinity(VolumeNodeAffinity nodeAffinity) {
        this.nodeAffinity = nodeAffinity;
    }

    /**
     * persistentVolumeReclaimPolicy defines what happens to a persistent volume when released from its claim. Valid options are Retain (default for manually created PersistentVolumes), Delete (default for dynamically provisioned PersistentVolumes), and Recycle (deprecated). Recycle must be supported by the volume plugin underlying this PersistentVolume. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#reclaiming
     */
    @JsonProperty("persistentVolumeReclaimPolicy")
    public String getPersistentVolumeReclaimPolicy() {
        return persistentVolumeReclaimPolicy;
    }

    /**
     * persistentVolumeReclaimPolicy defines what happens to a persistent volume when released from its claim. Valid options are Retain (default for manually created PersistentVolumes), Delete (default for dynamically provisioned PersistentVolumes), and Recycle (deprecated). Recycle must be supported by the volume plugin underlying this PersistentVolume. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#reclaiming
     */
    @JsonProperty("persistentVolumeReclaimPolicy")
    public void setPersistentVolumeReclaimPolicy(String persistentVolumeReclaimPolicy) {
        this.persistentVolumeReclaimPolicy = persistentVolumeReclaimPolicy;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("photonPersistentDisk")
    public PhotonPersistentDiskVolumeSource getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(PhotonPersistentDiskVolumeSource photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("portworxVolume")
    public PortworxVolumeSource getPortworxVolume() {
        return portworxVolume;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("portworxVolume")
    public void setPortworxVolume(PortworxVolumeSource portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("quobyte")
    public QuobyteVolumeSource getQuobyte() {
        return quobyte;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("quobyte")
    public void setQuobyte(QuobyteVolumeSource quobyte) {
        this.quobyte = quobyte;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("rbd")
    public RBDPersistentVolumeSource getRbd() {
        return rbd;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("rbd")
    public void setRbd(RBDPersistentVolumeSource rbd) {
        this.rbd = rbd;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("scaleIO")
    public ScaleIOPersistentVolumeSource getScaleIO() {
        return scaleIO;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("scaleIO")
    public void setScaleIO(ScaleIOPersistentVolumeSource scaleIO) {
        this.scaleIO = scaleIO;
    }

    /**
     * storageClassName is the name of StorageClass to which this persistent volume belongs. Empty value means that this volume does not belong to any StorageClass.
     */
    @JsonProperty("storageClassName")
    public String getStorageClassName() {
        return storageClassName;
    }

    /**
     * storageClassName is the name of StorageClass to which this persistent volume belongs. Empty value means that this volume does not belong to any StorageClass.
     */
    @JsonProperty("storageClassName")
    public void setStorageClassName(String storageClassName) {
        this.storageClassName = storageClassName;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("storageos")
    public StorageOSPersistentVolumeSource getStorageos() {
        return storageos;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("storageos")
    public void setStorageos(StorageOSPersistentVolumeSource storageos) {
        this.storageos = storageos;
    }

    /**
     * Name of VolumeAttributesClass to which this persistent volume belongs. Empty value is not allowed. When this field is not set, it indicates that this volume does not belong to any VolumeAttributesClass. This field is mutable and can be changed by the CSI driver after a volume has been updated successfully to a new class. For an unbound PersistentVolume, the volumeAttributesClassName will be matched with unbound PersistentVolumeClaims during the binding process.
     */
    @JsonProperty("volumeAttributesClassName")
    public String getVolumeAttributesClassName() {
        return volumeAttributesClassName;
    }

    /**
     * Name of VolumeAttributesClass to which this persistent volume belongs. Empty value is not allowed. When this field is not set, it indicates that this volume does not belong to any VolumeAttributesClass. This field is mutable and can be changed by the CSI driver after a volume has been updated successfully to a new class. For an unbound PersistentVolume, the volumeAttributesClassName will be matched with unbound PersistentVolumeClaims during the binding process.
     */
    @JsonProperty("volumeAttributesClassName")
    public void setVolumeAttributesClassName(String volumeAttributesClassName) {
        this.volumeAttributesClassName = volumeAttributesClassName;
    }

    /**
     * volumeMode defines if a volume is intended to be used with a formatted filesystem or to remain in raw block state. Value of Filesystem is implied when not included in spec.
     */
    @JsonProperty("volumeMode")
    public String getVolumeMode() {
        return volumeMode;
    }

    /**
     * volumeMode defines if a volume is intended to be used with a formatted filesystem or to remain in raw block state. Value of Filesystem is implied when not included in spec.
     */
    @JsonProperty("volumeMode")
    public void setVolumeMode(String volumeMode) {
        this.volumeMode = volumeMode;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("vsphereVolume")
    public VsphereVirtualDiskVolumeSource getVsphereVolume() {
        return vsphereVolume;
    }

    /**
     * PersistentVolumeSpec is the specification of a persistent volume.
     */
    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(VsphereVirtualDiskVolumeSource vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public PersistentVolumeSpecBuilder edit() {
        return new PersistentVolumeSpecBuilder(this);
    }

    @JsonIgnore
    public PersistentVolumeSpecBuilder toBuilder() {
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

}
