package io.fabric8.openshift.api.model.monitoring.v1alpha1;

import io.fabric8.kubernetes.api.builder.BaseFluent;
import io.fabric8.kubernetes.api.builder.Nested;
import io.fabric8.kubernetes.api.model.SecretKeySelector;
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
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Generated
 */
@SuppressWarnings("unchecked")
public class SlackConfigFluent<A extends io.fabric8.openshift.api.model.monitoring.v1alpha1.SlackConfigFluent<A>> extends BaseFluent<A>{

  private ArrayList<SlackActionBuilder> actions = new ArrayList<SlackActionBuilder>();
  private Map<String,Object> additionalProperties;
  private SecretKeySelector apiURL;
  private String callbackId;
  private String channel;
  private String color;
  private String fallback;
  private ArrayList<SlackFieldBuilder> fields = new ArrayList<SlackFieldBuilder>();
  private String footer;
  private HTTPConfigBuilder httpConfig;
  private String iconEmoji;
  private String iconURL;
  private String imageURL;
  private Boolean linkNames;
  private String messageText;
  private List<String> mrkdwnIn = new ArrayList<String>();
  private String pretext;
  private Boolean sendResolved;
  private Boolean shortFields;
  private String text;
  private String thumbURL;
  private String timeout;
  private String title;
  private String titleLink;
  private String username;

  public SlackConfigFluent() {
  }
  
  public SlackConfigFluent(SlackConfig instance) {
    this.copyInstance(instance);
  }

  public A addAllToActions(Collection<SlackAction> items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (SlackAction item : items) {
        SlackActionBuilder builder = new SlackActionBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToFields(Collection<SlackField> items) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    for (SlackField item : items) {
        SlackFieldBuilder builder = new SlackFieldBuilder(item);
        _visitables.get("fields").add(builder);
        this.fields.add(builder);
    }
    return (A) this;
  }
  
  public A addAllToMrkdwnIn(Collection<String> items) {
    if (this.mrkdwnIn == null) {
      this.mrkdwnIn = new ArrayList();
    }
    for (String item : items) {
      this.mrkdwnIn.add(item);
    }
    return (A) this;
  }
  
  public ActionsNested<A> addNewAction() {
    return new ActionsNested(-1, null);
  }
  
  public ActionsNested<A> addNewActionLike(SlackAction item) {
    return new ActionsNested(-1, item);
  }
  
  public FieldsNested<A> addNewField() {
    return new FieldsNested(-1, null);
  }
  
  public A addNewField(Boolean _short,String title,String value) {
    return (A) this.addToFields(new SlackField(_short, title, value));
  }
  
  public FieldsNested<A> addNewFieldLike(SlackField item) {
    return new FieldsNested(-1, item);
  }
  
  public A addToActions(SlackAction... items) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    for (SlackAction item : items) {
        SlackActionBuilder builder = new SlackActionBuilder(item);
        _visitables.get("actions").add(builder);
        this.actions.add(builder);
    }
    return (A) this;
  }
  
  public A addToActions(int index,SlackAction item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    SlackActionBuilder builder = new SlackActionBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.add(index, builder);
    }
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
  
  public A addToFields(SlackField... items) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    for (SlackField item : items) {
        SlackFieldBuilder builder = new SlackFieldBuilder(item);
        _visitables.get("fields").add(builder);
        this.fields.add(builder);
    }
    return (A) this;
  }
  
  public A addToFields(int index,SlackField item) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    SlackFieldBuilder builder = new SlackFieldBuilder(item);
    if (index < 0 || index >= fields.size()) {
        _visitables.get("fields").add(builder);
        fields.add(builder);
    } else {
        _visitables.get("fields").add(builder);
        fields.add(index, builder);
    }
    return (A) this;
  }
  
  public A addToMrkdwnIn(String... items) {
    if (this.mrkdwnIn == null) {
      this.mrkdwnIn = new ArrayList();
    }
    for (String item : items) {
      this.mrkdwnIn.add(item);
    }
    return (A) this;
  }
  
  public A addToMrkdwnIn(int index,String item) {
    if (this.mrkdwnIn == null) {
      this.mrkdwnIn = new ArrayList();
    }
    this.mrkdwnIn.add(index, item);
    return (A) this;
  }
  
  public SlackAction buildAction(int index) {
    return this.actions.get(index).build();
  }
  
  public List<SlackAction> buildActions() {
    return this.actions != null ? build(actions) : null;
  }
  
  public SlackField buildField(int index) {
    return this.fields.get(index).build();
  }
  
  public List<SlackField> buildFields() {
    return this.fields != null ? build(fields) : null;
  }
  
  public SlackAction buildFirstAction() {
    return this.actions.get(0).build();
  }
  
  public SlackField buildFirstField() {
    return this.fields.get(0).build();
  }
  
  public HTTPConfig buildHttpConfig() {
    return this.httpConfig != null ? this.httpConfig.build() : null;
  }
  
  public SlackAction buildLastAction() {
    return this.actions.get(actions.size() - 1).build();
  }
  
  public SlackField buildLastField() {
    return this.fields.get(fields.size() - 1).build();
  }
  
  public SlackAction buildMatchingAction(Predicate<SlackActionBuilder> predicate) {
      for (SlackActionBuilder item : actions) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  public SlackField buildMatchingField(Predicate<SlackFieldBuilder> predicate) {
      for (SlackFieldBuilder item : fields) {
        if (predicate.test(item)) {
          return item.build();
        }
      }
      return null;
  }
  
  protected void copyInstance(SlackConfig instance) {
    instance = instance != null ? instance : new SlackConfig();
    if (instance != null) {
        this.withActions(instance.getActions());
        this.withApiURL(instance.getApiURL());
        this.withCallbackId(instance.getCallbackId());
        this.withChannel(instance.getChannel());
        this.withColor(instance.getColor());
        this.withFallback(instance.getFallback());
        this.withFields(instance.getFields());
        this.withFooter(instance.getFooter());
        this.withHttpConfig(instance.getHttpConfig());
        this.withIconEmoji(instance.getIconEmoji());
        this.withIconURL(instance.getIconURL());
        this.withImageURL(instance.getImageURL());
        this.withLinkNames(instance.getLinkNames());
        this.withMessageText(instance.getMessageText());
        this.withMrkdwnIn(instance.getMrkdwnIn());
        this.withPretext(instance.getPretext());
        this.withSendResolved(instance.getSendResolved());
        this.withShortFields(instance.getShortFields());
        this.withText(instance.getText());
        this.withThumbURL(instance.getThumbURL());
        this.withTimeout(instance.getTimeout());
        this.withTitle(instance.getTitle());
        this.withTitleLink(instance.getTitleLink());
        this.withUsername(instance.getUsername());
        this.withAdditionalProperties(instance.getAdditionalProperties());
    }
  }
  
  public ActionsNested<A> editAction(int index) {
    if (actions.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public FieldsNested<A> editField(int index) {
    if (fields.size() <= index) {
      throw new RuntimeException(String.format("Can't edit %s. Index exceeds size.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public ActionsNested<A> editFirstAction() {
    if (actions.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(0, this.buildAction(0));
  }
  
  public FieldsNested<A> editFirstField() {
    if (fields.size() == 0) {
      throw new RuntimeException(String.format("Can't edit first %s. The list is empty.", "fields"));
    }
    return this.setNewFieldLike(0, this.buildField(0));
  }
  
  public HttpConfigNested<A> editHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(null));
  }
  
  public ActionsNested<A> editLastAction() {
    int index = actions.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public FieldsNested<A> editLastField() {
    int index = fields.size() - 1;
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit last %s. The list is empty.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public ActionsNested<A> editMatchingAction(Predicate<SlackActionBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < actions.size();i++) {
      if (predicate.test(actions.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "actions"));
    }
    return this.setNewActionLike(index, this.buildAction(index));
  }
  
  public FieldsNested<A> editMatchingField(Predicate<SlackFieldBuilder> predicate) {
    int index = -1;
    for (int i = 0;i < fields.size();i++) {
      if (predicate.test(fields.get(i))) {
          index = i;
          break;
      }
    }
    if (index < 0) {
      throw new RuntimeException(String.format("Can't edit matching %s. No match found.", "fields"));
    }
    return this.setNewFieldLike(index, this.buildField(index));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfig() {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(new HTTPConfigBuilder().build()));
  }
  
  public HttpConfigNested<A> editOrNewHttpConfigLike(HTTPConfig item) {
    return this.withNewHttpConfigLike(Optional.ofNullable(this.buildHttpConfig()).orElse(item));
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
    SlackConfigFluent that = (SlackConfigFluent) o;
    if (!(Objects.equals(actions, that.actions))) {
      return false;
    }
    if (!(Objects.equals(apiURL, that.apiURL))) {
      return false;
    }
    if (!(Objects.equals(callbackId, that.callbackId))) {
      return false;
    }
    if (!(Objects.equals(channel, that.channel))) {
      return false;
    }
    if (!(Objects.equals(color, that.color))) {
      return false;
    }
    if (!(Objects.equals(fallback, that.fallback))) {
      return false;
    }
    if (!(Objects.equals(fields, that.fields))) {
      return false;
    }
    if (!(Objects.equals(footer, that.footer))) {
      return false;
    }
    if (!(Objects.equals(httpConfig, that.httpConfig))) {
      return false;
    }
    if (!(Objects.equals(iconEmoji, that.iconEmoji))) {
      return false;
    }
    if (!(Objects.equals(iconURL, that.iconURL))) {
      return false;
    }
    if (!(Objects.equals(imageURL, that.imageURL))) {
      return false;
    }
    if (!(Objects.equals(linkNames, that.linkNames))) {
      return false;
    }
    if (!(Objects.equals(messageText, that.messageText))) {
      return false;
    }
    if (!(Objects.equals(mrkdwnIn, that.mrkdwnIn))) {
      return false;
    }
    if (!(Objects.equals(pretext, that.pretext))) {
      return false;
    }
    if (!(Objects.equals(sendResolved, that.sendResolved))) {
      return false;
    }
    if (!(Objects.equals(shortFields, that.shortFields))) {
      return false;
    }
    if (!(Objects.equals(text, that.text))) {
      return false;
    }
    if (!(Objects.equals(thumbURL, that.thumbURL))) {
      return false;
    }
    if (!(Objects.equals(timeout, that.timeout))) {
      return false;
    }
    if (!(Objects.equals(title, that.title))) {
      return false;
    }
    if (!(Objects.equals(titleLink, that.titleLink))) {
      return false;
    }
    if (!(Objects.equals(username, that.username))) {
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
  
  public SecretKeySelector getApiURL() {
    return this.apiURL;
  }
  
  public String getCallbackId() {
    return this.callbackId;
  }
  
  public String getChannel() {
    return this.channel;
  }
  
  public String getColor() {
    return this.color;
  }
  
  public String getFallback() {
    return this.fallback;
  }
  
  public String getFirstMrkdwnIn() {
    return this.mrkdwnIn.get(0);
  }
  
  public String getFooter() {
    return this.footer;
  }
  
  public String getIconEmoji() {
    return this.iconEmoji;
  }
  
  public String getIconURL() {
    return this.iconURL;
  }
  
  public String getImageURL() {
    return this.imageURL;
  }
  
  public String getLastMrkdwnIn() {
    return this.mrkdwnIn.get(mrkdwnIn.size() - 1);
  }
  
  public Boolean getLinkNames() {
    return this.linkNames;
  }
  
  public String getMatchingMrkdwnIn(Predicate<String> predicate) {
      for (String item : mrkdwnIn) {
        if (predicate.test(item)) {
          return item;
        }
      }
      return null;
  }
  
  public String getMessageText() {
    return this.messageText;
  }
  
  public List<String> getMrkdwnIn() {
    return this.mrkdwnIn;
  }
  
  public String getMrkdwnIn(int index) {
    return this.mrkdwnIn.get(index);
  }
  
  public String getPretext() {
    return this.pretext;
  }
  
  public Boolean getSendResolved() {
    return this.sendResolved;
  }
  
  public Boolean getShortFields() {
    return this.shortFields;
  }
  
  public String getText() {
    return this.text;
  }
  
  public String getThumbURL() {
    return this.thumbURL;
  }
  
  public String getTimeout() {
    return this.timeout;
  }
  
  public String getTitle() {
    return this.title;
  }
  
  public String getTitleLink() {
    return this.titleLink;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public boolean hasActions() {
    return this.actions != null && !(this.actions.isEmpty());
  }
  
  public boolean hasAdditionalProperties() {
    return this.additionalProperties != null;
  }
  
  public boolean hasApiURL() {
    return this.apiURL != null;
  }
  
  public boolean hasCallbackId() {
    return this.callbackId != null;
  }
  
  public boolean hasChannel() {
    return this.channel != null;
  }
  
  public boolean hasColor() {
    return this.color != null;
  }
  
  public boolean hasFallback() {
    return this.fallback != null;
  }
  
  public boolean hasFields() {
    return this.fields != null && !(this.fields.isEmpty());
  }
  
  public boolean hasFooter() {
    return this.footer != null;
  }
  
  public boolean hasHttpConfig() {
    return this.httpConfig != null;
  }
  
  public boolean hasIconEmoji() {
    return this.iconEmoji != null;
  }
  
  public boolean hasIconURL() {
    return this.iconURL != null;
  }
  
  public boolean hasImageURL() {
    return this.imageURL != null;
  }
  
  public boolean hasLinkNames() {
    return this.linkNames != null;
  }
  
  public boolean hasMatchingAction(Predicate<SlackActionBuilder> predicate) {
      for (SlackActionBuilder item : actions) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingField(Predicate<SlackFieldBuilder> predicate) {
      for (SlackFieldBuilder item : fields) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMatchingMrkdwnIn(Predicate<String> predicate) {
      for (String item : mrkdwnIn) {
        if (predicate.test(item)) {
          return true;
        }
      }
      return false;
  }
  
  public boolean hasMessageText() {
    return this.messageText != null;
  }
  
  public boolean hasMrkdwnIn() {
    return this.mrkdwnIn != null && !(this.mrkdwnIn.isEmpty());
  }
  
  public boolean hasPretext() {
    return this.pretext != null;
  }
  
  public boolean hasSendResolved() {
    return this.sendResolved != null;
  }
  
  public boolean hasShortFields() {
    return this.shortFields != null;
  }
  
  public boolean hasText() {
    return this.text != null;
  }
  
  public boolean hasThumbURL() {
    return this.thumbURL != null;
  }
  
  public boolean hasTimeout() {
    return this.timeout != null;
  }
  
  public boolean hasTitle() {
    return this.title != null;
  }
  
  public boolean hasTitleLink() {
    return this.titleLink != null;
  }
  
  public boolean hasUsername() {
    return this.username != null;
  }
  
  public int hashCode() {
    return Objects.hash(actions, apiURL, callbackId, channel, color, fallback, fields, footer, httpConfig, iconEmoji, iconURL, imageURL, linkNames, messageText, mrkdwnIn, pretext, sendResolved, shortFields, text, thumbURL, timeout, title, titleLink, username, additionalProperties);
  }
  
  public A removeAllFromActions(Collection<SlackAction> items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (SlackAction item : items) {
        SlackActionBuilder builder = new SlackActionBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromFields(Collection<SlackField> items) {
    if (this.fields == null) {
      return (A) this;
    }
    for (SlackField item : items) {
        SlackFieldBuilder builder = new SlackFieldBuilder(item);
        _visitables.get("fields").remove(builder);
        this.fields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeAllFromMrkdwnIn(Collection<String> items) {
    if (this.mrkdwnIn == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mrkdwnIn.remove(item);
    }
    return (A) this;
  }
  
  public A removeFromActions(SlackAction... items) {
    if (this.actions == null) {
      return (A) this;
    }
    for (SlackAction item : items) {
        SlackActionBuilder builder = new SlackActionBuilder(item);
        _visitables.get("actions").remove(builder);
        this.actions.remove(builder);
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
  
  public A removeFromFields(SlackField... items) {
    if (this.fields == null) {
      return (A) this;
    }
    for (SlackField item : items) {
        SlackFieldBuilder builder = new SlackFieldBuilder(item);
        _visitables.get("fields").remove(builder);
        this.fields.remove(builder);
    }
    return (A) this;
  }
  
  public A removeFromMrkdwnIn(String... items) {
    if (this.mrkdwnIn == null) {
      return (A) this;
    }
    for (String item : items) {
      this.mrkdwnIn.remove(item);
    }
    return (A) this;
  }
  
  public A removeMatchingFromActions(Predicate<SlackActionBuilder> predicate) {
    if (actions == null) {
      return (A) this;
    }
    Iterator<SlackActionBuilder> each = actions.iterator();
    List visitables = _visitables.get("actions");
    while (each.hasNext()) {
        SlackActionBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public A removeMatchingFromFields(Predicate<SlackFieldBuilder> predicate) {
    if (fields == null) {
      return (A) this;
    }
    Iterator<SlackFieldBuilder> each = fields.iterator();
    List visitables = _visitables.get("fields");
    while (each.hasNext()) {
        SlackFieldBuilder builder = each.next();
        if (predicate.test(builder)) {
            visitables.remove(builder);
            each.remove();
        }
    }
    return (A) this;
  }
  
  public ActionsNested<A> setNewActionLike(int index,SlackAction item) {
    return new ActionsNested(index, item);
  }
  
  public FieldsNested<A> setNewFieldLike(int index,SlackField item) {
    return new FieldsNested(index, item);
  }
  
  public A setToActions(int index,SlackAction item) {
    if (this.actions == null) {
      this.actions = new ArrayList();
    }
    SlackActionBuilder builder = new SlackActionBuilder(item);
    if (index < 0 || index >= actions.size()) {
        _visitables.get("actions").add(builder);
        actions.add(builder);
    } else {
        _visitables.get("actions").add(builder);
        actions.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToFields(int index,SlackField item) {
    if (this.fields == null) {
      this.fields = new ArrayList();
    }
    SlackFieldBuilder builder = new SlackFieldBuilder(item);
    if (index < 0 || index >= fields.size()) {
        _visitables.get("fields").add(builder);
        fields.add(builder);
    } else {
        _visitables.get("fields").add(builder);
        fields.set(index, builder);
    }
    return (A) this;
  }
  
  public A setToMrkdwnIn(int index,String item) {
    if (this.mrkdwnIn == null) {
      this.mrkdwnIn = new ArrayList();
    }
    this.mrkdwnIn.set(index, item);
    return (A) this;
  }
  
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    if (!(actions == null) && !(actions.isEmpty())) {
        sb.append("actions:");
        sb.append(actions);
        sb.append(",");
    }
    if (!(apiURL == null)) {
        sb.append("apiURL:");
        sb.append(apiURL);
        sb.append(",");
    }
    if (!(callbackId == null)) {
        sb.append("callbackId:");
        sb.append(callbackId);
        sb.append(",");
    }
    if (!(channel == null)) {
        sb.append("channel:");
        sb.append(channel);
        sb.append(",");
    }
    if (!(color == null)) {
        sb.append("color:");
        sb.append(color);
        sb.append(",");
    }
    if (!(fallback == null)) {
        sb.append("fallback:");
        sb.append(fallback);
        sb.append(",");
    }
    if (!(fields == null) && !(fields.isEmpty())) {
        sb.append("fields:");
        sb.append(fields);
        sb.append(",");
    }
    if (!(footer == null)) {
        sb.append("footer:");
        sb.append(footer);
        sb.append(",");
    }
    if (!(httpConfig == null)) {
        sb.append("httpConfig:");
        sb.append(httpConfig);
        sb.append(",");
    }
    if (!(iconEmoji == null)) {
        sb.append("iconEmoji:");
        sb.append(iconEmoji);
        sb.append(",");
    }
    if (!(iconURL == null)) {
        sb.append("iconURL:");
        sb.append(iconURL);
        sb.append(",");
    }
    if (!(imageURL == null)) {
        sb.append("imageURL:");
        sb.append(imageURL);
        sb.append(",");
    }
    if (!(linkNames == null)) {
        sb.append("linkNames:");
        sb.append(linkNames);
        sb.append(",");
    }
    if (!(messageText == null)) {
        sb.append("messageText:");
        sb.append(messageText);
        sb.append(",");
    }
    if (!(mrkdwnIn == null) && !(mrkdwnIn.isEmpty())) {
        sb.append("mrkdwnIn:");
        sb.append(mrkdwnIn);
        sb.append(",");
    }
    if (!(pretext == null)) {
        sb.append("pretext:");
        sb.append(pretext);
        sb.append(",");
    }
    if (!(sendResolved == null)) {
        sb.append("sendResolved:");
        sb.append(sendResolved);
        sb.append(",");
    }
    if (!(shortFields == null)) {
        sb.append("shortFields:");
        sb.append(shortFields);
        sb.append(",");
    }
    if (!(text == null)) {
        sb.append("text:");
        sb.append(text);
        sb.append(",");
    }
    if (!(thumbURL == null)) {
        sb.append("thumbURL:");
        sb.append(thumbURL);
        sb.append(",");
    }
    if (!(timeout == null)) {
        sb.append("timeout:");
        sb.append(timeout);
        sb.append(",");
    }
    if (!(title == null)) {
        sb.append("title:");
        sb.append(title);
        sb.append(",");
    }
    if (!(titleLink == null)) {
        sb.append("titleLink:");
        sb.append(titleLink);
        sb.append(",");
    }
    if (!(username == null)) {
        sb.append("username:");
        sb.append(username);
        sb.append(",");
    }
    if (!(additionalProperties == null) && !(additionalProperties.isEmpty())) {
        sb.append("additionalProperties:");
        sb.append(additionalProperties);
    }
    sb.append("}");
    return sb.toString();
  }
  
  public A withActions(List<SlackAction> actions) {
    if (this.actions != null) {
      this._visitables.get("actions").clear();
    }
    if (actions != null) {
        this.actions = new ArrayList();
        for (SlackAction item : actions) {
          this.addToActions(item);
        }
    } else {
      this.actions = null;
    }
    return (A) this;
  }
  
  public A withActions(SlackAction... actions) {
    if (this.actions != null) {
        this.actions.clear();
        _visitables.remove("actions");
    }
    if (actions != null) {
      for (SlackAction item : actions) {
        this.addToActions(item);
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
  
  public A withApiURL(SecretKeySelector apiURL) {
    this.apiURL = apiURL;
    return (A) this;
  }
  
  public A withCallbackId(String callbackId) {
    this.callbackId = callbackId;
    return (A) this;
  }
  
  public A withChannel(String channel) {
    this.channel = channel;
    return (A) this;
  }
  
  public A withColor(String color) {
    this.color = color;
    return (A) this;
  }
  
  public A withFallback(String fallback) {
    this.fallback = fallback;
    return (A) this;
  }
  
  public A withFields(List<SlackField> fields) {
    if (this.fields != null) {
      this._visitables.get("fields").clear();
    }
    if (fields != null) {
        this.fields = new ArrayList();
        for (SlackField item : fields) {
          this.addToFields(item);
        }
    } else {
      this.fields = null;
    }
    return (A) this;
  }
  
  public A withFields(SlackField... fields) {
    if (this.fields != null) {
        this.fields.clear();
        _visitables.remove("fields");
    }
    if (fields != null) {
      for (SlackField item : fields) {
        this.addToFields(item);
      }
    }
    return (A) this;
  }
  
  public A withFooter(String footer) {
    this.footer = footer;
    return (A) this;
  }
  
  public A withHttpConfig(HTTPConfig httpConfig) {
    this._visitables.remove("httpConfig");
    if (httpConfig != null) {
        this.httpConfig = new HTTPConfigBuilder(httpConfig);
        this._visitables.get("httpConfig").add(this.httpConfig);
    } else {
        this.httpConfig = null;
        this._visitables.get("httpConfig").remove(this.httpConfig);
    }
    return (A) this;
  }
  
  public A withIconEmoji(String iconEmoji) {
    this.iconEmoji = iconEmoji;
    return (A) this;
  }
  
  public A withIconURL(String iconURL) {
    this.iconURL = iconURL;
    return (A) this;
  }
  
  public A withImageURL(String imageURL) {
    this.imageURL = imageURL;
    return (A) this;
  }
  
  public A withLinkNames() {
    return withLinkNames(true);
  }
  
  public A withLinkNames(Boolean linkNames) {
    this.linkNames = linkNames;
    return (A) this;
  }
  
  public A withMessageText(String messageText) {
    this.messageText = messageText;
    return (A) this;
  }
  
  public A withMrkdwnIn(List<String> mrkdwnIn) {
    if (mrkdwnIn != null) {
        this.mrkdwnIn = new ArrayList();
        for (String item : mrkdwnIn) {
          this.addToMrkdwnIn(item);
        }
    } else {
      this.mrkdwnIn = null;
    }
    return (A) this;
  }
  
  public A withMrkdwnIn(String... mrkdwnIn) {
    if (this.mrkdwnIn != null) {
        this.mrkdwnIn.clear();
        _visitables.remove("mrkdwnIn");
    }
    if (mrkdwnIn != null) {
      for (String item : mrkdwnIn) {
        this.addToMrkdwnIn(item);
      }
    }
    return (A) this;
  }
  
  public A withNewApiURL(String key,String name,Boolean optional) {
    return (A) this.withApiURL(new SecretKeySelector(key, name, optional));
  }
  
  public HttpConfigNested<A> withNewHttpConfig() {
    return new HttpConfigNested(null);
  }
  
  public HttpConfigNested<A> withNewHttpConfigLike(HTTPConfig item) {
    return new HttpConfigNested(item);
  }
  
  public A withPretext(String pretext) {
    this.pretext = pretext;
    return (A) this;
  }
  
  public A withSendResolved() {
    return withSendResolved(true);
  }
  
  public A withSendResolved(Boolean sendResolved) {
    this.sendResolved = sendResolved;
    return (A) this;
  }
  
  public A withShortFields() {
    return withShortFields(true);
  }
  
  public A withShortFields(Boolean shortFields) {
    this.shortFields = shortFields;
    return (A) this;
  }
  
  public A withText(String text) {
    this.text = text;
    return (A) this;
  }
  
  public A withThumbURL(String thumbURL) {
    this.thumbURL = thumbURL;
    return (A) this;
  }
  
  public A withTimeout(String timeout) {
    this.timeout = timeout;
    return (A) this;
  }
  
  public A withTitle(String title) {
    this.title = title;
    return (A) this;
  }
  
  public A withTitleLink(String titleLink) {
    this.titleLink = titleLink;
    return (A) this;
  }
  
  public A withUsername(String username) {
    this.username = username;
    return (A) this;
  }
  public class ActionsNested<N> extends SlackActionFluent<ActionsNested<N>> implements Nested<N>{
  
    SlackActionBuilder builder;
    int index;
  
    ActionsNested(int index,SlackAction item) {
      this.index = index;
      this.builder = new SlackActionBuilder(this, item);
    }
  
    public N and() {
      return (N) SlackConfigFluent.this.setToActions(index, builder.build());
    }
    
    public N endAction() {
      return and();
    }
    
  }
  public class FieldsNested<N> extends SlackFieldFluent<FieldsNested<N>> implements Nested<N>{
  
    SlackFieldBuilder builder;
    int index;
  
    FieldsNested(int index,SlackField item) {
      this.index = index;
      this.builder = new SlackFieldBuilder(this, item);
    }
  
    public N and() {
      return (N) SlackConfigFluent.this.setToFields(index, builder.build());
    }
    
    public N endField() {
      return and();
    }
    
  }
  public class HttpConfigNested<N> extends HTTPConfigFluent<HttpConfigNested<N>> implements Nested<N>{
  
    HTTPConfigBuilder builder;
  
    HttpConfigNested(HTTPConfig item) {
      this.builder = new HTTPConfigBuilder(this, item);
    }
  
    public N and() {
      return (N) SlackConfigFluent.this.withHttpConfig(builder.build());
    }
    
    public N endHttpConfig() {
      return and();
    }
    
  }
}