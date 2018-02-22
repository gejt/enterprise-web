<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
  <head>
    <link href="${base}/static/admin/css/signin.css" rel="stylesheet">
    <#include "./common.ftl">
    <title>请登录</title>
  </head>

  <body>

    <div class="container">
      <form class="form-signin" action="${base}/admin/loginSubmit" method="post">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputEmail" class="sr-only">用户名</label>
        <input type="text" id="userName" class="form-control" placeholder="用户名" name="userName" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="密码" name="password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 下次自动登录
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>

    </div> <!-- /container -->

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="${base}/static/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
