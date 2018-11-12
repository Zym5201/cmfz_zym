<%@page pageEncoding="UTF-8" contentType="text/html; utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/form.validator.rules.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/easyui/themes/IconExtension.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.edatagrid.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/datagrid-cellediting.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/easyui/common.js"></script>


    <script>
        $(function(){
            $.post("${pageContext.request.contextPath}/adm/queryAllMenu",function(data){
                $.each(data,function(idx,menu){
                    /*创建二级菜单*/
                    var content="<div style=\"text-align:center;\">";
                    $.each(menu.menus,function(idx,child){
                        content+="<a class='easyui-linkbutton' onclick=\"addTabs('"+child.name+"','"+child.iconCls+"','"+child.url+"')\" data-options=\"iconCls:'"+child.iconCls+"',plain:true,\" style=\"width:96%;margin:5px 0px;border: 2px solid #b7d2ff\">"+child.name+"</a><br/>";
                    })
                    content+="</div>";
                    /*创建一级菜单*/
                    $("#menu").accordion('add',{
                        title:menu.name,
                        iconCls:menu.iconCls,
                        content:content,
                    })
                });
            });
        })
        /*菜单追加选项卡*/
        function addTabs(title,iconCls,href){
            var exists = $("#tabs").tabs('exists',title);
            if(!exists){
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    closable:true,
                    fit:true,
                    href:'${pageContext.request.contextPath}/'+href,
                });
            }else{
                $("#tabs").tabs('select',title);
            }
        }


        function updatepwd(){
            $("#updatePassword").dialog({
                title:'修改密码',
                width:400,
                height:300,
                href:'${pageContext.request.contextPath}/back/main/updatePassword.jsp',
                buttons:[
                    {
                        text:'保存',
                        iconCls:'icon-save',
                        handler:function(){
                            $("#updatePwd").form('submit',{
                                novalidate:true,
                                url:'${pageContext.request.contextPath}/admin/updatePassword',
                                success:function(result){
                                    var resultObj = $.parseJSON(result);
                                    if(resultObj.success){
                                        location.href="${pageContext.request.contextPath}/back/admin/login.jsp";
                                    }else{
                                        $.messager.show({title:'提示',iconCls:'icon-bell',msg:resultObj.message});
                                    }
                                }
                            });
                            $("#updatePassword").dialog('close');
                        }
                    },{
                        text:'关闭',
                        iconCls:'icon-cancel',
                        handler:function(){
                            $("#updatePassword").dialog('close');
                        }
                    }
                ],
            });
        }
    </script>
</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:${sessionScope.login_admin.name}&nbsp;<a href="#"onclick="updatepwd()"class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/admin/outlogin" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a></div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 htf@zparkhr.com.cn</div>
    </div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px; font-size: 12px;">
    	<div id="menu" class="easyui-accordion" data-options="fit:true">
		</div>
    </div>   
    <div data-options="region:'center'">
    	<div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>
    <%--修改密码对话框--%>
    <div id="updatePassword"></div>
</body> 
</html>