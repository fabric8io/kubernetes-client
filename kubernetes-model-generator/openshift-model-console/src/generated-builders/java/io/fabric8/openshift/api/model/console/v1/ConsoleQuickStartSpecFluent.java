package io.fabric8.openshift.api.model.console.v1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.authorization.v1.ResourceAttributes;
import java.lang.Integer;
import java.lang.Object;
import java.lang.RuntimeException;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class ConsoleQuickStartSpecFluent<A extends io.fabric8.openshift.api.model.console.v1.ConsoleQuickStartSpecFluent<A>> extends BaseFluent<A>{

  private List<ResourceAttributes> accessReviewResources = new ArrayList<ResourceAttributes>();
  private Map<String,Object> additionalProperties;
  private String conclusion;
  private String description;
  private String displayName;
  private Integer durationMinutes;
  private String icon;
  private String introduction;
  private List<String> nextQuickStart = new ArrayList<String>();
  private List<String> prerequisites = new ArrayList<String>();
  private List<String> tags = new ArrayList<String>();
  private ArrayList<ConsoleQuickStartTaskBuilder> tasks = new ArrayList<ConsoleQuickStartTaskBuilder>();

  public ConsoleQuickStartSpecFluent() {
  }
  
  public ConsoleQuickStartSpecFluent(ConsoleQuickStartSpec instance) {
    this.copyInstance(instance);
  }

  public A addAllToAccessReviewResources(Collection<ResourceAttributes> items) {
    if (this.accessReviewResources == null) {
      this.accessReviewResources = new ArrayList();
    }
    for (ResourceAttributes item : items) {
      this.accessReviewResources.add(item);
    }
    return (A) this;
  }
  
  public A addAllToNextQuickStart(Collection<String> items) {
    if (this.nextQuickStart == null) {
      this.nextQuickStart = new ArrayList();
    }
    for (String item : items) {
      this.nextQuickStart.add(item);
    }
    return (A) this;
  }
  
  public A addAllToPrerequisites(Collection<String> items) {
    if (this.prerequisites == null) {
      this.prerequisites = new ArrayList();
    }
    for (String item : items) {
      this.prerequisites.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTags(Collection<String> items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addAllToTasks(Collection<ConsoleQuickStartTask> items) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    for (ConsoleQuickStartTask item : items) {
        ConsoleQuickStartTaskBuilder builder = new ConsoleQuickStartTaskBuilder(item);
        _visitables.get("tasks").add(builder);
        this.tasks.add(builder);
    }
    return (A) this;
  }
  
  public TasksNested<A> addNewTask() {
    return new TasksNested(-1, null);
  }
  
  public TasksNested<A> addNewTaskLike(ConsoleQuickStartTask item) {
    return new TasksNested(-1, item);
  }
  
  public A addToAccessReviewResources(ResourceAttributes... items) {
    if (this.accessReviewResources == null) {
      this.accessReviewResources = new ArrayList();
    }
    for (ResourceAttributes item : items) {
      this.accessReviewResources.add(item);
    }
    return (A) this;
  }
  
  public A addToAccessReviewResources(int index,ResourceAttributes item) {
    if (this.accessReviewResources == null) {
      this.accessReviewResources = new ArrayList();
    }
    this.accessReviewResources.add(index, item);
    return (A) this;
  }
  
  public A addToAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null && map != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (map != null) {
      this.additionalProperties.putAll(map);
    }
    return (A) this;
  }
  
  public A addToAdditionalProperties(String key,Object value) {
    if (this.additionalProperties == null && key != null && value != null) {
      this.additionalProperties = new LinkedHashMap();
    }
    if (key != null && value != null) {
      this.additionalProperties.put(key, value);
    }
    return (A) this;
  }
  
  public A addToNextQuickStart(String... items) {
    if (this.nextQuickStart == null) {
      this.nextQuickStart = new ArrayList();
    }
    for (String item : items) {
      this.nextQuickStart.add(item);
    }
    return (A) this;
  }
  
  public A addToNextQuickStart(int index,String item) {
    if (this.nextQuickStart == null) {
      this.nextQuickStart = new ArrayList();
    }
    this.nextQuickStart.add(index, item);
    return (A) this;
  }
  
  public A addToPrerequisites(String... items) {
    if (this.prerequisites == null) {
      this.prerequisites = new ArrayList();
    }
    for (String item : items) {
      this.prerequisites.add(item);
    }
    return (A) this;
  }
  
  public A addToPrerequisites(int index,String item) {
    if (this.prerequisites == null) {
      this.prerequisites = new ArrayList();
    }
    this.prerequisites.add(index, item);
    return (A) this;
  }
  
  public A addToTags(String... items) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    for (String item : items) {
      this.tags.add(item);
    }
    return (A) this;
  }
  
  public A addToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.add(index, item);
    return (A) this;
  }
  
  public A addToTasks(ConsoleQuickStartTask... items) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    for (ConsoleQuickStartTask item : items) {
        ConsoleQuickStartTaskBuilder builder = new ConsoleQuickStartTaskBuilder(item);
        _visitables.get("tasks").add(builder);
        this.tasks.add(builder);
    }
    return (A) this;
  }
  
  public A addToTasks(int index,ConsoleQuickStartTask item) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    ConsoleQuickStartTaskBuilder builder = new ConsoleQuickStartTaskBuilder(item);
    if (index < 0 || index >= tasks.size()) {
        _visitables.get("tasks").add(builder);
        tasks.add(builder);
    } else {
        _visitables.get("tasks").add(builder);
        tasks.add(index, builder);
    }
    return (A) this;
  }
  
  public ConsoleQuickStartTask buildFirstTask() {
    return this.tasks.get(0).build();
  }
  
  public ConsoleQuickStartTask buildLastTask() {
    return this.tasks.get(tasks.size() - 1).build();
  }
  
  public ConsoleQuickStartTask buildMatchingTask(Predicate<ConsoleQuickStartTaskBuilder> predicate) {
      for (ConsoleQuickStartTaskBuilder item : tasks) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public ConsoleQuickStartTask buildTask(int index) {
    return this.tasks.get(index).build();
  }
  
  public List<ConsoleQuickStartTask> buildTasks() {
    return this.tasks != null ? build(tasks) : null;
  }
  
  protected void copyInstance(ConsoleQuickStartSpec instance) {
    instance = instance != null ? instance : new ConsoleQuickStartSpec();
    if (instance != null) {
        this.withAccessReviewResources(instance.getAccessReviewResources());
        this.withConclusion(instance.getConclusion());
        this.withDescription(instance.getDescription());
        this.withDisplayName(instance.getDisplayName());
        this.withDurationMinutes(instance.getDurationMinutes());
        this.withIcon(instance.getIcon());
        this.withIntroduction(instance.getIntroduction());
        this.withNextQuickStart(instance.getNextQuickStart());
        this.withPrerequisites(instance.getPrerequisites());
        this.withTags(instance.getTags());
        this.withTasks(instance.getTasks());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public TasksNested<A> editFirstTask() {
    if (tasks.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "tasks"));
    }
    return this.setNewTaskLike(0, this.buildTask(0));
  }
  
  public TasksNested<A> editLastTask() {
    int index = tasks.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public TasksNested<A> editMatchingTask(Predicate<ConsoleQuickStartTaskBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < tasks.size();i++) {
      if (predicate.test(tasks.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public TasksNested<A> editTask(int index) {
    if (tasks.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "tasks"));
    }
    return this.setNewTaskLike(index, this.buildTask(index));
  }
  
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    if (!(super.equals(o))) {
      return false;
    }
    ConsoleQuickStartSpecFluent that = (ConsoleQuickStartSpecFluent) o;
    if (!(Objects.equals(accessReviewResources, that.accessReviewResources))) {
      return false;
    }
    if (!(Objects.equals(conclusion, that.conclusion))) {
      return false;
    }
    if (!(Objects.equals(description, that.description))) {
      return false;
    }
    if (!(Objects.equals(displayName, that.displayName))) {
      return false;
    }
    if (!(Objects.equals(durationMinutes, that.durationMinutes))) {
      return false;
    }
    if (!(Objects.equals(icon, that.icon))) {
      return false;
    }
    if (!(Objects.equals(introduction, that.introduction))) {
      return false;
    }
    if (!(Objects.equals(nextQuickStart, that.nextQuickStart))) {
      return false;
    }
    if (!(Objects.equals(prerequisites, that.prerequisites))) {
      return false;
    }
    if (!(Objects.equals(tags, that.tags))) {
      return false;
    }
    if (!(Objects.equals(tasks, that.tasks))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public ResourceAttributes getAccessReviewResource(int index) {
    return this.accessReviewResources.get(index);
  }
  
  public List<ResourceAttributes> getAccessReviewResources() {
    return this.accessReviewResources;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getConclusion() {
    return this.conclusion;
  }
  
  public String getDescription() {
    return this.description;
  }
  
  public String getDisplayName() {
    return this.displayName;
  }
  
  public Integer getDurationMinutes() {
    return this.durationMinutes;
  }
  
  public ResourceAttributes getFirstAccessReviewResource() {
    return this.accessReviewResources.get(0);
  }
  
  public String getFirstNextQuickStart() {
    return this.nextQuickStart.get(0);
  }
  
  public String getFirstPrerequisite() {
    return this.prerequisites.get(0);
  }
  
  public String getFirstTag() {
    return this.tags.get(0);
  }
  
  public String getIcon() {
    return this.icon;
  }
  
  public String getIntroduction() {
    return this.introduction;
  }
  
  public ResourceAttributes getLastAccessReviewResource() {
    return this.accessReviewResources.get(accessReviewResources.size() - 1);
  }
  
  public String getLastNextQuickStart() {
    return this.nextQuickStart.get(nextQuickStart.size() - 1);
  }
  
  public String getLastPrerequisite() {
    return this.prerequisites.get(prerequisites.size() - 1);
  }
  
  public String getLastTag() {
    return this.tags.get(tags.size() - 1);
  }
  
  public ResourceAttributes getMatchingAccessReviewResource(Predicate<ResourceAttributes> predicate) {
      for (ResourceAttributes item : accessReviewResources) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingNextQuickStart(Predicate<String> predicate) {
      for (String item : nextQuickStart) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingPrerequisite(Predicate<String> predicate) {
      for (String item : prerequisites) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public List<String> getNextQuickStart() {
    return this.nextQuickStart;
  }
  
  public String getNextQuickStart(int index) {
    return this.nextQuickStart.get(index);
  }
  
  public String getPrerequisite(int index) {
    return this.prerequisites.get(index);
  }
  
  public List<String> getPrerequisites() {
    return this.prerequisites;
  }
  
  public String getTag(int index) {
    return this.tags.get(index);
  }
  
  public List<String> getTags() {
    return this.tags;
  }
  
  public boolean hasAccessReviewResources() {
    return this.accessReviewResources != null && !(this.accessReviewResources.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasConclusion() {
    return this.conclusion != null;
  }
  
  public boolean hasDescription() {
    return this.description != null;
  }
  
  public boolean hasDisplayName() {
    return this.displayName != null;
  }
  
  public boolean hasDurationMinutes() {
    return this.durationMinutes != null;
  }
  
  public boolean hasIcon() {
    return this.icon != null;
  }
  
  public boolean hasIntroduction() {
    return this.introduction != null;
  }
  
  public boolean hasMatchingAccessReviewResource(Predicate<ResourceAttributes> predicate) {
      for (ResourceAttributes item : accessReviewResources) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingNextQuickStart(Predicate<String> predicate) {
      for (String item : nextQuickStart) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingPrerequisite(Predicate<String> predicate) {
      for (String item : prerequisites) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTag(Predicate<String> predicate) {
      for (String item : tags) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingTask(Predicate<ConsoleQuickStartTaskBuilder> predicate) {
      for (ConsoleQuickStartTaskBuilder item : tasks) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasNextQuickStart() {
    return this.nextQuickStart != null && !(this.nextQuickStart.isEmpty());
  }
  
  public boolean hasPrerequisites() {
    return this.prerequisites != null && !(this.prerequisites.isEmpty());
  }
  
  public boolean hasTags() {
    return this.tags != null && !(this.tags.isEmpty());
  }
  
  public boolean hasTasks() {
    return this.tasks != null && !(this.tasks.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(accessReviewResources, conclusion, description, displayName, durationMinutes, icon, introduction, nextQuickStart, prerequisites, tags, tasks, additionalProperties);
  }
  
  public A removeAllFromAccessReviewResources(Collection<ResourceAttributes> items) {
    if (this.accessReviewResources == null) {
      return (A) this;
    }
    for (ResourceAttributes item : items) {
      this.accessReviewResources.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromNextQuickStart(Collection<String> items) {
    if (this.nextQuickStart == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nextQuickStart.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromPrerequisites(Collection<String> items) {
    if (this.prerequisites == null) {
      return (A) this;
    }
    for (String item : items) {
      this.prerequisites.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTags(Collection<String> items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeAllFromTasks(Collection<ConsoleQuickStartTask> items) {
    if (this.tasks == null) {
      return (A) this;
    }
    for (ConsoleQuickStartTask item : items) {
        ConsoleQuickStartTaskBuilder builder = new ConsoleQuickStartTaskBuilder(item);
        _visitables.get("tasks").remove(builder);
        this.tasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromAccessReviewResources(ResourceAttributes... items) {
    if (this.accessReviewResources == null) {
      return (A) this;
    }
    for (ResourceAttributes item : items) {
      this.accessReviewResources.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(String key) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (key != null && this.additionalProperties != null) {
      this.additionalProperties.remove(key);
    }
    return (A) this;
  }
  
  public A removeFromAdditionalProperties(Map<String,Object> map) {
    if (this.additionalProperties == null) {
      return (A) this;
    }
    if (map != null) {
      for (Object key : map.keySet()) {
        if (this.additionalProperties != null) {
          this.additionalProperties.remove(key);
        }
      }
    }
    return (A) this;
  }
  
  public A removeFromNextQuickStart(String... items) {
    if (this.nextQuickStart == null) {
      return (A) this;
    }
    for (String item : items) {
      this.nextQuickStart.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromPrerequisites(String... items) {
    if (this.prerequisites == null) {
      return (A) this;
    }
    for (String item : items) {
      this.prerequisites.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTags(String... items) {
    if (this.tags == null) {
      return (A) this;
    }
    for (String item : items) {
      this.tags.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromTasks(ConsoleQuickStartTask... items) {
    if (this.tasks == null) {
      return (A) this;
    }
    for (ConsoleQuickStartTask item : items) {
        ConsoleQuickStartTaskBuilder builder = new ConsoleQuickStartTaskBuilder(item);
        _visitables.get("tasks").remove(builder);
        this.tasks.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromTasks(Predicate<ConsoleQuickStartTaskBuilder> predicate) {
    if (tasks == null) {
      return (A) this;
    }
    Iterator<ConsoleQuickStartTaskBuilder> each = tasks.iterator();
    List visitables = _visitables.get("tasks");
    while (each.hasNext()) {
        ConsoleQuickStartTaskBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public TasksNested<A> setNewTaskLike(int index,ConsoleQuickStartTask item) {
    return new TasksNested(index, item);
  }
  
  public A setToAccessReviewResources(int index,ResourceAttributes item) {
    if (this.accessReviewResources == null) {
      this.accessReviewResources = new ArrayList();
    }
    this.accessReviewResources.set(index, item);
    return (A) this;
  }
  
  public A setToNextQuickStart(int index,String item) {
    if (this.nextQuickStart == null) {
      this.nextQuickStart = new ArrayList();
    }
    this.nextQuickStart.set(index, item);
    return (A) this;
  }
  
  public A setToPrerequisites(int index,String item) {
    if (this.prerequisites == null) {
      this.prerequisites = new ArrayList();
    }
    this.prerequisites.set(index, item);
    return (A) this;
  }
  
  public A setToTags(int index,String item) {
    if (this.tags == null) {
      this.tags = new ArrayList();
    }
    this.tags.set(index, item);
    return (A) this;
  }
  
  public A setToTasks(int index,ConsoleQuickStartTask item) {
    if (this.tasks == null) {
      this.tasks = new ArrayList();
    }
    ConsoleQuickStartTaskBuilder builder = new ConsoleQuickStartTaskBuilder(item);
    if (index < 0 || index >= tasks.size()) {
        _visitables.get("tasks").add(builder);
        tasks.add(builder);
    } else {
        _visitables.get("tasks").add(builder);
        tasks.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(accessReviewResources == null) && !(accessReviewResources.isEmpty())) {
        sb.append("accessReviewResources:");
        sb.append(accessReviewResources);
        sb.append(",");
    }
    if (!(conclusion == null)) {
        sb.append("conclusion:");
        sb.append(conclusion);
        sb.append(",");
    }
    if (!(description == null)) {
        sb.append("description:");
        sb.append(description);
        sb.append(",");
    }
    if (!(displayName == null)) {
        sb.append("displayName:");
        sb.append(displayName);
        sb.append(",");
    }
    if (!(durationMinutes == null)) {
        sb.append("durationMinutes:");
        sb.append(durationMinutes);
        sb.append(",");
    }
    if (!(icon == null)) {
        sb.append("icon:");
        sb.append(icon);
        sb.append(",");
    }
    if (!(introduction == null)) {
        sb.append("introduction:");
        sb.append(introduction);
        sb.append(",");
    }
    if (!(nextQuickStart == null) && !(nextQuickStart.isEmpty())) {
        sb.append("nextQuickStart:");
        sb.append(nextQuickStart);
        sb.append(",");
    }
    if (!(prerequisites == null) && !(prerequisites.isEmpty())) {
        sb.append("prerequisites:");
        sb.append(prerequisites);
        sb.append(",");
    }
    if (!(tags == null) && !(tags.isEmpty())) {
        sb.append("tags:");
        sb.append(tags);
        sb.append(",");
    }
    if (!(tasks == null) && !(tasks.isEmpty())) {
        sb.append("tasks:");
        sb.append(tasks);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withAccessReviewResources(List<ResourceAttributes> accessReviewResources) {
    if (accessReviewResources != null) {
        this.accessReviewResources = new ArrayList();
        for (ResourceAttributes item : accessReviewResources) {
          this.addToAccessReviewResources(item);
        }
    } else {
      this.accessReviewResources = null;
    }
    return (A) this;
  }
  
  public A withAccessReviewResources(ResourceAttributes... accessReviewResources) {
    if (this.accessReviewResources != null) {
        this.accessReviewResources.clear();
        _visitables.remove("accessReviewResources");
    }
    if (accessReviewResources != null) {
      for (ResourceAttributes item : accessReviewResources) {
        this.addToAccessReviewResources(item);
      }
    }
    return (A) this;
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withConclusion(String conclusion) {
    this.conclusion = conclusion;
    return (A) this;
  }
  
  public A withDescription(String description) {
    this.description = description;
    return (A) this;
  }
  
  public A withDisplayName(String displayName) {
    this.displayName = displayName;
    return (A) this;
  }
  
  public A withDurationMinutes(Integer durationMinutes) {
    this.durationMinutes = durationMinutes;
    return (A) this;
  }
  
  public A withIcon(String icon) {
    this.icon = icon;
    return (A) this;
  }
  
  public A withIntroduction(String introduction) {
    this.introduction = introduction;
    return (A) this;
  }
  
  public A withNextQuickStart(List<String> nextQuickStart) {
    if (nextQuickStart != null) {
        this.nextQuickStart = new ArrayList();
        for (String item : nextQuickStart) {
          this.addToNextQuickStart(item);
        }
    } else {
      this.nextQuickStart = null;
    }
    return (A) this;
  }
  
  public A withNextQuickStart(String... nextQuickStart) {
    if (this.nextQuickStart != null) {
        this.nextQuickStart.clear();
        _visitables.remove("nextQuickStart");
    }
    if (nextQuickStart != null) {
      for (String item : nextQuickStart) {
        this.addToNextQuickStart(item);
      }
    }
    return (A) this;
  }
  
  public A withPrerequisites(List<String> prerequisites) {
    if (prerequisites != null) {
        this.prerequisites = new ArrayList();
        for (String item : prerequisites) {
          this.addToPrerequisites(item);
        }
    } else {
      this.prerequisites = null;
    }
    return (A) this;
  }
  
  public A withPrerequisites(String... prerequisites) {
    if (this.prerequisites != null) {
        this.prerequisites.clear();
        _visitables.remove("prerequisites");
    }
    if (prerequisites != null) {
      for (String item : prerequisites) {
        this.addToPrerequisites(item);
      }
    }
    return (A) this;
  }
  
  public A withTags(List<String> tags) {
    if (tags != null) {
        this.tags = new ArrayList();
        for (String item : tags) {
          this.addToTags(item);
        }
    } else {
      this.tags = null;
    }
    return (A) this;
  }
  
  public A withTags(String... tags) {
    if (this.tags != null) {
        this.tags.clear();
        _visitables.remove("tags");
    }
    if (tags != null) {
      for (String item : tags) {
        this.addToTags(item);
      }
    }
    return (A) this;
  }
  
  public A withTasks(List<ConsoleQuickStartTask> tasks) {
    if (this.tasks != null) {
      this._visitables.get("tasks").clear();
    }
    if (tasks != null) {
        this.tasks = new ArrayList();
        for (ConsoleQuickStartTask item : tasks) {
          this.addToTasks(item);
        }
    } else {
      this.tasks = null;
    }
    return (A) this;
  }
  
  public A withTasks(ConsoleQuickStartTask... tasks) {
    if (this.tasks != null) {
        this.tasks.clear();
        _visitables.remove("tasks");
    }
    if (tasks != null) {
      for (ConsoleQuickStartTask item : tasks) {
        this.addToTasks(item);
      }
    }
    return (A) this;
  }
  public class TasksNested<N> extends ConsoleQuickStartTaskFluent<TasksNested<N>> implements Nested<N>{
  
    ConsoleQuickStartTaskBuilder builder;
    int index;
  
    TasksNested(int index,ConsoleQuickStartTask item) {
      this.index = index;
      this.builder = new ConsoleQuickStartTaskBuilder(this, item);
    }
  
    public N and() {
      return (N) ConsoleQuickStartSpecFluent.this.setToTasks(index, builder.build());
    }
    
    public N endTask() {
      return and();
    }
    
  }
}