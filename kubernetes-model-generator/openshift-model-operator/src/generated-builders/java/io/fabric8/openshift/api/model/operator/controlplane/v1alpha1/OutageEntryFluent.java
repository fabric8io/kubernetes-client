package io.fabric8.openshift.api.model.operator.controlplane.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import java.lang.Boolean;
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
public class OutageEntryFluent<A extends io.fabric8.openshift.api.model.operator.controlplane.v1alpha1.OutageEntryFluent<A>> extends BaseFluent<A>{

  private Map<String,Object> additionalProperties;
  private String end;
  private ArrayList<LogEntryBuilder> endLogs = new ArrayList<LogEntryBuilder>();
  private String message;
  private String start;
  private ArrayList<LogEntryBuilder> startLogs = new ArrayList<LogEntryBuilder>();

  public OutageEntryFluent() {
  }
  
  public OutageEntryFluent(OutageEntry instance) {
    this.copyInstance(instance);
  }

  public A addAllToEndLogs(Collection<LogEntry> items) {
    if (this.endLogs == null) {
      this.endLogs = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("endLogs").add(builder);
        this.endLogs.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToStartLogs(Collection<LogEntry> items) {
    if (this.startLogs == null) {
      this.startLogs = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("startLogs").add(builder);
        this.startLogs.add(builder);
    }
    return (A) this;
  }
  
  public EndLogsNested<A> addNewEndLog() {
    return new EndLogsNested(-1, null);
  }
  
  public A addNewEndLog(String latency,String message,String reason,Boolean success,String time) {
    return (A) this.addToEndLogs(new LogEntry(latency, message, reason, success, time));
  }
  
  public EndLogsNested<A> addNewEndLogLike(LogEntry item) {
    return new EndLogsNested(-1, item);
  }
  
  public StartLogsNested<A> addNewStartLog() {
    return new StartLogsNested(-1, null);
  }
  
  public A addNewStartLog(String latency,String message,String reason,Boolean success,String time) {
    return (A) this.addToStartLogs(new LogEntry(latency, message, reason, success, time));
  }
  
  public StartLogsNested<A> addNewStartLogLike(LogEntry item) {
    return new StartLogsNested(-1, item);
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
  
  public A addToEndLogs(LogEntry... items) {
    if (this.endLogs == null) {
      this.endLogs = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("endLogs").add(builder);
        this.endLogs.add(builder);
    }
    return (A) this;
  }
  
  public A addToEndLogs(int index,LogEntry item) {
    if (this.endLogs == null) {
      this.endLogs = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= endLogs.size()) {
        _visitables.get("endLogs").add(builder);
        endLogs.add(builder);
    } else {
        _visitables.get("endLogs").add(builder);
        endLogs.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToStartLogs(LogEntry... items) {
    if (this.startLogs == null) {
      this.startLogs = new ArrayList();
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("startLogs").add(builder);
        this.startLogs.add(builder);
    }
    return (A) this;
  }
  
  public A addToStartLogs(int index,LogEntry item) {
    if (this.startLogs == null) {
      this.startLogs = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= startLogs.size()) {
        _visitables.get("startLogs").add(builder);
        startLogs.add(builder);
    } else {
        _visitables.get("startLogs").add(builder);
        startLogs.add(index, builder);
    }
    return (A) this;
  }
  
  public LogEntry buildEndLog(int index) {
    return this.endLogs.get(index).build();
  }
  
  public List<LogEntry> buildEndLogs() {
    return this.endLogs != null ? build(endLogs) : null;
  }
  
  public LogEntry buildFirstEndLog() {
    return this.endLogs.get(0).build();
  }
  
  public LogEntry buildFirstStartLog() {
    return this.startLogs.get(0).build();
  }
  
  public LogEntry buildLastEndLog() {
    return this.endLogs.get(endLogs.size() - 1).build();
  }
  
  public LogEntry buildLastStartLog() {
    return this.startLogs.get(startLogs.size() - 1).build();
  }
  
  public LogEntry buildMatchingEndLog(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : endLogs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LogEntry buildMatchingStartLog(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : startLogs) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public LogEntry buildStartLog(int index) {
    return this.startLogs.get(index).build();
  }
  
  public List<LogEntry> buildStartLogs() {
    return this.startLogs != null ? build(startLogs) : null;
  }
  
  protected void copyInstance(OutageEntry instance) {
    instance = instance != null ? instance : new OutageEntry();
    if (instance != null) {
        this.withEnd(instance.getEnd());
        this.withEndLogs(instance.getEndLogs());
        this.withMessage(instance.getMessage());
        this.withStart(instance.getStart());
        this.withStartLogs(instance.getStartLogs());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public EndLogsNested<A> editEndLog(int index) {
    if (endLogs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "endLogs"));
    }
    return this.setNewEndLogLike(index, this.buildEndLog(index));
  }
  
  public EndLogsNested<A> editFirstEndLog() {
    if (endLogs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "endLogs"));
    }
    return this.setNewEndLogLike(0, this.buildEndLog(0));
  }
  
  public StartLogsNested<A> editFirstStartLog() {
    if (startLogs.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "startLogs"));
    }
    return this.setNewStartLogLike(0, this.buildStartLog(0));
  }
  
  public EndLogsNested<A> editLastEndLog() {
    int index = endLogs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "endLogs"));
    }
    return this.setNewEndLogLike(index, this.buildEndLog(index));
  }
  
  public StartLogsNested<A> editLastStartLog() {
    int index = startLogs.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "startLogs"));
    }
    return this.setNewStartLogLike(index, this.buildStartLog(index));
  }
  
  public EndLogsNested<A> editMatchingEndLog(Predicate<LogEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < endLogs.size();i++) {
      if (predicate.test(endLogs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "endLogs"));
    }
    return this.setNewEndLogLike(index, this.buildEndLog(index));
  }
  
  public StartLogsNested<A> editMatchingStartLog(Predicate<LogEntryBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < startLogs.size();i++) {
      if (predicate.test(startLogs.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "startLogs"));
    }
    return this.setNewStartLogLike(index, this.buildStartLog(index));
  }
  
  public StartLogsNested<A> editStartLog(int index) {
    if (startLogs.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "startLogs"));
    }
    return this.setNewStartLogLike(index, this.buildStartLog(index));
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
    OutageEntryFluent that = (OutageEntryFluent) o;
    if (!(Objects.equals(end, that.end))) {
      return false;
    }
    if (!(Objects.equals(endLogs, that.endLogs))) {
      return false;
    }
    if (!(Objects.equals(message, that.message))) {
      return false;
    }
    if (!(Objects.equals(start, that.start))) {
      return false;
    }
    if (!(Objects.equals(startLogs, that.startLogs))) {
      return false;
    }
    if (!(Objects.equals(additionalProperties, that.additionalProperties))) {
      return false;
    }
    return true;
  }
  
  public Map<String,Object> getAdditionalProperties() {
    return this.additionalProperties;
  }
  
  public String getEnd() {
    return this.end;
  }
  
  public String getMessage() {
    return this.message;
  }
  
  public String getStart() {
    return this.start;
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasEnd() {
    return this.end != null;
  }
  
  public boolean hasEndLogs() {
    return this.endLogs != null && !(this.endLogs.isEmpty());
  }
  
  public boolean hasMatchingEndLog(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : endLogs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingStartLog(Predicate<LogEntryBuilder> predicate) {
      for (LogEntryBuilder item : startLogs) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessage() {
    return this.message != null;
  }
  
  public boolean hasStart() {
    return this.start != null;
  }
  
  public boolean hasStartLogs() {
    return this.startLogs != null && !(this.startLogs.isEmpty());
  }
  
  public int hashCode() {
    return Objects.hash(end, endLogs, message, start, startLogs, additionalProperties);
  }
  
  public A removeAllFromEndLogs(Collection<LogEntry> items) {
    if (this.endLogs == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("endLogs").remove(builder);
        this.endLogs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromStartLogs(Collection<LogEntry> items) {
    if (this.startLogs == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("startLogs").remove(builder);
        this.startLogs.remove(builder);
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
  
  public A removeFromEndLogs(LogEntry... items) {
    if (this.endLogs == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("endLogs").remove(builder);
        this.endLogs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromStartLogs(LogEntry... items) {
    if (this.startLogs == null) {
      return (A) this;
    }
    for (LogEntry item : items) {
        LogEntryBuilder builder = new LogEntryBuilder(item);
        _visitables.get("startLogs").remove(builder);
        this.startLogs.remove(builder);
    }
    return (A) this;
  }
  
  public A removeMatchingFromEndLogs(Predicate<LogEntryBuilder> predicate) {
    if (endLogs == null) {
      return (A) this;
    }
    Iterator<LogEntryBuilder> each = endLogs.iterator();
    List visitables = _visitables.get("endLogs");
    while (each.hasNext()) {
        LogEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromStartLogs(Predicate<LogEntryBuilder> predicate) {
    if (startLogs == null) {
      return (A) this;
    }
    Iterator<LogEntryBuilder> each = startLogs.iterator();
    List visitables = _visitables.get("startLogs");
    while (each.hasNext()) {
        LogEntryBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public EndLogsNested<A> setNewEndLogLike(int index,LogEntry item) {
    return new EndLogsNested(index, item);
  }
  
  public StartLogsNested<A> setNewStartLogLike(int index,LogEntry item) {
    return new StartLogsNested(index, item);
  }
  
  public A setToEndLogs(int index,LogEntry item) {
    if (this.endLogs == null) {
      this.endLogs = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= endLogs.size()) {
        _visitables.get("endLogs").add(builder);
        endLogs.add(builder);
    } else {
        _visitables.get("endLogs").add(builder);
        endLogs.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToStartLogs(int index,LogEntry item) {
    if (this.startLogs == null) {
      this.startLogs = new ArrayList();
    }
    LogEntryBuilder builder = new LogEntryBuilder(item);
    if (index < 0 || index >= startLogs.size()) {
        _visitables.get("startLogs").add(builder);
        startLogs.add(builder);
    } else {
        _visitables.get("startLogs").add(builder);
        startLogs.set(index, builder);
    }
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(end == null)) {
        sb.append("end:");
        sb.append(end);
        sb.append(",");
    }
    if (!(endLogs == null) && !(endLogs.isEmpty())) {
        sb.append("endLogs:");
        sb.append(endLogs);
        sb.append(",");
    }
    if (!(message == null)) {
        sb.append("message:");
        sb.append(message);
        sb.append(",");
    }
    if (!(start == null)) {
        sb.append("start:");
        sb.append(start);
        sb.append(",");
    }
    if (!(startLogs == null) && !(startLogs.isEmpty())) {
        sb.append("startLogs:");
        sb.append(startLogs);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public <K,V>A withAdditionalProperties(Map<String,Object> additionalProperties) {
    if (additionalProperties == null) {
      this.additionalProperties = null;
    } else {
      this.additionalProperties = new LinkedHashMap(additionalProperties);
    }
    return (A) this;
  }
  
  public A withEnd(String end) {
    this.end = end;
    return (A) this;
  }
  
  public A withEndLogs(List<LogEntry> endLogs) {
    if (this.endLogs != null) {
      this._visitables.get("endLogs").clear();
    }
    if (endLogs != null) {
        this.endLogs = new ArrayList();
        for (LogEntry item : endLogs) {
          this.addToEndLogs(item);
        }
    } else {
      this.endLogs = null;
    }
    return (A) this;
  }
  
  public A withEndLogs(LogEntry... endLogs) {
    if (this.endLogs != null) {
        this.endLogs.clear();
        _visitables.remove("endLogs");
    }
    if (endLogs != null) {
      for (LogEntry item : endLogs) {
        this.addToEndLogs(item);
      }
    }
    return (A) this;
  }
  
  public A withMessage(String message) {
    this.message = message;
    return (A) this;
  }
  
  public A withStart(String start) {
    this.start = start;
    return (A) this;
  }
  
  public A withStartLogs(List<LogEntry> startLogs) {
    if (this.startLogs != null) {
      this._visitables.get("startLogs").clear();
    }
    if (startLogs != null) {
        this.startLogs = new ArrayList();
        for (LogEntry item : startLogs) {
          this.addToStartLogs(item);
        }
    } else {
      this.startLogs = null;
    }
    return (A) this;
  }
  
  public A withStartLogs(LogEntry... startLogs) {
    if (this.startLogs != null) {
        this.startLogs.clear();
        _visitables.remove("startLogs");
    }
    if (startLogs != null) {
      for (LogEntry item : startLogs) {
        this.addToStartLogs(item);
      }
    }
    return (A) this;
  }
  public class EndLogsNested<N> extends LogEntryFluent<EndLogsNested<N>> implements Nested<N>{
  
    LogEntryBuilder builder;
    int index;
  
    EndLogsNested(int index,LogEntry item) {
      this.index = index;
      this.builder = new LogEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) OutageEntryFluent.this.setToEndLogs(index, builder.build());
    }
    
    public N endEndLog() {
      return and();
    }
    
  }
  public class StartLogsNested<N> extends LogEntryFluent<StartLogsNested<N>> implements Nested<N>{
  
    LogEntryBuilder builder;
    int index;
  
    StartLogsNested(int index,LogEntry item) {
      this.index = index;
      this.builder = new LogEntryBuilder(this, item);
    }
  
    public N and() {
      return (N) OutageEntryFluent.this.setToStartLogs(index, builder.build());
    }
    
    public N endStartLog() {
      return and();
    }
    
  }
}