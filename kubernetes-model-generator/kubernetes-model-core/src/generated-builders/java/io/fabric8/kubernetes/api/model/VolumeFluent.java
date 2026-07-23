package io.fabric8.kubernetes.api.model;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class VolumeFluent<A extends io.fabric8.kubernetes.api.model.VolumeFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private AWSElasticBlockStoreVolumeSourceBuilder awsElasticBlockStore;
  private AzureDiskVolumeSourceBuilder azureDisk;
  private AzureFileVolumeSourceBuilder azureFile;
  private CephFSVolumeSourceBuilder cephfs;
  private CinderVolumeSourceBuilder cinder;
  private ConfigMapVolumeSourceBuilder configMap;
  private CSIVolumeSourceBuilder csi;
  private DownwardAPIVolumeSourceBuilder downwardAPI;
  private EmptyDirVolumeSourceBuilder emptyDir;
  private EphemeralVolumeSourceBuilder ephemeral;
  private FCVolumeSourceBuilder fc;
  private FlexVolumeSourceBuilder flexVolume;
  private FlockerVolumeSourceBuilder flocker;
  private GCEPersistentDiskVolumeSourceBuilder gcePersistentDisk;
  private GitRepoVolumeSourceBuilder gitRepo;
  private GlusterfsVolumeSourceBuilder glusterfs;
  private HostPathVolumeSourceBuilder hostPath;
  private ImageVolumeSourceBuilder image;
  private ISCSIVolumeSourceBuilder iscsi;
  private String name;
  private NFSVolumeSourceBuilder nfs;
  private PersistentVolumeClaimVolumeSourceBuilder persistentVolumeClaim;
  private PhotonPersistentDiskVolumeSourceBuilder photonPersistentDisk;
  private PortworxVolumeSourceBuilder portworxVolume;
  private ProjectedVolumeSourceBuilder projected;
  private QuobyteVolumeSourceBuilder quobyte;
  private RBDVolumeSourceBuilder rbd;
  private ScaleIOVolumeSourceBuilder scaleIO;
  private SecretVolumeSourceBuilder secret;
  private StorageOSVolumeSourceBuilder storageos;
  private VsphereVirtualDiskVolumeSourceBuilder vsphereVolume;

  public VolumeFluent() {
  }
  
  public VolumeFluent(Volume instance) {
    this.copyInstance(instance);
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
  
  public AWSElasticBlockStoreVolumeSource buildAwsElasticBlockStore() {
    return this.awsElasticBlockStore != null ? this.awsElasticBlockStore.build() : null;
  }
  
  public AzureDiskVolumeSource buildAzureDisk() {
    return this.azureDisk != null ? this.azureDisk.build() : null;
  }
  
  public AzureFileVolumeSource buildAzureFile() {
    return this.azureFile != null ? this.azureFile.build() : null;
  }
  
  public CephFSVolumeSource buildCephfs() {
    return this.cephfs != null ? this.cephfs.build() : null;
  }
  
  public CinderVolumeSource buildCinder() {
    return this.cinder != null ? this.cinder.build() : null;
  }
  
  public ConfigMapVolumeSource buildConfigMap() {
    return this.configMap != null ? this.configMap.build() : null;
  }
  
  public CSIVolumeSource buildCsi() {
    return this.csi != null ? this.csi.build() : null;
  }
  
  public DownwardAPIVolumeSource buildDownwardAPI() {
    return this.downwardAPI != null ? this.downwardAPI.build() : null;
  }
  
  public EmptyDirVolumeSource buildEmptyDir() {
    return this.emptyDir != null ? this.emptyDir.build() : null;
  }
  
  public EphemeralVolumeSource buildEphemeral() {
    return this.ephemeral != null ? this.ephemeral.build() : null;
  }
  
  public FCVolumeSource buildFc() {
    return this.fc != null ? this.fc.build() : null;
  }
  
  public FlexVolumeSource buildFlexVolume() {
    return this.flexVolume != null ? this.flexVolume.build() : null;
  }
  
  public FlockerVolumeSource buildFlocker() {
    return this.flocker != null ? this.flocker.build() : null;
  }
  
  public GCEPersistentDiskVolumeSource buildGcePersistentDisk() {
    return this.gcePersistentDisk != null ? this.gcePersistentDisk.build() : null;
  }
  
  public GitRepoVolumeSource buildGitRepo() {
    return this.gitRepo != null ? this.gitRepo.build() : null;
  }
  
  public GlusterfsVolumeSource buildGlusterfs() {
    return this.glusterfs != null ? this.glusterfs.build() : null;
  }
  
  public HostPathVolumeSource buildHostPath() {
    return this.hostPath != null ? this.hostPath.build() : null;
  }
  
  public ImageVolumeSource buildImage() {
    return this.image != null ? this.image.build() : null;
  }
  
  public ISCSIVolumeSource buildIscsi() {
    return this.iscsi != null ? this.iscsi.build() : null;
  }
  
  public NFSVolumeSource buildNfs() {
    return this.nfs != null ? this.nfs.build() : null;
  }
  
  public PersistentVolumeClaimVolumeSource buildPersistentVolumeClaim() {
    return this.persistentVolumeClaim != null ? this.persistentVolumeClaim.build() : null;
  }
  
  public PhotonPersistentDiskVolumeSource buildPhotonPersistentDisk() {
    return this.photonPersistentDisk != null ? this.photonPersistentDisk.build() : null;
  }
  
  public PortworxVolumeSource buildPortworxVolume() {
    return this.portworxVolume != null ? this.portworxVolume.build() : null;
  }
  
  public ProjectedVolumeSource buildProjected() {
    return this.projected != null ? this.projected.build() : null;
  }
  
  public QuobyteVolumeSource buildQuobyte() {
    return this.quobyte != null ? this.quobyte.build() : null;
  }
  
  public RBDVolumeSource buildRbd() {
    return this.rbd != null ? this.rbd.build() : null;
  }
  
  public ScaleIOVolumeSource buildScaleIO() {
    return this.scaleIO != null ? this.scaleIO.build() : null;
  }
  
  public SecretVolumeSource buildSecret() {
    return this.secret != null ? this.secret.build() : null;
  }
  
  public StorageOSVolumeSource buildStorageos() {
    return this.storageos != null ? this.storageos.build() : null;
  }
  
  public VsphereVirtualDiskVolumeSource buildVsphereVolume() {
    return this.vsphereVolume != null ? this.vsphereVolume.build() : null;
  }
  
  protected void copyInstance(Volume instance) {
    instance = instance != null ? instance : new Volume();
    if (instance != null) {
        this.withAwsElasticBlockStore(instance.getAwsElasticBlockStore());
        this.withAzureDisk(instance.getAzureDisk());
        this.withAzureFile(instance.getAzureFile());
        this.withCephfs(instance.getCephfs());
        this.withCinder(instance.getCinder());
        this.withConfigMap(instance.getConfigMap());
        this.withCsi(instance.getCsi());
        this.withDownwardAPI(instance.getDownwardAPI());
        this.withEmptyDir(instance.getEmptyDir());
        this.withEphemeral(instance.getEphemeral());
        this.withFc(instance.getFc());
        this.withFlexVolume(instance.getFlexVolume());
        this.withFlocker(instance.getFlocker());
        this.withGcePersistentDisk(instance.getGcePersistentDisk());
        this.withGitRepo(instance.getGitRepo());
        this.withGlusterfs(instance.getGlusterfs());
        this.withHostPath(instance.getHostPath());
        this.withImage(instance.getImage());
        this.withIscsi(instance.getIscsi());
        this.withName(instance.getName());
        this.withNfs(instance.getNfs());
        this.withPersistentVolumeClaim(instance.getPersistentVolumeClaim());
        this.withPhotonPersistentDisk(instance.getPhotonPersistentDisk());
        this.withPortworxVolume(instance.getPortworxVolume());
        this.withProjected(instance.getProjected());
        this.withQuobyte(instance.getQuobyte());
        this.withRbd(instance.getRbd());
        this.withScaleIO(instance.getScaleIO());
        this.withSecret(instance.getSecret());
        this.withStorageos(instance.getStorageos());
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
  
  public ConfigMapNested<A> editConfigMap() {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(null));
  }
  
  public CsiNested<A> editCsi() {
    return this.withNewCsiLike(Optional.ofNullable(this.buildCsi()).orElse(null));
  }
  
  public DownwardAPINested<A> editDownwardAPI() {
    return this.withNewDownwardAPILike(Optional.ofNullable(this.buildDownwardAPI()).orElse(null));
  }
  
  public EmptyDirNested<A> editEmptyDir() {
    return this.withNewEmptyDirLike(Optional.ofNullable(this.buildEmptyDir()).orElse(null));
  }
  
  public EphemeralNested<A> editEphemeral() {
    return this.withNewEphemeralLike(Optional.ofNullable(this.buildEphemeral()).orElse(null));
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
  
  public GitRepoNested<A> editGitRepo() {
    return this.withNewGitRepoLike(Optional.ofNullable(this.buildGitRepo()).orElse(null));
  }
  
  public GlusterfsNested<A> editGlusterfs() {
    return this.withNewGlusterfsLike(Optional.ofNullable(this.buildGlusterfs()).orElse(null));
  }
  
  public HostPathNested<A> editHostPath() {
    return this.withNewHostPathLike(Optional.ofNullable(this.buildHostPath()).orElse(null));
  }
  
  public ImageNested<A> editImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(null));
  }
  
  public IscsiNested<A> editIscsi() {
    return this.withNewIscsiLike(Optional.ofNullable(this.buildIscsi()).orElse(null));
  }
  
  public NfsNested<A> editNfs() {
    return this.withNewNfsLike(Optional.ofNullable(this.buildNfs()).orElse(null));
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
    return this.withNewAzureFileLike(Optional.ofNullable(this.buildAzureFile()).orElse(new AzureFileVolumeSourceBuilder().build()));
  }
  
  public AzureFileNested<A> editOrNewAzureFileLike(AzureFileVolumeSource item) {
    return this.withNewAzureFileLike(Optional.ofNullable(this.buildAzureFile()).orElse(item));
  }
  
  public CephfsNested<A> editOrNewCephfs() {
    return this.withNewCephfsLike(Optional.ofNullable(this.buildCephfs()).orElse(new CephFSVolumeSourceBuilder().build()));
  }
  
  public CephfsNested<A> editOrNewCephfsLike(CephFSVolumeSource item) {
    return this.withNewCephfsLike(Optional.ofNullable(this.buildCephfs()).orElse(item));
  }
  
  public CinderNested<A> editOrNewCinder() {
    return this.withNewCinderLike(Optional.ofNullable(this.buildCinder()).orElse(new CinderVolumeSourceBuilder().build()));
  }
  
  public CinderNested<A> editOrNewCinderLike(CinderVolumeSource item) {
    return this.withNewCinderLike(Optional.ofNullable(this.buildCinder()).orElse(item));
  }
  
  public ConfigMapNested<A> editOrNewConfigMap() {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(new ConfigMapVolumeSourceBuilder().build()));
  }
  
  public ConfigMapNested<A> editOrNewConfigMapLike(ConfigMapVolumeSource item) {
    return this.withNewConfigMapLike(Optional.ofNullable(this.buildConfigMap()).orElse(item));
  }
  
  public CsiNested<A> editOrNewCsi() {
    return this.withNewCsiLike(Optional.ofNullable(this.buildCsi()).orElse(new CSIVolumeSourceBuilder().build()));
  }
  
  public CsiNested<A> editOrNewCsiLike(CSIVolumeSource item) {
    return this.withNewCsiLike(Optional.ofNullable(this.buildCsi()).orElse(item));
  }
  
  public DownwardAPINested<A> editOrNewDownwardAPI() {
    return this.withNewDownwardAPILike(Optional.ofNullable(this.buildDownwardAPI()).orElse(new DownwardAPIVolumeSourceBuilder().build()));
  }
  
  public DownwardAPINested<A> editOrNewDownwardAPILike(DownwardAPIVolumeSource item) {
    return this.withNewDownwardAPILike(Optional.ofNullable(this.buildDownwardAPI()).orElse(item));
  }
  
  public EmptyDirNested<A> editOrNewEmptyDir() {
    return this.withNewEmptyDirLike(Optional.ofNullable(this.buildEmptyDir()).orElse(new EmptyDirVolumeSourceBuilder().build()));
  }
  
  public EmptyDirNested<A> editOrNewEmptyDirLike(EmptyDirVolumeSource item) {
    return this.withNewEmptyDirLike(Optional.ofNullable(this.buildEmptyDir()).orElse(item));
  }
  
  public EphemeralNested<A> editOrNewEphemeral() {
    return this.withNewEphemeralLike(Optional.ofNullable(this.buildEphemeral()).orElse(new EphemeralVolumeSourceBuilder().build()));
  }
  
  public EphemeralNested<A> editOrNewEphemeralLike(EphemeralVolumeSource item) {
    return this.withNewEphemeralLike(Optional.ofNullable(this.buildEphemeral()).orElse(item));
  }
  
  public FcNested<A> editOrNewFc() {
    return this.withNewFcLike(Optional.ofNullable(this.buildFc()).orElse(new FCVolumeSourceBuilder().build()));
  }
  
  public FcNested<A> editOrNewFcLike(FCVolumeSource item) {
    return this.withNewFcLike(Optional.ofNullable(this.buildFc()).orElse(item));
  }
  
  public FlexVolumeNested<A> editOrNewFlexVolume() {
    return this.withNewFlexVolumeLike(Optional.ofNullable(this.buildFlexVolume()).orElse(new FlexVolumeSourceBuilder().build()));
  }
  
  public FlexVolumeNested<A> editOrNewFlexVolumeLike(FlexVolumeSource item) {
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
  
  public GitRepoNested<A> editOrNewGitRepo() {
    return this.withNewGitRepoLike(Optional.ofNullable(this.buildGitRepo()).orElse(new GitRepoVolumeSourceBuilder().build()));
  }
  
  public GitRepoNested<A> editOrNewGitRepoLike(GitRepoVolumeSource item) {
    return this.withNewGitRepoLike(Optional.ofNullable(this.buildGitRepo()).orElse(item));
  }
  
  public GlusterfsNested<A> editOrNewGlusterfs() {
    return this.withNewGlusterfsLike(Optional.ofNullable(this.buildGlusterfs()).orElse(new GlusterfsVolumeSourceBuilder().build()));
  }
  
  public GlusterfsNested<A> editOrNewGlusterfsLike(GlusterfsVolumeSource item) {
    return this.withNewGlusterfsLike(Optional.ofNullable(this.buildGlusterfs()).orElse(item));
  }
  
  public HostPathNested<A> editOrNewHostPath() {
    return this.withNewHostPathLike(Optional.ofNullable(this.buildHostPath()).orElse(new HostPathVolumeSourceBuilder().build()));
  }
  
  public HostPathNested<A> editOrNewHostPathLike(HostPathVolumeSource item) {
    return this.withNewHostPathLike(Optional.ofNullable(this.buildHostPath()).orElse(item));
  }
  
  public ImageNested<A> editOrNewImage() {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(new ImageVolumeSourceBuilder().build()));
  }
  
  public ImageNested<A> editOrNewImageLike(ImageVolumeSource item) {
    return this.withNewImageLike(Optional.ofNullable(this.buildImage()).orElse(item));
  }
  
  public IscsiNested<A> editOrNewIscsi() {
    return this.withNewIscsiLike(Optional.ofNullable(this.buildIscsi()).orElse(new ISCSIVolumeSourceBuilder().build()));
  }
  
  public IscsiNested<A> editOrNewIscsiLike(ISCSIVolumeSource item) {
    return this.withNewIscsiLike(Optional.ofNullable(this.buildIscsi()).orElse(item));
  }
  
  public NfsNested<A> editOrNewNfs() {
    return this.withNewNfsLike(Optional.ofNullable(this.buildNfs()).orElse(new NFSVolumeSourceBuilder().build()));
  }
  
  public NfsNested<A> editOrNewNfsLike(NFSVolumeSource item) {
    return this.withNewNfsLike(Optional.ofNullable(this.buildNfs()).orElse(item));
  }
  
  public PersistentVolumeClaimNested<A> editOrNewPersistentVolumeClaim() {
    return this.withNewPersistentVolumeClaimLike(Optional.ofNullable(this.buildPersistentVolumeClaim()).orElse(new PersistentVolumeClaimVolumeSourceBuilder().build()));
  }
  
  public PersistentVolumeClaimNested<A> editOrNewPersistentVolumeClaimLike(PersistentVolumeClaimVolumeSource item) {
    return this.withNewPersistentVolumeClaimLike(Optional.ofNullable(this.buildPersistentVolumeClaim()).orElse(item));
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
  
  public ProjectedNested<A> editOrNewProjected() {
    return this.withNewProjectedLike(Optional.ofNullable(this.buildProjected()).orElse(new ProjectedVolumeSourceBuilder().build()));
  }
  
  public ProjectedNested<A> editOrNewProjectedLike(ProjectedVolumeSource item) {
    return this.withNewProjectedLike(Optional.ofNullable(this.buildProjected()).orElse(item));
  }
  
  public QuobyteNested<A> editOrNewQuobyte() {
    return this.withNewQuobyteLike(Optional.ofNullable(this.buildQuobyte()).orElse(new QuobyteVolumeSourceBuilder().build()));
  }
  
  public QuobyteNested<A> editOrNewQuobyteLike(QuobyteVolumeSource item) {
    return this.withNewQuobyteLike(Optional.ofNullable(this.buildQuobyte()).orElse(item));
  }
  
  public RbdNested<A> editOrNewRbd() {
    return this.withNewRbdLike(Optional.ofNullable(this.buildRbd()).orElse(new RBDVolumeSourceBuilder().build()));
  }
  
  public RbdNested<A> editOrNewRbdLike(RBDVolumeSource item) {
    return this.withNewRbdLike(Optional.ofNullable(this.buildRbd()).orElse(item));
  }
  
  public ScaleIONested<A> editOrNewScaleIO() {
    return this.withNewScaleIOLike(Optional.ofNullable(this.buildScaleIO()).orElse(new ScaleIOVolumeSourceBuilder().build()));
  }
  
  public ScaleIONested<A> editOrNewScaleIOLike(ScaleIOVolumeSource item) {
    return this.withNewScaleIOLike(Optional.ofNullable(this.buildScaleIO()).orElse(item));
  }
  
  public SecretNested<A> editOrNewSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(new SecretVolumeSourceBuilder().build()));
  }
  
  public SecretNested<A> editOrNewSecretLike(SecretVolumeSource item) {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(item));
  }
  
  public StorageosNested<A> editOrNewStorageos() {
    return this.withNewStorageosLike(Optional.ofNullable(this.buildStorageos()).orElse(new StorageOSVolumeSourceBuilder().build()));
  }
  
  public StorageosNested<A> editOrNewStorageosLike(StorageOSVolumeSource item) {
    return this.withNewStorageosLike(Optional.ofNullable(this.buildStorageos()).orElse(item));
  }
  
  public VsphereVolumeNested<A> editOrNewVsphereVolume() {
    return this.withNewVsphereVolumeLike(Optional.ofNullable(this.buildVsphereVolume()).orElse(new VsphereVirtualDiskVolumeSourceBuilder().build()));
  }
  
  public VsphereVolumeNested<A> editOrNewVsphereVolumeLike(VsphereVirtualDiskVolumeSource item) {
    return this.withNewVsphereVolumeLike(Optional.ofNullable(this.buildVsphereVolume()).orElse(item));
  }
  
  public PersistentVolumeClaimNested<A> editPersistentVolumeClaim() {
    return this.withNewPersistentVolumeClaimLike(Optional.ofNullable(this.buildPersistentVolumeClaim()).orElse(null));
  }
  
  public PhotonPersistentDiskNested<A> editPhotonPersistentDisk() {
    return this.withNewPhotonPersistentDiskLike(Optional.ofNullable(this.buildPhotonPersistentDisk()).orElse(null));
  }
  
  public PortworxVolumeNested<A> editPortworxVolume() {
    return this.withNewPortworxVolumeLike(Optional.ofNullable(this.buildPortworxVolume()).orElse(null));
  }
  
  public ProjectedNested<A> editProjected() {
    return this.withNewProjectedLike(Optional.ofNullable(this.buildProjected()).orElse(null));
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
  
  public SecretNested<A> editSecret() {
    return this.withNewSecretLike(Optional.ofNullable(this.buildSecret()).orElse(null));
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
    VolumeFluent that = (VolumeFluent) o;
    if (!(Objects.equals(awsElasticBlockStore, that.awsElasticBlockStore))) {
      return false;
    }
    if (!(Objects.equals(azureDisk, that.azureDisk))) {
      return false;
    }
    if (!(Objects.equals(azureFile, that.azureFile))) {
      return false;
    }
    if (!(Objects.equals(cephfs, that.cephfs))) {
      return false;
    }
    if (!(Objects.equals(cinder, that.cinder))) {
      return false;
    }
    if (!(Objects.equals(configMap, that.configMap))) {
      return false;
    }
    if (!(Objects.equals(csi, that.csi))) {
      return false;
    }
    if (!(Objects.equals(downwardAPI, that.downwardAPI))) {
      return false;
    }
    if (!(Objects.equals(emptyDir, that.emptyDir))) {
      return false;
    }
    if (!(Objects.equals(ephemeral, that.ephemeral))) {
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
    if (!(Objects.equals(gitRepo, that.gitRepo))) {
      return false;
    }
    if (!(Objects.equals(glusterfs, that.glusterfs))) {
      return false;
    }
    if (!(Objects.equals(hostPath, that.hostPath))) {
      return false;
    }
    if (!(Objects.equals(image, that.image))) {
      return false;
    }
    if (!(Objects.equals(iscsi, that.iscsi))) {
      return false;
    }
    if (!(Objects.equals(name, that.name))) {
      return false;
    }
    if (!(Objects.equals(nfs, that.nfs))) {
      return false;
    }
    if (!(Objects.equals(persistentVolumeClaim, that.persistentVolumeClaim))) {
      return false;
    }
    if (!(Objects.equals(photonPersistentDisk, that.photonPersistentDisk))) {
      return false;
    }
    if (!(Objects.equals(portworxVolume, that.portworxVolume))) {
      return false;
    }
    if (!(Objects.equals(projected, that.projected))) {
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
    if (!(Objects.equals(secret, that.secret))) {
      return false;
    }
    if (!(Objects.equals(storageos, that.storageos))) {
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
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getName() {
    return this.name;
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
  
  public boolean hasCephfs() {
    return this.cephfs != null;
  }
  
  public boolean hasCinder() {
    return this.cinder != null;
  }
  
  public boolean hasConfigMap() {
    return this.configMap != null;
  }
  
  public boolean hasCsi() {
    return this.csi != null;
  }
  
  public boolean hasDownwardAPI() {
    return this.downwardAPI != null;
  }
  
  public boolean hasEmptyDir() {
    return this.emptyDir != null;
  }
  
  public boolean hasEphemeral() {
    return this.ephemeral != null;
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
  
  public boolean hasGitRepo() {
    return this.gitRepo != null;
  }
  
  public boolean hasGlusterfs() {
    return this.glusterfs != null;
  }
  
  public boolean hasHostPath() {
    return this.hostPath != null;
  }
  
  public boolean hasImage() {
    return this.image != null;
  }
  
  public boolean hasIscsi() {
    return this.iscsi != null;
  }
  
  public boolean hasName() {
    return this.name != null;
  }
  
  public boolean hasNfs() {
    return this.nfs != null;
  }
  
  public boolean hasPersistentVolumeClaim() {
    return this.persistentVolumeClaim != null;
  }
  
  public boolean hasPhotonPersistentDisk() {
    return this.photonPersistentDisk != null;
  }
  
  public boolean hasPortworxVolume() {
    return this.portworxVolume != null;
  }
  
  public boolean hasProjected() {
    return this.projected != null;
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
  
  public boolean hasSecret() {
    return this.secret != null;
  }
  
  public boolean hasStorageos() {
    return this.storageos != null;
  }
  
  public boolean hasVsphereVolume() {
    return this.vsphereVolume != null;
  }
  
  public int hashCode() {
    return Objects.hash(awsElasticBlockStore, azureDisk, azureFile, cephfs, cinder, configMap, csi, downwardAPI, emptyDir, ephemeral, fc, flexVolume, flocker, gcePersistentDisk, gitRepo, glusterfs, hostPath, image, iscsi, name, nfs, persistentVolumeClaim, photonPersistentDisk, portworxVolume, projected, quobyte, rbd, scaleIO, secret, storageos, vsphereVolume, additionalProperties);
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
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
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
    if (!(configMap == null)) {
        sb.append("configMap:");
        sb.append(configMap);
        sb.append(",");
    }
    if (!(csi == null)) {
        sb.append("csi:");
        sb.append(csi);
        sb.append(",");
    }
    if (!(downwardAPI == null)) {
        sb.append("downwardAPI:");
        sb.append(downwardAPI);
        sb.append(",");
    }
    if (!(emptyDir == null)) {
        sb.append("emptyDir:");
        sb.append(emptyDir);
        sb.append(",");
    }
    if (!(ephemeral == null)) {
        sb.append("ephemeral:");
        sb.append(ephemeral);
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
    if (!(gitRepo == null)) {
        sb.append("gitRepo:");
        sb.append(gitRepo);
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
    if (!(image == null)) {
        sb.append("image:");
        sb.append(image);
        sb.append(",");
    }
    if (!(iscsi == null)) {
        sb.append("iscsi:");
        sb.append(iscsi);
        sb.append(",");
    }
    if (!(name == null)) {
        sb.append("name:");
        sb.append(name);
        sb.append(",");
    }
    if (!(nfs == null)) {
        sb.append("nfs:");
        sb.append(nfs);
        sb.append(",");
    }
    if (!(persistentVolumeClaim == null)) {
        sb.append("persistentVolumeClaim:");
        sb.append(persistentVolumeClaim);
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
    if (!(projected == null)) {
        sb.append("projected:");
        sb.append(projected);
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
    if (!(secret == null)) {
        sb.append("secret:");
        sb.append(secret);
        sb.append(",");
    }
    if (!(storageos == null)) {
        sb.append("storageos:");
        sb.append(storageos);
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
  
  public A withAzureFile(AzureFileVolumeSource azureFile) {
    this._visitables.remove("azureFile");
    if (azureFile != null) {
        this.azureFile = new AzureFileVolumeSourceBuilder(azureFile);
        this._visitables.get("azureFile").add(this.azureFile);
    } else {
        this.azureFile = null;
        this._visitables.get("azureFile").remove(this.azureFile);
    }
    return (A) this;
  }
  
  public A withCephfs(CephFSVolumeSource cephfs) {
    this._visitables.remove("cephfs");
    if (cephfs != null) {
        this.cephfs = new CephFSVolumeSourceBuilder(cephfs);
        this._visitables.get("cephfs").add(this.cephfs);
    } else {
        this.cephfs = null;
        this._visitables.get("cephfs").remove(this.cephfs);
    }
    return (A) this;
  }
  
  public A withCinder(CinderVolumeSource cinder) {
    this._visitables.remove("cinder");
    if (cinder != null) {
        this.cinder = new CinderVolumeSourceBuilder(cinder);
        this._visitables.get("cinder").add(this.cinder);
    } else {
        this.cinder = null;
        this._visitables.get("cinder").remove(this.cinder);
    }
    return (A) this;
  }
  
  public A withConfigMap(ConfigMapVolumeSource configMap) {
    this._visitables.remove("configMap");
    if (configMap != null) {
        this.configMap = new ConfigMapVolumeSourceBuilder(configMap);
        this._visitables.get("configMap").add(this.configMap);
    } else {
        this.configMap = null;
        this._visitables.get("configMap").remove(this.configMap);
    }
    return (A) this;
  }
  
  public A withCsi(CSIVolumeSource csi) {
    this._visitables.remove("csi");
    if (csi != null) {
        this.csi = new CSIVolumeSourceBuilder(csi);
        this._visitables.get("csi").add(this.csi);
    } else {
        this.csi = null;
        this._visitables.get("csi").remove(this.csi);
    }
    return (A) this;
  }
  
  public A withDownwardAPI(DownwardAPIVolumeSource downwardAPI) {
    this._visitables.remove("downwardAPI");
    if (downwardAPI != null) {
        this.downwardAPI = new DownwardAPIVolumeSourceBuilder(downwardAPI);
        this._visitables.get("downwardAPI").add(this.downwardAPI);
    } else {
        this.downwardAPI = null;
        this._visitables.get("downwardAPI").remove(this.downwardAPI);
    }
    return (A) this;
  }
  
  public A withEmptyDir(EmptyDirVolumeSource emptyDir) {
    this._visitables.remove("emptyDir");
    if (emptyDir != null) {
        this.emptyDir = new EmptyDirVolumeSourceBuilder(emptyDir);
        this._visitables.get("emptyDir").add(this.emptyDir);
    } else {
        this.emptyDir = null;
        this._visitables.get("emptyDir").remove(this.emptyDir);
    }
    return (A) this;
  }
  
  public A withEphemeral(EphemeralVolumeSource ephemeral) {
    this._visitables.remove("ephemeral");
    if (ephemeral != null) {
        this.ephemeral = new EphemeralVolumeSourceBuilder(ephemeral);
        this._visitables.get("ephemeral").add(this.ephemeral);
    } else {
        this.ephemeral = null;
        this._visitables.get("ephemeral").remove(this.ephemeral);
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
  
  public A withFlexVolume(FlexVolumeSource flexVolume) {
    this._visitables.remove("flexVolume");
    if (flexVolume != null) {
        this.flexVolume = new FlexVolumeSourceBuilder(flexVolume);
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
  
  public A withGitRepo(GitRepoVolumeSource gitRepo) {
    this._visitables.remove("gitRepo");
    if (gitRepo != null) {
        this.gitRepo = new GitRepoVolumeSourceBuilder(gitRepo);
        this._visitables.get("gitRepo").add(this.gitRepo);
    } else {
        this.gitRepo = null;
        this._visitables.get("gitRepo").remove(this.gitRepo);
    }
    return (A) this;
  }
  
  public A withGlusterfs(GlusterfsVolumeSource glusterfs) {
    this._visitables.remove("glusterfs");
    if (glusterfs != null) {
        this.glusterfs = new GlusterfsVolumeSourceBuilder(glusterfs);
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
  
  public A withImage(ImageVolumeSource image) {
    this._visitables.remove("image");
    if (image != null) {
        this.image = new ImageVolumeSourceBuilder(image);
        this._visitables.get("image").add(this.image);
    } else {
        this.image = null;
        this._visitables.get("image").remove(this.image);
    }
    return (A) this;
  }
  
  public A withIscsi(ISCSIVolumeSource iscsi) {
    this._visitables.remove("iscsi");
    if (iscsi != null) {
        this.iscsi = new ISCSIVolumeSourceBuilder(iscsi);
        this._visitables.get("iscsi").add(this.iscsi);
    } else {
        this.iscsi = null;
        this._visitables.get("iscsi").remove(this.iscsi);
    }
    return (A) this;
  }
  
  public A withName(String name) {
    this.name = name;
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
  
  public A withNewAzureFile(Boolean readOnly,String secretName,String shareName) {
    return (A) this.withAzureFile(new AzureFileVolumeSource(readOnly, secretName, shareName));
  }
  
  public AzureFileNested<A> withNewAzureFileLike(AzureFileVolumeSource item) {
    return new AzureFileNested(item);
  }
  
  public CephfsNested<A> withNewCephfs() {
    return new CephfsNested(null);
  }
  
  public CephfsNested<A> withNewCephfsLike(CephFSVolumeSource item) {
    return new CephfsNested(item);
  }
  
  public CinderNested<A> withNewCinder() {
    return new CinderNested(null);
  }
  
  public CinderNested<A> withNewCinderLike(CinderVolumeSource item) {
    return new CinderNested(item);
  }
  
  public ConfigMapNested<A> withNewConfigMap() {
    return new ConfigMapNested(null);
  }
  
  public ConfigMapNested<A> withNewConfigMapLike(ConfigMapVolumeSource item) {
    return new ConfigMapNested(item);
  }
  
  public CsiNested<A> withNewCsi() {
    return new CsiNested(null);
  }
  
  public CsiNested<A> withNewCsiLike(CSIVolumeSource item) {
    return new CsiNested(item);
  }
  
  public DownwardAPINested<A> withNewDownwardAPI() {
    return new DownwardAPINested(null);
  }
  
  public DownwardAPINested<A> withNewDownwardAPILike(DownwardAPIVolumeSource item) {
    return new DownwardAPINested(item);
  }
  
  public EmptyDirNested<A> withNewEmptyDir() {
    return new EmptyDirNested(null);
  }
  
  public EmptyDirNested<A> withNewEmptyDirLike(EmptyDirVolumeSource item) {
    return new EmptyDirNested(item);
  }
  
  public EphemeralNested<A> withNewEphemeral() {
    return new EphemeralNested(null);
  }
  
  public EphemeralNested<A> withNewEphemeralLike(EphemeralVolumeSource item) {
    return new EphemeralNested(item);
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
  
  public FlexVolumeNested<A> withNewFlexVolumeLike(FlexVolumeSource item) {
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
  
  public GitRepoNested<A> withNewGitRepo() {
    return new GitRepoNested(null);
  }
  
  public A withNewGitRepo(String directory,String repository,String revision) {
    return (A) this.withGitRepo(new GitRepoVolumeSource(directory, repository, revision));
  }
  
  public GitRepoNested<A> withNewGitRepoLike(GitRepoVolumeSource item) {
    return new GitRepoNested(item);
  }
  
  public GlusterfsNested<A> withNewGlusterfs() {
    return new GlusterfsNested(null);
  }
  
  public A withNewGlusterfs(String endpoints,String path,Boolean readOnly) {
    return (A) this.withGlusterfs(new GlusterfsVolumeSource(endpoints, path, readOnly));
  }
  
  public GlusterfsNested<A> withNewGlusterfsLike(GlusterfsVolumeSource item) {
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
  
  public ImageNested<A> withNewImage() {
    return new ImageNested(null);
  }
  
  public A withNewImage(String pullPolicy,String reference) {
    return (A) this.withImage(new ImageVolumeSource(pullPolicy, reference));
  }
  
  public ImageNested<A> withNewImageLike(ImageVolumeSource item) {
    return new ImageNested(item);
  }
  
  public IscsiNested<A> withNewIscsi() {
    return new IscsiNested(null);
  }
  
  public IscsiNested<A> withNewIscsiLike(ISCSIVolumeSource item) {
    return new IscsiNested(item);
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
  
  public PersistentVolumeClaimNested<A> withNewPersistentVolumeClaim() {
    return new PersistentVolumeClaimNested(null);
  }
  
  public A withNewPersistentVolumeClaim(String claimName,Boolean readOnly) {
    return (A) this.withPersistentVolumeClaim(new PersistentVolumeClaimVolumeSource(claimName, readOnly));
  }
  
  public PersistentVolumeClaimNested<A> withNewPersistentVolumeClaimLike(PersistentVolumeClaimVolumeSource item) {
    return new PersistentVolumeClaimNested(item);
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
  
  public ProjectedNested<A> withNewProjected() {
    return new ProjectedNested(null);
  }
  
  public ProjectedNested<A> withNewProjectedLike(ProjectedVolumeSource item) {
    return new ProjectedNested(item);
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
  
  public RbdNested<A> withNewRbdLike(RBDVolumeSource item) {
    return new RbdNested(item);
  }
  
  public ScaleIONested<A> withNewScaleIO() {
    return new ScaleIONested(null);
  }
  
  public ScaleIONested<A> withNewScaleIOLike(ScaleIOVolumeSource item) {
    return new ScaleIONested(item);
  }
  
  public SecretNested<A> withNewSecret() {
    return new SecretNested(null);
  }
  
  public SecretNested<A> withNewSecretLike(SecretVolumeSource item) {
    return new SecretNested(item);
  }
  
  public StorageosNested<A> withNewStorageos() {
    return new StorageosNested(null);
  }
  
  public StorageosNested<A> withNewStorageosLike(StorageOSVolumeSource item) {
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
  
  public A withPersistentVolumeClaim(PersistentVolumeClaimVolumeSource persistentVolumeClaim) {
    this._visitables.remove("persistentVolumeClaim");
    if (persistentVolumeClaim != null) {
        this.persistentVolumeClaim = new PersistentVolumeClaimVolumeSourceBuilder(persistentVolumeClaim);
        this._visitables.get("persistentVolumeClaim").add(this.persistentVolumeClaim);
    } else {
        this.persistentVolumeClaim = null;
        this._visitables.get("persistentVolumeClaim").remove(this.persistentVolumeClaim);
    }
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
  
  public A withProjected(ProjectedVolumeSource projected) {
    this._visitables.remove("projected");
    if (projected != null) {
        this.projected = new ProjectedVolumeSourceBuilder(projected);
        this._visitables.get("projected").add(this.projected);
    } else {
        this.projected = null;
        this._visitables.get("projected").remove(this.projected);
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
  
  public A withRbd(RBDVolumeSource rbd) {
    this._visitables.remove("rbd");
    if (rbd != null) {
        this.rbd = new RBDVolumeSourceBuilder(rbd);
        this._visitables.get("rbd").add(this.rbd);
    } else {
        this.rbd = null;
        this._visitables.get("rbd").remove(this.rbd);
    }
    return (A) this;
  }
  
  public A withScaleIO(ScaleIOVolumeSource scaleIO) {
    this._visitables.remove("scaleIO");
    if (scaleIO != null) {
        this.scaleIO = new ScaleIOVolumeSourceBuilder(scaleIO);
        this._visitables.get("scaleIO").add(this.scaleIO);
    } else {
        this.scaleIO = null;
        this._visitables.get("scaleIO").remove(this.scaleIO);
    }
    return (A) this;
  }
  
  public A withSecret(SecretVolumeSource secret) {
    this._visitables.remove("secret");
    if (secret != null) {
        this.secret = new SecretVolumeSourceBuilder(secret);
        this._visitables.get("secret").add(this.secret);
    } else {
        this.secret = null;
        this._visitables.get("secret").remove(this.secret);
    }
    return (A) this;
  }
  
  public A withStorageos(StorageOSVolumeSource storageos) {
    this._visitables.remove("storageos");
    if (storageos != null) {
        this.storageos = new StorageOSVolumeSourceBuilder(storageos);
        this._visitables.get("storageos").add(this.storageos);
    } else {
        this.storageos = null;
        this._visitables.get("storageos").remove(this.storageos);
    }
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
      return (N) VolumeFluent.this.withAwsElasticBlockStore(builder.build());
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
      return (N) VolumeFluent.this.withAzureDisk(builder.build());
    }
    
    public N endAzureDisk() {
      return and();
    }
    
  }
  public class AzureFileNested<N> extends AzureFileVolumeSourceFluent<AzureFileNested<N>> implements Nested<N>{
  
    AzureFileVolumeSourceBuilder builder;
  
    AzureFileNested(AzureFileVolumeSource item) {
      this.builder = new AzureFileVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withAzureFile(builder.build());
    }
    
    public N endAzureFile() {
      return and();
    }
    
  }
  public class CephfsNested<N> extends CephFSVolumeSourceFluent<CephfsNested<N>> implements Nested<N>{
  
    CephFSVolumeSourceBuilder builder;
  
    CephfsNested(CephFSVolumeSource item) {
      this.builder = new CephFSVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withCephfs(builder.build());
    }
    
    public N endCephfs() {
      return and();
    }
    
  }
  public class CinderNested<N> extends CinderVolumeSourceFluent<CinderNested<N>> implements Nested<N>{
  
    CinderVolumeSourceBuilder builder;
  
    CinderNested(CinderVolumeSource item) {
      this.builder = new CinderVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withCinder(builder.build());
    }
    
    public N endCinder() {
      return and();
    }
    
  }
  public class ConfigMapNested<N> extends ConfigMapVolumeSourceFluent<ConfigMapNested<N>> implements Nested<N>{
  
    ConfigMapVolumeSourceBuilder builder;
  
    ConfigMapNested(ConfigMapVolumeSource item) {
      this.builder = new ConfigMapVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withConfigMap(builder.build());
    }
    
    public N endConfigMap() {
      return and();
    }
    
  }
  public class CsiNested<N> extends CSIVolumeSourceFluent<CsiNested<N>> implements Nested<N>{
  
    CSIVolumeSourceBuilder builder;
  
    CsiNested(CSIVolumeSource item) {
      this.builder = new CSIVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withCsi(builder.build());
    }
    
    public N endCsi() {
      return and();
    }
    
  }
  public class DownwardAPINested<N> extends DownwardAPIVolumeSourceFluent<DownwardAPINested<N>> implements Nested<N>{
  
    DownwardAPIVolumeSourceBuilder builder;
  
    DownwardAPINested(DownwardAPIVolumeSource item) {
      this.builder = new DownwardAPIVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withDownwardAPI(builder.build());
    }
    
    public N endDownwardAPI() {
      return and();
    }
    
  }
  public class EmptyDirNested<N> extends EmptyDirVolumeSourceFluent<EmptyDirNested<N>> implements Nested<N>{
  
    EmptyDirVolumeSourceBuilder builder;
  
    EmptyDirNested(EmptyDirVolumeSource item) {
      this.builder = new EmptyDirVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withEmptyDir(builder.build());
    }
    
    public N endEmptyDir() {
      return and();
    }
    
  }
  public class EphemeralNested<N> extends EphemeralVolumeSourceFluent<EphemeralNested<N>> implements Nested<N>{
  
    EphemeralVolumeSourceBuilder builder;
  
    EphemeralNested(EphemeralVolumeSource item) {
      this.builder = new EphemeralVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withEphemeral(builder.build());
    }
    
    public N endEphemeral() {
      return and();
    }
    
  }
  public class FcNested<N> extends FCVolumeSourceFluent<FcNested<N>> implements Nested<N>{
  
    FCVolumeSourceBuilder builder;
  
    FcNested(FCVolumeSource item) {
      this.builder = new FCVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withFc(builder.build());
    }
    
    public N endFc() {
      return and();
    }
    
  }
  public class FlexVolumeNested<N> extends FlexVolumeSourceFluent<FlexVolumeNested<N>> implements Nested<N>{
  
    FlexVolumeSourceBuilder builder;
  
    FlexVolumeNested(FlexVolumeSource item) {
      this.builder = new FlexVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withFlexVolume(builder.build());
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
      return (N) VolumeFluent.this.withFlocker(builder.build());
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
      return (N) VolumeFluent.this.withGcePersistentDisk(builder.build());
    }
    
    public N endGcePersistentDisk() {
      return and();
    }
    
  }
  public class GitRepoNested<N> extends GitRepoVolumeSourceFluent<GitRepoNested<N>> implements Nested<N>{
  
    GitRepoVolumeSourceBuilder builder;
  
    GitRepoNested(GitRepoVolumeSource item) {
      this.builder = new GitRepoVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withGitRepo(builder.build());
    }
    
    public N endGitRepo() {
      return and();
    }
    
  }
  public class GlusterfsNested<N> extends GlusterfsVolumeSourceFluent<GlusterfsNested<N>> implements Nested<N>{
  
    GlusterfsVolumeSourceBuilder builder;
  
    GlusterfsNested(GlusterfsVolumeSource item) {
      this.builder = new GlusterfsVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withGlusterfs(builder.build());
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
      return (N) VolumeFluent.this.withHostPath(builder.build());
    }
    
    public N endHostPath() {
      return and();
    }
    
  }
  public class ImageNested<N> extends ImageVolumeSourceFluent<ImageNested<N>> implements Nested<N>{
  
    ImageVolumeSourceBuilder builder;
  
    ImageNested(ImageVolumeSource item) {
      this.builder = new ImageVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withImage(builder.build());
    }
    
    public N endImage() {
      return and();
    }
    
  }
  public class IscsiNested<N> extends ISCSIVolumeSourceFluent<IscsiNested<N>> implements Nested<N>{
  
    ISCSIVolumeSourceBuilder builder;
  
    IscsiNested(ISCSIVolumeSource item) {
      this.builder = new ISCSIVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withIscsi(builder.build());
    }
    
    public N endIscsi() {
      return and();
    }
    
  }
  public class NfsNested<N> extends NFSVolumeSourceFluent<NfsNested<N>> implements Nested<N>{
  
    NFSVolumeSourceBuilder builder;
  
    NfsNested(NFSVolumeSource item) {
      this.builder = new NFSVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withNfs(builder.build());
    }
    
    public N endNfs() {
      return and();
    }
    
  }
  public class PersistentVolumeClaimNested<N> extends PersistentVolumeClaimVolumeSourceFluent<PersistentVolumeClaimNested<N>> implements Nested<N>{
  
    PersistentVolumeClaimVolumeSourceBuilder builder;
  
    PersistentVolumeClaimNested(PersistentVolumeClaimVolumeSource item) {
      this.builder = new PersistentVolumeClaimVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withPersistentVolumeClaim(builder.build());
    }
    
    public N endPersistentVolumeClaim() {
      return and();
    }
    
  }
  public class PhotonPersistentDiskNested<N> extends PhotonPersistentDiskVolumeSourceFluent<PhotonPersistentDiskNested<N>> implements Nested<N>{
  
    PhotonPersistentDiskVolumeSourceBuilder builder;
  
    PhotonPersistentDiskNested(PhotonPersistentDiskVolumeSource item) {
      this.builder = new PhotonPersistentDiskVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withPhotonPersistentDisk(builder.build());
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
      return (N) VolumeFluent.this.withPortworxVolume(builder.build());
    }
    
    public N endPortworxVolume() {
      return and();
    }
    
  }
  public class ProjectedNested<N> extends ProjectedVolumeSourceFluent<ProjectedNested<N>> implements Nested<N>{
  
    ProjectedVolumeSourceBuilder builder;
  
    ProjectedNested(ProjectedVolumeSource item) {
      this.builder = new ProjectedVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withProjected(builder.build());
    }
    
    public N endProjected() {
      return and();
    }
    
  }
  public class QuobyteNested<N> extends QuobyteVolumeSourceFluent<QuobyteNested<N>> implements Nested<N>{
  
    QuobyteVolumeSourceBuilder builder;
  
    QuobyteNested(QuobyteVolumeSource item) {
      this.builder = new QuobyteVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withQuobyte(builder.build());
    }
    
    public N endQuobyte() {
      return and();
    }
    
  }
  public class RbdNested<N> extends RBDVolumeSourceFluent<RbdNested<N>> implements Nested<N>{
  
    RBDVolumeSourceBuilder builder;
  
    RbdNested(RBDVolumeSource item) {
      this.builder = new RBDVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withRbd(builder.build());
    }
    
    public N endRbd() {
      return and();
    }
    
  }
  public class ScaleIONested<N> extends ScaleIOVolumeSourceFluent<ScaleIONested<N>> implements Nested<N>{
  
    ScaleIOVolumeSourceBuilder builder;
  
    ScaleIONested(ScaleIOVolumeSource item) {
      this.builder = new ScaleIOVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withScaleIO(builder.build());
    }
    
    public N endScaleIO() {
      return and();
    }
    
  }
  public class SecretNested<N> extends SecretVolumeSourceFluent<SecretNested<N>> implements Nested<N>{
  
    SecretVolumeSourceBuilder builder;
  
    SecretNested(SecretVolumeSource item) {
      this.builder = new SecretVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withSecret(builder.build());
    }
    
    public N endSecret() {
      return and();
    }
    
  }
  public class StorageosNested<N> extends StorageOSVolumeSourceFluent<StorageosNested<N>> implements Nested<N>{
  
    StorageOSVolumeSourceBuilder builder;
  
    StorageosNested(StorageOSVolumeSource item) {
      this.builder = new StorageOSVolumeSourceBuilder(this, item);
    }
  
    public N and() {
      return (N) VolumeFluent.this.withStorageos(builder.build());
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
      return (N) VolumeFluent.this.withVsphereVolume(builder.build());
    }
    
    public N endVsphereVolume() {
      return and();
    }
    
  }
}