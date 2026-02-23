<#ftl output_format="HTML">
<#--

    Copyright (C) 2015 Red Hat, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

            http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

-->
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Revapi Report: ${moduleName}</title>
  <style>
    * { box-sizing: border-box; margin: 0; padding: 0; }
    body {
      font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
      font-size: 14px;
      line-height: 1.5;
      background: #f5f5f5;
      color: #333;
    }
    .container { max-width: 1600px; margin: 0 auto; padding: 20px; }
    .header {
      background: white;
      padding: 20px 30px;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      margin-bottom: 20px;
    }
    .header h1 { font-size: 1.4em; color: #222; margin-bottom: 6px; }
    .module-path { font-family: monospace; font-size: 0.85em; color: #666; margin-bottom: 10px; }
    .back-link {
      display: inline-block;
      padding: 6px 14px;
      background: #4CAF50;
      color: white;
      text-decoration: none;
      border-radius: 4px;
      font-size: 0.85em;
      margin-bottom: 12px;
    }
    .back-link:hover { background: #45a049; }
    .version-info { color: #555; font-size: 0.9em; margin-top: 8px; }
    .version-info code { background: #e3f2fd; color: #1565c0; padding: 1px 5px; border-radius: 3px; }
    .summary {
      background: white;
      padding: 20px 30px;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      margin-bottom: 20px;
    }
    .summary h2 { font-size: 1.1em; color: #555; margin-bottom: 14px; }
    .summary-stats { display: flex; gap: 16px; flex-wrap: wrap; }
    .stat-box { padding: 14px 20px; border-radius: 6px; text-align: center; min-width: 120px; }
    .stat-box.total       { background: #e3f2fd; border: 1px solid #90caf9; }
    .stat-box.breaking    { background: #fdecea; border: 1px solid #f5c6c2; }
    .stat-box.potentially { background: #fff4e5; border: 1px solid #ffd59e; }
    .stat-box.non-breaking { background: #e8f5e9; border: 1px solid #a5d6a7; }
    .stat-value { font-size: 2em; font-weight: bold; line-height: 1; }
    .stat-box.total .stat-value        { color: #1565c0; }
    .stat-box.breaking .stat-value     { color: #c62828; }
    .stat-box.potentially .stat-value  { color: #e65100; }
    .stat-box.non-breaking .stat-value { color: #2e7d32; }
    .stat-label { font-size: 0.8em; color: #666; margin-top: 4px; }
    .severity-section {
      background: white;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
      margin-bottom: 20px;
      overflow: hidden;
    }
    .severity-section summary {
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
    .severity-section summary::-webkit-details-marker { display: none; }
    .severity-section summary::after { content: "▲"; font-size: 0.7em; margin-left: auto; opacity: 0.5; }
    .severity-section:not([open]) summary::after { content: "▼"; }
    .severity-section:not([open]) summary { border-bottom: none; }
    .severity-breaking summary           { background: #fdecea; color: #c62828; }
    .severity-potentially-breaking summary { background: #fff4e5; color: #e65100; }
    .severity-non-breaking summary       { background: #e8f5e9; color: #2e7d32; }
    .severity-equivalent summary         { background: #f5f5f5; color: #555; }
    .count { font-weight: normal; font-size: 0.9em; opacity: 0.8; }
    .table-wrapper { overflow-x: auto; }
    table { width: 100%; border-collapse: collapse; font-size: 0.88em; }
    th {
      background: #fafafa;
      text-align: left;
      padding: 9px 14px;
      font-weight: 600;
      border-bottom: 2px solid #e0e0e0;
      white-space: nowrap;
    }
    td { padding: 8px 14px; border-bottom: 1px solid #f0f0f0; vertical-align: top; }
    tr:last-child td { border-bottom: none; }
    tr:hover td { background: #fafafa; }
    .code-cell code {
      background: #f0f4ff;
      color: #3949ab;
      padding: 2px 6px;
      border-radius: 3px;
      font-size: 0.85em;
      white-space: nowrap;
    }
    .element-cell { max-width: 320px; }
    .element-cell code {
      font-size: 0.82em;
      color: #444;
      background: #f5f5f5;
      padding: 2px 4px;
      border-radius: 2px;
      display: block;
      word-break: break-all;
    }
    .no-changes {
      background: white;
      padding: 40px;
      text-align: center;
      color: #888;
      border-radius: 8px;
      box-shadow: 0 2px 8px rgba(0,0,0,0.08);
    }
  </style>
</head>
<body>
<div class="container">

  <div class="header">
    <a href="${backLink}" class="back-link">&larr; Back to Index</a>
    <h1>${moduleName}</h1>
    <div class="module-path">${modulePath}</div>
    <#if oldArchive?has_content>
    <p class="version-info">Artifact: <code>${oldArchive}</code> &rarr; <code>${newArchive}</code></p>
    </#if>
  </div>

  <div class="summary">
    <h2>Summary</h2>
    <div class="summary-stats">
      <div class="stat-box total">
        <div class="stat-value">${stats.total}</div>
        <div class="stat-label">Total Changes</div>
      </div>
      <div class="stat-box breaking">
        <div class="stat-value">${stats.breaking}</div>
        <div class="stat-label">Breaking</div>
      </div>
      <div class="stat-box potentially">
        <div class="stat-value">${stats.potentiallyBreaking}</div>
        <div class="stat-label">Potentially Breaking</div>
      </div>
      <div class="stat-box non-breaking">
        <div class="stat-value">${stats.nonBreaking}</div>
        <div class="stat-label">Non-Breaking</div>
      </div>
    </div>
  </div>

  <#if changes?has_content>
    <#list severityOrder as severity>
      <#assign group = changesBySeverity[severity]![]>
      <#if group?has_content>
      <details class="severity-section severity-${severity?lower_case?replace("_", "-")}" open>
        <summary>${severityLabels[severity]} <span class="count">(${group?size})</span></summary>
        <div class="table-wrapper">
          <table>
            <thead>
              <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Old Element</th>
                <th>New Element</th>
                <th>Description</th>
                <th>Compatibility</th>
              </tr>
            </thead>
            <tbody>
              <#list group as change>
              <tr>
                <td class="code-cell"><code>${change.code}</code></td>
                <td>${change.name}</td>
                <td class="element-cell"><code>${change.old}</code></td>
                <td class="element-cell"><code>${change.newElement}</code></td>
                <td>${change.description}</td>
                <td>${change.compatibility}</td>
              </tr>
              </#list>
            </tbody>
          </table>
        </div>
      </details>
      </#if>
    </#list>
  <#else>
  <div class="no-changes">No API changes detected for this module.</div>
  </#if>

</div>
</body>
</html>
