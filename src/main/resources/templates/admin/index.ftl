<#assign base=request.contextPath />
<!DOCTYPE html>
<html>
  <head>
   <#include "./common.ftl">
   <link href="${base}/static/admin/css/dashboard.css" rel="stylesheet">
       <title>${APP.name}-欢迎您</title>
   <script>
    	function changeFrameHeight(){
		    var ifm= document.getElementById("mainFrame"); 
		    ifm.height=document.documentElement.clientHeight;
		}
		window.onresize=function(){  
		     changeFrameHeight();  
		} 
    </script>
  </head>
  <body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">展开</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">${APP.name}</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">测试员 <span class="glyphicon glyphicon-user"/> <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">个人信息</a></li>
	            <li><a href="#">修改密码</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="${base}/admin/logout">退出登录 <span class="glyphicon glyphicon-off"/></a></li>
	          </ul>
	        </li>
            <li><a href="#">帮助 <span class="glyphicon glyphicon-question-sign"/></a></li>
          </ul>
          <form class="navbar-form navbar-right">
			    <div class="input-group">
			      <input type="text" class="form-control" placeholder="搜索...">
			      <span class="input-group-btn">
			        <button class="btn btn-primary" type="button">搜索!</button>
			      </span>
			    </div><!-- /input-group -->
          </form>
        </div>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#">主页 </a></li>
            <li><a href="#">用户管理</a></li>
            <li><a href="#">角色管理</a></li>
            <li><a href="#">权限管理</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <iframe id="mainFrame" onload="changeFrameHeight()" style="width:100%;border-width:0px;" scrolling="no" frameborder="0" src="${base}/admin/welcome"/>
        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../${base}static/assets/js/vendor/jquery.min.js"></script>
    <script src="../${base}static/bootstrap/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../${base}static/assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../${base}static/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
