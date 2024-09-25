package io.fabric8.volcano.scheduling.v1alpha1.builder;

import io.fabric8.volcano.scheduling.v1alpha1.Job;
import io.fabric8.volcano.scheduling.v1alpha1.JobList;
import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.ListMeta;

import java.util.*;
import java.util.function.Predicate;

/**
 * @Author: mf
 * @Date: 2024/7/4  下午6:31
 * @FileName：JobListFluent
 * @Description:
 */
@SuppressWarnings("unchecked")
public class JobListFluent<A extends JobListFluent<A>> extends BaseFluent<A> {
    public JobListFluent() {
    }

    public JobListFluent(JobList instance) {
        this.copyInstance(instance);
    }
    private String apiVersion;
    private ArrayList<JobBuilder> items = new ArrayList<JobBuilder>();
    private String kind;
    private ListMeta metadata;
    private Map<String,Object> additionalProperties;

    protected void copyInstance(JobList instance) {
        instance = (instance != null ? instance : new JobList());
        if (instance != null) {
            this.withApiVersion(instance.getApiVersion());
            this.withItems(instance.getItems());
            this.withKind(instance.getKind());
            this.withMetadata(instance.getMetadata());
            this.withAdditionalProperties(instance.getAdditionalProperties());
        }
    }

    public String getApiVersion() {
        return this.apiVersion;
    }

    public A withApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return (A) this;
    }

    public boolean hasApiVersion() {
        return this.apiVersion != null;
    }

    public A addToItems(int index, Job item) {
        if (this.items == null) {this.items = new ArrayList<JobBuilder>();}
        JobBuilder builder = new JobBuilder(item);
        if (index < 0 || index >= items.size()) { _visitables.get("items").add(builder); items.add(builder); } else { _visitables.get("items").add(index, builder); items.add(index, builder);}
        return (A)this;
    }

    public A setToItems(int index,Job item) {
        if (this.items == null) {this.items = new ArrayList<JobBuilder>();}
        JobBuilder builder = new JobBuilder(item);
        if (index < 0 || index >= items.size()) { _visitables.get("items").add(builder); items.add(builder); } else { _visitables.get("items").set(index, builder); items.set(index, builder);}
        return (A)this;
    }

    public A addToItems(Job... items) {
        if (this.items == null) {this.items = new ArrayList<JobBuilder>();}
        for (Job item : items) {JobBuilder builder = new JobBuilder(item);_visitables.get("items").add(builder);this.items.add(builder);} return (A)this;
    }

    public A addAllToItems(Collection<Job> items) {
        if (this.items == null) {this.items = new ArrayList<JobBuilder>();}
        for (Job item : items) {JobBuilder builder = new JobBuilder(item);_visitables.get("items").add(builder);this.items.add(builder);} return (A)this;
    }

    public A removeFromItems(Job... items) {
        if (this.items == null) return (A)this;
        for (Job item : items) {JobBuilder builder = new JobBuilder(item);_visitables.get("items").remove(builder); this.items.remove(builder);} return (A)this;
    }

    public A removeAllFromItems(Collection<Job> items) {
        if (this.items == null) return (A)this;
        for (Job item : items) {JobBuilder builder = new JobBuilder(item);_visitables.get("items").remove(builder); this.items.remove(builder);} return (A)this;
    }

    public A removeMatchingFromItems(Predicate<JobBuilder> predicate) {
        if (items == null) return (A) this;
        final Iterator<JobBuilder> each = items.iterator();
        final List visitables = _visitables.get("items");
        while (each.hasNext()) {
            JobBuilder builder = each.next();
            if (predicate.test(builder)) {
                visitables.remove(builder);
                each.remove();
            }
        }
        return (A)this;
    }

    public List<Job> buildItems() {
        return this.items != null ? build(items) : null;
    }

    public Job buildItem(int index) {
        return this.items.get(index).build();
    }

    public Job buildFirstItem() {
        return this.items.get(0).build();
    }

    public Job buildLastItem() {
        return this.items.get(items.size() - 1).build();
    }

    public Job buildMatchingItem(Predicate<JobBuilder> predicate) {
        for (JobBuilder item : items) {
            if (predicate.test(item)) {
                return item.build();
            }
        }
        return null;
    }

    public boolean hasMatchingItem(Predicate<JobBuilder> predicate) {
        for (JobBuilder item : items) {
            if (predicate.test(item)) {
                return true;
            }
        }
        return false;
    }

    public A withItems(List<Job> items) {
        if (this.items != null) {
            this._visitables.get("items").clear();
        }
        if (items != null) {
            this.items = new ArrayList();
            for (Job item : items) {
                this.addToItems(item);
            }
        } else {
            this.items = null;
        }
        return (A) this;
    }

    public A withItems(Job... items) {
        if (this.items != null) {
            this.items.clear();
            _visitables.remove("items");
        }
        if (items != null) {
            for (Job item : items) {
                this.addToItems(item);
            }
        }
        return (A) this;
    }

    public boolean hasItems() {
        return this.items != null && !this.items.isEmpty();
    }

    public ItemsNested<A> addNewItem() {
        return new ItemsNested(-1, null);
    }

    public ItemsNested<A> addNewItemLike(Job item) {
        return new ItemsNested(-1, item);
    }

    public ItemsNested<A> setNewItemLike(int index,Job item) {
        return new ItemsNested(index, item);
    }

    public ItemsNested<A> editItem(int index) {
        if (items.size() <= index) throw new RuntimeException("Can't edit items. Index exceeds size.");
        return setNewItemLike(index, buildItem(index));
    }

    public ItemsNested<A> editFirstItem() {
        if (items.size() == 0) throw new RuntimeException("Can't edit first items. The list is empty.");
        return setNewItemLike(0, buildItem(0));
    }

    public ItemsNested<A> editLastItem() {
        int index = items.size() - 1;
        if (index < 0) throw new RuntimeException("Can't edit last items. The list is empty.");
        return setNewItemLike(index, buildItem(index));
    }

    public ItemsNested<A> editMatchingItem(Predicate<JobBuilder> predicate) {
        int index = -1;
        for (int i=0;i<items.size();i++) {
            if (predicate.test(items.get(i))) {index = i; break;}
        }
        if (index < 0) throw new RuntimeException("Can't edit matching items. No match found.");
        return setNewItemLike(index, buildItem(index));
    }

    public String getKind() {
        return this.kind;
    }

    public A withKind(String kind) {
        this.kind = kind;
        return (A) this;
    }

    public boolean hasKind() {
        return this.kind != null;
    }

    public ListMeta getMetadata() {
        return this.metadata;
    }

    public A withMetadata(ListMeta metadata) {
        this.metadata = metadata;
        return (A) this;
    }

    public boolean hasMetadata() {
        return this.metadata != null;
    }

    public A withNewMetadata(String _continue,Long remainingItemCount,String resourceVersion,String selfLink) {
        return (A)withMetadata(new ListMeta(_continue, remainingItemCount, resourceVersion, selfLink));
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
        JobListFluent that = (JobListFluent) o;
        if (!Objects.equals(apiVersion, that.apiVersion)) return false;
        if (!Objects.equals(items, that.items)) return false;
        if (!Objects.equals(kind, that.kind)) return false;
        if (!Objects.equals(metadata, that.metadata)) return false;
        if (!Objects.equals(additionalProperties, that.additionalProperties)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hash(apiVersion,  items,  kind,  metadata,  additionalProperties,  super.hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (apiVersion != null) { sb.append("apiVersion:"); sb.append(apiVersion + ","); }
        if (items != null && !items.isEmpty()) { sb.append("items:"); sb.append(items + ","); }
        if (kind != null) { sb.append("kind:"); sb.append(kind + ","); }
        if (metadata != null) { sb.append("metadata:"); sb.append(metadata + ","); }
        if (additionalProperties != null && !additionalProperties.isEmpty()) { sb.append("additionalProperties:"); sb.append(additionalProperties); }
        sb.append("}");
        return sb.toString();
    }
    public class ItemsNested<N> extends JobFluent<ItemsNested<N>> implements Nested<N> {
        ItemsNested(int index,Job item) {
            this.index = index;
            this.builder = new JobBuilder(this, item);
        }
        JobBuilder builder;
        int index;

        public N and() {
            return (N) JobListFluent.this.setToItems(index,builder.build());
        }

        public N endItem() {
            return and();
        }


    }

}
