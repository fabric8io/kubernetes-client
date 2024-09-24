
package io.fabric8.openshift.api.model.monitoring.v1;

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
import io.fabric8.kubernetes.api.model.Container;
import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import io.fabric8.kubernetes.api.model.LabelSelector;
import io.fabric8.kubernetes.api.model.LocalObjectReference;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.api.model.ObjectReference;
import io.fabric8.kubernetes.api.model.PersistentVolumeClaim;
import io.fabric8.kubernetes.api.model.PodTemplateSpec;
import io.fabric8.kubernetes.api.model.ResourceRequirements;
import io.sundr.builder.annotations.Buildable;
import io.sundr.builder.annotations.BuildableReference;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

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
@Buildable(editableEnabled = false, validationEnabled = false, generateBuilderPackage = false, lazyCollectionInitEnabled = false, builderPackage = "io.fabric8.kubernetes.api.builder", refs = {
    @BuildableReference(ObjectMeta.class),
    @BuildableReference(LabelSelector.class),
    @BuildableReference(Container.class),
    @BuildableReference(PodTemplateSpec.class),
    @BuildableReference(ResourceRequirements.class),
    @BuildableReference(IntOrString.class),
    @BuildableReference(ObjectReference.class),
    @BuildableReference(LocalObjectReference.class),
    @BuildableReference(PersistentVolumeClaim.class)
})
@Generated("jsonschema2pojo")
public class ThanosRulerSpecVolumes implements Editable<ThanosRulerSpecVolumesBuilder> , KubernetesResource
{

    @JsonProperty("awsElasticBlockStore")
    private ThanosRulerSpecVAwsElasticBlockStore awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private ThanosRulerSpecVAzureDisk azureDisk;
    @JsonProperty("azureFile")
    private ThanosRulerSpecVAzureFile azureFile;
    @JsonProperty("cephfs")
    private ThanosRulerSpecVCephfs cephfs;
    @JsonProperty("cinder")
    private ThanosRulerSpecVCinder cinder;
    @JsonProperty("configMap")
    private ThanosRulerSpecVConfigMap configMap;
    @JsonProperty("csi")
    private ThanosRulerSpecVCsi csi;
    @JsonProperty("downwardAPI")
    private ThanosRulerSpecVDownwardAPI downwardAPI;
    @JsonProperty("emptyDir")
    private ThanosRulerSpecVEmptyDir emptyDir;
    @JsonProperty("ephemeral")
    private ThanosRulerSpecVEphemeral ephemeral;
    @JsonProperty("fc")
    private ThanosRulerSpecVFc fc;
    @JsonProperty("flexVolume")
    private ThanosRulerSpecVFlexVolume flexVolume;
    @JsonProperty("flocker")
    private ThanosRulerSpecVFlocker flocker;
    @JsonProperty("gcePersistentDisk")
    private ThanosRulerSpecVGcePersistentDisk gcePersistentDisk;
    @JsonProperty("gitRepo")
    private ThanosRulerSpecVGitRepo gitRepo;
    @JsonProperty("glusterfs")
    private ThanosRulerSpecVGlusterfs glusterfs;
    @JsonProperty("hostPath")
    private ThanosRulerSpecVHostPath hostPath;
    @JsonProperty("iscsi")
    private ThanosRulerSpecVIscsi iscsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nfs")
    private ThanosRulerSpecVNfs nfs;
    @JsonProperty("persistentVolumeClaim")
    private ThanosRulerSpecVPersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("photonPersistentDisk")
    private ThanosRulerSpecVPhotonPersistentDisk photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private ThanosRulerSpecVPortworxVolume portworxVolume;
    @JsonProperty("projected")
    private ThanosRulerSpecVProjected projected;
    @JsonProperty("quobyte")
    private ThanosRulerSpecVQuobyte quobyte;
    @JsonProperty("rbd")
    private ThanosRulerSpecVRbd rbd;
    @JsonProperty("scaleIO")
    private ThanosRulerSpecVScaleIO scaleIO;
    @JsonProperty("secret")
    private ThanosRulerSpecVSecret secret;
    @JsonProperty("storageos")
    private ThanosRulerSpecVStorageos storageos;
    @JsonProperty("vsphereVolume")
    private ThanosRulerSpecVVsphereVolume vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ThanosRulerSpecVolumes() {
    }

    public ThanosRulerSpecVolumes(ThanosRulerSpecVAwsElasticBlockStore awsElasticBlockStore, ThanosRulerSpecVAzureDisk azureDisk, ThanosRulerSpecVAzureFile azureFile, ThanosRulerSpecVCephfs cephfs, ThanosRulerSpecVCinder cinder, ThanosRulerSpecVConfigMap configMap, ThanosRulerSpecVCsi csi, ThanosRulerSpecVDownwardAPI downwardAPI, ThanosRulerSpecVEmptyDir emptyDir, ThanosRulerSpecVEphemeral ephemeral, ThanosRulerSpecVFc fc, ThanosRulerSpecVFlexVolume flexVolume, ThanosRulerSpecVFlocker flocker, ThanosRulerSpecVGcePersistentDisk gcePersistentDisk, ThanosRulerSpecVGitRepo gitRepo, ThanosRulerSpecVGlusterfs glusterfs, ThanosRulerSpecVHostPath hostPath, ThanosRulerSpecVIscsi iscsi, String name, ThanosRulerSpecVNfs nfs, ThanosRulerSpecVPersistentVolumeClaim persistentVolumeClaim, ThanosRulerSpecVPhotonPersistentDisk photonPersistentDisk, ThanosRulerSpecVPortworxVolume portworxVolume, ThanosRulerSpecVProjected projected, ThanosRulerSpecVQuobyte quobyte, ThanosRulerSpecVRbd rbd, ThanosRulerSpecVScaleIO scaleIO, ThanosRulerSpecVSecret secret, ThanosRulerSpecVStorageos storageos, ThanosRulerSpecVVsphereVolume vsphereVolume) {
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
    public ThanosRulerSpecVAwsElasticBlockStore getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(ThanosRulerSpecVAwsElasticBlockStore awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    @JsonProperty("azureDisk")
    public ThanosRulerSpecVAzureDisk getAzureDisk() {
        return azureDisk;
    }

    @JsonProperty("azureDisk")
    public void setAzureDisk(ThanosRulerSpecVAzureDisk azureDisk) {
        this.azureDisk = azureDisk;
    }

    @JsonProperty("azureFile")
    public ThanosRulerSpecVAzureFile getAzureFile() {
        return azureFile;
    }

    @JsonProperty("azureFile")
    public void setAzureFile(ThanosRulerSpecVAzureFile azureFile) {
        this.azureFile = azureFile;
    }

    @JsonProperty("cephfs")
    public ThanosRulerSpecVCephfs getCephfs() {
        return cephfs;
    }

    @JsonProperty("cephfs")
    public void setCephfs(ThanosRulerSpecVCephfs cephfs) {
        this.cephfs = cephfs;
    }

    @JsonProperty("cinder")
    public ThanosRulerSpecVCinder getCinder() {
        return cinder;
    }

    @JsonProperty("cinder")
    public void setCinder(ThanosRulerSpecVCinder cinder) {
        this.cinder = cinder;
    }

    @JsonProperty("configMap")
    public ThanosRulerSpecVConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ThanosRulerSpecVConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public ThanosRulerSpecVCsi getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(ThanosRulerSpecVCsi csi) {
        this.csi = csi;
    }

    @JsonProperty("downwardAPI")
    public ThanosRulerSpecVDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(ThanosRulerSpecVDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("emptyDir")
    public ThanosRulerSpecVEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(ThanosRulerSpecVEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public ThanosRulerSpecVEphemeral getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(ThanosRulerSpecVEphemeral ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("fc")
    public ThanosRulerSpecVFc getFc() {
        return fc;
    }

    @JsonProperty("fc")
    public void setFc(ThanosRulerSpecVFc fc) {
        this.fc = fc;
    }

    @JsonProperty("flexVolume")
    public ThanosRulerSpecVFlexVolume getFlexVolume() {
        return flexVolume;
    }

    @JsonProperty("flexVolume")
    public void setFlexVolume(ThanosRulerSpecVFlexVolume flexVolume) {
        this.flexVolume = flexVolume;
    }

    @JsonProperty("flocker")
    public ThanosRulerSpecVFlocker getFlocker() {
        return flocker;
    }

    @JsonProperty("flocker")
    public void setFlocker(ThanosRulerSpecVFlocker flocker) {
        this.flocker = flocker;
    }

    @JsonProperty("gcePersistentDisk")
    public ThanosRulerSpecVGcePersistentDisk getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(ThanosRulerSpecVGcePersistentDisk gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    @JsonProperty("gitRepo")
    public ThanosRulerSpecVGitRepo getGitRepo() {
        return gitRepo;
    }

    @JsonProperty("gitRepo")
    public void setGitRepo(ThanosRulerSpecVGitRepo gitRepo) {
        this.gitRepo = gitRepo;
    }

    @JsonProperty("glusterfs")
    public ThanosRulerSpecVGlusterfs getGlusterfs() {
        return glusterfs;
    }

    @JsonProperty("glusterfs")
    public void setGlusterfs(ThanosRulerSpecVGlusterfs glusterfs) {
        this.glusterfs = glusterfs;
    }

    @JsonProperty("hostPath")
    public ThanosRulerSpecVHostPath getHostPath() {
        return hostPath;
    }

    @JsonProperty("hostPath")
    public void setHostPath(ThanosRulerSpecVHostPath hostPath) {
        this.hostPath = hostPath;
    }

    @JsonProperty("iscsi")
    public ThanosRulerSpecVIscsi getIscsi() {
        return iscsi;
    }

    @JsonProperty("iscsi")
    public void setIscsi(ThanosRulerSpecVIscsi iscsi) {
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
    public ThanosRulerSpecVNfs getNfs() {
        return nfs;
    }

    @JsonProperty("nfs")
    public void setNfs(ThanosRulerSpecVNfs nfs) {
        this.nfs = nfs;
    }

    @JsonProperty("persistentVolumeClaim")
    public ThanosRulerSpecVPersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(ThanosRulerSpecVPersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("photonPersistentDisk")
    public ThanosRulerSpecVPhotonPersistentDisk getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(ThanosRulerSpecVPhotonPersistentDisk photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    @JsonProperty("portworxVolume")
    public ThanosRulerSpecVPortworxVolume getPortworxVolume() {
        return portworxVolume;
    }

    @JsonProperty("portworxVolume")
    public void setPortworxVolume(ThanosRulerSpecVPortworxVolume portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    @JsonProperty("projected")
    public ThanosRulerSpecVProjected getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(ThanosRulerSpecVProjected projected) {
        this.projected = projected;
    }

    @JsonProperty("quobyte")
    public ThanosRulerSpecVQuobyte getQuobyte() {
        return quobyte;
    }

    @JsonProperty("quobyte")
    public void setQuobyte(ThanosRulerSpecVQuobyte quobyte) {
        this.quobyte = quobyte;
    }

    @JsonProperty("rbd")
    public ThanosRulerSpecVRbd getRbd() {
        return rbd;
    }

    @JsonProperty("rbd")
    public void setRbd(ThanosRulerSpecVRbd rbd) {
        this.rbd = rbd;
    }

    @JsonProperty("scaleIO")
    public ThanosRulerSpecVScaleIO getScaleIO() {
        return scaleIO;
    }

    @JsonProperty("scaleIO")
    public void setScaleIO(ThanosRulerSpecVScaleIO scaleIO) {
        this.scaleIO = scaleIO;
    }

    @JsonProperty("secret")
    public ThanosRulerSpecVSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(ThanosRulerSpecVSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("storageos")
    public ThanosRulerSpecVStorageos getStorageos() {
        return storageos;
    }

    @JsonProperty("storageos")
    public void setStorageos(ThanosRulerSpecVStorageos storageos) {
        this.storageos = storageos;
    }

    @JsonProperty("vsphereVolume")
    public ThanosRulerSpecVVsphereVolume getVsphereVolume() {
        return vsphereVolume;
    }

    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(ThanosRulerSpecVVsphereVolume vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public ThanosRulerSpecVolumesBuilder edit() {
        return new ThanosRulerSpecVolumesBuilder(this);
    }

    @JsonIgnore
    public ThanosRulerSpecVolumesBuilder toBuilder() {
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
