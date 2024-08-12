package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.JobSpec;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.model.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:13
 * @FileName：JobSpecFluent
 * @Description:
 */
public class JobSpecFluent<A extends JobSpecFluent<A>> extends BaseFluent<A> {
    public JobSpecFluent() {
    }

    public JobSpecFluent(JobSpec instance) {
        this.copyInstance(instance);
    }
    private Map<String, Quantity> capability;
    private Boolean reclaimable;
    private Integer weight;
    private Integer minAvailable;
    private String schedulerName;
    private String priorityClassName;
    private Integer maxRetry;
    private String queue;
    private ArrayList<VolumeMountBuilder> volumeMounts = new ArrayList<VolumeMountBuilder>();
    private ArrayList<VolumeBuilder> volumes = new ArrayList<VolumeBuilder>();
//    private ArrayList<TaskBuilder> tasks = new ArrayList<TaskBuilder>();
    private Map<String,Object> tasks;
    private Map<String,Object> additionalProperties;
    private Map<String,Object> policies;

    protected void copyInstance(JobSpec instance) {
        instance = (instance != null ? instance : new JobSpec());
        if (instance != null) {
//            this.withCapability(instance.getCapability());
//            this.withReclaimable(instance.getReclaimable());
//            this.withWeight(instance.getWeight());
            this.withMinAvailable(instance.getMinAvailable());
            this.withSchedulerName(instance.getSchedulerName());
            this.withQueue(instance.getQueue());
//            this.withVolumes(instance.getVolumes());
            this.withTasks(instance.getTasks());
//            this.withVolumeMounts(instance.getVolumeMounts());
//            this.withAdditionalProperties(instance.getAdditionalProperties());
            this.withPolicies(instance.getPolicies());
        }
    }

    public A addToCapability(String key,Quantity value) {
        if(this.capability == null && key != null && value != null) { this.capability = new LinkedHashMap(); }
        if(key != null && value != null) {this.capability.put(key, value);} return (A)this;
    }

    public A addToCapability(Map<String,Quantity> map) {
        if(this.capability == null && map != null) { this.capability = new LinkedHashMap(); }
        if(map != null) { this.capability.putAll(map);} return (A)this;
    }

    public A removeFromCapability(String key) {
        if(this.capability == null) { return (A) this; }
        if(key != null && this.capability != null) {this.capability.remove(key);} return (A)this;
    }

    public A removeFromCapability(Map<String,Quantity> map) {
        if(this.capability == null) { return (A) this; }
        if(map != null) { for(Object key : map.keySet()) {if (this.capability != null){this.capability.remove(key);}}} return (A)this;
    }

    public Map<String,Quantity> getCapability() {
        return this.capability;
    }

    public <K,V>A withCapability(Map<String,Quantity> capability) {
        if (capability == null) {
            this.capability = null;
        } else {
            this.capability = new LinkedHashMap(capability);
        }
        return (A) this;
    }

    public boolean hasCapability() {
        return this.capability != null;
    }

    public Boolean getReclaimable() {
        return this.reclaimable;
    }

    public A withReclaimable(Boolean reclaimable) {
        this.reclaimable = reclaimable;
        return (A) this;
    }

    public boolean hasReclaimable() {
        return this.reclaimable != null;
    }

    public Integer getWeight() {
        return this.weight;
    }

    public A withWeight(Integer weight) {
        this.weight = weight;
        return (A) this;
    }

    public Integer getMinAvailable() {
        return this.minAvailable;
    }

    public A withMinAvailable(Integer minAvailable) {
        this.minAvailable = minAvailable;
        return (A) this;
    }

    public String getSchedulerName() {
        return this.schedulerName;
    }

    public A withSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
        return (A) this;
    }

    public List<Volume> buildVolumes() {
        return this.volumes != null ? build(volumes) : null;
    }

    public A withVolumes(List<Volume> volumes) {
        if (this.volumes != null) {
            this._visitables.get("volumes").clear();
        }
        if (volumes != null) {
            this.volumes = new ArrayList();
            for (Volume item : volumes) {
                this.addToVolumes(item);
            }
        } else {
            this.volumes = null;
        }
        return (A) this;
    }
    public List<VolumeMount> buildVolumeMounts() {
        return this.volumeMounts != null ? build(volumeMounts) : null;
    }

    public A withVolumeMounts(List<VolumeMount> volumeMounts) {
        if (this.volumeMounts != null) {
            this._visitables.get("volumeMounts").clear();
        }
        if (volumeMounts != null) {
            this.volumeMounts = new ArrayList();
            for (VolumeMount item : volumeMounts) {
                this.addToVolumeMounts(item);
            }
        } else {
            this.volumeMounts = null;
        }
        return (A) this;
    }

    public A addToVolumeMounts(VolumeMount... items) {
        if (this.volumeMounts == null) {this.volumeMounts = new ArrayList<VolumeMountBuilder>();}
        for (VolumeMount item : items) {VolumeMountBuilder builder = new VolumeMountBuilder(item);_visitables.get("volumeMounts").add(builder);this.volumeMounts.add(builder);} return (A)this;
    }


    public String getQueue() {
        return this.queue;
    }

    public A withQueue(String queue) {
        this.queue = queue;
        return (A) this;
    }

    public A withPriorityClassName(String priorityClassName) {
        this.priorityClassName = priorityClassName;
        return (A) this;
    }

    public A withMaxRetry(Integer maxRetry) {
        this.maxRetry = maxRetry;
        return (A) this;
    }

//    public LinkedHashMap<String,Object> buildTasks() {
//        return this.tasks != null ? build(tasks) : null;
//    }

//    public A withTasks(List<Task> tasks) {
//        if (this.tasks != null) {
//            this._visitables.get("tasks").clear();
//        }
//        if (tasks != null) {
//            this.tasks = new ArrayList();
//            for (Task item : tasks) {
//                this.addToTasks(item);
//            }
//        } else {
//            this.tasks = null;
//        }
//        return (A) this;
//    }

    public A addToVolumes(Volume... items) {
        if (this.volumes == null) {this.volumes = new ArrayList<VolumeBuilder>();}
        for (Volume item : items) {VolumeBuilder builder = new VolumeBuilder(item);_visitables.get("volumes").add(builder);this.volumes.add(builder);} return (A)this;
    }

//    public A addToTasks(Task... items) {
//        if (this.tasks == null) {this.tasks = new ArrayList<TaskBuilder>();}
//        for (Task item : items) {TaskBuilder builder = new TaskBuilder(item);_visitables.get("tasks").add(builder);this.tasks.add(builder);} return (A)this;
//    }

    public boolean hasWeight() {
        return this.weight != null;
    }

    public boolean hasMinAvailable() {
        return this.minAvailable != null;
    }

    public A addToAdditionalProperties(String key,Object value) {
        if(this.additionalProperties == null && key != null && value != null) { this.additionalProperties = new LinkedHashMap(); }
        if(key != null && value != null) {this.additionalProperties.put(key, value);} return (A)this;
    }

    public A addToAdditionalProperties(Map<String,Object> map) {
        if(this.additionalProperties == null && map != null) { this.additionalProperties = new LinkedHashMap(); }
        if(map != null) { this.additionalProperties.putAll(map);} return (A)this;
    }

    public A removeFromAdditionalProperties(String key) {
        if(this.additionalProperties == null) { return (A) this; }
        if(key != null && this.additionalProperties != null) {this.additionalProperties.remove(key);} return (A)this;
    }

    public A removeFromAdditionalProperties(Map<String,Object> map) {
        if(this.additionalProperties == null) { return (A) this; }
        if(map != null) { for(Object key : map.keySet()) {if (this.additionalProperties != null){this.additionalProperties.remove(key);}}} return (A)this;
    }

    public Map<String,Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public Map<String,Object> getPolicies() {
        return this.policies;
    }

    public Map<String,Object> getTasks() {
        return this.tasks;
    }

    public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
        if (additionalProperties == null) {
            this.additionalProperties = null;
        } else {
            this.additionalProperties = new LinkedHashMap(additionalProperties);
        }
        return (A) this;
    }

    public <K,V>A withPolicies(Map<String,Object> policies) {
        if (policies == null) {
            this.policies = null;
        } else {
            this.policies = new LinkedHashMap(policies);
        }
        return (A) this;
    }

    public <K,V>A withTasks(Map<String,Object> tasks) {
        if (tasks == null) {
            this.tasks = null;
        } else {
            this.tasks = new LinkedHashMap(tasks);
        }
        return (A) this;
    }

    public boolean hasAdditionalProperties() {
        return this.additionalProperties != null;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        JobSpecFluent that = (JobSpecFluent) o;
        if (!java.util.Objects.equals(capability, that.capability)) return false;
        if (!java.util.Objects.equals(reclaimable, that.reclaimable)) return false;
        if (!java.util.Objects.equals(weight, that.weight)) return false;
        if (!java.util.Objects.equals(minAvailable, that.minAvailable)) return false;
        if (!java.util.Objects.equals(additionalProperties, that.additionalProperties)) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(capability,  reclaimable,  weight, minAvailable, additionalProperties,  super.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (capability != null && !capability.isEmpty()) { sb.append("capability:"); sb.append(capability + ","); }
        if (reclaimable != null) { sb.append("reclaimable:"); sb.append(reclaimable + ","); }
        if (weight != null) { sb.append("weight:"); sb.append(weight + ","); }
        if (minAvailable != null) { sb.append("minAvailable:"); sb.append(minAvailable + ","); }
        if (additionalProperties != null && !additionalProperties.isEmpty()) { sb.append("additionalProperties:"); sb.append(additionalProperties); }
        sb.append("}");
        return sb.toString();
    }

    public A withReclaimable() {
        return withReclaimable(true);
    }


}
