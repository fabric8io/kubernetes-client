
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
public class PrometheusSpecVolumes implements Editable<PrometheusSpecVolumesBuilder> , KubernetesResource
{

    @JsonProperty("awsElasticBlockStore")
    private PrometheusSpecVAwsElasticBlockStore awsElasticBlockStore;
    @JsonProperty("azureDisk")
    private PrometheusSpecVAzureDisk azureDisk;
    @JsonProperty("azureFile")
    private PrometheusSpecVAzureFile azureFile;
    @JsonProperty("cephfs")
    private PrometheusSpecVCephfs cephfs;
    @JsonProperty("cinder")
    private PrometheusSpecVCinder cinder;
    @JsonProperty("configMap")
    private PrometheusSpecVConfigMap configMap;
    @JsonProperty("csi")
    private PrometheusSpecVCsi csi;
    @JsonProperty("downwardAPI")
    private PrometheusSpecVDownwardAPI downwardAPI;
    @JsonProperty("emptyDir")
    private PrometheusSpecVEmptyDir emptyDir;
    @JsonProperty("ephemeral")
    private PrometheusSpecVEphemeral ephemeral;
    @JsonProperty("fc")
    private PrometheusSpecVFc fc;
    @JsonProperty("flexVolume")
    private PrometheusSpecVFlexVolume flexVolume;
    @JsonProperty("flocker")
    private PrometheusSpecVFlocker flocker;
    @JsonProperty("gcePersistentDisk")
    private PrometheusSpecVGcePersistentDisk gcePersistentDisk;
    @JsonProperty("gitRepo")
    private PrometheusSpecVGitRepo gitRepo;
    @JsonProperty("glusterfs")
    private PrometheusSpecVGlusterfs glusterfs;
    @JsonProperty("hostPath")
    private PrometheusSpecVHostPath hostPath;
    @JsonProperty("iscsi")
    private PrometheusSpecVIscsi iscsi;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nfs")
    private PrometheusSpecVNfs nfs;
    @JsonProperty("persistentVolumeClaim")
    private PrometheusSpecVPersistentVolumeClaim persistentVolumeClaim;
    @JsonProperty("photonPersistentDisk")
    private PrometheusSpecVPhotonPersistentDisk photonPersistentDisk;
    @JsonProperty("portworxVolume")
    private PrometheusSpecVPortworxVolume portworxVolume;
    @JsonProperty("projected")
    private PrometheusSpecVProjected projected;
    @JsonProperty("quobyte")
    private PrometheusSpecVQuobyte quobyte;
    @JsonProperty("rbd")
    private PrometheusSpecVRbd rbd;
    @JsonProperty("scaleIO")
    private PrometheusSpecVScaleIO scaleIO;
    @JsonProperty("secret")
    private PrometheusSpecVSecret secret;
    @JsonProperty("storageos")
    private PrometheusSpecVStorageos storageos;
    @JsonProperty("vsphereVolume")
    private PrometheusSpecVVsphereVolume vsphereVolume;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrometheusSpecVolumes() {
    }

    public PrometheusSpecVolumes(PrometheusSpecVAwsElasticBlockStore awsElasticBlockStore, PrometheusSpecVAzureDisk azureDisk, PrometheusSpecVAzureFile azureFile, PrometheusSpecVCephfs cephfs, PrometheusSpecVCinder cinder, PrometheusSpecVConfigMap configMap, PrometheusSpecVCsi csi, PrometheusSpecVDownwardAPI downwardAPI, PrometheusSpecVEmptyDir emptyDir, PrometheusSpecVEphemeral ephemeral, PrometheusSpecVFc fc, PrometheusSpecVFlexVolume flexVolume, PrometheusSpecVFlocker flocker, PrometheusSpecVGcePersistentDisk gcePersistentDisk, PrometheusSpecVGitRepo gitRepo, PrometheusSpecVGlusterfs glusterfs, PrometheusSpecVHostPath hostPath, PrometheusSpecVIscsi iscsi, String name, PrometheusSpecVNfs nfs, PrometheusSpecVPersistentVolumeClaim persistentVolumeClaim, PrometheusSpecVPhotonPersistentDisk photonPersistentDisk, PrometheusSpecVPortworxVolume portworxVolume, PrometheusSpecVProjected projected, PrometheusSpecVQuobyte quobyte, PrometheusSpecVRbd rbd, PrometheusSpecVScaleIO scaleIO, PrometheusSpecVSecret secret, PrometheusSpecVStorageos storageos, PrometheusSpecVVsphereVolume vsphereVolume) {
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
    public PrometheusSpecVAwsElasticBlockStore getAwsElasticBlockStore() {
        return awsElasticBlockStore;
    }

    @JsonProperty("awsElasticBlockStore")
    public void setAwsElasticBlockStore(PrometheusSpecVAwsElasticBlockStore awsElasticBlockStore) {
        this.awsElasticBlockStore = awsElasticBlockStore;
    }

    @JsonProperty("azureDisk")
    public PrometheusSpecVAzureDisk getAzureDisk() {
        return azureDisk;
    }

    @JsonProperty("azureDisk")
    public void setAzureDisk(PrometheusSpecVAzureDisk azureDisk) {
        this.azureDisk = azureDisk;
    }

    @JsonProperty("azureFile")
    public PrometheusSpecVAzureFile getAzureFile() {
        return azureFile;
    }

    @JsonProperty("azureFile")
    public void setAzureFile(PrometheusSpecVAzureFile azureFile) {
        this.azureFile = azureFile;
    }

    @JsonProperty("cephfs")
    public PrometheusSpecVCephfs getCephfs() {
        return cephfs;
    }

    @JsonProperty("cephfs")
    public void setCephfs(PrometheusSpecVCephfs cephfs) {
        this.cephfs = cephfs;
    }

    @JsonProperty("cinder")
    public PrometheusSpecVCinder getCinder() {
        return cinder;
    }

    @JsonProperty("cinder")
    public void setCinder(PrometheusSpecVCinder cinder) {
        this.cinder = cinder;
    }

    @JsonProperty("configMap")
    public PrometheusSpecVConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(PrometheusSpecVConfigMap configMap) {
        this.configMap = configMap;
    }

    @JsonProperty("csi")
    public PrometheusSpecVCsi getCsi() {
        return csi;
    }

    @JsonProperty("csi")
    public void setCsi(PrometheusSpecVCsi csi) {
        this.csi = csi;
    }

    @JsonProperty("downwardAPI")
    public PrometheusSpecVDownwardAPI getDownwardAPI() {
        return downwardAPI;
    }

    @JsonProperty("downwardAPI")
    public void setDownwardAPI(PrometheusSpecVDownwardAPI downwardAPI) {
        this.downwardAPI = downwardAPI;
    }

    @JsonProperty("emptyDir")
    public PrometheusSpecVEmptyDir getEmptyDir() {
        return emptyDir;
    }

    @JsonProperty("emptyDir")
    public void setEmptyDir(PrometheusSpecVEmptyDir emptyDir) {
        this.emptyDir = emptyDir;
    }

    @JsonProperty("ephemeral")
    public PrometheusSpecVEphemeral getEphemeral() {
        return ephemeral;
    }

    @JsonProperty("ephemeral")
    public void setEphemeral(PrometheusSpecVEphemeral ephemeral) {
        this.ephemeral = ephemeral;
    }

    @JsonProperty("fc")
    public PrometheusSpecVFc getFc() {
        return fc;
    }

    @JsonProperty("fc")
    public void setFc(PrometheusSpecVFc fc) {
        this.fc = fc;
    }

    @JsonProperty("flexVolume")
    public PrometheusSpecVFlexVolume getFlexVolume() {
        return flexVolume;
    }

    @JsonProperty("flexVolume")
    public void setFlexVolume(PrometheusSpecVFlexVolume flexVolume) {
        this.flexVolume = flexVolume;
    }

    @JsonProperty("flocker")
    public PrometheusSpecVFlocker getFlocker() {
        return flocker;
    }

    @JsonProperty("flocker")
    public void setFlocker(PrometheusSpecVFlocker flocker) {
        this.flocker = flocker;
    }

    @JsonProperty("gcePersistentDisk")
    public PrometheusSpecVGcePersistentDisk getGcePersistentDisk() {
        return gcePersistentDisk;
    }

    @JsonProperty("gcePersistentDisk")
    public void setGcePersistentDisk(PrometheusSpecVGcePersistentDisk gcePersistentDisk) {
        this.gcePersistentDisk = gcePersistentDisk;
    }

    @JsonProperty("gitRepo")
    public PrometheusSpecVGitRepo getGitRepo() {
        return gitRepo;
    }

    @JsonProperty("gitRepo")
    public void setGitRepo(PrometheusSpecVGitRepo gitRepo) {
        this.gitRepo = gitRepo;
    }

    @JsonProperty("glusterfs")
    public PrometheusSpecVGlusterfs getGlusterfs() {
        return glusterfs;
    }

    @JsonProperty("glusterfs")
    public void setGlusterfs(PrometheusSpecVGlusterfs glusterfs) {
        this.glusterfs = glusterfs;
    }

    @JsonProperty("hostPath")
    public PrometheusSpecVHostPath getHostPath() {
        return hostPath;
    }

    @JsonProperty("hostPath")
    public void setHostPath(PrometheusSpecVHostPath hostPath) {
        this.hostPath = hostPath;
    }

    @JsonProperty("iscsi")
    public PrometheusSpecVIscsi getIscsi() {
        return iscsi;
    }

    @JsonProperty("iscsi")
    public void setIscsi(PrometheusSpecVIscsi iscsi) {
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
    public PrometheusSpecVNfs getNfs() {
        return nfs;
    }

    @JsonProperty("nfs")
    public void setNfs(PrometheusSpecVNfs nfs) {
        this.nfs = nfs;
    }

    @JsonProperty("persistentVolumeClaim")
    public PrometheusSpecVPersistentVolumeClaim getPersistentVolumeClaim() {
        return persistentVolumeClaim;
    }

    @JsonProperty("persistentVolumeClaim")
    public void setPersistentVolumeClaim(PrometheusSpecVPersistentVolumeClaim persistentVolumeClaim) {
        this.persistentVolumeClaim = persistentVolumeClaim;
    }

    @JsonProperty("photonPersistentDisk")
    public PrometheusSpecVPhotonPersistentDisk getPhotonPersistentDisk() {
        return photonPersistentDisk;
    }

    @JsonProperty("photonPersistentDisk")
    public void setPhotonPersistentDisk(PrometheusSpecVPhotonPersistentDisk photonPersistentDisk) {
        this.photonPersistentDisk = photonPersistentDisk;
    }

    @JsonProperty("portworxVolume")
    public PrometheusSpecVPortworxVolume getPortworxVolume() {
        return portworxVolume;
    }

    @JsonProperty("portworxVolume")
    public void setPortworxVolume(PrometheusSpecVPortworxVolume portworxVolume) {
        this.portworxVolume = portworxVolume;
    }

    @JsonProperty("projected")
    public PrometheusSpecVProjected getProjected() {
        return projected;
    }

    @JsonProperty("projected")
    public void setProjected(PrometheusSpecVProjected projected) {
        this.projected = projected;
    }

    @JsonProperty("quobyte")
    public PrometheusSpecVQuobyte getQuobyte() {
        return quobyte;
    }

    @JsonProperty("quobyte")
    public void setQuobyte(PrometheusSpecVQuobyte quobyte) {
        this.quobyte = quobyte;
    }

    @JsonProperty("rbd")
    public PrometheusSpecVRbd getRbd() {
        return rbd;
    }

    @JsonProperty("rbd")
    public void setRbd(PrometheusSpecVRbd rbd) {
        this.rbd = rbd;
    }

    @JsonProperty("scaleIO")
    public PrometheusSpecVScaleIO getScaleIO() {
        return scaleIO;
    }

    @JsonProperty("scaleIO")
    public void setScaleIO(PrometheusSpecVScaleIO scaleIO) {
        this.scaleIO = scaleIO;
    }

    @JsonProperty("secret")
    public PrometheusSpecVSecret getSecret() {
        return secret;
    }

    @JsonProperty("secret")
    public void setSecret(PrometheusSpecVSecret secret) {
        this.secret = secret;
    }

    @JsonProperty("storageos")
    public PrometheusSpecVStorageos getStorageos() {
        return storageos;
    }

    @JsonProperty("storageos")
    public void setStorageos(PrometheusSpecVStorageos storageos) {
        this.storageos = storageos;
    }

    @JsonProperty("vsphereVolume")
    public PrometheusSpecVVsphereVolume getVsphereVolume() {
        return vsphereVolume;
    }

    @JsonProperty("vsphereVolume")
    public void setVsphereVolume(PrometheusSpecVVsphereVolume vsphereVolume) {
        this.vsphereVolume = vsphereVolume;
    }

    @JsonIgnore
    public PrometheusSpecVolumesBuilder edit() {
        return new PrometheusSpecVolumesBuilder(this);
    }

    @JsonIgnore
    public PrometheusSpecVolumesBuilder toBuilder() {
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
