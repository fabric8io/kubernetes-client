<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style type="text/css">
      body {
        font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
        line-height: 1.66666667;
        font-size: 16px;
        color: #333;
        background-color: #fff;
        margin: 2em 1em;
      }
      h1 {
        font-size: 28px;
        font-weight: 400;
      }
      p {
        margin: 0 0 10px;
      }
      .alert.alert-info {
        background-color: #F0F0F0;
        margin-top: 30px;
        padding: 30px;
      }
      .alert p {
        padding-left: 35px;
      }
      ul {
        padding-left: 51px;
        position: relative;
      }
      li {
        font-size: 14px;
        margin-bottom: 1em;
      }
      p.info {
        position: relative;
        font-size: 20px;
      }
      p.info:before, p.info:after {
        content: "";
        left: 0;
        position: absolute;
        top: 0;
      }
      p.info:before {
        background: #0066CC;
        border-radius: 16px;
        color: #fff;
        content: "i";
        font: bold 16px/24px serif;
        height: 24px;
        left: 0px;
        text-align: center;
        top: 4px;
        width: 24px;
      }

      @media (min-width: 768px) {
        body {
          margin: 6em;
        }
      }
    </style>
  </head>
  <body>
    <div>
      <h1>Application is not available</h1>
      <p>The application is currently not serving requests at this endpoint. It may not have been started or is still starting.</p>

      <div class="alert alert-info">
        <p class="info">
          Possible reasons you are seeing this page:
        </p>
        <ul>
          <li>
            <strong>The host doesn't exist.</strong>
            Make sure the hostname was typed correctly and that a route matching this hostname exists.
          </li>
          <li>
            <strong>The host exists, but doesn't have a matching path.</strong>
            Check if the URL path was typed correctly and that the route was created using the desired path.
          </li>
          <li>
            <strong>Route and path matches, but all pods are down.</strong>
            Make sure that the resources exposed by this route (pods, services, deployment configs, etc) have at least one pod running.
          </li>
        </ul>
      </div>
    </div>
  </body>
</html>
