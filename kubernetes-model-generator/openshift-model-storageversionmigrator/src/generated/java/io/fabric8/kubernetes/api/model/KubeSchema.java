
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageState;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageStateList;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigration;
import io.fabric8.openshift.api.model.storageversionmigrator.v1alpha1.StorageVersionMigrationList;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private Info info;
    private ObjectMeta objectMeta;
    private Patch patch;
    private Status status;
    private StorageState storageState;
    private StorageStateList storageStateList;
    private StorageVersionMigration storageVersionMigration;
    private StorageVersionMigrationList storageVersionMigrationList;
    private String time;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, Info info, ObjectMeta objectMeta, Patch patch, Status status, StorageState storageState, StorageStateList storageStateList, StorageVersionMigration storageVersionMigration, StorageVersionMigrationList storageVersionMigrationList, String time, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.status = status;
        this.storageState = storageState;
        this.storageStateList = storageStateList;
        this.storageVersionMigration = storageVersionMigration;
        this.storageVersionMigrationList = storageVersionMigrationList;
        this.time = time;
        this.typeMeta = typeMeta;
    }

    @JsonProperty("APIGroup")
    public APIGroup getAPIGroup() {
        return aPIGroup;
    }

    @JsonProperty("APIGroup")
    public void setAPIGroup(APIGroup aPIGroup) {
        this.aPIGroup = aPIGroup;
    }

    @JsonProperty("APIGroupList")
    public APIGroupList getAPIGroupList() {
        return aPIGroupList;
    }

    @JsonProperty("APIGroupList")
    public void setAPIGroupList(APIGroupList aPIGroupList) {
        this.aPIGroupList = aPIGroupList;
    }

    @JsonProperty("BaseKubernetesList")
    public KubernetesList getBaseKubernetesList() {
        return baseKubernetesList;
    }

    @JsonProperty("BaseKubernetesList")
    public void setBaseKubernetesList(KubernetesList baseKubernetesList) {
        this.baseKubernetesList = baseKubernetesList;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("ObjectMeta")
    public ObjectMeta getObjectMeta() {
        return objectMeta;
    }

    @JsonProperty("ObjectMeta")
    public void setObjectMeta(ObjectMeta objectMeta) {
        this.objectMeta = objectMeta;
    }

    @JsonProperty("Patch")
    public Patch getPatch() {
        return patch;
    }

    @JsonProperty("Patch")
    public void setPatch(Patch patch) {
        this.patch = patch;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("StorageState")
    public StorageState getStorageState() {
        return storageState;
    }

    @JsonProperty("StorageState")
    public void setStorageState(StorageState storageState) {
        this.storageState = storageState;
    }

    @JsonProperty("StorageStateList")
    public StorageStateList getStorageStateList() {
        return storageStateList;
    }

    @JsonProperty("StorageStateList")
    public void setStorageStateList(StorageStateList storageStateList) {
        this.storageStateList = storageStateList;
    }

    @JsonProperty("StorageVersionMigration")
    public StorageVersionMigration getStorageVersionMigration() {
        return storageVersionMigration;
    }

    @JsonProperty("StorageVersionMigration")
    public void setStorageVersionMigration(StorageVersionMigration storageVersionMigration) {
        this.storageVersionMigration = storageVersionMigration;
    }

    @JsonProperty("StorageVersionMigrationList")
    public StorageVersionMigrationList getStorageVersionMigrationList() {
        return storageVersionMigrationList;
    }

    @JsonProperty("StorageVersionMigrationList")
    public void setStorageVersionMigrationList(StorageVersionMigrationList storageVersionMigrationList) {
        this.storageVersionMigrationList = storageVersionMigrationList;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void setAdditionalProperties(Map<java.lang.String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

}
