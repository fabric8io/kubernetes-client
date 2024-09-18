
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
public class SubscriptionSpecCVolumes implements Editable<SubscriptionSpecCVolumesBuilder> , KubernetesResource
{

    @JsonProperty("awsElasticBlockStore")
    private SubscriptionSpecCVAwsElasticBlockStore awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private SubscriptionSpecCVAzureDisk azureDisk;
    @JsonProperty("azureFile")
    private SubscriptionSpecCVAzureFile azureFile;
    @JsonProperty("cephfs")
    private SubscriptionSpecCVCephfs cephfs;
    @JsonProperty("cinder")
    private SubscriptionSpecCVCinder cinder;
    @JsonProperty("configMap")
    private SubscriptionSpecCVConfigMap configMap;
    @JsonProperty("csi")
    private SubscriptionSpecCVCsi csi;
    @JsonProperty("downwardAPI")
    private SubscriptionSpecCVDownwardAPI downwardAPI;
    @JsonProperty("emptyDir")
    private SubscriptionSpecCVEmptyDir emptyDir;
    @JsonProperty("ephemeral")
    private SubscriptionSpecCVEphemeral ephemeral;
    @JsonProperty("fc")
    private SubscriptionSpecCVFc fc;
    @JsonProperty("flexVolume")
    private SubscriptionSpecCVFlexVolume flexVolume;
    @JsonProperty("flocker")
    private SubscriptionSpecCVFlocker flocker;
    @JsonProperty("gcePersistentDisk")
    private SubscriptionSpecCVGcePersistentDisk gcePersistentDisk;
    @JsonProperty("gitRepo")
    private SubscriptionSpecCVGitRepo gitRepo;
    @JsonProperty("glusterfs")
    private SubscriptionSpecCVGlusterfs glusterfs;
    @JsonProperty("hostPath")
    private SubscriptionSpecCVHostPath hostPath;
    @JsonProperty("iscsi")
    private SubscriptionSpecCVIscsi iscsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nfs")
    private SubscriptionSpecCVNfs nfs;
    @JsonProperty("persistentVolumeClaim")
    private SubscriptionSpecCVPersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("photonPersistentDisk")
    private SubscriptionSpecCVPhotonPersistentDisk photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private SubscriptionSpecCVPortworxVolume portworxVolume;
    @JsonProperty("projected")
    private SubscriptionSpecCVProjected projected;
    @JsonProperty("quobyte")
    private SubscriptionSpecCVQuobyte quobyte;
    @JsonProperty("rbd")
    private SubscriptionSpecCVRbd rbd;
    @JsonProperty("scaleIO")
    private SubscriptionSpecCVScaleIO scaleIO;
    @JsonProperty("secret")
    private SubscriptionSpecCVSecret secret;
    @JsonProperty("storageos")
    private SubscriptionSpecCVStorageos storageos;
    @JsonProperty("vsphereVolume")
    private SubscriptionSpecCVVsphereVolume vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public SubscriptionSpecCVolumes() {
    }

    public SubscriptionSpecCVolumes(SubscriptionSpecCVAwsElasticBlockStore awsElasticBlockStore, SubscriptionSpecCVAzureDisk azureDisk, SubscriptionSpecCVAzureFile azureFile, SubscriptionSpecCVCephfs cephfs, SubscriptionSpecCVCinder cinder, SubscriptionSpecCVConfigMap configMap, SubscriptionSpecCVCsi csi, SubscriptionSpecCVDownwardAPI downwardAPI, SubscriptionSpecCVEmptyDir emptyDir, SubscriptionSpecCVEphemeral ephemeral, SubscriptionSpecCVFc fc, SubscriptionSpecCVFlexVolume flexVolume, SubscriptionSpecCVFlocker flocker, SubscriptionSpecCVGcePersistentDisk gcePersistentDisk, SubscriptionSpecCVGitRepo gitRepo, SubscriptionSpecCVGlusterfs glusterfs, SubscriptionSpecCVHostPath hostPath, SubscriptionSpecCVIscsi iscsi, String name, SubscriptionSpecCVNfs nfs, SubscriptionSpecCVPersistentVolumeClaim persistentVolumeClaim, SubscriptionSpecCVPhotonPersistentDisk photonPersistentDisk, SubscriptionSpecCVPortworxVolume portworxVolume, SubscriptionSpecCVProjected projected, SubscriptionSpecCVQuobyte quobyte, SubscriptionSpecCVRbd rbd, SubscriptionSpecCVScaleIO scaleIO, SubscriptionSpecCVSecret secret, SubscriptionSpecCVStorageos storageos, SubscriptionSpecCVVsphereVolume vsphereVolume) {
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
    public SubscriptionSpecCVAwsElasticBlockStore getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(SubscriptionSpecCVAwsElasticBlockStore awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    @JsonProperty("azureDisk")
    public SubscriptionSpecCVAzureDisk getAzureDisk() {
        return azureDisk;
    }

    @JsonProperty("azureDisk")
    public void setAzureDisk(SubscriptionSpecCVAzureDisk azureDisk) {
        this.azureDisk = azureDisk;
    }

    @JsonProperty("azureFile")
    public SubscriptionSpecCVAzureFile getAzureFile() {
        return azureFile;
    }

    @JsonProperty("azureFile")
    public void setAzureFile(SubscriptionSpecCVAzureFile azureFile) {
        this.azureFile = azureFile;
    }

    @JsonProperty("cephfs")
    public SubscriptionSpecCVCephfs getCephfs() {
        return cephfs;
    }

    @JsonProperty("cephfs")
    public void setCephfs(SubscriptionSpecCVCephfs cephfs) {
        this.cephfs = cephfs;
    }

    @JsonProperty("cinder")
    public SubscriptionSpecCVCinder getCinder() {
        return cinder;
    }

    @JsonProperty("cinder")
    public void setCinder(SubscriptionSpecCVCinder cinder) {
        this.cinder = cinder;
    }

    @JsonProperty("configMap")
    public SubscriptionSpecCVConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(SubscriptionSpecCVConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public SubscriptionSpecCVCsi getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(SubscriptionSpecCVCsi csi) {
        this.csi = csi;
    }

    @JsonProperty("downwardAPI")
    public SubscriptionSpecCVDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(SubscriptionSpecCVDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("emptyDir")
    public SubscriptionSpecCVEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(SubscriptionSpecCVEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public SubscriptionSpecCVEphemeral getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(SubscriptionSpecCVEphemeral ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("fc")
    public SubscriptionSpecCVFc getFc() {
        return fc;
    }

    @JsonProperty("fc")
    public void setFc(SubscriptionSpecCVFc fc) {
        this.fc = fc;
    }

    @JsonProperty("flexVolume")
    public SubscriptionSpecCVFlexVolume getFlexVolume() {
        return flexVolume;
    }

    @JsonProperty("flexVolume")
    public void setFlexVolume(SubscriptionSpecCVFlexVolume flexVolume) {
        this.flexVolume = flexVolume;
    }

    @JsonProperty("flocker")
    public SubscriptionSpecCVFlocker getFlocker() {
        return flocker;
    }

    @JsonProperty("flocker")
    public void setFlocker(SubscriptionSpecCVFlocker flocker) {
        this.flocker = flocker;
    }

    @JsonProperty("gcePersistentDisk")
    public SubscriptionSpecCVGcePersistentDisk getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(SubscriptionSpecCVGcePersistentDisk gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    @JsonProperty("gitRepo")
    public SubscriptionSpecCVGitRepo getGitRepo() {
        return gitRepo;
    }

    @JsonProperty("gitRepo")
    public void setGitRepo(SubscriptionSpecCVGitRepo gitRepo) {
        this.gitRepo = gitRepo;
    }

    @JsonProperty("glusterfs")
    public SubscriptionSpecCVGlusterfs getGlusterfs() {
        return glusterfs;
    }

    @JsonProperty("glusterfs")
    public void setGlusterfs(SubscriptionSpecCVGlusterfs glusterfs) {
        this.glusterfs = glusterfs;
    }

    @JsonProperty("hostPath")
    public SubscriptionSpecCVHostPath getHostPath() {
        return hostPath;
    }

    @JsonProperty("hostPath")
    public void setHostPath(SubscriptionSpecCVHostPath hostPath) {
        this.hostPath = hostPath;
    }

    @JsonProperty("iscsi")
    public SubscriptionSpecCVIscsi getIscsi() {
        return iscsi;
    }

    @JsonProperty("iscsi")
    public void setIscsi(SubscriptionSpecCVIscsi iscsi) {
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
    public SubscriptionSpecCVNfs getNfs() {
        return nfs;
    }

    @JsonProperty("nfs")
    public void setNfs(SubscriptionSpecCVNfs nfs) {
        this.nfs = nfs;
    }

    @JsonProperty("persistentVolumeClaim")
    public SubscriptionSpecCVPersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(SubscriptionSpecCVPersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("photonPersistentDisk")
    public SubscriptionSpecCVPhotonPersistentDisk getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(SubscriptionSpecCVPhotonPersistentDisk photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    @JsonProperty("portworxVolume")
    public SubscriptionSpecCVPortworxVolume getPortworxVolume() {
        return portworxVolume;
    }

    @JsonProperty("portworxVolume")
    public void setPortworxVolume(SubscriptionSpecCVPortworxVolume portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    @JsonProperty("projected")
    public SubscriptionSpecCVProjected getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(SubscriptionSpecCVProjected projected) {
        this.projected = projected;
    }

    @JsonProperty("quobyte")
    public SubscriptionSpecCVQuobyte getQuobyte() {
        return quobyte;
    }

    @JsonProperty("quobyte")
    public void setQuobyte(SubscriptionSpecCVQuobyte quobyte) {
        this.quobyte = quobyte;
    }

    @JsonProperty("rbd")
    public SubscriptionSpecCVRbd getRbd() {
        return rbd;
    }

    @JsonProperty("rbd")
    public void setRbd(SubscriptionSpecCVRbd rbd) {
        this.rbd = rbd;
    }

    @JsonProperty("scaleIO")
    public SubscriptionSpecCVScaleIO getScaleIO() {
        return scaleIO;
    }

    @JsonProperty("scaleIO")
    public void setScaleIO(SubscriptionSpecCVScaleIO scaleIO) {
        this.scaleIO = scaleIO;
    }

    @JsonProperty("secret")
    public SubscriptionSpecCVSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(SubscriptionSpecCVSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("storageos")
    public SubscriptionSpecCVStorageos getStorageos() {
        return storageos;
    }

    @JsonProperty("storageos")
    public void setStorageos(SubscriptionSpecCVStorageos storageos) {
        this.storageos = storageos;
    }

    @JsonProperty("vsphereVolume")
    public SubscriptionSpecCVVsphereVolume getVsphereVolume() {
        return vsphereVolume;
    }

    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(SubscriptionSpecCVVsphereVolume vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public SubscriptionSpecCVolumesBuilder edit() {
        return new SubscriptionSpecCVolumesBuilder(this);
    }

    @JsonIgnore
    public SubscriptionSpecCVolumesBuilder toBuilder() {
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
