
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
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PersistentVolumeSpec)) {
            return false;
        }
        PersistentVolumeSpec other = (PersistentVolumeSpec) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$accessModes = this.getAccessModes();
        Object other$accessModes = other.getAccessModes();
        if (this$accessModes == null ? other$accessModes != null : !this$accessModes.equals(other$accessModes)) {
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
        Object this$capacity = this.getCapacity();
        Object other$capacity = other.getCapacity();
        if (this$capacity == null ? other$capacity != null : !this$capacity.equals(other$capacity)) {
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
        Object this$claimRef = this.getClaimRef();
        Object other$claimRef = other.getClaimRef();
        if (this$claimRef == null ? other$claimRef != null : !this$claimRef.equals(other$claimRef)) {
            return false;
        }
        Object this$csi = this.getCsi();
        Object other$csi = other.getCsi();
        if (this$csi == null ? other$csi != null : !this$csi.equals(other$csi)) {
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
        Object this$iscsi = this.getIscsi();
        Object other$iscsi = other.getIscsi();
        if (this$iscsi == null ? other$iscsi != null : !this$iscsi.equals(other$iscsi)) {
            return false;
        }
        Object this$local = this.getLocal();
        Object other$local = other.getLocal();
        if (this$local == null ? other$local != null : !this$local.equals(other$local)) {
            return false;
        }
        Object this$mountOptions = this.getMountOptions();
        Object other$mountOptions = other.getMountOptions();
        if (this$mountOptions == null ? other$mountOptions != null : !this$mountOptions.equals(other$mountOptions)) {
            return false;
        }
        Object this$nfs = this.getNfs();
        Object other$nfs = other.getNfs();
        if (this$nfs == null ? other$nfs != null : !this$nfs.equals(other$nfs)) {
            return false;
        }
        Object this$nodeAffinity = this.getNodeAffinity();
        Object other$nodeAffinity = other.getNodeAffinity();
        if (this$nodeAffinity == null ? other$nodeAffinity != null : !this$nodeAffinity.equals(other$nodeAffinity)) {
            return false;
        }
        Object this$persistentVolumeReclaimPolicy = this.getPersistentVolumeReclaimPolicy();
        Object other$persistentVolumeReclaimPolicy = other.getPersistentVolumeReclaimPolicy();
        if (this$persistentVolumeReclaimPolicy == null ? other$persistentVolumeReclaimPolicy != null : !this$persistentVolumeReclaimPolicy.equals(other$persistentVolumeReclaimPolicy)) {
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
        Object this$storageClassName = this.getStorageClassName();
        Object other$storageClassName = other.getStorageClassName();
        if (this$storageClassName == null ? other$storageClassName != null : !this$storageClassName.equals(other$storageClassName)) {
            return false;
        }
        Object this$storageos = this.getStorageos();
        Object other$storageos = other.getStorageos();
        if (this$storageos == null ? other$storageos != null : !this$storageos.equals(other$storageos)) {
            return false;
        }
        Object this$volumeAttributesClassName = this.getVolumeAttributesClassName();
        Object other$volumeAttributesClassName = other.getVolumeAttributesClassName();
        if (this$volumeAttributesClassName == null ? other$volumeAttributesClassName != null : !this$volumeAttributesClassName.equals(other$volumeAttributesClassName)) {
            return false;
        }
        Object this$volumeMode = this.getVolumeMode();
        Object other$volumeMode = other.getVolumeMode();
        if (this$volumeMode == null ? other$volumeMode != null : !this$volumeMode.equals(other$volumeMode)) {
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
        return other instanceof PersistentVolumeSpec;
    }

    @Override
    public int hashCode() {
        final int prime = 59;
        int result = 1;
        Object $accessModes = this.getAccessModes();
        result = result * prime + ($accessModes == null ? 43 : $accessModes.hashCode());
        Object $awsElasticBlockStore = this.getAwsElasticBlockStore();
        result = result * prime + ($awsElasticBlockStore == null ? 43 : $awsElasticBlockStore.hashCode());
        Object $azureDisk = this.getAzureDisk();
        result = result * prime + ($azureDisk == null ? 43 : $azureDisk.hashCode());
        Object $azureFile = this.getAzureFile();
        result = result * prime + ($azureFile == null ? 43 : $azureFile.hashCode());
        Object $capacity = this.getCapacity();
        result = result * prime + ($capacity == null ? 43 : $capacity.hashCode());
        Object $cephfs = this.getCephfs();
        result = result * prime + ($cephfs == null ? 43 : $cephfs.hashCode());
        Object $cinder = this.getCinder();
        result = result * prime + ($cinder == null ? 43 : $cinder.hashCode());
        Object $claimRef = this.getClaimRef();
        result = result * prime + ($claimRef == null ? 43 : $claimRef.hashCode());
        Object $csi = this.getCsi();
        result = result * prime + ($csi == null ? 43 : $csi.hashCode());
        Object $fc = this.getFc();
        result = result * prime + ($fc == null ? 43 : $fc.hashCode());
        Object $flexVolume = this.getFlexVolume();
        result = result * prime + ($flexVolume == null ? 43 : $flexVolume.hashCode());
        Object $flocker = this.getFlocker();
        result = result * prime + ($flocker == null ? 43 : $flocker.hashCode());
        Object $gcePersistentDisk = this.getGcePersistentDisk();
        result = result * prime + ($gcePersistentDisk == null ? 43 : $gcePersistentDisk.hashCode());
        Object $glusterfs = this.getGlusterfs();
        result = result * prime + ($glusterfs == null ? 43 : $glusterfs.hashCode());
        Object $hostPath = this.getHostPath();
        result = result * prime + ($hostPath == null ? 43 : $hostPath.hashCode());
        Object $iscsi = this.getIscsi();
        result = result * prime + ($iscsi == null ? 43 : $iscsi.hashCode());
        Object $local = this.getLocal();
        result = result * prime + ($local == null ? 43 : $local.hashCode());
        Object $mountOptions = this.getMountOptions();
        result = result * prime + ($mountOptions == null ? 43 : $mountOptions.hashCode());
        Object $nfs = this.getNfs();
        result = result * prime + ($nfs == null ? 43 : $nfs.hashCode());
        Object $nodeAffinity = this.getNodeAffinity();
        result = result * prime + ($nodeAffinity == null ? 43 : $nodeAffinity.hashCode());
        Object $persistentVolumeReclaimPolicy = this.getPersistentVolumeReclaimPolicy();
        result = result * prime + ($persistentVolumeReclaimPolicy == null ? 43 : $persistentVolumeReclaimPolicy.hashCode());
        Object $photonPersistentDisk = this.getPhotonPersistentDisk();
        result = result * prime + ($photonPersistentDisk == null ? 43 : $photonPersistentDisk.hashCode());
        Object $portworxVolume = this.getPortworxVolume();
        result = result * prime + ($portworxVolume == null ? 43 : $portworxVolume.hashCode());
        Object $quobyte = this.getQuobyte();
        result = result * prime + ($quobyte == null ? 43 : $quobyte.hashCode());
        Object $rbd = this.getRbd();
        result = result * prime + ($rbd == null ? 43 : $rbd.hashCode());
        Object $scaleIO = this.getScaleIO();
        result = result * prime + ($scaleIO == null ? 43 : $scaleIO.hashCode());
        Object $storageClassName = this.getStorageClassName();
        result = result * prime + ($storageClassName == null ? 43 : $storageClassName.hashCode());
        Object $storageos = this.getStorageos();
        result = result * prime + ($storageos == null ? 43 : $storageos.hashCode());
        Object $volumeAttributesClassName = this.getVolumeAttributesClassName();
        result = result * prime + ($volumeAttributesClassName == null ? 43 : $volumeAttributesClassName.hashCode());
        Object $volumeMode = this.getVolumeMode();
        result = result * prime + ($volumeMode == null ? 43 : $volumeMode.hashCode());
        Object $vsphereVolume = this.getVsphereVolume();
        result = result * prime + ($vsphereVolume == null ? 43 : $vsphereVolume.hashCode());
        Object $additionalProperties = this.getAdditionalProperties();
        result = result * prime + ($additionalProperties == null ? 43 : $additionalProperties.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "PersistentVolumeSpec(" + "accessModes=" + this.getAccessModes() + ", awsElasticBlockStore=" + this.getAwsElasticBlockStore() + ", azureDisk=" + this.getAzureDisk() + ", azureFile=" + this.getAzureFile() + ", capacity=" + this.getCapacity() + ", cephfs=" + this.getCephfs() + ", cinder=" + this.getCinder() + ", claimRef=" + this.getClaimRef() + ", csi=" + this.getCsi() + ", fc=" + this.getFc() + ", flexVolume=" + this.getFlexVolume() + ", flocker=" + this.getFlocker() + ", gcePersistentDisk=" + this.getGcePersistentDisk() + ", glusterfs=" + this.getGlusterfs() + ", hostPath=" + this.getHostPath() + ", iscsi=" + this.getIscsi() + ", local=" + this.getLocal() + ", mountOptions=" + this.getMountOptions() + ", nfs=" + this.getNfs() + ", nodeAffinity=" + this.getNodeAffinity() + ", persistentVolumeReclaimPolicy=" + this.getPersistentVolumeReclaimPolicy() + ", photonPersistentDisk=" + this.getPhotonPersistentDisk() + ", portworxVolume=" + this.getPortworxVolume() + ", quobyte=" + this.getQuobyte() + ", rbd=" + this.getRbd() + ", scaleIO=" + this.getScaleIO() + ", storageClassName=" + this.getStorageClassName() + ", storageos=" + this.getStorageos() + ", volumeAttributesClassName=" + this.getVolumeAttributesClassName() + ", volumeMode=" + this.getVolumeMode() + ", vsphereVolume=" + this.getVsphereVolume() + ", additionalProperties=" + this.getAdditionalProperties() + ")";
    }

}
