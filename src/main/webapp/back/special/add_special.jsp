<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set scope="request" var="base_path" value="${pageContext.request.contextPath}"/>

<div style="text-align:center;margin-top:30px;">
    <form id="addSpecialForm" method="post" enctype="multipart/form-data">
        <div style="margin-top:10px;">
            专辑图片:<input class="easyui-filebox" id="file" name="file" data-options="buttonText:'选择'"/><br/>
        </div>
        <div style="margin-top:10px;">
            专辑名称:<input id="name" name="name" type="text" class="easyui-textbox"/><br/>
        </div>
        <div style="margin-top:10px;">
            作　　者:<input id="author" name="author" type="text" class="easyui-textbox"/><br/>
        </div>
        <div style="margin-top:10px;">
            播　　音:<input id="broadcast" name="broadcast" type="text" class="easyui-textbox"/><br/>
        </div>
        <div style="margin-top:10px;">
            集　　数:<input id="collect_number" name="collect_number" type="text" class="easyui-textbox"/><br/>
        <div style="margin-top:10px;">
            发布日期:<input id="issue_date" name="issue_date" type="text" class="easyui-datebox"/><br/>
        </div>
        <div style="margin-top:10px;margin-button:20px;">
            <textarea type="text" style="width:190px;height:80px;border:1px solid #fff3f3;" name="content_synopsis"></textarea><br/>
         </div>
    </form>
</div>