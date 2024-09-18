
package io.fabric8.openshift.api.model.operatorhub.v1alpha1;

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
public class ClusterServiceVersionSpecISpecDSpecTSpecVolumes implements Editable<ClusterServiceVersionSpecISpecDSpecTSpecVolumesBuilder> , KubernetesResource
{

    @JsonProperty("awsElasticBlockStore")
    private ClusterServiceVersionSpecISpecDSpecTSpecVAwsElasticBlockStore awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private ClusterServiceVersionSpecISpecDSpecTSpecVAzureDisk azureDisk;
    @JsonProperty("azureFile")
    private ClusterServiceVersionSpecISpecDSpecTSpecVAzureFile azureFile;
    @JsonProperty("cephfs")
    private ClusterServiceVersionSpecISpecDSpecTSpecVCephfs cephfs;
    @JsonProperty("cinder")
    private ClusterServiceVersionSpecISpecDSpecTSpecVCinder cinder;
    @JsonProperty("configMap")
    private ClusterServiceVersionSpecISpecDSpecTSpecVConfigMap configMap;
    @JsonProperty("csi")
    private ClusterServiceVersionSpecISpecDSpecTSpecVCsi csi;
    @JsonProperty("downwardAPI")
    private ClusterServiceVersionSpecISpecDSpecTSpecVDownwardAPI downwardAPI;
    @JsonProperty("emptyDir")
    private ClusterServiceVersionSpecISpecDSpecTSpecVEmptyDir emptyDir;
    @JsonProperty("ephemeral")
    private ClusterServiceVersionSpecISpecDSpecTSpecVEphemeral ephemeral;
    @JsonProperty("fc")
    private ClusterServiceVersionSpecISpecDSpecTSpecVFc fc;
    @JsonProperty("flexVolume")
    private ClusterServiceVersionSpecISpecDSpecTSpecVFlexVolume flexVolume;
    @JsonProperty("flocker")
    private ClusterServiceVersionSpecISpecDSpecTSpecVFlocker flocker;
    @JsonProperty("gcePersistentDisk")
    private ClusterServiceVersionSpecISpecDSpecTSpecVGcePersistentDisk gcePersistentDisk;
    @JsonProperty("gitRepo")
    private ClusterServiceVersionSpecISpecDSpecTSpecVGitRepo gitRepo;
    @JsonProperty("glusterfs")
    private ClusterServiceVersionSpecISpecDSpecTSpecVGlusterfs glusterfs;
    @JsonProperty("hostPath")
    private ClusterServiceVersionSpecISpecDSpecTSpecVHostPath hostPath;
    @JsonProperty("iscsi")
    private ClusterServiceVersionSpecISpecDSpecTSpecVIscsi iscsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nfs")
    private ClusterServiceVersionSpecISpecDSpecTSpecVNfs nfs;
    @JsonProperty("persistentVolumeClaim")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("photonPersistentDisk")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPhotonPersistentDisk photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private ClusterServiceVersionSpecISpecDSpecTSpecVPortworxVolume portworxVolume;
    @JsonProperty("projected")
    private ClusterServiceVersionSpecISpecDSpecTSpecVProjected projected;
    @JsonProperty("quobyte")
    private ClusterServiceVersionSpecISpecDSpecTSpecVQuobyte quobyte;
    @JsonProperty("rbd")
    private ClusterServiceVersionSpecISpecDSpecTSpecVRbd rbd;
    @JsonProperty("scaleIO")
    private ClusterServiceVersionSpecISpecDSpecTSpecVScaleIO scaleIO;
    @JsonProperty("secret")
    private ClusterServiceVersionSpecISpecDSpecTSpecVSecret secret;
    @JsonProperty("storageos")
    private ClusterServiceVersionSpecISpecDSpecTSpecVStorageos storageos;
    @JsonProperty("vsphereVolume")
    private ClusterServiceVersionSpecISpecDSpecTSpecVVsphereVolume vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClusterServiceVersionSpecISpecDSpecTSpecVolumes() {
    }

    public ClusterServiceVersionSpecISpecDSpecTSpecVolumes(ClusterServiceVersionSpecISpecDSpecTSpecVAwsElasticBlockStore awsElasticBlockStore, ClusterServiceVersionSpecISpecDSpecTSpecVAzureDisk azureDisk, ClusterServiceVersionSpecISpecDSpecTSpecVAzureFile azureFile, ClusterServiceVersionSpecISpecDSpecTSpecVCephfs cephfs, ClusterServiceVersionSpecISpecDSpecTSpecVCinder cinder, ClusterServiceVersionSpecISpecDSpecTSpecVConfigMap configMap, ClusterServiceVersionSpecISpecDSpecTSpecVCsi csi, ClusterServiceVersionSpecISpecDSpecTSpecVDownwardAPI downwardAPI, ClusterServiceVersionSpecISpecDSpecTSpecVEmptyDir emptyDir, ClusterServiceVersionSpecISpecDSpecTSpecVEphemeral ephemeral, ClusterServiceVersionSpecISpecDSpecTSpecVFc fc, ClusterServiceVersionSpecISpecDSpecTSpecVFlexVolume flexVolume, ClusterServiceVersionSpecISpecDSpecTSpecVFlocker flocker, ClusterServiceVersionSpecISpecDSpecTSpecVGcePersistentDisk gcePersistentDisk, ClusterServiceVersionSpecISpecDSpecTSpecVGitRepo gitRepo, ClusterServiceVersionSpecISpecDSpecTSpecVGlusterfs glusterfs, ClusterServiceVersionSpecISpecDSpecTSpecVHostPath hostPath, ClusterServiceVersionSpecISpecDSpecTSpecVIscsi iscsi, String name, ClusterServiceVersionSpecISpecDSpecTSpecVNfs nfs, ClusterServiceVersionSpecISpecDSpecTSpecVPersistentVolumeClaim persistentVolumeClaim, ClusterServiceVersionSpecISpecDSpecTSpecVPhotonPersistentDisk photonPersistentDisk, ClusterServiceVersionSpecISpecDSpecTSpecVPortworxVolume portworxVolume, ClusterServiceVersionSpecISpecDSpecTSpecVProjected projected, ClusterServiceVersionSpecISpecDSpecTSpecVQuobyte quobyte, ClusterServiceVersionSpecISpecDSpecTSpecVRbd rbd, ClusterServiceVersionSpecISpecDSpecTSpecVScaleIO scaleIO, ClusterServiceVersionSpecISpecDSpecTSpecVSecret secret, ClusterServiceVersionSpecISpecDSpecTSpecVStorageos storageos, ClusterServiceVersionSpecISpecDSpecTSpecVVsphereVolume vsphereVolume) {
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
    public ClusterServiceVersionSpecISpecDSpecTSpecVAwsElasticBlockStore getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(ClusterServiceVersionSpecISpecDSpecTSpecVAwsElasticBlockStore awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    @JsonProperty("azureDisk")
    public ClusterServiceVersionSpecISpecDSpecTSpecVAzureDisk getAzureDisk() {
        return azureDisk;
    }

    @JsonProperty("azureDisk")
    public void setAzureDisk(ClusterServiceVersionSpecISpecDSpecTSpecVAzureDisk azureDisk) {
        this.azureDisk = azureDisk;
    }

    @JsonProperty("azureFile")
    public ClusterServiceVersionSpecISpecDSpecTSpecVAzureFile getAzureFile() {
        return azureFile;
    }

    @JsonProperty("azureFile")
    public void setAzureFile(ClusterServiceVersionSpecISpecDSpecTSpecVAzureFile azureFile) {
        this.azureFile = azureFile;
    }

    @JsonProperty("cephfs")
    public ClusterServiceVersionSpecISpecDSpecTSpecVCephfs getCephfs() {
        return cephfs;
    }

    @JsonProperty("cephfs")
    public void setCephfs(ClusterServiceVersionSpecISpecDSpecTSpecVCephfs cephfs) {
        this.cephfs = cephfs;
    }

    @JsonProperty("cinder")
    public ClusterServiceVersionSpecISpecDSpecTSpecVCinder getCinder() {
        return cinder;
    }

    @JsonProperty("cinder")
    public void setCinder(ClusterServiceVersionSpecISpecDSpecTSpecVCinder cinder) {
        this.cinder = cinder;
    }

    @JsonProperty("configMap")
    public ClusterServiceVersionSpecISpecDSpecTSpecVConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ClusterServiceVersionSpecISpecDSpecTSpecVConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public ClusterServiceVersionSpecISpecDSpecTSpecVCsi getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(ClusterServiceVersionSpecISpecDSpecTSpecVCsi csi) {
        this.csi = csi;
    }

    @JsonProperty("downwardAPI")
    public ClusterServiceVersionSpecISpecDSpecTSpecVDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(ClusterServiceVersionSpecISpecDSpecTSpecVDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("emptyDir")
    public ClusterServiceVersionSpecISpecDSpecTSpecVEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(ClusterServiceVersionSpecISpecDSpecTSpecVEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public ClusterServiceVersionSpecISpecDSpecTSpecVEphemeral getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(ClusterServiceVersionSpecISpecDSpecTSpecVEphemeral ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("fc")
    public ClusterServiceVersionSpecISpecDSpecTSpecVFc getFc() {
        return fc;
    }

    @JsonProperty("fc")
    public void setFc(ClusterServiceVersionSpecISpecDSpecTSpecVFc fc) {
        this.fc = fc;
    }

    @JsonProperty("flexVolume")
    public ClusterServiceVersionSpecISpecDSpecTSpecVFlexVolume getFlexVolume() {
        return flexVolume;
    }

    @JsonProperty("flexVolume")
    public void setFlexVolume(ClusterServiceVersionSpecISpecDSpecTSpecVFlexVolume flexVolume) {
        this.flexVolume = flexVolume;
    }

    @JsonProperty("flocker")
    public ClusterServiceVersionSpecISpecDSpecTSpecVFlocker getFlocker() {
        return flocker;
    }

    @JsonProperty("flocker")
    public void setFlocker(ClusterServiceVersionSpecISpecDSpecTSpecVFlocker flocker) {
        this.flocker = flocker;
    }

    @JsonProperty("gcePersistentDisk")
    public ClusterServiceVersionSpecISpecDSpecTSpecVGcePersistentDisk getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(ClusterServiceVersionSpecISpecDSpecTSpecVGcePersistentDisk gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    @JsonProperty("gitRepo")
    public ClusterServiceVersionSpecISpecDSpecTSpecVGitRepo getGitRepo() {
        return gitRepo;
    }

    @JsonProperty("gitRepo")
    public void setGitRepo(ClusterServiceVersionSpecISpecDSpecTSpecVGitRepo gitRepo) {
        this.gitRepo = gitRepo;
    }

    @JsonProperty("glusterfs")
    public ClusterServiceVersionSpecISpecDSpecTSpecVGlusterfs getGlusterfs() {
        return glusterfs;
    }

    @JsonProperty("glusterfs")
    public void setGlusterfs(ClusterServiceVersionSpecISpecDSpecTSpecVGlusterfs glusterfs) {
        this.glusterfs = glusterfs;
    }

    @JsonProperty("hostPath")
    public ClusterServiceVersionSpecISpecDSpecTSpecVHostPath getHostPath() {
        return hostPath;
    }

    @JsonProperty("hostPath")
    public void setHostPath(ClusterServiceVersionSpecISpecDSpecTSpecVHostPath hostPath) {
        this.hostPath = hostPath;
    }

    @JsonProperty("iscsi")
    public ClusterServiceVersionSpecISpecDSpecTSpecVIscsi getIscsi() {
        return iscsi;
    }

    @JsonProperty("iscsi")
    public void setIscsi(ClusterServiceVersionSpecISpecDSpecTSpecVIscsi iscsi) {
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
    public ClusterServiceVersionSpecISpecDSpecTSpecVNfs getNfs() {
        return nfs;
    }

    @JsonProperty("nfs")
    public void setNfs(ClusterServiceVersionSpecISpecDSpecTSpecVNfs nfs) {
        this.nfs = nfs;
    }

    @JsonProperty("persistentVolumeClaim")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(ClusterServiceVersionSpecISpecDSpecTSpecVPersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("photonPersistentDisk")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPhotonPersistentDisk getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(ClusterServiceVersionSpecISpecDSpecTSpecVPhotonPersistentDisk photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    @JsonProperty("portworxVolume")
    public ClusterServiceVersionSpecISpecDSpecTSpecVPortworxVolume getPortworxVolume() {
        return portworxVolume;
    }

    @JsonProperty("portworxVolume")
    public void setPortworxVolume(ClusterServiceVersionSpecISpecDSpecTSpecVPortworxVolume portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    @JsonProperty("projected")
    public ClusterServiceVersionSpecISpecDSpecTSpecVProjected getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(ClusterServiceVersionSpecISpecDSpecTSpecVProjected projected) {
        this.projected = projected;
    }

    @JsonProperty("quobyte")
    public ClusterServiceVersionSpecISpecDSpecTSpecVQuobyte getQuobyte() {
        return quobyte;
    }

    @JsonProperty("quobyte")
    public void setQuobyte(ClusterServiceVersionSpecISpecDSpecTSpecVQuobyte quobyte) {
        this.quobyte = quobyte;
    }

    @JsonProperty("rbd")
    public ClusterServiceVersionSpecISpecDSpecTSpecVRbd getRbd() {
        return rbd;
    }

    @JsonProperty("rbd")
    public void setRbd(ClusterServiceVersionSpecISpecDSpecTSpecVRbd rbd) {
        this.rbd = rbd;
    }

    @JsonProperty("scaleIO")
    public ClusterServiceVersionSpecISpecDSpecTSpecVScaleIO getScaleIO() {
        return scaleIO;
    }

    @JsonProperty("scaleIO")
    public void setScaleIO(ClusterServiceVersionSpecISpecDSpecTSpecVScaleIO scaleIO) {
        this.scaleIO = scaleIO;
    }

    @JsonProperty("secret")
    public ClusterServiceVersionSpecISpecDSpecTSpecVSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(ClusterServiceVersionSpecISpecDSpecTSpecVSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("storageos")
    public ClusterServiceVersionSpecISpecDSpecTSpecVStorageos getStorageos() {
        return storageos;
    }

    @JsonProperty("storageos")
    public void setStorageos(ClusterServiceVersionSpecISpecDSpecTSpecVStorageos storageos) {
        this.storageos = storageos;
    }

    @JsonProperty("vsphereVolume")
    public ClusterServiceVersionSpecISpecDSpecTSpecVVsphereVolume getVsphereVolume() {
        return vsphereVolume;
    }

    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(ClusterServiceVersionSpecISpecDSpecTSpecVVsphereVolume vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVolumesBuilder edit() {
        return new ClusterServiceVersionSpecISpecDSpecTSpecVolumesBuilder(this);
    }

    @JsonIgnore
    public ClusterServiceVersionSpecISpecDSpecTSpecVolumesBuilder toBuilder() {
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
