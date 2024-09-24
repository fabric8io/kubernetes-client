
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
public class AlertmanagerSpecVolumes implements Editable<AlertmanagerSpecVolumesBuilder> , KubernetesResource
{

    @JsonProperty("awsElasticBlockStore")
    private AlertmanagerSpecVAwsElasticBlockStore awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private AlertmanagerSpecVAzureDisk azureDisk;
    @JsonProperty("azureFile")
    private AlertmanagerSpecVAzureFile azureFile;
    @JsonProperty("cephfs")
    private AlertmanagerSpecVCephfs cephfs;
    @JsonProperty("cinder")
    private AlertmanagerSpecVCinder cinder;
    @JsonProperty("configMap")
    private AlertmanagerSpecVConfigMap configMap;
    @JsonProperty("csi")
    private AlertmanagerSpecVCsi csi;
    @JsonProperty("downwardAPI")
    private AlertmanagerSpecVDownwardAPI downwardAPI;
    @JsonProperty("emptyDir")
    private AlertmanagerSpecVEmptyDir emptyDir;
    @JsonProperty("ephemeral")
    private AlertmanagerSpecVEphemeral ephemeral;
    @JsonProperty("fc")
    private AlertmanagerSpecVFc fc;
    @JsonProperty("flexVolume")
    private AlertmanagerSpecVFlexVolume flexVolume;
    @JsonProperty("flocker")
    private AlertmanagerSpecVFlocker flocker;
    @JsonProperty("gcePersistentDisk")
    private AlertmanagerSpecVGcePersistentDisk gcePersistentDisk;
    @JsonProperty("gitRepo")
    private AlertmanagerSpecVGitRepo gitRepo;
    @JsonProperty("glusterfs")
    private AlertmanagerSpecVGlusterfs glusterfs;
    @JsonProperty("hostPath")
    private AlertmanagerSpecVHostPath hostPath;
    @JsonProperty("iscsi")
    private AlertmanagerSpecVIscsi iscsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nfs")
    private AlertmanagerSpecVNfs nfs;
    @JsonProperty("persistentVolumeClaim")
    private AlertmanagerSpecVPersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("photonPersistentDisk")
    private AlertmanagerSpecVPhotonPersistentDisk photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private AlertmanagerSpecVPortworxVolume portworxVolume;
    @JsonProperty("projected")
    private AlertmanagerSpecVProjected projected;
    @JsonProperty("quobyte")
    private AlertmanagerSpecVQuobyte quobyte;
    @JsonProperty("rbd")
    private AlertmanagerSpecVRbd rbd;
    @JsonProperty("scaleIO")
    private AlertmanagerSpecVScaleIO scaleIO;
    @JsonProperty("secret")
    private AlertmanagerSpecVSecret secret;
    @JsonProperty("storageos")
    private AlertmanagerSpecVStorageos storageos;
    @JsonProperty("vsphereVolume")
    private AlertmanagerSpecVVsphereVolume vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public AlertmanagerSpecVolumes() {
    }

    public AlertmanagerSpecVolumes(AlertmanagerSpecVAwsElasticBlockStore awsElasticBlockStore, AlertmanagerSpecVAzureDisk azureDisk, AlertmanagerSpecVAzureFile azureFile, AlertmanagerSpecVCephfs cephfs, AlertmanagerSpecVCinder cinder, AlertmanagerSpecVConfigMap configMap, AlertmanagerSpecVCsi csi, AlertmanagerSpecVDownwardAPI downwardAPI, AlertmanagerSpecVEmptyDir emptyDir, AlertmanagerSpecVEphemeral ephemeral, AlertmanagerSpecVFc fc, AlertmanagerSpecVFlexVolume flexVolume, AlertmanagerSpecVFlocker flocker, AlertmanagerSpecVGcePersistentDisk gcePersistentDisk, AlertmanagerSpecVGitRepo gitRepo, AlertmanagerSpecVGlusterfs glusterfs, AlertmanagerSpecVHostPath hostPath, AlertmanagerSpecVIscsi iscsi, String name, AlertmanagerSpecVNfs nfs, AlertmanagerSpecVPersistentVolumeClaim persistentVolumeClaim, AlertmanagerSpecVPhotonPersistentDisk photonPersistentDisk, AlertmanagerSpecVPortworxVolume portworxVolume, AlertmanagerSpecVProjected projected, AlertmanagerSpecVQuobyte quobyte, AlertmanagerSpecVRbd rbd, AlertmanagerSpecVScaleIO scaleIO, AlertmanagerSpecVSecret secret, AlertmanagerSpecVStorageos storageos, AlertmanagerSpecVVsphereVolume vsphereVolume) {
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
    public AlertmanagerSpecVAwsElasticBlockStore getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(AlertmanagerSpecVAwsElasticBlockStore awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    @JsonProperty("azureDisk")
    public AlertmanagerSpecVAzureDisk getAzureDisk() {
        return azureDisk;
    }

    @JsonProperty("azureDisk")
    public void setAzureDisk(AlertmanagerSpecVAzureDisk azureDisk) {
        this.azureDisk = azureDisk;
    }

    @JsonProperty("azureFile")
    public AlertmanagerSpecVAzureFile getAzureFile() {
        return azureFile;
    }

    @JsonProperty("azureFile")
    public void setAzureFile(AlertmanagerSpecVAzureFile azureFile) {
        this.azureFile = azureFile;
    }

    @JsonProperty("cephfs")
    public AlertmanagerSpecVCephfs getCephfs() {
        return cephfs;
    }

    @JsonProperty("cephfs")
    public void setCephfs(AlertmanagerSpecVCephfs cephfs) {
        this.cephfs = cephfs;
    }

    @JsonProperty("cinder")
    public AlertmanagerSpecVCinder getCinder() {
        return cinder;
    }

    @JsonProperty("cinder")
    public void setCinder(AlertmanagerSpecVCinder cinder) {
        this.cinder = cinder;
    }

    @JsonProperty("configMap")
    public AlertmanagerSpecVConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(AlertmanagerSpecVConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public AlertmanagerSpecVCsi getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(AlertmanagerSpecVCsi csi) {
        this.csi = csi;
    }

    @JsonProperty("downwardAPI")
    public AlertmanagerSpecVDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(AlertmanagerSpecVDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("emptyDir")
    public AlertmanagerSpecVEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(AlertmanagerSpecVEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public AlertmanagerSpecVEphemeral getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(AlertmanagerSpecVEphemeral ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("fc")
    public AlertmanagerSpecVFc getFc() {
        return fc;
    }

    @JsonProperty("fc")
    public void setFc(AlertmanagerSpecVFc fc) {
        this.fc = fc;
    }

    @JsonProperty("flexVolume")
    public AlertmanagerSpecVFlexVolume getFlexVolume() {
        return flexVolume;
    }

    @JsonProperty("flexVolume")
    public void setFlexVolume(AlertmanagerSpecVFlexVolume flexVolume) {
        this.flexVolume = flexVolume;
    }

    @JsonProperty("flocker")
    public AlertmanagerSpecVFlocker getFlocker() {
        return flocker;
    }

    @JsonProperty("flocker")
    public void setFlocker(AlertmanagerSpecVFlocker flocker) {
        this.flocker = flocker;
    }

    @JsonProperty("gcePersistentDisk")
    public AlertmanagerSpecVGcePersistentDisk getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(AlertmanagerSpecVGcePersistentDisk gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    @JsonProperty("gitRepo")
    public AlertmanagerSpecVGitRepo getGitRepo() {
        return gitRepo;
    }

    @JsonProperty("gitRepo")
    public void setGitRepo(AlertmanagerSpecVGitRepo gitRepo) {
        this.gitRepo = gitRepo;
    }

    @JsonProperty("glusterfs")
    public AlertmanagerSpecVGlusterfs getGlusterfs() {
        return glusterfs;
    }

    @JsonProperty("glusterfs")
    public void setGlusterfs(AlertmanagerSpecVGlusterfs glusterfs) {
        this.glusterfs = glusterfs;
    }

    @JsonProperty("hostPath")
    public AlertmanagerSpecVHostPath getHostPath() {
        return hostPath;
    }

    @JsonProperty("hostPath")
    public void setHostPath(AlertmanagerSpecVHostPath hostPath) {
        this.hostPath = hostPath;
    }

    @JsonProperty("iscsi")
    public AlertmanagerSpecVIscsi getIscsi() {
        return iscsi;
    }

    @JsonProperty("iscsi")
    public void setIscsi(AlertmanagerSpecVIscsi iscsi) {
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
    public AlertmanagerSpecVNfs getNfs() {
        return nfs;
    }

    @JsonProperty("nfs")
    public void setNfs(AlertmanagerSpecVNfs nfs) {
        this.nfs = nfs;
    }

    @JsonProperty("persistentVolumeClaim")
    public AlertmanagerSpecVPersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(AlertmanagerSpecVPersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("photonPersistentDisk")
    public AlertmanagerSpecVPhotonPersistentDisk getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(AlertmanagerSpecVPhotonPersistentDisk photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    @JsonProperty("portworxVolume")
    public AlertmanagerSpecVPortworxVolume getPortworxVolume() {
        return portworxVolume;
    }

    @JsonProperty("portworxVolume")
    public void setPortworxVolume(AlertmanagerSpecVPortworxVolume portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    @JsonProperty("projected")
    public AlertmanagerSpecVProjected getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(AlertmanagerSpecVProjected projected) {
        this.projected = projected;
    }

    @JsonProperty("quobyte")
    public AlertmanagerSpecVQuobyte getQuobyte() {
        return quobyte;
    }

    @JsonProperty("quobyte")
    public void setQuobyte(AlertmanagerSpecVQuobyte quobyte) {
        this.quobyte = quobyte;
    }

    @JsonProperty("rbd")
    public AlertmanagerSpecVRbd getRbd() {
        return rbd;
    }

    @JsonProperty("rbd")
    public void setRbd(AlertmanagerSpecVRbd rbd) {
        this.rbd = rbd;
    }

    @JsonProperty("scaleIO")
    public AlertmanagerSpecVScaleIO getScaleIO() {
        return scaleIO;
    }

    @JsonProperty("scaleIO")
    public void setScaleIO(AlertmanagerSpecVScaleIO scaleIO) {
        this.scaleIO = scaleIO;
    }

    @JsonProperty("secret")
    public AlertmanagerSpecVSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(AlertmanagerSpecVSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("storageos")
    public AlertmanagerSpecVStorageos getStorageos() {
        return storageos;
    }

    @JsonProperty("storageos")
    public void setStorageos(AlertmanagerSpecVStorageos storageos) {
        this.storageos = storageos;
    }

    @JsonProperty("vsphereVolume")
    public AlertmanagerSpecVVsphereVolume getVsphereVolume() {
        return vsphereVolume;
    }

    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(AlertmanagerSpecVVsphereVolume vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public AlertmanagerSpecVolumesBuilder edit() {
        return new AlertmanagerSpecVolumesBuilder(this);
    }

    @JsonIgnore
    public AlertmanagerSpecVolumesBuilder toBuilder() {
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
