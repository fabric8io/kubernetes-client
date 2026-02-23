<#ftl output_format="HTML">
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Revapi API Compatibility Reports</title>
  <style>
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
      font-size: 14px;
      line-height: 1.6;
      background: #f5f5f5;
      color: #333;
    }
    .container { max-width: 1400px; margin: 0 auto; padding: 20px; }
    .header {
      background: white;
      padding: 24px 30px;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      margin-bottom: 20px;
    }
    .header h1 { font-size: 1.6em; color: #222; border-bottom: 3px solid #4CAF50; padding-bottom: 10px; margin-bottom: 12px; }
    .version-info { color: #555; font-size: 0.9em; }
    .version-info code { background: #e3f2fd; color: #1565c0; padding: 1px 5px; border-radius: 3px; }
    .summary-bar {
      display: flex;
      gap: 16px;
      flex-wrap: wrap;
      background: white;
      padding: 20px 30px;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      margin-bottom: 20px;
    }
    .sum-box { padding: 12px 20px; border-radius: 6px; text-align: center; min-width: 130px; }
    .sum-box.total    { background: #e3f2fd; border: 1px solid #90caf9; }
    .sum-box.changes  { background: #fff4e5; border: 1px solid #ffd59e; }
    .sum-box.breaking { background: #fdecea; border: 1px solid #f5c6c2; }
    .sum-value { font-size: 1.8em; font-weight: bold; }
    .sum-box.total .sum-value    { color: #1565c0; }
    .sum-box.changes .sum-value  { color: #e65100; }
    .sum-box.breaking .sum-value { color: #c62828; }
    .sum-label { font-size: 0.8em; color: #666; margin-top: 4px; }
    .category {
      background: white;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      margin-bottom: 20px;
      overflow: hidden;
    }
    .category > summary {
      padding: 14px 20px;
      font-size: 1.05em;
      font-weight: 600;
      border-bottom: 1px solid #eee;
      cursor: pointer;
      list-style: none;
      display: flex;
      align-items: center;
      gap: 8px;
      user-select: none;
    }
    .category > summary::-webkit-details-marker { display: none; }
    .category > summary::after { content: "▲"; font-size: 0.7em; margin-left: auto; opacity: 0.5; }
    .category:not([open]) > summary::after { content: "▼"; }
    .category:not([open]) > summary { border-bottom: none; }
    .cat-breaking     > summary { background: #fdecea; color: #c62828; }
    .cat-non-breaking > summary { background: #fff4e5; color: #e65100; }
    .cat-no-changes   > summary { background: #e8f5e9; color: #2e7d32; }
    .cat-count { font-weight: normal; font-size: 0.9em; opacity: 0.8; }
    .module-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(340px, 1fr));
      gap: 10px;
      padding: 16px;
    }
    .module-card {
      border: 1px solid #e0e0e0;
      border-radius: 6px;
      padding: 12px 16px;
      background: #fafafa;
      transition: all 0.15s;
    }
    .module-card:hover { border-color: #4CAF50; box-shadow: 0 2px 8px rgba(0,0,0,0.12); background: white; }
    .module-card a { color: #1976d2; text-decoration: none; font-weight: 500; font-size: 0.95em; }
    .module-card a:hover { text-decoration: underline; }
    .module-card-path { font-family: monospace; font-size: 0.78em; color: #888; margin-top: 3px; }
    .module-card-artifact { font-family: monospace; font-size: 0.75em; color: #555; margin-top: 3px; }
    .badges { display: flex; flex-wrap: wrap; gap: 5px; margin-top: 7px; }
    .badge { font-size: 0.72em; padding: 2px 7px; border-radius: 10px; font-weight: 600; }
    .badge-breaking     { background: #fdecea; color: #c62828; }
    .badge-potentially  { background: #fff4e5; color: #e65100; }
    .badge-non-breaking { background: #e8f5e9; color: #2e7d32; }
    .badge-neutral      { background: #e9ecef; color: #6c757d; }
  </style>
</head>
<body>
<div class="container">

  <div class="header">
    <h1>Revapi API Compatibility Reports</h1>
    <#if indexOld?has_content>
    <p class="version-info">Comparing:
      <#if indexNew?has_content>
        <code>${indexOld}</code> &rarr; <code>${indexNew}</code>
      <#else>
        Current code vs. <code>${indexOld}</code>
      </#if>
    </p>
    </#if>
  </div>

  <div class="summary-bar">
    <div class="sum-box total">
      <div class="sum-value">${totalModules}</div>
      <div class="sum-label">Modules Analysed</div>
    </div>
    <div class="sum-box changes">
      <div class="sum-value">${modulesWithChanges}</div>
      <div class="sum-label">Modules with Changes</div>
    </div>
    <div class="sum-box breaking">
      <div class="sum-value">${modulesWithBreaking}</div>
      <div class="sum-label">Modules with Breaking Changes</div>
    </div>
    <div class="sum-box total">
      <div class="sum-value">${totalChanges}</div>
      <div class="sum-label">Total API Changes</div>
    </div>
  </div>

  <#list categories as cat>
  <details class="category ${cat.cssClass}"<#if cat.open> open</#if>>
    <summary>${cat.title} <span class="cat-count">(${cat.modules?size})</span></summary>
    <div class="module-grid">
      <#list cat.modules as m>
      <div class="module-card">
        <a href="${m.path}/revapi-report.html">${m.name}</a>
        <div class="module-card-path">${m.path}</div>
        <#if m.oldArchive?has_content && m.newArchive?has_content>
        <div class="module-card-artifact">${m.oldArchive} &rarr; ${m.newArchive}</div>
        </#if>
        <div class="badges">
          <#if (m.stats.total == 0)>
            <span class="badge badge-neutral">no changes</span>
          <#else>
            <#if (m.stats.breaking > 0)>
              <span class="badge badge-breaking">${m.stats.breaking} breaking</span>
            </#if>
            <#if (m.stats.potentiallyBreaking > 0)>
              <span class="badge badge-potentially">${m.stats.potentiallyBreaking} potentially breaking</span>
            </#if>
            <#if (m.stats.nonBreaking > 0)>
              <span class="badge badge-non-breaking">${m.stats.nonBreaking} non-breaking</span>
            </#if>
          </#if>
        </div>
      </div>
      </#list>
    </div>
  </details>
  </#list>

</div>
</body>
</html>