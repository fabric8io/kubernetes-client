
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.version.Info;
import io.fabric8.openshift.api.model.tuned.v1.Profile;
import io.fabric8.openshift.api.model.tuned.v1.ProfileList;
import io.fabric8.openshift.api.model.tuned.v1.Tuned;
import io.fabric8.openshift.api.model.tuned.v1.TunedList;

@Generated("jsonschema2pojo")
public class ValidationSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private Info info;
    private ObjectMeta objectMeta;
    private Patch patch;
    private Profile profile;
    private ProfileList profileList;
    private Status status;
    private String time;
    private Tuned tuned;
    private TunedList tunedList;
    private TypeMeta typeMeta;
    @JsonIgnore
    private Map<java.lang.String, Object> additionalProperties = new LinkedHashMap<java.lang.String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public ValidationSchema() {
    }

    public ValidationSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, Info info, ObjectMeta objectMeta, Patch patch, Profile profile, ProfileList profileList, Status status, String time, Tuned tuned, TunedList tunedList, TypeMeta typeMeta) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.info = info;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.profile = profile;
        this.profileList = profileList;
        this.status = status;
        this.time = time;
        this.tuned = tuned;
        this.tunedList = tunedList;
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

    @JsonProperty("Profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("Profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @JsonProperty("ProfileList")
    public ProfileList getProfileList() {
        return profileList;
    }

    @JsonProperty("ProfileList")
    public void setProfileList(ProfileList profileList) {
        this.profileList = profileList;
    }

    @JsonProperty("Status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("Time")
    public String getTime() {
        return time;
    }

    @JsonProperty("Time")
    public void setTime(String time) {
        this.time = time;
    }

    @JsonProperty("Tuned")
    public Tuned getTuned() {
        return tuned;
    }

    @JsonProperty("Tuned")
    public void setTuned(Tuned tuned) {
        this.tuned = tuned;
    }

    @JsonProperty("TunedList")
    public TunedList getTunedList() {
        return tunedList;
    }

    @JsonProperty("TunedList")
    public void setTunedList(TunedList tunedList) {
        this.tunedList = tunedList;
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
