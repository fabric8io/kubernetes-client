package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class PersistentVolumeSpecFluent<A extends io.fabric8.kubernetes.api.model.PersistentVolumeSpecFluent<A>> extends BaseFluent<A>{

  private List<String> accessModes = new ArrayList<String>();
  private Map<String,Object> additionalProperties;
  private AWSElasticBlockStoreVolumeSourceBuilder awsElasticBlockStore;
  private AzureDiskVolumeSourceBuilder azureDisk;
  private AzureFilePersistentVolumeSourceBuilder azureFile;
  private Map<String,Quantity> capacity;
  private CephFSPersistentVolumeSourceBuilder cephfs;
  private CinderPersistentVolumeSourceBuilder cinder;
  private ObjectReferenceBuilder claimRef;
  private CSIPersistentVolumeSourceBuilder csi;
  private FCVolumeSourceBuilder fc;
  private FlexPersistentVolumeSourceBuilder flexVolume;
  private FlockerVolumeSourceBuilder flocker;
  private GCEPersistentDiskVolumeSourceBuilder gcePersistentDisk;
  private GlusterfsPersistentVolumeSourceBuilder glusterfs;
  private HostPathVolumeSourceBuilder hostPath;
  private ISCSIPersistentVolumeSourceBuilder iscsi;
  private LocalVolumeSourceBuilder local;
  private List<String> mountOptions = new ArrayList<String>();
  private NFSVolumeSourceBuilder nfs;
  private VolumeNodeAffinityBuilder nodeAffinity;
  private String persistentVolumeReclaimPolicy;
  private PhotonPersistentDiskVolumeSourceBuilder photonPersistentDisk;
  private PortworxVolumeSourceBuilder portworxVolume;
  private QuobyteVolumeSourceBuilder quobyte;
  private RBDPersistentVolumeSourceBuilder rbd;
  private ScaleIOPersistentVolumeSourceBuilder scaleIO;
  private String storageClassName;
  private StorageOSPersistentVolumeSourceBuilder storageos;
  private String volumeAttributesClassName;
  private String volumeMode;
  private VsphereVirtualDiskVolumeSourceBuilder vsphereVolume;

  public PersistentVolumeSpecFluent() {
  }
  
  public PersistentVolumeSpecFluent(PersistentVolumeSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAccessModes(Collection<String> items) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    for (String item : items) {
      this.accessModes.add(item);
    }
    return (A) this;
  }
  
  public A addAllToMountOptions(Collection<String> items) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    for (String item : items) {
      this.mountOptions.add(item);
    }
    return (A) this;
  }
  
  public A addToAccessModes(String... items) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    for (String item : items) {
      this.accessModes.add(item);
    }
    return (A) this;
  }
  
  public A addToAccessModes(int index,String item) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    this.accessModes.add(index, item);
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToCapacity(Map<String,Quantity> map) {
    if (this.capacity == null && map != null) {
      this.capacity = new LinkedHashMap();
    }
    if (map != null) {
      this.capacity.putAll(map);
    }
    return (A) this;
  }
  
  public A addToCapacity(String key,Quantity value) {
    if (this.capacity == null && key != null && value != null) {
      this.capacity = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.capacity.put(key, value);
    }
    return (A) this;
  }
  
  public A addToMountOptions(String... items) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    for (String item : items) {
      this.mountOptions.add(item);
    }
    return (A) this;
  }
  
  public A addToMountOptions(int index,String item) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    this.mountOptions.add(index, item);
    return (A) this;
  }
  
  public AWSElasticBlockStoreVolumeSource buildAwsElasticBlockStore() {
    return this.awsElasticBlockStore != null ? this.awsElasticBlockStore.build() : null;
  }
  
  public AzureDiskVolumeSource buildAzureDisk() {
    return this.azureDisk != null ? this.azureDisk.build() : null;
  }
  
  public AzureFilePersistentVolumeSource buildAzureFile() {
    return this.azureFile != null ? this.azureFile.build() : null;
  }
  
  public CephFSPersistentVolumeSource buildCephfs() {
    return this.cephfs != null ? this.cephfs.build() : null;
  }
  
  public CinderPersistentVolumeSource buildCinder() {
    return this.cinder != null ? this.cinder.build() : null;
  }
  
  public ObjectReference buildClaimRef() {
    return this.claimRef != null ? this.claimRef.build() : null;
  }
  
  public CSIPersistentVolumeSource buildCsi() {
    return this.csi != null ? this.csi.build() : null;
  }
  
  public FCVolumeSource buildFc() {
    return this.fc != null ? this.fc.build() : null;
  }
  
  public FlexPersistentVolumeSource buildFlexVolume() {
    return this.flexVolume != null ? this.flexVolume.build() : null;
  }
  
  public FlockerVolumeSource buildFlocker() {
    return this.flocker != null ? this.flocker.build() : null;
  }
  
  public GCEPersistentDiskVolumeSource buildGcePersistentDisk() {
    return this.gcePersistentDisk != null ? this.gcePersistentDisk.build() : null;
  }
  
  public GlusterfsPersistentVolumeSource buildGlusterfs() {
    return this.glusterfs != null ? this.glusterfs.build() : null;
  }
  
  public HostPathVolumeSource buildHostPath() {
    return this.hostPath != null ? this.hostPath.build() : null;
  }
  
  public ISCSIPersistentVolumeSource buildIscsi() {
    return this.iscsi != null ? this.iscsi.build() : null;
  }
  
  public LocalVolumeSource buildLocal() {
    return this.local != null ? this.local.build() : null;
  }
  
  public NFSVolumeSource buildNfs() {
    return this.nfs != null ? this.nfs.build() : null;
  }
  
  public VolumeNodeAffinity buildNodeAffinity() {
    return this.nodeAffinity != null ? this.nodeAffinity.build() : null;
  }
  
  public PhotonPersistentDiskVolumeSource buildPhotonPersistentDisk() {
    return this.photonPersistentDisk != null ? this.photonPersistentDisk.build() : null;
  }
  
  public PortworxVolumeSource buildPortworxVolume() {
    return this.portworxVolume != null ? this.portworxVolume.build() : null;
  }
  
  public QuobyteVolumeSource buildQuobyte() {
    return this.quobyte != null ? this.quobyte.build() : null;
  }
  
  public RBDPersistentVolumeSource buildRbd() {
    return this.rbd != null ? this.rbd.build() : null;
  }
  
  public ScaleIOPersistentVolumeSource buildScaleIO() {
    return this.scaleIO != null ? this.scaleIO.build() : null;
  }
  
  public StorageOSPersistentVolumeSource buildStorageos() {
    return this.storageos != null ? this.storageos.build() : null;
  }
  
  public VsphereVirtualDiskVolumeSource buildVsphereVolume() {
    return this.vsphereVolume != null ? this.vsphereVolume.build() : null;
  }
  
  protected void copyInstance(PersistentVolumeSpec instance) {
    instance = instance != null ? instance : new PersistentVolumeSpec();
    if (instance != null) {
        this.withAccessModes(instance.getAccessModes());
        this.withAwsElasticBlockStore(instance.getAwsElasticBlockStore());
        this.withAzureDisk(instance.getAzureDisk());
        this.withAzureFile(instance.getAzureFile());
        this.withCapacity(instance.getCapacity());
        this.withCephfs(instance.getCephfs());
        this.withCinder(instance.getCinder());
        this.withClaimRef(instance.getClaimRef());
        this.withCsi(instance.getCsi());
        this.withFc(instance.getFc());
        this.withFlexVolume(instance.getFlexVolume());
        this.withFlocker(instance.getFlocker());
        this.withGcePersistentDisk(instance.getGcePersistentDisk());
        this.withGlusterfs(instance.getGlusterfs());
        this.withHostPath(instance.getHostPath());
        this.withIscsi(instance.getIscsi());
        this.withLocal(instance.getLocal());
        this.withMountOptions(instance.getMountOptions());
        this.withNfs(instance.getNfs());
        this.withNodeAffinity(instance.getNodeAffinity());
        this.withPersistentVolumeReclaimPolicy(instance.getPersistentVolumeReclaimPolicy());
        this.withPhotonPersistentDisk(instance.getPhotonPersistentDisk());
        this.withPortworxVolume(instance.getPortworxVolume());
        this.withQuobyte(instance.getQuobyte());
        this.withRbd(instance.getRbd());
        this.withScaleIO(instance.getScaleIO());
        this.withStorageClassName(instance.getStorageClassName());
        this.withStorageos(instance.getStorageos());
        this.withVolumeAttributesClassName(instance.getVolumeAttributesClassName());
        this.withVolumeMode(instance.getVolumeMode());
        this.withVsphereVolume(instance.getVsphereVolume());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public AwsElasticBlockStoreNested<A> editAwsElasticBlockStore() {
    return this.withNewAwsElasticBlockStoreLike(Optional.ofNullable(this.buildAwsElasticBlockStore()).orElse(null));
  }
  
  public AzureDiskNested<A> editAzureDisk() {
    return this.withNewAzureDiskLike(Optional.ofNullable(this.buildAzureDisk()).orElse(null));
  }
  
  public AzureFileNested<A> editAzureFile() {
    return this.withNewAzureFileLike(Optional.ofNullable(this.buildAzureFile()).orElse(null));
  }
  
  public CephfsNested<A> editCephfs() {
    return this.withNewCephfsLike(Optional.ofNullable(this.buildCephfs()).orElse(null));
  }
  
  public CinderNested<A> editCinder() {
    return this.withNewCinderLike(Optional.ofNullable(this.buildCinder()).orElse(null));
  }
  
  public ClaimRefNested<A> editClaimRef() {
    return this.withNewClaimRefLike(Optional.ofNullable(this.buildClaimRef()).orElse(null));
  }
  
  public CsiNested<A> editCsi() {
    return this.withNewCsiLike(Optional.ofNullable(this.buildCsi()).orElse(null));
  }
  
  public FcNested<A> editFc() {
    return this.withNewFcLike(Optional.ofNullable(this.buildFc()).orElse(null));
  }
  
  public FlexVolumeNested<A> editFlexVolume() {
    return this.withNewFlexVolumeLike(Optional.ofNullable(this.buildFlexVolume()).orElse(null));
  }
  
  public FlockerNested<A> editFlocker() {
    return this.withNewFlockerLike(Optional.ofNullable(this.buildFlocker()).orElse(null));
  }
  
  public GcePersistentDiskNested<A> editGcePersistentDisk() {
    return this.withNewGcePersistentDiskLike(Optional.ofNullable(this.buildGcePersistentDisk()).orElse(null));
  }
  
  public GlusterfsNested<A> editGlusterfs() {
    return this.withNewGlusterfsLike(Optional.ofNullable(this.buildGlusterfs()).orElse(null));
  }
  
  public HostPathNested<A> editHostPath() {
    return this.withNewHostPathLike(Optional.ofNullable(this.buildHostPath()).orElse(null));
  }
  
  public IscsiNested<A> editIscsi() {
    return this.withNewIscsiLike(Optional.ofNullable(this.buildIscsi()).orElse(null));
  }
  
  public LocalNested<A> editLocal() {
    return this.withNewLocalLike(Optional.ofNullable(this.buildLocal()).orElse(null));
  }
  
  public NfsNested<A> editNfs() {
    return this.withNewNfsLike(Optional.ofNullable(this.buildNfs()).orElse(null));
  }
  
  public NodeAffinityNested<A> editNodeAffinity() {
    return this.withNewNodeAffinityLike(Optional.ofNullable(this.buildNodeAffinity()).orElse(null));
  }
  
  public AwsElasticBlockStoreNested<A> editOrNewAwsElasticBlockStore() {
    return this.withNewAwsElasticBlockStoreLike(Optional.ofNullable(this.buildAwsElasticBlockStore()).orElse(new AWSElasticBlockStoreVolumeSourceBuilder().build()));
  }
  
  public AwsElasticBlockStoreNested<A> editOrNewAwsElasticBlockStoreLike(AWSElasticBlockStoreVolumeSource item) {
    return this.withNewAwsElasticBlockStoreLike(Optional.ofNullable(this.buildAwsElasticBlockStore()).orElse(item));
  }
  
  public AzureDiskNested<A> editOrNewAzureDisk() {
    return this.withNewAzureDiskLike(Optional.ofNullable(this.buildAzureDisk()).orElse(new AzureDiskVolumeSourceBuilder().build()));
  }
  
  public AzureDiskNested<A> editOrNewAzureDiskLike(AzureDiskVolumeSource item) {
    return this.withNewAzureDiskLike(Optional.ofNullable(this.buildAzureDisk()).orElse(item));
  }
  
  public AzureFileNested<A> editOrNewAzureFile() {
    return this.withNewAzureFileLike(Optional.ofNullable(this.buildAzureFile()).orElse(new AzureFilePersistentVolumeSourceBuilder().build()));
  }
  
  public AzureFileNested<A> editOrNewAzureFileLike(AzureFilePersistentVolumeSource item) {
    return this.withNewAzureFileLike(Optional.ofNullable(this.buildAzureFile()).orElse(item));
  }
  
  public CephfsNested<A> editOrNewCephfs() {
    return this.withNewCephfsLike(Optional.ofNullable(this.buildCephfs()).orElse(new CephFSPersistentVolumeSourceBuilder().build()));
  }
  
  public CephfsNested<A> editOrNewCephfsLike(CephFSPersistentVolumeSource item) {
    return this.withNewCephfsLike(Optional.ofNullable(this.buildCephfs()).orElse(item));
  }
  
  public CinderNested<A> editOrNewCinder() {
    return this.withNewCinderLike(Optional.ofNullable(this.buildCinder()).orElse(new CinderPersistentVolumeSourceBuilder().build()));
  }
  
  public CinderNested<A> editOrNewCinderLike(CinderPersistentVolumeSource item) {
    return this.withNewCinderLike(Optional.ofNullable(this.buildCinder()).orElse(item));
  }
  
  public ClaimRefNested<A> editOrNewClaimRef() {
    return this.withNewClaimRefLike(Optional.ofNullable(this.buildClaimRef()).orElse(new ObjectReferenceBuilder().build()));
  }
  
  public ClaimRefNested<A> editOrNewClaimRefLike(ObjectReference item) {
    return this.withNewClaimRefLike(Optional.ofNullable(this.buildClaimRef()).orElse(item));
  }
  
  public CsiNested<A> editOrNewCsi() {
    return this.withNewCsiLike(Optional.ofNullable(this.buildCsi()).orElse(new CSIPersistentVolumeSourceBuilder().build()));
  }
  
  public CsiNested<A> editOrNewCsiLike(CSIPersistentVolumeSource item) {
    return this.withNewCsiLike(Optional.ofNullable(this.buildCsi()).orElse(item));
  }
  
  public FcNested<A> editOrNewFc() {
    return this.withNewFcLike(Optional.ofNullable(this.buildFc()).orElse(new FCVolumeSourceBuilder().build()));
  }
  
  public FcNested<A> editOrNewFcLike(FCVolumeSource item) {
    return this.withNewFcLike(Optional.ofNullable(this.buildFc()).orElse(item));
  }
  
  public FlexVolumeNested<A> editOrNewFlexVolume() {
    return this.withNewFlexVolumeLike(Optional.ofNullable(this.buildFlexVolume()).orElse(new FlexPersistentVolumeSourceBuilder().build()));
  }
  
  public FlexVolumeNested<A> editOrNewFlexVolumeLike(FlexPersistentVolumeSource item) {
    return this.withNewFlexVolumeLike(Optional.ofNullable(this.buildFlexVolume()).orElse(item));
  }
  
  public FlockerNested<A> editOrNewFlocker() {
    return this.withNewFlockerLike(Optional.ofNullable(this.buildFlocker()).orElse(new FlockerVolumeSourceBuilder().build()));
  }
  
  public FlockerNested<A> editOrNewFlockerLike(FlockerVolumeSource item) {
    return this.withNewFlockerLike(Optional.ofNullable(this.buildFlocker()).orElse(item));
  }
  
  public GcePersistentDiskNested<A> editOrNewGcePersistentDisk() {
    return this.withNewGcePersistentDiskLike(Optional.ofNullable(this.buildGcePersistentDisk()).orElse(new GCEPersistentDiskVolumeSourceBuilder().build()));
  }
  
  public GcePersistentDiskNested<A> editOrNewGcePersistentDiskLike(GCEPersistentDiskVolumeSource item) {
    return this.withNewGcePersistentDiskLike(Optional.ofNullable(this.buildGcePersistentDisk()).orElse(item));
  }
  
  public GlusterfsNested<A> editOrNewGlusterfs() {
    return this.withNewGlusterfsLike(Optional.ofNullable(this.buildGlusterfs()).orElse(new GlusterfsPersistentVolumeSourceBuilder().build()));
  }
  
  public GlusterfsNested<A> editOrNewGlusterfsLike(GlusterfsPersistentVolumeSource item) {
    return this.withNewGlusterfsLike(Optional.ofNullable(this.buildGlusterfs()).orElse(item));
  }
  
  public HostPathNested<A> editOrNewHostPath() {
    return this.withNewHostPathLike(Optional.ofNullable(this.buildHostPath()).orElse(new HostPathVolumeSourceBuilder().build()));
  }
  
  public HostPathNested<A> editOrNewHostPathLike(HostPathVolumeSource item) {
    return this.withNewHostPathLike(Optional.ofNullable(this.buildHostPath()).orElse(item));
  }
  
  public IscsiNested<A> editOrNewIscsi() {
    return this.withNewIscsiLike(Optional.ofNullable(this.buildIscsi()).orElse(new ISCSIPersistentVolumeSourceBuilder().build()));
  }
  
  public IscsiNested<A> editOrNewIscsiLike(ISCSIPersistentVolumeSource item) {
    return this.withNewIscsiLike(Optional.ofNullable(this.buildIscsi()).orElse(item));
  }
  
  public LocalNested<A> editOrNewLocal() {
    return this.withNewLocalLike(Optional.ofNullable(this.buildLocal()).orElse(new LocalVolumeSourceBuilder().build()));
  }
  
  public LocalNested<A> editOrNewLocalLike(LocalVolumeSource item) {
    return this.withNewLocalLike(Optional.ofNullable(this.buildLocal()).orElse(item));
  }
  
  public NfsNested<A> editOrNewNfs() {
    return this.withNewNfsLike(Optional.ofNullable(this.buildNfs()).orElse(new NFSVolumeSourceBuilder().build()));
  }
  
  public NfsNested<A> editOrNewNfsLike(NFSVolumeSource item) {
    return this.withNewNfsLike(Optional.ofNullable(this.buildNfs()).orElse(item));
  }
  
  public NodeAffinityNested<A> editOrNewNodeAffinity() {
    return this.withNewNodeAffinityLike(Optional.ofNullable(this.buildNodeAffinity()).orElse(new VolumeNodeAffinityBuilder().build()));
  }
  
  public NodeAffinityNested<A> editOrNewNodeAffinityLike(VolumeNodeAffinity item) {
    return this.withNewNodeAffinityLike(Optional.ofNullable(this.buildNodeAffinity()).orElse(item));
  }
  
  public PhotonPersistentDiskNested<A> editOrNewPhotonPersistentDisk() {
    return this.withNewPhotonPersistentDiskLike(Optional.ofNullable(this.buildPhotonPersistentDisk()).orElse(new PhotonPersistentDiskVolumeSourceBuilder().build()));
  }
  
  public PhotonPersistentDiskNested<A> editOrNewPhotonPersistentDiskLike(PhotonPersistentDiskVolumeSource item) {
    return this.withNewPhotonPersistentDiskLike(Optional.ofNullable(this.buildPhotonPersistentDisk()).orElse(item));
  }
  
  public PortworxVolumeNested<A> editOrNewPortworxVolume() {
    return this.withNewPortworxVolumeLike(Optional.ofNullable(this.buildPortworxVolume()).orElse(new PortworxVolumeSourceBuilder().build()));
  }
  
  public PortworxVolumeNested<A> editOrNewPortworxVolumeLike(PortworxVolumeSource item) {
    return this.withNewPortworxVolumeLike(Optional.ofNullable(this.buildPortworxVolume()).orElse(item));
  }
  
  public QuobyteNested<A> editOrNewQuobyte() {
    return this.withNewQuobyteLike(Optional.ofNullable(this.buildQuobyte()).orElse(new QuobyteVolumeSourceBuilder().build()));
  }
  
  public QuobyteNested<A> editOrNewQuobyteLike(QuobyteVolumeSource item) {
    return this.withNewQuobyteLike(Optional.ofNullable(this.buildQuobyte()).orElse(item));
  }
  
  public RbdNested<A> editOrNewRbd() {
    return this.withNewRbdLike(Optional.ofNullable(this.buildRbd()).orElse(new RBDPersistentVolumeSourceBuilder().build()));
  }
  
  public RbdNested<A> editOrNewRbdLike(RBDPersistentVolumeSource item) {
    return this.withNewRbdLike(Optional.ofNullable(this.buildRbd()).orElse(item));
  }
  
  public ScaleIONested<A> editOrNewScaleIO() {
    return this.withNewScaleIOLike(Optional.ofNullable(this.buildScaleIO()).orElse(new ScaleIOPersistentVolumeSourceBuilder().build()));
  }
  
  public ScaleIONested<A> editOrNewScaleIOLike(ScaleIOPersistentVolumeSource item) {
    return this.withNewScaleIOLike(Optional.ofNullable(this.buildScaleIO()).orElse(item));
  }
  
  public StorageosNested<A> editOrNewStorageos() {
    return this.withNewStorageosLike(Optional.ofNullable(this.buildStorageos()).orElse(new StorageOSPersistentVolumeSourceBuilder().build()));
  }
  
  public StorageosNested<A> editOrNewStorageosLike(StorageOSPersistentVolumeSource item) {
    return this.withNewStorageosLike(Optional.ofNullable(this.buildStorageos()).orElse(item));
  }
  
  public VsphereVolumeNested<A> editOrNewVsphereVolume() {
    return this.withNewVsphereVolumeLike(Optional.ofNullable(this.buildVsphereVolume()).orElse(new VsphereVirtualDiskVolumeSourceBuilder().build()));
  }
  
  public VsphereVolumeNested<A> editOrNewVsphereVolumeLike(VsphereVirtualDiskVolumeSource item) {
    return this.withNewVsphereVolumeLike(Optional.ofNullable(this.buildVsphereVolume()).orElse(item));
  }
  
  public PhotonPersistentDiskNested<A> editPhotonPersistentDisk() {
    return this.withNewPhotonPersistentDiskLike(Optional.ofNullable(this.buildPhotonPersistentDisk()).orElse(null));
  }
  
  public PortworxVolumeNested<A> editPortworxVolume() {
    return this.withNewPortworxVolumeLike(Optional.ofNullable(this.buildPortworxVolume()).orElse(null));
  }
  
  public QuobyteNested<A> editQuobyte() {
    return this.withNewQuobyteLike(Optional.ofNullable(this.buildQuobyte()).orElse(null));
  }
  
  public RbdNested<A> editRbd() {
    return this.withNewRbdLike(Optional.ofNullable(this.buildRbd()).orElse(null));
  }
  
  public ScaleIONested<A> editScaleIO() {
    return this.withNewScaleIOLike(Optional.ofNullable(this.buildScaleIO()).orElse(null));
  }
  
  public StorageosNested<A> editStorageos() {
    return this.withNewStorageosLike(Optional.ofNullable(this.buildStorageos()).orElse(null));
  }
  
  public VsphereVolumeNested<A> editVsphereVolume() {
    return this.withNewVsphereVolumeLike(Optional.ofNullable(this.buildVsphereVolume()).orElse(null));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    PersistentVolumeSpecFluent that = (PersistentVolumeSpecFluent) o;
    if (!(Objects.equals(accessModes, that.accessModes))) {
      return false;
    }
    if (!(Objects.equals(awsElasticBlockStore, that.awsElasticBlockStore))) {
      return false;
    }
    if (!(Objects.equals(azureDisk, that.azureDisk))) {
      return false;
    }
    if (!(Objects.equals(azureFile, that.azureFile))) {
      return false;
    }
    if (!(Objects.equals(capacity, that.capacity))) {
      return false;
    }
    if (!(Objects.equals(cephfs, that.cephfs))) {
      return false;
    }
    if (!(Objects.equals(cinder, that.cinder))) {
      return false;
    }
    if (!(Objects.equals(claimRef, that.claimRef))) {
      return false;
    }
    if (!(Objects.equals(csi, that.csi))) {
      return false;
    }
    if (!(Objects.equals(fc, that.fc))) {
      return false;
    }
    if (!(Objects.equals(flexVolume, that.flexVolume))) {
      return false;
    }
    if (!(Objects.equals(flocker, that.flocker))) {
      return false;
    }
    if (!(Objects.equals(gcePersistentDisk, that.gcePersistentDisk))) {
      return false;
    }
    if (!(Objects.equals(glusterfs, that.glusterfs))) {
      return false;
    }
    if (!(Objects.equals(hostPath, that.hostPath))) {
      return false;
    }
    if (!(Objects.equals(iscsi, that.iscsi))) {
      return false;
    }
    if (!(Objects.equals(local, that.local))) {
      return false;
    }
    if (!(Objects.equals(mountOptions, that.mountOptions))) {
      return false;
    }
    if (!(Objects.equals(nfs, that.nfs))) {
      return false;
    }
    if (!(Objects.equals(nodeAffinity, that.nodeAffinity))) {
      return false;
    }
    if (!(Objects.equals(persistentVolumeReclaimPolicy, that.persistentVolumeReclaimPolicy))) {
      return false;
    }
    if (!(Objects.equals(photonPersistentDisk, that.photonPersistentDisk))) {
      return false;
    }
    if (!(Objects.equals(portworxVolume, that.portworxVolume))) {
      return false;
    }
    if (!(Objects.equals(quobyte, that.quobyte))) {
      return false;
    }
    if (!(Objects.equals(rbd, that.rbd))) {
      return false;
    }
    if (!(Objects.equals(scaleIO, that.scaleIO))) {
      return false;
    }
    if (!(Objects.equals(storageClassName, that.storageClassName))) {
      return false;
    }
    if (!(Objects.equals(storageos, that.storageos))) {
      return false;
    }
    if (!(Objects.equals(volumeAttributesClassName, that.volumeAttributesClassName))) {
      return false;
    }
    if (!(Objects.equals(volumeMode, that.volumeMode))) {
      return false;
    }
    if (!(Objects.equals(vsphereVolume, that.vsphereVolume))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public String getAccessMode(int index) {
    return this.accessModes.get(index);
  }
  
  public List<String> getAccessModes() {
    return this.accessModes;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public Map<String,Quantity> getCapacity() {
    return this.capacity;
  }
  
  public String getFirstAccessMode() {
    return this.accessModes.get(0);
  }
  
  public String getFirstMountOption() {
    return this.mountOptions.get(0);
  }
  
  public String getLastAccessMode() {
    return this.accessModes.get(accessModes.size() - 1);
  }
  
  public String getLastMountOption() {
    return this.mountOptions.get(mountOptions.size() - 1);
  }
  
  public String getMatchingAccessMode(Predicate<String> predicate) {
      for (String item : accessModes) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingMountOption(Predicate<String> predicate) {
      for (String item : mountOptions) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMountOption(int index) {
    return this.mountOptions.get(index);
  }
  
  public List<String> getMountOptions() {
    return this.mountOptions;
  }
  
  public String getPersistentVolumeReclaimPolicy() {
    return this.persistentVolumeReclaimPolicy;
  }
  
  public String getStorageClassName() {
    return this.storageClassName;
  }
  
  public String getVolumeAttributesClassName() {
    return this.volumeAttributesClassName;
  }
  
  public String getVolumeMode() {
    return this.volumeMode;
  }
  
  public boolean hasAccessModes() {
    return this.accessModes != null && !(this.accessModes.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasAwsElasticBlockStore() {
    return this.awsElasticBlockStore != null;
  }
  
  public boolean hasAzureDisk() {
    return this.azureDisk != null;
  }
  
  public boolean hasAzureFile() {
    return this.azureFile != null;
  }
  
  public boolean hasCapacity() {
    return this.capacity != null;
  }
  
  public boolean hasCephfs() {
    return this.cephfs != null;
  }
  
  public boolean hasCinder() {
    return this.cinder != null;
  }
  
  public boolean hasClaimRef() {
    return this.claimRef != null;
  }
  
  public boolean hasCsi() {
    return this.csi != null;
  }
  
  public boolean hasFc() {
    return this.fc != null;
  }
  
  public boolean hasFlexVolume() {
    return this.flexVolume != null;
  }
  
  public boolean hasFlocker() {
    return this.flocker != null;
  }
  
  public boolean hasGcePersistentDisk() {
    return this.gcePersistentDisk != null;
  }
  
  public boolean hasGlusterfs() {
    return this.glusterfs != null;
  }
  
  public boolean hasHostPath() {
    return this.hostPath != null;
  }
  
  public boolean hasIscsi() {
    return this.iscsi != null;
  }
  
  public boolean hasLocal() {
    return this.local != null;
  }
  
  public boolean hasMatchingAccessMode(Predicate<String> predicate) {
      for (String item : accessModes) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMountOption(Predicate<String> predicate) {
      for (String item : mountOptions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMountOptions() {
    return this.mountOptions != null && !(this.mountOptions.isEmpty());
  }
  
  public boolean hasNfs() {
    return this.nfs != null;
  }
  
  public boolean hasNodeAffinity() {
    return this.nodeAffinity != null;
  }
  
  public boolean hasPersistentVolumeReclaimPolicy() {
    return this.persistentVolumeReclaimPolicy != null;
  }
  
  public boolean hasPhotonPersistentDisk() {
    return this.photonPersistentDisk != null;
  }
  
  public boolean hasPortworxVolume() {
    return this.portworxVolume != null;
  }
  
  public boolean hasQuobyte() {
    return this.quobyte != null;
  }
  
  public boolean hasRbd() {
    return this.rbd != null;
  }
  
  public boolean hasScaleIO() {
    return this.scaleIO != null;
  }
  
  public boolean hasStorageClassName() {
    return this.storageClassName != null;
  }
  
  public boolean hasStorageos() {
    return this.storageos != null;
  }
  
  public boolean hasVolumeAttributesClassName() {
    return this.volumeAttributesClassName != null;
  }
  
  public boolean hasVolumeMode() {
    return this.volumeMode != null;
  }
  
  public boolean hasVsphereVolume() {
    return this.vsphereVolume != null;
  }
  
  public int hashCode() {
    return Objects.hash(accessModes, awsElasticBlockStore, azureDisk, azureFile, capacity, cephfs, cinder, claimRef, csi, fc, flexVolume, flocker, gcePersistentDisk, glusterfs, hostPath, iscsi, local, mountOptions, nfs, nodeAffinity, persistentVolumeReclaimPolicy, photonPersistentDisk, portworxVolume, quobyte, rbd, scaleIO, storageClassName, storageos, volumeAttributesClassName, volumeMode, vsphereVolume, additionalProperties);
  }
  
  public A removeAllFromAccessModes(Collection<String> items) {
    if (this.accessModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.accessModes.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromMountOptions(Collection<String> items) {
    if (this.mountOptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mountOptions.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAccessModes(String... items) {
    if (this.accessModes == null) {
      return (A) this;
    }
    for (String item : items) {
      this.accessModes.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromCapacity(String key) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (key != null && this.capacity != null) {
      this.capacity.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromCapacity(Map<String,Quantity> map) {
    if (this.capacity == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.capacity != null) {
          this.capacity.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromMountOptions(String... items) {
    if (this.mountOptions == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mountOptions.remove(item);
    }
    return (A) this;
  }
  
  public A setToAccessModes(int index,String item) {
    if (this.accessModes == null) {
      this.accessModes = new ArrayList();
    }
    this.accessModes.set(index, item);
    return (A) this;
  }
  
  public A setToMountOptions(int index,String item) {
    if (this.mountOptions == null) {
      this.mountOptions = new ArrayList();
    }
    this.mountOptions.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessModes == null) && !(accessModes.isEmpty())) {
        sb.append("accessModes:");
        sb.append(accessModes);
        sb.append(",");
    }
    if (!(awsElasticBlockStore == null)) {
        sb.append("awsElasticBlockStore:");
        sb.append(awsElasticBlockStore);
        sb.append(",");
    }
    if (!(azureDisk == null)) {
        sb.append("azureDisk:");
        sb.append(azureDisk);
        sb.append(",");
    }
    if (!(azureFile == null)) {
        sb.append("azureFile:");
        sb.append(azureFile);
        sb.append(",");
    }
    if (!(capacity == null) && !(capacity.isEmpty())) {
        sb.append("capacity:");
        sb.append(capacity);
        sb.append(",");
    }
    if (!(cephfs == null)) {
        sb.append("cephfs:");
        sb.append(cephfs);
        sb.append(",");
    }
    if (!(cinder == null)) {
        sb.append("cinder:");
        sb.append(cinder);
        sb.append(",");
    }
    if (!(claimRef == null)) {
        sb.append("claimRef:");
        sb.append(claimRef);
        sb.append(",");
    }
    if (!(csi == null)) {
        sb.append("csi:");
        sb.append(csi);
        sb.append(",");
    }
    if (!(fc == null)) {
        sb.append("fc:");
        sb.append(fc);
        sb.append(",");
    }
    if (!(flexVolume == null)) {
        sb.append("flexVolume:");
        sb.append(flexVolume);
        sb.append(",");
    }
    if (!(flocker == null)) {
        sb.append("flocker:");
        sb.append(flocker);
        sb.append(",");
    }
    if (!(gcePersistentDisk == null)) {
        sb.append("gcePersistentDisk:");
        sb.append(gcePersistentDisk);
        sb.append(",");
    }
    if (!(glusterfs == null)) {
        sb.append("glusterfs:");
        sb.append(glusterfs);
        sb.append(",");
    }
    if (!(hostPath == null)) {
        sb.append("hostPath:");
        sb.append(hostPath);
        sb.append(",");
    }
    if (!(iscsi == null)) {
        sb.append("iscsi:");
        sb.append(iscsi);
        sb.append(",");
    }
    if (!(local == null)) {
        sb.append("local:");
        sb.append(local);
        sb.append(",");
    }
    if (!(mountOptions == null) && !(mountOptions.isEmpty())) {
        sb.append("mountOptions:");
        sb.append(mountOptions);
        sb.append(",");
    }
    if (!(nfs == null)) {
        sb.append("nfs:");
        sb.append(nfs);
        sb.append(",");
    }
    if (!(nodeAffinity == null)) {
        sb.append("nodeAffinity:");
        sb.append(nodeAffinity);
        sb.append(",");
    }
    if (!(persistentVolumeReclaimPolicy == null)) {
        sb.append("persistentVolumeReclaimPolicy:");
        sb.append(persistentVolumeReclaimPolicy);
        sb.append(",");
    }
    if (!(photonPersistentDisk == null)) {
        sb.append("photonPersistentDisk:");
        sb.append(photonPersistentDisk);
        sb.append(",");
    }
    if (!(portworxVolume == null)) {
        sb.append("portworxVolume:");
        sb.append(portworxVolume);
        sb.append(",");
    }
    if (!(quobyte == null)) {
        sb.append("quobyte:");
        sb.append(quobyte);
        sb.append(",");
    }
    if (!(rbd == null)) {
        sb.append("rbd:");
        sb.append(rbd);
        sb.append(",");
    }
    if (!(scaleIO == null)) {
        sb.append("scaleIO:");
        sb.append(scaleIO);
        sb.append(",");
    }
    if (!(storageClassName == null)) {
        sb.append("storageClassName:");
        sb.append(storageClassName);
        sb.append(",");
    }
    if (!(storageos == null)) {
        sb.append("storageos:");
        sb.append(storageos);
        sb.append(",");
    }
    if (!(volumeAttributesClassName == null)) {
        sb.append("volumeAttributesClassName:");
        sb.append(volumeAttributesClassName);
        sb.append(",");
    }
    if (!(volumeMode == null)) {
        sb.append("volumeMode:");
        sb.append(volumeMode);
        sb.append(",");
    }
    if (!(vsphereVolume == null)) {
        sb.append("vsphereVolume:");
        sb.append(vsphereVolume);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessModes(List<String> accessModes) {
    if (accessModes != null) {
        this.accessModes = new ArrayList();
        for (String item : accessModes) {
          this.addToAccessModes(item);
        }
    } else {
      this.accessModes = null;
    }
    return (A) this;
  }
  
  public A withAccessModes(String... accessModes) {
    if (this.accessModes != null) {
        this.accessModes.clear();
        _visitables.remove("accessModes");
    }
    if (accessModes != null) {
      for (String item : accessModes) {
        this.addToAccessModes(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withAwsElasticBlockStore(AWSElasticBlockStoreVolumeSource awsElasticBlockStore) {
    this._visitables.remove("awsElasticBlockStore");
    if (awsElasticBlockStore != null) {
        this.awsElasticBlockStore = new AWSElasticBlockStoreVolumeSourceBuilder(awsElasticBlockStore);
        this._visitables.get("awsElasticBlockStore").add(this.awsElasticBlockStore);
    } else {
        this.awsElasticBlockStore = null;
        this._visitables.get("awsElasticBlockStore").remove(this.awsElasticBlockStore);
    }
    return (A) this;
  }
  
  public A withAzureDisk(AzureDiskVolumeSource azureDisk) {
    this._visitables.remove("azureDisk");
    if (azureDisk != null) {
        this.azureDisk = new AzureDiskVolumeSourceBuilder(azureDisk);
        this._visitables.get("azureDisk").add(this.azureDisk);
    } else {
        this.azureDisk = null;
        this._visitables.get("azureDisk").remove(this.azureDisk);
    }
    return (A) this;
  }
  
  public A withAzureFile(AzureFilePersistentVolumeSource azureFile) {
    this._visitables.remove("azureFile");
    if (azureFile != null) {
        this.azureFile = new AzureFilePersistentVolumeSourceBuilder(azureFile);
        this._visitables.get("azureFile").add(this.azureFile);
    } else {
        this.azureFile = null;
        this._visitables.get("azureFile").remove(this.azureFile);
    }
    return (A) this;
  }
  
  public <K,V>A withCapacity(Map<String,Quantity> capacity) {
    if (capacity == null) {
      this.capacity = null;
    } else {
      this.capacity = new LinkedHashMap(capacity);
    }
    return (A) this;
  }
  
  public A withCephfs(CephFSPersistentVolumeSource cephfs) {
    this._visitables.remove("cephfs");
    if (cephfs != null) {
        this.cephfs = new CephFSPersistentVolumeSourceBuilder(cephfs);
        this._visitables.get("cephfs").add(this.cephfs);
    } else {
        this.cephfs = null;
        this._visitables.get("cephfs").remove(this.cephfs);
    }
    return (A) this;
  }
  
  public A withCinder(CinderPersistentVolumeSource cinder) {
    this._visitables.remove("cinder");
    if (cinder != null) {
        this.cinder = new CinderPersistentVolumeSourceBuilder(cinder);
        this._visitables.get("cinder").add(this.cinder);
    } else {
        this.cinder = null;
        this._visitables.get("cinder").remove(this.cinder);
    }
    return (A) this;
  }
  
  public A withClaimRef(ObjectReference claimRef) {
    this._visitables.remove("claimRef");
    if (claimRef != null) {
        this.claimRef = new ObjectReferenceBuilder(claimRef);
        this._visitables.get("claimRef").add(this.claimRef);
    } else {
        this.claimRef = null;
        this._visitables.get("claimRef").remove(this.claimRef);
    }
    return (A) this;
  }
  
  public A withCsi(CSIPersistentVolumeSource csi) {
    this._visitables.remove("csi");
    if (csi != null) {
        this.csi = new CSIPersistentVolumeSourceBuilder(csi);
        this._visitables.get("csi").add(this.csi);
    } else {
        this.csi = null;
        this._visitables.get("csi").remove(this.csi);
    }
    return (A) this;
  }
  
  public A withFc(FCVolumeSource fc) {
    this._visitables.remove("fc");
    if (fc != null) {
        this.fc = new FCVolumeSourceBuilder(fc);
        this._visitables.get("fc").add(this.fc);
    } else {
        this.fc = null;
        this._visitables.get("fc").remove(this.fc);
    }
    return (A) this;
  }
  
  public A withFlexVolume(FlexPersistentVolumeSource flexVolume) {
    this._visitables.remove("flexVolume");
    if (flexVolume != null) {
        this.flexVolume = new FlexPersistentVolumeSourceBuilder(flexVolume);
        this._visitables.get("flexVolume").add(this.flexVolume);
    } else {
        this.flexVolume = null;
        this._visitables.get("flexVolume").remove(this.flexVolume);
    }
    return (A) this;
  }
  
  public A withFlocker(FlockerVolumeSource flocker) {
    this._visitables.remove("flocker");
    if (flocker != null) {
        this.flocker = new FlockerVolumeSourceBuilder(flocker);
        this._visitables.get("flocker").add(this.flocker);
    } else {
        this.flocker = null;
        this._visitables.get("flocker").remove(this.flocker);
    }
    return (A) this;
  }
  
  public A withGcePersistentDisk(GCEPersistentDiskVolumeSource gcePersistentDisk) {
    this._visitables.remove("gcePersistentDisk");
    if (gcePersistentDisk != null) {
        this.gcePersistentDisk = new GCEPersistentDiskVolumeSourceBuilder(gcePersistentDisk);
        this._visitables.get("gcePersistentDisk").add(this.gcePersistentDisk);
    } else {
        this.gcePersistentDisk = null;
        this._visitables.get("gcePersistentDisk").remove(this.gcePersistentDisk);
    }
    return (A) this;
  }
  
  public A withGlusterfs(GlusterfsPersistentVolumeSource glusterfs) {
    this._visitables.remove("glusterfs");
    if (glusterfs != null) {
        this.glusterfs = new GlusterfsPersistentVolumeSourceBuilder(glusterfs);
        this._visitables.get("glusterfs").add(this.glusterfs);
    } else {
        this.glusterfs = null;
        this._visitables.get("glusterfs").remove(this.glusterfs);
    }
    return (A) this;
  }
  
  public A withHostPath(HostPathVolumeSource hostPath) {
    this._visitables.remove("hostPath");
    if (hostPath != null) {
        this.hostPath = new HostPathVolumeSourceBuilder(hostPath);
        this._visitables.get("hostPath").add(this.hostPath);
    } else {
        this.hostPath = null;
        this._visitables.get("hostPath").remove(this.hostPath);
    }
    return (A) this;
  }
  
  public A withIscsi(ISCSIPersistentVolumeSource iscsi) {
    this._visitables.remove("iscsi");
    if (iscsi != null) {
        this.iscsi = new ISCSIPersistentVolumeSourceBuilder(iscsi);
        this._visitables.get("iscsi").add(this.iscsi);
    } else {
        this.iscsi = null;
        this._visitables.get("iscsi").remove(this.iscsi);
    }
    return (A) this;
  }
  
  public A withLocal(LocalVolumeSource local) {
    this._visitables.remove("local");
    if (local != null) {
        this.local = new LocalVolumeSourceBuilder(local);
        this._visitables.get("local").add(this.local);
    } else {
        this.local = null;
        this._visitables.get("local").remove(this.local);
    }
    return (A) this;
  }
  
  public A withMountOptions(List<String> mountOptions) {
    if (mountOptions != null) {
        this.mountOptions = new ArrayList();
        for (String item : mountOptions) {
          this.addToMountOptions(item);
        }
    } else {
      this.mountOptions = null;
    }
    return (A) this;
  }
  
  public A withMountOptions(String... mountOptions) {
    if (this.mountOptions != null) {
        this.mountOptions.clear();
        _visitables.remove("mountOptions");
    }
    if (mountOptions != null) {
      for (String item : mountOptions) {
        this.addToMountOptions(item);
      }
    }
    return (A) this;
  }
  
  public AwsElasticBlockStoreNested<A> withNewAwsElasticBlockStore() {
    return new AwsElasticBlockStoreNested(null);
  }
  
  public A withNewAwsElasticBlockStore(String fsType,Integer partition,Boolean readOnly,String volumeID) {
    return (A) this.withAwsElasticBlockStore(new AWSElasticBlockStoreVolumeSource(fsType, partition, readOnly, volumeID));
  }
  
  public AwsElasticBlockStoreNested<A> withNewAwsElasticBlockStoreLike(AWSElasticBlockStoreVolumeSource item) {
    return new AwsElasticBlockStoreNested(item);
  }
  
  public AzureDiskNested<A> withNewAzureDisk() {
    return new AzureDiskNested(null);
  }
  
  public AzureDiskNested<A> withNewAzureDiskLike(AzureDiskVolumeSource item) {
    return new AzureDiskNested(item);
  }
  
  public AzureFileNested<A> withNewAzureFile() {
    return new AzureFileNested(null);
  }
  
  public A withNewAzureFile(Boolean readOnly,String secretName,String secretNamespace,String shareName) {
    return (A) this.withAzureFile(new AzureFilePersistentVolumeSource(readOnly, secretName, secretNamespace, shareName));
  }
  
  public AzureFileNested<A> withNewAzureFileLike(AzureFilePersistentVolumeSource item) {
    return new AzureFileNested(item);
  }
  
  public CephfsNested<A> withNewCephfs() {
    return new CephfsNested(null);
  }
  
  public CephfsNested<A> withNewCephfsLike(CephFSPersistentVolumeSource item) {
    return new CephfsNested(item);
  }
  
  public CinderNested<A> withNewCinder() {
    return new CinderNested(null);
  }
  
  public CinderNested<A> withNewCinderLike(CinderPersistentVolumeSource item) {
    return new CinderNested(item);
  }
  
  public ClaimRefNested<A> withNewClaimRef() {
    return new ClaimRefNested(null);
  }
  
  public ClaimRefNested<A> withNewClaimRefLike(ObjectReference item) {
    return new ClaimRefNested(item);
  }
  
  public CsiNested<A> withNewCsi() {
    return new CsiNested(null);
  }
  
  public CsiNested<A> withNewCsiLike(CSIPersistentVolumeSource item) {
    return new CsiNested(item);
  }
  
  public FcNested<A> withNewFc() {
    return new FcNested(null);
  }
  
  public FcNested<A> withNewFcLike(FCVolumeSource item) {
    return new FcNested(item);
  }
  
  public FlexVolumeNested<A> withNewFlexVolume() {
    return new FlexVolumeNested(null);
  }
  
  public FlexVolumeNested<A> withNewFlexVolumeLike(FlexPersistentVolumeSource item) {
    return new FlexVolumeNested(item);
  }
  
  public FlockerNested<A> withNewFlocker() {
    return new FlockerNested(null);
  }
  
  public A withNewFlocker(String datasetName,String datasetUUID) {
    return (A) this.withFlocker(new FlockerVolumeSource(datasetName, datasetUUID));
  }
  
  public FlockerNested<A> withNewFlockerLike(FlockerVolumeSource item) {
    return new FlockerNested(item);
  }
  
  public GcePersistentDiskNested<A> withNewGcePersistentDisk() {
    return new GcePersistentDiskNested(null);
  }
  
  public A withNewGcePersistentDisk(String fsType,Integer partition,String pdName,Boolean readOnly) {
    return (A) this.withGcePersistentDisk(new GCEPersistentDiskVolumeSource(fsType, partition, pdName, readOnly));
  }
  
  public GcePersistentDiskNested<A> withNewGcePersistentDiskLike(GCEPersistentDiskVolumeSource item) {
    return new GcePersistentDiskNested(item);
  }
  
  public GlusterfsNested<A> withNewGlusterfs() {
    return new GlusterfsNested(null);
  }
  
  public A withNewGlusterfs(String endpoints,String endpointsNamespace,String path,Boolean readOnly) {
    return (A) this.withGlusterfs(new GlusterfsPersistentVolumeSource(endpoints, endpointsNamespace, path, readOnly));
  }
  
  public GlusterfsNested<A> withNewGlusterfsLike(GlusterfsPersistentVolumeSource item) {
    return new GlusterfsNested(item);
  }
  
  public HostPathNested<A> withNewHostPath() {
    return new HostPathNested(null);
  }
  
  public A withNewHostPath(String path,String type) {
    return (A) this.withHostPath(new HostPathVolumeSource(path, type));
  }
  
  public HostPathNested<A> withNewHostPathLike(HostPathVolumeSource item) {
    return new HostPathNested(item);
  }
  
  public IscsiNested<A> withNewIscsi() {
    return new IscsiNested(null);
  }
  
  public IscsiNested<A> withNewIscsiLike(ISCSIPersistentVolumeSource item) {
    return new IscsiNested(item);
  }
  
  public LocalNested<A> withNewLocal() {
    return new LocalNested(null);
  }
  
  public A withNewLocal(String fsType,String path) {
    return (A) this.withLocal(new LocalVolumeSource(fsType, path));
  }
  
  public LocalNested<A> withNewLocalLike(LocalVolumeSource item) {
    return new LocalNested(item);
  }
  
  public NfsNested<A> withNewNfs() {
    return new NfsNested(null);
  }
  
  public A withNewNfs(String path,Boolean readOnly,String server) {
    return (A) this.withNfs(new NFSVolumeSource(path, readOnly, server));
  }
  
  public NfsNested<A> withNewNfsLike(NFSVolumeSource item) {
    return new NfsNested(item);
  }
  
  public NodeAffinityNested<A> withNewNodeAffinity() {
    return new NodeAffinityNested(null);
  }
  
  public NodeAffinityNested<A> withNewNodeAffinityLike(VolumeNodeAffinity item) {
    return new NodeAffinityNested(item);
  }
  
  public PhotonPersistentDiskNested<A> withNewPhotonPersistentDisk() {
    return new PhotonPersistentDiskNested(null);
  }
  
  public A withNewPhotonPersistentDisk(String fsType,String pdID) {
    return (A) this.withPhotonPersistentDisk(new PhotonPersistentDiskVolumeSource(fsType, pdID));
  }
  
  public PhotonPersistentDiskNested<A> withNewPhotonPersistentDiskLike(PhotonPersistentDiskVolumeSource item) {
    return new PhotonPersistentDiskNested(item);
  }
  
  public PortworxVolumeNested<A> withNewPortworxVolume() {
    return new PortworxVolumeNested(null);
  }
  
  public A withNewPortworxVolume(String fsType,Boolean readOnly,String volumeID) {
    return (A) this.withPortworxVolume(new PortworxVolumeSource(fsType, readOnly, volumeID));
  }
  
  public PortworxVolumeNested<A> withNewPortworxVolumeLike(PortworxVolumeSource item) {
    return new PortworxVolumeNested(item);
  }
  
  public QuobyteNested<A> withNewQuobyte() {
    return new QuobyteNested(null);
  }
  
  public QuobyteNested<A> withNewQuobyteLike(QuobyteVolumeSource item) {
    return new QuobyteNested(item);
  }
  
  public RbdNested<A> withNewRbd() {
    return new RbdNested(null);
  }
  
  public RbdNested<A> withNewRbdLike(RBDPersistentVolumeSource item) {
    return new RbdNested(item);
  }
  
  public ScaleIONested<A> withNewScaleIO() {
    return new ScaleIONested(null);
  }
  
  public ScaleIONested<A> withNewScaleIOLike(ScaleIOPersistentVolumeSource item) {
    return new ScaleIONested(item);
  }
  
  public StorageosNested<A> withNewStorageos() {
    return new StorageosNested(null);
  }
  
  public StorageosNested<A> withNewStorageosLike(StorageOSPersistentVolumeSource item) {
    return new StorageosNested(item);
  }
  
  public VsphereVolumeNested<A> withNewVsphereVolume() {
    return new VsphereVolumeNested(null);
  }
  
  public A withNewVsphereVolume(String fsType,String storagePolicyID,String storagePolicyName,String volumePath) {
    return (A) this.withVsphereVolume(new VsphereVirtualDiskVolumeSource(fsType, storagePolicyID, storagePolicyName, volumePath));
  }
  
  public VsphereVolumeNested<A> withNewVsphereVolumeLike(VsphereVirtualDiskVolumeSource item) {
    return new VsphereVolumeNested(item);
  }
  
  public A withNfs(NFSVolumeSource nfs) {
    this._visitables.remove("nfs");
    if (nfs != null) {
        this.nfs = new NFSVolumeSourceBuilder(nfs);
        this._visitables.get("nfs").add(this.nfs);
    } else {
        this.nfs = null;
        this._visitables.get("nfs").remove(this.nfs);
    }
    return (A) this;
  }
  
  public A withNodeAffinity(VolumeNodeAffinity nodeAffinity) {
    this._visitables.remove("nodeAffinity");
    if (nodeAffinity != null) {
        this.nodeAffinity = new VolumeNodeAffinityBuilder(nodeAffinity);
        this._visitables.get("nodeAffinity").add(this.nodeAffinity);
    } else {
        this.nodeAffinity = null;
        this._visitables.get("nodeAffinity").remove(this.nodeAffinity);
    }
    return (A) this;
  }
  
  public A withPersistentVolumeReclaimPolicy(String persistentVolumeReclaimPolicy) {
    this.persistentVolumeReclaimPolicy = persistentVolumeReclaimPolicy;
    return (A) this;
  }
  
  public A withPhotonPersistentDisk(PhotonPersistentDiskVolumeSource photonPersistentDisk) {
    this._visitables.remove("photonPersistentDisk");
    if (photonPersistentDisk != null) {
        this.photonPersistentDisk = new PhotonPersistentDiskVolumeSourceBuilder(photonPersistentDisk);
        this._visitables.get("photonPersistentDisk").add(this.photonPersistentDisk);
    } else {
        this.photonPersistentDisk = null;
        this._visitables.get("photonPersistentDisk").remove(this.photonPersistentDisk);
    }
    return (A) this;
  }
  
  public A withPortworxVolume(PortworxVolumeSource portworxVolume) {
    this._visitables.remove("portworxVolume");
    if (portworxVolume != null) {
        this.portworxVolume = new PortworxVolumeSourceBuilder(portworxVolume);
        this._visitables.get("portworxVolume").add(this.portworxVolume);
    } else {
        this.portworxVolume = null;
        this._visitables.get("portworxVolume").remove(this.portworxVolume);
    }
    return (A) this;
  }
  
  public A withQuobyte(QuobyteVolumeSource quobyte) {
    this._visitables.remove("quobyte");
    if (quobyte != null) {
        this.quobyte = new QuobyteVolumeSourceBuilder(quobyte);
        this._visitables.get("quobyte").add(this.quobyte);
    } else {
        this.quobyte = null;
        this._visitables.get("quobyte").remove(this.quobyte);
    }
    return (A) this;
  }
  
  public A withRbd(RBDPersistentVolumeSource rbd) {
    this._visitables.remove("rbd");
    if (rbd != null) {
        this.rbd = new RBDPersistentVolumeSourceBuilder(rbd);
        this._visitables.get("rbd").add(this.rbd);
    } else {
        this.rbd = null;
        this._visitables.get("rbd").remove(this.rbd);
    }
    return (A) this;
  }
  
  public A withScaleIO(ScaleIOPersistentVolumeSource scaleIO) {
    this._visitables.remove("scaleIO");
    if (scaleIO != null) {
        this.scaleIO = new ScaleIOPersistentVolumeSourceBuilder(scaleIO);
        this._visitables.get("scaleIO").add(this.scaleIO);
    } else {
        this.scaleIO = null;
        this._visitables.get("scaleIO").remove(this.scaleIO);
    }
    return (A) this;
  }
  
  public A withStorageClassName(String storageClassName) {
    this.storageClassName = storageClassName;
    return (A) this;
  }
  
  public A withStorageos(StorageOSPersistentVolumeSource storageos) {
    this._visitables.remove("storageos");
    if (storageos != null) {
        this.storageos = new StorageOSPersistentVolumeSourceBuilder(storageos);
        this._visitables.get("storageos").add(this.storageos);
    } else {
        this.storageos = null;
        this._visitables.get("storageos").remove(this.storageos);
    }
    return (A) this;
  }
  
  public A withVolumeAttributesClassName(String volumeAttributesClassName) {
    this.volumeAttributesClassName = volumeAttributesClassName;
    return (A) this;
  }
  
  public A withVolumeMode(String volumeMode) {
    this.volumeMode = volumeMode;
    return (A) this;
  }
  
  public A withVsphereVolume(VsphereVirtualDiskVolumeSource vsphereVolume) {
    this._visitables.remove("vsphereVolume");
    if (vsphereVolume != null) {
        this.vsphereVolume = new VsphereVirtualDiskVolumeSourceBuilder(vsphereVolume);
        this._visitables.get("vsphereVolume").add(this.vsphereVolume);
    } else {
        this.vsphereVolume = null;
        this._visitables.get("vsphereVolume").remove(this.vsphereVolume);
    }
    return (A) this;
  }
  public class AwsElasticBlockStoreNested<N> extends AWSElasticBlockStoreVolumeSourceFluent<AwsElasticBlockStoreNested<N>> implements Nested<N>{
  
    AWSElasticBlockStoreVolumeSourceBuilder builder;
  
    AwsElasticBlockStoreNested(AWSElasticBlockStoreVolumeSource item) {
      this.builder = new AWSElasticBlockStoreVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withAwsElasticBlockStore(builder.build());
    }
    
    public N endAwsElasticBlockStore() {
      return and();
    }
    
  }
  public class AzureDiskNested<N> extends AzureDiskVolumeSourceFluent<AzureDiskNested<N>> implements Nested<N>{
  
    AzureDiskVolumeSourceBuilder builder;
  
    AzureDiskNested(AzureDiskVolumeSource item) {
      this.builder = new AzureDiskVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withAzureDisk(builder.build());
    }
    
    public N endAzureDisk() {
      return and();
    }
    
  }
  public class AzureFileNested<N> extends AzureFilePersistentVolumeSourceFluent<AzureFileNested<N>> implements Nested<N>{
  
    AzureFilePersistentVolumeSourceBuilder builder;
  
    AzureFileNested(AzureFilePersistentVolumeSource item) {
      this.builder = new AzureFilePersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withAzureFile(builder.build());
    }
    
    public N endAzureFile() {
      return and();
    }
    
  }
  public class CephfsNested<N> extends CephFSPersistentVolumeSourceFluent<CephfsNested<N>> implements Nested<N>{
  
    CephFSPersistentVolumeSourceBuilder builder;
  
    CephfsNested(CephFSPersistentVolumeSource item) {
      this.builder = new CephFSPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withCephfs(builder.build());
    }
    
    public N endCephfs() {
      return and();
    }
    
  }
  public class CinderNested<N> extends CinderPersistentVolumeSourceFluent<CinderNested<N>> implements Nested<N>{
  
    CinderPersistentVolumeSourceBuilder builder;
  
    CinderNested(CinderPersistentVolumeSource item) {
      this.builder = new CinderPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withCinder(builder.build());
    }
    
    public N endCinder() {
      return and();
    }
    
  }
  public class ClaimRefNested<N> extends ObjectReferenceFluent<ClaimRefNested<N>> implements Nested<N>{
  
    ObjectReferenceBuilder builder;
  
    ClaimRefNested(ObjectReference item) {
      this.builder = new ObjectReferenceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withClaimRef(builder.build());
    }
    
    public N endClaimRef() {
      return and();
    }
    
  }
  public class CsiNested<N> extends CSIPersistentVolumeSourceFluent<CsiNested<N>> implements Nested<N>{
  
    CSIPersistentVolumeSourceBuilder builder;
  
    CsiNested(CSIPersistentVolumeSource item) {
      this.builder = new CSIPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withCsi(builder.build());
    }
    
    public N endCsi() {
      return and();
    }
    
  }
  public class FcNested<N> extends FCVolumeSourceFluent<FcNested<N>> implements Nested<N>{
  
    FCVolumeSourceBuilder builder;
  
    FcNested(FCVolumeSource item) {
      this.builder = new FCVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withFc(builder.build());
    }
    
    public N endFc() {
      return and();
    }
    
  }
  public class FlexVolumeNested<N> extends FlexPersistentVolumeSourceFluent<FlexVolumeNested<N>> implements Nested<N>{
  
    FlexPersistentVolumeSourceBuilder builder;
  
    FlexVolumeNested(FlexPersistentVolumeSource item) {
      this.builder = new FlexPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withFlexVolume(builder.build());
    }
    
    public N endFlexVolume() {
      return and();
    }
    
  }
  public class FlockerNested<N> extends FlockerVolumeSourceFluent<FlockerNested<N>> implements Nested<N>{
  
    FlockerVolumeSourceBuilder builder;
  
    FlockerNested(FlockerVolumeSource item) {
      this.builder = new FlockerVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withFlocker(builder.build());
    }
    
    public N endFlocker() {
      return and();
    }
    
  }
  public class GcePersistentDiskNested<N> extends GCEPersistentDiskVolumeSourceFluent<GcePersistentDiskNested<N>> implements Nested<N>{
  
    GCEPersistentDiskVolumeSourceBuilder builder;
  
    GcePersistentDiskNested(GCEPersistentDiskVolumeSource item) {
      this.builder = new GCEPersistentDiskVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withGcePersistentDisk(builder.build());
    }
    
    public N endGcePersistentDisk() {
      return and();
    }
    
  }
  public class GlusterfsNested<N> extends GlusterfsPersistentVolumeSourceFluent<GlusterfsNested<N>> implements Nested<N>{
  
    GlusterfsPersistentVolumeSourceBuilder builder;
  
    GlusterfsNested(GlusterfsPersistentVolumeSource item) {
      this.builder = new GlusterfsPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withGlusterfs(builder.build());
    }
    
    public N endGlusterfs() {
      return and();
    }
    
  }
  public class HostPathNested<N> extends HostPathVolumeSourceFluent<HostPathNested<N>> implements Nested<N>{
  
    HostPathVolumeSourceBuilder builder;
  
    HostPathNested(HostPathVolumeSource item) {
      this.builder = new HostPathVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withHostPath(builder.build());
    }
    
    public N endHostPath() {
      return and();
    }
    
  }
  public class IscsiNested<N> extends ISCSIPersistentVolumeSourceFluent<IscsiNested<N>> implements Nested<N>{
  
    ISCSIPersistentVolumeSourceBuilder builder;
  
    IscsiNested(ISCSIPersistentVolumeSource item) {
      this.builder = new ISCSIPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withIscsi(builder.build());
    }
    
    public N endIscsi() {
      return and();
    }
    
  }
  public class LocalNested<N> extends LocalVolumeSourceFluent<LocalNested<N>> implements Nested<N>{
  
    LocalVolumeSourceBuilder builder;
  
    LocalNested(LocalVolumeSource item) {
      this.builder = new LocalVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withLocal(builder.build());
    }
    
    public N endLocal() {
      return and();
    }
    
  }
  public class NfsNested<N> extends NFSVolumeSourceFluent<NfsNested<N>> implements Nested<N>{
  
    NFSVolumeSourceBuilder builder;
  
    NfsNested(NFSVolumeSource item) {
      this.builder = new NFSVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withNfs(builder.build());
    }
    
    public N endNfs() {
      return and();
    }
    
  }
  public class NodeAffinityNested<N> extends VolumeNodeAffinityFluent<NodeAffinityNested<N>> implements Nested<N>{
  
    VolumeNodeAffinityBuilder builder;
  
    NodeAffinityNested(VolumeNodeAffinity item) {
      this.builder = new VolumeNodeAffinityBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withNodeAffinity(builder.build());
    }
    
    public N endNodeAffinity() {
      return and();
    }
    
  }
  public class PhotonPersistentDiskNested<N> extends PhotonPersistentDiskVolumeSourceFluent<PhotonPersistentDiskNested<N>> implements Nested<N>{
  
    PhotonPersistentDiskVolumeSourceBuilder builder;
  
    PhotonPersistentDiskNested(PhotonPersistentDiskVolumeSource item) {
      this.builder = new PhotonPersistentDiskVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withPhotonPersistentDisk(builder.build());
    }
    
    public N endPhotonPersistentDisk() {
      return and();
    }
    
  }
  public class PortworxVolumeNested<N> extends PortworxVolumeSourceFluent<PortworxVolumeNested<N>> implements Nested<N>{
  
    PortworxVolumeSourceBuilder builder;
  
    PortworxVolumeNested(PortworxVolumeSource item) {
      this.builder = new PortworxVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withPortworxVolume(builder.build());
    }
    
    public N endPortworxVolume() {
      return and();
    }
    
  }
  public class QuobyteNested<N> extends QuobyteVolumeSourceFluent<QuobyteNested<N>> implements Nested<N>{
  
    QuobyteVolumeSourceBuilder builder;
  
    QuobyteNested(QuobyteVolumeSource item) {
      this.builder = new QuobyteVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withQuobyte(builder.build());
    }
    
    public N endQuobyte() {
      return and();
    }
    
  }
  public class RbdNested<N> extends RBDPersistentVolumeSourceFluent<RbdNested<N>> implements Nested<N>{
  
    RBDPersistentVolumeSourceBuilder builder;
  
    RbdNested(RBDPersistentVolumeSource item) {
      this.builder = new RBDPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withRbd(builder.build());
    }
    
    public N endRbd() {
      return and();
    }
    
  }
  public class ScaleIONested<N> extends ScaleIOPersistentVolumeSourceFluent<ScaleIONested<N>> implements Nested<N>{
  
    ScaleIOPersistentVolumeSourceBuilder builder;
  
    ScaleIONested(ScaleIOPersistentVolumeSource item) {
      this.builder = new ScaleIOPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withScaleIO(builder.build());
    }
    
    public N endScaleIO() {
      return and();
    }
    
  }
  public class StorageosNested<N> extends StorageOSPersistentVolumeSourceFluent<StorageosNested<N>> implements Nested<N>{
  
    StorageOSPersistentVolumeSourceBuilder builder;
  
    StorageosNested(StorageOSPersistentVolumeSource item) {
      this.builder = new StorageOSPersistentVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withStorageos(builder.build());
    }
    
    public N endStorageos() {
      return and();
    }
    
  }
  public class VsphereVolumeNested<N> extends VsphereVirtualDiskVolumeSourceFluent<VsphereVolumeNested<N>> implements Nested<N>{
  
    VsphereVirtualDiskVolumeSourceBuilder builder;
  
    VsphereVolumeNested(VsphereVirtualDiskVolumeSource item) {
      this.builder = new VsphereVirtualDiskVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) PersistentVolumeSpecFluent.this.withVsphereVolume(builder.build());
    }
    
    public N endVsphereVolume() {
      return and();
    }
    
  }
}