
package io.fabric8.kubernetes.api.model;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.fabric8.kubernetes.api.model.batch.v1.Job;
import io.fabric8.kubernetes.api.model.batch.v1.JobList;
import io.fabric8.kubernetes.api.model.version.Info;

@Generated("jsonschema2pojo")
public class KubeSchema {

    private APIGroup aPIGroup;
    private APIGroupList aPIGroupList;
    private KubernetesList baseKubernetesList;
    private CreateOptions createOptions;
    private io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob cronJob;
    private io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList cronJobList;
    private DeleteOptions deleteOptions;
    private GetOptions getOptions;
    private Info info;
    private Job job;
    private JobList jobList;
    private ListOptions listOptions;
    private ObjectMeta objectMeta;
    private Patch patch;
    private PatchOptions patchOptions;
    private PodTemplate podTemplateList;
    private Quantity quantity;
    private RootPaths rootPaths;
    private Status status;
    private String time;
    private TypeMeta typeMeta;
    private UpdateOptions updateOptions;
    private io.fabric8.kubernetes.api.model.batch.v1.CronJob v1CronJob;
    private io.fabric8.kubernetes.api.model.batch.v1.CronJobList v1CronJobList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public KubeSchema() {
    }

    public KubeSchema(APIGroup aPIGroup, APIGroupList aPIGroupList, KubernetesList baseKubernetesList, CreateOptions createOptions, io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob cronJob, io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList cronJobList, DeleteOptions deleteOptions, GetOptions getOptions, Info info, Job job, JobList jobList, ListOptions listOptions, ObjectMeta objectMeta, Patch patch, PatchOptions patchOptions, PodTemplate podTemplateList, Quantity quantity, RootPaths rootPaths, Status status, String time, TypeMeta typeMeta, UpdateOptions updateOptions, io.fabric8.kubernetes.api.model.batch.v1.CronJob v1CronJob, io.fabric8.kubernetes.api.model.batch.v1.CronJobList v1CronJobList) {
        super();
        this.aPIGroup = aPIGroup;
        this.aPIGroupList = aPIGroupList;
        this.baseKubernetesList = baseKubernetesList;
        this.createOptions = createOptions;
        this.cronJob = cronJob;
        this.cronJobList = cronJobList;
        this.deleteOptions = deleteOptions;
        this.getOptions = getOptions;
        this.info = info;
        this.job = job;
        this.jobList = jobList;
        this.listOptions = listOptions;
        this.objectMeta = objectMeta;
        this.patch = patch;
        this.patchOptions = patchOptions;
        this.podTemplateList = podTemplateList;
        this.quantity = quantity;
        this.rootPaths = rootPaths;
        this.status = status;
        this.time = time;
        this.typeMeta = typeMeta;
        this.updateOptions = updateOptions;
        this.v1CronJob = v1CronJob;
        this.v1CronJobList = v1CronJobList;
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

    @JsonProperty("CreateOptions")
    public CreateOptions getCreateOptions() {
        return createOptions;
    }

    @JsonProperty("CreateOptions")
    public void setCreateOptions(CreateOptions createOptions) {
        this.createOptions = createOptions;
    }

    @JsonProperty("CronJob")
    public io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob getCronJob() {
        return cronJob;
    }

    @JsonProperty("CronJob")
    public void setCronJob(io.fabric8.kubernetes.api.model.batch.v1beta1.CronJob cronJob) {
        this.cronJob = cronJob;
    }

    @JsonProperty("CronJobList")
    public io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList getCronJobList() {
        return cronJobList;
    }

    @JsonProperty("CronJobList")
    public void setCronJobList(io.fabric8.kubernetes.api.model.batch.v1beta1.CronJobList cronJobList) {
        this.cronJobList = cronJobList;
    }

    @JsonProperty("DeleteOptions")
    public DeleteOptions getDeleteOptions() {
        return deleteOptions;
    }

    @JsonProperty("DeleteOptions")
    public void setDeleteOptions(DeleteOptions deleteOptions) {
        this.deleteOptions = deleteOptions;
    }

    @JsonProperty("GetOptions")
    public GetOptions getGetOptions() {
        return getOptions;
    }

    @JsonProperty("GetOptions")
    public void setGetOptions(GetOptions getOptions) {
        this.getOptions = getOptions;
    }

    @JsonProperty("Info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("Info")
    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("Job")
    public Job getJob() {
        return job;
    }

    @JsonProperty("Job")
    public void setJob(Job job) {
        this.job = job;
    }

    @JsonProperty("JobList")
    public JobList getJobList() {
        return jobList;
    }

    @JsonProperty("JobList")
    public void setJobList(JobList jobList) {
        this.jobList = jobList;
    }

    @JsonProperty("ListOptions")
    public ListOptions getListOptions() {
        return listOptions;
    }

    @JsonProperty("ListOptions")
    public void setListOptions(ListOptions listOptions) {
        this.listOptions = listOptions;
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

    @JsonProperty("PatchOptions")
    public PatchOptions getPatchOptions() {
        return patchOptions;
    }

    @JsonProperty("PatchOptions")
    public void setPatchOptions(PatchOptions patchOptions) {
        this.patchOptions = patchOptions;
    }

    @JsonProperty("PodTemplateList")
    public PodTemplate getPodTemplateList() {
        return podTemplateList;
    }

    @JsonProperty("PodTemplateList")
    public void setPodTemplateList(PodTemplate podTemplateList) {
        this.podTemplateList = podTemplateList;
    }

    @JsonProperty("Quantity")
    public Quantity getQuantity() {
        return quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("RootPaths")
    public RootPaths getRootPaths() {
        return rootPaths;
    }

    @JsonProperty("RootPaths")
    public void setRootPaths(RootPaths rootPaths) {
        this.rootPaths = rootPaths;
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

    @JsonProperty("TypeMeta")
    public TypeMeta getTypeMeta() {
        return typeMeta;
    }

    @JsonProperty("TypeMeta")
    public void setTypeMeta(TypeMeta typeMeta) {
        this.typeMeta = typeMeta;
    }

    @JsonProperty("UpdateOptions")
    public UpdateOptions getUpdateOptions() {
        return updateOptions;
    }

    @JsonProperty("UpdateOptions")
    public void setUpdateOptions(UpdateOptions updateOptions) {
        this.updateOptions = updateOptions;
    }

    @JsonProperty("V1CronJob")
    public io.fabric8.kubernetes.api.model.batch.v1.CronJob getV1CronJob() {
        return v1CronJob;
    }

    @JsonProperty("V1CronJob")
    public void setV1CronJob(io.fabric8.kubernetes.api.model.batch.v1.CronJob v1CronJob) {
        this.v1CronJob = v1CronJob;
    }

    @JsonProperty("V1CronJobList")
    public io.fabric8.kubernetes.api.model.batch.v1.CronJobList getV1CronJobList() {
        return v1CronJobList;
    }

    @JsonProperty("V1CronJobList")
    public void setV1CronJobList(io.fabric8.kubernetes.api.model.batch.v1.CronJobList v1CronJobList) {
        this.v1CronJobList = v1CronJobList;
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
