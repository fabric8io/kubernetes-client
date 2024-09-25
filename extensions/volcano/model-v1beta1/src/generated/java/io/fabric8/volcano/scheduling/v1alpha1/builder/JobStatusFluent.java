package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.JobStatus;
import io.fabric8.kubernetes.api.builder.BaseFluent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午5:19
 * @FileName：JobStatusFluent
 * @Description:
 */
public class JobStatusFluent<A extends JobStatusFluent<A>> extends BaseFluent<A> {
    public JobStatusFluent() {
    }

    public JobStatusFluent(JobStatus instance) {
        this.copyInstance(instance);
    }
    private Integer inqueue;
    private Integer pending;
    private Integer running;
    private String state;
    private Integer unknown;
    private Map<String,Object> additionalProperties;

    protected void copyInstance(JobStatus instance) {
        instance = (instance != null ? instance : new JobStatus());
        if (instance != null) {
            this.withInqueue(instance.getInqueue());
            this.withPending(instance.getPending());
            this.withRunning(instance.getRunning());
            this.withState(instance.getState());
            this.withUnknown(instance.getUnknown());
            this.withAdditionalProperties(instance.getAdditionalProperties());
        }
    }

    public Integer getInqueue() {
        return this.inqueue;
    }

    public A withInqueue(Integer inqueue) {
        this.inqueue = inqueue;
        return (A) this;
    }

    public boolean hasInqueue() {
        return this.inqueue != null;
    }

    public Integer getPending() {
        return this.pending;
    }

    public A withPending(Integer pending) {
        this.pending = pending;
        return (A) this;
    }

    public boolean hasPending() {
        return this.pending != null;
    }

    public Integer getRunning() {
        return this.running;
    }

    public A withRunning(Integer running) {
        this.running = running;
        return (A) this;
    }

    public boolean hasRunning() {
        return this.running != null;
    }

    public String getState() {
        return this.state;
    }

    public A withState(String state) {
        this.state = state;
        return (A) this;
    }

    public boolean hasState() {
        return this.state != null;
    }

    public Integer getUnknown() {
        return this.unknown;
    }

    public A withUnknown(Integer unknown) {
        this.unknown = unknown;
        return (A) this;
    }

    public boolean hasUnknown() {
        return this.unknown != null;
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

    public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
        if (additionalProperties == null) {
            this.additionalProperties = null;
        } else {
            this.additionalProperties = new LinkedHashMap(additionalProperties);
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
        JobStatusFluent that = (JobStatusFluent) o;
        if (!java.util.Objects.equals(inqueue, that.inqueue)) return false;
        if (!java.util.Objects.equals(pending, that.pending)) return false;
        if (!java.util.Objects.equals(running, that.running)) return false;
        if (!java.util.Objects.equals(state, that.state)) return false;
        if (!java.util.Objects.equals(unknown, that.unknown)) return false;
        if (!java.util.Objects.equals(additionalProperties, that.additionalProperties)) return false;
        return true;
    }

    public int hashCode() {
        return java.util.Objects.hash(inqueue,  pending,  running,  state,  unknown,  additionalProperties,  super.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (inqueue != null) { sb.append("inqueue:"); sb.append(inqueue + ","); }
        if (pending != null) { sb.append("pending:"); sb.append(pending + ","); }
        if (running != null) { sb.append("running:"); sb.append(running + ","); }
        if (state != null) { sb.append("state:"); sb.append(state + ","); }
        if (unknown != null) { sb.append("unknown:"); sb.append(unknown + ","); }
        if (additionalProperties != null && !additionalProperties.isEmpty()) { sb.append("additionalProperties:"); sb.append(additionalProperties); }
        sb.append("}");
        return sb.toString();
    }


}
